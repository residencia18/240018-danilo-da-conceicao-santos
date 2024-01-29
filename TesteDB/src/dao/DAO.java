package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
	private static final String URL = "jdbc:mysql://u3t374rdnumbidyw:DHxlRjT1SN6vwm64DYx0@bum9pj3nd8ex8q8apzfz-mysql.services.clever-cloud.com:3306/bum9pj3nd8ex8q8apzfz";
	private static final String USER = "u3t374rdnumbidyw";
	private static final String PASSWORD = "DHxlRjT1SN6vwm64DYx0";
	
	public static Connection conectar() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Conectado com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro ao conectar!");
		}
		return con;
	}
}
