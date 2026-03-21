package com.pcc.sys.lib;

import java.io.InputStreamReader;
import java.util.Properties;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FConfig {

	public static String getAppName() {
		//String s1 = getConfig1("app_name");
		String s2 = getConfig2("svnver");
		String s3 = getConfig2("update");
		//return s1 + " (svn: " + s2 + " , update: " + s3 + ")";
		return "(svn: " + s2 + " , update: " + s3 + ")";
	}

	public static String getConfig2(String key) {

		Properties props = new Properties();

		try {

			try (InputStreamReader in1 = new InputStreamReader(
					FConfig.class.getResourceAsStream("/config2.txt"), "UTF-8");) {

				props.load(in1);
				String value = props.getProperty(key);
				if (value == null) {
					return "";
				} else {
					return value.trim();
				}
			}

		} catch (Exception e) {
			return "";
		}

	}

	public static boolean getConfig2_VisibletxtOpenMenu() {
		String s = getConfig2("txtOpenMenu");
		if (s.trim().toUpperCase().equals("YES")) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean getConfig2_Report_In_Iframe() {
		String s = getConfig2("Report_In_Iframe");
		if (s.trim().toUpperCase().equals("YES")) {
			return true;
		} else {
			return false;
		}
	}
}
