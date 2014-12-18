package com.example.fw;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.tests.ContactsDataStructure;
import com.example.tests.GroupsDataStructure; 
import com.example.utils.SortedListOf;

public class HibernateHelper extends HelperBase {

	public HibernateHelper(ApplicationManager manager) {
	  super(manager);
	}

	public List<GroupsDataStructure> listGroups() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction trans = session.beginTransaction();
		try {
          return new SortedListOf<GroupsDataStructure>(
              (List<GroupsDataStructure>) session.createQuery("from GroupsDataStructure").list());
          						// мы указываем здесь не таблицу а тип объекта в который хотим извлечь
		} finally {
          trans.commit();
		}
	}
	
	public List<ContactsDataStructure> listContacts() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction trans = session.beginTransaction();
		try {
          return new SortedListOf<ContactsDataStructure>(
              (List<ContactsDataStructure>) session.createQuery("from ContactsDataStructure").list());
          						// мы указываем здесь не таблицу а тип объекта в который хотим извлечь
		} finally {
          trans.commit();
		}
	}
	
	
}
