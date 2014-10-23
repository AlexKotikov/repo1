package TestsForApp;

import org.testng.annotations.Test;

public class GroupModificationTests extends HeadOfSuite {

	
	@Test
    public void renamegroup() { 	
	
	app.getNavigationHelper().goToSiteHome();
	app.getGroupHelper().goToGroupsPage();
	app.getGroupHelper().initGroupModification(1);
	 
	GroupsDataStructure obj = new GroupsDataStructure();
	obj.aname = "new group444";
	    
	app.getGroupHelper().fillInGroup(obj);
		
	app.getGroupHelper().GroupUpdate();
	app.getGroupHelper().goToGroupsPage();
	
	
	
	}
	
}
