package jmc.feol.core.service.impl.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;

import jmc.feol.core.model.Empresa;
import jmc.feol.core.service.impl.CredencialAfipManagerImpl;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import FEV1.dif.afip.gov.ar.Err;
import FEV1.dif.afip.gov.ar.FEAuthRequest;
import FEV1.dif.afip.gov.ar.FECompConsResponse;
import FEV1.dif.afip.gov.ar.FECompConsultaReq;
import FEV1.dif.afip.gov.ar.FECompConsultaResponse;
import FEV1.dif.afip.gov.ar.ServiceSoapProxy;

public class GetFacturacion {

public static Empresa getCredencial(){
		
		CredencialAfipManagerImpl credencialAfipManagerImpl = new CredencialAfipManagerImpl();
		try{
		Empresa empresa = new Empresa();
		empresa.setIdEmpresa(1l);
		empresa.setCuit("30713480009");
		empresa.setNombre("Salmun");
		empresa.setEndpoint("https://wsaa.afip.gov.ar/ws/services/LoginCms");
		empresa.setService("wsfe");
		empresa.setDstDN("CN=wsaa, O=AFIP, C=AR, SERIALNUMBER=CUIT 33693450239");
		empresa.setP12File("C:/Certificados/playdon/playdon1.p12");
		empresa.setP12pass("123456");
		empresa.setTicketTime(36000000l);
		empresa.setSigner("playdon");
		
		
		empresa = credencialAfipManagerImpl.getCredencial(empresa);
		//empresa.setToken("PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/Pgo8c3NvIHZlcnNpb249IjIuMCI+CiAgICA8aWQgdW5pcXVlX2lkPSI0Mzk2MjM4NDUiIHNyYz0iQ049d3NhYSwgTz1BRklQLCBDPUFSLCBTRVJJQUxOVU1CRVI9Q1VJVCAzMzY5MzQ1MDIzOSIgZ2VuX3RpbWU9IjEzOTM1NjEyOTQiIGV4cF90aW1lPSIxMzkzNjA0NTU0IiBkc3Q9IkNOPXdzZmUsIE89QUZJUCwgQz1BUiIvPgogICAgPG9wZXJhdGlvbiB2YWx1ZT0iZ3JhbnRlZCIgdHlwZT0ibG9naW4iPgogICAgICAgIDxsb2dpbiB1aWQ9IkM9YXIsIFNUPWJzYXMsIEw9YnNhcywgTz1jbHVlLCBPVT1jbHVlLCBTRVJJQUxOVU1CRVI9Q1VJVCAzMzcxMDgyODI1OSwgQ049Y2x1ZS5jb20uYXIiIHNlcnZpY2U9IndzZmUiIHJlZ21ldGhvZD0iMjIiIGVudGl0eT0iMzM2OTM0NTAyMzkiIGF1dGhtZXRob2Q9ImNtcyI+CiAgICAgICAgICAgIDxyZWxhdGlvbnM+CiAgICAgICAgICAgICAgICA8cmVsYXRpb24gcmVsdHlwZT0iNCIga2V5PSIzMzcxMDgyODI1OSIvPgogICAgICAgICAgICA8L3JlbGF0aW9ucz4KICAgICAgICA8L2xvZ2luPgogICAgPC9vcGVyYXRpb24+Cjwvc3NvPgoK");
		//empresa.setSignToken("c3fNOLnqaxswRZJsUT/FLO04Db6HVODS/hh2eHAw3YeFwCNHTo7dDGagxUVl2hulVND1hcW0nRaW/Dkgx95GOJDPbwMexq4/zeKZ+jbcrr2isr7JaL+bNvzICzQXeqS5UX5gRGoPTU8X/ZkxgY4+zgTR5WO6jkvd4ixW7DiDwIM=");
		return empresa;
		
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}

		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Obtengo el token y Sign
		Empresa empresa = new Empresa();
		empresa = getCredencial();
		// Hago un loop sobre el punto de venta
		int punto_venta = 2;
		boolean end_facturacion = false; 
		Long nro_comprob = 1l;
		 //Se crea el libro Excel
        HSSFWorkbook wb = new HSSFWorkbook();

        //Se crea una nueva hoja dentro del libro
        HSSFSheet sheet = wb.createSheet("Facturacion");
        
        //Se crea una fila dentro de la hoja
        HSSFRow row_ = sheet.createRow((short)0);

        
        //Creamos celdas de varios tipos
        row_.createCell((short)0).setCellValue("Fecha Proceso");
        row_.createCell((short)1).setCellValue("Tipo Comprobante");
        row_.createCell((short)2).setCellValue("Punto de Venta");
        row_.createCell((short)3).setCellValue("Nro Comprobante");
        row_.createCell((short)4).setCellValue("Importe Total");
        row_.createCell((short)5).setCellValue("Importe Neto");
        row_.createCell((short)6).setCellValue("Importe IVA");
        row_.createCell((short)7).setCellValue("Tipo Doc");
        row_.createCell((short)8).setCellValue("Numero Doc");
        row_.createCell((short)9).setCellValue("CAE");
        row_.createCell((short)10).setCellValue("Vencimiento CAE");
        short nro_fila = 0;
		Integer[] lista = new Integer[1];
		lista[0]=8;
        for(Integer tipo_comprob : lista){
			end_facturacion = false;
			nro_comprob = 1122l;
			while(!end_facturacion){
				FECompConsResponse res = getFactura(empresa.getToken(), empresa.getSignToken(), Long.parseLong(empresa.getCuit()),nro_comprob, tipo_comprob,punto_venta);
				if (res != null){		
					nro_comprob ++;
					//if (nro_comprob>3){
					//	end_facturacion = true;
					//}
					try{
						Long fecha = Long.parseLong(res.getFchProceso());
						//if (true){
						System.out.println(fecha);
//						if (fecha > 20140318000000l){
//							end_facturacion = true;
//						}
						//if (fecha > 20111231000000l && fecha < 20140319000000l){
							if(true){
							 try
						        {
								 	nro_fila++;
						            //Se crea una fila dentro de la hoja
						            HSSFRow row = sheet.createRow(nro_fila);
						 
						            row.createCell((short)0).setCellValue(res.getCbteFch());
						            row.createCell((short)1).setCellValue(res.getCbteTipo());
						            row.createCell((short)2).setCellValue(res.getPtoVta());
						            row.createCell((short)3).setCellValue(res.getCbteDesde());
						            row.createCell((short)4).setCellValue(res.getImpTotal());
						            row.createCell((short)5).setCellValue(res.getImpNeto());
						            row.createCell((short)6).setCellValue(res.getImpIVA());
						            row.createCell((short)7).setCellValue(res.getDocTipo());
						            row.createCell((short)8).setCellValue(res.getDocNro());
						            row.createCell((short)9).setCellValue(res.getCodAutorizacion());
						            row.createCell((short)10).setCellValue(res.getFchVto());
						          
						        }
						        catch(Exception e)
						        {
						            System.out.println("Error al escribir el fichero.");
						        }
						    
							System.out.println(res.getImpTotal());
						}
					}catch(Exception e){
						e.printStackTrace();
						end_facturacion = true;
					}
				}else{
					end_facturacion = true;
				}
			}
		}
		  //Escribimos los resultados a un fichero Excel
        FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream("c://ventas_2012_"  + empresa.getNombre() + ".xls");
			 wb.write(fileOut);
		     fileOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

       
	}
	
	public static Integer[] getTipoComprob(){
		Integer[] tipo_comprobante_list = new Integer[6];
		tipo_comprobante_list[0] = 2;
		tipo_comprobante_list[1] = 1;
		tipo_comprobante_list[2] = 3;
		tipo_comprobante_list[3] = 6;
		tipo_comprobante_list[4] = 7;
		tipo_comprobante_list[5] = 8;
		return tipo_comprobante_list;
	}
	
	public static FECompConsResponse getFactura(String token, String sign, Long cuit, Long nro_comprob, int tipo_comprob, int punto_vta){
		
		ServiceSoapProxy service = new ServiceSoapProxy("https://servicios1.afip.gov.ar/wsfev1/service.asmx");
		FEAuthRequest feAuth = new FEAuthRequest();

		feAuth.setToken(token);
		feAuth.setSign(sign);
		
		//feAuth.setToken("PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/Pgo8c3NvIHZlcnNpb249IjIuMCI+CiAgICA8aWQgdW5pcXVlX2lkPSI0Mzk2MjM4NDUiIHNyYz0iQ049d3NhYSwgTz1BRklQLCBDPUFSLCBTRVJJQUxOVU1CRVI9Q1VJVCAzMzY5MzQ1MDIzOSIgZ2VuX3RpbWU9IjEzOTM1NjEyOTQiIGV4cF90aW1lPSIxMzkzNjA0NTU0IiBkc3Q9IkNOPXdzZmUsIE89QUZJUCwgQz1BUiIvPgogICAgPG9wZXJhdGlvbiB2YWx1ZT0iZ3JhbnRlZCIgdHlwZT0ibG9naW4iPgogICAgICAgIDxsb2dpbiB1aWQ9IkM9YXIsIFNUPWJzYXMsIEw9YnNhcywgTz1jbHVlLCBPVT1jbHVlLCBTRVJJQUxOVU1CRVI9Q1VJVCAzMzcxMDgyODI1OSwgQ049Y2x1ZS5jb20uYXIiIHNlcnZpY2U9IndzZmUiIHJlZ21ldGhvZD0iMjIiIGVudGl0eT0iMzM2OTM0NTAyMzkiIGF1dGhtZXRob2Q9ImNtcyI+CiAgICAgICAgICAgIDxyZWxhdGlvbnM+CiAgICAgICAgICAgICAgICA8cmVsYXRpb24gcmVsdHlwZT0iNCIga2V5PSIzMzcxMDgyODI1OSIvPgogICAgICAgICAgICA8L3JlbGF0aW9ucz4KICAgICAgICA8L2xvZ2luPgogICAgPC9vcGVyYXRpb24+Cjwvc3NvPgoK");
		//feAuth.setSign("c3fNOLnqaxswRZJsUT/FLO04Db6HVODS/hh2eHAw3YeFwCNHTo7dDGagxUVl2hulVND1hcW0nRaW/Dkgx95GOJDPbwMexq4/zeKZ+jbcrr2isr7JaL+bNvzICzQXeqS5UX5gRGoPTU8X/ZkxgY4+zgTR5WO6jkvd4ixW7DiDwIM=");

		
		
		feAuth.setCuit(cuit);			
		
		FECompConsultaReq feCompConsReq = new FECompConsultaReq ();
		feCompConsReq.setCbteNro(nro_comprob);
		feCompConsReq.setCbteTipo(tipo_comprob);
		feCompConsReq.setPtoVta(punto_vta);
		try {
			FECompConsultaResponse fECompConsultaResponse   = service.FECompConsultar(feAuth, feCompConsReq);
			FECompConsResponse res =  fECompConsultaResponse.getResultGet();
			if (fECompConsultaResponse.getErrors() != null){
				for(Err error : fECompConsultaResponse.getErrors()){
					System.out.println(error.getMsg());
				}
			}
			return res;		
		} catch (Exception e) {			
			e.printStackTrace();
		}				
		return null;
		
	}
	
	
}
