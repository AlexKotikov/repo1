package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {

	public NavigationHelper(ApplicationManager manager) {
		super(manager);
		
	}

	public void backToHomePage() {
		 click(By.linkText("home"));
	}

	public void goToSiteHome() {
		driver.get(manager.baseUrl );//+ "/group.php"
		
	}
	public void goToBirthdaysPage() {
		 click(By.linkText("next birthdays"));
		 
	}
}
