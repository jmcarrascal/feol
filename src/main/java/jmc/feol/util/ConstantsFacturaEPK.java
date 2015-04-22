package jmc.feol.util;


public class ConstantsFacturaEPK {

	public final static String ERROR_CAST_TIPO_COMP = "Error al parsear la variable a un tipo de dato Short (numerico) ";
	
	public static String errorCast(String variable, String tipoDato){
		return "Error al parsear la variable " + variable + " a un tipo de dato " + tipoDato + "(numerico) ";
	}
}
