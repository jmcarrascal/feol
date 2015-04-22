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



public class InvokeFacturaParam {

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

		ServiceSoapProxy service = new ServiceSoapProxy();
		FEAuthRequest feAuth = new FEAuthRequest();
		feAuth.setToken("PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/Pgo8c3NvIHZlcnNpb249IjIuMCI+CiAgICA8aWQgdW5pcXVlX2lkPSIxMDIxMDAyMTQ3IiBzcmM9IkNOPXdzYWFob21vLCBPPUFGSVAsIEM9QVIsIFNFUklBTE5VTUJFUj1DVUlUIDMzNjkzNDUwMjM5IiBnZW5fdGltZT0iMTMwMzM1MTc3NSIgZXhwX3RpbWU9IjEzMDMzOTUwMzUiIGRzdD0iQ049d3NmZSwgTz1BRklQLCBDPUFSIi8+CiAgICA8b3BlcmF0aW9uIHZhbHVlPSJncmFudGVkIiB0eXBlPSJsb2dpbiI+CiAgICAgICAgPGxvZ2luIHVpZD0iQz1hciwgU1Q9YnVlbm9zIGFpcmVzLCBMPWJ1ZW5vcyBhaXJlcywgTz1jb2luc2UsIE9VPWNvaW5zZSwgU0VSSUFMTlVNQkVSPUNVSVQgMzA3MDA0NDIzNjEsIENOPWNvaW5zZS5jb20uYXIsIEVNQUlMQUREUkVTUz1jb2luc2VAY29pbnNlLmNvbS5hciIgc2VydmljZT0id3NmZSIgcmVnbWV0aG9kPSIyMiIgZW50aXR5PSIzMzY5MzQ1MDIzOSIgYXV0aG1ldGhvZD0iY21zIj4KICAgICAgICAgICAgPHJlbGF0aW9ucz4KICAgICAgICAgICAgICAgIDxyZWxhdGlvbiByZWx0eXBlPSI0IiBrZXk9IjMwNzAwNDQyMzYxIi8+CiAgICAgICAgICAgIDwvcmVsYXRpb25zPgogICAgICAgIDwvbG9naW4+CiAgICA8L29wZXJhdGlvbj4KPC9zc28+Cgo=");
		feAuth.setSign("mZTqciXMVdkxIN1rVeC9ABadKxNvOUjEQP2fYlcB17uK1Wls6MwsFhOlEnifRQWgb303eQJoYmyb9p0ufgVhOoPvxY8+MpJpHKFIdt0SssdJOv9rl0H4/Yw6rE7xAbT4R8VMedEJqs0KSI0rvlkn//9Eoy/vpkIzvUdkSnWOBbc=");
		feAuth.setCuit(30700442361l);
				
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
	public void autorizarFactura(FECAERequest feReq){
		
		ServiceSoapProxy service = new ServiceSoapProxy();
		FEAuthRequest feAuth = new FEAuthRequest();
		feAuth.setToken("PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/Pgo8c3NvIHZlcnNpb249IjIuMCI+CiAgICA8aWQgdW5pcXVlX2lkPSIzMjY3MDk4MDgyIiBzcmM9IkNOPXdzYWFob21vLCBPPUFGSVAsIEM9QVIsIFNFUklBTE5VTUJFUj1DVUlUIDMzNjkzNDUwMjM5IiBnZW5fdGltZT0iMTMwNjEwMDM5MiIgZXhwX3RpbWU9IjEzMDYxNDM2NTIiIGRzdD0iQ049d3NmZSwgTz1BRklQLCBDPUFSIi8+CiAgICA8b3BlcmF0aW9uIHZhbHVlPSJncmFudGVkIiB0eXBlPSJsb2dpbiI+CiAgICAgICAgPGxvZ2luIHVpZD0iQz1hciwgU1Q9YnVlbm9zIGFpcmVzLCBMPWJ1ZW5vcyBhaXJlcywgTz1jb2luc2UsIE9VPWNvaW5zZSwgU0VSSUFMTlVNQkVSPUNVSVQgMzA3MDA0NDIzNjEsIENOPWNvaW5zZS5jb20uYXIsIEVNQUlMQUREUkVTUz1jb2luc2VAY29pbnNlLmNvbS5hciIgc2VydmljZT0id3NmZSIgcmVnbWV0aG9kPSIyMiIgZW50aXR5PSIzMzY5MzQ1MDIzOSIgYXV0aG1ldGhvZD0iY21zIj4KICAgICAgICAgICAgPHJlbGF0aW9ucz4KICAgICAgICAgICAgICAgIDxyZWxhdGlvbiByZWx0eXBlPSI0IiBrZXk9IjMwNzAwNDQyMzYxIi8+CiAgICAgICAgICAgIDwvcmVsYXRpb25zPgogICAgICAgIDwvbG9naW4+CiAgICA8L29wZXJhdGlvbj4KPC9zc28+Cgo=");
		feAuth.setSign("CufsSiTcLpErGBsVEjoZ7iuPKEg3F5K+5t2Ciuw06GLzzZdqc3jdt1Dg0TULdWjNEUAUipefeL/3PcqA5imngAi3hZ+I3SitaZpYUom20C5Mek9o0tGIf2kor1Klp2/esuTh2k+sjc2mbm2PI/tYC/c3XHqtPR3r3RNsjN4fN2w=");
		feAuth.setCuit(30700442361l);

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
