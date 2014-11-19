package com.example.fw;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.opera.core.systems.OperaDriver;

public class ApplicationManager {

	public  WebDriver driver;
	public  String baseUrl;
	

	private NavigationHelper navigationHelper;
	private GroupHelper  groupHelper;
	private ContactsHelper  contactsHelper;
	
	protected String returnBaseURL(){
	   return this.baseUrl;
	}
 
	public ContactsHelper getContactsHelper(){
		if (contactsHelper == null) {
			contactsHelper = new ContactsHelper(this);
		}
		
		return contactsHelper;
	}
	
	public GroupHelper getGroupHelper(){
		if (groupHelper == null) {
			groupHelper = new GroupHelper(this);
		}
		return groupHelper;
	} 
	
	  // ленивая инициализация
	public NavigationHelper navigateTo(){
		if (navigationHelper == null) {
			navigationHelper =  new NavigationHelper(this);
		}
		return navigationHelper; 
	}
	
	
	
	public ApplicationManager(Properties prop) throws FileNotFoundException, IOException {
		 
		
		if (prop.getProperty("browser").equals("firefox"))
			driver = new FirefoxDriver();
		else 
		if (prop.getProperty("browser").equals("opera"))
			driver = new OperaDriver();
		else
		if (prop.getProperty("browser").equals("chrome"))
			driver = new ChromeDriver();
		else
		if (prop.getProperty("browser").equals("ie"))
			driver = new InternetExplorerDriver();
		else 
			throw new Error("unsupported browser");
		
		
		
		
		baseUrl = prop.getProperty("baseurl");
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(baseUrl); 
	}
	
	
	public void stop() {
		 driver.quit();
	}


	
	
}
