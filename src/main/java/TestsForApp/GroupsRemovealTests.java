package TestsForApp;

import org.testng.annotations.Test;

public class GroupsRemovealTests extends HeadOfSuite   {
    // HeadOfSuite = TestBase
	@Test
	public void deleteSomeGroup(){
		app.getNavigationHelper().goToSiteHome();
		app.getGroupHelper().goToGroupsPage();
		app.getGroupHelper().deleteGroup(1);
		app.getGroupHelper().goToGroupsPage();
		
	}
	
}
