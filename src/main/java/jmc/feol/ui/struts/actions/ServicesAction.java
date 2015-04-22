package jmc.feol.ui.struts.actions;



import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jmc.feol.core.model.Caea;
import jmc.feol.core.model.Factura;
import jmc.feol.core.model.Parametrizacion;
import jmc.feol.core.model.Patente;
import jmc.feol.core.model.Usuario;
import jmc.feol.core.model.cot.Viajes;
import jmc.feol.core.service.FacturasManager;
import jmc.feol.core.service.ParametrizacionManager;
import jmc.feol.core.service.ServicesManager;
import jmc.feol.util.Constants;
import jmc.feol.util.FileUtil;
import jmc.feol.util.FormatUtil;
import jmc.feol.util.email.Email;
import jmc.feol.util.email.SendEmailThread;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.extremecomponents.table.context.Context;
import org.extremecomponents.table.context.HttpServletRequestContext;
import org.extremecomponents.table.core.TableConstants;
import org.extremecomponents.table.limit.Filter;
import org.extremecomponents.table.limit.Limit;
import org.extremecomponents.table.limit.LimitFactory;
import org.extremecomponents.table.limit.TableLimit;
import org.extremecomponents.table.limit.TableLimitFactory;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Carrascal
 * 
 */
public class ServicesAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ParametrizacionManager parametrizacionManager;
	private ServicesManager servicesManager;
	private FacturasManager facturasManager;
	private Factura factura;
	private String moneda;
	private String prefijo;
	private String tipoComprobante;
	private String nroComprobante;
	private Parametrizacion parametrizacion;
	private Viajes viaje;
	private Patente patente;
	private String periodo;
	private String quincena;
	
	
	
	
	

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getQuincena() {
		return quincena;
	}

	public void setQuincena(String quincena) {
		this.quincena = quincena;
	}

	public Patente getPatente() {
		return patente;
	}

	public void setPatente(Patente patente) {
		this.patente = patente;
	}

	public Viajes getViaje() {
		return viaje;
	}

	public void setViaje(Viajes viaje) {
		this.viaje = viaje;
	}

	public Parametrizacion getParametrizacion() {
		return parametrizacion;
	}

	public void setParametrizacion(Parametrizacion parametrizacion) {
		this.parametrizacion = parametrizacion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getPrefijo() {
		return prefijo;
	}

	public void setPrefijo(String prefijo) {
		this.prefijo = prefijo;
	}

	public String getTipoComprobante() {
		return tipoComprobante;
	}

	public void setTipoComprobante(String tipoComprobante) {
		this.tipoComprobante = tipoComprobante;
	}

	public String getNroComprobante() {
		return nroComprobante;
	}

	public void setNroComprobante(String nroComprobante) {
		this.nroComprobante = nroComprobante;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public FacturasManager getFacturasManager() {
		return facturasManager;
	}

	public void setFacturasManager(FacturasManager facturasManager) {
		this.facturasManager = facturasManager;
	}

	private String param1;
	private String param2;
	private String param3;
	private String param4;
	private String param5;
	private String param6;
	private String usuario;
	private String password;

	public String getParam6() {
		return param6;
	}

	public void setParam6(String param6) {
		this.param6 = param6;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getParam5() {
		return param5;
	}

	public void setParam5(String param5) {
		this.param5 = param5;
	}

	public String getParam4() {
		return param4;
	}

	public void setParam4(String param4) {
		this.param4 = param4;
	}

	public String getParam2() {
		return param2;
	}

	public void setParam2(String param2) {
		this.param2 = param2;
	}

	public String getParam3() {
		return param3;
	}

	public void setParam3(String param3) {
		this.param3 = param3;
	}

	public String getParam1() {
		return param1;
	}

	public void setParam1(String param1) {
		this.param1 = param1;
	}

	public ServicesManager getServicesManager() {
		return servicesManager;
	}

	public void setServicesManager(ServicesManager servicesManager) {
		this.servicesManager = servicesManager;
	}

	public ParametrizacionManager getParametrizacionManager() {
		return parametrizacionManager;
	}

	public void setParametrizacionManager(
			ParametrizacionManager parametrizacionManager) {
		this.parametrizacionManager = parametrizacionManager;
	}

	public String execute() throws Exception {
		return "success";
	}

	/**
	 * Redirige la APP a la pagina de Login
	 * 
	 * @return
	 * @throws Exception
	 */
	public String login() throws Exception {
		return "success";
	}

	/**
	 * Cierra la session de la APP y redirige al Login
	 * 
	 * @return
	 * @throws Exception
	 */
	public String out() throws Exception {
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().getActionInvocation().getInvocationContext()
				.get(ServletActionContext.HTTP_REQUEST);
		request.getSession().setAttribute("usuario", null);
		return "success";
	}

	/**
	 * prepara pagina para obtener el caea
	 * 
	 * @return
	 * @throws Exception
	 */
	public String preparedGetCaea() throws Exception {
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().getActionInvocation().getInvocationContext()
				.get(ServletActionContext.HTTP_REQUEST);
		
		return "success";
	}
	
	
	
	/**
	 * Este metodo devuelve el usuario de la session actual
	 * @return Usuario actual
	 */
	private Usuario getUsuarioSesion() {
		HttpServletRequest request =(HttpServletRequest)ActionContext.getContext().getActionInvocation().getInvocationContext().get(ServletActionContext.HTTP_REQUEST);		
		return (Usuario)request.getSession().getAttribute("usuario");
	}
	
	
	/**
	 * Lista la parametrizacion
	 * 
	 * @return
	 * @throws Exception
	 */
	public String preparedNewPatente() throws Exception {
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().getActionInvocation().getInvocationContext()
				.get(ServletActionContext.HTTP_REQUEST);
		
		
		
		return "success";
	}

	
	

	/**
	 * Lista la parametrizacion
	 * 
	 * @return
	 * @throws Exception
	 */
	public String newPatente() throws Exception {
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().getActionInvocation().getInvocationContext()
				.get(ServletActionContext.HTTP_REQUEST);
			servicesManager.addPatente(patente);
		
		return "success";
	}
	
	/**
	 * Lista la parametrizacion
	 * 
	 * @return
	 * @throws Exception
	 */
	public String deletePatente() throws Exception {
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().getActionInvocation().getInvocationContext()
				.get(ServletActionContext.HTTP_REQUEST);
			servicesManager.deletePatente(patente);
		
		return "success";
	}

	/**
	 * Lista la parametrizacion
	 * 
	 * @return
	 * @throws Exception
	 */
	public String preparedListPatente() throws Exception {
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().getActionInvocation().getInvocationContext()
				.get(ServletActionContext.HTTP_REQUEST);
		
		List<Patente> listPatente = servicesManager.getPatenteAllOrden();
		
		request.setAttribute("listPatente", listPatente);
		
		return "success";
	}

	/**
	 * Lista la parametrizacion
	 * 
	 * @return
	 * @throws Exception
	 */
	public String preparedListParametrizacion() throws Exception {
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().getActionInvocation().getInvocationContext()
				.get(ServletActionContext.HTTP_REQUEST);
		
		List<Parametrizacion> listParametrizacion = parametrizacionManager.getAllParametrizacion();
		
		request.setAttribute("listParametrizacion", listParametrizacion);
		
		
		return "success";
	}
	
	/**
	 * Lista la Caeas
	 * 
	 * @return
	 * @throws Exception
	 */
	public String historyCaea() throws Exception {
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().getActionInvocation().getInvocationContext()
				.get(ServletActionContext.HTTP_REQUEST);
		Usuario usuario = getUsuarioSesion();
		
		List<Caea> listCaea = servicesManager.getCAEAbyEmpresa(usuario.getEmpresa());
		
		request.setAttribute("listCaea", listCaea);		
		
		return "success";
	}
	
	
	public String preparedViajesSinCot() throws Exception {
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().getActionInvocation().getInvocationContext()
				.get(ServletActionContext.HTTP_REQUEST);
		
		List<Parametrizacion> listParametrizacion = parametrizacionManager.getAllParametrizacion();
		
		//Busco patentes diponibles.
		List<Patente> patenteList = servicesManager.getPatenteAllOrden();
		
		// Lista de Patentes
		ActionContext.getContext().getSession().put("patenteList", patenteList);
		
		List<Viajes> listViajes = new ArrayList<Viajes>();
		
		Viajes viaje = new Viajes();
		
		viaje.setChoferNr(2);
		viaje.setFecha(new Date(System.currentTimeMillis()));
		viaje.setKm(23f);
		viaje.setModalidad(3);
		viaje.setPrecio(new BigDecimal("23"));
		viaje.setProcesado(false);
		viaje.setViajeNr(413643);
		viaje.setZonaNr(12);

		Viajes viaje1 = new Viajes();
		
		viaje1.setChoferNr(2);
		viaje1.setFecha(new Date(System.currentTimeMillis()));
		viaje1.setKm(23f);
		viaje1.setModalidad(3);
		viaje1.setPrecio(new BigDecimal("23"));
		viaje1.setProcesado(true);
		viaje1.setViajeNr(413644);
		viaje1.setZonaNr(12);
		
		listViajes.add(viaje);
		listViajes.add(viaje1);
		
		//List<Viajes> listViajes = servicesManager.getViajesSinCot(getUsuarioSesion());
		
		request.setAttribute("listParametrizacion", listParametrizacion);		

		request.setAttribute("listViajes", listViajes);

		return "success";
	}
	

	public String autorizarViaje() throws Exception {
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().getActionInvocation().getInvocationContext()
				.get(ServletActionContext.HTTP_REQUEST);
		
		HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().getActionInvocation().getInvocationContext().get(ServletActionContext.HTTP_RESPONSE);		

		String respuestaCot = servicesManager.autorizarViaje(viaje.getViajeNr(), getUsuarioSesion(), patente);
		
		ServletOutputStream sos = null;
		try {
			sos = response.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		StringBuilder salida = new StringBuilder();
	    
		salida.append(respuestaCot);

		response.setContentType("text/html; charset=iso-8859-1");
	    //Imprime el resultado
	    try {
			sos.print(salida.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
	

	/**
	 * Edita la parametrizacion
	 * 
	 * @return
	 * @throws Exception
	 */
	public String preparedEditParametrizacion() throws Exception {
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().getActionInvocation().getInvocationContext()
				.get(ServletActionContext.HTTP_REQUEST);
		
		parametrizacion = parametrizacionManager.getParametrizacionByPrimaryKey(parametrizacion.getIdParametrizacion());
		
		request.setAttribute("parametrizacion", parametrizacion);
				
		return "success";
	}

	
	public String setCheque() throws Exception {
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().getActionInvocation().getInvocationContext()
				.get(ServletActionContext.HTTP_REQUEST);
		
		if (parametrizacionManager
				.getParametrizacionByPrimaryKey(Constants.ID_PASSWORD)
				.getValor().equals(param2)) {
			
			// Guardo la factura
			// Obtengo la ruta del archivo
			try {
				String chequeNr = param1;
				String parte = param3;
				Integer parteInt  = 0;
				try{
					parteInt= Integer.parseInt(parte);
				}catch(NumberFormatException ne){
					ne.printStackTrace();
				}
				servicesManager.setChequeNr(chequeNr, parteInt);
			}catch(Exception e){
				e.printStackTrace();
			}
			
			
		}
return  null;
	}

	/**
	 * Se actualiza un valor 
	 * 
	 * @return
	 * @throws Exception
	 */
	public String editParametrizacion() throws Exception {
		
		parametrizacionManager.updateParametrizacion(parametrizacion);

		return "success";
	}
	
	
	/*
	 * M�todo que env�a mails llamando un requerimiento HTTP
	 */
	public String sendMail() {

		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().getActionInvocation().getInvocationContext()
				.get(ServletActionContext.HTTP_RESPONSE);
		ServletOutputStream sos = null;
		try {
			sos = response.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String valor = parametrizacionManager.getParametrizacionByPrimaryKey(
				Constants.ID_PASSWORD).getValor();
		String useService = "false";
		try{
			useService = parametrizacionManager.getParametrizacionByPrimaryKey(
					Constants.USE_SERVICE_SENDMAIL).getValor();			
		}catch(Exception e){}
		
		if (valor.equals(param5)) {

			if(useService.equals("true")){
							
				String archivo = param3;
				File archivoAdjunto = null;
				if (archivo != null && !archivo.trim().equals("")) {
	
					try {
						archivoAdjunto = new File(archivo);
	
						if (!archivoAdjunto.exists()) {
							try {
								sos.print("No se ha podido tomar el archivo "
										+ archivo);
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							return null;
						}
					} catch (Exception e) {
						e.printStackTrace();
						try {
							sos.print("No se ha podido tomar el archivo " + archivo);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						return null;
					}
				}
				// Cargo los datos del EMail
				Email email = new Email( param1, param2, archivoAdjunto, param4);
	
				Properties props = servicesManager.getPropertiesEmail(param6);
	
				SendEmailThread emailManager = new SendEmailThread(props, email, param6);
				emailManager.start();
	
				try {
					sos.print("OK");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else{
				try {
					sos.print("El servicio esta desactivado");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			try {
				sos.print("ERROR PASS");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/*
	 * M�todo Validar el Usuario
	 */
	public String validateUSR() {
		String msg = "";

		// msg = servicesManager.validateUSR(usuario, password);

		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().getActionInvocation().getInvocationContext()
				.get(ServletActionContext.HTTP_RESPONSE);
		ServletOutputStream sos = null;
		try {
			sos = response.getOutputStream();
			sos.print(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * M�todo facturar factura de AFIP
	 */
	public String facturar() {
		// Invoco al metodo de facturacion
		String msg = "ERROR PASS";
		if (parametrizacionManager
				.getParametrizacionByPrimaryKey(Constants.ID_PASSWORD)
				.getValor().equals(param5)) {
			Long transac = 0l;
			try {
				transac = Long.parseLong(param1);
				msg = servicesManager.autorizoFactura(transac, param2, param3,
						param4);

			} catch (Exception e) {
				msg = "No se pudo obtener el numero de Transaccion";
			}
		}
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().getActionInvocation().getInvocationContext()
				.get(ServletActionContext.HTTP_RESPONSE);
		ServletOutputStream sos = null;
		try {
			sos = response.getOutputStream();
			sos.print(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	

	/*
	 * M�todo get_facturacion factura de AFIP
	 */
	public String get_facturacion() {
		// Invoco al metodo de facturacion
		String msg = "ERROR PASS";
		if (parametrizacionManager
				.getParametrizacionByPrimaryKey(Constants.ID_PASSWORD)
				.getValor().equals(param5)) {
			Long transac = 0l;
			try {
				String punto_vta = param1;
				String rutaBaseFactuAfip = param2;
				String cte_desde = param3;
				String cte_hasta = param4;
				String tipo_comprobante = param6;
				msg = servicesManager.getFacturacionAFIP(punto_vta,rutaBaseFactuAfip,cte_desde,cte_hasta,tipo_comprobante);

			} catch (Exception e) {
				msg = "No se pudo obtener el numero de Transaccion";
			}
		}
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().getActionInvocation().getInvocationContext()
				.get(ServletActionContext.HTTP_RESPONSE);
		ServletOutputStream sos = null;
		try {
			sos = response.getOutputStream();
			sos.print(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * M�todo Obtener Facturas Perdidas
	 */
	public String facturasPerdidas() {
		
		HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().getActionInvocation().getInvocationContext().get(ServletActionContext.HTTP_RESPONSE);
		
		//byte[] arrayBytes = FileUtil.getBytesFromArrayList(facturasManager.getFacturasOrdenadas());
		
		byte[] arrayBytes = FormatUtil.getFacturasExcel(facturasManager.getFacturasOrdenadas());
		
		try {

			
			ServletOutputStream sos;
			try {
				sos = response.getOutputStream();		
					
			response.setHeader("Content-disposition", "attachment; filename=" + "facturaPerdidas.xls");        
			response.setHeader("Pragma", "Public");        
			response.setContentType("text/txt; charset=UTF-8");   
			//response.setContentLength(bytes.length);
			sos.write(arrayBytes);
			sos.flush();
			sos.close();	
			
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (Exception e1) {

			e1.printStackTrace();
		}


		return null;
	}
	public String funcionNoLicenciada() {

		return "success";
	}
	
	/*
	 * Devuelve 2 arreglos, unos de propiedades y otro de valores a partir de un
	 * arreglo de objetos de tipo Filter
	 */
	private void extractFilter(Filter[] filters, String[] propertyFilter,
			String[] valueFilter) {
		int j = 0;
		if (filters.length > 0) {
			for (Filter f : filters) {
				propertyFilter[j] = f.getProperty();
				valueFilter[j++] = f.getValue();
			}
		}
	}

	/**
	 * Este metodo devuelve el remito en formato PDF
	 * @return 
	 * @author Carrascal
	 */
	public String downloadRemito(){
		
			HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().getActionInvocation().getInvocationContext().get(ServletActionContext.HTTP_RESPONSE);									
			
			byte[] fileDownload = servicesManager.getRemito(viaje.getViajeNr());						
	    	
			int length   = 0;
			
			ServletOutputStream sos;
			try {
				sos = response.getOutputStream();
			
					
			response.setHeader("Content-disposition", "attachment; filename=" + viaje.getViajeNr() + ".pdf");        
			response.setHeader("Pragma", "Public");        
			response.setContentType("application/octet-stream");   
			
			
			response.setContentType("application/pdf");
			OutputStream out=response.getOutputStream();
			out.write(fileDownload);
			out.flush();
			out.close();		
			}catch(Exception e){
				e.printStackTrace();
			}												
	
		return null;
	}

	
	/**
	 * Metodo para preparar los listados de facturas
	 */
	public String preparedListFacturas() {

		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().getActionInvocation().getInvocationContext()
				.get(ServletActionContext.HTTP_REQUEST);
		// Grilla de No registrados
		Context context = new HttpServletRequestContext(request);
		LimitFactory limitFactory = new TableLimitFactory(context, "notReg");
		Limit limit = new TableLimit(limitFactory);

		String propertySort = limit.getSort().getProperty();
		String orderSort = limit.getSort().getSortOrder();
		// Se obtienen los filtros para la grilla superior
		Filter[] filters = limit.getFilterSet().getFilters();
		String[] propertyFilter = new String[filters.length];
		String[] valueFilter = new String[filters.length];
		extractFilter(filters, propertyFilter, valueFilter);

		int pageSize = 100;

		String rows = context.getParameter("notReg_" + TableConstants.CURRENT_ROWS_DISPLAYED);

		if (StringUtils.isNotBlank(rows)) {
			pageSize = Integer.parseInt(rows);
		}
		Integer max = limit.getPage() * pageSize;

		Integer min = max - pageSize;

		Long regTotalRows = facturasManager.getCountFacturaGrilla();

		List<Factura> listFactura = new ArrayList<Factura>();
		try {
			listFactura = facturasManager.getFacturaGrilla(propertySort,
					orderSort, propertyFilter, valueFilter, min, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (propertyFilter != null && propertyFilter.length > 0) {
			// Si estan seteados los filtros se reduce la cantidad de registros
			// a mostrar
			limit.setRowAttributes(listFactura.size(), pageSize);
			request.setAttribute("notReg_totalRows", listFactura.size());
		} else {
			limit.setRowAttributes(regTotalRows.intValue(), pageSize);
			request.setAttribute("notReg_totalRows", regTotalRows.intValue());
		}

		request.setAttribute("listFactura", listFactura);
		request.setAttribute("totalRows", regTotalRows.intValue());

		return "success";
	}

	/**
	 * Reprocesa un id de Factura
	 */
	public String switchProcesoAfip() {

		

		Factura facturaActual = servicesManager.getFacturaById(factura
				.getIdFactura());

		if (facturaActual.getCae() == null
				|| facturaActual.getCae().trim().equals("")) {
			facturasManager.reProcesarFactura(facturaActual);
		}
		
		return "success";
	}

	/**
	 * Metodo para procesar facturas con error en la comunicacion con AFIP
	 */
	public String checkFacturas() {
		// Buscar facturas con CodError en 10 y enviarlas a procesar nuevamente
		servicesManager.procesarFacturaError();

		return null;
	}
	
	/**
	 * Metodo para procesar facturas con error en la comunicacion con AFIP
	 */
	public String checkFileFacturas() {
		// Buscar facturas con CodError en 10 y enviarlas a procesar nuevamente
		servicesManager.procesarFileFacturaError_v1();

		return null;
	}
		
	
	
	/**
	 * Metodo para obtener las imagenes de los cheques
	 */
	public String checkGetImageCheque() {
		// Buscar Imagenes de Cheques
		servicesManager.getImageCheque();
		return null;
	}

	
	
	/**
	 * Invoco el metodo para facturar por AFIP desde el AS400
	 */
	public String getFacturaAs() {
		// Buscar facturas con CodError en 10 y enviarlas a procesar nuevamente
		try {
			Long idSolicitud = Long.parseLong(param2);
			servicesManager.gestionoFacturaABAS(param1, idSolicitud);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return null;
	}

		

	/**
	 * Metodo para guardar el adjunto de la factura
	 */
	public String recuperarCheque() {
		
		HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().getActionInvocation().getInvocationContext().get(ServletActionContext.HTTP_RESPONSE);

		String msg = "ERROR PASS";
		if (true) {
			
			// Guardo la factura
			// Obtengo la ruta del archivo
			try {
											
				byte[] bytes = servicesManager.getByteImageCheques("",0);
					
					ServletOutputStream sos;
					try {
						sos = response.getOutputStream();		
							
					//response.setHeader("Content-disposition", "attachment; filename=" + facturaActual.getNombreArchivo().replaceAll("txt", "xml"));        
					response.setHeader("Pragma", "Public");        
					response.setContentType("image/jpeg");   
					//response.setContentLength(bytes.length);
					sos.write(bytes);
					sos.flush();
					sos.close();	
					
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				

				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}


		return null;
	}

	/**
	 * Metodo para guardar el adjunto de la factura
	 */
	public String saveAdjuntoFactura() {
		String msg = "ERROR PASS";
		if (parametrizacionManager
				.getParametrizacionByPrimaryKey(Constants.ID_PASSWORD)
				.getValor().equals(param5)) {
			msg = "Error en la lectura del Archivo";
			// Guardo la factura
			// Obtengo la ruta del archivo
			try {
				String transacNr = param1;
				File adjunto = new File(param2);
				if (adjunto.exists()) {
					try {
						servicesManager.saveAdjuntoFactura(transacNr, adjunto);
						msg = "OK";
					} catch (Exception e) {
						e.printStackTrace();
						msg = "No se ha podido guardar el adjunto";
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().getActionInvocation().getInvocationContext()
				.get(ServletActionContext.HTTP_RESPONSE);
		ServletOutputStream sos = null;
		try {
			sos = response.getOutputStream();
			sos.print(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	
	/**
	 * Metodo para procesar facturas con error en la comunicacion con AFIP
	 */
	public String checkFacturasByFileExpov1() {
		// Busco facturas desde archivos
		while(true){
			servicesManager.procesarFacturaByFilesExpov1();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {

				e.printStackTrace();
				return null;
			}
		}
		
	}

	
	/**
	 * Metodo para procesar facturas con error en la comunicacion con AFIP
	 */
	public String checkFacturasByFile() {
		// Busco facturas desde archivos
		while(true){
			servicesManager.procesarFacturaByFiles();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {

				e.printStackTrace();
				return null;
			}
		}
		
	}

	/**
	 * Consulto un cotizacion
	 */
	public String showCotizacion() {

		String mensaje = "No se ha podido consultar la cotizaci�n";
		
		try {
			mensaje = servicesManager.getCotizacionByMoneda(moneda);
		} catch (Exception e1) {			
			e1.printStackTrace();
		}
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().getActionInvocation().getInvocationContext()
				.get(ServletActionContext.HTTP_RESPONSE);
		ServletOutputStream sos = null;
		try {
			sos = response.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			sos.print(mensaje);
		} catch (IOException e) {

			e.printStackTrace();
		}

		return null;
	}

	
	/**
	 * Obtiene un caea
	 */
	public String getCaea() {

		String mensaje = "No se ha podido consultar la cotizaci�n";
		Usuario usuario = getUsuarioSesion();
		try {
			mensaje = servicesManager.getCaea(periodo,quincena, usuario.getEmpresa());
		} catch (Exception e1) {			
			e1.printStackTrace();
		}
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().getActionInvocation().getInvocationContext()
				.get(ServletActionContext.HTTP_RESPONSE);
		ServletOutputStream sos = null;
		try {
			sos = response.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			sos.print(mensaje);
		} catch (IOException e) {

			e.printStackTrace();
		}

		return null;
	}
	
	/**
	 * Consulto un verificacion AFIP
	 */
	public String verifAfipExpo() {

		String mensaje = "No se ha podido realizar la consulta";
		
		try {
			mensaje = servicesManager.getEstadoAfipExpo();
		} catch (Exception e1) {			
			e1.printStackTrace();
		}
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().getActionInvocation().getInvocationContext()
				.get(ServletActionContext.HTTP_RESPONSE);
		ServletOutputStream sos = null;
		try {
			sos = response.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			sos.print(mensaje);
		} catch (IOException e) {

			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Consulto un cotizacion
	 */
	public String showCotizacionExpo() {

		String mensaje = "No se ha podido consultar la cotizaci�n";
		
		try {
			mensaje = servicesManager.getCotizacionExpoByMoneda(moneda);
		} catch (Exception e1) {			
			e1.printStackTrace();
		}
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().getActionInvocation().getInvocationContext()
				.get(ServletActionContext.HTTP_RESPONSE);
		ServletOutputStream sos = null;
		try {
			sos = response.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			sos.print(mensaje);
		} catch (IOException e) {

			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Consulto un cotizacion
	 */
	public String preparedCotizacion() {
		
		return "success";
	}
	
	/**
	 * Consulto un cotizacion
	 */
	public String preparedVerifAfipExpo() {
		
		return "success";
	}
	/**
	 * Consulto un cotizacion
	 */
	public String tablasAFIP() {
		
		return "success";
	}
	
	
	
	/**
	 * Consulto un cotizacion
	 */
	public String preparedCotizacionExpo() {
		
		return "success";
	}

	/**
	 * Preparo el buscador de facturas
	 */
	public String preparedDownloadFactura() {
		
		return "success";
	}
	

	/**
	 * Preparo el buscador de facturas
	 */
	public String preparedDownloadFacturaExpo() {
		System.out.println("Entro");
		return "success";
	}

	/**
	 * Este metodo devuelve la factura procesada por AFIP
	 * @return 
	 * @author Carrascal
	 */
	public String downloadFactura(){
		
		boolean error = true; 
		HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().getActionInvocation().getInvocationContext().get(ServletActionContext.HTTP_RESPONSE);
		int prefijoInt = 0;
		long cbteNroLong = 0;
		int cbteTipoInt = 0;
		try{
			prefijoInt = Integer.parseInt(prefijo);
			cbteTipoInt = Integer.parseInt(tipoComprobante);
			
			if(nroComprobante == null || nroComprobante.trim().equals("")){
				cbteNroLong = servicesManager.getLastNroCompr(prefijoInt,cbteTipoInt);
			}else{
				cbteNroLong = Long.parseLong(nroComprobante);
			}
			error = false;
		}catch(Exception e){
			e.printStackTrace();
		}
		if (error){
			ServletOutputStream sos = null;
			try {
				sos = response.getOutputStream();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				sos.print("No se ha podido recuperar la factura requerida ");
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}else{
			byte[] bytes = servicesManager.getFactura(cbteNroLong,cbteTipoInt,prefijoInt);
			
			ServletOutputStream sos;
			try {
				sos = response.getOutputStream();		
					
			//response.setHeader("Content-disposition", "attachment; filename=" + fileName);        
			response.setHeader("Pragma", "Public");        
			response.setContentType("text/xml; charset=UTF-8");   
			//response.setContentLength(bytes.length);
			sos.write(bytes);
			sos.flush();
			sos.close();	
			
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		return null;

	}
	

	/**
	 * Este metodo devuelve la factura procesada por AFIP
	 * @return 
	 * @author Carrascal
	 */
	public String downloadFacturaExpo(){
		
		boolean error = true; 
		HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().getActionInvocation().getInvocationContext().get(ServletActionContext.HTTP_RESPONSE);
		int prefijoInt = 0;
		long cbteNroLong = 0;
		int cbteTipoInt = 0;
		try{
			prefijoInt = Integer.parseInt(prefijo);
			cbteTipoInt = Integer.parseInt(tipoComprobante);
			
			if(nroComprobante == null || nroComprobante.trim().equals("")){
				cbteNroLong = servicesManager.getLastNroComprExpo(prefijoInt,cbteTipoInt);
			}else{
				cbteNroLong = Long.parseLong(nroComprobante);
			}
			error = false;
		}catch(Exception e){
			e.printStackTrace();
		}
		if (error){
			ServletOutputStream sos = null;
			try {
				sos = response.getOutputStream();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				sos.print("No se ha podido recuperar la factura requerida ");
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}else{
			byte[] bytes = servicesManager.getFacturaExpo(cbteNroLong,cbteTipoInt,prefijoInt);
			
			ServletOutputStream sos;
			try {
				sos = response.getOutputStream();		
					
			//response.setHeader("Content-disposition", "attachment; filename=" + fileName);        
			response.setHeader("Pragma", "Public");        
			response.setContentType("text/xml; charset=UTF-8");   
			//response.setContentLength(bytes.length);
			sos.write(bytes);
			sos.flush();
			sos.close();	
			
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		return null;

	}

	/**
	 * Este metodo devuelve el request enviado a la AFIP
	 * @return 
	 * @author Carrascal
	 */
	public String downloadRequest(){
				 
		HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().getActionInvocation().getInvocationContext().get(ServletActionContext.HTTP_RESPONSE);

		Factura facturaActual = servicesManager.getFacturaById(factura.getIdFactura());
		
		byte[] bytes = facturaActual.getRequestEnviado();
			
			ServletOutputStream sos;
			try {
				sos = response.getOutputStream();		
					
			response.setHeader("Content-disposition", "attachment; filename=" + facturaActual.getNombreArchivo().replaceAll("txt", "xml"));        
			response.setHeader("Pragma", "Public");        
			response.setContentType("text/xml; charset=UTF-8");   
			//response.setContentLength(bytes.length);
			sos.write(bytes);
			sos.flush();
			sos.close();	
			
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		
		return null;

	}
	
	/**
	 * Este metodo devuelve el documento subido por el usuario
	 * @return 
	 * @author Carrascal
	 */
	public String downloadFile(){
				 
		HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().getActionInvocation().getInvocationContext().get(ServletActionContext.HTTP_RESPONSE);

		Factura facturaActual = servicesManager.getFacturaById(factura.getIdFactura());
		String rutaDefinitivo = "";
		if (facturaActual.getTipo_cbte() == 19 || facturaActual.getTipo_cbte() == 20 || facturaActual.getTipo_cbte() == 21 ){
			rutaDefinitivo = parametrizacionManager.getParametrizacionByPrimaryKey(Constants.ID_CARPETA_DEFINITIVO_EXPOV1).getValor();
		}else{
			rutaDefinitivo = parametrizacionManager.getParametrizacionByPrimaryKey(Constants.ID_CARPETA_DEFINITIVO).getValor();
		}
		
		byte[] bytes = null;
		try {
			bytes = FileUtil.getBytesFromFile(new File(rutaDefinitivo + facturaActual.getNombreArchivo()));
			
			ServletOutputStream sos;
			try {
				sos = response.getOutputStream();		
					
			response.setHeader("Content-disposition", "attachment; filename=" + facturaActual.getNombreArchivo());        
			response.setHeader("Pragma", "Public");        
			response.setContentType("text/txt; charset=UTF-8");   
			//response.setContentLength(bytes.length);
			sos.write(bytes);
			sos.flush();
			sos.close();	
			
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (IOException e1) {

			e1.printStackTrace();
		}
			
			
			
		
		return null;

	}

}