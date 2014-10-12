package TestForContacts;

public class ContactsDataStructure {
	public String first;
	public String last;
	public String address;
	public String home;
	public String mobile;
	public String work;
	public String email1;
	public String email2;
	public String byear;
	public String address2;
	public String secondaryAddress;
	public String homepage;

	public ContactsDataStructure(String first, String last,
			String address, String home, String mobile, String work,
			String email1, String email2, String byear, String address2,
			String secondaryAddress, String homepage) {
		this.first = first;
		this.last = last;
		this.address = address;
		this.home = home;
		this.mobile = mobile;
		this.work = work;
		this.email1 = email1;
		this.email2 = email2;
		this.byear = byear;
		this.address2 = address2;
		this.secondaryAddress = secondaryAddress;
		this.homepage = homepage;
	}
	
	public ContactsDataStructure() {};
	
}