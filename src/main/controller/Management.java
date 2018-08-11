package main.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import main.model.Customer;
import main.service.AdvisorService;
import main.service.CommonService;
import main.service.CustomerService;

import main.connection.ConnectionManager;

public class Management {
	
	private static AdvisorService advisorService = new AdvisorService();
	private static CustomerService customerService = new CustomerService();

	public static void main(String[] args) throws SQLException {
		
		
		//ERROR ERROR ERROR   HOW TO AUTO SHIFT ID WHEN YOU DELETE SOMETHING
		//RIGHT NOW IN OUR CUSTOMER TABLE ID=1 IS NOT THERE
		//THOUGHT: CAN WE WRITE A CHECK METHOD FOR USER INPUT IN MY CASE I WANT TO SAY 
		//THAT YOUR ENTERED ID IS WRONG (PROVIDED YOUR CONDITIONS CHANGED FREQUENTLY IN THIS
		//CASE THE ID ARE CONSTANTLY CHANGING BY INSERTING AND DELETING CUSTOMERS)
		
		
		

		for (int i = 0; i < 100;) {
			System.out.println("Press 1 to view details of all advisors");
			System.out.println("Press 2 to view details of all customers");
			System.out.println("Press 3 to add details for new advisor");
			System.out.println("Press 4 to add details for new customers");
			System.out.println("Press 5 to delete  advisor");
			System.out.println("Press 6 to delete  customer");
			System.out.println("Press 7 to edit existing advisor");
			System.out.println("Press 8 to edit existing customer");
			System.out.println("Press 9 to get all info");

			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();
			if (choice == 1) {
				advisorService.view();
			} else if (choice == 2) {
				customerService.view();
			} else if (choice == 3) {
				advisorService.create();
			} else if (choice == 4) {
				customerService.create();
			
			} else if (choice == 5) {
				advisorService.delete();
			} else if (choice == 6) {
				customerService.delete();
			} else if (choice == 7) {
				advisorService.edit();
			} else if (choice == 8) {
				customerService.edit();
			}
			//else if (choice == 9) {
			//	advisorService.getAll();
			//}
			else {
				System.out.println("you enter the wrong details");

			}
			System.out.println("Press enter to continue the application");
			scanner.nextLine();
			String name = scanner.nextLine();
			if (name.equals("")) {
				i++;
			} else {
				System.exit(0);
			}


		
		
		

	}

}}
