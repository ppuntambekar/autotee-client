package com.noname.controller;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

class xmlData{
	private String name;
	private String browser;
	private String file;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrowser() {
		return browser;
	}
	public void setBrowser(String browser) {
		this.browser = browser;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	
}
@WebServlet("/generate")
public class GenerateXml extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("into http do post");
			StringBuffer sb = new StringBuffer();
			try 
		    {
		      BufferedReader reader = request.getReader();
		      String text = null;
		      while ((text = reader.readLine()) != null)
		      {
		        sb.append(text);
		      }
		    } catch (Exception e) { e.printStackTrace(); }
		 
		      Gson gson = new Gson();
		      DataObject obj = gson.fromJson(sb.toString(), DataObject.class);
		      System.out.println("Browser is :"+obj.getBrowser());
		      CreateXml createXml = new CreateXml();
		      createXml.createfile(obj.getBrowser(), obj.getName(), obj.getFile().getBytes());
			  hubnodesetup hns = new hubnodesetup();
			  try {
				hns.hubsetup();
				Thread.sleep(5000);
				hns.nodesetup("localhost");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  try {
				Thread.sleep(10000);
				 TestNGRun tgn = new TestNGRun();
				  tgn.runTestng();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			super.doPost(request, response);
		}
	
}
