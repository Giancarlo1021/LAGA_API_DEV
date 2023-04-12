package net.javaguides.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCPostgreSQLConnect {
	// jdbc url - Location of database in memory.
	// jdbc user - User who owns database.
	// jdbc password - Password of user who owns database.

	// Added environment variables to DB
	// edited code here so it can use those variabels to connect to DB
	private static final String url = System.getenv("DATABASE_URL");
	private static final String user = System.getenv("DATABASE_USER");
	private static final String password = System.getenv("DATABASE_PASSWORD");
	private static Connection connection = null;
	
	public static Connection connect() {
		
		try {
			//Class.forName("postgresql-42.6.0");
			connection = DriverManager.getConnection(url, user, password);
			if (connection != null) {
				System.out.println("Connected to PostgreSQL server successfully!");
			} else {
				System.out.println("Failed to connect to PostgreSQL server.");
			}
			
			/*
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT VERSION()");
			if(resultSet.next()) {
				System.out.println(resultSet.getString(1));
			}
			*/
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public static void main(String[] args) {
		JDBCPostgreSQLConnect sqlConnect = new JDBCPostgreSQLConnect();
		sqlConnect.connect();
	}
}
