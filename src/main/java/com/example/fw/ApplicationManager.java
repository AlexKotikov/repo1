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

	private  WebDriver driver;
	private  String baseUrl;
	private Properties  properts;

	private NavigationHelper navigationHelper;
	private GroupHelper  groupHelper;
	private ContactsHelper  contactsHelper;
	private HibernateHelper hibernatehelper;
	
	private ApplicationModel  model;
	private Integer counter = 0;
	
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
	
	public HibernateHelper GetHibernateHelper(){
		if (hibernatehelper == null) {
			hibernatehelper =  new HibernateHelper(this);
		}
		return hibernatehelper; 
	}
	
	
	
	public ApplicationManager(Properties prop) throws FileNotFoundException, IOException {
		 
		this.properts = prop;
		
		model = new ApplicationModel();
		model.setGroups(GetHibernateHelper().listGroups()) ;
		model.setContacts(GetHibernateHelper().listContacts()) ;	 
		
	}
	
	public ApplicationModel getModelHelper(){
		return this.model;
		
	}
	
	 
	
	
	public void stop() {
		 driver.quit();
	}

  public WebDriver getDriver() {
		if (driver == null) {
			
			if (properts.getProperty("browser").equals("firefox"))
				driver = new FirefoxDriver();
			else 
			if (properts.getProperty("browser").equals("opera"))
				driver = new OperaDriver();
			else
			if (properts.getProperty("browser").equals("chrome"))
				driver = new ChromeDriver();
			else
			if (properts.getProperty("browser").equals("ie"))
				driver = new InternetExplorerDriver();
			else 
				throw new Error("unsupported browser");			
		}
		
		baseUrl = properts.getProperty("baseurl");
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(baseUrl); 
		
		
		return this.driver ;
	}

  		public String getProperty(String key){
  			return properts.getProperty(key);
  		}
	
	
}
