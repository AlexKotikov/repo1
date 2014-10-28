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
		 
		for (int i =0; i< 5; i++)
		{
		GroupsDataStructure group = new GroupsDataStructure();
			group.aname = generateRandomString();
			group.header = generateRandomString();
			group.footer = 	generateRandomString();
			
			list.add (new Object[]{group});
			// не понимаю что вообще за конструкция такая Object[]{group}
			//  почему мы пишем {group} в фигурных скобках?
			// какую тему читать в книге по джава чтобы это понять?
		}	
		 	
		return list.iterator();
	}
	
	
	public String generateRandomString (){
		Random rnd = new Random();	
		if (rnd.nextInt(3)==0)	 		
			return  "";
			 
		        else     return  "randomtext" + rnd.nextInt(); 
			 
	}	
	
}
