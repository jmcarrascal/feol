package jmc.feol.core.service.impl.test;

import java.util.List;

import FEV1.dif.afip.gov.ar.FECAERequest;
import FEV1.dif.afip.gov.ar.FECAEResponse;
import FEV1.dif.afip.gov.ar.FECompConsultaResponse;
import FEV1.dif.afip.gov.ar.FECotizacionResponse;
import FEV1.dif.afip.gov.ar.Tributo;
import FEV1.dif.afip.gov.ar.wmtx.AutorizarComprobanteResponseType;
import FEV1.dif.afip.gov.ar.wmtx.ComprobanteType;
import fex.dif.afip.gov.ar.ClsFEXRequestDesa;
import fex.dif.afip.gov.ar.FEXResponseAuthorizeDesa;
import jmc.feol.core.model.Empresa;
import jmc.feol.core.model.Factura;
import jmc.feol.core.service.FacturaManager;
import jmc.feol.core.service.impl.FacturaManagerImpl;
import jmc.feol.util.FileUtil;

public class ObtenerFacturaABV1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FacturaManager fm = new FacturaManagerImpl();
		Empresa empresa = new Empresa();
		empresa.setToken("PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/Pgo8c3NvIHZlcnNpb249IjIuMCI+CiAgICA8aWQgdW5pcXVlX2lkPSIzNzYzMTE1OTA3IiBzcmM9IkNOPXdzYWEsIE89QUZJUCwgQz1BUiwgU0VSSUFMTlVNQkVSPUNVSVQgMzM2OTM0NTAyMzkiIGdlbl90aW1lPSIxMzQ5MjM4MTE2IiBleHBfdGltZT0iMTM0OTI4MTM3NiIgZHN0PSJDTj13c2ZlLCBPPUFGSVAsIEM9QVIiLz4KICAgIDxvcGVyYXRpb24gdmFsdWU9ImdyYW50ZWQiIHR5cGU9ImxvZ2luIj4KICAgICAgICA8bG9naW4gdWlkPSJDPWFyLCBTVD1idWVub3MgYWlyZXMsIEw9cGNpYSBkZSBidWVub3MgYWlyZXMsIE89bWVnYXRveXMsIE9VPW1lZ2F0b3lzLCBTRVJJQUxOVU1CRVI9Q1VJVCAzMDcwOTU5NzQwNiwgQ049bWVnYXRveXMuY29tLmFyIiBzZXJ2aWNlPSJ3c2ZlIiByZWdtZXRob2Q9IjIyIiBlbnRpdHk9IjMzNjkzNDUwMjM5IiBhdXRobWV0aG9kPSJjbXMiPgogICAgICAgICAgICA8cmVsYXRpb25zPgogICAgICAgICAgICAgICAgPHJlbGF0aW9uIHJlbHR5cGU9IjQiIGtleT0iMzA3MDk1OTc0MDYiLz4KICAgICAgICAgICAgPC9yZWxhdGlvbnM+CiAgICAgICAgPC9sb2dpbj4KICAgIDwvb3BlcmF0aW9uPgo8L3Nzbz4KCg==");
		empresa.setSignToken("LuTG2SHpoQXhImllOWTAqeSosHgdY0O+qBtoq16OR/bdt2xlAzjP+Dks4nSBuloaHrva8LFD/YoC0EKVN0SEiEjzGnZCqOpSkK7Ep4XKxKOBkQJINFvur7H39DiLuBMju0WYYrO1h3SNNbZyfWGfLOG1v7R2cqbY5LmvIzRlNxc=");
		empresa.setCuit("30709597406");
		empresa.setUrlWebService("https://servicios1.afip.gov.ar/wsfe/service.asmx");
		byte[] fac = null;
		try {
			fac = fm.getFactura(258l, 3, 2, empresa);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			FileUtil.writeFile(fac, "c://fac.xml");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
