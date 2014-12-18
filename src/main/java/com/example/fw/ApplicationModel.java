package com.example.fw;

import java.util.List;

import com.example.tests.ContactsDataStructure;
import com.example.tests.GroupsDataStructure;
import com.example.utils.SortedListOf;

public class ApplicationModel {

	private SortedListOf<GroupsDataStructure> groups;
	private SortedListOf<ContactsDataStructure> contacts;
	
	
	public SortedListOf<GroupsDataStructure>  getGroups()
	{ 
		return this.groups; 
		}
	
	public SortedListOf<ContactsDataStructure>  getContacts(){
		return this.contacts; 
		}
	
	
public void setContacts (List<ContactsDataStructure> conts) {	
	this.contacts =new SortedListOf<ContactsDataStructure> (conts);
	}	
	

public ApplicationModel addContact(ContactsDataStructure obj) {
	this.contacts.add(obj);
	return this;
	}


public ApplicationModel removeContact(int index) {
	this.contacts.remove(index);
	return this;
	}
	

	
public void setGroups(List<GroupsDataStructure>  groups) {
	  
	this.groups =new SortedListOf<GroupsDataStructure>( groups);
		 
	}


public ApplicationModel addGroup(GroupsDataStructure obj) {
	this.groups.add(obj);
	return this;
	}


public ApplicationModel removeGroup(int index) {
		this.groups.remove(index);
	return this;
	}
}