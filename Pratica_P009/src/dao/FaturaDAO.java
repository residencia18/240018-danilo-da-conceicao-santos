package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Fatura;

public class FaturaDAO {
	public static boolean create(Fatura fatura) {
		DAO dao = new DAO();
		Connection con = dao.conectar();
		String query = "INSERT INTO Fatura (data, ultimaLeitura, penultimaLeitura, valor,estadoPagamento) VALUES (?, ?, ?, ?, ?)";
		
		try(PreparedStatement stmt = con.prepareStatement(query)) {
			Date dataSql = Date.valueOf(fatura.getData());
		    stmt.setDate(1, dataSql);
			stmt.setFloat(2, fatura.getUltimaLeitura());
			stmt.setFloat(3, fatura.getPenultimaLeitura());
			stmt.setFloat(4, fatura.getValor());
			stmt.setBoolean(5, fatura.getEstadoPagamento());
			stmt.execute();
			System.out.println(stmt.toString());
		}catch (SQLException e) {
			System.out.println("Erro ao adicionar " + e);
		}
		return false;
	}
}
