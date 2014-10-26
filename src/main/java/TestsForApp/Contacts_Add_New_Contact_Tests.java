package TestsForApp;

import org.testng.annotations.Test;
 


public class Contacts_Add_New_Contact_Tests extends TestBase {
  @Test
  public void testCase1() throws Exception {
    app.getNavigationHelper().goToSiteHome();
    app.getContactsHelper().startToAddingOfNewContact();
    
    
    ContactsDataStructure obj = new ContactsDataStructure();
    obj.first	=   "First";
    obj.last	=	"Last";
    obj.address	=	"Address 123 /123";
    obj.home	=	"Home"; 
    obj.mobile	=	"Mobile"; 
    obj.work	=	"Work"; 
    obj.email1	=	"E-mail@E-mail.ru";
    obj.email2	=	"E2-mail@E2-mail.ru";
    obj.byear   =	"1988";
    obj.address2	=	"Secondary";
    obj.secondaryAddress	=	"SecondaryAddress";
    obj.homepage =		"Homepage.ru";
    obj.day = "17";
    obj.month ="December";
	
    
    
    app.getContactsHelper().sendDataToContacts(obj);
    app.getContactsHelper().sendContactsForm();
    app.getNavigationHelper().backToHomePage();
  }
}
