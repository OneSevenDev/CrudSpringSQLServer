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
	
	/*public ConnectionMysql() {
		// TODO Auto-generated constructor stub
	}

	// Usando el patron singleton se crea una variable donde se guarde la
	// instancia de la clase
	private static ConnectionMysql _Instance;

	public static ConnectionMysql Instance() {
		// Se comprueba que no exista la instancia para crearla, en el caso que
		// exista se devuelve la misma instancia
		if (_Instance == null) 
			_Instance = new ConnectionMysql();
		
		return _Instance;
	}

	public Connection getConnection() throws Exception {
		Connection con = null;
		try {
			String url = "jdbc:mysql://127.0.0.1/empresa";
			String user = "root";
			String key = "12345678";
			
			//Para Mysql; si se desea usar SQLServer seria: Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection(url, user, key);

			System.out.println("Exito conexion BD");
		} catch (Exception e) {
			System.out.println("Error conexion BD " + e.getMessage());
			throw e;
		}
		return con;
	}*/
}
