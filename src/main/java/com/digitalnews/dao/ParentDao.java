package com.digitalnews.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.digitalnews.mapper.IRowMapper;

public class ParentDao<T> {

	public ParentDao() {

	}

	public Connection getConnection() throws ClassNotFoundException, SQLException, NamingException {

		Context ct = (Context) new InitialContext().lookup("java:/comp/env");

		Class.forName((String) ct.lookup("drivername"));
		String url = (String) ct.lookup("url");
		String user = (String) ct.lookup("username");
		String password = (String) ct.lookup("password");
		return DriverManager.getConnection(url, user, password);

	}

	public void closeConnection(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException {

		if(rs != null && !rs.isClosed()) {
			rs.close();
		}
		if(ps != null && !ps.isClosed()) {
			ps.close();
		}
		if(conn != null && !conn.isClosed()) {
			conn.close();
		}

	}

	public void setParameter(PreparedStatement st, Object... objects) throws SQLException {

		for (int i = 0; i < objects.length; i++) {
			Object ob = objects[i];
			int index = i + 1;
			if (ob instanceof Integer) {
				st.setInt(index, (Integer) ob);
			} else if (ob instanceof String) {
				st.setString(index, (String) ob);
			} else if (ob instanceof Date) {
				st.setDate(index, (Date) ob);
			}
		}

	}

	public <T> List<T> query(String sql, IRowMapper<T> rowMapper, Object... objects) throws Exception {

		List<T> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			conn = getConnection();
			statement = conn.prepareStatement(sql);
			setParameter(statement, objects);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				list.add(rowMapper.mapRow(resultSet));
			}
			return list;
		} catch (Exception e) {
			throw e;
		} finally {
			closeConnection(conn, statement, resultSet);
		}

		

	}

	public int count(String sql, Object... parameters) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int count = 0;
		
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			setParameter(statement, parameters);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				count = resultSet.getInt(1);
			}
		}catch (Exception e) {
			throw e;
			//chưa đảm bảo throw exception
		} finally {
			closeConnection(connection, statement, resultSet);
		}

		return count;

	}

}
