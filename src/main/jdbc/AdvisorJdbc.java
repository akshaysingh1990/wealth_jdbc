package main.jdbc;

import main.model.Advisor;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AdvisorJdbc extends CommonJdbc {

	public void create(Advisor advisor) throws SQLException {
       PreparedStatement st;
		if (advisor.getId() == null) {
			String sql = "insert into Advisor(name,age) values(?,?,?)";

			 st = connection.prepareStatement(sql);

			String name = advisor.getName();
			int age = advisor.getAge();

			st.setString(1, name);
			st.setInt(2, age);

		} else {
			String sql = "insert into Advisor(id,name,age) values(?,?,?) ";

			 st = connection.prepareStatement(sql);

			String name = advisor.getName();
			int age = advisor.getAge();
			Long id = advisor.getId();
			st.setString(2, name);
			st.setInt(3, age);
			st.setLong(1, id);

		}
st.executeUpdate();
	}

	public void view() throws SQLException {

		String sql = "select * from Advisor";
		PreparedStatement st = connection.prepareStatement(sql);

		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getInt("id") + "   " + rs.getString("name") + "   " + rs.getInt("age")+"   "+rs.getInt("TotalTransactionAmount"));
		}

	}

	public void delete(int id) throws SQLException {

		String sql = " delete from advisor where id =?";

		PreparedStatement st = connection.prepareStatement(sql);

		st.setInt(1, id);
		st.executeUpdate();

	}

	public void edit(int id) throws SQLException {

		Scanner scanner = new Scanner(System.in);

		Advisor advisor = getAdvisorById(id);

		delete(id);

		System.out.println("Press 1 to change advisor name  OR");
		System.out.println("Press 2 to change advisor age  ");
		int option = scanner.nextInt();
		if (option == 1) {
			System.out.println("Enter Name");
			scanner.nextLine();
			String name = scanner.nextLine();
			advisor.setName(name);
			create(advisor);
		}

		else if (option == 2) {
			System.out.println("Enter age");
			int age = scanner.nextInt();
			advisor.setAge(age);
			create(advisor);
		} else
			System.out.println("Wrong option entered");

	}

	public Advisor getAdvisorById(int id) throws SQLException {
		String sql = "Select * from Advisor where id = ?";

		PreparedStatement st = connection.prepareStatement(sql);

		st.setInt(1, id);
		ResultSet rs = st.executeQuery();
		Advisor advisor = new Advisor();
		rs.next();
		advisor.setName(rs.getString("name"));
		advisor.setId(rs.getLong("id"));
		advisor.setAge(rs.getInt("age"));
		return advisor;
	}
	

	
}