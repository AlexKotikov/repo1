package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.thoughtworks.xstream.XStream;

public class ContactsGenerator {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("Welcome to Contacts Data Generator"	);
		
		
		
		if (args.length == 3 ) { 
		
			int amount = Integer.parseInt(args[0]); 
		     File file = new File(args[1]);
		      if (file.exists()) {
			 	System.out.println("File " + file + " already exists!");
			  	return; }
		     
		     
			 if (args[2].equals("csv")) 
			   {
				 GenerateCSVfile(amount, file);
			   }
			 	else 
			 		if (args[2].equals("xml")) 
					   {
			 			GenerateXMLfile(amount, file); 
					   }
					 	else System.out.println("unknown format " + args[2]);
		
		 System.out.println("File " + args[1] + " has been created.");
		} else 
			System.out.println("Please specify required parametrs" +
				"<amount> <filename> <format>(csv,xml)");

		 
	}
  
	protected static void GenerateXMLfile(int amount, File file) throws IOException {
		XStream stream = new XStream();
		FileWriter wr = new FileWriter(file);
		
		stream.alias("contact", ContactsDataStructure.class);
		List<ContactsDataStructure> contacts = new ArrayList<ContactsDataStructure>();
		
		for (int i=0; i < amount; i++){
		ContactsDataStructure contact = new ContactsDataStructure()
		  .withFirstName(GenNewString())
		  .withSecondName(GenNewString())
		  .withEmail1(GenNewString());
		
		contacts.add(contact);
		}
		
		String  str = stream.toXML(contacts);
		wr.write(str);
		wr.close();
	}
 
	protected  static List<ContactsDataStructure> loadXMLfile (File file)  {	
		XStream stream = new XStream();
		stream.alias("contact", ContactsDataStructure.class);	
		return  (List<ContactsDataStructure>) stream.fromXML(file); 
		
		 
		  	
	}
	
	protected  static List<ContactsDataStructure> loadCSVfile (File file) throws IOException {
		String a;
		
		FileReader fl = new  FileReader(file);
		BufferedReader reader = new  BufferedReader(fl);
		List<ContactsDataStructure> list  = new ArrayList<ContactsDataStructure>();
		 
		
		a = reader.readLine();
		 
		while (a != null) {
			
			String[] line = a.split(",");
			
			ContactsDataStructure  cont = new ContactsDataStructure()
			   .withFirstName(line[0])
			   .withSecondName(line[1])
			   .withEmail1(line[2])
			   .withMobile(line[3]);
			
			 list.add(cont);	
			 a = reader.readLine();
		}
		
		reader.close();
		return list;
	}
	
	private static void GenerateCSVfile(int amount, File file) throws IOException {
		 FileWriter wr =   new FileWriter(file);
		 StringBuilder a = new StringBuilder("");
		 
		 for (int i=0; i < amount; i++ )	{	 
			 for (int i2=0; i2 < 4; i2++ ){
				  a.append(GenNewString()+",");
				  }
				 
			 a.append("! \n");
			 wr.write(a.toString());
			 a.delete(0, a.length());
		 }
		 wr.close();		 
	}
         //генератор красивых имен и фамилий )
protected static String GenNewString() {
		 String abc ="abcdefghijaeiouklmnopqrstuvwxyz"; 
		 StringBuilder str = new StringBuilder("");
		 String a ="";
		 int  rnd = 0;  
		 
		 for (int i=0; i < ( 5 +(int) (Math.random() * (11 -5))); i++ ) 
		 {  
			 rnd  = (  (int) (Math.random() * (abc.length()  )));
			 
			 
			 if (i == 0) {
			 a =  Character.toString(abc.charAt(rnd));
			 a = a.substring(0,1).toUpperCase();
			 str.append(a); }
			 else     
				   str.append(abc.charAt(rnd));		 
		 }
	return  str.toString(); }
	 

	
	
}
