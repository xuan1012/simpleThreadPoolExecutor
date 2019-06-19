package com.jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest01 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/emall?useUnicode=true&characterEncoding=utf8", "root", "xuan1012");
			Statement statement = conn.createStatement();
			statement.executeLargeUpdate("insert into emall_user(username,password) values('xiaozhang','zhangsan')");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
