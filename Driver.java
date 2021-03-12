package main;

import java.util.Scanner;

import models.Student;

public class Driver {

	public static void main(String[] args) {

	Student stud  = new Student();
	
	Scanner input = new Scanner(System.in);
	
	
	System.out.println(" Enter ID");
	
	String id= input.next();
	
	System.out.println(" Enter Name");

	String name= input.next();

	stud.create(id, name);
	stud.readAll(); 
	
	System.out.println(" Enter ID to be updated");
	
	String updateId= input.next();
	
	System.out.println(" Enter Name to be updated");

	String updateName= input.next();
	
	stud.update(updateId, updateName);
	stud.readAll(); 
	System.out.println(" Enter ID you want to delete");
	
	String deletedId= input.next();
	stud.delete(deletedId);
	
	stud.readAll();
	
	
	}

}
