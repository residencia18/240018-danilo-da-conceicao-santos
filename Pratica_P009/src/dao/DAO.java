package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
		private static final String URL = "jdbc:mysql://uxmohzcrtdbgkvbq:f3VqVHMXWPTTrsGBuhs1@b8lufxsoytqjuufdkzii-mysql.services.clever-cloud.com:3306/b8lufxsoytqjuufdkzii";
		private static final String USER = "uxmohzcrtdbgkvbq";
		private static final String PASSWORD = "f3VqVHMXWPTTrsGBuhs1";
		
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
