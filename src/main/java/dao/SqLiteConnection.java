package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class SqLiteConnection {

	public Connection getConnection() {
		Connection conn = null;

		try {
			Class.forName("org.sqlite.JDBC");
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			conn = DriverManager.getConnection("jdbc:sqlite:C:/Users/Gustavo/eclipse-workspace.6/Projeto_BACK_END/src/main/java/dao/Banco2.db");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}

}
