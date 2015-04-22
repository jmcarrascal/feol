package jmc.feol.core.service.impl.test;

import java.io.IOException;

import jmc.feol.util.FileUtil;
import jmc.feol.util.FormatUtil;

public class TestUnionImages {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			byte[] imagen = FormatUtil.convertJPG("c://cheques/test1.tif", 0);
			FileUtil.writeFile(imagen, "c://cheques/test1.jpg");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
