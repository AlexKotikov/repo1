package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.thoughtworks.xstream.XStream;

public class GroupGenerator {

	public static void main(String[] args) throws IOException {
		System.out.println(" == Welcome to Groups data generator == " );
		
		if (args.length < 3) 
			System.out.println("Enter 3 args: <amount>  <file_name> <format>(csv,xml) " );
		else{
		File file = new File(args[1]);
		
		if (file.exists()) {
			System.out.println("File " + file + " already exists!");
			return;
		}
			
		List <GroupsDataStructure> groups = generateRandomGroups(Integer.parseInt(args[0]));
		
		
		if (args[2].equals("csv"))
			saveGroupsToCSVFile(groups,file);
		else 
			if (args[2].equals("xml"))
				saveGroupsToXMLFile(groups,file);
			else 	
				System.out.println("unknown format: " + args[2]);
		
		System.out.println("File " + file + " has been done");
      
		}
	}

	public static List<GroupsDataStructure> generateRandomGroups(int amount) {
		List<GroupsDataStructure> list = new ArrayList<GroupsDataStructure>();
		 
		for (int i =0; i< amount; i++)
		{
		  GroupsDataStructure  gp = new GroupsDataStructure()
		  .withName(generateRandomString())
		  .withHeader(generateRandomString())
		  .withFooter(generateRandomString());
					
		list.add (gp);
		}	
		 	
		return list ;
		 
	}

	public static String generateRandomString (){
		Random rnd = new Random();	
		if (rnd.nextInt(2)==0)	 		
		 return  "";
		 else   
		        return  "random" + rnd.nextInt(); 		 
	}	
	
	private static void saveGroupsToCSVFile(List<GroupsDataStructure> groups, File file) throws IOException {
		   FileWriter writer = new FileWriter(file);		
		   for (GroupsDataStructure a : groups) {
			writer.write(a.getName() +","+ a.getHeader()+","+ a.getFooter()+",!"+"\n");
		} 
		writer.close();
	}
	
	public static List<GroupsDataStructure> loadGruopsFromCSVfile (File filename) throws IOException{
		List<GroupsDataStructure> list = new ArrayList<GroupsDataStructure>();
		
		FileReader reader = new FileReader(filename);
		BufferedReader bufferedReader = new BufferedReader	(reader);
		String line = bufferedReader.readLine();
		
		while (line != null) {
			String[] l = line.split(",");			
			GroupsDataStructure group  =new  GroupsDataStructure()
					.withName(l[0])
					.withHeader(l[1])
					.withFooter(l[2]);					
			line = bufferedReader.readLine();
			list.add(group);	
		}			 
		bufferedReader.close();
		return list;
	}
	
	
	public static void saveGroupsToXMLFile(List<GroupsDataStructure> groups,  File file) throws IOException {
		XStream  xStream = new XStream();
		
		xStream.alias("group", GroupsDataStructure.class);
		String xml = xStream.toXML(groups);
		 FileWriter writer = new FileWriter(file);
		 writer.write(xml);
		 writer.close();				 
	}

	
	public static List<GroupsDataStructure> loadGroupsFromXMLFile(File file) {
		XStream  xStream = new XStream();	
		xStream.alias("group", GroupsDataStructure.class);
		return (List<GroupsDataStructure> ) xStream.fromXML(file);
	}
}
