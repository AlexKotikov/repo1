package testsForGroups;

import java.util.regex.Pattern;
//import org.junit.*;
//import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

//import org.junit.AfterClass;
import org.openqa.selenium.*;
//import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.Assert;


public class FillInGroup extends BaseFillinClass{
  @Test
  public void testSendDataToGroup() throws Exception {
    goToSite();
	goToGroupsPage();
    clickNewGroup();
    FillInGroupParameter obj = new FillInGroupParameter();
    obj.aname = "group3";
    obj.footer =  "footer3";
    obj.header =  "header3";
    fillInGroup(obj);
    submitGroupForm();
    goToGroupsPage();
  }

  @Test
  public void testSendNoneDataToGroup() throws Exception {
    goToSite();
	goToGroupsPage();
    clickNewGroup();
    fillInGroup(new FillInGroupParameter("", "", ""));
    submitGroupForm();
    goToGroupsPage();
  }
}
