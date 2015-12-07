package com.noname.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class TestNGRun {
	static TestNG testng;
	//static Class[] classList = new Class[]{      NewTest.class};
	 
	/*public static void runTestng() {

		try {
			testng = new TestNG();
			testng.setPreserveOrder(true);
			testng.setVerbose(3);
	
			 testng.setTestSuites(Arrays.asList("/Users/amit/Documents/workspacet2/noname/TestNG.xml"));//path to the testng.xml file created
			 //testng.setTestClasses(classList);
			testng.run();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}*/
	public String runTestng() throws IOException, InterruptedException{
			System.out.println("running testng.xml");
			String nav="cd Desktop/jars";
			String testcmd="java -cp \"/Users/amit/Desktop/jars/*\" org.testng.TestNG /Users/amit/Documents/workspacet2/noname/TestNG.xml";
							//nav="cd Documents/workspacet2/noname/WebContent/files/jars";
							//testcmd="java -cp \"/Users/amit/Documents/workspacet2/noname/WebContent/files/jars/*\" org.testng.TestNG /Users/amit/Documents/workspacet2/noname/WebContent/files/jars/TestNG.xml";
							//nav="cd Documents/workspacet2/noname/WebContent/files/jars";
							//testcmd="java -cp \"/Users/amit/Documents/workspacet2/noname/WebContent/files/jars/*\" org.testng.TestNG /Users/amit/Documents/workspacet2/noname/WebContent/files/jars/TestNG.xml";
			Process p1 = Runtime.getRuntime().exec(nav+" && "+testcmd);//"cmd /c start "+
				   // p1.waitFor();
				/*	BufferedReader br1 = new BufferedReader(new InputStreamReader(p1.getInputStream()));
					String str2;
					while((str2=br1.readLine()) !=null){
						System.out.println(str2);
					}
					
					BufferedReader stdError1 = new BufferedReader(new 
						     InputStreamReader(p1.getErrorStream()));
					String str3;
					while((str3=stdError1.readLine()) !=null){
						System.out.println(str3);
					}*/
					return "testng";
			
		
		
	}

}
