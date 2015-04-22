package jmc.feol.core.service.impl.test;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.IndexColorModel;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.ImageIcon;

import jmc.feol.util.FileUtil;


public class TestAddTextInImagev1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			//Tomo imagen y la convierto en byte[]
		      File file = new File("C:/SGI/archivos/huellas/h_135.jpg");
		        System.out.println(file.exists() + "!!");
		 
		        FileInputStream fis = new FileInputStream(file);
		        //create FileInputStream which obtains input bytes from a file in a file system
		        //FileInputStream is meant for reading streams of raw bytes such as image data. For reading streams of characters, consider using FileReader.
		 
		        //InputStream in = resource.openStream();
		        ByteArrayOutputStream bos = new ByteArrayOutputStream();
		        byte[] buf = new byte[1024];
		        try {
		            for (int readNum; (readNum = fis.read(buf)) != -1;) {
		                bos.write(buf, 0, readNum); 
		                //no doubt here is 0
		                /*Writes len bytes from the specified byte array starting at offset 
		                off to this byte array output stream.*/
		                System.out.println("read " + readNum + " bytes,");
		            }
		        } catch (IOException ex) {
		            //Logger.getLogger(ConvertImage.class.getName()).log(Level.SEVERE, null, ex);
		        }
		        byte[] bytes = bos.toByteArray();
		        //bytes is the ByteArray we need
		 
		 
		        /*
		         * The second part shows how to convert byte array back to an image file  
		         */
		 
		 
		        //Before is how to change ByteArray back to Image
		        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
		        Iterator<?> readers = ImageIO.getImageReadersByFormatName("jpg");
		        //ImageIO is a class containing static convenience methods for locating ImageReaders
		        //and ImageWriters, and performing simple encoding and decoding. 
		 
		        ImageReader reader = (ImageReader) readers.next();
		        Object source = bis; // File or InputStream, it seems file is OK
		 
		        ImageInputStream iis = ImageIO.createImageInputStream(source);
		        //Returns an ImageInputStream that will take its input from the given Object
		 
		        reader.setInput(iis, true);
		        ImageReadParam param = reader.getDefaultReadParam();
		 
		        Image reference = reader.read(0, param);

			
			//Tomo Tamaño de la imagen
			int widthImg = reference.getWidth(null);
			int heightImg = reference.getHeight(null);

			//IndexColorModel i = new IndexColorModel(); 
			//Creo imagen del mismo tamaño
			BufferedImage bimg = new BufferedImage(widthImg, heightImg,BufferedImage.TYPE_BYTE_BINARY);

			//Convierto imagen nueva en obbjeto Graphics2D	 
			Graphics2D gr = (Graphics2D)bimg.getGraphics();
			
			//gr.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			
			//pinto el fondo blanco
			//gr.setColor(Color.white);
			
			//Seteo Ubicacion
			gr.fillRect(0, 0, 1, 1);
			
			//coloco la imagen original
			gr.drawImage(reference,0,0,null);
			
			//Seteo el color del String a Escribir			
			gr.setPaint(Color.BLACK);
			
			//Seteo el tipo de letra
			Font font = new Font("arial", 1, 42);
			
			gr.setFont(font);
			
			gr.drawString("Estado Actual", 50, heightImg-14);

			//FuinalizaciÃ³n
			ByteArrayOutputStream bas =	new ByteArrayOutputStream();
			ImageIO.write(bimg, "jpeg", bas);
			byte[] data = null;
			data = bas.toByteArray();
			System.out.println("Tamaño imagen final " + data.length);
			try {
				FileUtil.writeFile(data, "c://huellas_tocada1.jpg");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	/**
	 * Agrega el Id de solicitud a la Imagen
	 * 
	 * @param Texto a Agregar
	 * @param data
	 * @return
	 */
	public static void addTextInImage(String text, String archivoOrig, String archivoTemp) {
		
		try {
			//Tomo imagen y la convierto en byte[]
			byte[] data = FileUtil.getBytesFromFile(new File(archivoOrig));
			
			//System.out.println("Tamaño imagen original " + data.length);
			
			//Objeto Image  
			Image reference = new ImageIcon(data).getImage();
			
			//Tomo Tamaño de la imagen
			int widthImg = reference.getWidth(null);
			int heightImg = reference.getHeight(null);

			//Creo imagen del mismo tamaño
			BufferedImage bimg = new BufferedImage(widthImg, heightImg,BufferedImage.TYPE_INT_RGB);

			//Convierto imagen nueva en obbjeto Graphics2D 
			Graphics2D gr = (Graphics2D)bimg.getGraphics();
			gr.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			
			//pinto el fondo blanco
			gr.setColor(Color.white);
			
			//Seteo Ubicacion
			gr.fillRect(0, 0, 1, 1);
			
			//coloco la imagen original
			gr.drawImage(new ImageIcon(data).getImage(),0,0,null);
			
			//Seteo el color del String a Escribir			
			gr.setPaint(Color.GRAY);
			
			//Seteo el tipo de letra
			Font font = new Font("arial", 1, 42);
			
			gr.setFont(font);
			
			gr.drawString(text, 50, heightImg-14);

			//Finalizo
			ByteArrayOutputStream bas =	new ByteArrayOutputStream();
			ImageIO.write(bimg, "jpg", bas);
			data = bas.toByteArray();
			
			try {
				FileUtil.writeFile(data, archivoTemp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		} catch (IOException e) {			
			e.printStackTrace();
		
			
		}
		

	}

}
