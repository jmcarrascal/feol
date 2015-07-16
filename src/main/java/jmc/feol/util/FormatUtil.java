package jmc.feol.util;



import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import fexv1.dif.afip.gov.ar.ClsFEXGetCMPR;

public class FormatUtil {

	public static Long formatCuit(String cuit) throws Exception
	{
	    Long cuitFormated = 0l;
		System.out.println("Cuit " + cuit);
	    cuit = cuit.trim().replaceAll("-", "");
	    cuit = cuit.trim().replaceAll(" ", "");
	    try{
	    	cuitFormated = Long.parseLong(cuit);
	    }catch(NumberFormatException e){
	    	e.printStackTrace();
	    }		
		return cuitFormated;
	}

	public static boolean validar(String cadena, Long[] valores){
        
    	char[] nroClave = cadena.toCharArray();
        int checksuma=0;
        
        for(int i=0;i<11;i++){
            checksuma  += Integer.parseInt( String.valueOf( nroClave[i] ))*i;
        }                
        
        for(Long valor : valores){
	        System.out.println("comparo valor: " + valor + "checksuma =" + checksuma);
        	if (checksuma==valor)
	                return true;                	
        }
        return false;
    }
	
	public static String getError(String valorInt){		
		if (valorInt != null){
			int i = valorInt.indexOf("|", 1);
			while (i != -1){			 
				valorInt = valorInt.substring(i);
				i = valorInt.indexOf("|", 1);
				
			}
			return valorInt.replaceFirst("\\|", "");					
		}else{
			return null;
		}
	}

	public static String llenoConCeros(String valor, int longitud){
		while(valor.length() < longitud){
			valor = "0" + valor;
		}
		return valor;
	}

	public static double redondearEn2(double numero)
	{
	       return Math.rint(numero*100)/100;
	}
	
	public static double redondearEn6(double numero)
	{
	       return Math.rint(numero*1000000)/1000000;
	}

	public static byte[] getFacturasExcel(List<String> facturasPerdidas){
		
        HSSFWorkbook libro = new HSSFWorkbook();

        // Se crea una hoja dentro del libro
        HSSFSheet hoja = libro.createSheet();

        // Se crea una fila dentro de la hoja
        HSSFRow fila = hoja.createRow(1);

        // Se crea una celda dentro de la fila.
        HSSFCell prefijo = fila.createCell((short) 0);
        HSSFCell tipoCompr = fila.createCell((short) 1);	        
        HSSFCell nroComprobante = fila.createCell((short) 2);
        HSSFCell cae = fila.createCell((short) 3);
        HSSFCell vtoCae = fila.createCell((short) 4);
        HSSFCell impTotal = fila.createCell((short) 5);
        HSSFCell impNeto = fila.createCell((short) 6);	        
        HSSFCell impTrib = fila.createCell((short) 7);
        HSSFCell impIVA = fila.createCell((short) 8);
        HSSFCell docNro = fila.createCell((short) 9);
        HSSFCell docTipo = fila.createCell((short) 10);
        HSSFCell cbteFch = fila.createCell((short) 11);               
        
        // Se crea el contenido de la celda y se mete en ella.        
        prefijo.setCellValue("Punto de Vta");
        tipoCompr.setCellValue("Tipo Comprobante");
        nroComprobante.setCellValue("Numero Comprobante");        
        cae.setCellValue("Nro CAE");
        vtoCae.setCellValue("Vto. CAE");
        impTotal.setCellValue("Importe Total");
        impNeto.setCellValue("Importe Neto");
        impTrib.setCellValue("Importe Tributo");        
        impIVA.setCellValue("Importe IVA");
        docNro.setCellValue("Numero Doc");
        docTipo.setCellValue("Tipo de Doc");
        cbteFch.setCellValue("Fecha Cbte");
        
        int i = 2;
        for(String factura : facturasPerdidas){
            HSSFRow filaNew = hoja.createRow(i);

            // Se crea una celda dentro de la fila
            HSSFCell prefijoNew = filaNew.createCell((short) 0);
            HSSFCell tipoComprNew = filaNew.createCell((short) 1);	        
            HSSFCell nroComprobanteNew = filaNew.createCell((short) 2);
            HSSFCell caeNew = filaNew.createCell((short) 3);
            HSSFCell vtoCaeNew = filaNew.createCell((short) 4);
            HSSFCell impTotalNew = filaNew.createCell((short) 5);
            HSSFCell impNetoNew = filaNew.createCell((short) 6);	        
            HSSFCell impTribNew = filaNew.createCell((short) 7);
            HSSFCell impIVANew = filaNew.createCell((short) 8);
            HSSFCell docNroNew = filaNew.createCell((short) 9);
            HSSFCell docTipoNew = filaNew.createCell((short) 10);
            HSSFCell cbteFchNew = filaNew.createCell((short) 11);               
            
            
            // Se crea el contenido de la celda y se mete en ella.
            //HSSFRichTextString texto = new HSSFRichTextString("hola mundo");
            
        	String[] campos = factura.split("\\;");
        	try{
        		prefijoNew.setCellValue(campos[0]);	
        	}catch(Exception e){
        		e.printStackTrace();
        	}
        	try{        		
        		tipoComprNew.setCellValue(campos[1]);
        	}catch(Exception e){
        		e.printStackTrace();
        	}
        	try{        		
        		nroComprobanteNew.setCellValue(campos[2]);
        	}catch(Exception e){
        		e.printStackTrace();
        	}
        	try{
        		caeNew.setCellValue(campos[3]);        		
        	}catch(Exception e){
        		e.printStackTrace();
        	}
        	try{        		
        		vtoCaeNew.setCellValue(campos[4]);	
        	}catch(Exception e){
        		e.printStackTrace();
        	}

        	try{        		
        		impTotalNew.setCellValue(campos[5]);	
        	}catch(Exception e){
        		e.printStackTrace();
        	}
        	try{        		
        		impNetoNew.setCellValue(campos[6]);	
        	}catch(Exception e){
        		e.printStackTrace();
        	}
        	try{        		
        		impTribNew.setCellValue(campos[7]);	
        	}catch(Exception e){
        		e.printStackTrace();
        	}
        	try{        		
        		impIVANew.setCellValue(campos[8]);	
        	}catch(Exception e){
        		e.printStackTrace();
        	}
        	try{
        		docNroNew.setCellValue(campos[9]);
        	}catch(Exception e){
        		e.printStackTrace();
        	}
        	try{
        		docTipoNew.setCellValue(campos[10]);
        	}catch(Exception e){
        		e.printStackTrace();
        	}try{
        		cbteFchNew.setCellValue(campos[11]);
        	}catch(Exception e){
        		e.printStackTrace();
        	}
        	i++;
        }
        // Se salva el libro.
        FileOutputStream elFichero = null;
        String nombreArchivo = "c:\\T_" +System.currentTimeMillis()+".txt";
        byte[] array = null;
        try {
        	
        	elFichero = new FileOutputStream(nombreArchivo);
            libro.write(elFichero);
            elFichero.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
		try {
			array = FileUtil.getBytesFromFile(new File(nombreArchivo));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File fileDelete = new File(nombreArchivo);
		fileDelete.delete();

        return array;
    }
	
	public static Image getImage(byte[] bytes, boolean isThumbnail) throws IOException {

		ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
		Iterator readers = ImageIO.getImageReadersByFormatName("jpeg");
		ImageReader reader = (ImageReader) readers.next();
		Object source = bis; // File or InputStream
		ImageInputStream iis = ImageIO.createImageInputStream(source);
		reader.setInput(iis, true);
		ImageReadParam param = reader.getDefaultReadParam();
		if (isThumbnail) {

		param.setSourceSubsampling(4, 4, 0, 0);

		}
		return reader.read(0, param);

	}

//	public static byte[] convertJPG(String filename, int parte) throws IOException {
//
//        File file = new File(filename);
//        SeekableStream s = new FileSeekableStream(file);
//
//        TIFFDecodeParam param = null;
//                
//        
//        ImageDecoder dec = ImageCodec.createImageDecoder("tiff", s, param);
//
//        
//        
//        
//        // Which of the multiple images in the TIFF file do we want to load
//        // 0 refers to the first, 1 to the second and so on.
//        int imageToLoad = parte;
//
//        RenderedImage op =
//            new NullOpImage(dec.decodeAsRenderedImage(imageToLoad),
//                            null,
//                            OpImage.OP_IO_BOUND,
//                            null);
//        
//        
//        PlanarImage pi = PlanarImage.wrapRenderedImage(op);
//               
//        BufferedImage bi = pi.getAsBufferedImage();
//                
//        Graphics2D g = (Graphics2D)bi.getGraphics();
//        
//        g.drawLine(0,0,50,50);
//        
//        g.scale(20, 20);
//                        
//        g.dispose();
//        
//        ByteArrayOutputStream bas =	new ByteArrayOutputStream();
//		ImageIO.write(bi, "jpg", bas);
//		byte[] data = bas.toByteArray();
//		
//		return data;
//    }

		
		
	public static byte[] mergeJPG(byte[] image1, byte[] image2){
		ByteArrayInputStream bi1 = new ByteArrayInputStream (image1);
		ByteArrayInputStream bi2 = new ByteArrayInputStream (image2);
		BufferedImage image = null;
		BufferedImage overlay = null;
		try {
		image = ImageIO.read(bi1);
		overlay= ImageIO.read(bi2);
		} catch (IOException e) {
		e.printStackTrace();
		}

		// create the new image, canvas size is the max. of both image sizes
		int w = Math.max(image.getWidth(), overlay.getWidth());
		int h = Math.max(image.getHeight(), overlay.getHeight());
		BufferedImage combined = new BufferedImage(w, h*2, BufferedImage.TYPE_BYTE_GRAY);

		// paint both images, preserving the alpha channels
		Graphics g = combined.getGraphics();
		g.drawImage(image, 0, 0, null);
		g.drawImage(overlay, 0, h, null);
		ByteArrayOutputStream bas = new ByteArrayOutputStream();
		try {
		ImageIO.write(combined, "jpg", bas);
		} catch (IOException e) {
		e.printStackTrace();
		}
		byte[] data = bas.toByteArray();
		return data;
		}

	public static Double redondearEn4(Double porDesc) {
		return Math.rint(porDesc*10000)/10000;
	}

	public static Double redondearEn3(Double porDesc) {
		return Math.rint(porDesc*1000)/1000;

	}
	public static Double redondearEn1(Double porDesc) {
		return Math.rint(porDesc*10)/10;

	}

	public static boolean validarExpo(String cadena, Long[] valores) {
		char[] nroClave = cadena.toCharArray();
        int checksuma=0;
        
        for(int i=0;i<11;i++){
            checksuma  += Integer.parseInt( String.valueOf( nroClave[i] ))*i;
        }                
        
        for(Long valor : valores){
	        System.out.println("comparo valor: " + valor + "checksuma =" + checksuma);
        	if (checksuma==valor)
	                return true;                	
        }
        return false;	}
	
	public static byte[] getFacturaXML(ClsFEXGetCMPR fac) throws Exception{		
		  	JAXBContext contextObj = JAXBContext.newInstance(ClsFEXGetCMPR.class);
		    Marshaller marshallerObj = contextObj.createMarshaller();
		    marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		    byte [] vector;   
		    ByteArrayOutputStream salida = new ByteArrayOutputStream();
		    marshallerObj.marshal(fac,salida);
		    vector = salida.toByteArray();
		    return vector;		
	}
}

