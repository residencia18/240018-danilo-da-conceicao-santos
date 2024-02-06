package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Pagamento;

public class PagamentoDAO {
	public static boolean create(Pagamento pagamento) {
		DAO dao = new DAO();
		Connection con = dao.conectar();
		String query = "INSERT INTO Pagamento (valor, data) VALUES (?, ?)";
		try(PreparedStatement stmt = con.prepareStatement(query)) {
			stmt.setFloat(1, pagamento.getValor());
			stmt.setDate(2, Date.valueOf(pagamento.getData()));
			stmt.execute();
			System.out.println(stmt.toString());
			return true;
		} catch (SQLException e) {
			System.out.println("Erro ao adicionar " + e);
		}
		return false;
	}
	
	public static ArrayList<Pagamento> readAll(){
		DAO dao = new DAO();
		Connection con = dao.conectar();
		String query = "SELECT valor, data FROM Pagamento";
		try(PreparedStatement stmt = con.prepareStatement(query)) {
			ResultSet rs = stmt.executeQuery();
			ArrayList<Pagamento> lista = new ArrayList<Pagamento>();
			while(rs.next()) {
				Pagamento pagamento = new Pagamento();
				pagamento.setValor(rs.getFloat("valor"));
				pagamento.setData(rs.getDate("data").toLocalDate());
				lista.add(pagamento);
			}
			return lista;
		}catch (SQLException e) {
			System.out.println("Erro ao adicionar " + e);
		}
		return null;
	}
	
	public static Pagamento readById(String id){
		ArrayList<Pagamento> lista = new ArrayList<>();
		DAO dao = new DAO();
		Connection con = dao.conectar();
		String query = "SELECT valor, data FROM Pagamento WHERE id = ?";
		try(PreparedStatement stmt = con.prepareStatement(query)) {
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				Pagamento pagamento = new Pagamento();
				pagamento.setValor(rs.getFloat("valor"));
				pagamento.setData(rs.getDate("data").toLocalDate());
				lista.add(pagamento);
				return pagamento;
			}else {
				return null;
			}
		}catch (SQLException e) {
			System.out.println("Erro ao adicionar " + e);
		}
		return null;
	}
	public static boolean update(Pagamento pagamento) {
		try {
			DAO dao = new DAO();
			Connection con = dao.conectar();
			String query = "UPDATE Pagamento SET valor = ?, data = ? WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setFloat(1, pagamento.getValor());
			stmt.setDate(2, Date.valueOf(pagamento.getData()));
			stmt.setString(3, pagamento.getId());
			stmt.execute();
			return true;
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar " + e);
		}
		return false;
	}
	
	public static boolean delete(String id) {
		try {
			DAO dao = new DAO();
			Connection con = dao.conectar();
			String query = "DELETE FROM Pagamento WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, id);
			stmt.execute();
			return true;
		}
		catch (SQLException e) {
			System.out.println("Erro ao deletar " + e);
		}
		return false;
	}
	
}

