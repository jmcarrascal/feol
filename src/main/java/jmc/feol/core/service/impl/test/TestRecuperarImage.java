package jmc.feol.core.service.impl.test;

import java.awt.Image;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jmc.feol.util.FileUtil;
import jmc.feol.util.FormatUtil;

public class TestRecuperarImage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		  try {
				Class.forName("net.sourceforge.jtds.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} 
		  Connection conn = null;
			try {
				conn = DriverManager.getConnection("jdbc:jtds:sqlserver://localhost:1433/Comunsql", "sa", "super");
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			byte[] img = null;
			  try{
		    		String sql = "select imagen1 from imagenes ";
					ResultSet rs;
					Statement stmt;
					stmt = conn.createStatement();
					rs = stmt.executeQuery(sql);

					if (rs.next()) {
						img = rs.getBytes("imagen1");
					}

					rs.close();
					stmt.close();

			  }catch(SQLException se){
				  se.printStackTrace();
			  }
			  try {
					FileUtil.writeFile(img, "c://testfinal.jpg");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  try {
				Image image = FormatUtil.getImage(img,false);
				
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

}
