package jmc.feol.core.service.impl.test;

import jmc.feol.util.ParseFacturaExpo;

public class TestFacturaExpoV1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ParseFacturaExpo p = new ParseFacturaExpo ();
		p.parseFacturaE("c://A001500000033.txt");
		

	}

}
