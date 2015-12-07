package com.noname.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

	@WebServlet("/startGrid")
	public class nodeRegister extends HttpServlet{

		private static final long serialVersionUID = 1L;

		public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			StringBuffer sb = new StringBuffer();
			String ipadd=(String) request.getAttribute("ipaddress");
			
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
		      hubnodesetup hns = new hubnodesetup();
			  try {
				hns.nodesetup(ipadd);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
				
				response.setContentType("text/html");
				PrintWriter out=response.getWriter();
				out.write("hub machine ipaddress");
				out.flush();
				out.close();
				
			  
			
			}
		
	

}
