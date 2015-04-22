package jmc.feol.core.service.impl.test;

import java.rmi.RemoteException;

import jmc.feol.util.Constants;

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
		
		System.setProperty("proxySet", "true");
		System.setProperty("http.proxyHost", "10.3.1.1");
		System.setProperty("http.proxyPort", "80");				

		ServiceSoapProxy service = new ServiceSoapProxy();
		FEAuthRequest feAuth = new FEAuthRequest();

		feAuth.setToken("PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/Pgo8c3NvIHZlcnNpb249IjIuMCI+CiAgICA8aWQgdW5pcXVlX2lkPSIzMTc0MDU1MzAiIHNyYz0iQ049d3NhYWhvbW8sIE89QUZJUCwgQz1BUiwgU0VSSUFMTlVNQkVSPUNVSVQgMzM2OTM0NTAyMzkiIGdlbl90aW1lPSIxMzA3NDUxMTY0IiBleHBfdGltZT0iMTMwNzQ5NDQyNCIgZHN0PSJDTj13c2ZlLCBPPUFGSVAsIEM9QVIiLz4KICAgIDxvcGVyYXRpb24gdmFsdWU9ImdyYW50ZWQiIHR5cGU9ImxvZ2luIj4KICAgICAgICA8bG9naW4gdWlkPSJDPWFyLCBTVD1idWVub3MgYWlyZXMsIEw9YnVlbm9zIGFpcmVzLCBPPWNvaW5zZSwgT1U9Y29pbnNlLCBTRVJJQUxOVU1CRVI9Q1VJVCAzMDcwMDQ0MjM2MSwgQ049Y29pbnNlLmNvbS5hciwgRU1BSUxBRERSRVNTPWNvaW5zZUBjb2luc2UuY29tLmFyIiBzZXJ2aWNlPSJ3c2ZlIiByZWdtZXRob2Q9IjIyIiBlbnRpdHk9IjMzNjkzNDUwMjM5IiBhdXRobWV0aG9kPSJjbXMiPgogICAgICAgICAgICA8cmVsYXRpb25zPgogICAgICAgICAgICAgICAgPHJlbGF0aW9uIHJlbHR5cGU9IjQiIGtleT0iMzA3MDA0NDIzNjEiLz4KICAgICAgICAgICAgPC9yZWxhdGlvbnM+CiAgICAgICAgPC9sb2dpbj4KICAgIDwvb3BlcmF0aW9uPgo8L3Nzbz4KCg==");
		feAuth.setSign("CGj2vieq78bDmWc7FLqgeX2J0BpvLuRoh8mjjEgAA8FaZw9ScXZAQXU0UZHNscluGExfvYL1/xpbg9Y7U9P9YF9U2ZyYRRGKNO+p1G606I6hwMG9MC4xRP6uv6c8N/ADaQ5VhprRmg0BAb4AM4Ol8ADyBoClVWPD38t1vDyvbYc=");

		
		feAuth.setCuit(30700442361l);			
		
		FERecuperaLastCbteResponse feLastResponse = new FERecuperaLastCbteResponse();
		try {
			feLastResponse = service.FECompUltimoAutorizado(feAuth, 3, 1);
			System.out.println(feLastResponse.getCbteNro());
			System.out.println(feLastResponse.getCbteTipo());
			System.out.println(feLastResponse.getPtoVta());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
		
		return null;
	}


}
