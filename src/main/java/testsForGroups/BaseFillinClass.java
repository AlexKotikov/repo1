package testsForGroups;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class BaseFillinClass {

	private  static WebDriver driver;
	private  static String baseUrl;
	private  static boolean acceptNextAlert = true;
	private  static  StringBuffer verificationErrors = new StringBuffer();

	@BeforeTest
	public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://mysite/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	protected void submitGroupForm() {
		// Подтверждаем и выходим
	    driver.findElement(By.name("submit")).click();
	}

	protected void fillInGroup(FillInGroupParameter parameterObject) {
		// Начинаем вводить данные
	    driver.findElement(By.name("group_name")).clear();
	    driver.findElement(By.name("group_name")).sendKeys(parameterObject.aname);
	    driver.findElement(By.name("group_header")).clear();
	    driver.findElement(By.name("group_header")).sendKeys(parameterObject.header);
	    driver.findElement(By.name("group_footer")).clear();
	    driver.findElement(By.name("group_footer")).sendKeys(parameterObject.footer);
	}

	protected void clickNewGroup() {
		// Создаем новую группу
	    driver.findElement(By.name("new")).click();
	}

	protected void goToGroupsPage() {
		// переход на страницу с группами
	    driver.findElement(By.linkText("groups")).click();
	}

	protected void goToSite() {
		//Переход на сайт
		driver.get(baseUrl + "/index.php");
	}

	@AfterTest
	public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	    	org.testng.Assert.fail(verificationErrorString);
	    }
	  }

	private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }

}
