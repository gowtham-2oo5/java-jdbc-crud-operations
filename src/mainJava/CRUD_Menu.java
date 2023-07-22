package mainJava;

import java.sql.SQLException;
import java.util.Scanner;

public class CRUD_Menu {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc=new Scanner(System.in);
		boolean loop=true;
		CRUD_Ops op=new CRUD_Ops();
		while(loop) {
			menu();
			System.out.println("Select your choice: ");
			int ch=sc.nextInt();
			switch(ch) {
			case 1:
				System.out.println("Enter name and regno");
				op.add(sc.next(),sc.nextLong());
				break;
			case 2:op.display();
				break;
			case 3:
				System.out.println("Enter student's id who's name should be updated");
				long rg=sc.nextLong();
				System.out.println("Enter new name: ");
				String s=sc.next();
				op.update(rg,s);
				break;
			case 4:
				System.out.println("Enter student's id who's data should be deleted");
				long reg=sc.nextLong();
				op.delete(reg);
				break;
			case 5:loop=false;
			System.out.println("Exited.");
				break;
			default:System.out.println("Invalid input try again..");
				break;
			}
		}
		sc.close();
	}

	private static void menu() {
		System.out.println("1. Add student (Name , regno)");
		System.out.println("2. Display all existing students");
		System.out.println("3. Update a student's name");
		System.out.println("4. Delete a student");
		System.out.println("5. Exit");
	}

}