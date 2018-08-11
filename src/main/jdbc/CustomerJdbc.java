package main.jdbc;

import java.sql.PreparedStatement;

import main.model.Advisor;
import main.model.Customer;
import java.sql.Connection;

import main.connection.ConnectionManager;

import main.jdbc.AdvisorJdbc;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CustomerJdbc extends CommonJdbc {
	
	
	public void create(Customer customer) throws SQLException {
		
		PreparedStatement st;
		

		String name = customer.getName();
		int age = customer.getAge();
		int totalAmount = customer.getTotalAmount();
		int advisorId = customer.getAdvisorId();

		
		
		
		
		
		
		if (customer.getId() == null) {
			String sql = "insert into customer(name,age,totalAmount,advisor) values(?,?,?,?)";

			 st = connection.prepareStatement(sql);

			st.setString(1, name);
			st.setInt(2, age);
			st.setInt(3, totalAmount);
			st.setInt(4, advisorId);


		} else {
			String sql = "insert into customer(id,name,age,totalAmount,advisor) values(?,?,?,?,?) ";

			 st = connection.prepareStatement(sql);

		
			Long id = customer.getId();
		
			
			
			st.setString(2, name);
			st.setInt(3, age);
			st.setLong(1, id);
			st.setInt(4, totalAmount);
			st.setInt(5, advisorId);


		}
	
	st.executeUpdate();
	
	
	
	
	}	
	
	public void view() throws SQLException {

		String sql = "select * from Customer";
		PreparedStatement st = connection.prepareStatement(sql);

		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getInt("id") + "   " + rs.getString("name") + "   " + rs.getInt("age")+"   "+rs.getInt("totalAmount") + "   "+rs.getInt("advisor"));
		}

	}
	public void delete(int id) throws SQLException {

		String sql = " delete from customer where id =?";

		PreparedStatement st = connection.prepareStatement(sql);

		st.setInt(1, id);
		st.executeUpdate();

	}
	public void edit(int id) throws SQLException {

		Scanner scanner = new Scanner(System.in);

        Customer customer = getCustomerById(id);

        delete(id);

		System.out.println("Press 1 to change customer name  OR");
		System.out.println("Press 2 to change customer age OR ");
		System.out.println("Press 3 to change customer Total Amount ");

		int option = scanner.nextInt();
		if (option == 1) {
			System.out.println("Enter Name");
			scanner.nextLine();
			String name = scanner.nextLine();
			customer.setName(name);
			create(customer);
		}

		else if (option == 2) {
			System.out.println("Enter age");
			int age = scanner.nextInt();
			customer.setAge(age);
			create(customer);
		} 
		else if (option == 3) {
			System.out.println("Enter Total amount");
			int totalAmount = scanner.nextInt();
			customer.setTotalAmount(totalAmount);
			create(customer);
		}
		
		else
			System.out.println("Wrong option entered");

	}

	
	public Customer getCustomerById(int id) throws SQLException {
		String sql = "Select * from Customer where id = ?";

		PreparedStatement st = connection.prepareStatement(sql);

		st.setInt(1, id);
		ResultSet rs = st.executeQuery();
		Customer customer = new Customer();
		rs.next();
		customer.setName(rs.getString("name"));
		customer.setId(rs.getLong("id"));
		customer.setAge(rs.getInt("age"));
		customer.setTotalAmount(rs.getInt("totalAmount"));
		customer.setAdvisorId(rs.getInt("advisor"));
		return customer;
	}
	
	public void totalTransactionAmount(int id) throws SQLException {

	String sql ="Select * from Customer where advisor =? ";
	PreparedStatement st = connection.prepareStatement(sql);
	st.setInt(1, id);
	ResultSet rs = st.executeQuery();
	int amount = 0;
	while(rs.next()) {
		amount = amount +rs.getInt("totalAmount");
	}

	AdvisorJdbc advisorJdbc = new AdvisorJdbc();
	advisorJdbc.getAdvisorById(id).setTotalTransactionAmount(amount);
	
	String sql2 ="update Advisor set TotalTransactionAmount = ? where id =?"; 
	PreparedStatement st2 = connection.prepareStatement(sql2);

	st2.setInt(1, amount);
	st2.setInt(2, id);

	st2.executeUpdate();

	}
	
	
}
	
	
	
	
	

