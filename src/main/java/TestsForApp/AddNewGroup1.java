package TestsForApp;

import java.util.regex.Pattern;
//import org.junit.*;
//import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

//import org.junit.AfterClass;
import org.openqa.selenium.*;
//import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.Assert;



public class AddNewGroup1 extends HeadOfSuite{
  @Test
  public void testSendDataToGroup() throws Exception {
    
    app.getGroupHelper().goToGroupsPage();
    app.getGroupHelper().clickNewGroup();
    GroupsDataStructure obj = new GroupsDataStructure();
    obj.aname = "group1";
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
