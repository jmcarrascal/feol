package jmc.feol.core.service.impl.test;

import java.rmi.RemoteException;

import jmc.feol.util.Constants;
import jmc.feol.util.FileUtil;

import FEV1.dif.afip.gov.ar.FEAuthRequest;
import FEV1.dif.afip.gov.ar.FECompConsResponse;
import FEV1.dif.afip.gov.ar.FECompConsultaReq;
import FEV1.dif.afip.gov.ar.FECompConsultaResponse;
import FEV1.dif.afip.gov.ar.FERecuperaLastCbteResponse;
import FEV1.dif.afip.gov.ar.ServiceSoapProxy;



public class TestLastFac {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.setProperty("proxySet", "true");
		//System.setProperty("http.proxyHost", "10.3.1.1");
		//System.setProperty("http.proxyPort", "80");				

		getLastNroFactura();
		//getFactura();
	}
	public static Long getLastNroFactura(){
		
		
		ServiceSoapProxy service = new ServiceSoapProxy();
		FEAuthRequest feAuth = new FEAuthRequest();

		feAuth.setToken("PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/Pgo8c3NvIHZlcnNpb249IjIuMCI+CiAgICA8aWQgdW5pcXVlX2lkPSI1NDAwNDg0NjEiIHNyYz0iQ049d3NhYSwgTz1BRklQLCBDPUFSLCBTRVJJQUxOVU1CRVI9Q1VJVCAzMzY5MzQ1MDIzOSIgZ2VuX3RpbWU9IjE0MTgzODg4NzgiIGV4cF90aW1lPSIxNDE4NDMyMTM4IiBkc3Q9IkNOPXdzZmUsIE89QUZJUCwgQz1BUiIvPgogICAgPG9wZXJhdGlvbiB2YWx1ZT0iZ3JhbnRlZCIgdHlwZT0ibG9naW4iPgogICAgICAgIDxsb2dpbiB1aWQ9IkM9YXIsIFNUPWJ1ZW5vcyBhaXJlcywgTD1idWVub3MgYWlyZXMsIE89cGxheWRvbiwgT1U9cGxheWRvbiwgU0VSSUFMTlVNQkVSPUNVSVQgMzA3MTM0ODAwMDksIENOPXBsYXlkb24uY29tLmFyLCBFTUFJTEFERFJFU1M9aW5mb0BwbGF5ZG9uLmNvbS5hciIgc2VydmljZT0id3NmZSIgcmVnbWV0aG9kPSIyMiIgZW50aXR5PSIzMzY5MzQ1MDIzOSIgYXV0aG1ldGhvZD0iY21zIj4KICAgICAgICAgICAgPHJlbGF0aW9ucz4KICAgICAgICAgICAgICAgIDxyZWxhdGlvbiByZWx0eXBlPSI0IiBrZXk9IjMwNzEzNDgwMDA5Ii8+CiAgICAgICAgICAgIDwvcmVsYXRpb25zPgogICAgICAgIDwvbG9naW4+CiAgICA8L29wZXJhdGlvbj4KPC9zc28+Cgo=");
		feAuth.setSign("J7Bw7q8nY24yyNB9lYVEkhpSzCVIVUTT3ZSW+Oi4Or1YFFqwhWiauw4BehiZVd/i6uciYHLUuWaLVe/WCZSqtCV2Yl6V7ZfVVNoKuPG8QhT50WBRnZyj2MvZ4EstJzJhMOaY02ABpsHaUjbs+YBGZ4U/KfiHy9pKCCILlA+ESAc=");

		
		feAuth.setCuit(30713480009l);			
		
		FERecuperaLastCbteResponse feLastResponse = new FERecuperaLastCbteResponse();
		try {
			feLastResponse = service.FECompUltimoAutorizado(feAuth, 5, 1);
			System.out.println(feLastResponse.getCbteNro());
			System.out.println(feLastResponse.getCbteTipo());
			System.out.println(feLastResponse.getPtoVta());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
		
		return null;
	}

	public static byte[]  getFactura(){
		
		ServiceSoapProxy service = new ServiceSoapProxy();
		FEAuthRequest feAuth = new FEAuthRequest();

		feAuth.setToken("PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/Pgo8c3NvIHZlcnNpb249IjIuMCI+CiAgICA8aWQgdW5pcXVlX2lkPSI1NDAwNDg0NjEiIHNyYz0iQ049d3NhYSwgTz1BRklQLCBDPUFSLCBTRVJJQUxOVU1CRVI9Q1VJVCAzMzY5MzQ1MDIzOSIgZ2VuX3RpbWU9IjE0MTgzODg4NzgiIGV4cF90aW1lPSIxNDE4NDMyMTM4IiBkc3Q9IkNOPXdzZmUsIE89QUZJUCwgQz1BUiIvPgogICAgPG9wZXJhdGlvbiB2YWx1ZT0iZ3JhbnRlZCIgdHlwZT0ibG9naW4iPgogICAgICAgIDxsb2dpbiB1aWQ9IkM9YXIsIFNUPWJ1ZW5vcyBhaXJlcywgTD1idWVub3MgYWlyZXMsIE89cGxheWRvbiwgT1U9cGxheWRvbiwgU0VSSUFMTlVNQkVSPUNVSVQgMzA3MTM0ODAwMDksIENOPXBsYXlkb24uY29tLmFyLCBFTUFJTEFERFJFU1M9aW5mb0BwbGF5ZG9uLmNvbS5hciIgc2VydmljZT0id3NmZSIgcmVnbWV0aG9kPSIyMiIgZW50aXR5PSIzMzY5MzQ1MDIzOSIgYXV0aG1ldGhvZD0iY21zIj4KICAgICAgICAgICAgPHJlbGF0aW9ucz4KICAgICAgICAgICAgICAgIDxyZWxhdGlvbiByZWx0eXBlPSI0IiBrZXk9IjMwNzEzNDgwMDA5Ii8+CiAgICAgICAgICAgIDwvcmVsYXRpb25zPgogICAgICAgIDwvbG9naW4+CiAgICA8L29wZXJhdGlvbj4KPC9zc28+Cgo=");
		feAuth.setSign("J7Bw7q8nY24yyNB9lYVEkhpSzCVIVUTT3ZSW+Oi4Or1YFFqwhWiauw4BehiZVd/i6uciYHLUuWaLVe/WCZSqtCV2Yl6V7ZfVVNoKuPG8QhT50WBRnZyj2MvZ4EstJzJhMOaY02ABpsHaUjbs+YBGZ4U/KfiHy9pKCCILlA+ESAc=");

		
		feAuth.setCuit(30700442361l);			
		
		FECompConsultaReq feCompConsReq = new FECompConsultaReq ();
		feCompConsReq.setCbteNro(309);
		feCompConsReq.setCbteTipo(1);
		feCompConsReq.setPtoVta(3);
		try {
			FECompConsultaResponse fECompConsultaResponse   = service.FECompConsultar(feAuth, feCompConsReq);
			FECompConsResponse res =  fECompConsultaResponse.getResultGet();
			System.out.println(res.getImpTotal());
			return fECompConsultaResponse.getXmlResponse();			
		} catch (RemoteException e) {			
			e.printStackTrace();
		}				
		return null;
		
	}

}
