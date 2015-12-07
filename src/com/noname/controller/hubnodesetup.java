package com.noname.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.logging.Logger;

import org.testng.TestNG;

public class hubnodesetup {
    
	static TestNG testng;
   
	public String hubsetup() throws IOException, InterruptedException{
		System.out.println("starting grid");
		Process p = Runtime.getRuntime().exec("java -jar /Users/amit/Documents/seleniumgrid/selenium-server-standalone-2.48.2.jar -role hub ");
		//cmd /c start //"java -jar /noname/WebContent/files/jars/selenium-server-standalone-2.48.2.jar -role hub"
	   // p.waitFor();
	/*	BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String str;
		while((str=br.readLine()) !=null){
			System.out.println(str);
		}
		
		BufferedReader stdError = new BufferedReader(new 
			     InputStreamReader(p.getErrorStream()));
		String str1;
		while((str1=stdError.readLine()) !=null){
			System.out.println(str1);
		}*/
		return "hub";
	   
	}
	public String nodesetup(String pnum) throws IOException, InterruptedException{
		System.out.println("starting node ......");
		String portnum=pnum;//"localhost";
		String domainName1 = "http://"+portnum+":4444/grid/register -port 5570";
		String chromedriver="/Applications/Google\\ Chrome.app/Contents/MacOS/chromedriver";
		String nodecmd="java -jar /Users/amit/Documents/seleniumgrid/selenium-server-standalone-2.48.2.jar -role webdriver -hub "+domainName1+" -browser browserName=chrome,maxInstances=4 -Dwebdriver.chrome.driver="+chromedriver+" -browser browserName=firefox,maxInstances=4";
						//"java -jar /noname/WebContent/files/jars/selenium-server-standalone-2.48.2.jar -role webdriver -hub "+domainName1+" -browser browserName=chrome,maxInstances=4 -Dwebdriver.chrome.driver="+chromedriver+" -browser browserName=firefox,maxInstances=4";
		Process p1 = Runtime.getRuntime().exec(nodecmd);//"cmd /c start "+
				
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
				return "nodesetup";
		
	} 


	
	

	
	
	/*public static void main(String[] args) throws IOException, InterruptedException{
		System.out.println("hub node setup");
		hubnodesetup hns = new hubnodesetup();
		hns.hubsetup();
		Thread.sleep(5000);
		hns.nodesetup();
	}*/

	

}
