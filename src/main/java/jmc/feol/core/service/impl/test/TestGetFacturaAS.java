package jmc.feol.core.service.impl.test;

import FEV1.dif.afip.gov.ar.FECAERequest;
//import jmc.feol.core.dao.impl.BaseExterna;
import jmc.feol.core.dao.impl.BaseExternaAS;

public class TestGetFacturaAS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		BaseExternaAS be = new BaseExternaAS("com.ibm.as400.access.AS400JDBCDriver","jdbc:as400://"+"www.coinse.com.ar"+"/"+"libivade1", null, null, "jmc", "juan");
		
		FECAERequest fe = be.getFacturaExt(2000096l);
		
		System.out.println("");
	}

}
