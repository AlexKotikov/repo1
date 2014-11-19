package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import com.example.tests.GroupsDataStructure;
import com.example.utils.SortedListOf;

public class GroupHelper extends HelperBase{

	public GroupHelper createNewGorup(GroupsDataStructure obj ) {
		 
		manager.navigateTo().goToGroupsPage();
				clickNewGroup();
	            fillInGroup(obj);
	            submitGroupForm();
	            returntoGroupPage();
	            rebuildCache();
	    return this;
	}
	 
	private  SortedListOf<GroupsDataStructure> cachedGroups;
	
	
	
	public SortedListOf<GroupsDataStructure> getGroups() {
		
		if (cachedGroups == null) rebuildCache();
	
	return 	 cachedGroups;
	}
		
	
		
	
	private void rebuildCache() {
		  cachedGroups = new SortedListOf<GroupsDataStructure>();
           manager.navigateTo().goToGroupsPage();
		
        List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement webElement : checkboxes) { 
			String su = webElement.getAttribute("title");
			String aname =  su.substring("Select (".length(), su.length() - ")".length() );			
			cachedGroups.add(new GroupsDataStructure().withName(aname));
		}
		
        
	}  
		





	public GroupHelper deleteGroup(int index) {
		 
		manager.navigateTo().goToGroupsPage();
		selectByIndex(index);
		delete();
		returntoGroupPage();
		rebuildCache();
		return this;
	}



	
	public GroupHelper modifyGroup(int index, GroupsDataStructure obj) {
		
		manager.navigateTo().goToGroupsPage();
		
		initGroupModification(index) ;
        fillInGroup(obj) 	 	;
	    groupUpdate();
	    returntoGroupPage();
	    rebuildCache();
	    return this;
}
	
	// -------------------------------------------------------------------------------------

	private GroupHelper returntoGroupPage() {
		click(By.linkText("groups"));
		return this;
	}




	private void selectByIndex(int index) {
		click (By.xpath("//input[@name=\"selected[]\"]["+(index+1)+"]"));
	}


	private void delete() {
		click (By.name("delete"));
		cachedGroups = null;
	}
	
	
	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}

	public GroupHelper submitGroupForm() {
		// Подтверждаем и выходим
	    driver.findElement(By.name("submit")).click();
	    cachedGroups = null;
	    return this;
	}

    public GroupHelper fillInGroup(GroupsDataStructure parameterObject) {
		// Начинаем вводить данные
		
		type(By.name("group_name"),parameterObject.getName()); 
		type(By.name("group_header"),parameterObject.getHeader());
		type(By.name("group_footer"),parameterObject.getFooter());
		return this;
	}

    public GroupHelper clickNewGroup() {
		// Создаем новую группу
	    click(By.name("new"));
	    return this;
	}

   

	

	public GroupHelper initGroupModification(int index) {
		selectByIndex(index);
		click (By.name("edit"));
		return this;
	}

	public GroupHelper groupUpdate() {
		click (By.name("update"));
		cachedGroups = null;
		return this;
	}
}
