package com.tcs.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {
	public static void main(String[] args) {
		String DB_URL = "jdbc:mysql://localhost/practice";
		String DB_USER = "root";
		String DB_PASSWORD = "Nuvelabs123$";
		try(Connection connection = DriverManager.getConnection(DB_URL ,DB_USER, DB_PASSWORD);
				Statement statement = connection.createStatement();){
			Create(statement);
			Reterive(statement);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
			
		
	}

	private static void Reterive(Statement statement) throws SQLException {
		ResultSet resultset = statement.executeQuery("SELECT * from regions");
		while(resultset.next()) {
			System.out.println(resultset.getInt(1));
			System.out.println(resultset.getNString("REGION_NAME"));
		}
		
	}

	private static void Create(Statement statement) throws SQLException {
		statement.execute("INSERT INTO REGIONS VALUES(6 , 'North America')");
	}
}
