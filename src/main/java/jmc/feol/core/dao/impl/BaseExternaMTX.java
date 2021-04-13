package jmc.feol.core.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jmc.feol.core.service.impl.FacturaManagerImpl;
import jmc.feol.util.DateUtil;
import jmc.feol.util.FormatUtil;

import FEV1.dif.afip.gov.ar.wmtx.ComprobanteType;
import FEV1.dif.afip.gov.ar.wmtx.ItemType;
import FEV1.dif.afip.gov.ar.wmtx.OtroTributoType;
import FEV1.dif.afip.gov.ar.wmtx.SubtotalIVAType;


public class BaseExternaMTX {
	private Boolean actualizoBase = Boolean.FALSE;
	private String urlBase = "";
	private String base = "";
	private String usuario = "";
	private String usuarioClave = "";
	private String tabla = "";
	private String controlador = "";
	private String prefijo = "";
	private String campoNumCot = "";
	private String campoRespuestaRentas = "";
	private String campoRemito = "";
	private String rutaComun = ""; 
	private String rutaArticulo = "";
	private String usr = "";
	private String password = "";
	private Boolean useSQL = Boolean.FALSE;
	private Connection connMDB = null;
	
	

	public Connection getConnMDB(String rutaBase) {
		if (useSQL){
	        String direccion = urlBase;
	        try {
				Class.forName(controlador);
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} 
	        Connection conn = null;
			try {
				conn = DriverManager.getConnection(direccion, usr, password);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
	        try {
				conn.getAutoCommit();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
	        return conn;
			
		}else{
			String direccion = urlBase.replaceFirst("@rutaBase", rutaBase);
			try {
				Class.forName(controlador);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			Connection conn = null;
			try {
				conn = DriverManager.getConnection(direccion);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.getAutoCommit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return conn;
		}
	}

	public void setConnMDB(Connection connMDB) {
		this.connMDB = connMDB;
	}

	public String getUsr() {
		return usr;
	}

	public void setUsr(String usr) {
		this.usr = usr;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getUseSQL() {
		return useSQL;
	}

	public void setUseSQL(Boolean useSQL) {
		this.useSQL = useSQL;
	}

	public String getRutaComun() {
		return rutaComun;
	}

	public void setRutaComun(String rutaComun) {
		this.rutaComun = rutaComun;
	}

	public String getRutaArticulo() {
		return rutaArticulo;
	}

	public void setRutaArticulo(String rutaArticulo) {
		this.rutaArticulo = rutaArticulo;
	}

	public BaseExternaMTX(String contralador, String urlBase, String rutaComun, String rutaArticulo) {
		this.setUrlBase(urlBase);
		this.setControlador(contralador);
		this.setRutaArticulo(rutaArticulo);
		this.setRutaComun(rutaComun);
	}
	
	public BaseExternaMTX(String contralador, String urlBase, String rutaComun, String rutaArticulo, String usr, String password) {
		this.setUrlBase(urlBase);
		this.setControlador(contralador);
		this.setRutaArticulo(rutaArticulo);
		this.setRutaComun(rutaComun);
		this.setUsr(usr);
		this.setPassword(password);
		this.useSQL = true;
	}

	public Boolean getActualizoBase() {
		return actualizoBase;
	}

	public void setActualizoBase(Boolean actualizoBase) {
		this.actualizoBase = actualizoBase;
	}

	public String getUrlBase() {
		return urlBase;
	}

	public void setUrlBase(String urlBase) {
		this.urlBase = urlBase;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getUsuarioClave() {
		return usuarioClave;
	}

	public void setUsuarioClave(String usuarioClave) {
		this.usuarioClave = usuarioClave;
	}

	public String getTabla() {
		return tabla;
	}

	public void setTabla(String tabla) {
		this.tabla = tabla;
	}

	public String getControlador() {
		return controlador;
	}

	public void setControlador(String controlador) {
		this.controlador = controlador;
	}

	public String getPrefijo() {
		return prefijo;
	}

	public void setPrefijo(String prefijo) {
		this.prefijo = prefijo;
	}

	public String getCampoNumCot() {
		return campoNumCot;
	}

	public void setCampoNumCot(String campoNumCot) {
		this.campoNumCot = campoNumCot;
	}

	public String getCampoRespuestaRentas() {
		return campoRespuestaRentas;
	}

	public void setCampoRespuestaRentas(String campoRespuestaRentas) {
		this.campoRespuestaRentas = campoRespuestaRentas;
	}

	public String getCampoRemito() {
		return campoRemito;
	}

	public void setCampoRemito(String campoRemito) {
		this.campoRemito = campoRemito;
	}

	
	

	private ComprobanteType makeComprobanteType(ResultSet rs, Long transac, String rutaBase)
			throws SQLException {

		Double totalSk = rs.getDouble("Total");
		// Carga del objeto FERequet
		ComprobanteType feReq = new ComprobanteType();
		String errorParseo = "";
		// Cargo Cabezera.		
		int tipoComp = 0;
		String letra="";
		try {
			tipoComp = rs.getInt("TipoComprob");
		} catch (SQLException e) {
			errorParseo = "No se ha podido obtener el Tipo de Comprobante del campo 'TipoComprob'";
			e.printStackTrace();
		}

		try {
			letra = rs.getString("Letra");
		} catch (SQLException e) {
			errorParseo = "No se ha podido obtener el Tipo de Comprobante del campo 'TipoComprob'";
			e.printStackTrace();
		}
		
		short tipoCompAfip = 0;
		
		if (tipoComp == 1 && letra.trim().equals("A")){
			tipoCompAfip = 1;
		}
		if (tipoComp == 1 && letra.trim().equals("B")){
			tipoCompAfip = 6;
		}
		if (tipoComp == 2 && letra.trim().equals("A")){
			tipoCompAfip = 3;
		}
		if (tipoComp == 2 && letra.trim().equals("B")){
			tipoCompAfip = 8;
		}
		if (tipoComp == 7 && letra.trim().equals("A")){
			tipoCompAfip = 2;
		}
		if (tipoComp == 7 && letra.trim().equals("B")){
			tipoCompAfip = 7;
		}
						
		feReq.setCodigoTipoComprobante(tipoCompAfip);
		
		try {
			feReq.setNumeroPuntoVenta(Short.parseShort(rs.getString("Prefijo")));
		} catch (NumberFormatException e) {
			errorParseo = "No se ha podido obtener el Punto de Venta del campo 'Prefijo'";
			e.printStackTrace();
		} catch (SQLException e) {
			errorParseo = "No se ha podido obtener el Punto de Venta del campo 'Prefijo'";
			e.printStackTrace();
		}	

		try {
			feReq.setNumeroComprobante(Long.parseLong(rs.getString("NrComprob")));
		} catch (NumberFormatException e) {
			errorParseo = "No se ha podido obtener el Numero del campo 'NrComprob'";
			e.printStackTrace();
		} catch (SQLException e) {
			errorParseo = "No se ha podido obtener el Numero del campo 'NrComprob'";
			e.printStackTrace();
		}


		try{
			feReq.setFechaEmision(rs.getDate("fecha"));
		}catch(Exception e){
			errorParseo = "No se ha podido obtener la fecha del campo 'Fecha'";
			e.printStackTrace();			
		}		
		
		//	
		
		feReq.setImporteTotal(BigDecimal.valueOf(totalSk));
				
		//feReq.setErrorParseo(errorParseo);
		
		feReq.setCodigoMoneda("PES");
		
		feReq.setCotizacionMoneda(BigDecimal.ONE);
				
		feReq.setCodigoConcepto(Short.parseShort("1"));
		
		
		try{
			String doc = rs.getString("Cuit");
			
			feReq.setNumeroDocumento(FormatUtil.formatCuit(doc));			
			
			if (doc.substring(0, 2).equals("00")){				
				feReq.setCodigoTipoDocumento(Short.parseShort("96"));
			}else{
				feReq.setCodigoTipoDocumento(Short.parseShort("80"));
			}			
		}catch(Exception e){
			errorParseo = "No se ha podido obtener CUIT o el tipo de documento del campo 'cuit'";
			e.printStackTrace();						
		}
		
		
		
		
		
		//Completo ITEMS
		feReq = this.completeValoresItems(transac, rutaBase, feReq);		
		
		//Completo IVA
		feReq = this.completeValoresIVA(transac, rutaBase, feReq);		
		
		//Completo Tributo
		Double perIb = 0d;
		Double perInternos = 0d;
		Double perIva = 0d;
		Double perGan = 0d;
		Double perRni = 0d;
		Double perCargasSoc = 0d;		
		Double totalTributo = 0d;
		List<OtroTributoType> tributosList = new ArrayList<OtroTributoType>();		
		try {
			perIb = rs.getDouble("retib");
			if (perIb>0){
				perIb = FormatUtil.redondearEn2(perIb);
				FacturaManagerImpl fm = new FacturaManagerImpl();
				OtroTributoType tributoIb = fm.generateTributoMTX(feReq.getImporteGravado(), perIb, "", Short.parseShort("2"));
				totalTributo = totalTributo + perIb; 
				tributosList.add(tributoIb);
			}
					
		} catch (NumberFormatException e) {
			errorParseo = "No se ha podido obtener la percepci�n de Ingresos brutos del campo 'retib'";
			e.printStackTrace();
		} catch (SQLException e) {
			errorParseo = "No se ha podido obtener la percepci�n de Ingresos brutos del campo 'retib'";
			e.printStackTrace();
		}

		try {
			
			perInternos = rs.getDouble("internos");
			if (perInternos>0){
				perInternos = FormatUtil.redondearEn2(perInternos);
				FacturaManagerImpl fm = new FacturaManagerImpl();
				OtroTributoType tributoInternos = fm.generateTributoMTX(feReq.getImporteGravado(), perInternos, "", Short.parseShort("1"));				
				totalTributo = totalTributo + perInternos; 
				tributosList.add(tributoInternos);
			}
					
		} catch (NumberFormatException e) {
			errorParseo = "No se ha podido obtener la percepci�n de Internos del campo 'internos'";
			e.printStackTrace();
		} catch (SQLException e) {
			errorParseo = "No se ha podido obtener la percepci�n de Internos del campo 'internos'";
			e.printStackTrace();
		}

		try {
			perIva = rs.getDouble("retiva");
			if (perIva>0){
				perIva = FormatUtil.redondearEn2(perIva);
				FacturaManagerImpl fm = new FacturaManagerImpl();
				OtroTributoType tributoIb = fm.generateTributoMTX(feReq.getImporteGravado(), perIva, "", Short.parseShort("1"));				
				totalTributo = totalTributo + perIva;
				tributosList.add(tributoIb);				
			}
				
		} catch (NumberFormatException e) {
			errorParseo = "No se ha podido obtener la percepci�n de Iva del campo 'retiva'";
			e.printStackTrace();
		} catch (SQLException e) {
			errorParseo = "No se ha podido obtener la percepci�n de Iva del campo 'retiva'";
			e.printStackTrace();
		}

		try {
			perGan = rs.getDouble("retgan");
			if (perGan>0){
				perGan = FormatUtil.redondearEn2(perGan);
				FacturaManagerImpl fm = new FacturaManagerImpl();
				OtroTributoType tributogan = fm.generateTributoMTX(feReq.getImporteGravado(), perGan, "", Short.parseShort("1"));				
				totalTributo = totalTributo + perGan;
				tributosList.add(tributogan);								
			}
							
		} catch (NumberFormatException e) {
			errorParseo = "No se ha podido obtener la percepci�n de Ganancias del campo 'retgan'";
			e.printStackTrace();
		} catch (SQLException e) {
			errorParseo = "No se ha podido obtener la percepci�n de Ganancias del campo 'retgan'";
			e.printStackTrace();
		}

		try {
			perCargasSoc = rs.getDouble("RetCargasSoc");
			if (perCargasSoc>0){
				perCargasSoc = FormatUtil.redondearEn2(perCargasSoc);
				FacturaManagerImpl fm = new FacturaManagerImpl();
				OtroTributoType tributocarsoc = fm.generateTributoMTX(feReq.getImporteGravado(), perCargasSoc, "", Short.parseShort("2"));				
				totalTributo = totalTributo + perCargasSoc;
				tributosList.add(tributocarsoc);												
			}
				
		} catch (NumberFormatException e) {
			errorParseo = "No se ha podido obtener la percepci�n de Cargas Sociales del campo 'RetCargasSoc'";
			e.printStackTrace();
		} catch (SQLException e) {
			errorParseo = "No se ha podido obtener la percepci�n de Cargas Sociales del campo 'RetCargasSoc'";
			e.printStackTrace();
		}			
		
		try {
			perRni = rs.getDouble("IvaRni");
			if (perRni>0){
				perRni = FormatUtil.redondearEn2(perRni);
				FacturaManagerImpl fm = new FacturaManagerImpl();
				OtroTributoType tributorni = fm.generateTributoMTX(feReq.getImporteGravado(), perRni, "", Short.parseShort("2"));				
				totalTributo = totalTributo + perRni;
				tributosList.add(tributorni);												
			}
				
		} catch (NumberFormatException e) {
			errorParseo = "No se ha podido obtener la percepci�n de Cargas Sociales del campo 'IvaRni'";
			e.printStackTrace();
		} catch (SQLException e) {
			errorParseo = "No se ha podido obtener la percepci�n de Cargas Sociales del campo 'IvaRni'";
			e.printStackTrace();
		}			

		try{
			if (tributosList.size() > 0){
				OtroTributoType[] tributos = new OtroTributoType[tributosList.size()];
				int i = 0;
				
				for(OtroTributoType tributo : tributosList){
					tributos[i] = tributo;				
					i++;
				}
				feReq.setArrayOtrosTributos(tributos);
				  
			}				
		}catch(Exception e){
			errorParseo = "Error al calcular las percepciones";
			e.printStackTrace();
		}
		
		Double impTotal = feReq.getImporteTotal().doubleValue();
		
		if (totalTributo > 0){
			feReq.setImporteOtrosTributos(BigDecimal.valueOf(FormatUtil.redondearEn2(totalTributo)));
		}
		
		feReq.setImporteTotal(BigDecimal.valueOf(FormatUtil.redondearEn2(totalTributo + impTotal)));
		
		System.out.println("Total Generador por SKS                 : " + totalSk + " TransacNr: " + transac);
		
		System.out.println("Total Generador por FEOL sin Percepiones: " + (FormatUtil.redondearEn2(impTotal)) + " TransacNr: " + transac);
		
		System.out.println("Total Generador por FEOL con Percepiones: " + (FormatUtil.redondearEn2(totalTributo + impTotal)) + " TransacNr: " + transac);
		//feReq.setErrorParseo(errorParseo);

		
		return feReq;

	}
	
	private ComprobanteType completeValoresIVA(Long transacNr, String rutaBase,ComprobanteType comprobanteType) {

		// connection to an ACCESS MDB
		Connection conn = getConnMDB(rutaBase);

		try {
			ResultSet rs;
			Statement stmt;
			String sql;

			if (useSQL){
				sql = "SELECT Gente.TipoIva,Stock.IvaGravado, Items.Precio, Items.Cant1, Items.Bonif, Items.TransacNr, "
					+ "Gente.Cuit, Transac.Fecha, Transac.TipoComprob, Transac.NrComprob, "
					+ "Transac.Prefijo, Transac.Vencim1, Transac.Total, Impuestos.Alicuota " +
					"FROM (Transac INNER JOIN (("+ rutaArticulo +".Stock as Stock INNER JOIN Items ON Stock.Clave = Items.Articulo COLLATE DATABASE_DEFAULT) " +
					"INNER JOIN "+ rutaComun +".Gente as Gente ON Items.GenteNr = Gente.GenteNr) ON (Gente.GenteNr = Transac.GenteNr) " +
					"AND (Transac.TransacNr = Items.TransacNr)) INNER JOIN Impuestos ON Stock.IvaGravado = " +
					"Impuestos.Nr WHERE (((Items.TransacNr)="+transacNr+"))";
			}else{
				sql = "SELECT Gente.TipoIva,Stock.IvaGravado, Items.Precio, Items.Cant1, Items.Bonif,Items.TransacNr, "
					+ "Gente.Cuit, Transac.Fecha, Transac.TipoComprob, Transac.NrComprob, "
					+ "Transac.Prefijo, Transac.Vencim1, Transac.Total, Impuestos.Alicuota " +
					"FROM (Transac INNER JOIN (("+ rutaArticulo +".Stock as Stock INNER JOIN Items ON Stock.Clave = Items.Articulo) " +
					"INNER JOIN "+ rutaComun +".Gente as Gente ON Items.GenteNr = Gente.GenteNr) ON (Gente.GenteNr = Transac.GenteNr) " +
					"AND (Transac.TransacNr = Items.TransacNr)) INNER JOIN Impuestos ON Stock.IvaGravado = " +
					"Impuestos.Nr WHERE (((Items.TransacNr)="+transacNr+"))";				
			}
			

			//System.out.println(sql);
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);

			Double neto = 0d;
			Double iva0 = -1d;
			Double iva10 = 0d;
			Double iva21 = 0d;
			Double iva27 = 0d;
			Double baseImp0 = 0d;
			Double baseImp10 = 0d;
			Double baseImp21 = 0d;
			Double baseImp27 = 0d;
			Double totalIVA = 0d;
			Double total = 0d;
			Double descuentoTotal = 0d;
			if (comprobanteType.getCodigoTipoComprobante() == Short.valueOf("6") || comprobanteType.getCodigoTipoComprobante() == Short.valueOf("7") || comprobanteType.getCodigoTipoComprobante() == Short.valueOf("8")){
				while (rs.next()) {

					Double precio = rs.getDouble("precio"); 
					Double porDesc = rs.getDouble("bonif");
					Double cantidad = rs.getDouble("cant1"); 
					if (cantidad == 0){
						cantidad = 1d;
					}
					Double descuento = (precio * porDesc) /100;
					Double baseImp = (precio * cantidad)- (descuento *cantidad) ;
					Double baseImpTotal = (precio * cantidad) ;
					//Double totalUnit = (precio * cantidad) - descuento;
					descuentoTotal = ((precio * porDesc) /100) * cantidad;
					
					Integer tipoIva = rs.getInt("TipoIva");
					Double alicouta = rs.getDouble("Alicuota"); 
					if (alicouta == null)
						alicouta = 0d;
					
					if (tipoIva != null && (tipoIva == 6 || tipoIva == 3)){
					//Solo Drofar
					//if (tipoIva != null && (tipoIva == 6 || tipoIva == 3 || tipoIva == 2 || tipoIva == 7 || tipoIva == 9 || tipoIva == 10 || tipoIva == 13)){
						alicouta = 0d;
					}
									
					if (alicouta.equals(0d)) {
						iva0 = 0d;
						baseImp0 = baseImp0 + baseImp;
					}
					if (alicouta.equals(21d)) {
						iva21 = iva21 + (baseImp * 21d / 100);
						baseImp21 = baseImp21 + baseImp;
					}
					if (alicouta.equals(10.5d)) {
						iva10 = iva10 + (baseImp * 10.5d / 100);
						baseImp10 = baseImp10 + baseImp;
					}				
					if (alicouta.equals(27d)) {
						iva27 = iva27 + (baseImp * 27d / 100);
						baseImp27 = baseImp27 + baseImp;
					}	
					neto = neto + (baseImpTotal - descuentoTotal);

				}

			}else{
				while (rs.next()) {

					Double precio = rs.getDouble("precio"); 
					Double porDesc = rs.getDouble("bonif");
					Double cantidad = rs.getDouble("cant1"); 
					if (cantidad == 0){
						cantidad = 1d;
					}
					Double descuento = (precio * porDesc) /100;
					Double totalUnit = (precio * cantidad) - (descuento * cantidad);
					
					Integer tipoIva = rs.getInt("TipoIva");
					Double alicouta = rs.getDouble("Alicuota"); 
					if (alicouta == null)
						alicouta = 0d;
					
					if (tipoIva != null && (tipoIva == 6 || tipoIva == 3)){
						alicouta = 0d;
					}
					if (alicouta.equals(0d)) {
						iva0 = 0d;
						baseImp0 = baseImp0 + totalUnit;
					}
					if (alicouta.equals(21d)) {
						iva21 = iva21 + (totalUnit * 21d / 100);
						baseImp21 = baseImp21 + totalUnit;
					}
					if (alicouta.equals(10.5d)) {
						iva10 = iva10 + (totalUnit * 10.5d / 100);
						baseImp10 = baseImp10 + totalUnit;
					}				
					if (alicouta.equals(27d)) {
						iva27 = iva27 + (totalUnit * 27d / 100);
						baseImp27 = baseImp27 + totalUnit;
					}	
					neto = neto + totalUnit;

				}
			}
			
			totalIVA = iva21 + iva10 + iva27;
			total = neto + iva21 + iva10 + iva27;
			/*
			boniftotal = (preciouni * (0.25) * cantidad)

			precioitem =  ((preciouni * cantidad) - boniftotal) * 0.21 


			gravado = (preciouni * cantidad) - boniftotal
			*/ 


			//Redondeo
			neto = FormatUtil.redondearEn2(neto);
			iva10 = FormatUtil.redondearEn2(iva10);
			iva21 = FormatUtil.redondearEn2(iva21);
			iva27 = FormatUtil.redondearEn2(iva27);
			baseImp10 = FormatUtil.redondearEn2(baseImp10);
			baseImp21 = FormatUtil.redondearEn2(baseImp21);
			baseImp27 = FormatUtil.redondearEn2(baseImp27);
			totalIVA = FormatUtil.redondearEn2(totalIVA);
			total = FormatUtil.redondearEn2(total);
			
			
			System.out.println("Total Neto: " + neto);
			System.out.println("Total IVA 21: " + iva21 );
			System.out.println("Total IVA 10.5: " + iva10);
			System.out.println("Total Bruto:  " + (total));
			
			
			List<SubtotalIVAType> subtotalIVATypeList = new ArrayList<SubtotalIVAType>();
				
			
			if (iva0 == 0){				
				//SubtotalIVAType alicIva0 = new SubtotalIVAType();
				//alicIva0.setCodigo(Short.valueOf("2"));				
				//alicIva0.setImporte(BigDecimal.valueOf(iva0));	
				//subtotalIVATypeList.add(alicIva0);				
			}
			
			if (iva21 > 0){				
				SubtotalIVAType alicIva21 = new SubtotalIVAType();
				alicIva21.setCodigo(Short.valueOf("5"));				
				alicIva21.setImporte(BigDecimal.valueOf(iva21));	
				subtotalIVATypeList.add(alicIva21);
			}
			if (iva10 > 0){				
				SubtotalIVAType alicIva10 = new SubtotalIVAType();
				alicIva10.setCodigo(Short.valueOf("5"));				
				alicIva10.setImporte(BigDecimal.valueOf(iva10));	
				subtotalIVATypeList.add(alicIva10);
			}
			if (iva27 > 0){				
				SubtotalIVAType alicIva27 = new SubtotalIVAType();
				alicIva27.setCodigo(Short.valueOf("6"));				
				alicIva27.setImporte(BigDecimal.valueOf(iva27));
				subtotalIVATypeList.add(alicIva27);
			}
			SubtotalIVAType[] alicIvas = null;	
			try{
				if (subtotalIVATypeList.size() > 0){
					alicIvas = new SubtotalIVAType[subtotalIVATypeList.size()];
					int i = 0;
					
					for(SubtotalIVAType alicIva : subtotalIVATypeList){
						alicIvas[i] = alicIva;				
						i++;
					}
					
					  
				}				
			}catch(Exception e){
				//comprobanteType.setErrorParseo("Error al calcular las percepciones");
				e.printStackTrace();
			}

			if (comprobanteType.getCodigoTipoComprobante() == Short.valueOf("6") || comprobanteType.getCodigoTipoComprobante() == Short.valueOf("7") || comprobanteType.getCodigoTipoComprobante() == Short.valueOf("8")){
				comprobanteType.setArraySubtotalesIVA(alicIvas);
				comprobanteType.setImporteTotal(BigDecimal.valueOf(total));
			}else{
				comprobanteType.setArraySubtotalesIVA(alicIvas);
				comprobanteType.setImporteTotal(BigDecimal.valueOf(total));
			}
			
			if(comprobanteType.getImporteGravado() == null){
				comprobanteType.setImporteGravado(BigDecimal.ZERO);
			}
			
			comprobanteType.setImporteGravado(BigDecimal.valueOf(FormatUtil.redondearEn2(comprobanteType.getImporteGravado().doubleValue())));
			
			comprobanteType.setImporteExento(BigDecimal.valueOf(FormatUtil.redondearEn2(comprobanteType.getImporteExento().doubleValue())));
			
			comprobanteType.setImporteSubtotal(BigDecimal.valueOf(neto));

			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}

		return comprobanteType;
	}

	
	
	
	public void updateBase(Long transacNr, String cae, String vencimiento, String rutaBase, String nrComprob, BigDecimal total) throws SQLException{
		
		// connection to an ACCESS MDB
		Connection conn = getConnMDB(rutaBase);	
		
		String query = "update transac set CAE = '" + cae + "', FechaCAE =  '" + vencimiento + "', NrComprob =  '" + nrComprob + 
        "', total =  " + total + " where transacNr = " + transacNr; 
        
		PreparedStatement pstmt  = conn.prepareStatement(query);
        pstmt.execute();
        pstmt.close();
        conn.close();
		 
	}
	
	public ComprobanteType getFacturaExt(Long transacNr, String rutaBase) {

		// connection to an ACCESS MDB
		Connection conn = getConnMDB(rutaBase);

		ComprobanteType cmp = null;
		try {
			ResultSet rs;
			Statement stmt;
			String sql;

			sql = "SELECT Transac.TipoComprob, Transac.NrComprob, Transac.IvaRni,Transac.RetIb, " +
					"Transac.RetIva, Transac.Total, Transac.internos,Transac.RetGan, Transac.RetCargasSoc, " +
					"Transac.Prefijo, Gente.Cuit, Transac.Fecha, Transac.TransacNr, Transac.Letra," +
					" Domicilios.RazonSocial, Domicilios.Domicilio, Domicilios.Pais, " +
					"Transac.TransacNr, Domicilios.DomiNr FROM (Transac INNER JOIN "+ rutaComun +".Gente as Gente ON " +
					"Transac.GenteNr = Gente.GenteNr) INNER JOIN "+ rutaComun +".Domicilios as Domicilios ON Gente.GenteNr = " +
					"Domicilios.GenteNr WHERE (((Transac.TransacNr)="	+ transacNr + " and Domicilios.DomiPrincipal = -1)) order by Domicilios.DomiNr desc";

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				cmp = makeComprobanteType(rs,transacNr,rutaBase);
			}

			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		
		return cmp;
	}



	
	private ComprobanteType completeValoresItems(Long transacNr, String rutaBase, ComprobanteType feReq) {

		// connection to an ACCESS MDB
		Connection conn = getConnMDB(rutaBase);

		try {
			ResultSet rs;
			Statement stmt;
			String sql;
			if (useSQL){
				sql = "SELECT Gente.TipoIva, Stock.codbarras,Stock.UniVenta, Stock.Descripcion, Stock.IvaGravado, Items.Precio, Items.Articulo,Items.Cant1, Items.bonif,Items.TransacNr, "
					+ "Gente.Cuit, Transac.Fecha, Transac.TipoComprob, Transac.NrComprob, "
					+ "Transac.Prefijo, Transac.Vencim1, Transac.Total, Impuestos.Alicuota " +
					"FROM (Transac INNER JOIN (("+ rutaArticulo +".Stock as Stock INNER JOIN Items ON Stock.Clave = Items.Articulo COLLATE DATABASE_DEFAULT) " +
					"INNER JOIN "+ rutaComun +".Gente as Gente ON Items.GenteNr = Gente.GenteNr) ON (Gente.GenteNr = Transac.GenteNr) " +
					"AND (Transac.TransacNr = Items.TransacNr)) INNER JOIN Impuestos ON Stock.IvaGravado = " +
					"Impuestos.Nr WHERE (((Items.TransacNr)="+transacNr+"))";				
			}else{
				sql = "SELECT Gente.TipoIva, Stock.codbarras, Stock.UniVenta, Stock.Descripcion, Stock.IvaGravado, Items.Precio, Items.Articulo,Items.Cant1, Items.bonif, Items.TransacNr, "
					+ "Gente.Cuit, Transac.Fecha, Transac.TipoComprob, Transac.NrComprob, "
					+ "Transac.Prefijo, Transac.Vencim1, Transac.Total, Impuestos.Alicuota " +
					"FROM (Transac INNER JOIN (("+ rutaArticulo +".Stock as Stock INNER JOIN Items ON Stock.Clave = Items.Articulo) " +
					"INNER JOIN "+ rutaComun +".Gente as Gente ON Items.GenteNr = Gente.GenteNr) ON (Gente.GenteNr = Transac.GenteNr) " +
					"AND (Transac.TransacNr = Items.TransacNr)) INNER JOIN Impuestos ON Stock.IvaGravado = " +
					"Impuestos.Nr WHERE (((Items.TransacNr)="+transacNr+"))";								
			}

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			List<ItemType> itemList = new ArrayList<ItemType>();
			Double total = 0d;
			while (rs.next()) {
				Double precio = rs.getDouble("precio"); 
				Double porDesc = rs.getDouble("bonif");
				Double cantidad = rs.getDouble("cant1"); 
				if (cantidad == 0){
					cantidad = 1d;
				}
				Double descuento = (precio * porDesc) /100;
				Double totalUnit = (precio * cantidad) - (descuento * cantidad);
				ItemType item = new ItemType();
				item.setDescripcion(rs.getString("Descripcion"));				 
				item.setCantidad(BigDecimal.valueOf(FormatUtil.redondearEn6(cantidad)));
				item.setUnidadesMtx(1);
				item.setCodigoUnidadMedida(Short.parseShort("7"));
				item.setCodigoMtx(rs.getString("codbarras"));
				Integer tipoIva = rs.getInt("TipoIva");
				Double codIva = rs.getDouble("Alicuota"); 
				if (codIva == null)
					codIva = 0d;
				
				if (tipoIva != null && (tipoIva == 6 || tipoIva == 3)){
					codIva = 0d;
				}
				
				Double importeIva = 0d;
				Double precioConIva = precio;
				Double descuentoTotal = 0d;
				if (feReq.getImporteGravado() == null)
					feReq.setImporteGravado(BigDecimal.ZERO);
				
				if (feReq.getImporteExento() == null)
					feReq.setImporteExento(BigDecimal.ZERO);
				Double valorIva = 0d;
				if (codIva != null){
					if (codIva.equals(21d)){
						item.setCodigoCondicionIVA(Short.parseShort("5"));
						importeIva = (totalUnit * 21) / 100;
						precioConIva = precio + ((precio  * 21) / 100);
						descuentoTotal = descuento + ((descuento  * 21) / 100);
						feReq.setImporteGravado(BigDecimal.valueOf(feReq.getImporteGravado().doubleValue() + totalUnit));
						valorIva = 21d;
						 
					}
					if (codIva.equals(10.5d)){
						item.setCodigoCondicionIVA(Short.parseShort("4"));
						importeIva = (totalUnit * 10.5) / 100;
						precioConIva = precio + ((precio  * 10.5) / 100);
						descuentoTotal = descuento + ((descuento  * 10.5) / 100);
						feReq.setImporteGravado(BigDecimal.valueOf(feReq.getImporteGravado().doubleValue() + totalUnit));
						valorIva = 10.5d;
					}
					if (codIva.equals(0d)){
						item.setCodigoCondicionIVA(Short.parseShort("2"));
						feReq.setImporteExento(BigDecimal.valueOf(feReq.getImporteExento().doubleValue() + totalUnit));
						if (feReq.getImporteGravado() == null){
							feReq.setImporteGravado(BigDecimal.ZERO);
						}
						descuentoTotal = descuento;
						importeIva = 0d;
						valorIva = 0d;
					}
					if (codIva.equals(27d)){
						item.setCodigoCondicionIVA(Short.parseShort("6"));
						importeIva = (totalUnit * 27) / 100;
						precioConIva = precio  + ((precio  * 27) / 100);
						descuentoTotal = descuento + ((descuento  * 27) / 100);
						feReq.setImporteGravado(BigDecimal.valueOf(feReq.getImporteGravado().doubleValue() + totalUnit));
						valorIva = 27d;
					}

				}
				Double importeItem = 0d;
				//importeItem = totalUnit + importeIva;
				descuento = (FormatUtil.redondearEn6(descuento));
				precio = (FormatUtil.redondearEn2(precio));
				//Si es factura B
				if (feReq.getCodigoTipoComprobante() == Short.valueOf("6") || feReq.getCodigoTipoComprobante() == Short.valueOf("7") || feReq.getCodigoTipoComprobante() == Short.valueOf("8")){
					
					//item.setImporteItem(BigDecimal.valueOf(FormatUtil.redondearEn2((precioConIva * cantidad) - (descuentoTotal * cantidad))));
					//item.setImporteItem(BigDecimal.valueOf(FormatUtil.redondearEn2((precio * cantidad - descuentoTotal) * (1 + (valorIva/ 100)))));
					BigDecimal precioUnitario = BigDecimal.valueOf(FormatUtil.redondearEn6(precioConIva));
					item.setPrecioUnitario(precioUnitario);
					item.setImporteBonificacion(BigDecimal.valueOf(FormatUtil.redondearEn6(descuentoTotal * cantidad)));
					importeItem = BigDecimal.valueOf(FormatUtil.redondearEn2((precio * cantidad - (descuentoTotal*cantidad)) * (1 + (valorIva/ 100)))).doubleValue();
					item.setImporteItem(BigDecimal.valueOf(FormatUtil.redondearEn2(importeItem)));
					System.out.println("precio: " + precio);
					System.out.println("cantidad: " + cantidad);
					System.out.println("descuentoTotal: " + descuentoTotal);
					System.out.println("valorIva: " + valorIva);
					System.out.println("importeItem " + importeItem);

					
				}else{
					item.setImporteIVA(BigDecimal.valueOf(FormatUtil.redondearEn2(importeIva)));
					//item.setImporteIVA(BigDecimal.valueOf(FormatUtil.redondearEn2(((precio * cantidad) - FormatUtil.redondearEn2(descuentoTotal * cantidad)) * (codIva/100))));
					//item.setImporteItem(BigDecimal.valueOf(FormatUtil.redondearEn2(importeItem)));
					importeItem = BigDecimal.valueOf(FormatUtil.redondearEn2((precio * cantidad - (descuento * cantidad)) * (1 + (valorIva/ 100)))).doubleValue();
					item.setImporteItem(BigDecimal.valueOf(FormatUtil.redondearEn2(importeItem)));
					System.out.println("precio: " + precio);
					System.out.println("cantidad: " + cantidad);
					System.out.println("descuento: " + descuento);
					System.out.println("valorIva: " + valorIva);
					System.out.println("importeItem " + importeItem);

					//item.setImporteItem(BigDecimal.valueOf(FormatUtil.redondearEn2(((precio * cantidad) - FormatUtil.redondearEn2(descuentoTotal * cantidad)) * (1 + (codIva/100)))));
					item.setPrecioUnitario(BigDecimal.valueOf(FormatUtil.redondearEn2(precio)));
					
					item.setImporteBonificacion(BigDecimal.valueOf(FormatUtil.redondearEn6(descuento * cantidad)));
				}
				Double totalItem = 0d;
				
				if (feReq.getCodigoTipoComprobante() == Short.valueOf("6") || feReq.getCodigoTipoComprobante() == Short.valueOf("7") || feReq.getCodigoTipoComprobante() == Short.valueOf("8")){
					totalItem = (totalUnit);		
				}else{
					totalItem = (importeItem);
				}
								
				
				total = total + totalItem;
				itemList.add(item);
			}
			total = FormatUtil.redondearEn2(total);
			feReq.setImporteTotal(BigDecimal.valueOf(total));
			
			ItemType[] itemsDesa = null;	
			try{
				if (itemList.size() > 0){
					itemsDesa = new ItemType[itemList.size()];
					int i = 0;
					
					for(ItemType itemDesa : itemList){
						itemsDesa[i] = itemDesa;				
						i++;
					}
					
					  
				}				
			}catch(Exception e){
				//feReq.setErrorParseo("Error al calcular las percepciones");
				e.printStackTrace();
			}
			feReq.setArrayItems(itemsDesa);

			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}

		return feReq;
	}

	private int getUnidadMedida(String valor){
		if (valor != null){
			if(valor.trim().indexOf("u") == -1 && valor.trim().indexOf("U") == -1){
				if(valor.trim().indexOf("k") == -1 && valor.trim().indexOf("K") == -1 ){
					if(valor.trim().indexOf("t") == -1 && valor.trim().indexOf("T") == -1 ){
						return 1;
					}else{
						return 2;
					}
					
				}else{
					return 1;
				}
				
			}else{
				return 7;
			}		
	}else{
		return 1;
	}
	}
		
}
