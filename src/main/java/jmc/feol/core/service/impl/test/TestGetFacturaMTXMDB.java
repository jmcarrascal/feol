package jmc.feol.core.service.impl.test;


import java.sql.Timestamp;


import jmc.feol.core.dao.impl.BaseExternaMTX;
import jmc.feol.core.model.Empresa;
import jmc.feol.core.service.impl.FacturaManagerImpl;
import FEV1.dif.afip.gov.ar.Err;
import FEV1.dif.afip.gov.ar.FECAEDetResponse;
import FEV1.dif.afip.gov.ar.FECAERequest;
import FEV1.dif.afip.gov.ar.FECAEResponse;
import FEV1.dif.afip.gov.ar.Obs;
import FEV1.dif.afip.gov.ar.wmtx.AutorizarComprobanteResponseType;
import FEV1.dif.afip.gov.ar.wmtx.CodigoDescripcionType;
import FEV1.dif.afip.gov.ar.wmtx.ComprobanteType;


public class TestGetFacturaMTXMDB {
	

	private static String castArrayToString(CodigoDescripcionType[] arrayErrores) {
		String result = "";
			for(CodigoDescripcionType code: arrayErrores ){
				result = result + code.getDescripcion();
				System.out.println(code.getDescripcion());
			}
		return result;
	}



	  public static void main (String args[]) {

		try {
			
			
			BaseExternaMTX be = new BaseExternaMTX("sun.jdbc.odbc.JdbcOdbcDriver","jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=@rutaBase", "[C:/Simpa/bd1_mtx.mdb]","[C:/Simpa/bd1_mtx.mdb]");

			ComprobanteType feab = be.getFacturaExt(1001l, "[C:/Simpa/bd1_mtx.mdb]");
			
			Empresa empresa = new Empresa();
			
			empresa.setIdEmpresa(1l);
			empresa.setCuit("30700442361");
			empresa.setNombre("Coinse");
			empresa.setEndpoint("https://wsaahomo.afip.gov.ar/ws/services/LoginCms"); 
			empresa.setService("wsmtxca");
			empresa.setDstDN("CN=wsaahomo, O=AFIP, C=AR, SERIALNUMBER=CUIT 33693450239");
			empresa.setP12File("C:/FacturaElectronica/Certificados/ks3.p12");
			empresa.setSigner("coinse");
			empresa.setP12pass("123456");
			empresa.setToken("PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/Pgo8c3NvIHZlcnNpb249IjIuMCI+CiAgICA8aWQgdW5pcXVlX2lkPSIzMTAxMzA0ODgxIiBzcmM9IkNOPXdzYWFob21vLCBPPUFGSVAsIEM9QVIsIFNFUklBTE5VTUJFUj1DVUlUIDMzNjkzNDUwMjM5IiBnZW5fdGltZT0iMTMwOTczNTA0NSIgZXhwX3RpbWU9IjEzMDk3NzgzMDUiLz4KICAgIDxvcGVyYXRpb24gdmFsdWU9ImdyYW50ZWQiIHR5cGU9ImxvZ2luIj4KICAgICAgICA8bG9naW4gdWlkPSJDPWFyLCBTVD1idWVub3MgYWlyZXMsIEw9YnVlbm9zIGFpcmVzLCBPPWNvaW5zZSwgT1U9Y29pbnNlLCBTRVJJQUxOVU1CRVI9Q1VJVCAzMDcwMDQ0MjM2MSwgQ049Y29pbnNlLmNvbS5hciwgRU1BSUxBRERSRVNTPWNvaW5zZUBjb2luc2UuY29tLmFyIiBzZXJ2aWNlPSJ3c210eGNhIiByZWdtZXRob2Q9IjIyIiBlbnRpdHk9IjMzNjkzNDUwMjM5IiBhdXRobWV0aG9kPSJjbXMiPgogICAgICAgICAgICA8cmVsYXRpb25zPgogICAgICAgICAgICAgICAgPHJlbGF0aW9uIHJlbHR5cGU9IjQiIGtleT0iMzA3MDA0NDIzNjEiLz4KICAgICAgICAgICAgPC9yZWxhdGlvbnM+CiAgICAgICAgPC9sb2dpbj4KICAgIDwvb3BlcmF0aW9uPgo8L3Nzbz4KCg==");
			empresa.setSignToken("oplLmxs7nJ9tcY7HKFjcM/Wp/kfd4JR6oyITyQHBXapMiURKjwvw9GSQHjX3yMXj614mzID6e0f7jPekldbkM84OiCMLxd2PV+PtAW8kWLM/+lTRVIq92+H6r0T88QKuZOS9zcLg/YLeLZQfErepuRWTFZuiQaGpqUjE06MtvJo=");
			empresa.setLastToken(new Timestamp(System.currentTimeMillis()));
			empresa.setUrlWebService("https://fwshomo.afip.gov.ar/wsmtxca/services/MTXCAService");
			 //private java.lang.String MTXCAServiceHttpSoap11Endpoint_address = "https://fwshomo.afip.gov.ar/wsmtxca/services/MTXCAService";
		    //private java.lang.String MTXCAServiceHttpSoap11Endpoint_address = "https://serviciosjava.afip.gob.ar/wsmtxca/services/MTXCAService";
		   
			//empresa.setToken("PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/Pgo8c3NvIHZlcnNpb249IjIuMCI+CiAgICA8aWQgdW5pcXVlX2lkPSIyMzQ4MDYxNzQ4IiBzcmM9IkNOPXdzYWFob21vLCBPPUFGSVAsIEM9QVIsIFNFUklBTE5VTUJFUj1DVUlUIDMzNjkzNDUwMjM5IiBnZW5fdGltZT0iMTMwNjE2NDM0NiIgZXhwX3RpbWU9IjEzMDYyMDc2MDYiIGRzdD0iQ049d3NmZSwgTz1BRklQLCBDPUFSIi8+CiAgICA8b3BlcmF0aW9uIHZhbHVlPSJncmFudGVkIiB0eXBlPSJsb2dpbiI+CiAgICAgICAgPGxvZ2luIHVpZD0iQz1hciwgU1Q9YnVlbm9zIGFpcmVzLCBMPWJ1ZW5vcyBhaXJlcywgTz1jb2luc2UsIE9VPWNvaW5zZSwgU0VSSUFMTlVNQkVSPUNVSVQgMzA3MDA0NDIzNjEsIENOPWNvaW5zZS5jb20uYXIsIEVNQUlMQUREUkVTUz1jb2luc2VAY29pbnNlLmNvbS5hciIgc2VydmljZT0id3NmZSIgcmVnbWV0aG9kPSIyMiIgZW50aXR5PSIzMzY5MzQ1MDIzOSIgYXV0aG1ldGhvZD0iY21zIj4KICAgICAgICAgICAgPHJlbGF0aW9ucz4KICAgICAgICAgICAgICAgIDxyZWxhdGlvbiByZWx0eXBlPSI0IiBrZXk9IjMwNzAwNDQyMzYxIi8+CiAgICAgICAgICAgIDwvcmVsYXRpb25zPgogICAgICAgIDwvbG9naW4+CiAgICA8L29wZXJhdGlvbj4KPC9zc28+Cgo=");
			//empresa.setSigner("AgXm0HFgFA8XQVYORn+fTZ+oQB+KLWDzRFFd+tJlpMp1G0prcacsCArUpmnOHzQsx9KxffNfgKm3P32p1Ehk5xOxd5ZFzE9H79iIO8950SereMDbY4olPAYVHTj2vmgoCzG+bbIMni9y9OnLVmOQOm0YBM0v8rm3xkMX5ZXz4k8=");
			//empresa.setLastToken(new Timestamp(System.currentTimeMillis()));
			empresa.setTicketTime(36000000l);

			FacturaManagerImpl facturaManagerImpl = new FacturaManagerImpl();
			
			AutorizarComprobanteResponseType autorizarComprobanteResponseType = facturaManagerImpl.facturacionAFIPMTX(feab, empresa);
			
			String resultado = "";
			
			if (autorizarComprobanteResponseType != null){
				
				//System.out.println("Aut - Resultado = " + feResponse.getRError().getPerrmsg());
				if (autorizarComprobanteResponseType.getComprobanteResponse() != null){					
										
					if (autorizarComprobanteResponseType.getArrayErrores() !=null && autorizarComprobanteResponseType.getArrayErrores().length > 0){
						//Tengo Errores
						resultado = castArrayToString(autorizarComprobanteResponseType.getArrayErrores());
						if (resultado.length() > 200){
							resultado = resultado.substring(0, 200);
						}

					}else{
						//No tengo Errores

					}
					
					
				}else{
					if (autorizarComprobanteResponseType.getArrayErrores().length > 0){
						//Tengo Errores
						resultado = castArrayToString(autorizarComprobanteResponseType.getArrayErrores());
						if (resultado.length() > 200){
							resultado = resultado.substring(0, 200);
						}
						
						
					}else{
					
					}
				}
			}else{
				
			}
	}catch(Exception e){
		e.printStackTrace();
	}
	}
}
