package jmc.feol.util;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import jmc.feol.core.model.Factura;

import org.xml.sax.helpers.ParserFactory;

import fexv1.dif.afip.gov.ar.ClsFEXRequest;
import fexv1.dif.afip.gov.ar.Cmp_asoc;
import fexv1.dif.afip.gov.ar.Item;
import fexv1.dif.afip.gov.ar.Permiso;


public class ParseFacturaExpo {

	/**
	 * @param args
	 */
	public static ClsFEXRequest parseFacturaE(String rutaArchivo){
		ClsFEXRequest cmp = new ClsFEXRequest();
		BufferedReader entrada = null;
		try {
			entrada = new BufferedReader(new FileReader(rutaArchivo));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String devolver = "";
		
		String[] listaParametros = null;

		List<Item> itemList = new ArrayList<Item>();
		List<Permiso> permisoList = null;
		List<Cmp_asoc> cmpAsocList = null;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		do
        {
            try{
			if((devolver = entrada.readLine()) == null || devolver.length() == 0)
                break;
            //String algo =  devolver.substring(0, 1);
            if(devolver.substring(0, 1).equals("1"))
            {
            	devolver = devolver.substring(1);
            	listaParametros = devolver.split("\\|");
            	int i = 0;
            	while(listaParametros.length > i){
            		
            		switch (i) {
					case 2:
						try{
							cmp.setCbte_Tipo(Short.parseShort(listaParametros[i].trim()));
							break;
						}catch(NumberFormatException e){
							cmp.setErrorParceso(ConstantsFacturaEPK.errorCast("tipo_cbte", "short"));
							return cmp;
						}						
					case 3:
						try{
							cmp.setPunto_vta(Short.parseShort(listaParametros[i].trim()));
							break;
						}catch(NumberFormatException e){
							cmp.setErrorParceso(ConstantsFacturaEPK.errorCast("punto_vta", "short"));
							return cmp;
						}						
					case 4:
						try{
							cmp.setCbte_nro(Long.parseLong(listaParametros[i].trim()));
							break;
						}catch(NumberFormatException e){
							cmp.setErrorParceso(ConstantsFacturaEPK.errorCast("cbte_nro", "long"));
							return cmp;
						}						
					case 5:
						try{
							cmp.setTipo_expo(Short.parseShort(listaParametros[i].trim()));
							break;
						}catch(NumberFormatException e){
							cmp.setErrorParceso(ConstantsFacturaEPK.errorCast("tipo_expo", "short"));
							return cmp;
						}						
					case 6:
						cmp.setPermiso_existente(listaParametros[i].trim());
						break;
					case 7:
						try{
							cmp.setDst_cmp(Short.parseShort(listaParametros[i].trim()));
							break;
						}catch(NumberFormatException e){
							cmp.setErrorParceso(ConstantsFacturaEPK.errorCast("dst_cmp", "short"));
							return cmp;
						}						
					case 8:
						cmp.setCliente(listaParametros[i].trim());
						break;
					case 9:
						if (!listaParametros[i].trim().trim().equals("")){
							try{
								cmp.setCuit_pais_cliente(Long.parseLong(listaParametros[i].trim()));
								break;
							}catch(NumberFormatException e){
								cmp.setErrorParceso(ConstantsFacturaEPK.errorCast("cuit_pais_cliente", "long"));
								return cmp;
							}						
						}
					case 10:
						cmp.setDomicilio_cliente(listaParametros[i].trim());
						break;
					case 11:
						cmp.setId_impositivo(listaParametros[i].trim());
						break;
					case 12:
						cmp.setMoneda_Id(listaParametros[i].trim());
						break;
					case 13:
						if (!listaParametros[i].trim().trim().equals("")){
							try{
								String value_double = listaParametros[i].trim().replaceFirst(",", ".");
								cmp.setMoneda_ctz(new BigDecimal(value_double));
								break;
							}catch(NumberFormatException e){
								cmp.setErrorParceso(ConstantsFacturaEPK.errorCast("moneda_ctz", "double"));
								return cmp;
							}						
						}
					case 14:
						cmp.setObs_comerciales(listaParametros[i].trim());
						break;
					case 15:
						if (!listaParametros[i].trim().trim().equals("")){
							try{
								String value_double = listaParametros[i].trim().replaceFirst(",", ".");
								cmp.setImp_total(new BigDecimal(value_double));
								break;
							}catch(NumberFormatException e){
								cmp.setErrorParceso(ConstantsFacturaEPK.errorCast("imp_total", "double"));
								return cmp;
							}						
						}
					case 16:
						cmp.setObs(listaParametros[i].trim());
						break;
					case 17:
						cmp.setForma_pago(listaParametros[i].trim());
						break;
					case 18:
						cmp.setIncoterms(listaParametros[i].trim());
						break;
					case 19:
						cmp.setIncoterms_Ds(listaParametros[i].trim());
						break;
					case 20:
						try{
							cmp.setIdioma_cbte(Short.parseShort(listaParametros[i].trim()));
							break;
						}catch(NumberFormatException e){
							cmp.setErrorParceso(ConstantsFacturaEPK.errorCast("idioma_cbte", "short"));
							return cmp;
						}						
						
            		}  
            		i++;
            	}            	
            	
            }
            if(devolver.substring(0, 1).equals("2"))
            {
            	Permiso permiso = new Permiso();
            	devolver = devolver.substring(1);
            	listaParametros = devolver.split("\\|");
            	int i = 0;
            	while(listaParametros.length > i){
            		
            		switch (i) {
					case 1:
						permiso.setId_permiso(listaParametros[i]);
						break;
					case 2:
						if (!listaParametros[i].trim().trim().equals("")){
							try{
								int value_integer = Integer.parseInt(listaParametros[i].trim());
								permiso.setDst_merc(value_integer);
								break;
							}catch(NumberFormatException e){
								cmp.setErrorParceso(ConstantsFacturaEPK.errorCast("dst_merc", "integer"));
								return cmp;
							}						
						}
					}  
            		i++;
            	}
            	permisoList = new ArrayList<Permiso>();
            	permisoList.add(permiso);            	            	                
            }
            if(devolver.substring(0, 1).equals("3"))
            {
               	devolver = devolver.substring(1);
            	listaParametros = devolver.split("\\|");
            	int i = 0;
            	Cmp_asoc cmpAsoc = new Cmp_asoc();
            	while(listaParametros.length > i){
            		
            		switch (i) {
					case 1:
						if (!listaParametros[i].trim().equals("")){
							try{								
								cmpAsoc.setCbte_tipo(Short.parseShort(listaParametros[i]));
								break;
							}catch(NumberFormatException e){
								cmp.setErrorParceso(ConstantsFacturaEPK.errorCast("cbte_tipo", "short"));
								return cmp;
							}						
						}
					case 2:
						if (!listaParametros[i].trim().equals("")){
							try{								
								cmpAsoc.setCbte_punto_vta(Short.parseShort(listaParametros[i]));
								break;
							}catch(NumberFormatException e){
								cmp.setErrorParceso(ConstantsFacturaEPK.errorCast("cbte_punto_vta", "short"));
								return cmp;
							}						
						}
					case 3:
						if (!listaParametros[i].trim().trim().equals("")){
							try{
								cmpAsoc.setCbte_nro(Long.parseLong(listaParametros[i].trim()));
								break;
							}catch(NumberFormatException e){
								cmp.setErrorParceso(ConstantsFacturaEPK.errorCast("cbte_nro", "long"));
								return cmp;
							}						
						}
            		}
            		i++;
            	}
            	cmpAsocList = new ArrayList<Cmp_asoc>();
            	cmpAsocList.add(cmpAsoc);
            }
            if(devolver.substring(0, 1).equals("4"))
            {
               	devolver = devolver.substring(1);
            	listaParametros = devolver.split("\\|");
            	int i = 0;
            	Item item = new Item();
            	while(listaParametros.length > i){
            		
            		switch (i) {
					case 1:
						item.setPro_codigo(listaParametros[i]);
						break;
					case 2:
						item.setPro_ds(listaParametros[i]);
						break;
					case 3:
						if (!listaParametros[i].trim().trim().equals("")){
							try{
								String value_double = listaParametros[i].trim().replaceFirst(",", ".");
								item.setPro_qty(new BigDecimal(value_double));
								break;
							}catch(NumberFormatException e){
								cmp.setErrorParceso(ConstantsFacturaEPK.errorCast("Pro_qty", "double"));
								return cmp;
							}						
						}
					case 4:
						if (!listaParametros[i].trim().equals("")){
							try{
								int value_integer = Integer.parseInt(listaParametros[i].trim());
								item.setPro_umed(value_integer);
								break;
							}catch(NumberFormatException e){
								cmp.setErrorParceso(ConstantsFacturaEPK.errorCast("pro_umed", "integer"));
								return cmp;
							}						
						}
					case 5:
						if (!listaParametros[i].trim().trim().equals("")){
							try{
								String value_double = listaParametros[i].trim().replaceFirst(",", ".");
								item.setPro_precio_uni(new BigDecimal(value_double));
								break;
							}catch(NumberFormatException e){
								cmp.setErrorParceso(ConstantsFacturaEPK.errorCast("Pro_precio_uni", "double"));
								return cmp;
							}						
						}
					case 6:
						if (!listaParametros[i].trim().trim().equals("")){
							try{
								String value_double = listaParametros[i].trim().replaceFirst(",", ".");
								item.setPro_total_item(new BigDecimal(value_double));
								break;
							}catch(NumberFormatException e){
								cmp.setErrorParceso(ConstantsFacturaEPK.errorCast("Pro_total_item", "double"));
								return cmp;
							}						
						}						
					case 7:
						if (!listaParametros[i].trim().trim().equals("")){
							try{
								String value_double = listaParametros[i].trim().replaceFirst(",", ".");
								item.setPro_bonificacion(new BigDecimal(value_double));
								break;
							}catch(NumberFormatException e){
								cmp.setErrorParceso(ConstantsFacturaEPK.errorCast("Pro_bonificacion", "BigDecimal"));
								return cmp;
							}						
						}						
            		}
            		i++;
            	}
            	itemList.add(item);            	
            }
            
            }catch(IOException e){
            	e.printStackTrace();
            }
            
        
        }while(true);
		if (permisoList != null)
		cmp.setPermisos(listPermisoToArray(permisoList));
		if (cmpAsocList != null)
		cmp.setCmps_asoc(listCmp_asocToArray(cmpAsocList));
		cmp.setItems(listItemToArray(itemList));
		return cmp;
	
	}

	private static Permiso[] listPermisoToArray(List<Permiso> listPermiso){
		Permiso[] permisoArray = new Permiso[listPermiso.size()];
		int i = 0;
		for(Permiso permiso:listPermiso){
			permisoArray[i] = permiso;
			i++;
		}
		return permisoArray;
	}
	
	private static Item[] listItemToArray(List<Item> listItem){
		Item[] itemArray = new Item[listItem.size()];
		int i = 0;
		for(Item item:listItem){
			itemArray[i] = item;
			i++;
		}
		return itemArray;
	}
	
	private static Cmp_asoc[] listCmp_asocToArray(List<Cmp_asoc> listCmp_asoc){
		Cmp_asoc[] cmp_asocArray = new Cmp_asoc[listCmp_asoc.size()];
		int i = 0;
		for(Cmp_asoc cmp_asoc:listCmp_asoc){
			cmp_asocArray[i] = cmp_asoc;
			i++;
		}
		return cmp_asocArray;
	}
//	public static String getOutDataFactura(Factura factura){
//		String result ="";		
//		result = result + FileUtil.sinNull("1");
//		result = result + FileUtil.sinNull(FileUtil.llenoConCeros(String.valueOf(factura.getTipo_cbte()), 2));
//		result = result + FileUtil.sinNull(FileUtil.llenoConCeros(String.valueOf(factura.getPunto_vta()), 4));
//		result = result + FileUtil.sinNull(FileUtil.llenoConCeros(String.valueOf(factura.getCbt_desde()), 8));
//		result = result + FileUtil.sinNull(FileUtil.llenoConEspacios(String.valueOf(factura.getCae()), 14));
//		result = result + FileUtil.sinNull(FileUtil.llenoConEspacios(String.valueOf(factura.getAdjunto()), 8));
//		result = result + FileUtil.sinNull(FileUtil.llenoConEspacios(String.valueOf(factura.getCodError()), 10));
//		result = result + FileUtil.sinNull(FileUtil.llenoConEspacios(FileUtil.recortoValor(String.valueOf(factura.getErrorCAE()), 100),100));
//		result = result + FileUtil.sinNull(FileUtil.llenoConEspacios(FileUtil.recortoValor(String.valueOf(factura.getErrorCAE()), 100),100));
//		result = result + FileUtil.sinNull(FileUtil.llenoConEspacios(String.valueOf(factura.getReproceso()), 1));		
//		return result;
//	}
	public static String getOutDataFactura(Factura factura){
		String result ="";
		result = result + FileUtil.sinNull("1");
		result = result + FileUtil.sinNull(FileUtil.llenoConCeros(String.valueOf(factura.getTipo_cbte()), 2));
		result = result + FileUtil.sinNull(FileUtil.llenoConCeros(String.valueOf(factura.getPunto_vta()), 4));
		result = result + FileUtil.sinNull(FileUtil.llenoConCeros(String.valueOf(factura.getCbt_desde()), 8));
		result = result + FileUtil.sinNull(FileUtil.llenoConEspacios(String.valueOf(factura.getCae()), 14));
		result = result + FileUtil.sinNull(FileUtil.llenoConEspacios(String.valueOf(factura.getCae_vto()), 8));
		result = result + FileUtil.sinNull(FileUtil.llenoConEspacios(String.valueOf(factura.getCodError()), 10));
		result = result + FileUtil.sinNull(FileUtil.llenoConEspacios(FileUtil.recortoValor(String.valueOf(factura.getErrorCAE()), 100),100));
		result = result + FileUtil.sinNull(FileUtil.llenoConEspacios(FileUtil.recortoValor(String.valueOf(""), 100),100));
		result = result + FileUtil.sinNull(FileUtil.llenoConEspacios(String.valueOf(factura.getReproceso()), 1));	
		System.out.println("Mensaje salida: " + result);
		return result;
	}

	private static String parseOutDataFactura(String data, String result){
		if (data == null || data.equals("null"))
			data = "";
		result = result + data + "|";
		return result;
	}
	
	private static String parseOutDataFacturaEspacio(String data, String result){
		if (data == null || data.equals("null"))
			data = "";
		result = result + data;
		return result;
	}

}
