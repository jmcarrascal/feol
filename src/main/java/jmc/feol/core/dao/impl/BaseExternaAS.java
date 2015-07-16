package jmc.feol.core.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import jmc.feol.core.model.Usuario;
import jmc.feol.core.service.impl.FacturaManagerImpl;
import jmc.feol.util.DateUtil;
import jmc.feol.util.FormatUtil;
import FEV1.dif.afip.gov.ar.AlicIva;
import FEV1.dif.afip.gov.ar.FECAECabRequest;
import FEV1.dif.afip.gov.ar.FECAEDetRequest;
import FEV1.dif.afip.gov.ar.FECAERequest;
import FEV1.dif.afip.gov.ar.Tributo;

public class BaseExternaAS {
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

	
	public BaseExternaAS(String contralador, String urlBase, String rutaComun, String rutaArticulo, String usr, String password) {
		this.setUrlBase(urlBase);
		this.setControlador(contralador);
		this.setRutaArticulo(rutaArticulo);
		this.setRutaComun(rutaComun);
		this.setUsr(usr);
		this.setPassword(password);		
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

	public Connection getConnAS() {

			String direccion = urlBase;
			try {
				DriverManager.registerDriver(new com.ibm.as400.access.AS400JDBCDriver());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			Connection conn = null;
			try {
				 	Properties prop = new Properties();		            
		            prop.put("user", usr);
		            prop.put("password", password);
		            
				conn = DriverManager.getConnection(direccion,prop);
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

	private FECAERequest makeFECAERequest(ResultSet rs, Long transac)
			throws SQLException {

		// Carga del objeto FERequet
		FECAERequest feReq = new FECAERequest();
		String errorParseo = "";
		// Cargo Cabezera.

		FECAECabRequest feCabecera = new FECAECabRequest();
		feCabecera.setCantReg(1);
		int tipoComp = 0;
		
		
		try {
			tipoComp = rs.getInt("FECOCO");
		} catch (SQLException e) {
			errorParseo = "No se ha podido obtener el Tipo de Comprobante del campo 'FECOCO'";
			e.printStackTrace();
		}

				
		feCabecera.setCbteTipo(tipoComp);
		
		try {
			feCabecera.setPtoVta(rs.getInt("FEPREF"));
		} catch (NumberFormatException e) {
			errorParseo = "No se ha podido obtener el Punto de Venta del campo 'FEPREF'";
			e.printStackTrace();
		} catch (SQLException e) {
			errorParseo = "No se ha podido obtener el Punto de Venta del campo 'FEPREF'";
			e.printStackTrace();
		}

		feReq.setFeCabReq(feCabecera);

		// Cargo el detalle.
		FECAEDetRequest[] feDetalles = new FECAEDetRequest[1];
		FECAEDetRequest feDetalle = new FECAEDetRequest();
		try {
			feDetalle.setCbteDesde(rs.getLong("FENRDE"));
		} catch (NumberFormatException e) {
			errorParseo = "No se ha podido obtener el Numero del campo 'FENRDE'";
			e.printStackTrace();
		} catch (SQLException e) {
			errorParseo = "No se ha podido obtener el Numero del campo 'FENRDE'";
			e.printStackTrace();
		}

		feDetalle.setCbteHasta(feDetalle.getCbteDesde());
		try{
			feDetalle.setCbteFch(String.valueOf(rs.getLong("FEFEFC")));
		}catch(Exception e){
			errorParseo = "No se ha podido obtener la fecha del campo 'FEFEFC'";
			e.printStackTrace();			
		}
		
		feDetalle.setConcepto(1);
		
		try{			
			feDetalle.setDocNro(rs.getLong("FECUCL"));								
		}catch(Exception e){
			errorParseo = "No se ha podido obtener CUIT o el tipo de documento del campo 'FECUCL'";
			e.printStackTrace();						
		}
						
		String monId = rs.getString("FECOMO");
		if(monId.trim().equals("")){
			feDetalle.setMonId("PES");
			feDetalle.setMonCotiz(1d);			
		}else{
			feDetalle.setMonId(monId);
			feDetalle.setMonCotiz(rs.getDouble("FECOTI"));
		}
		
		feDetalle.setDocTipo(rs.getInt("FETIDO"));
		
		feDetalle.setFchServDesde(rs.getString("FESRVD"));
		
		feDetalle.setFchServHasta(rs.getString("FESRVH"));
		
		feDetalle.setFchVtoPago(rs.getString("FEFEVT"));
		
		feDetalle.setImpIVA(rs.getDouble("FEIMLI"));
		
		feDetalle.setImpNeto(rs.getDouble("FEIMGR"));
		
		feDetalle.setImpOpEx(rs.getDouble("FEIMEX"));
		
		feDetalle.setImpTotal(rs.getDouble("FEIMTO"));
		
		feDetalle.setImpTotConc(rs.getDouble("FEIMNG"));
		
		feDetalle.setImpTrib(rs.getDouble("FEIMNI"));
				
		feDetalle = this.loadTributos(feDetalle, transac);
		
		feDetalle = this.loadAlicIva(feDetalle, transac);
				
		feDetalles[0] = feDetalle; 
		
		feReq.setFeDetReq(feDetalles);
				
		feReq.setErrorFE(errorParseo);
		
		return feReq;

	}
	
	private FECAEDetRequest loadTributos(FECAEDetRequest feDetalle, Long fesose){
		
		Connection conn = getConnAS();
		
		List<Tributo> tributosList = new ArrayList<Tributo>();
		
		try {
			
			ResultSet rs;
			Statement stmt;
			String sql;
			
			sql = "SELECT FETRCO,FETRDE, FETRBI,FETRAL,FETRIM,FESOSE FROM VTELET00 WHERE FESOSE = " + fesose ;				

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {  
				Tributo tributo = new Tributo();
				tributo.setBaseImp(rs.getDouble("FETRBI"));
				tributo.setId(rs.getShort("FETRCO"));
				tributo.setAlic(rs.getDouble("FETRAL"));
				tributo.setImporte(rs.getDouble("FETRIM"));
				tributo.setDesc(rs.getString("FETRDE"));
				tributosList.add(tributo);
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
		try{
			if (tributosList.size() > 0){
				Tributo[] tributos = new Tributo[tributosList.size()];
				int i = 0;
				
				for(Tributo tributo : tributosList){
					tributos[i] = tributo;				
					i++;
				}
				feDetalle.setTributos(tributos);
				  
			}				
		}catch(Exception e){			
			e.printStackTrace();
		}
		return feDetalle;
	}
	
	private FECAEDetRequest loadAlicIva(FECAEDetRequest feDetalle, Long fesose){
		
		Connection conn = getConnAS();
		
		List<AlicIva> alicIvaList = new ArrayList<AlicIva>();
		
		try {
			
			ResultSet rs;
			Statement stmt;
			String sql;
			
			sql = "SELECT FEIVCO,FEIVBI, FEIVIM FROM VTELEI00 WHERE FESOSE = " + fesose ;				

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				AlicIva alicIva = new AlicIva();
				alicIva.setBaseImp(rs.getDouble("FEIVBI"));
				alicIva.setId(rs.getShort("FEIVCO"));
				alicIva.setImporte(rs.getDouble("FEIVIM")); 
				alicIvaList.add(alicIva);
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
		try{
			if (alicIvaList.size() > 0){
				AlicIva[] alicIvas = new AlicIva[alicIvaList.size()];
				int i = 0;
				
				for(AlicIva alicIva : alicIvaList){
					alicIvas[i] = alicIva;				
					i++;
				}
				feDetalle.setIva(alicIvas);
				  
			}				
		}catch(Exception e){			
			e.printStackTrace();
		}
		return feDetalle;
	}

	public void updateBase(Long transacNr, String cae, Long vencimiento, Long nrComprob, String resultado) throws SQLException{
		
		if (resultado != null && resultado.length() > 77){
			resultado = resultado.substring(0, 76);
		}
		// connection to an ACCESS MDB
		Connection conn = getConnAS();	
		//FECAE, FECAEV, FERESU, FEMOTI, FERESU
		String query = "update VTELEE00 set FECAE = '" + cae + "', FERESU =  '" + resultado + "', FECAEV =  " + vencimiento + ", FENRDE =  " + nrComprob + ", FENRHA =  " + nrComprob + " " +
				"where fesose = " + transacNr; 
        
		PreparedStatement pstmt  = conn.prepareStatement(query);
        pstmt.execute();
        pstmt.close();
        conn.close();
        
	}
	public FECAERequest getFacturaExt(Long transacNr) {

		// connection AS
		Connection conn = getConnAS();

		FECAERequest fECAERequest = null;
		try {
			ResultSet rs;
			Statement stmt;
			String sql;
			
			sql = "SELECT FEID, FESEBI, FECANR, FETIDO, FECUCL, FECOCO, FEPREF, " +
					"FENRDE, FENRHA, FEIMTO, FEIMNG, FEIMGR, FEIMLI, FEIMNI, FEIMEX, " +
					"FESRVD, FESRVH, FEFEVT,  FEFEFC, FECAE, FECAEV, FERESU, FEMOTI,FEPLD, " +
					"FESOSE, FECOMO, FECOTI FROM VTELEE00 WHERE FESOSE = " + transacNr ;				

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				fECAERequest = makeFECAERequest(rs,transacNr);
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
		
		return fECAERequest;
	}

	public String getTipoFactura(Long transacNr, String rutaBase) {

		String result = "NA";
		
		Connection conn = getConnAS();

		try {
			ResultSet rs;
			Statement stmt;
			String sql;

			sql = "SELECT Transac.TransacNr, Transac.Letra, Transac.TipoComprob "
				  + "FROM Transac WHERE (((Transac.TransacNr)="
				  + transacNr + "))";

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int tipoComp = 0;
				String letra="";
				try {
					tipoComp = rs.getInt("TipoComprob");
				} catch (SQLException e) {
					e.printStackTrace();
				}

				try {
					letra = rs.getString("Letra");
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				
				
				if (tipoComp == 1 && letra.trim().equals("A")){
					result = "AB";
				}
				if (tipoComp == 1 && letra.trim().equals("B")){
					result = "AB";
				}
				if (tipoComp == 2 && letra.trim().equals("A")){
					result = "AB";
				}
				if (tipoComp == 2 && letra.trim().equals("B")){
					result = "AB";
				}
				if (tipoComp == 7 && letra.trim().equals("A")){
					result = "AB";
				}
				if (tipoComp == 7 && letra.trim().equals("B")){
					result = "AB";
				}
				if (letra.trim().equals("E")){
					result = "E";
				}
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
		
		return result;
	}

	

	public Usuario getUsuario(String cuit, String rutaBase) {

		Usuario usuario = null;
		return usuario;
	}

}
