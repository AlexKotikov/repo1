package TestsForApp;

import static org.testng.AssertJUnit.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class Groups_Remove_Existed_Tests extends TestBase   {
   
	@Test
	public void deleteSomeGroup(){
		app.getNavigationHelper().goToSiteHome();
		app.getGroupHelper().goToGroupsPage();
		
		   // сохранить состояние   
	    List<GroupsDataStructure> oldList  = app.getGroupHelper().GetGroups();
	    
		Random  rnd = new Random();
		int index = rnd.nextInt(oldList.size()-1);
		
		app.getGroupHelper().deleteGroup(index);
		app.getGroupHelper().goToGroupsPage();
		
		 // получить новый  
	    List<GroupsDataStructure> newList  = app.getGroupHelper().GetGroups();
	    
	  // сравнить все 
	   //assertEquals( newList.size(), oldList.size()+1);
	  
	   oldList.remove(index);
	   Collections.sort(oldList);
	   assertEquals( newList, oldList);
		
	}
	
}
