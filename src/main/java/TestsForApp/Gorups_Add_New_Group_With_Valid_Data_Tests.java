package TestsForApp;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;


public class Gorups_Add_New_Group_With_Valid_Data_Tests extends TestBase{
 
    @Test (dataProvider = "randomValidGroupGenerator")
    public void testSendDataToGroup(GroupsDataStructure obj) throws Exception
    {
    	SortedListOf<GroupsDataStructure> oldList  = app.getGroupHelper().getGroups();
   
    	app.getGroupHelper().createNewGorup(obj);
 
    	SortedListOf<GroupsDataStructure> newList  = app.getGroupHelper().getGroups();  
  
    	assertThat(newList, equalTo(oldList.withAdded(obj)));
  
    	//---------------------------
    	System.out.println("---New List---"); 
    	for(GroupsDataStructure a:  newList) {System.out.println(a);}
  
    
  
    
    
   
    
    
     
  }
}
