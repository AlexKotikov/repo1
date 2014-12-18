package com.example.tests;

public class GroupsDataStructure implements  Comparable<GroupsDataStructure> {

	private String aname;
	private String header;
	private String footer;
	private String id;
	
	
	public String getAname() {
		return aname;
	}

	public GroupsDataStructure(String aname, String header, String footer,  String id) {
		this.aname = aname;
		this.header = header;
		this.footer = footer;
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public GroupsDataStructure withId(String id) {
		
		this.id = id;
		return this;
		
	}
	
	
	public String getName() {
		return aname;
	}
	public String getHeader() {
		return header;
	}
	public String getFooter() {
		return footer;
	}
	
	
	public GroupsDataStructure setAname(String aname) {
		this.aname = aname;
		return this;
	}

	public GroupsDataStructure setHeader(String header) {
		this.header = header;
		return this;
	}

	public GroupsDataStructure setFooter(String footer) {
		this.footer = footer;
		return this;
	}

	public void setId(String id) {
		this.id = id;
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

	public GroupsDataStructure withName(String aname) {	  
		this.aname = aname;
		return this;
	}
	public int compareTo(GroupsDataStructure o) {
		 
		return this.aname.toLowerCase().
				compareTo(o.aname.toLowerCase());
	}
	public GroupsDataStructure withHeader(String header) {
		this.header = header;
		return this;
	}
	public GroupsDataStructure withFooter(String Footer) {
 
		this.footer = Footer;
		return this;
	}
	 
}