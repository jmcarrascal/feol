package jmc.feol.core.service.impl.test;

import java.io.File;

import jmc.feol.util.FileUtil;

public class TestCopyFile {
	
	
	public static void main(String[] args) throws Exception {
		FileUtil.copy(new File("/Users/juanmanuelcarrascal/Downloads/B035306557.txt.jtrecu"), new File("/Users/juanmanuelcarrascal/Downloads/B035306557.txt"));
	}

}
