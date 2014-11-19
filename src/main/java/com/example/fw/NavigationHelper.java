package com.example.fw;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
 


public class NavigationHelper extends HelperBase {

	public NavigationHelper(ApplicationManager manager) {
		super(manager);
		
	}

	public void backToHomePage() {
		 click(By.linkText("home"));
	}

	public void homePage() {
		
		if (!onHomePage())
		//click(By.linkText("home"));
		 goBaseUrl();
	}
	

	
	 
	
	private boolean onHomePage() {
		boolean var;
		 driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		
		 var = driver.findElements(By.id("maintable")).size() >0;
		 
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		return (var);
		  
		
	}

	public void goToBirthdaysPage() {
		 click(By.linkText("next birthdays"));
		 
	}
	
	 public void goToGroupsPage() {
		 
		  if (onGroupsPage())
		 return ;		 	 
		 // переход на страницу с группами
			click(By.linkText("groups"));
			 
		}

	private boolean onGroupsPage() { 
		if (driver.getCurrentUrl().contains("group.php")
            &&  driver.findElements(By.name("new")).size() >0
            )
			return true; else return false;
	}
	
}
