package com.noname.controller;

import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
public class NewTest {

	public WebDriver driver;
	@Parameters({"browser"})
	@BeforeTest
	public void setup(String browser) throws MalformedURLException {
		Logger.getLogger("into before test");
		DesiredCapabilities capability=null;
		if(browser.equalsIgnoreCase("firefox")){
			System.out.println("firefox");
			capability= DesiredCapabilities.firefox();
			capability.setBrowserName("firefox");
			capability.setPlatform(org.openqa.selenium.Platform.ANY);
			//capability.setVersion("");
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
			driver.navigate().to("http://openweathermap.org/");
		}
		/*if(browser.equalsIgnoreCase("chrome")){
			System.out.println("chrome");
			capability= DesiredCapabilities.chrome();
			capability.setBrowserName("chrome");
			capability.setPlatform(org.openqa.selenium.Platform.MAC);
			//capability.setVersion("");
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
			driver.navigate().to("http://openweathermap.org/");
		}*/
		if(browser.equalsIgnoreCase("chrome")){
			System.out.println("chrome");
			capability= DesiredCapabilities.chrome();
			capability.setBrowserName("chrome");
			capability.setPlatform(org.openqa.selenium.Platform.MAC);
			//capability.setVersion("");
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
			driver.navigate().to("http://openweathermap.org/");
		}

		
		//driver.navigate().to("http://google.com");
	}
	@Test
	public void test_first() throws InterruptedException{
		Thread.sleep(1000);
		WebElement city=driver.findElement(By.cssSelector("input.form-control:nth-child(2)"));
		city.clear();
		city.sendKeys("san francisco usa");
		driver.findElement(By.cssSelector("button.btn-orange")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".table > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > b:nth-child(1) > a:nth-child(1)")).click();
		Thread.sleep(10000);
}


	@AfterTest
	public void tearDown(){
		driver.quit();
	}
}

