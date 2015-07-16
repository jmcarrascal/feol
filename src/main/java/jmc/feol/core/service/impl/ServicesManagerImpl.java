package jmc.feol.core.service.impl;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import jmc.feol.core.dao.GenericDAO;
import jmc.feol.core.dao.PatenteDAO;
import jmc.feol.core.dao.impl.BaseExterna;
import jmc.feol.core.dao.impl.BaseExternaAS;
import jmc.feol.core.dao.impl.BaseExternaCot;
import jmc.feol.core.dao.impl.BaseExternaE;
import jmc.feol.core.dao.impl.BaseExternaMTX;
import jmc.feol.core.dao.impl.BaseExternaTeso;
import jmc.feol.core.model.Caea;
import jmc.feol.core.model.Empresa;
import jmc.feol.core.model.EmpresaC;
import jmc.feol.core.model.EquipoImagen;
import jmc.feol.core.model.Factura;
import jmc.feol.core.model.Parametrizacion;
import jmc.feol.core.model.Patente;
import jmc.feol.core.model.RespuestaAfip;
import jmc.feol.core.model.Usuario;
import jmc.feol.core.model.cot.ParamConnRentas;
import jmc.feol.core.model.cot.Viajes;
import jmc.feol.core.service.CotManager;
import jmc.feol.core.service.EmpresaManager;
import jmc.feol.core.service.FacturaManager;
import jmc.feol.core.service.ServicesManager;
import jmc.feol.util.Constants;
import jmc.feol.util.DateUtil;
import jmc.feol.util.FileUtil;
import jmc.feol.util.FormatUtil;
import jmc.feol.util.ParseFactura;
import jmc.feol.util.ParseFacturaCaea;
import jmc.feol.util.ParseFacturaExpo;
import jmc.feol.util.SerializateUtil;
import jmc.feol.util.TestUtil;
import jmc.feol.util.email.Email;
import jmc.feol.util.email.SendEmailThread;
import jmc.feol.util.exception.GenerationTimerException;
import FEV1.dif.afip.gov.ar.Cotizacion;
import FEV1.dif.afip.gov.ar.Err;
import FEV1.dif.afip.gov.ar.FECAEADetResponse;
import FEV1.dif.afip.gov.ar.FECAEAGetResponse;
import FEV1.dif.afip.gov.ar.FECAEARequest;
import FEV1.dif.afip.gov.ar.FECAEAResponse;
import FEV1.dif.afip.gov.ar.FECAEDetResponse;
import FEV1.dif.afip.gov.ar.FECAERequest;
import FEV1.dif.afip.gov.ar.FECAEResponse;
import FEV1.dif.afip.gov.ar.FECompConsultaResponse;
import FEV1.dif.afip.gov.ar.FECotizacionResponse;
import FEV1.dif.afip.gov.ar.Obs;
import FEV1.dif.afip.gov.ar.wmtx.AutorizarComprobanteResponseType;
import FEV1.dif.afip.gov.ar.wmtx.CodigoDescripcionType;
import FEV1.dif.afip.gov.ar.wmtx.ComprobanteType;
import fex.dif.afip.gov.ar.ClsFEXRequestDesa;
import fex.dif.afip.gov.ar.FEXResponseAuthorizeDesa;
import fexv1.dif.afip.gov.ar.ClsFEXRequest;
import fexv1.dif.afip.gov.ar.ClsFEXResponse_Ctz;
import fexv1.dif.afip.gov.ar.FEXResponseAuthorize;
import fexv1.dif.afip.gov.ar.FEXResponse_Ctz;

public class ServicesManagerImpl implements ServicesManager {

	private GenericDAO<Parametrizacion> parametrizacionDAO;
	private GenericDAO<EmpresaC> empresaCDAO;
	private FacturaManager facturaManager;
	private EmpresaManager empresaManager;
	private String rutaBaseOrig;
	private String rutaComunOrig;
	private String rutaArticuloOrig;	
	private GenericDAO<EquipoImagen> equipoImagenDAO;
	private GenericDAO<Usuario> usuarioDAO;
	private PatenteDAO extendedPatenteDAO;
	private GenericDAO<Caea> caeaDAO;
	
	
	
	
	public GenericDAO<Caea> getCaeaDAO() {
		return caeaDAO;
	}

	public void setCaeaDAO(GenericDAO<Caea> caeaDAO) {
		this.caeaDAO = caeaDAO;
	}

	public PatenteDAO getExtendedPatenteDAO() {
		return extendedPatenteDAO;
	}

	public void setExtendedPatenteDAO(PatenteDAO extendedPatenteDAO) {
		this.extendedPatenteDAO = extendedPatenteDAO;
	}

	public GenericDAO<EmpresaC> getEmpresaCDAO() {
		return empresaCDAO;
	}

	public void setEmpresaCDAO(GenericDAO<EmpresaC> empresaCDAO) {
		this.empresaCDAO = empresaCDAO;
	}

	public GenericDAO<Usuario> getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(GenericDAO<Usuario> usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	public GenericDAO<EquipoImagen> getEquipoImagenDAO() {
		return equipoImagenDAO;
	}

	public void setEquipoImagenDAO(GenericDAO<EquipoImagen> equipoImagenDAO) {
		this.equipoImagenDAO = equipoImagenDAO;
	}

	public String getRutaBaseOrig() {
		return rutaBaseOrig;
	}

	public void setRutaBaseOrig(String rutaBaseOrig) {
		this.rutaBaseOrig = rutaBaseOrig;
	}

	public String getRutaComunOrig() {
		return rutaComunOrig;
	}

	public void setRutaComunOrig(String rutaComunOrig) {
		this.rutaComunOrig = rutaComunOrig;
	}

	public String getRutaArticuloOrig() {
		return rutaArticuloOrig;
	}

	public void setRutaArticuloOrig(String rutaArticuloOrig) {
		this.rutaArticuloOrig = rutaArticuloOrig;
	}

	public EmpresaManager getEmpresaManager() {
		return empresaManager;
	}

	public void setEmpresaManager(EmpresaManager empresaManager) {
		this.empresaManager = empresaManager;
	}

	public FacturaManager getFacturaManager() {
		return facturaManager;
	}

	public void setFacturaManager(FacturaManager facturaManager) {
		this.facturaManager = facturaManager;
	}

	public GenericDAO<Parametrizacion> getParametrizacionDAO() {
		return parametrizacionDAO;
	}

	public void setParametrizacionDAO(GenericDAO<Parametrizacion> parametrizacionDAO) {
		this.parametrizacionDAO = parametrizacionDAO;
	}
	
	
	public String autorizoFactura(Long transacNr, String rutaBase, String rutaComun, String rutaArticulo){
		this.rutaBaseOrig = rutaBase;
		this.rutaComunOrig = rutaComun;
		this.rutaArticuloOrig = rutaArticulo;
		
		String result = "Error al leer la base de datos " + rutaBase;
		Empresa empresa = empresaManager.getByPrimaryKey(1l);
		if (!empresa.getCuit().trim().equals("30708661321") && !empresa.getCuit().trim().equals("30710339828") && !empresa.getCuit().trim().equals("30502795844") 
				&& !empresa.getCuit().trim().equals("30708417668") && !empresa.getCuit().trim().equals("33708983409") && !empresa.getCuit().trim().equals("33613036879")  	
				&& !empresa.getCuit().trim().equals("33709732949") && !empresa.getCuit().trim().equals("30612476000") && !empresa.getCuit().trim().equals("30686204797") 
				&& !empresa.getCuit().trim().equals("30707601392") && !empresa.getCuit().trim().equals("30700442361") && !empresa.getCuit().trim().equals("30708182849")
				&& !empresa.getCuit().trim().equals("30636228385") && !empresa.getCuit().trim().equals("33710828259") && !empresa.getCuit().trim().equals("30709071943")
				&& !empresa.getCuit().trim().equals("30528127610") && !empresa.getCuit().trim().equals("30663753025") && !empresa.getCuit().trim().equals("30628323603")
				&& !empresa.getCuit().trim().equals("30680810946") && !empresa.getCuit().trim().equals("30686262312") && !empresa.getCuit().trim().equals("30609484124")
				&& !empresa.getCuit().trim().equals("30586412732") && !empresa.getCuit().trim().equals("30686869098") && !empresa.getCuit().trim().equals("30710954786")
				&& !empresa.getCuit().trim().equals("30708351586") && !empresa.getCuit().trim().equals("30694541581") && !empresa.getCuit().trim().equals("30708142286")
				&& !empresa.getCuit().trim().equals("30710925735") && !empresa.getCuit().trim().equals("30707416528") && !empresa.getCuit().trim().equals("30710836597")
				&& !empresa.getCuit().trim().equals("30713480009") && !empresa.getCuit().trim().equals("30713479108") && !empresa.getCuit().trim().equals("30712671706")
				&& !empresa.getCuit().trim().equals("30714238589") && !empresa.getCuit().trim().equals("30655105596") && !empresa.getCuit().trim().equals("30630516389")
				&& !empresa.getCuit().trim().equals("30709171034") && !empresa.getCuit().trim().equals("30711712824") && !empresa.getCuit().trim().equals("30710104375") 
				&& !empresa.getCuit().trim().equals("30520946531") && !empresa.getCuit().trim().equals("30641408383") && !empresa.getCuit().trim().equals("20139245351")
				&& !empresa.getCuit().trim().equals("30710542321") && !empresa.getCuit().trim().equals("33600481059") && !empresa.getCuit().trim().equals("30712014950")
				&& !empresa.getCuit().trim().equals("30710486588") && !empresa.getCuit().trim().equals("30712258396") && !empresa.getCuit().trim().equals("30711245673")
				&& !empresa.getCuit().trim().equals("30710471637") && !empresa.getCuit().trim().equals("30712521151") && !empresa.getCuit().trim().equals("30711534616")
				&& !empresa.getCuit().trim().equals("30626244536") && !empresa.getCuit().trim().equals("30611628532") && !empresa.getCuit().trim().equals("30714366005")
				&& !empresa.getCuit().trim().equals("20162192974")
				
				
				)

		{
			result = "El CUIT enviado no est� licenciado";
		}else{

			try{

				String baseComun="";
				String baseArticulo="";
				
				BaseExterna be = null;
				//Clasifico la Factura
				int ubicador = rutaBase.indexOf("|");  
				if (ubicador == -1){
					//rutaBase = "[" + rutaBase+ "]";
					String rutaComunA = "[" + rutaComunOrig+ "]";
					String rutaArticuloA = "[" + rutaArticuloOrig+ "]";
					be = new BaseExterna("sun.jdbc.odbc.JdbcOdbcDriver","jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=@rutaBase", rutaComunA, rutaArticuloA);
				}else{					
					String servidor = rutaBase.substring(0, ubicador);
					String base = rutaBase.substring(ubicador +1);
					//rutaBase = "[" + rutaBaseOrig + "]" + ".dbo";
					baseComun = "[" + rutaComunOrig.substring(ubicador +1) + "]" + ".dbo";
					baseArticulo = "[" + rutaArticuloOrig.substring(ubicador +1) + "]" + ".dbo";
					String user = parametrizacionDAO.getByPrimaryKey(Constants.ID_USR_SQL).getValor();
					String password = parametrizacionDAO.getByPrimaryKey(Constants.ID_PASSWORD_SQL).getValor();
					be = new BaseExterna("net.sourceforge.jtds.jdbc.Driver","jdbc:jtds:sqlserver://"+servidor+":1433/"+base, baseComun, baseArticulo, user, password);					
				}
								
				String tipoFactura = be.getTipoFactura(transacNr, rutaBase);
				
				if (tipoFactura == "AB"){
					String facturaMTX = "";
					try{
						facturaMTX = parametrizacionDAO.getByPrimaryKey(Constants.ID_FACTURA_MTX).getValor();
					}catch(Exception e){
						//e.printStackTrace();
					}						
					if (!facturaMTX.equals("true")){
						result = gestionoFacturaAB(transacNr, rutaBase,rutaComun, rutaArticulo,be);
					}else{
						result = gestionoFacturaMTX(transacNr, rutaBase, rutaComun, rutaArticulo);
					}
						
				}
				if (tipoFactura == "NA"){
					result = "El documento enviado no se corresponde a una factura A, B o E";
				}
				if (tipoFactura == "E"){
						result = gestionoFacturaE(transacNr, rutaBase,rutaComun, rutaArticulo);
				}
			}catch(Exception e){
				e.printStackTrace();
				result  = e.getMessage();
			}
			
		}
		return result;
	}
	
	private String gestionoFacturaAB(Long transacNr, String rutaBase, String rutaComun, String rutaArticulo, BaseExterna be){
		String msg = "";
		try{
			FECAEResponse feRes = new FECAEResponse(); 
			FECAERequest feReq = new FECAERequest();
			try{
				feReq = be.getFacturaExt(transacNr, rutaBase);
	
			}catch(Exception e){
				e.printStackTrace();
				msg =  e.getMessage();
			}
			//Controlo los errores de parseo
			if (msg.equals("") && feReq.getErrorFE().equals("")){
				
				Empresa empresa = empresaManager.getByPrimaryKey(1l);			
				//Obtengo la Factura de base local
				Factura factura = facturaManager.getFacturaByTransac(transacNr);
				
				boolean facturaProcesada = false;
				//Si no existe la factura en la base la creo
				if (factura == null){
					try{
						//Persisto la Factura
						facturaManager.saveFactura(generateFacturaAB(feReq, transacNr, rutaBaseOrig, rutaComunOrig, rutaArticuloOrig));
					}catch(Exception e){
						e.printStackTrace();
					}
				}else{					
					//Si tiene CAE armo el archivo de devoluci�n
					if (factura.getCae() != null && !factura.getCae().trim().equals("")){
						facturaProcesada = true;
						//msg = factura.getCae() + "|" + factura.getCae_vto() + "|" + factura.getCbt_desde() + "|" + "La factura ya se encuentra Procesada con la obtenci�n de CAE exitoso";						
						be.updateBase(transacNr, factura.getCae() ,factura.getCae_vto() , rutaBase, String.valueOf(FormatUtil.llenoConCeros(String.valueOf(factura.getCbt_desde()), 8)), factura.getImp_total(), feReq.isActualizoTotal());												
						msg = "OK";
						return msg;
					}else{
						//Le digo a la factura que esta siendo procesada
						if (factura.getReproceso() != null && factura.getReproceso().equals("P")){
							//Comparo que la fecha de creacion tenga 15 seg. de antiguedad
							Long diferenciaFechas = (new Timestamp(System.currentTimeMillis())).getTime() - factura.getFecha_creacion().getTime();
							if (diferenciaFechas < 15000l){
								msg = "Esta Factura esta siendo procesada, intente nuevamente en unos segundos";
								return msg;
								
							}
						}
					} 
				}	
				if(factura != null && factura.getReproceso() != null && factura.getReproceso().equals("P")){
					//Recuperar Factura de la Base Mysql
					Factura facturaRecuperada = facturaManager.getFacturaByTransac(transacNr);
					FECompConsultaResponse feResponse = null;
					try{						
					//Recuperar la factura desde la AFIP
						feResponse = facturaManager.getComprobanteByPrimary(facturaRecuperada.getCbt_desde(), facturaRecuperada.getTipo_cbte(), facturaRecuperada.getPunto_vta(), empresa);
					}catch(Exception e){
						msg ="Existi� un Error con la conexi�n a la AFIP, por favor intente nuevamente";
						return msg;						
					}
					try{
						//Comparar los valores de Imptotal, Tipo de Compro, Prefijo, Numero de Factura
						if (feResponse != null && feResponse.getResultGet() != null && feResponse.getResultGet().getImpTotal() == facturaRecuperada.getImp_total() && 
								feResponse.getResultGet().getCbteTipo() == facturaRecuperada.getTipo_cbte() &&
								feResponse.getResultGet().getCbteDesde() == facturaRecuperada.getCbt_desde()){
	
							be.updateBase(transacNr, feResponse.getResultGet().getCodAutorizacion() ,feResponse.getResultGet().getFchVto() , rutaBase, String.valueOf(FormatUtil.llenoConCeros(String.valueOf(feResponse.getResultGet().getCbteDesde()), 8)), feResponse.getResultGet().getImpTotal(), feReq.isActualizoTotal());						
							//msg = feDetalleResponseA[0].getCAE() + "|" + feDetalleResponseA[0].getCAEFchVto() + "|" + comprNr + "|" +resultado;
							msg = "OK";
							//Actualizo Base Local
							Factura facturaUpdate = facturaManager.getFacturaByTransac(transacNr);
							facturaUpdate.setCae(feResponse.getResultGet().getCodAutorizacion() );
							facturaUpdate.setCae_vto(feResponse.getResultGet().getFchVto() );
							try{
								facturaUpdate.setCbt_desde(Long.parseLong(String.valueOf(feResponse.getResultGet().getCbteDesde())));
								facturaUpdate.setCbt_hasta(Long.parseLong(String.valueOf(feResponse.getResultGet().getCbteDesde())));								
							}catch(NumberFormatException ne){
								
							}						
							facturaUpdate.setCodError("0");
							facturaUpdate.setReproceso(null);
							facturaManager.updateFactura(facturaUpdate);
							return msg;
	
							
						}else{
							//Si no coincide libero la factura seteando en NULL el valor reproceso
							Factura facturaALiberar = facturaManager.getFacturaByTransac(transacNr);
							facturaALiberar.setReproceso(null);
							facturaManager.updateFactura(facturaRecuperada);
							facturaProcesada = false;
							msg ="Existi� un Error con la conexi�n a la AFIP, por favor intente nuevamente";
							return msg;
						}
					}catch(Exception e){
						e.printStackTrace();
						//Si no coincide libero la factura seteando en NULL el valor reproceso
						Factura facturaALiberar = facturaManager.getFacturaByTransac(transacNr);
						facturaALiberar.setReproceso(null);
						facturaManager.updateFactura(facturaRecuperada);
						facturaProcesada = false;
						msg ="Existi� un Error con la conexi�n a la AFIP, por favor intente nuevamente";
						return msg;						
					}

					
					
				}else{
					
					if(!facturaProcesada){
						try {
							//Obtengo los datos que voy a pedir para la factura							
							Long nroComp = facturaManager.getLastNroFactura(feReq, empresa);
							//Persisto en la base el nroComp
							Factura facturaUpdateNroComp = facturaManager.getFacturaByTransac(transacNr);
							facturaUpdateNroComp.setCbt_desde(nroComp);
							facturaUpdateNroComp.setCbt_hasta(nroComp);
							facturaUpdateNroComp.setFecha_creacion(new Timestamp(System.currentTimeMillis()));
							facturaUpdateNroComp.setReproceso("P");
							facturaManager.updateFactura(facturaUpdateNroComp);
							
							//Pido facturacion AFIP
							feRes = facturaManager.facturacionAFIP(feReq, empresa, nroComp);							
							
							Factura facturaUpdate1 = facturaManager.getFacturaByTransac(transacNr);
							facturaUpdate1.setRequestEnviado(feRes.getRequestEnviado());	
							facturaManager.updateFactura(facturaUpdate1);
							
							//factura
							
							String resultado = "";
							
							Err[] errores = feRes.getErrors();
												
							if (errores == null) {
								if (feRes.getFeDetResp() != null
										|| feRes.getFeDetResp().length > 0) {
									Obs[] observaciones = feRes.getFeDetResp()[0]
											.getObservaciones();
									if (observaciones != null) {
										int i = 0;
										for (Obs obs : observaciones) {
											System.out.println(obs.getMsg());
											if (i == 0){
												resultado = obs.getMsg();	
											}else{
												resultado = resultado + "/" + obs.getMsg();
											}
											i++;
											
										}
									}
								}
							} else {
								int i = 0;
								for (Err err : errores) {							
									if (i == 0){
										resultado = err.getMsg();	
									}else{
										resultado = resultado + "/  " + err.getMsg();
									}
									i++;
									
								}
			
							}
							
							FECAEDetResponse[] feDetalleResponseA = feRes.getFeDetResp();
							
							try{
								System.out.println("CAE " + feDetalleResponseA[0].getCAE());
								
								System.out.println("Tipo de Comprobante " + feRes.getFeCabResp().getCbteTipo());
								
								System.out.println("Comprobante " + feDetalleResponseA[0].getCbteDesde());
								
								System.out.println("CAE Vencimiento " + feDetalleResponseA[0].getCAEFchVto());
				
								System.out.println("Prefijo " + feRes.getFeCabResp().getPtoVta());
								
							}catch(Exception e){
								//e.printStackTrace();
							}
			
							//Si no tengo un error en la obtencion
							if (feDetalleResponseA != null && feDetalleResponseA[0] != null){
								if (!feDetalleResponseA[0].getCAE().trim().equals("")){
									String comprNr = FormatUtil.llenoConCeros(String.valueOf(feDetalleResponseA[0].getCbteDesde()), 8);
									String cae = feDetalleResponseA[0].getCAE();
									if (cae == null || cae.trim().equals("")){
										cae = "11111111111111";
									}
//									try{
//										be.updateBase(transacNr, cae , feDetalleResponseA[0].getCAEFchVto(), rutaBase, comprNr, feReq.getFeDetReq()[0].getImpTotal());
//									}catch(Exception e){
//										e.printStackTrace();
//									}															
									//msg = feDetalleResponseA[0].getCAE() + "|" + feDetalleResponseA[0].getCAEFchVto() + "|" + comprNr + "|" +resultado;
									msg = "OK";
									//Actualizo Base Local
									Factura facturaUpdate = facturaManager.getFacturaByTransac(transacNr);
									facturaUpdate.setCae(feDetalleResponseA[0].getCAE() );
									facturaUpdate.setCae_vto(feDetalleResponseA[0].getCAEFchVto());
									try{
										facturaUpdate.setCbt_desde(Long.parseLong(comprNr));
										facturaUpdate.setCbt_hasta(Long.parseLong(comprNr));								
									}catch(NumberFormatException ne){}
									facturaUpdate.setResultado(resultado);
									facturaUpdate.setCodError("0");
									facturaManager.updateFactura(facturaUpdate);
									 
									try{
										be.updateBase(transacNr, cae , feDetalleResponseA[0].getCAEFchVto(), rutaBase, comprNr, feReq.getFeDetReq()[0].getImpTotal(), feReq.isActualizoTotal());
									}catch(Exception e){
										e.printStackTrace();
										msg="Error al guardar el registro en SKSoft, intente nuevamente";
										return msg;
									}																							
									
									return msg;
								}else{
									msg =  resultado;
									if (parametrizacionDAO.getByPrimaryKey(Constants.ID_ENVIA_MAIL).getValor().equals("true")){
										sendMail(resultado, transacNr);
									}
								}
							}else{
								msg = resultado;
							}		
						} catch (RemoteException e) {
							e.printStackTrace();
							msg =  "No se ha podido realizar la comunicaci�n con el servidor de AFIP, cuando el sistema tenga acceso enviar� la factura automaticamente";
							//Hay que cargar la factura el la cola para volver a cargarla
							try{
								Factura facturaUpdate = facturaManager.getFacturaByTransac(transacNr);	
								facturaUpdate.setCodError("10");
								facturaUpdate.setReproceso("P");
								facturaManager.updateFactura(facturaUpdate);
							}catch(Exception ne){
								ne.printStackTrace();
							}
							if (parametrizacionDAO.getByPrimaryKey(Constants.ID_ENVIA_MAIL).getValor().equals("true")){
								sendMail(msg, transacNr);
							}
							return msg;						
						}catch(GenerationTimerException ge){
							ge.printStackTrace();
							msg =  "La fecha/hora informada (" + new Timestamp(System.currentTimeMillis()) + ") no es la esperada por AFIP, actualice la fecha/hora del servidor";
							try{
								Factura facturaUpdate = facturaManager.getFacturaByTransac(transacNr);	
								facturaUpdate.setCodError("10");							
								facturaManager.updateFactura(facturaUpdate);
							}catch(Exception ne){
								ne.printStackTrace();
							}
							if (parametrizacionDAO.getByPrimaryKey(Constants.ID_ENVIA_MAIL).getValor().equals("true")){
								sendMail(msg, transacNr);
							}										
						}
					}
				}
			}else{
				msg = feReq.getErrorFE();
			}								
		}catch(Exception e){
			e.printStackTrace();	
			msg =  "Error: " + e.getMessage();
		}	
		//Actualizo Base Local
		try{
			Factura facturaUpdate = facturaManager.getFacturaByTransac(transacNr);			
			facturaUpdate.setResultado(msg);
			facturaUpdate.setCodError("0");
			facturaManager.updateFactura(facturaUpdate);
		}catch(Exception e){
			e.printStackTrace();
		}

		return msg;		
	}
	
	public String gestionoFacturaABAS(String letra, Long transacNr){
		
		String sistema = parametrizacionDAO.getByPrimaryKey(Constants.ID_SISTEMA).getValor();
		String bibliotecaGeneric = parametrizacionDAO.getByPrimaryKey(Constants.ID_BASE_GENERIC).getValor();
		String usrAs = parametrizacionDAO.getByPrimaryKey(Constants.ID_USR_AS).getValor();
		String passAs = parametrizacionDAO.getByPrimaryKey(Constants.ID_PASS_AS).getValor();
		
		BaseExternaAS be = new BaseExternaAS("com.ibm.as400.access.AS400JDBCDriver","jdbc:as400://"+sistema+"/"+bibliotecaGeneric+letra+"1", null, null, usrAs, passAs);

		String msg = "";
		try{
			FECAEResponse feRes = new FECAEResponse(); 
			FECAERequest feReq = new FECAERequest();
			try{
				feReq = be.getFacturaExt(transacNr);
	
			}catch(Exception e){
				e.printStackTrace();
				msg =  e.getMessage();
			}
			//Controlo los errores de parseo
			if (msg.equals("") && feReq.getErrorFE().equals("")){
				
				Empresa empresa = empresaManager.getByLetra(letra);			
				//Obtengo la Factura de base local
				
				
				Factura factura = facturaManager.getFacturaByTransacLetra(transacNr, letra);
				
				boolean facturaProcesada = false;
				//Si existe la factura en la base
				if (factura != null){
					//Si tiene CAE armo el archivo de devoluci�n
					if (factura.getCae() != null && !factura.getCae().trim().equals("")){
						facturaProcesada = true;
						
						try{
							be.updateBase(transacNr, factura.getCae() , Long.parseLong(factura.getCae_vto()), factura.getCbt_desde(), "OK");
						}catch(Exception eee){
							eee.printStackTrace();
						}//msg = factura.getCae() + "|" + factura.getCae_vto() + "|" + factura.getCbt_desde() + "|" + "La factura ya se encuentra Procesada con la obtenci�n de CAE exitoso";
						msg = "OK";
						return msg;
					} 

				}else{
					try{
						//Persisto la Factura
						facturaManager.saveFactura(generateFacturaAB(feReq, transacNr, rutaBaseOrig, rutaComunOrig, rutaArticuloOrig, letra));
					}catch(Exception e){
						e.printStackTrace();
					}
				}	
				
				if(factura != null && factura.getReproceso() != null && factura.getReproceso().equals("P")){
					//Recuperar Factura de la Base Mysql
					Factura facturaRecuperada = facturaManager.getFacturaByTransacLetra(transacNr, letra);
					
					
					//Recuperar la factura desde la AFIP
					FECompConsultaResponse feResponse = facturaManager.getComprobanteByPrimary(facturaRecuperada.getCbt_desde(), facturaRecuperada.getTipo_cbte(), facturaRecuperada.getPunto_vta(), empresa);

					//Comparar los valores de Imptotal, Tipo de Compro, Prefijo, Numero de Factura
					if (feResponse != null && feResponse.getResultGet().getImpTotal() == facturaRecuperada.getImp_total() && 
							feResponse.getResultGet().getCbteTipo() == facturaRecuperada.getTipo_cbte() &&
							feResponse.getResultGet().getCbteDesde() == facturaRecuperada.getCbt_desde()){						
						be.updateBase(transacNr, feResponse.getResultGet().getCodAutorizacion() ,Long.parseLong(feResponse.getResultGet().getFchVto()) , feResponse.getResultGet().getCbteDesde(), "OK");						
						//msg = feDetalleResponseA[0].getCAE() + "|" + feDetalleResponseA[0].getCAEFchVto() + "|" + comprNr + "|" +resultado;
						msg = "OK";
						//Actualizo Base Local
						Factura facturaUpdate = facturaManager.getFacturaByTransac(transacNr);
						facturaUpdate.setCae(feResponse.getResultGet().getCodAutorizacion() );
						facturaUpdate.setCae_vto(feResponse.getResultGet().getFchVto() );
						try{
							facturaUpdate.setCbt_desde(Long.parseLong(String.valueOf(feResponse.getResultGet().getCbteDesde())));
							facturaUpdate.setCbt_hasta(Long.parseLong(String.valueOf(feResponse.getResultGet().getCbteDesde())));								
						}catch(NumberFormatException ne){
							
						}						
						facturaUpdate.setCodError("0");
						facturaUpdate.setReproceso(null);
						facturaManager.updateFactura(facturaUpdate);
						return msg;

						//Si no coincide libero la factura seteando en NULL el valor reproceso
					}else{
						Factura facturaALiberar = facturaManager.getFacturaByTransac(transacNr);
						facturaALiberar.setReproceso(null);
						facturaManager.updateFactura(facturaRecuperada);
						facturaProcesada = false;
						//msg ="Existi� un Error con la conexi�n a la AFIP, por favor intente nuevamente";
						//return msg;
					}
					

					
					
				}else{

				if(!facturaProcesada){
					try {
						feRes = facturaManager.facturacionAFIP(feReq, empresa, null);
						
						Factura facturaUpdate1 = facturaManager.getFacturaByTransacLetra(transacNr, letra);
						
						facturaUpdate1.setRequestEnviado(feRes.getRequestEnviado());
						
						facturaManager.updateFactura(facturaUpdate1);
						
						//factura
						
						String resultado = "";
						
						Err[] errores = feRes.getErrors();
											
						if (errores == null) {
							if (feRes.getFeDetResp() != null
									|| feRes.getFeDetResp().length > 0) {
								Obs[] observaciones = feRes.getFeDetResp()[0]
										.getObservaciones();
								if (observaciones != null) {
									int i = 0;
									for (Obs obs : observaciones) {
										System.out.println(obs.getMsg());
										if (i == 0){
											resultado = obs.getMsg();	
										}else{
											resultado = resultado + "/" + obs.getMsg();
										}
										i++;
										
									}
								}
							}
						} else {
							int i = 0;
							for (Err err : errores) {							
								if (i == 0){
									resultado = err.getMsg();	
								}else{
									resultado = resultado + "/  " + err.getMsg();
								}
								i++;
								
							}
		
						}
						
						FECAEDetResponse[] feDetalleResponseA = feRes.getFeDetResp();
						
						try{
							System.out.println("CAE " + feDetalleResponseA[0].getCAE());
							
							System.out.println("Tipo de Comprobante " + feRes.getFeCabResp().getCbteTipo());
							
							System.out.println("Comprobante " + feDetalleResponseA[0].getCbteDesde());
							
							System.out.println("CAE Vencimiento " + feDetalleResponseA[0].getCAEFchVto());
			
							System.out.println("Prefijo " + feRes.getFeCabResp().getPtoVta());
							
						}catch(Exception e){
							//e.printStackTrace();
						}
		
						//Si no tengo un error en la obtencion
						if (feDetalleResponseA != null && feDetalleResponseA[0] != null){
							if (!feDetalleResponseA[0].getCAE().trim().equals("")){
								String comprNr = FormatUtil.llenoConCeros(String.valueOf(feDetalleResponseA[0].getCbteDesde()), 8);
								try{
								//Actualizo AS
								be.updateBase(transacNr, feDetalleResponseA[0].getCAE() , Long.parseLong(feDetalleResponseA[0].getCAEFchVto()), Long.parseLong(comprNr), "OK");														
								}catch(Exception ee){
									ee.printStackTrace();
								}
								//msg = feDetalleResponseA[0].getCAE() + "|" + feDetalleResponseA[0].getCAEFchVto() + "|" + comprNr + "|" +resultado;
								msg = "OK";
								//Actualizo Base Local
								Factura facturaUpdate = facturaManager.getFacturaByTransac(transacNr);
								facturaUpdate.setCae(feDetalleResponseA[0].getCAE() );
								facturaUpdate.setCae_vto(feDetalleResponseA[0].getCAEFchVto());
								try{
									facturaUpdate.setCbt_desde(Long.parseLong(comprNr));
									facturaUpdate.setCbt_hasta(Long.parseLong(comprNr));								
								}catch(NumberFormatException ne){}
								facturaUpdate.setResultado(resultado);
								facturaUpdate.setCodError("0");
								facturaManager.updateFactura(facturaUpdate);
								return msg;
							}else{								
								msg =  resultado;
								if (parametrizacionDAO.getByPrimaryKey(Constants.ID_ENVIA_MAIL).getValor().equals("true")){
									sendMail(resultado, transacNr);
								}
							}
						}else{
							msg = resultado;
						}		
					} catch (RemoteException e) {
						e.printStackTrace();
						msg =  "No se ha podido realizar la comunicaci�n con el servidor de AFIP, cuando el sistema tenga acceso enviar� la factura automaticamente";
						//Hay que cargar la factura el la cola para volver a cargarla
						try{
							Factura facturaUpdate = facturaManager.getFacturaByTransacLetra(transacNr, letra);	
							facturaUpdate.setLetra(letra);
							facturaUpdate.setNumeroInterno(String.valueOf(transacNr));
							facturaUpdate.setCodError("10");
							facturaUpdate.setReproceso("P");
							facturaManager.updateFactura(facturaUpdate);
							//Actualizo AS
							be.updateBase(transacNr, "" , 0l, 0l, msg);														

						}catch(Exception ne){
							ne.printStackTrace();
						}
						if (parametrizacionDAO.getByPrimaryKey(Constants.ID_ENVIA_MAIL).getValor().equals("true")){
							sendMail(msg, transacNr);
						}
						return msg;						
					}catch(GenerationTimerException ge){
						ge.printStackTrace();
						msg =  "La fecha/hora informada (" + new Timestamp(System.currentTimeMillis()) + ") no es la esperada por AFIP, actualice la fecha/hora del servidor";
						try{
							Factura facturaUpdate = facturaManager.getFacturaByTransac(transacNr);	
							facturaUpdate.setCodError("10");							
							facturaManager.updateFactura(facturaUpdate);
						}catch(Exception ne){
							ne.printStackTrace();
						}
						if (parametrizacionDAO.getByPrimaryKey(Constants.ID_ENVIA_MAIL).getValor().equals("true")){
							sendMail(msg, transacNr);
						}
											
					}
				}
				}
			}else{
				msg =  feReq.getErrorFE();
			}								
		}catch(Exception e){
			e.printStackTrace();	
			msg =  "Error: " + e.getMessage();
		}	
		//Actualizo Base Local
		try{
			Factura facturaUpdate = facturaManager.getFacturaByTransac(transacNr);			
			facturaUpdate.setLetra(letra);
			facturaUpdate.setNumeroInterno(String.valueOf(transacNr));
			facturaUpdate.setResultado(msg);
			facturaUpdate.setCodError("0");
			facturaManager.updateFactura(facturaUpdate);
			//Actualizo AS
			be.updateBase(transacNr, "" , 0l, 0l, msg);	
		}catch(Exception e){
			e.printStackTrace();
		}

		return msg;		
	}
	private String gestionoFacturaMTX(Long transacNr, String rutaBase, String rutaComun, String rutaArticulo){
		String msg = "";
		try{
			
			//Clasifico la Factura
			//BaseExternaE be = new BaseExternaE("sun.jdbc.odbc.JdbcOdbcDriver","jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=@rutaBase", rutaComun, rutaArticulo);

			String baseComun="";
			String baseArticulo="";
			
			BaseExternaMTX be = null;
			//Clasifico la Factura
			int ubicador = rutaBase.indexOf("|");  
			if (ubicador == -1){
				//rutaBase = "[" + rutaBase+ "]";
				String rutaComunA = "[" + rutaComunOrig+ "]";
				String rutaArticuloA = "[" + rutaArticuloOrig+ "]";
				be = new BaseExternaMTX("sun.jdbc.odbc.JdbcOdbcDriver","jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=@rutaBase", rutaComunA, rutaArticuloA);
			}else{					
				String servidor = rutaBase.substring(0, ubicador);
				String base = rutaBase.substring(ubicador +1);
				//rutaBase = "[" + rutaBaseOrig + "]" + ".dbo";
				baseComun = "[" + rutaComunOrig.substring(ubicador +1) + "]" + ".dbo";
				baseArticulo = "[" + rutaArticuloOrig.substring(ubicador +1) + "]" + ".dbo";
				String user = parametrizacionDAO.getByPrimaryKey(Constants.ID_USR_SQL).getValor();
				String password = parametrizacionDAO.getByPrimaryKey(Constants.ID_PASSWORD_SQL).getValor();
				be = new BaseExternaMTX("net.sourceforge.jtds.jdbc.Driver","jdbc:jtds:sqlserver://"+servidor+":1433/"+base, baseComun, baseArticulo, user, password);					
			}

				
			ComprobanteType feReq = new ComprobanteType(); 
			
			try{
				feReq  = be.getFacturaExt(transacNr, rutaBase);
	
			}catch(Exception e){
				e.printStackTrace();
				msg = e.getMessage();
			}
			//Controlo los errores de parseo
			if (msg.equals("")){
				
				Empresa empresa = empresaManager.getByPrimaryKey(3l);
				
				AutorizarComprobanteResponseType autorizarComprobanteResponseType = new AutorizarComprobanteResponseType();
				//Obtengo la Factura de base local
				Factura factura = facturaManager.getFacturaByTransac(transacNr);
				
				boolean facturaProcesada = false;
				//Si existe la factura en la base
				if (factura != null){
					//Si tiene CAE armo el archivo de devoluci�n
					if (factura.getCae() != null && !factura.getCae().trim().equals("")){
						facturaProcesada = true;
						msg = "OK";
						return msg;
					} 
				}else{
					try{
						//Persisto la Factura
						facturaManager.saveFactura(generateFacturaMTX(feReq, transacNr, rutaBase, rutaComun, rutaArticulo));
					}catch(Exception e){
						e.printStackTrace();
					}
				}
				if(!facturaProcesada){
					try {
						autorizarComprobanteResponseType = facturaManager.facturacionAFIPMTX(feReq, empresa);
						
						Factura facturaUpdate1 = facturaManager.getFacturaByTransac(transacNr);
						
						facturaUpdate1.setRequestEnviado(autorizarComprobanteResponseType.getRequestEnviado());
						
						facturaManager.updateFactura(facturaUpdate1);
						
						String resultado = "";
						
						//System.out.println("Repuesta - Error: " + castArrayToString(autorizarComprobanteResponseType.getArrayErrores()));												
						
												
						
						
							
							//Si tengo errores
							if (autorizarComprobanteResponseType.getArrayErrores() !=null && autorizarComprobanteResponseType.getArrayErrores().length > 0){
								resultado = castArrayToString(autorizarComprobanteResponseType.getArrayErrores());
								msg =  resultado;
								if (parametrizacionDAO.getByPrimaryKey(Constants.ID_ENVIA_MAIL).getValor().equals("true")){
									sendMail(resultado, transacNr);
								}
								
							}else{
								System.out.println("Repuesta - CAE: " + autorizarComprobanteResponseType.getComprobanteResponse().getCAE());															
								
								System.out.println("Repuesta - Vencimiento CAE: " + DateUtil.getCanonicalFech(autorizarComprobanteResponseType.getComprobanteResponse().getFechaVencimientoCAE()));
								
								System.out.println("Repuesta - Numero de Comprobante: " + autorizarComprobanteResponseType.getComprobanteResponse().getNumeroComprobante());
								
								String comprNr = FormatUtil.llenoConCeros(String.valueOf(autorizarComprobanteResponseType.getComprobanteResponse().getNumeroComprobante()), 8);
								be.updateBase(transacNr, String.valueOf(autorizarComprobanteResponseType.getComprobanteResponse().getCAE()), DateUtil.getCanonicalFech(autorizarComprobanteResponseType.getComprobanteResponse().getFechaVencimientoCAE()), rutaBase, comprNr, feReq.getImporteTotal());						
								//msg = fEXResponseAuthorizeDesa.getFEXResultAuth().getCae() + "|" + fEXResponseAuthorizeDesa.getFEXResultAuth().getFch_venc_Cae() + "|" + comprNr + "|" +resultado;
								msg="OK";
								//Actualizo Base Local
								Factura facturaUpdate = facturaManager.getFacturaByTransac(transacNr);
								facturaUpdate.setCae(String.valueOf(autorizarComprobanteResponseType.getComprobanteResponse().getCAE()));
								facturaUpdate.setCae_vto(DateUtil.getCanonicalFech(autorizarComprobanteResponseType.getComprobanteResponse().getFechaVencimientoCAE()));
								try{
									facturaUpdate.setCbt_desde(Long.parseLong(comprNr));
									facturaUpdate.setCbt_hasta(Long.parseLong(comprNr));								
								}catch(NumberFormatException ne){}
								facturaUpdate.setResultado(resultado);								
								facturaUpdate.setCodError("0");
								facturaManager.updateFactura(facturaUpdate);
								return msg;
							}
					} catch (RemoteException e) {
						e.printStackTrace();
						msg = "No se ha podido realizar la comunicaci�n con el servidor de AFIP, cuando el sistema tenga acceso enviar� la factura automaticamente";
						//Hay que cargar la factura el la cola para volver a cargarla
						try{
							Factura facturaUpdate = facturaManager.getFacturaByTransac(transacNr);	
							facturaUpdate.setCodError("10");							
							facturaManager.updateFactura(facturaUpdate);
						}catch(Exception ne){
							ne.printStackTrace();
						}
						if (parametrizacionDAO.getByPrimaryKey(Constants.ID_ENVIA_MAIL).getValor().equals("true")){
							sendMail(msg, transacNr);
						}
						return msg;	
					}catch(GenerationTimerException ge){
						ge.printStackTrace();
						msg =  "La fecha/hora informada (" + new Timestamp(System.currentTimeMillis()) + ") no es la esperada por AFIP, actualice la fecha/hora del servidor";
						try{
							Factura facturaUpdate = facturaManager.getFacturaByTransac(transacNr);	
							facturaUpdate.setCodError("10");							
							facturaManager.updateFactura(facturaUpdate);
						}catch(Exception ne){
							ne.printStackTrace();
						}
						if (parametrizacionDAO.getByPrimaryKey(Constants.ID_ENVIA_MAIL).getValor().equals("true")){
							sendMail(msg, transacNr);
						}
											
					}catch (Exception e) {
						e.printStackTrace();
						msg =  "Existe alg�n dato que no se corresponde con el tipo de dato requerido";
					}
				}
			}else{
				//msg =  feReq.getErrorParceso();
			}	
			//Persisto la factura 
		}catch(Exception e){
			e.printStackTrace();	
			msg =  "Error al conectar a la base de datos " +e.getMessage();
		}			
		//Actualizo Base Local
		try{
			Factura facturaUpdate = facturaManager.getFacturaByTransac(transacNr);	
			facturaUpdate.setResultado(msg);
			facturaUpdate.setCodError("0");
			facturaManager.updateFactura(facturaUpdate);
		}catch(Exception e){}
		return msg;		
	}
	

	private static String castArrayToString(CodigoDescripcionType[] arrayErrores) {
		String result = "";
			for(CodigoDescripcionType code: arrayErrores ){
				result = result + code.getDescripcion();
				System.out.println(code.getDescripcion());
			}
		return result;
	}

	private String gestionoFacturaE(Long transacNr, String rutaBase, String rutaComun, String rutaArticulo){
		String msg = "";
		System.out.println("Transac:" + transacNr + " " + rutaBase + " " + rutaComun + " " + rutaArticulo);
		try{
			
			//Clasifico la Factura
			//BaseExternaE be = new BaseExternaE("sun.jdbc.odbc.JdbcOdbcDriver","jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=@rutaBase", rutaComun, rutaArticulo);

			String baseComun="";
			String baseArticulo="";
			
			BaseExternaE be = null;
			//Clasifico la Factura
			int ubicador = rutaBase.indexOf("|");  
			if (ubicador == -1){
				//rutaBase = "[" + rutaBase+ "]";
				String rutaComunA = "[" + rutaComunOrig+ "]";
				String rutaArticuloA = "[" + rutaArticuloOrig+ "]";
				be = new BaseExternaE("sun.jdbc.odbc.JdbcOdbcDriver","jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=@rutaBase", rutaComunA, rutaArticuloA);
			}else{					
				String servidor = rutaBase.substring(0, ubicador);
				String base = rutaBase.substring(ubicador +1);
				//rutaBase = "[" + rutaBaseOrig + "]" + ".dbo";
				baseComun = "[" + rutaComunOrig.substring(ubicador +1) + "]" + ".dbo";
				baseArticulo = "[" + rutaArticuloOrig.substring(ubicador +1) + "]" + ".dbo";
				String user = parametrizacionDAO.getByPrimaryKey(Constants.ID_USR_SQL).getValor();
				String password = parametrizacionDAO.getByPrimaryKey(Constants.ID_PASSWORD_SQL).getValor();
				be = new BaseExternaE("net.sourceforge.jtds.jdbc.Driver","jdbc:jtds:sqlserver://"+servidor+":1433/"+base, baseComun, baseArticulo, user, password);					
			}

				
			ClsFEXRequestDesa feReq = new ClsFEXRequestDesa(); 
			try{
				feReq  = be.getFacturaExt(transacNr, rutaBase);
	
			}catch(Exception e){
				e.printStackTrace();
				msg = e.getMessage();
			}
			//Controlo los errores de parseo
			if (msg.equals("") && feReq.getErrorParceso().equals("")){
				
				Empresa empresa = empresaManager.getByPrimaryKey(2l);
				
				FEXResponseAuthorizeDesa fEXResponseAuthorizeDesa = null;
				//Obtengo la Factura de base local
				Factura factura = facturaManager.getFacturaByTransac(transacNr);
				
				boolean facturaProcesada = false;
				//Si existe la factura en la base
				if (factura != null){
					//Si tiene CAE armo el archivo de devoluci�n
					if (factura.getCae() != null && !factura.getCae().trim().equals("")){
						facturaProcesada = true;
						msg = "OK";
						return msg;
					} 
				}else{
					try{
						//Persisto la Factura
						facturaManager.saveFactura(generateFacturaE(feReq, transacNr, rutaBase));
					}catch(Exception e){
						e.printStackTrace();
					}
				}
				if(!facturaProcesada){
					try {
												
						fEXResponseAuthorizeDesa = facturaManager.facturacionEAFIP(feReq, empresa);						
						
						Factura facturaUpdate1 = facturaManager.getFacturaByTransac(transacNr);
						
						facturaUpdate1.setRequestEnviado(fEXResponseAuthorizeDesa.getRequestEnviado());
						
						facturaManager.updateFactura(facturaUpdate1);
						

						String resultado = "";
						
						System.out.println("Repuesta - Error: " + fEXResponseAuthorizeDesa.getFEXErr().getErrMsg());
						
						System.out.println("Repuesta - Events: " + fEXResponseAuthorizeDesa.getFEXEvents().getEventMsg());				
						
						System.out.println("Repuesta - Codigo Error: " + fEXResponseAuthorizeDesa.getFEXErr().getErrCode());
						
						resultado = fEXResponseAuthorizeDesa.getFEXErr().getErrMsg().trim() + "/" + fEXResponseAuthorizeDesa.getFEXErr().getErrCode() + "/" +fEXResponseAuthorizeDesa.getFEXEvents().getEventMsg();						
						
						if (fEXResponseAuthorizeDesa.getFEXResultAuth() != null){
							
							System.out.println("Repuesta - CAE: " + fEXResponseAuthorizeDesa.getFEXResultAuth().getCae());
							
							System.out.println("Repuesta - Reproceso: " + fEXResponseAuthorizeDesa.getFEXResultAuth().getReproceso());
							
							System.out.println("Repuesta - Vencimiento CAE: " + fEXResponseAuthorizeDesa.getFEXResultAuth().getFch_venc_Cae());
						
						}
											
						//Si no tengo un error en la obtencion
						if (fEXResponseAuthorizeDesa.getFEXResultAuth() != null){
							String comprNr = FormatUtil.llenoConCeros(String.valueOf(fEXResponseAuthorizeDesa.getFEXResultAuth().getCbte_nro()), 8);
							be.updateBase(transacNr, fEXResponseAuthorizeDesa.getFEXResultAuth().getCae(),fEXResponseAuthorizeDesa.getFEXResultAuth().getFch_venc_Cae(), rutaBase, comprNr, feReq.getImp_total());						
							//msg = fEXResponseAuthorizeDesa.getFEXResultAuth().getCae() + "|" + fEXResponseAuthorizeDesa.getFEXResultAuth().getFch_venc_Cae() + "|" + comprNr + "|" +resultado;
							msg="OK";
							//Actualizo Base Local
							Factura facturaUpdate = facturaManager.getFacturaByTransac(transacNr);
							facturaUpdate.setCae(fEXResponseAuthorizeDesa.getFEXResultAuth().getCae());
							facturaUpdate.setCae_vto(fEXResponseAuthorizeDesa.getFEXResultAuth().getFch_venc_Cae());
							try{
								facturaUpdate.setCbt_desde(Long.parseLong(comprNr));
								facturaUpdate.setCbt_hasta(Long.parseLong(comprNr));								
							}catch(NumberFormatException ne){}
							facturaUpdate.setResultado(resultado);
							facturaUpdate.setIdAfip(String.valueOf(feReq.getId()));
							facturaUpdate.setCodError("0");
							facturaManager.updateFactura(facturaUpdate);
							return msg;
						}else{
							msg =  resultado;
							if (parametrizacionDAO.getByPrimaryKey(Constants.ID_ENVIA_MAIL).getValor().equals("true")){
								sendMail(resultado, transacNr);
							}
						}
		
					} catch (RemoteException e) {
						e.printStackTrace();
						msg = "No se ha podido realizar la comunicaci�n con el servidor de AFIP, cuando el sistema tenga acceso enviar� la factura automaticamente";
						//Hay que cargar la factura el la cola para volver a cargarla
						try{
							Factura facturaUpdate = facturaManager.getFacturaByTransac(transacNr);	
							facturaUpdate.setCodError("10");							
							facturaManager.updateFactura(facturaUpdate);
						}catch(Exception ne){
							ne.printStackTrace();
						}
						if (parametrizacionDAO.getByPrimaryKey(Constants.ID_ENVIA_MAIL).getValor().equals("true")){
							sendMail(msg, transacNr);
						}
						return msg;	
					}catch(GenerationTimerException ge){
						ge.printStackTrace();
						msg =  "La fecha/hora informada (" + new Timestamp(System.currentTimeMillis()) + ") no es la esperada por AFIP, actualice la fecha/hora del servidor";
						try{
							Factura facturaUpdate = facturaManager.getFacturaByTransac(transacNr);	
							facturaUpdate.setCodError("10");							
							facturaManager.updateFactura(facturaUpdate);
						}catch(Exception ne){
							ne.printStackTrace();
						}
						if (parametrizacionDAO.getByPrimaryKey(Constants.ID_ENVIA_MAIL).getValor().equals("true")){
							sendMail(msg, transacNr);
						}
											
					}catch (Exception e) {

						e.printStackTrace();
						msg =  "Existe alg�n dato que no se corresponde con el tipo de dato requerido";
					}
				}
			}else{
				msg =  feReq.getErrorParceso();
			}	
			//Persisto la factura 
		}catch(Exception e){
			e.printStackTrace();	
			msg =  "Error al conectar a la base de datos";
		}			
		//Actualizo Base Local
		try{
			Factura facturaUpdate = facturaManager.getFacturaByTransac(transacNr);	
			facturaUpdate.setResultado(msg);
			facturaUpdate.setCodError("0");
			facturaManager.updateFactura(facturaUpdate);
		}catch(Exception e){}
		return msg;		
	}
	
	public Properties getPropertiesEmail(){
		Properties props = new Properties();
		long i = 50l;
		while(i < 66){
			Parametrizacion parametrizacion = parametrizacionDAO.getByPrimaryKey(i);			
			if (parametrizacion!=null){
				props.put(parametrizacion.getDescrip().trim(), parametrizacion.getValor().trim());				
			}			
			i++;
		}			
		return props;
	}

	public Properties getPropertiesEmail(String enviante){
		Properties props = new Properties();
		long i = 50l;
		while(i < 66){
			Parametrizacion parametrizacion = parametrizacionDAO.getByPrimaryKey(i);			
			if (parametrizacion!=null){
				if (i == 63){
					//props.put("mail.smtp.user", enviante);
				}else{
					props.put(parametrizacion.getDescrip().trim(), parametrizacion.getValor().trim());
				}
								
			}			
			i++;
		}			
		return props;
	}
	
	private void sendMail(String error, Long transacNr){
		//Cargo los datos del EMail				
		String mailAdminitrador = parametrizacionDAO.getByPrimaryKey(Constants.ID_MAIL_ADMNISTRADOR).getValor();
		Email email = new Email("Error en la Autorizacion de una Factura en la Transacci�n : " + transacNr,error,null, mailAdminitrador);
		Properties props = getPropertiesEmail();		
		SendEmailThread emailManager = new SendEmailThread(props,email);		
		emailManager.start();
	}
	
	
	private Factura generateFacturaE(ClsFEXRequestDesa feReq, Long transacNr, String rutaBase){
		Factura facturaSave = new Factura();
		facturaSave.setFecha_cbte(DateUtil.composeCanonicalFech(feReq.getFecha_cbte()));
		facturaSave.setFecha_creacion(new Timestamp(System.currentTimeMillis()));
		facturaSave.setImp_total(feReq.getImp_total());
		facturaSave.setTipo_cbte(((Short)feReq.getTipo_cbte()).intValue());
		facturaSave.setNumeroInterno(String.valueOf(transacNr));
		facturaSave.setPunto_vta(((Short)feReq.getPunto_vta()).intValue());
		facturaSave.setNro_doc(feReq.getCuit_pais_cliente());
		facturaSave.setNombreArchivo(rutaBase);		
		return facturaSave;		
	}
	
	private Factura generateFacturaMTX(ComprobanteType feReq, Long transacNr, String rutaBase, String rutaComun, String rutaArticulo){
		Factura facturaSave = new Factura();
		facturaSave.setFecha_cbte(new Timestamp(feReq.getFechaEmision().getTime()));
		facturaSave.setFecha_creacion(new Timestamp(System.currentTimeMillis()));
		facturaSave.setImp_total(feReq.getImporteTotal().doubleValue());
		facturaSave.setTipo_cbte(feReq.getCodigoTipoDocumento().intValue());
		facturaSave.setNumeroInterno(String.valueOf(transacNr));
		facturaSave.setPunto_vta(((Short)feReq.getNumeroPuntoVenta()).intValue());
		facturaSave.setNro_doc(feReq.getNumeroDocumento());
		facturaSave.setNombreArchivo(rutaBase);
		facturaSave.setRutaComun(rutaComun);
		facturaSave.setRutaArticulo(rutaArticulo);
		return facturaSave;		
	}

	private Factura generateFacturaAB (FECAERequest feReq, Long transacNr, String rutaBase, String rutaComun, String rutaArticulo){
		Factura facturaSave = new Factura();
		facturaSave.setFecha_cbte(DateUtil.composeCanonicalFech(feReq.getFeDetReq()[0].getCbteFch()));
		facturaSave.setFecha_creacion(new Timestamp(System.currentTimeMillis()));
		facturaSave.setImp_total(feReq.getFeDetReq()[0].getImpTotal());
		facturaSave.setTipo_cbte((feReq.getFeCabReq().getCbteTipo()));
		facturaSave.setNumeroInterno(String.valueOf(transacNr));
		facturaSave.setPunto_vta(feReq.getFeCabReq().getPtoVta());
		facturaSave.setNro_doc(feReq.getFeDetReq()[0].getDocNro());
		facturaSave.setNombreArchivo(rutaBase);
		facturaSave.setRutaComun(rutaComun);
		facturaSave.setRutaArticulo(rutaArticulo);
		//facturaSave.setReproceso("P");
		return facturaSave;						
	}
	
	private Factura generateFacturaAB (FECAERequest feReq, Long transacNr, String rutaBase, String rutaComun, String rutaArticulo, String letra){
		Factura facturaSave = new Factura();
		facturaSave.setMetodoAfip("LOCAL");
		facturaSave.setFecha_cbte(DateUtil.composeCanonicalFech(feReq.getFeDetReq()[0].getCbteFch()));
		facturaSave.setFecha_creacion(new Timestamp(System.currentTimeMillis()));
		facturaSave.setImp_total(feReq.getFeDetReq()[0].getImpTotal());
		facturaSave.setTipo_cbte((feReq.getFeCabReq().getCbteTipo()));
		facturaSave.setNumeroInterno(String.valueOf(transacNr));
		facturaSave.setPunto_vta(feReq.getFeCabReq().getPtoVta());
		facturaSave.setNro_doc(feReq.getFeDetReq()[0].getDocNro());
		facturaSave.setNombreArchivo("Request" + feReq.getNumeroInterno() + ".txt");
		facturaSave.setRutaComun(rutaComun);
		facturaSave.setRutaArticulo(rutaArticulo);
		facturaSave.setLetra(letra);
		return facturaSave;						
	}

	private Factura generateFacturaAB (FECAERequest feReq){
		Factura facturaSave = new Factura();
		facturaSave.setMetodoAfip("LOCAL");
		facturaSave.setFecha_cbte(DateUtil.composeCanonicalFech(feReq.getFeDetReq()[0].getCbteFch()));
		facturaSave.setFecha_creacion(new Timestamp(System.currentTimeMillis()));
		facturaSave.setImp_total(feReq.getFeDetReq()[0].getImpTotal());
		facturaSave.setTipo_cbte((feReq.getFeCabReq().getCbteTipo()));
		facturaSave.setNumeroInterno(feReq.getNumeroInterno());
		facturaSave.setPunto_vta(feReq.getFeCabReq().getPtoVta());
		facturaSave.setNro_doc(feReq.getFeDetReq()[0].getDocNro());		
		return facturaSave;						
	}
	private Factura generateFacturaABCaea (FECAEARequest feReq){
		Factura facturaSave = new Factura();
		facturaSave.setMetodoAfip("LOCAL");
		facturaSave.setFecha_cbte(DateUtil.composeCanonicalFech(feReq.getFeDetReq()[0].getCbteFch()));
		facturaSave.setFecha_creacion(new Timestamp(System.currentTimeMillis()));
		facturaSave.setImp_total(feReq.getFeDetReq()[0].getImpTotal());
		facturaSave.setTipo_cbte((feReq.getFeCabReq().getCbteTipo()));
		facturaSave.setNumeroInterno(feReq.getNumeroInterno());
		facturaSave.setPunto_vta(feReq.getFeCabReq().getPtoVta());
		facturaSave.setNro_doc(feReq.getFeDetReq()[0].getDocNro());		
		return facturaSave;						
	}
	
		private Factura generateFacturaE (ClsFEXRequest feReq){
		Factura facturaSave = new Factura();
		facturaSave.setMetodoAfip("EXPO");
		facturaSave.setFecha_cbte(DateUtil.composeCanonicalFech(feReq.getFecha_cbte()));
		facturaSave.setFecha_creacion(new Timestamp(System.currentTimeMillis()));
		facturaSave.setImp_total(feReq.getImp_total().doubleValue());
		facturaSave.setTipo_cbte(Integer.parseInt(String.valueOf(feReq.getCbte_Tipo())));
		facturaSave.setNumeroInterno("");
		facturaSave.setPunto_vta(Integer.parseInt(String.valueOf(feReq.getPunto_vta())));
		facturaSave.setNro_doc(feReq.getCuit_pais_cliente());		
		return facturaSave;						
	}

	
	public void procesarFacturaError() {
		List<Factura> facturas = facturaManager.getFacturasConErrorConn();
		if (facturas != null && facturas.size() > 0){
			for(Factura factura: facturas){
				try{
					Long transacNr = Long.parseLong(factura.getNumeroInterno());
					autorizoFactura(transacNr, factura.getNombreArchivo(), factura.getRutaComun(), factura.getRutaArticulo());	
				}catch(Exception e){
					e.printStackTrace();
				}
				
			}
		}		
	}

	/**
	 * Valido el usuario y password 
	 * @param usuario
	 * @param password
	 * @return
	 */
	public String validateUSR(String usuario, String password){
		String result = "";
		//Pregunto si el cuit se encuentra en la base de facturas
		String rutaComun = "";//facturaManager.getRutaFactura(usuario); 
		if( rutaComun == null){
			result = "No existen factruras relacionadas con el CUIT";
		}else{
			//BaseExterna be = new BaseExterna(rutaComun);

		}
		return null;
	}
	
	public void saveAdjuntoFactura(String transacNr, File adjunto) throws IOException{
		Factura factura = facturaManager.getFacturaByTransac(transacNr);
		if(factura != null){
			factura.setAdjunto(FileUtil.getBytesFromFile(adjunto));
			facturaManager.updateFactura(factura);
		}
		
	}


	public void procesarFacturaByFiles() {
		String msg = "";
		try{

			String rutaProvisorio = (parametrizacionDAO.getByPrimaryKey(Constants.ID_CARPETA_PROVISORIO)).getValor();
			String rutaDefinitivo = (parametrizacionDAO.getByPrimaryKey(Constants.ID_CARPETA_DEFINITIVO)).getValor();
			
			
			//System.out.println("rutaProvisorioDesa " + rutaProvisorio);
			//System.out.println("rutaDefinitivoDesa " + rutaDefinitivo);
			Empresa em = empresaManager.getByPrimaryKey(1l);
			
			FECAEResponse feRes = new FECAEResponse(); 
			FECAERequest feReq = new FECAERequest();

			File dir = new File(rutaProvisorio);
			
			File[] files = dir.listFiles();
	        
	        int countFiles = files.length;        
			int i = 0;
				        
	        while(i < countFiles){
		        if (files[i].isFile()){
		        	if(files[i].canWrite()){                                    
		                try{                
		                    if (files[i].getName().startsWith("A")){
		                        // Borro cualquier archivo con el mismo nombre en el destino
		                        File borrado = new File(rutaDefinitivo+files[i].getName());
		                        borrado.delete();
		                        // muevo el archivo                              
		                        File fileDestino = new File(rutaDefinitivo+files[i].getName());
		                        FileUtil.copy(files[i], fileDestino);
		                        files[i].delete();
		                        //Pregunto si es caea
		                        if (parametrizacionDAO.getByPrimaryKey(Constants.ID_USE_MODE_CAEA).getValor().equals("true")){
			                        FECAEARequest feReqIntCaea = ParseFacturaCaea.parseFacturaABv1(fileDestino.getAbsolutePath());
			                        //Proceso la Factura
			                        procesoFacturaABCaea(feReqIntCaea, fileDestino.getName());
		                        }else{
			                        FECAERequest feReqInt = ParseFactura.parseFacturaABv1(fileDestino.getAbsolutePath());
			                        //Proceso la Factura
			                        procesoFacturaAB(feReqInt, fileDestino.getName());		                        	
		                        }
		                        
		                     }   	    
		                    }catch (Exception exp){
			                	exp.printStackTrace();
		                }
		                    
		        	}                
		        }else{
		        	i++;
		        }
		        
			}
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}
	//informarComprobCaeaAFIP

	private String procesoFacturaAB(FECAERequest feReq, String nombreArchivo){
		String msg = "";
		String rutaSalida= (parametrizacionDAO.getByPrimaryKey(Constants.ID_CARPETA_SALIDA)).getValor();
		try{

			FECAEResponse feRes = new FECAEResponse(); 
			//Controlo los errores de parseo
			if (msg.equals("") ){
				
				Empresa empresa = empresaManager.getByPrimaryKey(1l);			
				//Valido CUIT
				if (!TestUtil.validate(empresa.getCuit())){
					String data = "El cuit enviado no esta Licenciado";
					FileUtil.createTempFile(data,  rutaSalida + nombreArchivo);
					return "Error de Licenciamiento";
				}
				
				Factura facturaActual = generateFacturaAB(feReq);
				facturaActual.setNombreArchivo(nombreArchivo);
				//Obtengo la Factura de base local
				Factura factura = facturaManager.getByArchivo(nombreArchivo);
				
				boolean facturaProcesada = false;
				//Si existe la factura en la base
				if (factura != null){
					//Si tiene CAE armo el archivo de devoluci�n
					if (factura.getCae() != null && !factura.getCae().trim().equals("")){
						facturaProcesada = true;
						msg = factura.getCae() + "|" + factura.getCae_vto() + "|" + factura.getCbt_desde() + "|" + "La factura ya se encuentra Procesada con la obtenci�n de CAE exitoso";
						//Genero Archivo de salida con los datos de la base		
						//Genero Archivo de Salida
						System.out.println("FEL: La factura ya se encuentra procesada");
						String data = ParseFactura.getOutDataFactura(factura);
						FileUtil.createTempFile(data,  rutaSalida + nombreArchivo);
						msg = "OK";
						return msg;
					} 
					factura.setImp_total(facturaActual.getImp_total());
					factura.setNro_doc(facturaActual.getNro_doc());
					factura.setPunto_vta(facturaActual.getPunto_vta());
					factura.setTipo_cbte(facturaActual.getTipo_cbte());
					factura.setFecha_cbte(facturaActual.getFecha_cbte());
					factura.setMetodoAfip("LOCAL");
					facturaManager.updateFactura(factura);					
				}else{
					try{
						//Persisto la Factura
						facturaManager.saveFactura(facturaActual);
					}catch(Exception e){
						e.printStackTrace();
					}
				}	
				if(!facturaProcesada){
					try {
						feRes = facturaManager.facturacionAFIP(feReq, empresa, null);
						
						Factura facturaUpdate1 = facturaManager.getByArchivo(nombreArchivo);
						
						facturaUpdate1.setRequestEnviado(feRes.getRequestEnviado());
						
						facturaManager.updateFactura(facturaUpdate1);
						
						
						String resultado = "";
						
						Err[] errores = feRes.getErrors();
											
						if (errores == null) {
							if (feRes.getFeDetResp() != null
									|| feRes.getFeDetResp().length > 0) {
								Obs[] observaciones = feRes.getFeDetResp()[0]
										.getObservaciones();
								if (observaciones != null) {
									int i = 0;
									for (Obs obs : observaciones) {
										System.out.println(obs.getMsg());
										if (i == 0){
											resultado = obs.getMsg();	
										}else{
											resultado = resultado + "/" + obs.getMsg();
										}
										i++;
										
									}
								}
							}
						} else {
							int i = 0;
							for (Err err : errores) {							
								if (i == 0){
									resultado = err.getMsg();	
								}else{
									resultado = resultado + "/  " + err.getMsg();
								}
								i++;
								
							}
		
						}
						
						FECAEDetResponse[] feDetalleResponseA = feRes.getFeDetResp();
						
						try{
							
							System.out.println("Nombre Empresa " + empresa.getNombre());
							
							System.out.println("Tipo de Facturacion: FEL ");
							
							System.out.println("CAE " + feDetalleResponseA[0].getCAE());
							
							System.out.println("Tipo de Comprobante " + feRes.getFeCabResp().getCbteTipo());
							
							System.out.println("Comprobante " + feDetalleResponseA[0].getCbteDesde());
							
							System.out.println("CAE Vencimiento " + feDetalleResponseA[0].getCAEFchVto());
			
							System.out.println("Prefijo " + feRes.getFeCabResp().getPtoVta());
							
							
							
						}catch(Exception e){
							//e.printStackTrace();
						}
		
						//Si no tengo un error en la obtencion
						if (feDetalleResponseA != null && feDetalleResponseA[0] != null){
							if (!feDetalleResponseA[0].getCAE().trim().equals("")){
								String comprNr = FormatUtil.llenoConCeros(String.valueOf(feDetalleResponseA[0].getCbteDesde()), 8);
								//be.updateBase(transacNr, feDetalleResponseA[0].getCAE(), feDetalleResponseA[0].getCAEFchVto(), rutaBase, comprNr);
								
								
								msg = "OK";
								//Actualizo Base Local
								Factura facturaUpdate = facturaManager.getByArchivo(nombreArchivo);
								facturaUpdate.setResultado(resultado);
								facturaUpdate.setReproceso("N");
								facturaUpdate.setCodError("");
								facturaUpdate.setCae(feDetalleResponseA[0].getCAE() );
								facturaUpdate.setCae_vto(feDetalleResponseA[0].getCAEFchVto());
								try{
									facturaUpdate.setCbt_desde(Long.parseLong(comprNr));
									facturaUpdate.setCbt_hasta(Long.parseLong(comprNr));								
								}catch(NumberFormatException ne){}
								facturaUpdate.setResultado(resultado);
								facturaUpdate.setCodError("0");
								facturaManager.updateFactura(facturaUpdate);
								
								//Genero Archivo de Salida
								String data = ParseFactura.getOutDataFactura(facturaUpdate);
								System.out.println("Mensaje Salida: " + data);
								FileUtil.createTempFile(data,  rutaSalida + nombreArchivo);
								return msg;
							}else{
								msg =  resultado;
								if (parametrizacionDAO.getByPrimaryKey(Constants.ID_ENVIA_MAIL).getValor().equals("true")){
									Long numeroInterno = 0l;
									try{
										numeroInterno = Long.parseLong(feReq.getNumeroInterno());
									}catch(Exception e){}
									sendMail(resultado, numeroInterno);
								}
							}
						}else{
							msg = resultado;
						}		
					} catch (RemoteException e) {
						e.printStackTrace();
						msg =  "No se ha podido realizar la comunicaci�n con el servidor de AFIP, cuando el sistema tenga acceso enviar� la factura automaticamente";						
						 
						try{
							Factura facturaUpdate = facturaManager.getByArchivo(nombreArchivo);	
							facturaUpdate.setCodError("10");
							facturaUpdate.setResultado(msg);
							facturaManager.updateFactura(facturaUpdate);
							//Genero Archivo de Salida
							String data = ParseFactura.getOutDataFactura(facturaUpdate);
							FileUtil.createTempFile(data,  rutaSalida + nombreArchivo);
						}catch(Exception ne){
							ne.printStackTrace();
						}
						if (parametrizacionDAO.getByPrimaryKey(Constants.ID_ENVIA_MAIL).getValor().equals("true")){
							Long numeroInterno = 0l;
							try{
								numeroInterno = Long.parseLong(feReq.getNumeroInterno());
							}catch(Exception excep){}
							sendMail(msg, numeroInterno);
						}
						return msg;						
					}catch(GenerationTimerException ge){
						ge.printStackTrace();
						msg =  "La fecha/hora informada (" + new Timestamp(System.currentTimeMillis()) + ") no es la esperada por AFIP, actualice la fecha/hora del servidor";
						FileUtil.createTempFile(msg,  rutaSalida + nombreArchivo);
						return "Error de Fecha Hora";											
					}
				}
			}else{
				msg =  feReq.getErrorFE();
			}								
		}catch(Exception e){
			e.printStackTrace();	
			msg =  "Error: " + e.getMessage();
		}	
		//Actualizo Base Local
		try{
			Factura facturaUpdate = facturaManager.getByArchivo(nombreArchivo);			
			facturaUpdate.setResultado(msg);
			facturaUpdate.setCodError("0");
			facturaManager.updateFactura(facturaUpdate);
			//Genero Archivo de Salida
			String data = ParseFactura.getOutDataFactura(facturaUpdate);
			FileUtil.createTempFile(data,  rutaSalida + nombreArchivo);
		}catch(Exception e){
			e.printStackTrace();
		}
		return msg;		
	}

	
	private String procesoFacturaABCaea(FECAEARequest feReq, String nombreArchivo){
		String msg = "";
		String rutaSalida= (parametrizacionDAO.getByPrimaryKey(Constants.ID_CARPETA_SALIDA)).getValor();
		try{

			FECAEAResponse feRes = new FECAEAResponse(); 
			//Controlo los errores de parseo
			if (msg.equals("") ){
				
				Empresa empresa = empresaManager.getByPrimaryKey(1l);			
				//Valido CUIT
				if (!TestUtil.validate(empresa.getCuit())){
					String data = "El cuit enviado no esta Licenciado";
					FileUtil.createTempFile(data,  rutaSalida + nombreArchivo);
					return "Error de Licenciamiento";
				}
				
				Factura facturaActual = generateFacturaABCaea(feReq);
				facturaActual.setNombreArchivo(nombreArchivo);
				//Obtengo la Factura de base local
				Factura factura = facturaManager.getByArchivo(nombreArchivo);
				
				boolean facturaProcesada = false;
				//Si existe la factura en la base
				if (factura != null){
					//Si tiene CAE armo el archivo de devoluci�n
					if (factura.getCae() != null && !factura.getCae().trim().equals("")){
						facturaProcesada = true;
						msg = factura.getCae() + "|" + factura.getCae_vto() + "|" + factura.getCbt_desde() + "|" + "La factura ya se encuentra Procesada con la obtenci�n de CAE exitoso";
						//Genero Archivo de salida con los datos de la base		
						//Genero Archivo de Salida
						System.out.println("FEL: La factura ya se encuentra procesada");
						String data = ParseFactura.getOutDataFactura(factura);
						FileUtil.createTempFile(data,  rutaSalida + nombreArchivo);
						msg = "OK";
						return msg;
					} 
					factura.setImp_total(facturaActual.getImp_total());
					factura.setNro_doc(facturaActual.getNro_doc());
					factura.setPunto_vta(facturaActual.getPunto_vta());
					factura.setTipo_cbte(facturaActual.getTipo_cbte());
					factura.setFecha_cbte(facturaActual.getFecha_cbte());
					factura.setMetodoAfip("LOCAL");
					facturaManager.updateFactura(factura);					
				}else{
					try{
						//Persisto la Factura
						facturaManager.saveFactura(facturaActual);
					}catch(Exception e){
						e.printStackTrace();
					}
				}	
				if(!facturaProcesada){
					try {
						feRes = facturaManager.informarComprobCaeaAFIP(feReq, empresa, null);
						
						Factura facturaUpdate1 = facturaManager.getByArchivo(nombreArchivo);
						
						//facturaUpdate1.setRequestEnviado(feRes.getRequestEnviado());
						
						facturaManager.updateFactura(facturaUpdate1);
						
						
						String resultado = "";
						
						Err[] errores = feRes.getErrors();
											
						if (errores == null) {
							if (feRes.getFeDetResp() != null
									|| feRes.getFeDetResp().length > 0) {
								Obs[] observaciones = feRes.getFeDetResp()[0]
										.getObservaciones();
								if (observaciones != null) {
									int i = 0;
									for (Obs obs : observaciones) {
										System.out.println(obs.getMsg());
										if (i == 0){
											resultado = obs.getMsg();	
										}else{
											resultado = resultado + "/" + obs.getMsg();
										}
										i++;
										
									}
								}
							}
						} else {
							int i = 0;
							for (Err err : errores) {							
								if (i == 0){
									resultado = err.getMsg();	
								}else{
									resultado = resultado + "/  " + err.getMsg();
								}
								i++;
								
							}
		
						}
						
						FECAEADetResponse[] feDetalleResponseA = feRes.getFeDetResp();
						
						try{
							
							System.out.println("Respuesta CAEA");
							
							System.out.println("Nombre Empresa " + empresa.getNombre());
							
							System.out.println("Tipo de Facturacion: FEL ");
							
							System.out.println("CAE " + feDetalleResponseA[0].getCAEA());
							
							System.out.println("Tipo de Comprobante " + feRes.getFeCabResp().getCbteTipo());
							
							System.out.println("Comprobante " + feDetalleResponseA[0].getCbteDesde());
							
			
							System.out.println("Prefijo " + feRes.getFeCabResp().getPtoVta());
							
							
							
						}catch(Exception e){
							//e.printStackTrace();
						}
		
						//Si no tengo un error en la obtencion
						if (feDetalleResponseA != null && feDetalleResponseA[0] != null){
							if (!feDetalleResponseA[0].getCAEA().trim().equals("")){
								String comprNr = FormatUtil.llenoConCeros(String.valueOf(feDetalleResponseA[0].getCbteDesde()), 8);
								//be.updateBase(transacNr, feDetalleResponseA[0].getCAE(), feDetalleResponseA[0].getCAEFchVto(), rutaBase, comprNr);
								
								
								msg = "OK";
								//Actualizo Base Local
								Factura facturaUpdate = facturaManager.getByArchivo(nombreArchivo);
								facturaUpdate.setResultado(resultado);
								facturaUpdate.setReproceso("N");
								facturaUpdate.setCodError("");
								facturaUpdate.setCae(feDetalleResponseA[0].getCAEA() );
								//facturaUpdate.setCae_vto(feDetalleResponseA[0].getCAEFchVto());
								try{
									facturaUpdate.setCbt_desde(Long.parseLong(comprNr));
									facturaUpdate.setCbt_hasta(Long.parseLong(comprNr));								
								}catch(NumberFormatException ne){}
								facturaUpdate.setResultado(resultado);
								facturaUpdate.setCodError("0");
								facturaManager.updateFactura(facturaUpdate);
								
								//Genero Archivo de Salida
								String data = ParseFactura.getOutDataFactura(facturaUpdate);
								System.out.println("Mensaje Salida: " + data);
								FileUtil.createTempFile(data,  rutaSalida + nombreArchivo);
								return msg;
							}else{
								msg =  resultado;
								if (parametrizacionDAO.getByPrimaryKey(Constants.ID_ENVIA_MAIL).getValor().equals("true")){
									Long numeroInterno = 0l;
									try{
										numeroInterno = Long.parseLong(feReq.getNumeroInterno());
									}catch(Exception e){}
									sendMail(resultado, numeroInterno);
								}
							}
						}else{
							msg = resultado;
						}		
					} catch (RemoteException e) {
						e.printStackTrace();
						msg =  "No se ha podido realizar la comunicaci�n con el servidor de AFIP, cuando el sistema tenga acceso enviar� la factura automaticamente";						
						 
						try{
							Factura facturaUpdate = facturaManager.getByArchivo(nombreArchivo);	
							facturaUpdate.setCodError("10");
							facturaUpdate.setResultado(msg);
							facturaManager.updateFactura(facturaUpdate);
							//Genero Archivo de Salida
							String data = ParseFactura.getOutDataFactura(facturaUpdate);
							FileUtil.createTempFile(data,  rutaSalida + nombreArchivo);
						}catch(Exception ne){
							ne.printStackTrace();
						}
						if (parametrizacionDAO.getByPrimaryKey(Constants.ID_ENVIA_MAIL).getValor().equals("true")){
							Long numeroInterno = 0l;
							try{
								numeroInterno = Long.parseLong(feReq.getNumeroInterno());
							}catch(Exception excep){}
							sendMail(msg, numeroInterno);
						}
						return msg;						
					}catch(GenerationTimerException ge){
						ge.printStackTrace();
						msg =  "La fecha/hora informada (" + new Timestamp(System.currentTimeMillis()) + ") no es la esperada por AFIP, actualice la fecha/hora del servidor";
						FileUtil.createTempFile(msg,  rutaSalida + nombreArchivo);
						return "Error de Fecha Hora";											
					}
				}
			}else{
				msg =  feReq.getErrorFE();
			}								
		}catch(Exception e){
			e.printStackTrace();	
			msg =  "Error: " + e.getMessage();
		}	
		//Actualizo Base Local
		try{
			Factura facturaUpdate = facturaManager.getByArchivo(nombreArchivo);			
			facturaUpdate.setResultado(msg);
			facturaUpdate.setCodError("0");
			facturaManager.updateFactura(facturaUpdate);
			//Genero Archivo de Salida
			String data = ParseFactura.getOutDataFactura(facturaUpdate);
			FileUtil.createTempFile(data,  rutaSalida + nombreArchivo);
		}catch(Exception e){
			e.printStackTrace();
		}
		return msg;		
	}


	
	public Factura getFacturaById(Long idFactura) {
		return facturaManager.getFacturaById(idFactura);
	}

	
	public String getCotizacionByMoneda(String moneda) throws Exception {
		
		Empresa empresa = empresaManager.getByPrimaryKey(1l);			

		FECotizacionResponse cotizacionResponse =  facturaManager.getCotizacion(moneda, empresa);
		
		String resultado = "";
		
		if (cotizacionResponse != null){
			Err[] errores = cotizacionResponse.getErrors();
			
			if (errores != null) {		
				int i = 0;
				for (Err err : errores) {							
					if (i == 0){
						resultado = err.getMsg();	
					}else{
						resultado = resultado + "/  " + err.getMsg();
					}
					i++;				
				}
			}else{
				Cotizacion cot = cotizacionResponse.getResultGet();
				resultado = String.valueOf(cot.getMonCotiz());
			}
			
		}		
		return resultado;
	}

	public byte[] getFactura(long cbteNroLong, int cbteTipoInt, int prefijoInt) {
		
		Empresa empresa = empresaManager.getByPrimaryKey(1l);
		
		byte[] result = null;
		
		try {
			result = facturaManager.getFactura(cbteNroLong, cbteTipoInt, prefijoInt, empresa);
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		return result;
	}

	
	private FECompConsultaResponse getComprobanteByPrimary(long cbteNroLong, int cbteTipoInt, int prefijoInt) throws Exception {
		
		Empresa empresa = empresaManager.getByPrimaryKey(1l);
		
		FECompConsultaResponse feReqResponse= null;
		
		feReqResponse = facturaManager.getComprobanteByPrimary(cbteNroLong, cbteTipoInt, prefijoInt, empresa);
		
		return feReqResponse;
	}
	
	public long getLastNroCompr(int prefijoInt, int cbteTipoInt)
			throws Exception {
		Empresa empresa = empresaManager.getByPrimaryKey(1l);
		return facturaManager.getLastNroFacturaByPyC(prefijoInt,cbteTipoInt,empresa);
	}

	private List<File> filterCarpetas(File[] listadoCarpeta, String fecha){
		List<File> listFolders = new ArrayList<File>();
		Long fechaEquipo = 0l;
		Long fechaHoy = 0l;
		try{
			fechaEquipo = Long.parseLong(fecha);
			fechaHoy = Long.parseLong(DateUtil.getCanonicalFech(new Date(System.currentTimeMillis())));
		}catch(NumberFormatException ne){
			ne.printStackTrace();
			return listFolders;
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(File carpeta : listadoCarpeta){
			Long fechaCarpeta = 0l; 
			try{
				fechaCarpeta = Long.parseLong(carpeta.getName());
				if(fechaCarpeta > fechaEquipo && fechaCarpeta < fechaHoy){
					listFolders.add(carpeta);
				}
			}catch(NumberFormatException ne){
				ne.printStackTrace();				
			}

		}
		
		
		return listFolders;
	}
	
	public void getImageCheque() {
		//Obtener PC que tengo que ir a buscar archivos
		List<EquipoImagen> listEquipoImagen = equipoImagenDAO.getAll(); 
		
		//Hago un loop para obtener imagen de cada PC
			boolean termino = false;
			for(EquipoImagen equipo : listEquipoImagen){							
				if (equipo.getProcesando() == 0){
					
					String carpetaFechasUltima = "";
					File carpeta = new File("//" + equipo.getIp() + "//" + equipo.getCarpeta() + "//");				
					if (carpeta.exists()){
						//System.out.println("OK");
						//Listo las carpetas
						File[] carpetas = carpeta.listFiles();
						List<File> listCarpetas = filterCarpetas(carpetas, equipo.getFecha());
						for(File carpetaFechas : listCarpetas){
							if(carpetaFechas.getName().indexOf("read") == -1){
								if(carpetaFechas.isDirectory()){
									carpetaFechasUltima = carpetaFechas.getName();
									File[] imagenes = carpetaFechas.listFiles();
									for(File imagen:imagenes){
										//Obtengo la Imagen
										equipo.setProcesando(1);
										equipoImagenDAO.update(equipo);										
										System.out.println(imagen.getAbsolutePath());
										if (FileUtil.parseExtension(imagen.getName()).equalsIgnoreCase("tif")){										
											//Convierto la Imagen
											try {
												byte[] cara = null;//FormatUtil.convertJPG(imagen.getAbsoluteFile().toString(),0);
												
												byte[] contraCara = null;//FormatUtil.convertJPG(imagen.getAbsoluteFile().toString(),1);
												
												byte[] cheque = FormatUtil.mergeJPG(cara, contraCara);
												
												//Guardo la Imagen en la base de Datos
												String servidor = parametrizacionDAO.getByPrimaryKey(Constants.TESO_SERVIDOR).getValor();
												String base = parametrizacionDAO.getByPrimaryKey(Constants.TESO_BASE).getValor();
												String usr = parametrizacionDAO.getByPrimaryKey(Constants.TESO_USR).getValor();
												String pass = parametrizacionDAO.getByPrimaryKey(Constants.TESO_PASS).getValor();
												String tabla = parametrizacionDAO.getByPrimaryKey(Constants.TESO_TABLA).getValor();
												String campoPK = parametrizacionDAO.getByPrimaryKey(Constants.TESO_CAMPO_PK).getValor();
												
												//BaseExternaTeso bet = new BaseExternaTeso();
												String clave = FileUtil.parseNameFile(imagen.getName());
												try{
													clave = clave.substring(0, 29);	
												}catch(Exception e){
													e.printStackTrace();
												}
												//String clave = "";
												BaseExternaTeso.saveImage(clave, 0, cheque, servidor, base, usr, pass, tabla, campoPK);									
												//BaseExternaTeso.saveImage(clave, 1, contraCara, servidor, base, usr, pass, tabla, campoPK);									
												termino = true;
											} catch (Exception e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
										
										}									
									}
									
									
								}
								
							}
							equipo.setFecha(carpetaFechasUltima);
							equipoImagenDAO.update(equipo);
						}
						equipo.setProcesando(0);
						equipoImagenDAO.update(equipo);					
					}						
					
				}
			}
	}

	
	public byte[] getByteImageCheques(String chequeNr, int parte) {
		String servidor = parametrizacionDAO.getByPrimaryKey(Constants.TESO_SERVIDOR).getValor();
		String base = parametrizacionDAO.getByPrimaryKey(Constants.TESO_BASE).getValor();
		String usr = parametrizacionDAO.getByPrimaryKey(Constants.TESO_USR).getValor();
		String pass = parametrizacionDAO.getByPrimaryKey(Constants.TESO_PASS).getValor();
		String tabla = parametrizacionDAO.getByPrimaryKey(Constants.TESO_TABLA).getValor();
		String campoPK = parametrizacionDAO.getByPrimaryKey(Constants.TESO_CAMPO_PK).getValor();
		Usuario usrStr = usuarioDAO.getByPrimaryKey(1l);
		byte[] imagen = BaseExternaTeso.getImageCheque(usrStr.getChequeNr(), usrStr.getParte(), servidor, base, usr, pass, tabla, campoPK);
		return imagen;				
	}


	public void setChequeNr(String chequeNr, Integer parte) {
		Usuario usr = usuarioDAO.getByPrimaryKey(1l);
		usr.setChequeNr(chequeNr);
		usr.setParte(parte);
		usuarioDAO.update(usr);		
	}

	public void procesarFacturaByFilesExpov1() {
		String msg = "";
		try{

			String rutaProvisorio = (parametrizacionDAO.getByPrimaryKey(Constants.ID_CARPETA_PROVISORIO_EXPOV1)).getValor();
			String rutaDefinitivo = (parametrizacionDAO.getByPrimaryKey(Constants.ID_CARPETA_DEFINITIVO_EXPOV1)).getValor();
			
			Empresa em = empresaManager.getByPrimaryKey(1l);
			
			//System.out.println("rutaProvisorioDesa " + rutaProvisorio);
			//System.out.println("rutaDefinitivoDesa " + rutaDefinitivo);

			FECAEResponse feRes = new FECAEResponse(); 
			FECAERequest feReq = new FECAERequest();

			File dir = new File(rutaProvisorio);
			
			File[] files = dir.listFiles();
	        
	        int countFiles = files.length;        
			int i = 0;
				        
	        while(i < countFiles){
		        if (files[i].isFile()){
		        	if(files[i].canWrite()){                                    
		                try{                
		                    if (files[i].getName().startsWith("A")){
		                        // Borro cualquier archivo con el mismo nombre en el destino
		                        File borrado = new File(rutaDefinitivo+files[i].getName());
		                        borrado.delete();
		                        // muevo el archivo                              
		                        File fileDestino = new File(rutaDefinitivo+files[i].getName());
		                        FileUtil.copy(files[i], fileDestino);
		                        files[i].delete();
		                        //String userRentas = this.getUserRentas(fileDestino);
		                        ClsFEXRequest feReqInt = ParseFacturaExpo.parseFacturaE(fileDestino.getAbsolutePath());
		                        //Proceso la Factura
		                        procesoFacturaExpov1(feReqInt, fileDestino.getName());
		                        		                     }   	    
		                    }catch (Exception exp){
			                	exp.printStackTrace();
		                }
		                    
		        	}                
		        }else{
		        	i++;
		        }
		        
			}
		}catch(Exception exception){
			exception.printStackTrace();
		}		
	}



	private String procesoFacturaExpov1(ClsFEXRequest feReq, String nombreArchivo){
		String msg = "";
		String rutaSalida= (parametrizacionDAO.getByPrimaryKey(Constants.ID_CARPETA_SALIDA_EXPOV1)).getValor();
		try{

			FEXResponseAuthorize feRes = new FEXResponseAuthorize(); 
			//Controlo los errores de parseo
			if (msg.equals("") ){
				
				Empresa empresa = empresaManager.getByPrimaryKey(2l);			
				//Valido CUIT
				if (!TestUtil.validateExpo(empresa.getCuit())){
					String data = "El cuit enviado no esta Licenciado";
					FileUtil.createTempFile(data,  rutaSalida + nombreArchivo);
					return "Error de Licenciamiento";
				}
				
				Factura facturaActual = generateFacturaE(feReq);
				facturaActual.setNombreArchivo(nombreArchivo);
				//Obtengo la Factura de base local
				Factura factura = facturaManager.getByArchivo(nombreArchivo);
				
				boolean facturaProcesada = false;
				//Si existe la factura en la base
				if (factura != null){
					//Si tiene CAE armo el archivo de devoluci�n
					if (factura.getCae() != null && !factura.getCae().trim().equals("")){
						facturaProcesada = true;
						//msg = factura.getCae() + "|" + factura.getCae_vto() + "|" + factura.getCbt_desde() + "|" + "La factura ya se encuentra Procesada con la obtenci�n de CAE exitoso";
						//Genero Archivo de salida con los datos de la base			
						System.out.println("FEX: La factura ya se encuentra procesada");
						String data = ParseFacturaExpo.getOutDataFactura(factura);
						FileUtil.createTempFile(data,  rutaSalida + nombreArchivo);
						msg = "OK";
						return msg;
					} 
					factura.setImp_total(facturaActual.getImp_total());
					factura.setNro_doc(facturaActual.getNro_doc());
					factura.setPunto_vta(facturaActual.getPunto_vta());
					factura.setTipo_cbte(facturaActual.getTipo_cbte());
					factura.setFecha_cbte(facturaActual.getFecha_cbte());
					factura.setMetodoAfip("EXPO");
					facturaManager.updateFactura(factura);					
				}else{
					try{
						//Persisto la Factura
						facturaManager.saveFactura(facturaActual);
					}catch(Exception e){
						e.printStackTrace();
					}
				}	
				if(!facturaProcesada){
					try {
						feRes = facturaManager.facturacionEAFIPExpo(feReq, empresa);
						
						Factura facturaUpdate1 = facturaManager.getByArchivo(nombreArchivo);
						
						facturaUpdate1.setRequestEnviado(feRes.getRequestEnviado());
						
						facturaManager.updateFactura(facturaUpdate1);
						
						
						String resultado = "";
						
						resultado = feRes.getFEXErr().getErrMsg().trim() + "/" + feRes.getFEXErr().getErrCode() + "/" +feRes.getFEXEvents().getEventMsg();						
						
						if (feRes.getFEXResultAuth() != null){
							
							System.out.println("Nombre Empresa " + empresa.getNombre());
							
							System.out.println("Tipo de Facturacion: FEX ");
							
							System.out.println("EXPO v1 : Repuesta - CAE: " + feRes.getFEXResultAuth().getCae());
							
							System.out.println("EXPO v1 : Repuesta - Reproceso: " + feRes.getFEXResultAuth().getReproceso());
							
							System.out.println("EXPO v1 : Repuesta - Vencimiento CAE: " + feRes.getFEXResultAuth().getFch_venc_Cae());
						
						}
			
						if (feRes.getFEXResultAuth() != null){
							String comprNr = FormatUtil.llenoConCeros(String.valueOf(feRes.getFEXResultAuth().getCbte_nro()), 8);
							msg="OK";
							//Actualizo Base Local						
							Factura facturaUpdate = facturaManager.getByArchivo(nombreArchivo);
							facturaUpdate.setCae(feRes.getFEXResultAuth().getCae());
							facturaUpdate.setCae_vto(feRes.getFEXResultAuth().getFch_venc_Cae());
							try{
								facturaUpdate.setCbt_desde(Long.parseLong(comprNr));
								facturaUpdate.setCbt_hasta(Long.parseLong(comprNr));								
							}catch(NumberFormatException ne){}
							facturaUpdate.setResultado(resultado);
							facturaUpdate.setIdAfip(String.valueOf(feReq.getId()));
							facturaUpdate.setCodError("0");
							facturaManager.updateFactura(facturaUpdate);
							//Genero Archivo de Salida
							String data = ParseFacturaExpo.getOutDataFactura(facturaUpdate);
							FileUtil.createTempFile(data,  rutaSalida + nombreArchivo);

							return msg;
						}else{
							msg =  resultado;
						}
						try{
							Factura facturaUpdate = facturaManager.getByArchivo(nombreArchivo);			
							facturaUpdate.setResultado(msg);
							facturaUpdate.setCodError("0");
							facturaManager.updateFactura(facturaUpdate);
							//Genero Archivo de Salida
							String data = ParseFactura.getOutDataFactura(facturaUpdate);
							FileUtil.createTempFile(data,  rutaSalida + nombreArchivo);
						}catch(Exception e){
							e.printStackTrace();
						}
						
		
					} catch (RemoteException e) {
						e.printStackTrace();
						msg = "No se ha podido realizar la comunicaci�n con el servidor de AFIP, cuando el sistema tenga acceso enviar� la factura automaticamente";
						//Hay que cargar la factura el la cola para volver a cargarla
						try{
							Factura facturaUpdate = facturaManager.getByArchivo(nombreArchivo);			
							facturaUpdate.setResultado(msg);
							facturaUpdate.setCodError("10");
							facturaManager.updateFactura(facturaUpdate);
							//Genero Archivo de Salida
							String data = ParseFactura.getOutDataFactura(facturaUpdate);
							FileUtil.createTempFile(data,  rutaSalida + nombreArchivo);
						}catch(Exception ep){
							ep.printStackTrace();
						}
						return msg;	
					}catch(GenerationTimerException ge){
						ge.printStackTrace();
						msg =  "La fecha/hora informada (" + new Timestamp(System.currentTimeMillis()) + ") no es la esperada por AFIP, actualice la fecha/hora del servidor";
						try{
							Factura facturaUpdate = facturaManager.getByArchivo(nombreArchivo);			
							facturaUpdate.setResultado(msg);
							facturaUpdate.setCodError("0");
							facturaManager.updateFactura(facturaUpdate);
							//Genero Archivo de Salida
							String data = ParseFactura.getOutDataFactura(facturaUpdate);
							FileUtil.createTempFile(data,  rutaSalida + nombreArchivo);
						}catch(Exception e){
							e.printStackTrace();
						}
					}catch (Exception e) {
						e.printStackTrace();
						msg =  "Existe alg�n dato que no se corresponde con el tipo de dato requerido";
						try{
							Factura facturaUpdate = facturaManager.getByArchivo(nombreArchivo);			
							facturaUpdate.setResultado(msg);
							facturaUpdate.setCodError("0");
							facturaManager.updateFactura(facturaUpdate);
							//Genero Archivo de Salida
							String data = ParseFactura.getOutDataFactura(facturaUpdate);
							FileUtil.createTempFile(data,  rutaSalida + nombreArchivo);
						}catch(Exception ej){
							ej.printStackTrace();
						}
					}
				}
			}else{
				msg =  feReq.getErrorParceso();
			}	
						
		}catch(Exception e){
			e.printStackTrace();	
			msg =  "Error: " + e.getMessage();
		}	
		//Actualizo Base Local
		
		System.out.println("EXPOV1 : Comprobante : " + feReq.getCbte_nro());
		System.out.println("EXPOV1 : Resultado: " + msg);
		return msg;		
	}

	public String getCotizacionExpoByMoneda(String moneda) {
		
		Empresa empresa = empresaManager.getByPrimaryKey(2l);			

		FEXResponse_Ctz cotizacionResponse = null;
		try {
			cotizacionResponse = facturaManager.getCotizacionExpo(moneda, empresa);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String resultado = "";
		
		if (cotizacionResponse != null){
			String errores = cotizacionResponse.getFEXErr().getErrMsg();
			
			if (errores != null && !errores.equals("OK")) {		
				resultado = errores;
			}else{
				ClsFEXResponse_Ctz cot = cotizacionResponse.getFEXResultGet();
				resultado = String.valueOf(cot.getMon_ctz());
			}
			
		}		
		return resultado;
	}

	public long getLastNroComprExpo(int prefijoInt, int cbteTipoInt){
		Empresa empresa = empresaManager.getByPrimaryKey(2l);
		Long result = 0l;
		try {
			result = facturaManager.getLastNroFacturaByPyCExpo(prefijoInt,cbteTipoInt,empresa);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return result;
	}

	public byte[] getFacturaExpo(long cbteNroLong, int cbteTipoInt,
			int prefijoInt) {
		Empresa empresa = empresaManager.getByPrimaryKey(2l);
		
		byte[] result = null;
		
		try {
			result = facturaManager.getFacturaExpo(cbteNroLong, cbteTipoInt, prefijoInt, empresa);
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		return result;
	}

	public String getEstadoAfipExpo() {
		Empresa empresa = empresaManager.getByPrimaryKey(2l);
		
		String result = facturaManager.getEstadoAfipExpo(empresa);

		return result;
	}

	public List<Viajes> getViajesSinCot(Usuario usuario) {

		EmpresaC empresaC = empresaCDAO.getByPrimaryKey(usuario.getIdEmpresaC());
		
		String user = parametrizacionDAO.getByPrimaryKey(Constants.ID_USR_SQL).getValor();
		String password = parametrizacionDAO.getByPrimaryKey(Constants.ID_PASSWORD_SQL).getValor();
		//String servidor = parametrizacionDAO.getByPrimaryKey(Constants.ID_SERVIDOR).getValor();
		String servidor = empresaC.getIpserverBase();
		//Long viajeInicio = Long.parseLong(parametrizacionDAO.getByPrimaryKey(Constants.ID_VIAJE_INICIO).getValor());
		Long viajeInicio = empresaC.getViajeInicio();
		String controlador = "net.sourceforge.jtds.jdbc.Driver";
//		String baseEmpresa = parametrizacionDAO.getByPrimaryKey(Constants.ID_BASE_EMPRESA_COT).getValor();
//		String baseComun = parametrizacionDAO.getByPrimaryKey(Constants.ID_BASE_COMUN).getValor();
//		String baseStock = parametrizacionDAO.getByPrimaryKey(Constants.ID_BASE_STOCK).getValor();
		String baseEmpresa = empresaC.getBaseViajes();
		String baseComun = empresaC.getBaseComun();
		String baseStock = empresaC.getBaseStock();
		
		BaseExternaCot bec = new BaseExternaCot(controlador,"jdbc:jtds:sqlserver://"+servidor+":1433/"+baseEmpresa, user, password,baseComun,baseEmpresa,baseStock); 
		
		List<Viajes> viajes = bec.getViajesSinCot(viajeInicio);
		
		for(Viajes viaje: viajes){
			String carpetaSalida = parametrizacionDAO.getByPrimaryKey(Constants.ID_CARPETA_SALIDA).getValor();
			File file = new File(carpetaSalida +System.getProperty("file.separator") + viaje.getViajeNr() + ".pdf");
			if (file != null && file.exists()){
				viaje.setProcesado(true);
			}
		}
		
		//Tengo que ver si hay un archivo para Descargar
		
		
		return viajes;
	}

	public String autorizarViaje(int viajeNr, Usuario usuario, Patente patente) {

		String result = "OK";
		EmpresaC empresaC = empresaCDAO.getByPrimaryKey(usuario.getIdEmpresaC());
		
		patente = extendedPatenteDAO.getByPrimaryKey(patente.getIdPatente());
		
		//String cuit = parametrizacionDAO.getByPrimaryKey(Constants.ID_CUIT_COT).getValor();
		String cuit = empresaC.getCuitCot().toString();
		String user = parametrizacionDAO.getByPrimaryKey(Constants.ID_USR_SQL).getValor();
		String password = parametrizacionDAO.getByPrimaryKey(Constants.ID_PASSWORD_SQL).getValor();
		String servidor = empresaC.getIpserverBase();
		//String servidor = parametrizacionDAO.getByPrimaryKey(Constants.ID_SERVIDOR).getValor();
		String controlador = "net.sourceforge.jtds.jdbc.Driver";
//		String baseEmpresa = parametrizacionDAO.getByPrimaryKey(Constants.ID_BASE_EMPRESA_COT).getValor();
//		String baseComun = parametrizacionDAO.getByPrimaryKey(Constants.ID_BASE_COMUN).getValor();
//		String baseStock = parametrizacionDAO.getByPrimaryKey(Constants.ID_BASE_STOCK).getValor();
//		
		String baseEmpresa = empresaC.getBaseViajes();
		String baseComun = empresaC.getBaseComun();
		String baseStock = empresaC.getBaseStock();
		BaseExternaCot bec = new BaseExternaCot(controlador,"jdbc:jtds:sqlserver://"+servidor+":1433/"+baseEmpresa, user, password,baseComun,baseEmpresa,baseStock); 

		String nombreArchivo = "";
		try {
			//Armo el nombre del archivo
			//Pido el Cuit de la empresa 
			
			
			String viajeNrStr = String.valueOf(viajeNr);
			//Saco el �ltimo valor de la empresa
			int tamano = viajeNrStr.length();
			viajeNrStr = viajeNrStr.substring(0,tamano -1);
			if (viajeNrStr.length() > 6){
				viajeNrStr.substring(0,5);
			}
			viajeNrStr = FormatUtil.llenoConCeros(viajeNrStr, 6);
			nombreArchivo = "TB_" + cuit + "_001001_" + DateUtil.getCanonicalFech(new Date(System.currentTimeMillis())) + "_" + viajeNrStr + ".txt";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String razonSocial = empresaC.getRazonSocial();

		String calle = empresaC.getCalle();
		
		String numero = empresaC.getNumero();
		
		String localidad = empresaC.getLocalidad();	
		
		String passCot = empresaC.getPass();	
		
		List<String> list = bec.getLineasFileCot(viajeNr, cuit, razonSocial, calle,numero,localidad,patente.getValor());
		
		for(String s:list){
			System.out.println(s);
		}
		//ParamConnRentas paramConnRentas, String passwordRentas,File fileB
		
		String carpetaEntrada = parametrizacionDAO.getByPrimaryKey(Constants.ID_CARPETA_ENTRADA).getValor();
		
		File fileB = FileUtil.generateFile(carpetaEntrada, nombreArchivo, list);
		
		CotManager cotManager = new CotManagerImpl(buildParamConnRentas(),passCot,fileB, cuit);
		
		List<String> listS = cotManager.getCot();
		
		String carpetaSalida = parametrizacionDAO.getByPrimaryKey(Constants.ID_CARPETA_SALIDA).getValor();
		
		try {
	            
			//new ByteArrayInputStream( builder.toString().getBytes("UTF-8") );
			String xml = "";
			boolean empezo = false;
			for(String s:listS){
            	
            	if (s.startsWith("<?xml version='1.0'"))
					empezo = true;
            	if (empezo)
            	xml = xml + s;
            	
    		}
			String nombreArchivoPdf = carpetaSalida +System.getProperty("file.separator") + viajeNr + ".pdf";
			
			JAXBContext jaxbContext;
			try {
				jaxbContext = JAXBContext.newInstance(RespuestaAfip.class);
			
	 
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			//Pregunto si tiene un error y si fue procesado con Anterioridad
			if (xml.indexOf("<TBError>") != -1){
				if (xml.indexOf("<codigoError>11</codigoError>") != -1){
					result = "El archivo recibido ya fue procesado con anterioridad.";
				}else{
					result = "Existe un error en la transmisi�n del Archivo.";
				}
			}else{
				RespuestaAfip ra = (RespuestaAfip) jaxbUnmarshaller.unmarshal(new ByteArrayInputStream( xml.getBytes("UTF-8") ));
				SerializateUtil.generateRemitoPdf(ra, nombreArchivoPdf );
			}
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        } catch (Exception e) {

	            e.printStackTrace();
	        }
		
		
		
		return result;
	}
	
	private ParamConnRentas buildParamConnRentas() {
	   	ParamConnRentas paramConnRentas = new ParamConnRentas();
	   	paramConnRentas.setFolderEntrada((parametrizacionDAO.getByPrimaryKey(Constants.ID_CARPETA_ENTRADA)).getValor());
    	paramConnRentas.setHost((parametrizacionDAO.getByPrimaryKey(Constants.ID_HOST)).getValor());
		paramConnRentas.setProxyPort(Integer.parseInt((parametrizacionDAO.getByPrimaryKey(Constants.ID_PROXY_PORT)).getValor()));
		paramConnRentas.setProxyUrl((parametrizacionDAO.getByPrimaryKey(Constants.ID_PROXY_URL)).getValor());
		paramConnRentas.setUrlApp((parametrizacionDAO.getByPrimaryKey(Constants.ID_URL_APP)).getValor());
		paramConnRentas.setUrlPort(Integer.parseInt((parametrizacionDAO.getByPrimaryKey(Constants.ID_URL_PORT)).getValor()));
		paramConnRentas.setUseProxy((parametrizacionDAO.getByPrimaryKey(Constants.ID_USE_PROXY)).getValor());
		paramConnRentas.setKeystoreJREPassword((parametrizacionDAO.getByPrimaryKey(Constants.ID_KEYSTORE_PASS)).getValor());
		return paramConnRentas;
	}

	public byte[] getRemito(Integer viajeNr) {
		String carpetaSalida = parametrizacionDAO.getByPrimaryKey(Constants.ID_CARPETA_SALIDA).getValor();
		File file = new File(carpetaSalida +System.getProperty("file.separator") + viajeNr + ".pdf");
		byte[] bytes = null;
		try {
			bytes = FileUtil.getBytesFromFile(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bytes;
	}

	public List<Patente> getPatenteAllOrden() {
		return extendedPatenteDAO.getAllOrder();
	}

	public void deletePatente(Patente patenteOrig) {

		Patente patente = extendedPatenteDAO.getByPrimaryKey(patenteOrig.getIdPatente());
		
		extendedPatenteDAO.remove(patente);
	}

	public void addPatente(Patente patente) {
		
		extendedPatenteDAO.save(patente);
		
	}

	@Override
	public void procesarFileFacturaError() {
		List<Factura> facturas = facturaManager.getFacturasConErrorConn();
		if (facturas != null && facturas.size() > 0){
			for(Factura factura: facturas){
				try{
					
					if (factura.getCae() == null
							|| factura.getCae().trim().equals("")) {
						
						//Copio el Archivo que se encuentra en la carpeta Definitivo en la carpeta provisorio
						File fileProvisorio = new File(parametrizacionDAO.getByPrimaryKey(Constants.ID_CARPETA_PROVISORIO).getValor() + factura.getNombreArchivo() );
						File fileDefinitivo = new File(parametrizacionDAO.getByPrimaryKey(Constants.ID_CARPETA_DEFINITIVO).getValor() + factura.getNombreArchivo() );
						
						try {
							FileUtil.copy(fileDefinitivo, fileProvisorio);
						} catch (IOException e) {
							e.printStackTrace();
						}
						try {
							Thread.sleep(15000l);
						} catch (InterruptedException e) {
							
							e.printStackTrace();
						}
						
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				
			}
		}
		
		
		
	}
	
	
	
	public void procesarFileFacturaError_v1() {
		//System.out.println("Ingresp a Manager de facturas");
		List<Factura> facturas = facturaManager.getFacturasConErrorConn();
		if (facturas != null && facturas.size() > 0){
			for(Factura factura: facturas){
				try{
					
					if (factura.getCae() == null
							|| factura.getCae().trim().equals("")) {
						
						//Copio el Archivo que se encuentra en la carpeta Definitivo en la carpeta provisorio
						File fileProvisorio = null;
						File fileDefinitivo = null;

						if (factura.getMetodoAfip() != null && factura.getMetodoAfip().equals("EXPO")){
							fileProvisorio = new File(parametrizacionDAO.getByPrimaryKey(Constants.ID_CARPETA_PROVISORIO_EXPOV1).getValor() + factura.getNombreArchivo() );
							fileDefinitivo = new File(parametrizacionDAO.getByPrimaryKey(Constants.ID_CARPETA_DEFINITIVO_EXPOV1).getValor() + factura.getNombreArchivo() );							
						}else{
							fileProvisorio = new File(parametrizacionDAO.getByPrimaryKey(Constants.ID_CARPETA_PROVISORIO).getValor() + factura.getNombreArchivo() );
							fileDefinitivo = new File(parametrizacionDAO.getByPrimaryKey(Constants.ID_CARPETA_DEFINITIVO).getValor() + factura.getNombreArchivo() );
						}
						
						try {
							FileUtil.copy(fileDefinitivo, fileProvisorio);
						} catch (IOException e) {
							e.printStackTrace();
						}
						try {
							Thread.sleep(30000l);
						} catch (InterruptedException e) {
							
							e.printStackTrace();
						}
						
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				
			}
		}
	}


	public String getFacturacionAFIP(String punto_vta,
			String rutaBaseFactuAfip, String cte_desde, String cte_hasta,
			String tipo_comprobante) {
		Empresa empresa = empresaManager.getByPrimaryKey(1l);
		
		try{
			//Loop de los numeros de comprobantes
			long cte_desde_ = Long.parseLong(cte_desde);
			long cte_hasta_ = Long.parseLong(cte_hasta);
			int tipo_comp_ = Integer.parseInt(tipo_comprobante);
			int prefijo_ = Integer.parseInt(punto_vta);
			if (cte_desde_ <= cte_hasta_){
				//Clasifico la Factura
				BaseExterna be = null;
				int ubicador = rutaBaseFactuAfip.indexOf("|");  
				if (ubicador == -1){
					//rutaBase = "[" + rutaBase+ "]";
					be = new BaseExterna("sun.jdbc.odbc.JdbcOdbcDriver","jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=@rutaBase");
				}else{					
					String servidor = rutaBaseFactuAfip.substring(0, ubicador);
					String base = rutaBaseFactuAfip.substring(ubicador +1);
					//rutaBase = "[" + rutaBaseOrig + "]" + ".dbo";
					String user = parametrizacionDAO.getByPrimaryKey(Constants.ID_USR_SQL).getValor();
					String password = parametrizacionDAO.getByPrimaryKey(Constants.ID_PASSWORD_SQL).getValor();
					be = new BaseExterna("net.sourceforge.jtds.jdbc.Driver","jdbc:jtds:sqlserver://"+servidor+":1433/"+base, user, password);					
				}
				
				 
				long dif = cte_hasta_ - cte_desde_;
				//delete Base
				be.deleteFactuAfip(rutaBaseFactuAfip);
				for(int j = 0; j < dif; j++){
					long cte_ = cte_desde_ + j;
					FECompConsultaResponse feResponse = facturaManager.getComprobanteByPrimary(cte_, tipo_comp_, prefijo_, empresa);
					System.out.println("ss");
					if (feResponse != null && feResponse.getErrors() == null){
						//System.out.println(feResponse.getResultGet().getCodAutorizacion());
						System.out.println("GRAOB");
						be.updateSetFacturacion(feResponse,rutaBaseFactuAfip);
					}
				}				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "OK";
	}

	
	public String getCaea(String periodo, String quincena, Empresa empresa) {
		FECAEAGetResponse response = facturaManager.getCaea(periodo,  quincena,  empresa);
		if (response != null && response.getErrors() == null){
			//System.out.println(feResponse.getResultGet().getCodAutorizacion());
			Caea caea = new Caea();
			caea.setFchVigDesde(response.getResultGet().getFchVigDesde());
			caea.setFchVigHasta(response.getResultGet().getFchVigHasta());
			caea.setEmpresa(empresa);
			caea.setPeriodo((response.getResultGet().getPeriodo()));
			caea.setCAEA(response.getResultGet().getCAEA());
			caea.setOrden(Integer.parseInt(response.getResultGet().getOrden()+""));
			caea.setFchProceso(response.getResultGet().getFchProceso());
			caeaDAO.save(caea);
			//Genero archivo de salida
			FileUtil.createTempFile(response.getResultGet().getCAEA(), empresa.getPath_file_caea());
			if (empresa.getLibAS400() != null){
				String sistema = parametrizacionDAO.getByPrimaryKey(Constants.ID_SISTEMA).getValor();
				String bibliotecaGeneric = parametrizacionDAO.getByPrimaryKey(Constants.ID_BASE_GENERIC).getValor();
				String usrAs = parametrizacionDAO.getByPrimaryKey(Constants.ID_USR_AS).getValor();
				String passAs = parametrizacionDAO.getByPrimaryKey(Constants.ID_PASS_AS).getValor();
				
				BaseExternaAS be = new BaseExternaAS("com.ibm.as400.access.AS400JDBCDriver","jdbc:as400://"+sistema+"/"+bibliotecaGeneric+empresa.getLetra()+"1", null, null, usrAs, passAs);
				
			}
			
		}
		if (response == null){
			return "El formato de los datos ingresados es invalido";
		}
//		
//		Caea caea = new Caea();
//		caea.setFchVigDesde("20150315");
//		caea.setFchVigHasta("20150330");
//		caea.setEmpresa(empresa);
//		caea.setCAEA("69234378349873");
//		caea.setOrden(2);
//		caea.setPeriodo(201504);
//		caea.setFchProceso("20150314");
//		caeaDAO.save(caea);

		
		return response.getErrors()[0].getMsg();
		
	}


	public List<Caea> getCAEAbyEmpresa(Empresa empresa) {
		HashMap<String , Object> parameters=new HashMap<String, Object>();
		parameters.put("empresa", empresa);		
		List<Caea> listCaea = caeaDAO.findByObjectCriteria(parameters);
		return listCaea;
	}
	
}
	