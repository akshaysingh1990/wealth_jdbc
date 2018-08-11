package main.service;

import java.sql.SQLException;
import java.util.Scanner;

import main.jdbc.AdvisorJdbc;
import main.jdbc.CustomerJdbc;
import main.model.Customer;

public class CustomerService implements CommonService{
	
private Scanner scanner = new Scanner(System.in);
	
CustomerJdbc customerJdbc = new CustomerJdbc();

	public void create() throws SQLException{
		
		Customer customer = new Customer();
		
		System.out.println("Enter name");
		String name = scanner.nextLine();
		
		
		System.out.println("Enter age");
		int age = scanner.nextInt();
		
		
		System.out.println("Enter Total Amount");
		int amount = scanner.nextInt();
		
		System.out.println("Enter Advisor id");
		int advisorId = scanner.nextInt();
		
	customer.setName(name);
	customer.setAge(age);
	customer.setAdvisorId(advisorId);
	customer.setTotalAmount(amount);
		
	
		
		customerJdbc.create(customer);
		customerJdbc.totalTransactionAmount(advisorId);



		
		
	}
	
	public	void delete() throws SQLException{
System.out.println("Enter Customer Id you want to delete");
		
		int id = scanner.nextInt();
		
		customerJdbc.delete(id);
		
	}
	
	
	public	void edit() throws SQLException{
		
		System.out.println("Enter Customer Id you want to edit");

		int id = scanner.nextInt();
		
		
		customerJdbc.edit(id);
		customerJdbc.getCustomerById(id);
		
		customerJdbc.totalTransactionAmount(customerJdbc.getCustomerById(id).getAdvisorId())
;

		
	}
	
	public	void view() throws SQLException{
		
		
		customerJdbc.view();
		
	}
	
	
	
	
	
	

}
