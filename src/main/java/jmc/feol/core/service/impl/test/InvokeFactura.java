package jmc.feol.core.service.impl.test;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;



import FEV1.dif.afip.gov.ar.AlicIva;
import FEV1.dif.afip.gov.ar.Err;
import FEV1.dif.afip.gov.ar.FEAuthRequest;
import FEV1.dif.afip.gov.ar.FECAECabRequest;
import FEV1.dif.afip.gov.ar.FECAECabResponse;
import FEV1.dif.afip.gov.ar.FECAEDetRequest;
import FEV1.dif.afip.gov.ar.FECAEDetResponse;
import FEV1.dif.afip.gov.ar.FECAERequest;
import FEV1.dif.afip.gov.ar.FECAEResponse;
import FEV1.dif.afip.gov.ar.Obs;
import FEV1.dif.afip.gov.ar.ServiceSoapProxy;
import FEV1.dif.afip.gov.ar.Tributo;



public class InvokeFactura {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Seteo de Proxy
		//System.setProperty("proxySet", "true");
		//System.setProperty("http.proxyHost", "10.3.1.1");
		//System.setProperty("http.proxyPort", "80");
		
		//Seteo Fecha
    	Calendar calendario = GregorianCalendar.getInstance();
    	Date fecha = calendario.getTime();
    	//System.out.println(fecha);
    	SimpleDateFormat formatoDeFecha = new SimpleDateFormat("yyyyMMdd");
    	//System.out.println(formatoDeFecha.format(fecha));

		ServiceSoapProxy service = new ServiceSoapProxy("https://servicios1.afip.gov.ar/wsfev1/service.asmx");
		FEAuthRequest feAuth = new FEAuthRequest();
		
		feAuth.setToken("PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/Pgo8c3NvIHZlcnNpb249IjIuMCI+CiAgICA8aWQgdW5pcXVlX2lkPSI1NTAxNjIxNjUiIHNyYz0iQ049d3NhYSwgTz1BRklQLCBDPUFSLCBTRVJJQUxOVU1CRVI9Q1VJVCAzMzY5MzQ1MDIzOSIgZ2VuX3RpbWU9IjEzNTg5NjU3MzYiIGV4cF90aW1lPSIxMzU5MDA4OTk2IiBkc3Q9IkNOPXdzZmUsIE89QUZJUCwgQz1BUiIvPgogICAgPG9wZXJhdGlvbiB2YWx1ZT0iZ3JhbnRlZCIgdHlwZT0ibG9naW4iPgogICAgICAgIDxsb2dpbiB1aWQ9IkM9YXIsIFNUPWJ1ZW5vcyBhaXJlcywgTD1idWVub3MgYWlyZXMsIE89b25jb2xpZmUsIE9VPW9uY29saWZlLCBTRVJJQUxOVU1CRVI9Q1VJVCAzMDcwODM1MTU4NiwgQ049b25jb2xpZmUuY29tLmFyLCBFTUFJTEFERFJFU1M9aW5mb0BvbmNvbGlmZS5jb20uYXIiIHNlcnZpY2U9IndzZmUiIHJlZ21ldGhvZD0iMjIiIGVudGl0eT0iMzM2OTM0NTAyMzkiIGF1dGhtZXRob2Q9ImNtcyI+CiAgICAgICAgICAgIDxyZWxhdGlvbnM+CiAgICAgICAgICAgICAgICA8cmVsYXRpb24gcmVsdHlwZT0iNCIga2V5PSIzMDcwODM1MTU4NiIvPgogICAgICAgICAgICA8L3JlbGF0aW9ucz4KICAgICAgICA8L2xvZ2luPgogICAgPC9vcGVyYXRpb24+Cjwvc3NvPgoK");
		feAuth.setSign("hmGIEIdubFAy4heM5dCFOyq1+hm54we1bfky1ZouPFizMB8k9TSdvZwk8FVGUju66FYAqmXHzIUNIPtvVRNY9s4C8d77z9SC7Zh2ib3K86J1GciVsWlQCw8HoT9jrhyuYQeDE8Z2JG3X7cmgYkgKdWLT1qE0xMxB7zeajl0GwL8=");
		
		feAuth.setCuit(30708351586l);
				
		//Carga del objeto FERequet
		FECAERequest feReq = new FECAERequest();
		//Cargo Cabezera.		
		FECAECabRequest feCabecera = new FECAECabRequest();
		feCabecera.setCantReg(1);
		feCabecera.setCbteTipo(1);
		feCabecera.setPtoVta(3);
		
		
		feReq.setFeCabReq(feCabecera);
		
		Tributo tributo = new Tributo();
		Tributo[] tributos = new Tributo[1];
		
		
		AlicIva[] alicIvas = new AlicIva[1];
		AlicIva alicIva = new AlicIva();
		alicIva.setId(5);
		alicIva.setBaseImp(1);
		alicIva.setImporte(0.21);
		alicIvas[0] = alicIva;
		
		//Cargo el detalle.
		FECAEDetRequest[] feDetalles = new FECAEDetRequest[1];
		FECAEDetRequest feDetalle = new FECAEDetRequest();
		feDetalle.setDocTipo(80);
		feDetalle.setConcepto(2);
		feDetalle.setDocNro(30501213116l);					
		feDetalle.setCbteDesde(218l);
		feDetalle.setCbteHasta(218l);
		feDetalle.setImpTotal(1.21);
		feDetalle.setImpTotConc(0);
		feDetalle.setImpNeto(1);		
		feDetalle.setIva(alicIvas);
		//feDetalle.setImpTrib(0.21);
		feDetalle.setFchServDesde("20110501");
		feDetalle.setFchServHasta("20110515");
		feDetalle.setImpOpEx(0.0);
		feDetalle.setImpIVA(0.21);
		feDetalle.setMonId("PES");
		feDetalle.setMonCotiz(1);
		feDetalle.setCbteFch(formatoDeFecha.format(fecha));
		feDetalle.setFchVtoPago(formatoDeFecha.format(fecha));	
		feDetalles[0] = feDetalle;
		feReq.setFeCabReq(feCabecera);
		feReq.setFeDetReq(feDetalles);

		FECAEResponse  feResponse = new FECAEResponse();
		
		try {
			feResponse = service.FECAESolicitar(feAuth, feReq);
			Err[] errores = feResponse.getErrors();
			if(errores == null){
				if (feResponse.getFeDetResp() != null || feResponse.getFeDetResp().length > 0){
					Obs[] observaciones = feResponse.getFeDetResp()[0].getObservaciones();
					if(observaciones != null){
							for(Obs obs : observaciones){
						
							System.out.println(obs.getMsg());
						}
				}
				}
			}else{
				for(Err err: errores){
					System.out.println(err.getMsg());
				}
				
			}

			
			
			FECAEDetResponse[] feDetalleResponseA = feResponse.getFeDetResp();
			//System.out.println(feDetalleResponseA[0].getImp_neto());
			System.out.println("CAE " + feDetalleResponseA[0].getCAE());
			//System.out.println(feDetalleResponseA[0].getImpto_liq());
			System.out.println("Comprobante " + feDetalleResponseA[0].getCbteDesde());
			
			System.out.println("CAE Vencimiento" + feDetalleResponseA[0].getCAEFchVto());
			
			System.out.println("Prefijo " + feResponse.getFeCabResp().getPtoVta());
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
