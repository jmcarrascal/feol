package jmc.feol.core.service.impl.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class TestOpenURL {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		URL yahoo = null;
		try {
			yahoo = new URL("http://localhost:8080/FEOL/facturar?param1=62431&param2=C:_Simpa_bd1.mdb");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		BufferedReader in = null;
		try {in = new BufferedReader(new InputStreamReader(yahoo.openStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}

				}
		

	}

