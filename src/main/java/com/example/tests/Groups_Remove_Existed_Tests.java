package com.example.tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;


public class Groups_Remove_Existed_Tests extends TestBase   {
   
	@Test
	public void deleteSomeGroup(){
	 
		
		
		 // сохранить состояние   
		SortedListOf<GroupsDataStructure> oldList  = app.getGroupHelper().getUIGroups();
	    
		Random  rnd = new Random();
		int index = rnd.nextInt(oldList.size()-1);
		
		app.getGroupHelper()
		   .deleteGroup(index) ;
		 // получить новый  
		SortedListOf<GroupsDataStructure> newList  = app.getGroupHelper().getUIGroups();
	     // сравнить все 
	     //assertEquals( newList.size(), oldList.size()+1);
 
	   assertThat(newList, equalTo(oldList.without(index)));
	   System.out.println("---New List---"); 
	    for(GroupsDataStructure a:  newList) {System.out.println(a);}
	}
	 
}
