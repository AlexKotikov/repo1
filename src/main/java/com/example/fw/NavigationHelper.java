package com.example.fw;

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
		return (driver.findElements(By.id("maintable")).size() >0);
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
