package com.example.fw;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ApplicationManager {

	public  WebDriver driver;
	public  String baseUrl;
	//private StringBuffer verificationErrors = new StringBuffer();

	private NavigationHelper navigationHelper;
	private GroupHelper  groupHelper;
	private ContactsHelper  contactsHelper;
	
 
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
	
 
	
	public ApplicationManager() {
		driver = new FirefoxDriver();
	    baseUrl = "http://mysite/index.php";
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(baseUrl); 
	}
	
	
	public void stop() {
		 driver.quit();
	}

	
	
	
}
