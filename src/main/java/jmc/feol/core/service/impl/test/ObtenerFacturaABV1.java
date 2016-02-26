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
		empresa.setToken("PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/Pgo8c3NvIHZlcnNpb249IjIuMCI+CiAgICA8aWQgdW5pcXVlX2lkPSIyNzA1MDc5MDM1IiBzcmM9IkNOPXdzYWEsIE89QUZJUCwgQz1BUiwgU0VSSUFMTlVNQkVSPUNVSVQgMzM2OTM0NTAyMzkiIGdlbl90aW1lPSIxNDU0MzMwODQzIiBleHBfdGltZT0iMTQ1NDM3NDEwMyIgZHN0PSJDTj13c2ZlLCBPPUFGSVAsIEM9QVIiLz4KICAgIDxvcGVyYXRpb24gdmFsdWU9ImdyYW50ZWQiIHR5cGU9ImxvZ2luIj4KICAgICAgICA8bG9naW4gdWlkPSJDPWFyLCBTVD1idWVub3MgYWlyZXMsIEw9YnVlbm9zIGFpcmVzLCBPPXRlamlzdXIsIE9VPXRlamlzdXIsIFNFUklBTE5VTUJFUj1DVUlUIDMwNzEyMDE0OTUwLCBDTj10ZWppc3VyLmNvbS5hciwgRU1BSUxBRERSRVNTPWluZm9AdGVqaXN1ci5jb20uYXIiIHNlcnZpY2U9IndzZmUiIHJlZ21ldGhvZD0iMjIiIGVudGl0eT0iMzM2OTM0NTAyMzkiIGF1dGhtZXRob2Q9ImNtcyI+CiAgICAgICAgICAgIDxyZWxhdGlvbnM+CiAgICAgICAgICAgICAgICA8cmVsYXRpb24gcmVsdHlwZT0iNCIga2V5PSIzMDcxMjAxNDk1MCIvPgogICAgICAgICAgICA8L3JlbGF0aW9ucz4KICAgICAgICA8L2xvZ2luPgogICAgPC9vcGVyYXRpb24+Cjwvc3NvPgoK");
		empresa.setSignToken("Rf08Km9KtLET7BHpOnGWuxrtcaiqKKYzP67JEerPaL6f23bg8e/FH8DV7CQRKZBTPdD9bOpu3K/vBw52bHIZ2/0fTuuvQygoJXLOMLx7aSt4kIqTXs3RVD2fcBtFbC03Tm5NCYlJSm2/KXgU+or7/bimAI37HnleE6jU6fPrEKM=");
		empresa.setCuit("30712014950");
		empresa.setUrlWebService("https://servicios1.afip.gov.ar/wsfev1/service.asmx");
		byte[] fac = null;
		try {
			fac = fm.getFactura(47l, 2, 10, empresa);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			FileUtil.writeFile(fac, "/tmp/fac.xml");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
