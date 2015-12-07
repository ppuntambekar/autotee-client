package com.noname.controller;

public class DataObject {
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


	@Override
	public String toString() {
		return "DataObject [name=" + name + ", browser=" + browser + ", file=" + file + "]";
	}
	
	
}
