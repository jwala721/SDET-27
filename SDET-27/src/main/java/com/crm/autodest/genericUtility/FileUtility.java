package com.crm.autodest.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	
	public String getPropertyKeyValue(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./data/comdata.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;
	}

}
