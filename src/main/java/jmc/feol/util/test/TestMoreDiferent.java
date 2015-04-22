package jmc.feol.util.test;

import jmc.feol.util.MathUtil;

public class TestMoreDiferent {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Double valor1 = 13d;
		Double valor2 = 13.05d;
		Double dif = 0.05d;
		System.out.println(MathUtil.isMoreDiferent(valor1, valor2, dif));
		
	}

}
