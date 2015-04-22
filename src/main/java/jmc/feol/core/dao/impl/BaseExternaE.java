package jmc.feol.core.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fex.dif.afip.gov.ar.ClsFEXRequestDesa;
import fex.dif.afip.gov.ar.ItemDesa;
import fex.dif.afip.gov.ar.PermisoDesa;

import jmc.feol.core.service.impl.FacturaManagerImpl;
import jmc.feol.util.DateUtil;
import jmc.feol.util.FormatUtil;
import FEV1.dif.afip.gov.ar.AlicIva;
import FEV1.dif.afip.gov.ar.FECAECabRequest;
import FEV1.dif.afip.gov.ar.FECAEDetRequest;
import FEV1.dif.afip.gov.ar.FECAERequest;
import FEV1.dif.afip.gov.ar.Tributo;

public class BaseExternaE {
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

	public BaseExternaE(String contralador, String urlBase, String rutaComun, String rutaArticulo) {
		this.setUrlBase(urlBase);
		this.setControlador(contralador);
		this.setRutaArticulo(rutaArticulo);
		this.setRutaComun(rutaComun);
	}
	
	public BaseExternaE(String contralador, String urlBase, String rutaComun, String rutaArticulo, String usr, String password) {
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

	
	

	private ClsFEXRequestDesa makeClsFEXRequestDesa(ResultSet rs, Long transac, String rutaBase)
			throws Exception {
		System.out.println("1");
		// Carga del objeto FERequet
		ClsFEXRequestDesa feReq = new ClsFEXRequestDesa();
		System.out.println("2");
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
		System.out.println("3");
		try {
			letra = rs.getString("Letra");
		} catch (SQLException e) {
			errorParseo = "No se ha podido obtener el Tipo de Comprobante del campo 'TipoComprob'";
			e.printStackTrace();
		}
		System.out.println("4");
		short tipoCompAfip = 0;
		if (tipoComp == 1 && letra.trim().equals("E")){
			tipoCompAfip = 19;
		}
		if (tipoComp == 2 && letra.trim().equals("E")){
			tipoCompAfip = 21;
		}
		if (tipoComp == 7 && letra.trim().equals("E")){
			tipoCompAfip = 20;
		}
						
		feReq.setTipo_cbte(tipoCompAfip);
		
		try {
			feReq.setPunto_vta(Short.parseShort(rs.getString("Prefijo")));
		} catch (NumberFormatException e) {
			errorParseo = "No se ha podido obtener el Punto de Venta del campo 'Prefijo'";
			e.printStackTrace();
		} catch (SQLException e) {
			errorParseo = "No se ha podido obtener el Punto de Venta del campo 'Prefijo'";
			e.printStackTrace();
		}	
		System.out.println("5");
		try {
			feReq.setCbte_nro(Long.parseLong(rs.getString("NrComprob")));
		} catch (NumberFormatException e) {
			errorParseo = "No se ha podido obtener el Numero del campo 'NrComprob'";
			e.printStackTrace();
		} catch (SQLException e) {
			errorParseo = "No se ha podido obtener el Numero del campo 'NrComprob'";
			e.printStackTrace();
		}
		System.out.println("6");

		try{
			feReq.setFecha_cbte(DateUtil.getCanonicalFech(rs.getDate("fecha")));
			//feReq.setFecha_cbte(DateUtil.getCanonicalFech(new Date(System.currentTimeMillis())));
		}catch(Exception e){
			errorParseo = "No se ha podido obtener la fecha del campo 'Fecha'";
			e.printStackTrace();			
		}
		System.out.println("7");
		feReq.setTipo_expo(Short.parseShort("1"));
		System.out.println("8");
		try{
			feReq.setDst_cmp(Short.parseShort(rs.getString("pais").substring(0, 3)));
		}catch(Exception e){
			//Pais Destino
			feReq.setDst_cmp(Short.parseShort("200"));
		}
		if (feReq.getDst_cmp() == 200){
			//Moneda Fija pedido por sk
			feReq.setMoneda_Id("PES");			
			feReq.setMoneda_ctz(1d);			
		}else{
			//Obtengo de la tabla paranComun el monedaId, buscando en el campo Strin donde el campo switch es = a feReq.getDst_cmp()  
			String tipoMoneda = getTipoMoneda(rutaBase, feReq.getDst_cmp());
			feReq.setMoneda_Id(tipoMoneda);			
			
			//Obtengo de la tabla preferencias la cotizacion donde nr = 2
			Double ctz = getCtz(rutaBase);
			feReq.setMoneda_ctz(ctz);						
		}
		//Cliente
		feReq.setCliente(rs.getString("RazonSocial"));
		
		//Incoterms
		//feReq.setIncoterms("FOB");
		feReq.setIncoterms(rs.getString("ordenCompra"));
		//Cuit pais Cliente							
		try{
			String doc = rs.getString("cuit");
			feReq.setCuit_pais_cliente(FormatUtil.formatCuit(doc));		
			System.out.println(feReq.getCuit_pais_cliente());
		}catch(Exception e){
			errorParseo = "No se ha podido obtener CUIT o el tipo de documento del campo 'cuit'";
			e.printStackTrace();						
		}
		
				
		//Domicilio Cliente
		feReq.setDomicilio_cliente(rs.getString("domicilio"));
				
		//Domicilio Cliente
		feReq.setImp_total(rs.getDouble("total"));
		
		//Idioma
		feReq.setIdioma_cbte(Short.parseShort("1"));

		//Permiso Existente		
		if(tipoCompAfip == 19){
			feReq.setPermiso_existente("N");
		}else{
			feReq.setPermiso_existente("");
		}

		//Permiso de Embarque
		String permiso = rs.getString("urgencia");
		String per = permiso.trim();
		if (!per.equals(".")){
			feReq.setPermiso_existente("S");
			PermisoDesa[] permisos = new PermisoDesa[1];
			PermisoDesa permiso_1 = new PermisoDesa();
			permiso_1.setId_permiso(per);
			permiso_1.setDst_merc(feReq.getDst_cmp());
			permisos[0] = permiso_1;
			feReq.setPermisos(permisos);
		}
		
		feReq.setErrorParceso(errorParseo);
				
		
		System.out.println("Llego a antes de completeVAloresItems");
		feReq = this.completeValoresItems(transac, rutaBase, feReq);		
		
		return feReq;

	}
	
	private Double getCtz(String rutaBase) {
		Double result = 1d;
		System.out.println("Entro a getCtz");
		System.out.println("La base es " + rutaBase);
		// connection to an ACCESS MDB
		Connection conn = getConnMDB(rutaBase);

		try {
			ResultSet rs;
			Statement stmt;
			String sql;

			sql = "select valor from preferencias where nr = 2";

			System.out.println(sql);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				try{
					result = Double.parseDouble(rs.getString("valor"));
				}catch(NumberFormatException nex){
					nex.printStackTrace();
				}
			}
			System.out.println("Cotizacion = " + result);
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
		
		
		return result;
	}

	private String getTipoMoneda(String rutaBase, short dst_cmp) {
		System.out.println("Entro a getTipoMoneda");
		String result = "";
		// connection to an ACCESS MDB
		Connection conn = getConnMDB(rutaBase);

		try {
			ResultSet rs;
			Statement stmt;
			String sql;

			sql = "select strin from "+ rutaComun +".paramComun where switch =  " + dst_cmp;

			System.out.println(sql);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				result = rs.getString("strin");
			}
			System.out.println("Tipo Moneda = " + result);
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
		
		return result;
	}

	public void updateBase(Long transacNr, String cae, String vencimiento, String rutaBase, String nrComprob) throws SQLException{
		
		// connection to an ACCESS MDB
		Connection conn = getConnMDB(rutaBase);	
		
		String query = "update transac set CAE = '" + cae + "', FechaCAE =  '" + vencimiento + "', NrComprob =  '" + nrComprob + 
        "' where transacNr = " + transacNr; 
        
		PreparedStatement pstmt  = conn.prepareStatement(query);
        pstmt.execute();
        pstmt.close();
        conn.close();
		 
	}
	
	public void updateBase(Long transacNr, String cae, String vencimiento, String rutaBase, String nrComprob, Double total) throws SQLException{
		
		// connection to an ACCESS MDB
		Connection conn = getConnMDB(rutaBase);	
		
//		String query = "update transac set CAE = '" + cae + "', FechaCAE =  '" + vencimiento + "', NrComprob =  '" + nrComprob + 
//        "', total =  " + total + " where transacNr = " + transacNr; 
        
		String query = "update transac set CAE = '" + cae + "', FechaCAE =  '" + vencimiento + "', NrComprob =  '" + nrComprob + 
        "' where transacNr = " + transacNr; 

		PreparedStatement pstmt  = conn.prepareStatement(query);
        pstmt.execute();
        pstmt.close();
        conn.close();
		 
	}

	public ClsFEXRequestDesa getFacturaExt(Long transacNr, String rutaBase) {
		System.out.println("Entro a getFacturaExt");
		// connection to an ACCESS MDB
		Connection conn = getConnMDB(rutaBase);

		ClsFEXRequestDesa cmp = null;
		try {
			ResultSet rs;
			Statement stmt;
			String sql;

			sql = "SELECT Transac.urgencia, Transac.TipoComprob, Transac.NrComprob, Transac.RetIb, " +
					"Transac.RetIva, Transac.Total, Transac.RetGan, Transac.RetCargasSoc, " +
					"Transac.Prefijo, Gente.Cuit, Transac.Fecha, Transac.TransacNr, Transac.Letra," +
					"Gente.\"Razon Social\" as RazonSocial, Domicilios.Domicilio, Domicilios.Pais, " +
					"Transac.ordenCompra,Transac.TransacNr, Domicilios.DomiNr FROM (Transac INNER JOIN "+ rutaComun +".Gente as Gente ON " +
					"Transac.GenteNr = Gente.GenteNr) INNER JOIN "+ rutaComun +".Domicilios as Domicilios ON Gente.GenteNr = " +
					"Domicilios.GenteNr WHERE (((Transac.TransacNr)="	+ transacNr + ")) and Domicilios.domiNr = Transac.NrDomicilioEnt order by Domicilios.DomiNr desc";

			System.out.println(sql);
			System.out.println(conn);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				cmp = makeClsFEXRequestDesa(rs,transacNr,rutaBase);
				System.out.println("Encontro transac");
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



	
	private ClsFEXRequestDesa completeValoresItems(Long transacNr, String rutaBase,
			ClsFEXRequestDesa feReq) {

		// connection to an ACCESS MDB
		Connection conn = getConnMDB(rutaBase);

		try {
			ResultSet rs;
			Statement stmt;
			String sql;
			if (useSQL){
				sql = "SELECT Stock.UniVenta, Stock.Descripcion, Stock.IvaGravado, Items.Precio, Items.Cant1, Items.bonif,Items.TransacNr, "
					+ "Gente.Cuit, Transac.Fecha, Transac.TipoComprob, Transac.NrComprob, "
					+ "Transac.Prefijo, Transac.Vencim1, Transac.Total, Impuestos.Alicuota " +
					"FROM (Transac INNER JOIN (("+ rutaArticulo +".Stock as Stock INNER JOIN Items ON Stock.Clave = Items.Articulo COLLATE DATABASE_DEFAULT) " +
					"INNER JOIN "+ rutaComun +".Gente as Gente ON Items.GenteNr = Gente.GenteNr) ON (Gente.GenteNr = Transac.GenteNr) " +
					"AND (Transac.TransacNr = Items.TransacNr)) INNER JOIN Impuestos ON Stock.IvaGravado = " +
					"Impuestos.Nr WHERE (((Items.TransacNr)="+transacNr+"))";				
			}else{
				sql = "SELECT Stock.UniVenta, Stock.Descripcion, Stock.IvaGravado, Items.Precio, Items.Cant1, Items.bonif, Items.TransacNr, "
					+ "Gente.Cuit, Transac.Fecha, Transac.TipoComprob, Transac.NrComprob, "
					+ "Transac.Prefijo, Transac.Vencim1, Transac.Total, Impuestos.Alicuota " +
					"FROM (Transac INNER JOIN (("+ rutaArticulo +".Stock as Stock INNER JOIN Items ON Stock.Clave = Items.Articulo) " +
					"INNER JOIN "+ rutaComun +".Gente as Gente ON Items.GenteNr = Gente.GenteNr) ON (Gente.GenteNr = Transac.GenteNr) " +
					"AND (Transac.TransacNr = Items.TransacNr)) INNER JOIN Impuestos ON Stock.IvaGravado = " +
					"Impuestos.Nr WHERE (((Items.TransacNr)="+transacNr+"))";								
			}

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			List<ItemDesa> itemList = new ArrayList<ItemDesa>();
			Double total = 0d;
			while (rs.next()) {
				Double precio = 0d;
				if (feReq.getMoneda_Id().equals("PES")){
					precio = rs.getDouble("precio");
				}else{
					precio = rs.getDouble("precio") / feReq.getMoneda_ctz();
				}
				
				Double porDesc = rs.getDouble("bonif");
				Double cantidad = rs.getDouble("cant1"); 
				if (cantidad == 0){
					cantidad = 1d;
				}
				Double descuento = (precio * porDesc) /100;
				Double totalUnit = (precio - descuento)
						* cantidad;
				ItemDesa item = new ItemDesa();
				item.setPro_ds(rs.getString("Descripcion"));				 
				item.setPro_qty(0);
				//item.setPro_qty(cantidad);
				item.setPro_umed(0);				
				//Double precioUni = FormatUtil.redondearEn2(precio);
				//item.setPro_precio_uni(precioUni);
				item.setPro_precio_uni(0);
				Double totalItem = (FormatUtil.redondearEn2(totalUnit));				
				item.setPro_total_item(totalItem);
				total = total + totalItem;
				itemList.add(item);
			}
			total = FormatUtil.redondearEn2(total);
			System.out.println("Total genrado por FEOL: " + total);
			System.out.println("Total genrado por SKS: " + feReq.getImp_total());
			
			feReq.setImp_total(total);
			
			ItemDesa[] itemsDesa = null;	
			try{
				if (itemList.size() > 0){
					itemsDesa = new ItemDesa[itemList.size()];
					int i = 0;
					
					for(ItemDesa itemDesa : itemList){
						itemsDesa[i] = itemDesa;				
						i++;
					}
					
					  
				}				
			}catch(Exception e){
				feReq.setErrorParceso("Error al calcular las percepciones");
				e.printStackTrace();
			}
			feReq.setItems(itemsDesa);

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
