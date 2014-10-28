package TestsForApp;

import static org.testng.AssertJUnit.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class Groups_Modify_Existed_Tests extends TestBase {

	
	@Test (dataProvider = "randomValidGroupGenerator")
    public void renamegroup(GroupsDataStructure obj) { 	
	
	app.getNavigationHelper().goToSiteHome();
	app.getGroupHelper().goToGroupsPage();
	
	   // сохранить состояние   
    List<GroupsDataStructure> oldList  = app.getGroupHelper().GetGroups();
    
    Random  rnd = new Random();
	int index = rnd.nextInt(oldList.size()-1);
    
    
	app.getGroupHelper().initGroupModification(index);
	 
	//GroupsDataStructure obj = new GroupsDataStructure();
	//obj.aname = "new groupmmmmm";
	    
	app.getGroupHelper().fillInGroup(obj);		
	app.getGroupHelper().GroupUpdate();
	app.getGroupHelper().goToGroupsPage();

	 // получить новый  
    List<GroupsDataStructure> newList  = app.getGroupHelper().GetGroups();
    
   // сравнить все 
   //assertEquals( newList.size(), oldList.size()+1);
  
    
    oldList.remove(index); 
    oldList.add(obj);
    Collections.sort(oldList);
    assertEquals( newList, oldList);
	
	//  
	}
	
}
