package jmc.feol.core.service.impl.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import jmc.feol.core.model.Empresa;
import jmc.feol.core.service.impl.CredencialAfipManagerImpl;
import jmc.feol.core.service.impl.FacturaManagerImpl;
import jmc.feol.util.DateUtil;

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
import FEV1.dif.afip.gov.ar.wmtx.AutorizarComprobanteResponseType;
import FEV1.dif.afip.gov.ar.wmtx.ConsultarComprobanteResponseType;

public class GetFacturacionMTX {

	public static Empresa getCredencial() {

		CredencialAfipManagerImpl credencialAfipManagerImpl = new CredencialAfipManagerImpl();
		try {
			Empresa empresa = new Empresa();
			empresa.setIdEmpresa(1l);
			empresa.setCuit("33708983409");
			empresa.setNombre("Janin_credito_b");
			empresa.setEndpoint("https://wsaa.afip.gov.ar/ws/services/LoginCms");
			empresa.setService("wsfe");
			empresa.setDstDN("CN=wsaa, O=AFIP, C=AR, SERIALNUMBER=CUIT 33693450239");
			empresa.setP12File("/Users/juanmanuelcarrascal/projects/ERP/Certificados/janin/janin1.p12");
			empresa.setP12pass("123456");
			empresa.setTicketTime(36000000l);
			empresa.setSigner("janin");

			empresa = credencialAfipManagerImpl.getCredencial(empresa);
			// empresa.setToken("PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/Pgo8c3NvIHZlcnNpb249IjIuMCI+CiAgICA8aWQgdW5pcXVlX2lkPSI0Mzk2MjM4NDUiIHNyYz0iQ049d3NhYSwgTz1BRklQLCBDPUFSLCBTRVJJQUxOVU1CRVI9Q1VJVCAzMzY5MzQ1MDIzOSIgZ2VuX3RpbWU9IjEzOTM1NjEyOTQiIGV4cF90aW1lPSIxMzkzNjA0NTU0IiBkc3Q9IkNOPXdzZmUsIE89QUZJUCwgQz1BUiIvPgogICAgPG9wZXJhdGlvbiB2YWx1ZT0iZ3JhbnRlZCIgdHlwZT0ibG9naW4iPgogICAgICAgIDxsb2dpbiB1aWQ9IkM9YXIsIFNUPWJzYXMsIEw9YnNhcywgTz1jbHVlLCBPVT1jbHVlLCBTRVJJQUxOVU1CRVI9Q1VJVCAzMzcxMDgyODI1OSwgQ049Y2x1ZS5jb20uYXIiIHNlcnZpY2U9IndzZmUiIHJlZ21ldGhvZD0iMjIiIGVudGl0eT0iMzM2OTM0NTAyMzkiIGF1dGhtZXRob2Q9ImNtcyI+CiAgICAgICAgICAgIDxyZWxhdGlvbnM+CiAgICAgICAgICAgICAgICA8cmVsYXRpb24gcmVsdHlwZT0iNCIga2V5PSIzMzcxMDgyODI1OSIvPgogICAgICAgICAgICA8L3JlbGF0aW9ucz4KICAgICAgICA8L2xvZ2luPgogICAgPC9vcGVyYXRpb24+Cjwvc3NvPgoK");
			// empresa.setSignToken("c3fNOLnqaxswRZJsUT/FLO04Db6HVODS/hh2eHAw3YeFwCNHTo7dDGagxUVl2hulVND1hcW0nRaW/Dkgx95GOJDPbwMexq4/zeKZ+jbcrr2isr7JaL+bNvzICzQXeqS5UX5gRGoPTU8X/ZkxgY4+zgTR5WO6jkvd4ixW7DiDwIM=");
			return empresa;

		} catch (Exception e) {
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
		// empresa = getCredencial();
		empresa.setToken(
				"PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/Pgo8c3NvIHZlcnNpb249IjIuMCI+CiAgICA8aWQgdW5pcXVlX2lkPSIzNzg1Mjg3OTA5IiBzcmM9IkNOPXdzYWEsIE89QUZJUCwgQz1BUiwgU0VSSUFMTlVNQkVSPUNVSVQgMzM2OTM0NTAyMzkiIGdlbl90aW1lPSIxNTA0ODgyOTY0IiBleHBfdGltZT0iMTUwNDkyNjIyNCIvPgogICAgPG9wZXJhdGlvbiB2YWx1ZT0iZ3JhbnRlZCIgdHlwZT0ibG9naW4iPgogICAgICAgIDxsb2dpbiB1aWQ9IkM9YXIsIFNUPWJ1ZW5vcyBhaXJlcywgTD1idWVub3MgYWlyZXMsIE89ZHJvZmFyLCBPVT1kcm9mYXIsIFNFUklBTE5VTUJFUj1DVUlUIDMwNzA3NDE2NTI4LCBDTj1kcm9mYXIuY29tLmFyLCBFTUFJTEFERFJFU1M9aW5mb0Bkcm9mYXIuY29tLmFyIiBzZXJ2aWNlPSJ3c210eGNhIiByZWdtZXRob2Q9IjIyIiBlbnRpdHk9IjMzNjkzNDUwMjM5IiBhdXRobWV0aG9kPSJjbXMiPgogICAgICAgICAgICA8cmVsYXRpb25zPgogICAgICAgICAgICAgICAgPHJlbGF0aW9uIHJlbHR5cGU9IjQiIGtleT0iMzA3MDc0MTY1MjgiLz4KICAgICAgICAgICAgPC9yZWxhdGlvbnM+CiAgICAgICAgPC9sb2dpbj4KICAgIDwvb3BlcmF0aW9uPgo8L3Nzbz4KCg==");
		empresa.setCuit("30707416528");
		empresa.setSignToken(
				"EdVEWI4VfHvDKxwfZoDwuwMg38gJ+dbzDbsLNjMve7D3Jur2N1Eln0hlKB0Js+31mEGPxxvAFVNyaOtHXREIgV2L5KkoKXvPZtnRAJXnznc9pQSU6I4+bfhdaSnBIzKBInuqyqGKRKgXMBQiNo2LKCzP/QUCEiE6x/m8ESSyhsY=");
		// Hago un loop sobre el punto de venta
		int punto_venta = 10;
		boolean end_facturacion = false;
		Long nro_comprob = 1l;
		// Se crea el libro Excel
		HSSFWorkbook wb = new HSSFWorkbook();

		// Se crea una nueva hoja dentro del libro
		HSSFSheet sheet = wb.createSheet("Facturacion");

		// Se crea una fila dentro de la hoja
		HSSFRow row_ = sheet.createRow((short) 0);

		// Creamos celdas de varios tipos
		row_.createCell((short) 0).setCellValue("Fecha Proceso");
		row_.createCell((short) 1).setCellValue("Tipo Comprobante");
		row_.createCell((short) 2).setCellValue("Punto de Venta");
		row_.createCell((short) 3).setCellValue("Nro Comprobante");
		row_.createCell((short) 4).setCellValue("Importe Total");
		row_.createCell((short) 5).setCellValue("Importe Neto");
		row_.createCell((short) 6).setCellValue("Importe IVA");
		row_.createCell((short) 7).setCellValue("Tipo Doc");
		row_.createCell((short) 8).setCellValue("Numero Doc");
		row_.createCell((short) 9).setCellValue("CAE");
		row_.createCell((short) 10).setCellValue("Vencimiento CAE");
		short nro_fila = 0;
		Integer[] lista = new Integer[1];
		lista[0] = 8;
		for (Integer tipo_comprob : lista) {
			end_facturacion = false;
			nro_comprob = 1l;
			Long nro_comprobFinal = 2l;
			while (nro_comprob < nro_comprobFinal) {
				ConsultarComprobanteResponseType res = getFacturaMTX(empresa, nro_comprob, tipo_comprob, punto_venta);
				if (res != null) {
					nro_comprob++;

					try {
						Date fecha = res.getComprobante().getFechaEmision();
						// if (true){
						System.out.println(DateUtil.getFormattedDate(fecha));
						//
						if (true) {
							try {
								nro_fila++;
								// Se crea una fila dentro de la hoja
								HSSFRow row = sheet.createRow(nro_fila);

								row.createCell((short) 0).setCellValue(DateUtil.getFormattedDate(res.getComprobante().getFechaEmision()));
								row.createCell((short) 1).setCellValue(res.getComprobante().getCodigoTipoComprobante());
								row.createCell((short) 2).setCellValue(res.getComprobante().getNumeroPuntoVenta());
								row.createCell((short) 3).setCellValue(res.getComprobante().getNumeroComprobante());
								row.createCell((short) 4).setCellValue(String.valueOf(res.getComprobante().getImporteTotal()));
								row.createCell((short) 5).setCellValue(String.valueOf(res.getComprobante().getImporteGravado()));
								row.createCell((short) 6).setCellValue(String.valueOf(res.getComprobante().getImporteOtrosTributos()));
								row.createCell((short) 7).setCellValue(res.getComprobante().getCodigoTipoDocumento());
								row.createCell((short) 8).setCellValue(res.getComprobante().getNumeroDocumento());
								row.createCell((short) 9).setCellValue(String.valueOf(res.getComprobante().getCodigoAutorizacion()));
								row.createCell((short) 10).setCellValue(DateUtil.getFormattedDate(res.getComprobante().getFechaVencimiento()));

							} catch (Exception e) {
								System.out.println("Error al escribir el fichero.");
							}

							System.out.println(String.valueOf(res.getComprobante().getImporteTotal()));
						}
					} catch (Exception e) {
						e.printStackTrace();
						end_facturacion = true;
					}
				} else {
					end_facturacion = true;
				}
			}
		}
		// Escribimos los resultados a un fichero Excel
		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream(
					"/Users/juanmanuelcarrascal/Documents/ventas_2012_" + empresa.getNombre() + ".xls");
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

	public static Integer[] getTipoComprob() {
		Integer[] tipo_comprobante_list = new Integer[6];
		tipo_comprobante_list[0] = 2;
		tipo_comprobante_list[1] = 1;
		tipo_comprobante_list[2] = 3;
		tipo_comprobante_list[3] = 6;
		tipo_comprobante_list[4] = 7;
		tipo_comprobante_list[5] = 8;
		return tipo_comprobante_list;
	}

	public static ConsultarComprobanteResponseType getFacturaMTX(Empresa empresa, Long nro_comprob, int tipo_comprob,
			int punto_vta) {

		
		ConsultarComprobanteResponseType autorizarComprobanteResponseType = null;
		try {
			FacturaManagerImpl facturaManagerImpl = new FacturaManagerImpl();

			 autorizarComprobanteResponseType = facturaManagerImpl
					.getFacturaMTX(nro_comprob, tipo_comprob, punto_vta, empresa);

			String resultado = "";
		} catch (Exception e) {
			e.printStackTrace();
		}

		return autorizarComprobanteResponseType;
	}

}
