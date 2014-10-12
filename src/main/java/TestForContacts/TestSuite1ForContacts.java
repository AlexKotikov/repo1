package TestForContacts;

import org.testng.annotations.Test;



public class TestSuite1ForContacts extends HeadOfSuite {
  @Test
  public void testCase1() throws Exception {
    goToContactsPage();
    startToAddingOfNewContact();
    ContactsDataStructure obj = new ContactsDataStructure();
    obj.first	= "First";
    obj.last	=	"Last";
    obj.address	=	"Address 123 /123";
    obj.home	=	"Home"; 
    obj.mobile	=	"Mobile"; 
    obj.work	=	"Work"; 
    obj.email1	=	"E-mail@E-mail.ru";
    obj.email2	=	"E2-mail@E2-mail.ru";
    obj.byear=		"1988";
    obj.address2	=	"Secondary";
    obj.secondaryAddress	=	"SecondaryAddress";
    obj.homepage =		"Homepage.ru";
    sendDataToContacts(obj);
    sendContactsForm();
    backToContactsPAge();
  }
}
