package jmc.feol.core.service.impl;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import jmc.feol.core.dao.CotDAO;
import jmc.feol.core.dao.GenericDAO;
import jmc.feol.core.model.Cot;
import jmc.feol.core.model.Empresa;
import jmc.feol.core.model.Parametrizacion;
import jmc.feol.core.model.RespuestaAfip;
import jmc.feol.core.model.RespuestaAfipRemito;
import jmc.feol.core.model.cot.ParamConnRentas;
import jmc.feol.core.service.CotManager;
import jmc.feol.core.service.ServicesInitManager;
import jmc.feol.ui.struts.actions.ServicesAction;
import jmc.feol.util.Constants;
import jmc.feol.util.DateUtil;
import jmc.feol.util.FileUtil;
import FEV1.dif.afip.gov.ar.FECAERequest;
import FEV1.dif.afip.gov.ar.FECAEResponse;

public class ServicesInitManagerImpl implements ServicesInitManager {
	
	private static final Log log = LogFactory.getLog(ServicesAction.class);	

	private GenericDAO<Parametrizacion> parametrizacionDAO;
	private GenericDAO<Empresa> empresaDAO;
	private CotDAO extendedCotDAO;

	public GenericDAO<Empresa> getEmpresaDAO() {
		return empresaDAO;
	}

	public void setEmpresaDAO(GenericDAO<Empresa> empresaDAO) {
		this.empresaDAO = empresaDAO;
	}

	public CotDAO getExtendedCotDAO() {
		return extendedCotDAO;
	}

	public void setExtendedCotDAO(CotDAO extendedCotDAO) {
		this.extendedCotDAO = extendedCotDAO;
	}

	public GenericDAO<Parametrizacion> getParametrizacionDAO() {
		return parametrizacionDAO;
	}

	public void setParametrizacionDAO(
			GenericDAO<Parametrizacion> parametrizacionDAO) {
		this.parametrizacionDAO = parametrizacionDAO;
	}

	public void getCot() {
		System.out.println(parametrizacionDAO.getByPrimaryKey(10l).getValor());

	}

	private ParamConnRentas buildParamConnRentas() {
		ParamConnRentas paramConnRentas = new ParamConnRentas();
		// paramConnRentas.setFolderEntrada((parametrizacionDAO.getByPrimaryKey(Constants.ID_CARPETA_ENTRADA)).getValor());
		paramConnRentas.setHost((parametrizacionDAO
				.getByPrimaryKey(Constants.ID_HOST)).getValor());
		paramConnRentas.setProxyPort(Integer.parseInt((parametrizacionDAO
				.getByPrimaryKey(Constants.ID_PROXY_PORT)).getValor()));
		paramConnRentas.setProxyUrl((parametrizacionDAO
				.getByPrimaryKey(Constants.ID_PROXY_URL)).getValor());
		paramConnRentas.setUrlApp((parametrizacionDAO
				.getByPrimaryKey(Constants.ID_URL_APP)).getValor());
		paramConnRentas.setUrlPort(Integer.parseInt((parametrizacionDAO
				.getByPrimaryKey(Constants.ID_URL_PORT)).getValor()));
		paramConnRentas.setUseProxy((parametrizacionDAO
				.getByPrimaryKey(Constants.ID_USE_PROXY)).getValor());
		paramConnRentas.setKeystoreJREPassword((parametrizacionDAO
				.getByPrimaryKey(Constants.ID_KEYSTORE_PASS)).getValor());
		return paramConnRentas;
	}

	public void procesarByFilesCot() {
		
		String msg = "";
		try {

			Empresa em = empresaDAO.getByPrimaryKey(1l);

			FECAEResponse feRes = new FECAEResponse();
			FECAERequest feReq = new FECAERequest();

			File dir = new File(em.getRuta_provisorio_cot());

			File[] filesTotal = dir.listFiles();

			
			
			List<File> only100Files = new ArrayList<File>();
			int iupdate = 0;
			for(File realFiles:  filesTotal){
				if (iupdate < 10){
					only100Files.add(realFiles);
				}else{
					break;
				}
			}
			List<File> listFileAnalisis = new ArrayList<File>();
			
			int countFiles = only100Files.size();
			int i = 0;
			
			while (i < countFiles) {
				
				if (only100Files.get(i).isFile()) {
					if (only100Files.get(i).canWrite()) {
						try {
							if (only100Files.get(i).getName().startsWith("B")) {
								// Borro cualquier archivo con el mismo nombre
								// en el destino
								File borrado = new File(
										em.getRuta_definitivo_cot()
												+ only100Files.get(i).getName());
								borrado.delete();
								// muevo el archivo
								File fileDestino = new File(
										em.getRuta_definitivo_cot()
												+ only100Files.get(i).getName());
								FileUtil.copy(only100Files.get(i), fileDestino);
								listFileAnalisis.add(fileDestino);
								
								only100Files.get(i).delete();
								i++;
								
							} else {
								i++;
							}
						
						}catch(Exception e){
							e.printStackTrace();
							i++;
						}
					}
				}else{
					i++;
				}
				
			}
			
			for(File fileDestino : listFileAnalisis){								
							String planta = "000";
							try{
								planta = fileDestino.getName()
										.substring(1, 4);
							}catch(Exception e){}
							String secuencia = "000000";
							try{
								secuencia = fileDestino.getName()
										.substring(4, 10);
							}catch(Exception e){}
								
								String nombreArchivo = "TB_"
										+ em.getCuit()
										+ "_"
										+ planta
										+ "001"
										+ "_"
										+ DateUtil.getCanonicalFech(new Date(
												System.currentTimeMillis()))
										+ "_" + secuencia + ".txt";
								File fileDestinoEntrada = new File(
										em.getRuta_entrada_cot()
												+ nombreArchivo);
								FileUtil.copy(fileDestino, fileDestinoEntrada);
								CotManager cotManager = new CotManagerImpl(
										buildParamConnRentas(),
										em.getPass_cot(), fileDestinoEntrada,
										em.getUser_cot());
								List<String> listS = new ArrayList<String>();
								try {
									
									listS = cotManager.getCot();
									log.info("Invoco al server de Arba, archivo: " + fileDestino.getName());
								} catch (Exception e) {
									try {
										e.printStackTrace();
										// Crear archivo de Error generico
										List<String> resultList = new ArrayList<String>();
										resultList
												.add("<?xml version=\"1.0\" encoding=\"ISO-8859-1\" ?>");
										resultList.add("<TBError>");
										resultList
												.add("<tipoError>NETWORK OR FISLESYSTEM ERROR</tipoError>");
										resultList
												.add("<codigoError>001</codigoError>");
										resultList
												.add("<mensajeError>Error al intentar Conectarse con el server o al mover archivos en el FileSystem</mensajeError>");
										resultList.add("</TBError>");
										String nombreArchivoSalida = "CR"
												+ planta + secuencia + ".xml";
										FileUtil.generateFile(
												em.getRuta_salida_cot(),
												nombreArchivoSalida, resultList);
										Cot cot = new Cot();
										cot.setFecha_creacion(new Timestamp(
												System.currentTimeMillis()));
										cot.setNombreArchivo(nombreArchivoSalida);
										cot.setNombreArchivoEntrada(fileDestino
												.getName());
										cot.setPlanta(planta);
										cot.setSecuencia(secuencia);
										cot.setRespuesta("Error al intentar Conectarse con el server o al mover archivos en el FileSystem");
										extendedCotDAO.save(cot);
									} catch (Exception e_catch) {
										e_catch.printStackTrace();
									}
								}
								List<String> listresult = new ArrayList<String>();
								String result = "";
								try {
									String xml = "";
									boolean empezo = false;
									for (String s : listS) {

										if (s.startsWith("<?xml version='1.0'"))
											empezo = true;
										if (empezo) {
											listresult.add(s);
											xml = xml + s;
										}
										if (s.indexOf("<mensajeError>") != -1) {
											result = s.replaceAll("<mensajeError>", "");
										}

									}
									JAXBContext jaxbContext;
									try {
										jaxbContext = JAXBContext
												.newInstance(RespuestaAfip.class);

										Unmarshaller jaxbUnmarshaller = jaxbContext
												.createUnmarshaller();
										// Pregunto si tiene un error y si fue
										// procesado con Anterioridad
										if (xml.indexOf("<TBError>") != -1) {
											String nombreArchivoSalida = "BR"
													+ planta + secuencia
													+ ".xml";
											try{
											
											}catch(Exception e){}
											FileUtil.generateFile(
													em.getRuta_salida_cot(),
													nombreArchivoSalida,
													listresult);
											Cot cot = new Cot();
											cot.setFecha_creacion(new Timestamp(
													System.currentTimeMillis()));
											cot.setNombreArchivo(nombreArchivoSalida);
											cot.setNombreArchivoEntrada(fileDestino
													.getName());
											cot.setPlanta(planta);
											cot.setSecuencia(secuencia);
											cot.setRespuesta(result);
											extendedCotDAO.save(cot);
										} else {
											RespuestaAfip ra = (RespuestaAfip) jaxbUnmarshaller
													.unmarshal(new ByteArrayInputStream(
															xml.getBytes("UTF-8")));
											// SerializateUtil.generateRemitoPdf(ra,
											// nombreArchivoPdf );
											Boolean procesadoOk = false;
											try {
												for (RespuestaAfipRemito rr : ra
														.getValidacionesRemitos()
														.getRemito()) {													
													if (rr.getProcesado()
															.equals("NO")) {
														procesadoOk = false;
													} else if (rr
															.getProcesado()
															.equals("SI")) {
														procesadoOk = true;
													}
													
												}
											} catch (Exception e) {
												procesadoOk = false;
											}
											String nombreArchivoSalida = "";
											if (procesadoOk) {
												nombreArchivoSalida = "AR"
														+ planta + secuencia
														+ ".xml";
											} else {
												nombreArchivoSalida = "BR"
														+ planta + secuencia
														+ ".xml";
											}
											FileUtil.generateFile(
													em.getRuta_salida_cot(),
													nombreArchivoSalida,
													listresult);
											Cot cot = new Cot();
											cot.setFecha_creacion(new Timestamp(
													System.currentTimeMillis()));
											cot.setNombreArchivo(nombreArchivoSalida);
											cot.setNombreArchivoEntrada(fileDestino
													.getName());
											cot.setPlanta(planta);
											cot.setSecuencia(secuencia);
											cot.setRespuesta(xml);
											extendedCotDAO.save(cot);

										}
									} catch (JAXBException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}

								} catch (Exception e) {

									e.printStackTrace();
								}
							}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
