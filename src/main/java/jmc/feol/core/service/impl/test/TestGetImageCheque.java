package jmc.feol.core.service.impl.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jmc.feol.core.dao.impl.BaseExternaTeso;
import jmc.feol.util.Constants;
import jmc.feol.util.DateUtil;
import jmc.feol.util.FileUtil;
import jmc.feol.util.FormatUtil;

public class TestGetImageCheque {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Obtener PC que tengo que ir a buscar archivos
		//Hago un loop para obtener imagen de cada PC
			//Listo Directorios
			File carpeta = new File("//localhost//Cheques//");			
			
			String carpetaFechasUltima = "";
			if (carpeta.exists()){
				System.out.println("OK");
				//Listo las carpetas
				File[] carpetas = carpeta.listFiles();
				List<File> listCarpetas = filterCarpetas(carpetas, "20110901");
				for(File carpetaFechas : listCarpetas){
					if(carpetaFechas.getName().indexOf("read") == -1){
						if(carpetaFechas.isDirectory()){
							carpetaFechasUltima = carpetaFechas.getName();
							File[] imagenes = carpetaFechas.listFiles();
							for(File imagen:imagenes){
								//Obtengo la Imagen
								//System.out.println(imagen.getName());
								if (FileUtil.parseExtension(imagen.getName()).equalsIgnoreCase("tif")){										
									//Convierto la Imagen
								
								}									
							}
							
							
						}
						
					}
					System.out.println("Fecha a Actualizar " + carpetaFechasUltima); 
				}
			}						


	}

	private static List<File> filterCarpetas(File[] listadoCarpeta, String fecha){
		List<File> listFolders = new ArrayList<File>();
		Long fechaEquipo = 0l;
		Long fechaHoy = 0l;
		try{
			fechaEquipo = Long.parseLong(fecha);
			fechaHoy = Long.parseLong(DateUtil.getCanonicalFech(new Date(System.currentTimeMillis())));
		}catch(NumberFormatException ne){
			ne.printStackTrace();
			return listFolders;
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(File carpeta : listadoCarpeta){
			Long fechaCarpeta = 0l; 
			try{
				fechaCarpeta = Long.parseLong(carpeta.getName());
				if(fechaCarpeta > fechaEquipo && fechaCarpeta < fechaHoy){
					listFolders.add(carpeta);
				}
			}catch(NumberFormatException ne){
				ne.printStackTrace();				
			}

		}
		
		
		return listFolders;
	}

}
