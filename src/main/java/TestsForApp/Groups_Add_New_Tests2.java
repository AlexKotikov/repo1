package TestsForApp;



import org.testng.annotations.Test;
import org.testng.Assert;



public class Groups_Add_New_Tests2 extends TestBase {


  @Test
  public void testSendDataToGroup() throws Exception {
	    
	    app.getNavigationHelper().goToSiteHome();
	    app.getGroupHelper().goToGroupsPage();
	    app.getGroupHelper().clickNewGroup();
	    GroupsDataStructure obj = new GroupsDataStructure();
	    obj.aname = "group2";
	    obj.footer =  "footer2";
	    obj.header =  "header2";
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
