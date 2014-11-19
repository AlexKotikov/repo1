package com.example.tests;

import static com.example.tests.GroupGenerator.generateRandomGroups;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;
import static com.example.tests.GroupGenerator.loadGruopsFromCSVfile;
import static com.example.tests.GroupGenerator.loadGroupsFromXMLFile;

public class Gorups_Add_New_Group_With_Valid_Data_Tests extends TestBase{
 
	

	@DataProvider
	public Iterator<Object[]> groupsFromCSVFile() throws IOException{
	
	 return wrapGropupsForDataProvider(loadGruopsFromCSVfile(new File ("groups.txt"))).iterator();
	}
	
	@DataProvider
	public Iterator<Object[]> groupsFromXMLFile() throws IOException{
	
	 return wrapGropupsForDataProvider(loadGroupsFromXMLFile(new File ("groups.xml"))).iterator();
	}
	
	
	 @Test (dataProvider = "groupsFromXMLFile")
	    public void testGroupsFromFile(GroupsDataStructure obj) throws Exception
	    {
	    	SortedListOf<GroupsDataStructure> oldList  = app.getGroupHelper().getGroups();
	   
	    	app.getGroupHelper().createNewGorup(obj);
	 
	    	SortedListOf<GroupsDataStructure> newList  = app.getGroupHelper().getGroups();  
	  
	    	assertThat(newList, equalTo(oldList.withAdded(obj)));
	  
	    	//---------------------------
	    	System.out.println("---New List---"); 
	    	for(GroupsDataStructure a:  newList) {System.out.println(a);}     
	  }
	
	
    //@Test (dataProvider = "randomValidGroupGenerator")
    public void testSendDataToGroup(GroupsDataStructure obj) throws Exception
    {
    	SortedListOf<GroupsDataStructure> oldList  = app.getGroupHelper().getGroups();
    	app.getGroupHelper().createNewGorup(obj); 
    	SortedListOf<GroupsDataStructure> newList  = app.getGroupHelper().getGroups();  
    	assertThat(newList, equalTo(oldList.withAdded(obj)));
    	//---------------------------
    	System.out.println("---New List---"); 
    	for(GroupsDataStructure a:  newList) {System.out.println(a);}     
  }
}
