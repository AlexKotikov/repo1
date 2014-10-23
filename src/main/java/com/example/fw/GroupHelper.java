package com.example.fw;

import org.openqa.selenium.By;

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
		click (By.xpath("//input[@name=\"selected[]\"]["+index+"]"));
		click (By.name("delete"));
		
	}

	public void initGroupModification(int index) {
		click (By.xpath("//input[@name=\"selected[]\"]["+index+"]"));
		click (By.name("edit"));
	}

	public void GroupUpdate() {
		

		click (By.name("update"));
		
	} 
	
	
}
