package jmc.feol.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import jmc.feol.core.model.RespuestaAfip;
import jmc.feol.core.model.RespuestaAfipRemito;
import jmc.feol.core.model.RespuestaAfipRemitoError;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;



public class SerializateUtil {
	
	public static void generateRemitoPdf(RespuestaAfip ra, String nombreArchivo ){
		try{
		OutputStream file = new FileOutputStream(new File(nombreArchivo));

        Document document = new Document();
        PdfWriter.getInstance(document, file);
        document.open();
        
        Image image1 = Image.getInstance("c:\\logoEmpresa.png");
        document.add(image1);
        
        //CUIT Empresa
    	document.add(new Paragraph("Cuit de la Empresa",FontFactory.getFont("arial", 8, Font.BOLD)));
    	
    	document.add(new Paragraph(ra.getCuitEmpresa(),FontFactory.getFont("arial", 8, Font.NORMAL)));
        
        //Numero Comprobante
    	document.add(new Paragraph("Numero de Comprobante",FontFactory.getFont("arial", 8, Font.BOLD)));
    	
    	document.add(new Paragraph(ra.getNumeroComprobante(),FontFactory.getFont("arial", 8, Font.NORMAL)));
        
        //CODIGO INTEGRIDAD
    	document.add(new Paragraph("C�digo de Integridad",FontFactory.getFont("arial", 8, Font.BOLD)));
    	
    	document.add(new Paragraph(ra.getCodigoIntegridad(),FontFactory.getFont("arial", 8, Font.NORMAL)));
        
        //Validaciones Remitos
    	document.add(new Paragraph("Remitos",FontFactory.getFont("arial", 8, Font.BOLD)));
        
    	if (ra.getValidacionesRemitos() != null && ra.getValidacionesRemitos().getRemito() != null && ra.getValidacionesRemitos().getRemito().size() > 0){
    		for(RespuestaAfipRemito rr: ra.getValidacionesRemitos().getRemito()){
    			 //Remito
    	    	document.add(new Paragraph("Remito",FontFactory.getFont("arial", 8, Font.BOLD)));
    	    	document.add(new Paragraph("N�mero �nico",FontFactory.getFont("arial", 8, Font.BOLD)));
  	    	
    	    	document.add(new Paragraph(rr.getNumeroUnico(),FontFactory.getFont("arial", 8, Font.NORMAL)));

    	    	document.add(new Paragraph("Procesado",FontFactory.getFont("arial", 8, Font.BOLD)));
      	    	
    	    	document.add(new Paragraph(rr.getProcesado(),FontFactory.getFont("arial", 8, Font.NORMAL)));
    	    	if (rr.getErrores() != null && rr.getErrores().getError().size() > 0){
    	    		for(RespuestaAfipRemitoError rrr: rr.getErrores().getError()){
    	    	    	document.add(new Paragraph("Error",FontFactory.getFont("arial", 8, Font.BOLD)));
    	    	    	document.add(new Paragraph("C�digo",FontFactory.getFont("arial", 8, Font.BOLD)));    	  	    	
    	    	    	document.add(new Paragraph(rrr.getCodigo(),FontFactory.getFont("arial", 8, Font.NORMAL)));
    	    	    	document.add(new Paragraph("Descripci�n",FontFactory.getFont("arial", 8, Font.BOLD)));        	  	    	
    	    	    	document.add(new Paragraph(rrr.getDescripcion(),FontFactory.getFont("arial", 8, Font.NORMAL)));    	    	    	    	    		
    	    		}
    	    	}
    	      
    		}
    	}
       
        
        document.close();
        file.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
