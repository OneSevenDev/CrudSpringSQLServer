package com.oneseven.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDatabase {
	private static final String HOST = "localhost:1433";
	private static final String DATABASE = "company";
	private static final String USER = "sa";
	private static final String PASSWORD = "12345678";

	private Connection connection = null;

	public ConnectionDatabase() {
		// TODO Auto-generated constructor stub
	}

	private static ConnectionDatabase _instance;

	public static ConnectionDatabase Instance() {
		if (_instance == null)
			_instance = new ConnectionDatabase();
		return _instance;
	}

	public Connection getConnection() throws Exception {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(
					"jdbc:sqlserver://".concat(HOST).concat(";databaseName=".concat(DATABASE)), USER, PASSWORD);
		} catch (Exception e) {
		}
		return connection;
	}
	
}
