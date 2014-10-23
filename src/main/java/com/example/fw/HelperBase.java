package com.example.fw;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;



public abstract class HelperBase {

 
protected ApplicationManager manager;
protected WebDriver driver;
protected  boolean acceptNextAlert = true;

public HelperBase(ApplicationManager manager){
	this.manager = manager;
	this.driver = manager.driver;
}
	
public boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

public boolean isAlertPresent() {
    try {
    	 driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

public String closeAlertAndGetItsText() {
    try {
      Alert alert =  driver.switchTo().alert();
      String alertText = alert.getText();
      if ( acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
       acceptNextAlert = true;
    }
  }

protected void type(By locator, String text) {
	if (text != null){
	driver.findElement(locator).clear();
	driver.findElement(locator).sendKeys(text);
	}
}

protected void click(By name1) {
	driver.findElement(name1).click();
}
protected void selectByText(By locator, String seltext) {
	new Select(driver.findElement(locator)).selectByVisibleText(seltext);
}

public void sendContactsForm() {
	 click(By.name("submit"));
}

public void startToAddingOfNewContact() {
	click(By.linkText("add new"));
	
 
}

}
