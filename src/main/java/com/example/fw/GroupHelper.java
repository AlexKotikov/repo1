package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import TestsForApp.GroupsDataStructure;

public class GroupHelper extends HelperBase{

	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}

	public void submitGroupForm() {
		// Подтверждаем и выходим
	    driver.findElement(By.name("submit")).click();
	}

    public void fillInGroup(GroupsDataStructure parameterObject) {
		// Начинаем вводить данные
		
		type(By.name("group_name"),parameterObject.aname); 
		type(By.name("group_header"),parameterObject.header);
		type(By.name("group_footer"),parameterObject.footer);
	 
	}

    public void clickNewGroup() {
		// Создаем новую группу
	   
	    click(By.name("new"));
	    
	}

    public void goToGroupsPage() {
		// переход на страницу с группами
		click(By.linkText("groups"));
		
		
	}

	public void deleteGroup(int index) {
		click (By.xpath("//input[@name=\"selected[]\"]["+(index+1)+"]"));
		click (By.name("delete"));
		
	}

	public void initGroupModification(int index) {
		click (By.xpath("//input[@name=\"selected[]\"]["+(index+1)+"]"));
		click (By.name("edit"));
	}

	public void GroupUpdate() {
		

		click (By.name("update"));
		
	}

	public List<GroupsDataStructure> GetGroups() {
		List<GroupsDataStructure>  groups = new ArrayList<GroupsDataStructure>();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement webElement : checkboxes) {
			GroupsDataStructure group = new GroupsDataStructure();
			String su = webElement.getAttribute("title");
			group.aname =  su.substring("Select (".length(), su.length() - ")".length() );			
			groups.add(group);
		}
        return groups;
	}  
	
	
}
