package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws IOException {
		String url = "jdbc:mysql://localhost/servicedesk?user=alunos&password=alunos&useSSL=false";
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			throw new IOException(e);
		}
		return conn;
	}
}
