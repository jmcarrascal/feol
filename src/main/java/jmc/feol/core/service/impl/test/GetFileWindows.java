package jmc.feol.core.service.impl.test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;

;

public class GetFileWindows {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String urlToBackUpFile = "smb://ip/backup$/test.txt";
		System.out.println("smb folder of source file" + urlToBackUpFile);
		NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(null,
				"login", "pass");
		SmbFile dir;
		try {
			dir = new SmbFile(urlToBackUpFile, auth);
			System.out.println(dir.getDate());
			SmbFile dest = new SmbFile("C:/SQLRESTORESTAGE/v2.bak");
			dir.copyTo(dest);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SmbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
