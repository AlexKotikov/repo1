package com.example.fw;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

protected void type(By locator, String text)
	{
		if (text == null ) return; //|| text == ""
		WebElement element = driver.findElement(locator);
	    element.clear();
	    element.sendKeys(text);
	}

protected void click(By name1) {
	driver.findElement(name1).click();
}
protected void selectByText(By locator, String seltext) {
	if (seltext != null){
	new Select(driver.findElement(locator)).selectByVisibleText(seltext);
	}
}
	//we want to be sure that element doesn't present on form.
protected boolean isElementNotPresent(By locator) {
	  driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	  
	  boolean result = driver.findElements(locator).size() > 0;
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  return result;
	}



// Можно много полезных функций для себя обернуть. Главное не светить driver снаружи базового класса.
protected int countElements(By by) {
    return driver.findElements(by).size();
}

protected String getText(By by) {
    return driver.findElement(by).getText();
}

protected String getCurrentUrl() {
    return driver.getCurrentUrl();
}
 
protected void goBaseUrl() {
     driver.get(manager.returnBaseURL());
}

}
