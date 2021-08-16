package com.tcs.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo {
	public static void main(String[] args) {
		String DB_URL = "jdbc:mysql://localhost/practice";
		String DB_USER = "root";
		String DB_PASSWORD = "Nuvelabs123$";
		try(Connection connection = DriverManager.getConnection(DB_URL ,DB_USER, DB_PASSWORD);
				Statement statement = connection.createStatement();){
			//Create(statement);
			Update(statement);
			List<String> regions = Reterive(statement);
			System.out.println(regions);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
			
		
	}

	/**
	 * @param statement
	 * @throws SQLException 
	 */
	private static void Update(Statement statement) throws SQLException {
		statement.executeUpdate("UPDATE regions set region_id = 7 where region_name = 'Antartica'");
	}
 
	private static List<String> Reterive(Statement statement) throws SQLException {
		ResultSet resultset = statement.executeQuery("SELECT * from regions where region_name LIKE '%A%' order by region_name DESC");
		List<String> regions = new ArrayList<String>();
		while(resultset.next()) {
			//System.out.println(resultset.getInt(1));
			//System.out.println(resultset.getNString("REGION_NAME"));
			regions.add(resultset.getNString("REGION_NAME"));
		}
		return regions;
		
	}

	private static void Create(Statement statement) throws SQLException {
		statement.execute("INSERT INTO REGIONS VALUES(6 , 'North America')");
	}
}
