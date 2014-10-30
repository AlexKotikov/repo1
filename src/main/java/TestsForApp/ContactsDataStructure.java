package TestsForApp;

 

public class ContactsDataStructure  implements Comparable<ContactsDataStructure> {
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
	public String day;
	public String month;
	
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
		this.month = month; 
		
	}
	
	public ContactsDataStructure() {}
    //Этот метод определяет как сортировать все что находится в коллекции.
	public int compareTo(ContactsDataStructure o) {
	
		return  this.first .compareTo(o.first) ;
		
		
		
}

	@Override
	public String toString() {
		return "ContactsDataStructure [first=" + first + ", last=" + last
				+ ", address=" + address + "]";
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
		this.last  =a;
		return this;
	}
	
	
	
	}

	
	