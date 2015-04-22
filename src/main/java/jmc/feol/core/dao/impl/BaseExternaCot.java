package jmc.feol.core.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringEscapeUtils;

import jmc.feol.core.model.Usuario;
import jmc.feol.core.model.cot.Viajes;
import jmc.feol.core.service.impl.FacturaManagerImpl;
import jmc.feol.util.DateUtil;
import jmc.feol.util.FileUtil;
import jmc.feol.util.FormatUtil;
import FEV1.dif.afip.gov.ar.AlicIva;
import FEV1.dif.afip.gov.ar.FECAECabRequest;
import FEV1.dif.afip.gov.ar.FECAEDetRequest;
import FEV1.dif.afip.gov.ar.FECAERequest;
import FEV1.dif.afip.gov.ar.Tributo;

public class BaseExternaCot {
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
	private String baseComun;
	private String baseEmpresa;
	private String baseStock;	
	
		
	public String getBaseComun() {
		return baseComun;
	}

	public void setBaseComun(String baseComun) {
		this.baseComun = baseComun;
	}

	public String getBaseEmpresa() {
		return baseEmpresa;
	}

	public void setBaseEmpresa(String baseEmpresa) {
		this.baseEmpresa = baseEmpresa;
	}

	public String getBaseStock() {
		return baseStock;
	}

	public void setBaseStock(String baseStock) {
		this.baseStock = baseStock;
	}

	public Boolean getUseSQL() {
		return useSQL;
	}

	public void setUseSQL(Boolean useSQL) {
		this.useSQL = useSQL;
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

	public BaseExternaCot(String controlador, String urlBase, String user,
			String password,String baseComun,String baseEmpresa,String baseStock) {
		this.setUrlBase(urlBase);
		this.setControlador(controlador);
		this.setUsr(user);
		this.setPassword(password);
		this.useSQL = true;
		this.baseComun= baseComun;
		this.baseEmpresa = baseEmpresa;
		this.baseStock=baseStock;
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

	public Connection getConnSQL() {

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
			
		
	}	

	private FECAERequest makeFECAERequest(ResultSet rs, Long transac, String rutaBase)
			throws SQLException {

		return null;
	}
	
//	public void updateBase(Long transacNr, String cae, String vencimiento, String rutaBase, String nrComprob) throws SQLException{
//		
//		// connection to an ACCESS MDB
//		Connection conn = getConnMDB(rutaBase);	
//		
//		String query = "update transac set CAE = '" + cae + "', FechaCAE =  '" + vencimiento + "', NrComprob =  '" + nrComprob + 
//        "' where transacNr = " + transacNr; 
//        
//		PreparedStatement pstmt  = conn.prepareStatement(query);
//        pstmt.execute();
//        pstmt.close();
//        conn.close();
//        
//        
//	}
	
	public List<Viajes> getViajesSinCot(Long viajeNr) {

		// connection to an ACCESS MDB
		Connection conn = getConnSQL();
		Viajes viaje = new Viajes();
		List<Viajes> viajeList = new ArrayList<Viajes>();
		try {
			ResultSet rs;
			Statement stmt;
			String sql = "";

			sql = "select * from viajes where viajenr >= " + viajeNr + " order by fecha desc " ;
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				viaje= makeListViajes(rs);
				viajeList.add(viaje);
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
		
		return viajeList;
	}

	private Viajes makeListViajes(ResultSet rs) {
		Viajes viaje = new Viajes();
		
		try {
			viaje.setViajeNr(rs.getInt("viajeNr"));
			viaje.setFecha(rs.getDate("fecha"));
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return viaje;
	}

	public Usuario getUsuario(String cuit, String rutaBase) {

		Usuario usuario = null;
		return usuario;
	}

	public List<String> getLineasFileCot(int viajeNr, String cuit, String razon, String domicilioEmp, String numero, String localidad, String patente) {
		
		// connection to an ACCESS MDB
		Connection conn = getConnSQL();
		Viajes viaje = new Viajes();
		
		List<String> result = new ArrayList<String>();
		try {
			ResultSet rs;
			Statement stmt;
	
			String query = "SELECT v.ViajeNr, d.TransacRemito, t.Letra, " + 
			"t.Prefijo,t.total,t.valor, t.NrComprob, t.Fecha, g.[Razon Social] as razon, "+
			"g.Cuit,g.TipoIva,do.Domicilio, do.Localidad, do.Provincia " +
			"from " + baseEmpresa + ".dbo.DetaViajes d, " + baseEmpresa + ".dbo.Viajes v, " + baseEmpresa + ".dbo.Transac t, " + baseComun + ".dbo.Gente g, " + baseComun + ".dbo.Domicilios do " +  
			"where v.ViajeNr=d.ViajeNr and " +
			"d.TransacRemito=t.TransacNr and " +
			"t.GenteNr=g.GenteNr and " +
			"t.NrDomicilioEnt=do.DomiNr and "+
			"v.ViajeNr= " + viajeNr;
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			//Armo Registro 1
			String registro1 = "01|@cuit|".replaceAll("@cuit", cuit);
			List<String> cotContenido = new ArrayList<String>();
			int i = 0;
			while (rs.next()) {
				//Tomo el remito
				Long remito = rs.getLong("TransacRemito");
				//Armo registro 2
				String registro2 = generateRegistro2(rs, cuit, razon,domicilioEmp , numero,localidad, patente);
				//Pido Registro 3
				List<String> registros3 = generateRegistro3(remito,conn);
//			    elremi = rs![TransacRemito]
				
				cotContenido.add(registro2);
				cotContenido.addAll(registros3);
				i++;
			}
			String registro4 = "04|" + FormatUtil.llenoConCeros(String.valueOf(i), 10) +"|";
			
			result.add(registro1);
			result.addAll(cotContenido);
			result.add(registro4);
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

	private List<String> generateRegistro3(Long remito, Connection conn) {
		
		String sql = "select v.viajeNr, d.transacRemito, i.articulo, i.cant1, s.uniVenta, s.codAfip, s.descripcion " +
		"from " + baseEmpresa + ".dbo.Viajes v, " + baseEmpresa + ".dbo.DetaViajes d, " + baseEmpresa + ".dbo.Items i, " + baseStock + ".dbo.Stock s " +
		"where v.ViajeNr  = d.ViajeNr and " +
		"d.TransacRemito = i.TransacNr and " +
		"i.Articulo COLLATE DATABASE_DEFAULT = s.Clave COLLATE DATABASE_DEFAULT and " +
		"d.TransacRemito=" + remito;
		
		System.out.println(sql);
		ResultSet rs = null;
		Statement stmt= null;
		
		List<String> registros3 = new ArrayList<String>();
		try{
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		
		while (rs.next()) {
			String registro3 = generateDetalleRegistro3(rs);
			registros3.add(registro3);
		}

		rs.close();
		stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		
		}
		return registros3;
	}
	
	
	private String generateDetalleRegistro3(ResultSet rs) {
        String registro3 = "";
        try {
            registro3 = registro3 + "03" + "|";
            String codAfip = rs.getString("codafip");
            if (codAfip.trim().equals(".") || codAfip.trim().equals("0")){
            	codAfip = "401219";
            }
            registro3 = registro3 + codAfip  + "|";
            String uniMedida = rs.getString("univenta").toLowerCase();
            if (uniMedida.equals("kg")) {
            	registro3 = registro3 + "1" + "|";
            }else{
            	if (uniMedida.equals("un")) {
                	registro3 = registro3 + "3" + "|";
                }else{
                	registro3 = registro3 + "3" + "|";
                }
            }
        	registro3 = registro3 + FormatUtil.llenoConCeros(String.valueOf(rs.getInt("cant1") * 100), 15) + "|";
	        registro3 = registro3 + rs.getString("articulo").trim() + "|"; 
	        registro3 = registro3 + FileUtil.recortoValor(rs.getString("descripcion"), 40) + "|";  //' 11        
	        registro3 = registro3 + "UN" + "|";
	        registro3 = registro3 + FormatUtil.llenoConCeros(String.valueOf(rs.getInt("cant1") * 100), 15) + "|";

        } catch (SQLException e) {
			e.printStackTrace();
		}


		return registro3;
	}

	private String generateRegistro2(ResultSet rs, String cuit, String razon, String domicilioEmp, String numero, String localidad, String patente) {
		String registro2 = "";
		registro2 =  "02" + "|";
		try {
			registro2 =  registro2 + DateUtil.getCanonicalFech(rs.getDate("fecha")) + "|";
			registro2 =  registro2 + "91 R";
			registro2 =  registro2 + rs.getString("prefijo");
			registro2 =  registro2 + rs.getString("nrcomprob") + "|";
			registro2 =  registro2 + DateUtil.getCanonicalFech(new Date(System.currentTimeMillis())) + "|";
			registro2 =  registro2 + " " + "|";   // 4
			registro2 =  registro2 + "E" + "|";   //   ' 5
			if (rs.getInt("tipoiva") != 2){
				registro2 =  registro2 + "0" + "|";      //' 6
				registro2 =  registro2 + " " + "|";      //' 7
				registro2 =  registro2 + " " + "|";      //' 8
				registro2 =  registro2 + rs.getString("cuit").replaceAll("-", "") + "|"; //' 9
				registro2 =  registro2 + rs.getString("razon").trim() + "|";   // 10
				registro2 =  registro2 + "1" + "|";      //' DESTINATARIO_TENEDOR
			}else{
				registro2 =  registro2 + "1" + "|";      //' 6
				registro2 =  registro2 + " " + "|";      //' 7
				registro2 =  registro2 + " " + "|";      //' 8
				registro2 =  registro2 + " " + "|";      //' 9
				registro2 =  registro2 + " " + "|";      //' 10
				registro2 =  registro2 + "0" + "|";      //' DESTINATARIO_TENEDOR
			}
			
			registro2 =  registro2 + FileUtil.recortoValor(rs.getString("Domicilio"), 40) + "|";  //' 11
			registro2 =  registro2 + "01" + "|";      //' 12
			registro2 =  registro2 + " " + "|";      //' 13
			registro2 =  registro2 + " " + "|";      //' 14
			registro2 =  registro2 + " " + "|";      //' 15
			registro2 =  registro2 + " " + "|";      //' 16
			registro2 =  registro2 + "C1431FPD" + "|";      //' 17
			registro2 =  registro2 + rs.getString("localidad") + "|";   //' 18
			registro2 =  registro2 + "B" + "|";   //' 19
			registro2 =  registro2 + " " + "|";     // ' 20
			registro2 =  registro2 + "NO" + "|";      //' 21
			registro2 =  registro2 + cuit + "|"; //' 22
			registro2 =  registro2 + razon.trim() + "|"; //' 23
		    
			registro2 =  registro2 + "0" + "|";      //' Emisor_Tenedor
		    
			registro2 =  registro2 + domicilioEmp.trim() + "|"; //' 24
			registro2 =  registro2 + numero.trim() + "|";      //' 25
			registro2 =  registro2 + " " + "|";      //' 26
			registro2 =  registro2 + " " + "|";      //' 27
			registro2 =  registro2 + " " + "|";      //' 28
			registro2 =  registro2 + " " + "|";      //' 29
			registro2 =  registro2 + "C1431FPD" + "|";      //' 30
			registro2 =  registro2 + localidad.trim() + "|"; //' 31
			registro2 =  registro2 + "B" + "|"; //' 32
		    
			registro2 =  registro2 + cuit + "|";      //' Transportista cuit
		    
			registro2 =  registro2 + " " + "|";      //' 34
			registro2 =  registro2 + " " + "|";      //' 35
			registro2 =  registro2 + " " + "|";      //' 36
			registro2 =  registro2 + " " + "|";      //' 37
			registro2 =  registro2 + patente + "|";      //' 38
			registro2 =  registro2 + " " + "|";      //' 39
			registro2 =  registro2 + " " + "0|";      //' campo nuevo 19-9-2011
		    
		    //String importe = String.valueOf(rs.getDouble("total"));
			String importe = String.valueOf(rs.getDouble("valor"));
		    importe = importe.replace(".", "");
			registro2 =  registro2 + FormatUtil.llenoConCeros(importe, 10) + "|";
//		    
//			a$ = Mid$(i$, 1, 8)
//		    
//			b$ = Mid$(i$, 10, 2)
//		    
//		    Print #2, a$ + b$ + "|"   ' Importe
		    
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
		return registro2;
	}

}
