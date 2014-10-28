package TestsForApp;

public class GroupsDataStructure implements  Comparable<GroupsDataStructure> {
	public String aname;
	public String header;
	public String footer;

	public GroupsDataStructure(String aname, String header, String footer) {
		this.aname = aname;
		this.header = header;
		this.footer = footer;
	}
	public GroupsDataStructure() {
		 
	}

	@Override
	public String toString() {
		return "GroupsDataStructure [aname=" + aname + ", header=" + header
				+ ", footer=" + footer + "]";
	}
	@Override
	public int hashCode() {
		//final int prime = 31;
		int result = 1;
		//result = prime * result + ((aname == null) ? 0 : aname.hashCode());
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
		GroupsDataStructure other = (GroupsDataStructure) obj;
		if (aname == null) {
			if (other.aname != null)
				return false;
		} else if (!aname.equals(other.aname))
			return false;
		return true;
	}
<<<<<<< HEAD
=======
	
	public int compareTo(GroupsDataStructure o) {
		 
		return  this.aname.toLowerCase().
				compareTo(o.aname.toLowerCase());
	}
>>>>>>> 6d63cb00e7c5ff6920bde148aea7c8f2c9b6cb89
	
	public int compareTo(GroupsDataStructure o) {
		 
		return  this.aname.toLowerCase().
				compareTo(o.aname.toLowerCase());
	}
	 
}