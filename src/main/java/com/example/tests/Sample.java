package com.example.tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.example.fw.ApplicationManager;
import com.example.fw.JdbcHelper;

public class Sample {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		

		String props = System.getProperty("config", "application.properties");		
		Properties prop = new Properties();
		prop.load( new FileReader ( new File(props)));
		ApplicationManager app = new ApplicationManager(prop);
		
		//JDBC		
		//JdbcHelper jdbc = new JdbcHelper(app, "jdbc:mysql://localhost/addressbook?user=root&password=123");
		//System.out.println(jdbc.listGroups());
		//addressbook - это название базы
	
		//Hibernate
		System.out.println(app.GetHibernateHelper().listContacts());
		
		
	}

}
