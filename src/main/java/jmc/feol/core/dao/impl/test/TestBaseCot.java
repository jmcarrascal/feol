package jmc.feol.core.dao.impl.test;

import java.util.List;

import jmc.feol.core.dao.impl.BaseExternaCot;

public class TestBaseCot {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BaseExternaCot bec = new BaseExternaCot("net.sourceforge.jtds.jdbc.Driver","jdbc:jtds:sqlserver://localhost:1433/EmpresaL","sa","super", "ComunSqlL","EmpresaL","ComunSqlL");
		List<String> list = bec.getLineasFileCot(44601, "30663753025", "LUMA PRODUCTOS SRL", "Rebizzo","5770","Caseros (B1678BDN)", "");
		for(String s:list){
			System.out.println(s);
		}
	}

}
