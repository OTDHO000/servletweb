/**
 * 
 */
package com.figo.study.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.figo.study.dao.UserDAO;
import com.figo.study.model.User;

/**
 * @author figo
 *
 */
public class UserDAOImpl implements UserDAO {

	@Override
	public boolean login(User user) {
		// TODO Auto-generated method stub
		String sql = "select * from users where name='" + user.getUserName() + "' and password='" + user.getUserPwd()
				+ "'";
		return executeSql(sql);
	}

	public boolean executeSql(String sql) {
		boolean isTure = false;
		// 驱动程序名
		String driver = "com.mysql.jdbc.Driver";
		// URL指向要访问的数据库名world
		String url = "jdbc:mysql://127.0.0.1:33066/study";
		// MySQL配置时的用户名
		String user = "root";
		// MySQL配置时的密码
		String password = "123456";
		String name;
		try {
			// 加载驱动程序
			Class.forName(driver);
			// 连续数据库
			Connection conn = DriverManager.getConnection(url, user, password);
			if (!conn.isClosed())
				System.out.println("Succeeded connecting to the Database!");
			// statement用来执行SQL语句
			Statement statement = conn.createStatement();
			// 要执行的SQL语句
			// String sql = "select * from city";
			// 结果集
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				// // 选择Name这列数据
				// name = rs.getString("Name");
				// // 输出结果
				// System.out.println(rs.getString("CountryCode") + "\t" +
				// name);
				isTure = true;
			}

			rs.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			System.out.println("Sorry,can`t find the Driver!");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return isTure;
	}

}
