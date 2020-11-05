package com.FaceBook.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLink {
	
		@Test
		public void brokenLinkTest() throws Throwable {
			WebDriverManager.chromedriver().setup();

			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://www.facebook.com");

			List<WebElement> link = driver.findElements(By.tagName("a"));

			for(WebElement ele:link) {
				String add = ele.getAttribute("href");
				//System.out.println(add);


				HttpURLConnection http=(HttpURLConnection)new URL(add).openConnection();
				http.connect();
				int statusCode = http.getResponseCode();
				if(statusCode>=400) {
					System.out.println("connection broken "+add+"==>"+statusCode);
				}else
				{
					System.out.println("valid link "+ add+"==>"+statusCode);
				}
			}
		}
	}
