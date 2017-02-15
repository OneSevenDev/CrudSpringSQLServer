package com.oneseven.viewModels;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.oneseven.models.Employee;
import com.oneseven.models.Position;

public class Employees {
	public Employees() {
		// TODO Auto-generated constructor stub
	}

	private static Employees _instance;

	public static Employees Instance() {
		if (_instance == null)
			_instance = new Employees();
		return _instance;
	}

	public ArrayList<Employee> listEmployee() throws Exception {
		Connection conn = null;
		Employee e = null;
		Position p = null;
		CallableStatement callableStatement = null;
		ResultSet resultSet = null;
		ArrayList<Employee> list = new ArrayList<Employee>();
		try {
			conn = ConnectionMysql.Instance().getConnection();
			callableStatement = conn.prepareCall(
					"SELECT EmployeeId,Name,LastName,Age,PositionID,PositionName FROM Employee INNER JOIN Position ON Position_Id = PositionID;");
			resultSet = callableStatement.executeQuery();
			while (resultSet.next()) {
				e = new Employee();
				e.setId(resultSet.getInt("EmployeeId"));
				e.setNombres(resultSet.getString("Name"));
				e.setApellidos(resultSet.getString("LastName"));
				e.setEdad(resultSet.getInt("Age"));

				// Se ingresa el nombre del cargo a la entidad de Position para
				// lograr insertarlos dentro de la entidad Employee
				p = new Position();
				p.setId(resultSet.getInt("PositionID"));
				p.setNombrecargo(resultSet.getString("PositionName"));
				e.setCargo(p);

				list.add(e);
			}
		} catch (Exception ex) {
			throw ex;
		} finally {
			conn.close();
			callableStatement.close();
			resultSet.close();
		}
		return list;
	}

	public boolean InsertEmployee(Employee e) throws Exception {
		Connection conn = null;
		CallableStatement statement = null;
		boolean result = false;
		try {
			conn = ConnectionMysql.Instance().getConnection();
			statement = conn.prepareCall("INSERT INTO Employee(Name,LastName,Age,Position_Id) VALUES (?,?,?,?)");
			statement.setString(1, e.getNombres());
			statement.setString(2, e.getApellidos());
			statement.setInt(3, e.getEdad());
			statement.setInt(4, e.getCargo().getId());
			result = !statement.execute();
		} catch (Exception ex) {
			throw ex;
		} finally {
			conn.close();
			statement.close();
		}

		return result;
	}

	public boolean deleteEmployee(int id) throws Exception {
		Connection conn = null;
		CallableStatement statement = null;
		boolean result = false;
		try {
			conn = ConnectionMysql.Instance().getConnection();
			statement = conn.prepareCall("DELETE FROM Employee WHERE EmployeeId = ?");
			statement.setInt(1, id);
			result = !statement.execute();
		} catch (Exception ex) {
			throw ex;
		} finally {
			conn.close();
			statement.close();
		}
		return result;
	}

	public boolean EditEmployee(Employee e) throws Exception {
		Connection conn = null;
		CallableStatement statement = null;
		boolean result = false;
		try {
			conn = ConnectionMysql.Instance().getConnection();
			statement = conn
					.prepareCall("UPDATE Employee SET Name=?,LastName=?,Age=?, Position_Id = ? WHERE EmployeeId = ?");
			statement.setString(1, e.getNombres());
			statement.setString(2, e.getApellidos());
			statement.setInt(3, e.getEdad());
			statement.setInt(4, e.getCargo().getId());
			statement.setInt(5, e.getId());
			result = !statement.execute();
		} catch (Exception ex) {
			throw ex;
		} finally {
			conn.close();
			statement.close();
		}

		return result;
	}

	public Employee SearchEmployee(int id) throws Exception {
		Connection conn = null;
		Employee e = null;
		Position p = null;
		CallableStatement callableStatement = null;
		ResultSet resultSet = null;
		try {
			conn = ConnectionMysql.Instance().getConnection();
			// Enviando Consulta
			callableStatement = conn.prepareCall(
					"SELECT EmployeeId,Name,LastName,Age,PositionID,PositionName FROM Employee INNER JOIN Position ON Position_Id = PositionID WHERE EmployeeId = ?");
			callableStatement.setInt(1, id);
			resultSet = callableStatement.executeQuery();

			while (resultSet.next()) {
				e = new Employee();
				e.setId(resultSet.getInt("EmployeeId"));
				e.setNombres(resultSet.getString("Name"));
				e.setApellidos(resultSet.getString("LastName"));
				e.setEdad(resultSet.getInt("Age"));

				// Se ingresa el nombre del cargo a la entidad de Position para
				// lograr insertarlos dentro de la entidad Employee
				p = new Position();
				p.setId(resultSet.getInt("PositionID"));
				p.setNombrecargo(resultSet.getString("PositionName"));
				e.setCargo(p);
			}
		} catch (Exception ex) {
			throw ex;
		} finally {
			conn.close();
			callableStatement.close();
			resultSet.close();
		}
		return e;
	}
}
