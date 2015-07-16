package jmc.feol.core.dao.impl.test;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import jmc.feol.core.model.RespuestaAfip;
import jmc.feol.util.SerializateUtil;

public class TestGenerarPDF {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        
		File file = new File("C:\\viaje.xml");
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(RespuestaAfip.class);
		
 
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		RespuestaAfip ra = (RespuestaAfip) jaxbUnmarshaller.unmarshal(file);
		SerializateUtil.generateRemitoPdf(ra, "c:\\viaje1.pdf");
		
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


	}

}
