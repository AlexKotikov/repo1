package testsForGroups;



import org.testng.annotations.Test;
import org.testng.Assert;


public class SecondFillInGroup extends BaseFillinClass {


  @Test
  public void testSendDataToGroup() throws Exception {
    goToSite();
	goToGroupsPage();
    clickNewGroup();
    FillInGroupParameter obj = new FillInGroupParameter();
    obj.aname = "group5";
    obj.footer =  "footer5";
    obj.header =  "header5";
    fillInGroup(obj);
    submitGroupForm();
    goToGroupsPage();
  }

  @Test
  public void testSendNoneDataToGroup() throws Exception {
    goToSite();
	goToGroupsPage();
    clickNewGroup();
    fillInGroup(new FillInGroupParameter("_", "_", "_"));
    submitGroupForm();
    goToGroupsPage();
  }
  

}
