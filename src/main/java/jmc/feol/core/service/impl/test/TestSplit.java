package jmc.feol.core.service.impl.test;

import java.math.BigInteger;
import java.security.SecureRandom;

public class TestSplit {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestSplit ts = new TestSplit();
		System.out.println(ts.nextSessionId().toUpperCase());

	}
	
	private SecureRandom random = new SecureRandom();
	  public String nextSessionId()
	  {
	    String result = new BigInteger(130, random).toString(32);	   
	    if (result.length() > 14)
	    	result = result.substring(0, 14);
		  return result;
	  }

}
