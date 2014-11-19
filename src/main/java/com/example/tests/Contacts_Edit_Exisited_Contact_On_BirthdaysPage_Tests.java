package com.example.tests;



import org.testng.annotations.Test;

public class Contacts_Edit_Exisited_Contact_On_BirthdaysPage_Tests extends TestBase {
	
	@Test  
    public void changeNameOfExistedContact() { 	
	 
       app.navigateTo().homePage();
       app.navigateTo().goToBirthdaysPage();
      
 
       app. getContactsHelper().selectExistedContactEditLinkFromBirthdays(1);
       
       app.getContactsHelper().sendDataToContacts(
         
       new ContactsDataStructure() 
          .withFirstName("Petya")
          .withSecondName("Sviridov")
       ,   app.getContactsHelper().MODIFICATION);
       
       
       app.getContactsHelper().updateForm();
       app.navigateTo().goToBirthdaysPage();
      
   
	}
	
}