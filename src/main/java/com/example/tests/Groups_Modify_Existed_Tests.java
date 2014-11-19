package com.example.tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class Groups_Modify_Existed_Tests extends TestBase {

	@Test (dataProvider = "randomValidGroupGenerator")
    public void renamegroup(GroupsDataStructure obj) { 	
 
	  // сохранить состояние   
	SortedListOf<GroupsDataStructure> oldList  = app.getGroupHelper().getGroups();
    
	Random  rnd = new Random();
	int index = rnd.nextInt(oldList.size()-1);
	
	app.getGroupHelper().modifyGroup(index,obj);
	
	// получить новый  
	SortedListOf<GroupsDataStructure> newList  = app.getGroupHelper().getGroups();   
    // сравнить все 
    //assertEquals( newList.size(), oldList.size()+1);
   
	System.out.println("---New List---"); 
    for(GroupsDataStructure a:  newList) {System.out.println(a);}
    assertThat(newList, equalTo(oldList.without(index).withAdded(obj)));
   
	}
	
}
