package com.todo.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class TodoDAOImpl  implements TodoDAO{
	
	private static TodoDAOImpl instance = new TodoDAOImpl();
	public static TodoDAOImpl getInstance() {
		return instance;
	}
	
	private Connection getConnection() throws Exception{
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/react");
		return ds.getConnection();
	}

	@Override
	public void insert(Todo todo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Todo> list() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<Todo> arr = new ArrayList<Todo>();
		try {
			con =getConnection();
			String sql = "select * from todo";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Todo todo = new Todo();
				todo.setName(rs.getString("name"));
				todo.setNum(rs.getLong("num"));
				todo.setRegdate(rs.getDate("regdate"));
				todo.setSubject(rs.getString("subject"));
				todo.setSummary(rs.getString("summary"));
				arr.add(todo);
			}
		} catch (Exception e) {
				e.printStackTrace();
		}finally {
			//´Ý±â ¸Þ¼Òµå
		}
		return arr;
	}

}
