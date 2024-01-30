package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
		private static final String URL = "jdbc:mysql://localhost:3306/";
		private static final String USER = "root";
		private static final String PASSWORD = "";
		
		public static Connection conectar() {
			Connection con = null;
			try {
				con = DriverManager.getConnection(URL, USER, PASSWORD);
				System.out.println("Conectado com sucesso!");
			} catch (SQLException e) {
				System.out.println("Erro ao conectar!"+e.getMessage());
			}
				
			return con;
		}
		
}
