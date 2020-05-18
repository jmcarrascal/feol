package jmc.feol.core.service.impl.test;

import java.rmi.RemoteException;

import jmc.feol.util.Constants;
import FEV1.dif.afip.gov.ar.Err;
import FEV1.dif.afip.gov.ar.FEAuthRequest;
import FEV1.dif.afip.gov.ar.FERecuperaLastCbteResponse;
import FEV1.dif.afip.gov.ar.ServiceSoapProxy;



public class TestLastNroFac {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getLastNroFactura();
	}
	public static Long getLastNroFactura(){
		
//		System.setProperty("proxySet", "true");
//		System.setProperty("http.proxyHost", "10.3.1.1");
//		System.setProperty("http.proxyPort", "80");				

		ServiceSoapProxy service = new ServiceSoapProxy();
		FEAuthRequest feAuth = new FEAuthRequest();

		feAuth.setToken("PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/Pgo8c3NvIHZlcnNpb249IjIuMCI+CiAgICA8aWQgc3JjPSJDTj13c2FhLCBPPUFGSVAsIEM9QVIsIFNFUklBTE5VTUJFUj1DVUlUIDMzNjkzNDUwMjM5IiBkc3Q9IkNOPXdzZmUsIE89QUZJUCwgQz1BUiIgdW5pcXVlX2lkPSI3ODY2ODIyMjkiIGdlbl90aW1lPSIxNTg1NzY2NzI3IiBleHBfdGltZT0iMTU4NTgwOTk4NyIvPgogICAgPG9wZXJhdGlvbiB0eXBlPSJsb2dpbiIgdmFsdWU9ImdyYW50ZWQiPgogICAgICAgIDxsb2dpbiBlbnRpdHk9IjMzNjkzNDUwMjM5IiBzZXJ2aWNlPSJ3c2ZlIiB1aWQ9IlNFUklBTE5VTUJFUj1DVUlUIDMwNzE2MTYzNzQ4LCBDTj1jaXByZXMiIGF1dGhtZXRob2Q9ImNtcyIgcmVnbWV0aG9kPSIyMiI+CiAgICAgICAgICAgIDxyZWxhdGlvbnM+CiAgICAgICAgICAgICAgICA8cmVsYXRpb24ga2V5PSIzMDcxNjE2Mzc0OCIgcmVsdHlwZT0iNCIvPgogICAgICAgICAgICA8L3JlbGF0aW9ucz4KICAgICAgICA8L2xvZ2luPgogICAgPC9vcGVyYXRpb24+Cjwvc3NvPgo=");
		feAuth.setSign("cR0Z7gNpRT05ozv48CgjV1fNVTKPq3rcZr6AJPKLq+nIYyRRpNl6NCfJoLAlgKvVAGz4SpOtTsXhj7I26UZBb2bBXrB94Sg/baCbYdi/urkJyuh6yNuZvYc0KvKbp/zds16n/6vPwXMYrMpxp2nNL+UZM7OoLrIYU0SoItDZKTw=");

		
		feAuth.setCuit(30716163748l);			
		
		FERecuperaLastCbteResponse feLastResponse = new FERecuperaLastCbteResponse();
		try {
			feLastResponse = service.FECompUltimoAutorizado(feAuth, 1, 6);
			System.out.println(feLastResponse.getCbteNro());
			System.out.println(feLastResponse.getCbteTipo());
			System.out.println(feLastResponse.getPtoVta());
			//for (Err e : feLastResponse.getErrors()) {
			//	System.out.println(e.getMsg());
			//}
			System.out.println(feLastResponse.getErrors());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
		
		return null;
	}


}
