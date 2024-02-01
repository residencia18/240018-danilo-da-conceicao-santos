package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Imovel;

public class ImovelDAO {
	public static boolean create(Imovel imovel) {
		DAO dao = new DAO();
		Connection con = dao.conectar();
		
		
		
		String query = "INSERT INTO Imovel (matricula, endereco, ultimaLeitura, penultimaLeitura, cliente) VALUES (?, ?, ?, ?, ?)";
		try(PreparedStatement stmt = con.prepareStatement(query)) {
			stmt.setString(1, imovel.getMatricula());
			stmt.setString(2, imovel.getEndereco());
			stmt.setFloat(3, imovel.getUltimaLeitura());
			stmt.setFloat(4, imovel.getPenultimaLeitura());
			stmt.setInt(5, imovel.getIdCliente());
			stmt.execute();
			System.out.println(stmt.toString());
			return true;
		} catch (SQLException e) {
			System.out.println("Erro ao adicionar " + e);
		}
		return false;
	}
	
	public static ArrayList<Imovel> readAll(){
		DAO dao = new DAO();
		Connection con = dao.conectar();
		String query = "SELECT matricula, endereco, ultimaLeitura, penultimaLeitura FROM Imovel";
		try(PreparedStatement stmt = con.prepareStatement(query)) {
			ArrayList<Imovel> lista = new ArrayList<Imovel>();
			ResultSet rs = stmt.executeQuery();
			Imovel imovel = new Imovel();
			while(rs.next()) {
				stmt.setString(1, imovel.getMatricula());
				stmt.setString(2, imovel.getEndereco());
				stmt.setFloat(3, imovel.getUltimaLeitura());
				stmt.setFloat(4, imovel.getPenultimaLeitura());
				stmt.setFloat(4, imovel.getIdCliente());
				lista.add(imovel);
				return lista;				
			}
		}catch (SQLException e) {
			System.out.println("Erro ao adicionar " + e);
			
		}
		return null;
	}
	
	public static Imovel readById(String matricula){
		DAO dao = new DAO();
		Connection con = dao.conectar();
		String query = "SELECT matricula, endereco, ultimaLeitura, penultimaLeitura FROM Imovel WHERE matricula = ?";
		try(PreparedStatement stmt = con.prepareStatement(query)) {
			stmt.setString(1, matricula);
			ResultSet rs = stmt.executeQuery();
			Imovel imovel = new Imovel();
			if(rs.next()) {
				imovel.setMatricula(rs.getString("matricula"));
				imovel.setEndereco(rs.getString("endereco"));
				imovel.setUltimaLeitura(rs.getFloat("ultimaLeitura"));
				imovel.setPenultimaLeitura(rs.getFloat("penultimaLeitura"));
				imovel.setIdCliente(rs.getInt("idCliente"));
				return imovel;
			}else {
				return null;
			}
		}catch (SQLException e) {
			System.out.println("Erro ao adicionar " + e);
		}
		return null;
	}
	public static boolean update(Imovel imovel) {
		DAO dao = new DAO();
		Connection con = dao.conectar();
		String query = "UPDATE Imovel SET matricula = ?, endereco = ?, ultimaLeitura = ?, penultimaLeitura = ? WHERE matricula = ?";
		
		try(PreparedStatement stmt = con.prepareStatement(query)) {
			stmt.setString(1, imovel.getMatricula());
			stmt.setString(2, imovel.getEndereco());
			stmt.setFloat(3, imovel.getUltimaLeitura());
			stmt.setFloat(4, imovel.getPenultimaLeitura());
			stmt.setString(5, imovel.getMatricula());
			stmt.execute();
		}catch (SQLException e) {
			System.out.println("Erro ao adicionar " + e);
		}
		return false;	
	}
	public static boolean delete(String matricula) {
		try {
			DAO dao = new DAO();
			Connection con = dao.conectar();
			String query = "DELETE FROM Imovel WHERE matricula = ?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, matricula);
			stmt.execute();
			return true;
		}catch (SQLException e) {
			System.out.println("Erro ao adicionar " + e);
		}
		return false;
	}
}
