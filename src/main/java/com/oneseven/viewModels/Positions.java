package com.oneseven.viewModels;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.oneseven.models.Position;

public class Positions {
	public Positions() {
		// TODO Auto-generated constructor stub
	}

	private static Positions _instance;

	public static Positions Instance() {
		if (_instance == null)
			_instance = new Positions();
		return _instance;
	}
	
	public ArrayList<Position> listPosition() throws Exception{
		ArrayList<Position> list = new ArrayList<Position>();
		CallableStatement statement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		Position p = null;
		try {
			connection = ConnectionMysql.Instance().getConnection();
			statement = connection.prepareCall("SELECT PositionID, PositionName FROM Position ORDER BY PositionName");
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				p = new Position();
				p.setId(resultSet.getInt("PositionID"));
				p.setNombrecargo(resultSet.getString("PositionName"));
				list.add(p);
			}
		} catch (Exception ex) {
			throw ex;
		}
		return list;
	}
	public Position backPosition(int id) throws Exception {
		CallableStatement statement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		Position p = null;
		try {
			connection = ConnectionMysql.Instance().getConnection();
			statement = connection.prepareCall("SELECT PositionID, PositionName FROM Position WHERE PositionID = ? ORDER BY PositionName");
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				p = new Position();
				p.setId(resultSet.getInt("PositionID"));
				p.setNombrecargo(resultSet.getString("PositionName"));
			}
		} catch (Exception ex) {
			throw ex;
		}
		return p;
	}
}
