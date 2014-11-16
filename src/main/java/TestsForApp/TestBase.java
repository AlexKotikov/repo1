package TestsForApp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

public class TestBase {

	protected  ApplicationManager app;

	
	
	@BeforeTest
	public void setUp() throws Exception {
	    app = new ApplicationManager();
	  } 

	@AfterTest
	public void tearDown() throws Exception {
		app.stop();
	  }

	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator(){
		List<Object[]> list = new ArrayList<Object[]>();
		 
		for (int i =0; i< 1; i++)
		{
		GroupsDataStructure group = new GroupsDataStructure()
			
		     .withName(generateRandomString())
		     .withHeader(generateRandomString())
		     .withFooter(generateRandomString());	
			list.add (new Object[]{group});  // это массив
		}		
		return list.iterator();
	}
	


	@DataProvider
	public Iterator<Object[]> randomValidContactsGenerator(){
		List<Object[]> list = new ArrayList<Object[]>();
		 
		for (int i =0; i< 1; i++)
		{
		ContactsDataStructure  con = new ContactsDataStructure()
		
		.withFirstName(generateRandomString())
		.withSecondName(generateRandomString())
		.withEmail1(generateRandomString());
					
		list.add (new Object[]{con});
		}	
		 	
		return list.iterator();
	}
	
	
	
	
	
	public String generateRandomString (){
		Random rnd = new Random();	
		//if (rnd.nextInt(0)==0)	 		
		//	 return  "";
		// else   
		        return  "randomtext" + rnd.nextInt(); 
			 
	}	
	
}
