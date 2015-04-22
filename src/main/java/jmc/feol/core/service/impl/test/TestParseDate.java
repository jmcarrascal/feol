package jmc.feol.core.service.impl.test;

import java.sql.Timestamp;

import jmc.feol.util.DateUtil;

public class TestParseDate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Timestamp ts = DateUtil.composeCanonicalFech(null);
		System.out.println(ts);

	}

}
