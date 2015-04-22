package jmc.feol.util;

import java.math.BigDecimal;

public class MathUtil {

	public static double redondear(double numero)
	{
	       return Math.rint(numero*100)/100;
	}

	public static boolean isMoreDiferent(Double valor1, Double valor2, Double diferencia){
		boolean result = true;
		Double dif = valor1 - valor2;
		if (dif < 0)
			dif = dif * -1;
		
		if(dif > diferencia){
			result = true;
		}else{
			result = false;
		}				
		return result;		
	}

}
