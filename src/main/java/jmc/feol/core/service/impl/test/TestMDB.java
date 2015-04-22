package jmc.feol.core.service.impl.test;

import java.net.URL;
import java.sql.*;

import jmc.feol.core.dao.impl.BaseExterna;
import jmc.feol.util.DateUtil;


public class TestMDB {



	

	  static Connection theConn;

	  public static void main (String args[]) {
	    try {
	      // connection to an ACCESS MDB
	      theConn = getConnection();

	      ResultSet rs;
	      Statement stmt;
	      String sql;

	      sql =  "select * from notas ";
	      stmt = theConn.createStatement();
	      rs = stmt.executeQuery(sql);
	      Date fecha = null;
	      while (rs.next()) {
	         //System.out.println(rs.getDouble("NetoGrav") + "," + rs.getString("TransacNr") + "," + rs.getDate("fecha"));
	         fecha = rs.getDate("fecha");
	      }
	      System.out.println(DateUtil.getCanonicalFech(fecha));
	      rs.close();
	      stmt.close();
	    }
	    catch (Exception e) {
	        e.printStackTrace();
	    }
	    finally {
	      try {
	        if (theConn != null) theConn.close();
	      }
	      catch (Exception e) {
	      }
	    }

	    }
	  

	//be = new BaseExterna("net.sourceforge.jtds.jdbc.Driver","jdbc:jtds:sqlserver://"+servidor+":1433/"+base, baseComun, baseArticulo, user, password);
	  public static Connection getConnection() throws Exception {
	    //Driver d = (Driver)Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection c = DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)}; DBQ=c:\\sk\\pases.mdb");
	    return c;
	    
	    // To use an already defined ODBC Datasource :    
//		  	
//	    try {
//				Class.forName("net.sourceforge.jtds.jdbc.Driver");
//			} catch (ClassNotFoundException e) {
//				
//				e.printStackTrace();
//			}  
//	        //String URL = "DriverManager.getConnection(direccion, usr, password);";
	        //Connection c = DriverManager.getConnection("jdbc:jtds:sqlserver://hpserver:1300/empresa1", "sa", "mapsasask05"); 
	        //return c;
	         
	    }
	
}
