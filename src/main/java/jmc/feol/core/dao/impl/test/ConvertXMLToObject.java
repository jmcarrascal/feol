package jmc.feol.core.dao.impl.test;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import jmc.feol.core.model.*;



	public class ConvertXMLToObject {

	    public static void main (String [] args) {
	        try {
	        	File file = new File("C:\\viaje.xml");
	    		JAXBContext jaxbContext = JAXBContext.newInstance(RespuestaAfip.class);
	     
	    		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	    		RespuestaAfip param = (RespuestaAfip) jaxbUnmarshaller.unmarshal(file);
	    		System.out.println(param);
	    		
	       } catch (JAXBException e) {
	           e.printStackTrace ();
	       }
	   }
	}
	 
