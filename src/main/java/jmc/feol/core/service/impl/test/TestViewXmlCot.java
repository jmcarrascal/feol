package jmc.feol.core.service.impl.test;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import jmc.feol.core.model.RespuestaAfip;
import jmc.feol.core.model.RespuestaAfipRemito;

public class TestViewXmlCot {

	public static void main(String[] args) {
		File file = new File("/tmp/viaje.xml");
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(RespuestaAfip.class);
		
 
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		
		
		RespuestaAfip ra = (RespuestaAfip) jaxbUnmarshaller.unmarshal(new File("/tmp/viaje.xml"));
		for(RespuestaAfipRemito rr: ra.getValidacionesRemitos().getRemito()){
			System.out.println(rr.getProcesado());
			
		}
		
		//SerializateUtil.generateRemitoPdf(ra, "c:\\viaje1.pdf");
		
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
