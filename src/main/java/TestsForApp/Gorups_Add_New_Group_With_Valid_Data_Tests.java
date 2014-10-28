package TestsForApp;

import static org.testng.AssertJUnit.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
 

public class Gorups_Add_New_Group_With_Valid_Data_Tests extends TestBase{
    
	
	
	
	@Test (dataProvider = "randomValidGroupGenerator")
  public void testSendDataToGroup(GroupsDataStructure obj) throws Exception {
    
	app.getNavigationHelper().goToSiteHome();
    app.getGroupHelper().goToGroupsPage();
  
     // сохранить состояние   
    List<GroupsDataStructure> oldList  = app.getGroupHelper().GetGroups();
    
    app.getGroupHelper().clickNewGroup();
    
    
    // произвести действия  
  /*    GroupsDataStructure obj = new GroupsDataStructure();
    obj.aname = "group_listtest";
    obj.footer =  "footer1_listtest";
    obj.header =  "header1_listtest";  */
    
    app.getGroupHelper().fillInGroup(obj);
    app.getGroupHelper(). submitGroupForm();
    app.getGroupHelper().goToGroupsPage();
  
  // получить новый  
    List<GroupsDataStructure> newList  = app.getGroupHelper().GetGroups();
    
  // сравнить все 
   //assertEquals( newList.size(), oldList.size()+1);
  
   oldList.add(obj);
   Collections.sort(oldList);
   assertEquals( newList, oldList); 
     
  }
}
