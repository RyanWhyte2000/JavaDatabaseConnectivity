package main;

import java.util.Scanner;

import models.Student;

public class Driver {

	public static void main(String[] args) {
		Student stud  = new Student();
		Scanner in = new Scanner(System.in);
		int choice=0;
		do {
			System.out.println("1. Create ");
			System.out.println("2. Readall ");
			System.out.println("3. Update");
			System.out.println("4. Delete");
			System.out.println("5. Exit ");
			
			
			choice= in.nextInt();
			
			switch(choice) {
			
			case 1:
				System.out.println(" Enter ID");

				String id= in.next();

				System.out.println(" Enter first  Name");

				String firstName= in.next();
			
				System.out.println(" Enter last  Name");

				String lastName= in.next();

				System.out.println(" Enter email");

				String email= in.next();


				stud.create(id, firstName, lastName, email);
				
				break;
			case 2:
				stud.readAll(); 

				
				break;
			case 3:
				System.out.println(" Enter ID to be updated");

				String updateId= in.next();

				System.out.println(" Enter Name to be updated");

				String updateName= in.next();

				stud.update(updateId, updateName);
				break;
			case 4:
				System.out.println(" Enter ID you want to delete");

				String deletedId= in.next();
				stud.delete(deletedId);

				stud.readAll();
				break;
		
			case 5:
					System.out.println(" Exiting........");
				break;
			}
			
		}while (choice !=5);
	



	}

}
