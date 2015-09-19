package jmc.feol.core.service.impl.test;

import java.io.File;

import jmc.feol.util.FileUtil;

public class TestGetNameFile {
	
	
	public static void main(String[] args) throws Exception {
		File file = new File("/Users/juanmanuelcarrascal/Downloads/B035306557.txt");
		String planta = file.getName().substring(1, 4);
		String secuencia = file.getName().substring(4, 10);
		System.out.println(planta);
		System.out.println(secuencia);
	}

}
