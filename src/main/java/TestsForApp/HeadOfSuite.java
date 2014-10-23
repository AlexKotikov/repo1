package TestsForApp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.example.fw.ApplicationManager;

public class HeadOfSuite {

	public ApplicationManager app;
	
	
	@BeforeTest
	public void setUp() throws Exception {
	    app = new ApplicationManager();
	  }

	@AfterTest
	public void tearDown() throws Exception {
		app.stop();
		
	   
	  }

}
