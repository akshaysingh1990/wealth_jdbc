package main.jdbc;

import java.sql.Connection;

import main.connection.ConnectionManager;

public class CommonJdbc  {
	
	ConnectionManager connectionManager = new ConnectionManager();
	
	Connection connection = connectionManager.getConnectiond();
	
	
	
	

}
