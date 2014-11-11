package TestsForApp;

 

public class ContactsDataStructure  implements Comparable<ContactsDataStructure> {
	private String first;
	private String last;
	private String address;
	private String home;
	private String mobile;
	private String work;
	private String email1;
	private String email2;
	private String byear;
	private String address2;
	private String secondaryAddress;
	private String homepage;
	private String day;
	private String month;
	
	public ContactsDataStructure(String first, String last,
			String address, String home, String mobile, String work,
			String email1, String email2, String byear, String address2,
			String secondaryAddress, String homepage, String day, String month) {
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
		this.day = day;
		this. month = month; 
		
	}
	
	public ContactsDataStructure() {}
	
	
    //Этот метод определяет как сортировать все что находится в коллекции.
	public int compareTo(ContactsDataStructure o) {
	
		return  this.first .compareTo(o.first) ;
		
		
		
}

	@Override
	public String toString() {
		return "ContactsDataStructure [first=" + first + ", last=" + last
				+ ", address=" + address + "  email1=" + email1 +  "]";
	}

	@Override
	public int hashCode() {
		//final int prime = 31;
		int result = 1;
		//result = prime * result + ((email1 == null) ? 0 : email1.hashCode());
		//result = prime * result + ((first == null) ? 0 : first.hashCode());
		//result = prime * result + ((last == null) ? 0 : last.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactsDataStructure other = (ContactsDataStructure) obj;
		if (email1 == null) {
			if (other.email1 != null)
				return false;
		} else if (!email1.equals(other.email1))
			return false;
		if (first == null) {
			if (other.first != null)
				return false;
		} else if (!first.equals(other.first))
			return false;
		if (last == null) {
			if (other.last != null)
				return false;
		} else if (!last.equals(other.last))
			return false;
		return true;
	}

	public ContactsDataStructure swapFirstAndLast() {
		
		String a = this.first;
		this.first = this.last;
		this.last  = a;
		return this;
	}

	public ContactsDataStructure withFirstName(String name) {		
		this.first = name;
		return this;
	}

	public ContactsDataStructure withSecondName(String name) {	 
		this.last = name;
		return this;
	}

	public ContactsDataStructure withEmail1(String name) {
		this.email1 = name;
		return this;
	}

	public ContactsDataStructure withAddress(String string) {
	 
		this.address = string;
		return this;
	}

	public ContactsDataStructure withHome(String string) {
		 
		this.home = string;
		return this;
	}

	public ContactsDataStructure withMobile(String string) {
		 
		this.mobile = string;
		return this;
	}

	public ContactsDataStructure withWork(String string) {
		this.work = string;
				return this;
	}

	public ContactsDataStructure withEmail2(String string) {
		 
	 
		this.email2   = string;
		return this;
	}

	public ContactsDataStructure withByear(String string) {
		 
		this.byear = string;
		return this;
	}

	public ContactsDataStructure withAddress2(String string) {
		 
		this.address2 = string;
		return this;
	}

	public ContactsDataStructure withSecondaryAddress(String string) {
		 
		this.secondaryAddress = string;
		return this;
	}

	public ContactsDataStructure withHomepage(String string) {
		 
		this.home = string;
		return this;
	}

	public ContactsDataStructure withDay(String string) {
		this.day =  string;
		return this;
	}

	public ContactsDataStructure withMonth(String string) {
        this.month = string;
		return this;
	}

	public String getFirst() {
		return first;
	}

	public String getLast() {
		return last;
	}

	public String getAddress() {
		return address;
	}

	public String getHome() {
		return home;
	}

	public String getMobile() {
		return mobile;
	}

	public String getWork() {
		return work;
	}

	public String getEmail1() {
		return email1;
	}

	public String getEmail2() {
		return email2;
	}

	public String getByear() {
		return byear;
	}

	public String getAddress2() {
		return address2;
	}

	public String getSecondaryAddress() {
		return secondaryAddress;
	}

	public String getHomepage() {
		return homepage;
	}

	public String getDay() {
		return day;
	}

	public String getMonth() {
		return month;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}
	
	
	
	
	
	}

	
	