package dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Reembolso;
public class ReembolsoDAO {
	public static boolean create(Reembolso reembolso) {
		DAO dao = new DAO();
		Connection con = dao.conectar();
		String query = "INSERT INTO Reembolso (valor, data) VALUES (?, ?)";
		try(PreparedStatement stmt = con.prepareStatement(query)) {
			stmt.setFloat(1, reembolso.getValor());
			stmt.setDate(2, Date.valueOf(reembolso.getData()));
			stmt.execute();
			return true;
		}catch (SQLException e) {
			System.out.println("Erro ao adicionar " + e);
		}
		return false;
	}
	
	public static ArrayList<Reembolso> readAll(){
		DAO dao = new DAO();
		Connection con = dao.conectar();
		String query = "SELECT valor, data FROM Reembolso";
		try(PreparedStatement stmt = con.prepareStatement(query)) {
			ArrayList<Reembolso> lista = new ArrayList<Reembolso>();
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Reembolso reembolso = new Reembolso(0, null);
				reembolso.setValor(rs.getFloat("valor"));
				reembolso.setData(rs.getDate("data").toLocalDate());
				lista.add(reembolso);
				
			}
			return lista;
		}catch (SQLException e) {
			System.out.println("Erro ao adicionar " + e);
		}
		return null;
	}
	public static Reembolso readById(String id){
		ArrayList<Reembolso> lista = new ArrayList<>();
		DAO dao = new DAO();
		Connection con = dao.conectar();
		String query = "SELECT valor, data FROM Reembolso WHERE id = ?";
		try(PreparedStatement stmt = con.prepareStatement(query)) {
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				Reembolso reembolso = new Reembolso(0, null);
				reembolso.setValor(rs.getFloat("valor"));
				reembolso.setData(rs.getDate("data").toLocalDate());
				lista.add(reembolso);
				return reembolso;
			}else {
				
				return null;			
			}
		}catch (SQLException e) {
			System.out.println("Erro ao adicionar " + e);
		}
		return null;		
	}
			
	public static boolean update(Reembolso reembolso) {
		try {
			DAO dao = new DAO();
			Connection con = dao.conectar();
			String query = "UPDATE Reembolso SET valor = ?, data = ? WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setFloat(1, reembolso.getValor());
			stmt.setDate(2, Date.valueOf(reembolso.getData()));
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
			String query = "DELETE FROM Reembolso WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, id);
			stmt.execute();
			return true;
		} catch (SQLException e) {
			System.out.println("Erro ao deletar " + e);
		}
		return false;
	}
	
}
