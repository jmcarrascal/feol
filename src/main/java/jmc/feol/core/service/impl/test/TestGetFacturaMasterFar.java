package jmc.feol.core.service.impl.test;


import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import jmc.feol.core.model.Empresa;
import jmc.feol.core.service.impl.CredencialAfipManagerImpl;
import jmc.feol.util.DateUtil;
import FEV1.dif.afip.gov.ar.wmtx.AuthRequestType;
import FEV1.dif.afip.gov.ar.wmtx.CodigoDescripcionType;
import FEV1.dif.afip.gov.ar.wmtx.ConsultaComprobanteRequestType;
import FEV1.dif.afip.gov.ar.wmtx.ConsultarComprobanteRequestType;
import FEV1.dif.afip.gov.ar.wmtx.ConsultarComprobanteResponseType;
import FEV1.dif.afip.gov.ar.wmtx.ConsultarUltimoComprobanteAutorizadoRequestType;
import FEV1.dif.afip.gov.ar.wmtx.ItemType;
import FEV1.dif.afip.gov.ar.wmtx.MTXCAServicePortTypeProxy;
import FEV1.dif.afip.gov.ar.wmtx.SubtotalIVAType;


public class TestGetFacturaMasterFar {


	  public static void main (String args[]) {
		  Empresa empresa = new Empresa();
			
		  CredencialAfipManagerImpl credencialAfipManagerImpl = new CredencialAfipManagerImpl();
			try{
			empresa.setIdEmpresa(1l);
			empresa.setCuit("30716163748");
			empresa.setNombre("VASA");
			empresa.setEndpoint("https://wsaa.afip.gov.ar/ws/services/LoginCms");
			empresa.setService("wsfe");
			empresa.setDstDN("CN=wsaa, O=AFIP, C=AR, SERIALNUMBER=CUIT 33693450239");
			empresa.setP12File("");
			empresa.setP12pass("123456");
			empresa.setTicketTime(36000000l);
			empresa.setSigner("droval");
			
			//empresa.setRutaArchivoConfigAfip("c:/FacturaElectronica/wsaa_client_kila.properties");
			empresa = credencialAfipManagerImpl.getCredencial(empresa);
			}	catch(Exception e){
				e.printStackTrace();
			}
	  
	  		
		AuthRequestType feAuth = new AuthRequestType();
		try {
			//empresa = this.getCredencial(empresa.getIdEmpresa());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
						
		feAuth.setToken(empresa.getToken());
		
		feAuth.setSign(empresa.getSignToken());
		System.out.println(empresa.getToken());
		System.out.println(empresa.getSignToken());

		feAuth.setCuitRepresentada(30699754486l); 
		
		Long[] nros = {39173l};
		Short punto_vta = new Short("5");
		Short tipo_comprob = new Short("6");
		  
		for (Long nro :nros){
			getFacturas(nro, punto_vta, tipo_comprob, feAuth);
		}  
		
		
}

	  private static void writeFactura(ConsultarComprobanteRequestType c){
			MTXCAServicePortTypeProxy service = new MTXCAServicePortTypeProxy("https://serviciosjava.afip.gob.ar/wsmtxca/services/MTXCAService","");

		  ConsultarComprobanteResponseType r = null;
			
			try {
				r = service.consultarComprobante(c);
			} catch (RemoteException e) {			
				e.printStackTrace();
			}		
			if (r.getArrayErrores() != null){
			for (CodigoDescripcionType co :r.getArrayErrores()){
				System.out.println(co.getDescripcion());
			}
			}
			
			System.out.println("----------------------------------------------------------------");
			System.out.println("Fecha Comprobante: " + DateUtil.getFormattedDate(r.getComprobante().getFechaEmision()));
			
			
			System.out.println("Numero Comprobante: " + r.getComprobante().getNumeroComprobante());
			System.out.println("Tipo Comprobante : " + r.getComprobante().getCodigoTipoComprobante());
			System.out.println("Punto de Venta : " + r.getComprobante().getNumeroPuntoVenta());
			
			
			System.out.println("Importe Total: " + r.getComprobante().getImporteTotal());
			System.out.println("Importe Gravado: " + r.getComprobante().getImporteGravado());
			System.out.println("Importe No Gravado: " + r.getComprobante().getImporteNoGravado());
			System.out.println("Importe Otros Tributos: " + r.getComprobante().getImporteOtrosTributos());
			System.out.println("Importe SubTotal: " + r.getComprobante().getImporteSubtotal());
			
			if (r.getComprobante().getArraySubtotalesIVA() != null){
				for(SubtotalIVAType s: r.getComprobante().getArraySubtotalesIVA()){
					System.out.println("Iva Codigo: " + s.getCodigo() + " Iva Importe: " + s.getImporte());
					
		
				}
			}
			
			if (r.getComprobante().getArrayItems() != null){
				int j = 1;
				for(ItemType i: r.getComprobante().getArrayItems()){
					System.out.println(" -- Articulo(" +j+"): " + i.getDescripcion() + " Importe Item: " + i.getImporteItem()  + " Importe Item IVA: " + i.getImporteIVA());
					j++;
				}
			}
			
			System.out.println("Codigo Tipo Documento: " + r.getComprobante().getCodigoTipoDocumento());
			System.out.println("Numero de Documento: " + r.getComprobante().getNumeroDocumento());
			System.out.println("CAE: " + r.getComprobante().getCodigoAutorizacion());
			System.out.println("Vto CAE: " + DateUtil.getFormattedDate(r.getComprobante().getFechaVencimiento()));
				
		  
		  }
		  
private static void getFacturas(Long nro, Short punto_vta, Short tipo_comprob,AuthRequestType feAuth){
	
	ConsultarComprobanteRequestType c = new ConsultarComprobanteRequestType();
	
	ConsultaComprobanteRequestType cc = new ConsultaComprobanteRequestType();
	
	cc.setCodigoTipoComprobante(tipo_comprob);
	cc.setNumeroComprobante(nro);
	cc.setNumeroPuntoVenta(punto_vta);
	
	
	
	c.setAuthRequest(feAuth);
	c.setConsultaComprobanteRequest(cc);
	
	
	
	List<ConsultarComprobanteRequestType> listC = new ArrayList<ConsultarComprobanteRequestType>();
	
	listC.add(c);
	
	
	writeFactura(c);
	
}	  
}
	  