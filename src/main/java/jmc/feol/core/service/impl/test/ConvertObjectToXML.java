package jmc.feol.core.service.impl.test;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import jmc.feol.core.model.Parametrizacion;



public class ConvertObjectToXML {
  public static void main(String[] args) throws Exception {
    JAXBContext contextObj = JAXBContext.newInstance(Parametrizacion.class);

    Marshaller marshallerObj = contextObj.createMarshaller();
    marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

       
    List<String> mailsTo = new ArrayList<String>(); 
    mailsTo.add("jmcarrasca@gmail.com");
    mailsTo.add("jmcarrasca@hotmail.com");

    List<String> fromFolder = new ArrayList<String>(); 
    fromFolder.add("c://folder1//");

    List<String> mailsProperties = new ArrayList<String>(); 
    mailsProperties.add("mail.user=jmcarrascal@gmail.com");
    mailsProperties.add("mail.pass=jmc");
    mailsProperties.add("mail.smtp=jmc");

    Parametrizacion param = new Parametrizacion();
    byte [] vector; 
    marshallerObj.marshal(param, new FileOutputStream("c://param.xml"));  
    ByteArrayOutputStream salida = new ByteArrayOutputStream();
    marshallerObj.marshal(param,salida);
    vector = salida.toByteArray();
    System.out.println("alf");
  }
} 