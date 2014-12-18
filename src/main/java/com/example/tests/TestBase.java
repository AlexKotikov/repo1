package com.example.tests;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;
import static com.example.tests.GroupGenerator.generateRandomGroups;
import static com.example.tests.GroupGenerator.generateRandomString;
import static com.example.tests.ContactsGenerator.GenNewString;

public class TestBase {

	protected  ApplicationManager app;
	 
	private int counterUI;
	private int counterDB;

	
	
	@BeforeTest
	public void setUp() throws Exception {
		
		String props = System.getProperty("config", "application.properties");		
		Properties prop = new Properties();
		prop.load( new FileReader ( new File(props)));
		
		app = new ApplicationManager(prop);
		
	  } 

	@AfterTest
	public void tearDown() throws Exception {
		app.stop();
	  }

	
	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator(){
	
	 return wrapGropupsForDataProvider(generateRandomGroups(5)).iterator();
	}
	


  public static  List<Object[]> wrapGropupsForDataProvider(
		List<GroupsDataStructure> groups) {
		List<Object[]> list = new ArrayList <Object[]>();
		
		for(GroupsDataStructure a: groups) 
		list.add(new Object[] {a});
		
		return list;
	}

  protected  List<Object[]> conactstsWraper(List<ContactsDataStructure> conts) {
		 List<Object[]> obj = new ArrayList<Object[]>();
		  for (ContactsDataStructure objects : conts) {	
			  obj.add(new Object[]{objects});
		  }
		  	return 	obj;
	}
  
	@DataProvider
	public Iterator<Object[]> randomValidContactsGenerator(){
		List<Object[]> list = new ArrayList<Object[]>();
		 
		for (int i =0; i< 1; i++)
		{
		ContactsDataStructure  con = new ContactsDataStructure()
		
		.withFirstName(GenNewString())
		.withSecondName(GenNewString())
		.withEmail1(GenNewString());
					
		list.add (new Object[]{con});
		}	
		 	
		return list.iterator();
	}
	
	protected boolean checking(String str) {
		
		if (str.equals("db")){
			counterDB++;
			if ( Integer.parseInt(app.getProperty("check.db-count")) > 0)
						if (counterDB ==  Integer.parseInt(app.getProperty("check.db-count"))) { 
							counterDB=0;
								return true;
								}
		}
		
		if (str.equals("ui")){
			counterUI++;
		
			if ( Integer.parseInt(app.getProperty("check.ui-count")) > 0)
					if (counterUI ==  Integer.parseInt(app.getProperty("check.ui-count"))) { 
						counterUI=0;
						return true;
						   
					} 			   
	 	}				   
			return false;
		}
	
	
}
