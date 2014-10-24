package TestsForApp;

import org.testng.annotations.Test;

public class Groups_Modify_Existed_Tests extends TestBase {

	
	@Test
    public void renamegroup() { 	
	
	app.getNavigationHelper().goToSiteHome();
	app.getGroupHelper().goToGroupsPage();
	app.getGroupHelper().initGroupModification(1);
	 
	GroupsDataStructure obj = new GroupsDataStructure();
	obj.aname = "new group4444444444444444444444";
	    
	app.getGroupHelper().fillInGroup(obj);		
	app.getGroupHelper().GroupUpdate();
	app.getGroupHelper().goToGroupsPage();

	}
	
}
