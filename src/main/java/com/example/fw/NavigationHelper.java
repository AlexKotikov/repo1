package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {

	public NavigationHelper(ApplicationManager manager) {
		super(manager);
		
	}

	public void backToContactsPAge() {
		 click(By.linkText("home page"));
	}

	public void goToSiteHome() {
		driver.get(manager.baseUrl + "/group.php");
		
	}

}
