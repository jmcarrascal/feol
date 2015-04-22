package jmc.feol.core.service.impl.test;

import org.apache.commons.lang.StringEscapeUtils;

public class TestReplace {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String importe = "4525.8";
		
		importe = importe.replace(".", "");
		
		System.out.println(importe);
	}

}
