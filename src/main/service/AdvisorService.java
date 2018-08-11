package main.service;

import java.sql.SQLException;

import java.util.Scanner;

import main.jdbc.AdvisorJdbc;
import main.model.Advisor;

public class AdvisorService implements CommonService {

	private Scanner scanner = new Scanner(System.in);

	public void create() throws SQLException {

		Advisor advisor = new Advisor();

		System.out.println("Enter Name");
		String name = scanner.nextLine();

		System.out.println("Enter age");
		int age = scanner.nextInt();
		advisor.setName(name);
		advisor.setAge(age);

		AdvisorJdbc advisorJdbc = new AdvisorJdbc();

		advisorJdbc.create(advisor);

	}

	public void delete() throws SQLException  {
		
		System.out.println("Enter Advisor Id you want to delete");
		
		int id = scanner.nextInt();
		
		AdvisorJdbc advisorJdbc = new AdvisorJdbc();

		advisorJdbc.delete(id);
		
		
		

	}

	public void edit() throws SQLException {
		
		System.out.println("Enter Advisor Id you want to edit");

		int id = scanner.nextInt();
		
		AdvisorJdbc advisorJdbc = new AdvisorJdbc();
		
		advisorJdbc.edit(id);

		
//		System.out.println("Press 1 to change advisor name  OR");
	//	System.out.println("Press 2 to change advisor age  ");
		//int option = scanner

	}

	public void view() throws SQLException {
		AdvisorJdbc advisorJdbc = new AdvisorJdbc();

		advisorJdbc.view();

	}
	
	
	

}
