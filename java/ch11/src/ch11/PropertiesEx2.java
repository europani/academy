package ch11;

import java.io.*;
import java.util.Properties;

public class PropertiesEx2 {
	public static void main(String[] args) throws IOException {
		Properties pr = new Properties();
		
		pr.setProperty("timeout", "30");
		pr.setProperty("language", "ÇÑ±Û");
		pr.setProperty("size", "10");
		pr.setProperty("capacity", "10");
		
		pr.store(new FileOutputStream("src/ch11/output.txt"), "abc");
		pr.storeToXML(new FileOutputStream("src/ch11/output.xml"), "abc");
		
		
	}
}
