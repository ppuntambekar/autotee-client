package com.noname.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.testng.TestNG;

public class CreateXml {				//"/noname/WebContent/files/javaUpload/" + UUID.randomUUID().toString() + ".java";
	private static String file_location = "/Users/amit/Documents/workspacet2/noname/WebContent/files/jars/" + UUID.randomUUID().toString() + ".java"; //"C://Users/Meher/Desktop/files/" + UUID.randomUUID().toString() + ".java";
	public void createfile(String browser, String suit, byte[] fileString) {

		upload(fileString);
		
		File file = new File("/Users/amit/Documents/workspacet2/noname/WebContent/files/jars/TestNG.xml");
		try {				
			FileOutputStream fos = new FileOutputStream(file);
			PrintStream ps = new PrintStream(fos);
			// ObjectOutputStream os=new ObjectOutputStream(fos);
			ps.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			ps.println("<suite name=\"" + suit + "\" verbose=\"3\"  parallel=\"tests\" thread-count=\"4\">");
			ps.println("<test name=\"Running on " + browser + "\">");
			ps.println("<parameter name=\"browser\"  value=\"" + browser + "\"/>");
			ps.println("<classes>");
			ps.println("<class name=\"testsng.NewTest\"/>");
			ps.println("</classes>");
			ps.println("</test>");
			ps.println("</suite>");
          
		} catch (IOException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}
	
		  
	}
	public void upload(byte[] fileString) {
		Logger.getAnonymousLogger().log(Level.INFO, "into method upload", "");

		try {
			File file = new File(file_location);
			FileOutputStream fout = new FileOutputStream(file);
			fout.write(fileString);
			fout.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // This will copy the file to the specific location.

	}
	
		
public void testclasscopy(){
			
			String fileName = "/Users/amit/Desktop/files/NewTest.class"; ///Users/amit/Documents/workspacet2/noname/build/classes/com/noname/controller/NewTest.class
			File f=new File(fileName);
            byte[] buffer = new byte[(int) f.length()];
	        try {
	            FileInputStream inputStream = new FileInputStream(fileName);
	            inputStream.read(buffer);
	            inputStream.close();        
	            String classpath="/Users/amit/Documents/workspacet2/noname/WebContent/files/jars/NewTest.class";
				File classfile = new File(classpath);
				FileOutputStream fout = new FileOutputStream(classfile);
				fout.write(buffer);
				fout.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // This will copy the file to the specific location.

		}


}
