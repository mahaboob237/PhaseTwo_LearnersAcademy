package com.dbutil;

import java.sql.Connection;




import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Userdao {
public static Connection getConnection() {
	String userNameDB = "";
    String passwordDB = "";

	Connection connection = null;
	try {

		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/learnersacademy", "root",
				"Mahaboob@237");
		Statement st = connection.createStatement(); //Statement is used to write queries. Read more about it.
	       ResultSet resultSet = st.executeQuery("select userName,password from users"); //the table name is users and userName,password are columns. Fetching all the records and storing in a resultSet.

	    while(resultSet.next()) // Until next row is present otherwise it return false
	    {
	     userNameDB = resultSet.getString("userName"); //fetch the values present in database
	     passwordDB = resultSet.getString("password");
	    }
	}
	 catch (Exception ex) {
		System.out.println("Exception Raised...");
		System.out.println(ex.getMessage());
	}
	return connection;
}
}