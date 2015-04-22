/*
 * Manejador.java
 *
 * Created on 31 de octubre de 2006, 13:49
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package jmc.feol.util;
import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.helpers.DefaultHandler;


/**
 *
 * @author andres
 */
public class Manejador extends DefaultHandler {
       private Locator loc;
        public boolean sin_error;
        public String nombreArchivo;
        public String ErrDescription= new String("");
        public String nro_comprobante=null;
        public String [][]remitos=new String[10][2];
        private int cuenta=0;
        public int remito=0;
        
        
        // my boolean army....
        private boolean bool_num_compro;
        private boolean bool_nom_archivo;
        private boolean bool_remito;
        private boolean bool_procesado;
        private boolean bool_error_desc;
        

        public void setDocumentLocator(Locator l) {
          loc = l;
        }

        public void startDocument() {
            sin_error = true;
            bool_nom_archivo=false;
            bool_num_compro=false;
            bool_remito=false;
            bool_error_desc=false;
            bool_procesado=false;
        }

        public void endDocument() {

        }

        public void processingInstruction(String destino, String datos) {
        }

        public void startPrefixMapping(String prefijo, String uri) {
        }

        public void endPrefixMapping(String prefijo) {
        }

        public void startElement(String espacio, String nomLocal,
                                 String nomCompleto, Attributes atrs) {
              if (nomLocal.equals("nombreArchivo"))
                      bool_nom_archivo = true;
              if (nomLocal.equals("numeroComprobante"))
                      bool_num_compro = true;
              if (nomLocal.equals("numeroUnico"))
                      bool_remito = true;
              if (nomLocal.equals("procesado"))
                      bool_procesado=true;
              if ((nomLocal.equals("TBError"))||(nomLocal.equals("error")))
                  sin_error=false;
              if ( (nomLocal.equals("mensajeError")) || (nomLocal.equals("codigo")) || (nomLocal.equals("descripcion")) )
                  bool_error_desc=true;
            }
        public void endElement(String espacio, String nomLocal, 
                               String nomCompleto) {
              if (nomLocal.equals("nombreArchivo"))
                    bool_nom_archivo = false;
              if (nomLocal.equals("numeroComprobante"))
                       bool_num_compro = false;
              if (nomLocal.equals("numeroUnico"))
                      bool_remito = false;
              if (nomLocal.equals("procesado"))
                      bool_procesado = false;
              if ( (nomLocal.equals("mensajeError")) || (nomLocal.equals("codigo")) || (nomLocal.equals("descripcion")) )
                  bool_error_desc=false;              
            }

        public void characters(char[] ch, int comienzo, int fin) {
          String s = new String(ch, comienzo, fin);
              if (bool_nom_archivo)
                    nombreArchivo=s;
              if(bool_num_compro){
                    nro_comprobante=s;
              }
              if(bool_remito){                    
                    remitos[remito][0]=s;            
                    remito++;
              }
              if (bool_procesado){
                    remitos[remito-1][1]=s;
                    if (s.equals("NO")){
                        sin_error=false;
                        if (ErrDescription.equals(""))
                            ErrDescription="Error en remito "+ remitos[remito-1][0] + " codigo:";
                        else
                            ErrDescription=ErrDescription + "\n" + "Error en remito "+ remitos[remito-1][0] + " codigo:";
                    }
               }
               if (bool_error_desc)
                   if (ErrDescription.equals(""))
                       ErrDescription=s;
                   else
                       ErrDescription= ErrDescription +" "+ s;
              }
 }