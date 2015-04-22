package jmc.feol.core.service.impl.test;


import java.rmi.RemoteException;

import fex.dif.afip.gov.ar.FEXResponse_MonDesa;
import fexv1.dif.afip.gov.ar.ClsFEXAuthRequest;
import fexv1.dif.afip.gov.ar.ClsFEXGetCMP;
import fexv1.dif.afip.gov.ar.ClsFEX_LastCMP;
import fexv1.dif.afip.gov.ar.FEXGetCMPResponse;
import fexv1.dif.afip.gov.ar.FEXResponseLast_CMP;
import fexv1.dif.afip.gov.ar.ServiceSoapProxyExpov1;





public class TestLastFacturaE1Simpa {

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

		
		auth.setToken("PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/Pgo8c3NvIHZlcnNpb249IjIuMCI+CiAgICA8aWQgdW5pcXVlX2lkPSI4Mzg2Nzk5MDAiIHNyYz0iQ049d3NhYSwgTz1BRklQLCBDPUFSLCBTRVJJQUxOVU1CRVI9Q1VJVCAzMzY5MzQ1MDIzOSIgZ2VuX3RpbWU9IjEzODcyMzM1MjkiIGV4cF90aW1lPSIxMzg3Mjc2Nzg5IiBkc3Q9IndzZmV4Ii8+CiAgICA8b3BlcmF0aW9uIHZhbHVlPSJncmFudGVkIiB0eXBlPSJsb2dpbiI+CiAgICAgICAgPGxvZ2luIHVpZD0iQz1hciwgU1Q9YnVlbm9zIGFpcmVzLCBMPXBjaWEgZGUgYnVlbm9zIGFpcmVzLCBPPWhhZ3JhZiwgT1U9aGFncmFmLCBTRVJJQUxOVU1CRVI9Q1VJVCAzMDY4NTg0NDYzNiwgQ049aGFncmFmIiBzZXJ2aWNlPSJ3c2ZleCIgcmVnbWV0aG9kPSIyMiIgZW50aXR5PSIzMzY5MzQ1MDIzOSIgYXV0aG1ldGhvZD0iY21zIj4KICAgICAgICAgICAgPHJlbGF0aW9ucz4KICAgICAgICAgICAgICAgIDxyZWxhdGlvbiByZWx0eXBlPSI0IiBrZXk9IjMwNjg1ODQ0NjM2Ii8+CiAgICAgICAgICAgIDwvcmVsYXRpb25zPgogICAgICAgIDwvbG9naW4+CiAgICA8L29wZXJhdGlvbj4KPC9zc28+Cgo=");
		auth.setSign("uJ0+Yp14Gn/Nd/wDowwXxCBIQowGrdzLBA52LIZBVFGDHWQ7iv1hv/eZQjT45oo8Yq4NcizjJ081Q8M1oQTgjDWVB77mGf7gITOY7MholjvH6LBKdFbnmZku69qiACOJ5m4yj4i33M0n8Udfho93zYXqWXp8pIdnCGqaTzM0wAU=");
		auth.setCuit(30685844636l);
		
		ClsFEX_LastCMP cmp = new ClsFEX_LastCMP(); 
		cmp.setCbte_Tipo(Short.parseShort("21"));		
		cmp.setCuit(30685844636l);
		cmp.setPto_venta(Short.parseShort("8"));
		cmp.setToken("PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/Pgo8c3NvIHZlcnNpb249IjIuMCI+CiAgICA8aWQgdW5pcXVlX2lkPSI4Mzg2Nzk5MDAiIHNyYz0iQ049d3NhYSwgTz1BRklQLCBDPUFSLCBTRVJJQUxOVU1CRVI9Q1VJVCAzMzY5MzQ1MDIzOSIgZ2VuX3RpbWU9IjEzODcyMzM1MjkiIGV4cF90aW1lPSIxMzg3Mjc2Nzg5IiBkc3Q9IndzZmV4Ii8+CiAgICA8b3BlcmF0aW9uIHZhbHVlPSJncmFudGVkIiB0eXBlPSJsb2dpbiI+CiAgICAgICAgPGxvZ2luIHVpZD0iQz1hciwgU1Q9YnVlbm9zIGFpcmVzLCBMPXBjaWEgZGUgYnVlbm9zIGFpcmVzLCBPPWhhZ3JhZiwgT1U9aGFncmFmLCBTRVJJQUxOVU1CRVI9Q1VJVCAzMDY4NTg0NDYzNiwgQ049aGFncmFmIiBzZXJ2aWNlPSJ3c2ZleCIgcmVnbWV0aG9kPSIyMiIgZW50aXR5PSIzMzY5MzQ1MDIzOSIgYXV0aG1ldGhvZD0iY21zIj4KICAgICAgICAgICAgPHJlbGF0aW9ucz4KICAgICAgICAgICAgICAgIDxyZWxhdGlvbiByZWx0eXBlPSI0IiBrZXk9IjMwNjg1ODQ0NjM2Ii8+CiAgICAgICAgICAgIDwvcmVsYXRpb25zPgogICAgICAgIDwvbG9naW4+CiAgICA8L29wZXJhdGlvbj4KPC9zc28+Cgo=");
		cmp.setSign("uJ0+Yp14Gn/Nd/wDowwXxCBIQowGrdzLBA52LIZBVFGDHWQ7iv1hv/eZQjT45oo8Yq4NcizjJ081Q8M1oQTgjDWVB77mGf7gITOY7MholjvH6LBKdFbnmZku69qiACOJ5m4yj4i33M0n8Udfho93zYXqWXp8pIdnCGqaTzM0wAU=");
		
		FEXGetCMPResponse gg = new FEXGetCMPResponse(); 
		FEXResponseLast_CMP hh = new FEXResponseLast_CMP();
		try {
			hh = service.FEXGetLast_CMP(cmp);
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