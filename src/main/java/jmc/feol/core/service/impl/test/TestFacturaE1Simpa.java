package jmc.feol.core.service.impl.test;


import java.rmi.RemoteException;

import fexv1.dif.afip.gov.ar.ClsFEXAuthRequest;
import fexv1.dif.afip.gov.ar.ClsFEXGetCMP;
import fexv1.dif.afip.gov.ar.FEXGetCMPResponse;
import fexv1.dif.afip.gov.ar.ServiceSoapProxyExpov1;





public class TestFacturaE1Simpa {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getLastRequetAfip();

	}

	
	private static void getLastRequetAfip(){
		
		
		ServiceSoapProxyExpov1 service = new ServiceSoapProxyExpov1();
		ClsFEXAuthRequest auth = new ClsFEXAuthRequest();

		
		auth.setToken("PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/Pgo8c3NvIHZlcnNpb249IjIuMCI+CiAgICA8aWQgdW5pcXVlX2lkPSIxOTUxMzM5ODAxIiBzcmM9IkNOPXdzYWEsIE89QUZJUCwgQz1BUiwgU0VSSUFMTlVNQkVSPUNVSVQgMzM2OTM0NTAyMzkiIGdlbl90aW1lPSIxNDE1MTk1NzEwIiBleHBfdGltZT0iMTQxNTIzODk3MCIgZHN0PSJ3c2ZleCIvPgogICAgPG9wZXJhdGlvbiB2YWx1ZT0iZ3JhbnRlZCIgdHlwZT0ibG9naW4iPgogICAgICAgIDxsb2dpbiB1aWQ9IkM9YXIsIFNUPWJ1ZW5vcyBhaXJlcywgTD1idWVub3MgYWlyZXMsIE89c2ltcGEsIE9VPXNpbXBhLCBTRVJJQUxOVU1CRVI9Q1VJVCAzMDYyODMyMzYwMywgQ049c2ltcGEuY29tLmFyIiBzZXJ2aWNlPSJ3c2ZleCIgcmVnbWV0aG9kPSIyMiIgZW50aXR5PSIzMzY5MzQ1MDIzOSIgYXV0aG1ldGhvZD0iY21zIj4KICAgICAgICAgICAgPHJlbGF0aW9ucz4KICAgICAgICAgICAgICAgIDxyZWxhdGlvbiByZWx0eXBlPSI0IiBrZXk9IjMwNjI4MzIzNjAzIi8+CiAgICAgICAgICAgIDwvcmVsYXRpb25zPgogICAgICAgIDwvbG9naW4+CiAgICA8L29wZXJhdGlvbj4KPC9zc28+Cgo=");
		auth.setSign("pzb7ovMfCYLb0k0AXYf6TQc0StT259iEoUmSclETgtjRRoW2S2qnJOi2ETjQEaHWPPrNITPpG6RTYtd3GSjj66qJKkqIPGBVihbQ1tbRIPkxTOlqK9EhqA4XCufIv1a19dO49vp6a2mJ3rOZNUqkDDpr/tjO4TL8kHKZq7xnyaA=");
		auth.setCuit(30628323603l);
		
		ClsFEXGetCMP cmp = new ClsFEXGetCMP(); 
		cmp.setCbte_nro(1667l);
		cmp.setPunto_vta(Short.parseShort("7"));
		cmp.setCbte_tipo(Short.parseShort("19"));		
		
		FEXGetCMPResponse gg = new FEXGetCMPResponse(); 
		
		try {
			gg = service.FEXGetCMP(auth, cmp);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		System.out.println("Repuesta - Error: " + gg.getFEXErr().getErrMsg());
		
		System.out.println("Repuesta - Events: " + gg.getFEXEvents().getEventMsg());				
		
		System.out.println("Repuesta - Codigo Error: " + gg.getFEXErr().getErrCode());
		
		System.out.println("CUIT: " + gg.getFEXResultGet().getCuit_pais_cliente());
		
		
		System.out.println("CAE: " + gg.getFEXResultGet().getCbte_nro());
		System.out.println("CAE: " + gg.getFEXResultGet().getCae());
		
		System.out.println("Vencimiento CAE: " + gg.getFEXResultGet().getFch_venc_Cae());
		
		System.out.println("Importe Total: " + gg.getFEXResultGet().getImp_total());

	}
}