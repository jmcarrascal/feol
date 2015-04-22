package jmc.feol.core.dao.impl.test;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import jmc.feol.core.model.Parametrizacion;
import jmc.feol.core.model.*;




public class ConvertObjectToXML {
  public static void main(String[] args) throws Exception {
    JAXBContext contextObj = JAXBContext.newInstance(RespuestaAfip.class);

    Marshaller marshallerObj = contextObj.createMarshaller();
    marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

    RespuestaAfipRemitoError rare = new RespuestaAfipRemitoError();
    rare.setCodigo("95");
    rare.setDescripcion("El campo IMPORTE es inválido o inexistente.");
    List<RespuestaAfipRemitoError> listRare = new ArrayList<RespuestaAfipRemitoError>();
    listRare.add(rare);
    
    Errores errores = new Errores();
    errores.setError(listRare);
    
    RespuestaAfipRemito rar = new RespuestaAfipRemito();
    rar.setErrores(errores);
    rar.setNumeroUnico("91 R000100093248");
    rar.setProcesado("NO");
    List<RespuestaAfipRemito> listRar = new ArrayList<RespuestaAfipRemito>();
    listRar.add(rar);
    
    
    ValidacionesRemitos va = new ValidacionesRemitos();
    va.setRemito(listRar);
    
  
    
    RespuestaAfip ra = new RespuestaAfip();
    ra.setCodigoIntegridad("5ba574f61fc304aefec3999d841292d5");
    ra.setCuitEmpresa("30663753025");
    ra.setNombreArchivo("TB_30663753025_001001_20121220_044901.txt");
    ra.setValidacionesRemitos(va);
    ra.setNumeroComprobante("84329999");
    
    
    
    marshallerObj.marshal(ra, new FileOutputStream("c://remito.xml"));  
   

  }
} 