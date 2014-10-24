package com.example.fw;

import org.openqa.selenium.By;


public class BirthdaysHelper  extends HelperBase{

	public BirthdaysHelper(ApplicationManager manager) {
		super(manager);
		
	}

	public void selectExistedContactEditLink(int index) {
		click (By.xpath("//tr[@class=\"odd\"]["+ index +"]/td/a[starts-with(@href, \"edit.php\")]"));
		
		
		
	}
	
	
	
	
	
	
}
