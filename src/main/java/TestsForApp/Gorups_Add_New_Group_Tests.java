package TestsForApp;

import org.testng.annotations.Test;
 

public class Gorups_Add_New_Group_Tests extends TestBase{
  @Test
  public void testSendDataToGroup() throws Exception {
    
	app.getNavigationHelper().goToSiteHome();
    app.getGroupHelper().goToGroupsPage();
    app.getGroupHelper().clickNewGroup();
    GroupsDataStructure obj = new GroupsDataStructure();
    obj.aname = "group111111111111";
    obj.footer =  "footer1";
    obj.header =  "header1";
    app.getGroupHelper().fillInGroup(obj);
    app.getGroupHelper(). submitGroupForm();
    app.getGroupHelper().goToGroupsPage();
  }

  @Test
  public void testSendNoneDataToGroup() throws Exception {
	 
	  app.getGroupHelper().goToGroupsPage();
	  app.getGroupHelper().clickNewGroup();
	  app.getGroupHelper().fillInGroup(new GroupsDataStructure("", "", ""));
	  app.getGroupHelper().submitGroupForm();
	  app.getGroupHelper().goToGroupsPage();
  }
}
