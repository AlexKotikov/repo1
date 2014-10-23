package TestsForApp;

import org.testng.annotations.Test;


public class AddNewContactWithData2 extends HeadOfSuite {
  @Test
  public void testCase1() throws Exception {
    app.getNavigationHelper().goToSiteHome();
    app.getContactsHelper().startToAddingOfNewContact();
    ContactsDataStructure obj = new ContactsDataStructure();
    obj.first	= "First2";
    obj.last	=	"Last2";
    obj.address	=	"Address 123 /1232";
    obj.home	=	"Home2"; 
    obj.mobile	=	"Mobile2"; 
    obj.work	=	"Work2"; 
    obj.email1	=	"E-mail@E-mail.ru2";
    obj.email2	=	"E2-mail@E2-mail.ru2";
    obj.byear=		"1988";
    obj.address2	=	"Secondary2";
    obj.secondaryAddress	=	"SecondaryAddress2";
    obj.homepage =		"Homepage.ru2";
    obj.day = "18";
    obj.month ="December";
 
    app.getContactsHelper().sendDataToContacts(obj);
    app.getContactsHelper().sendContactsForm();
    app.getNavigationHelper().backToContactsPAge();
  }
}
