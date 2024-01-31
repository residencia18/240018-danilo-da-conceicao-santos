package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cliente.Cliente;

public class ClienteDAO {
	
	public static boolean create(Cliente cliente) {
		DAO dao = new DAO();
		Connection con = dao.conectar();
		String query = "INSERT INTO Cliente (nome, cpf) VALUES (?, ?)";
		
		try(PreparedStatement stmt = con.prepareStatement(query)) {
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCpf());
			stmt.execute();
			System.out.println(stmt.toString());
			return true;			
		}catch (SQLException e) {
			System.out.println("Erro ao adicionar " + e);
		}
		return false;
	}
	
	public static ArrayList<Cliente> readAll(){
		DAO dao = new DAO();
		Connection con = dao.conectar();
		String query = "SELECT nome, cpf FROM Cliente";
		try(PreparedStatement stmt = con.prepareStatement(query)) {
			ResultSet rs = stmt.executeQuery();
			ArrayList<Cliente> lista = new ArrayList<Cliente>();
			while(rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setNome(rs.getString("nome"));
				cliente.setCpf(rs.getString("cpf"));
				lista.add(cliente);
			}
			return lista;
		} catch (SQLException e) {
			System.out.println("Erro ao adicionar " + e);
		}
		return null;
	}
	
	public static Cliente readById(String id){
	    ArrayList<Cliente> lista = new ArrayList<>();
	    DAO dao = new DAO();
	    Connection con = dao.conectar();
	    String query = "SELECT nome, cpf FROM Cliente WHERE id = ?";
	    
	    try (PreparedStatement stmt = con.prepareStatement(query)) {
	        stmt.setString(1, id);
	        ResultSet rs = stmt.executeQuery();
	        
	        if (rs.next()) {
	            Cliente cliente = new Cliente();
	            cliente.setNome(rs.getString("nome"));
	            cliente.setCpf(rs.getString("cpf"));
	            lista.add(cliente);
	            return cliente;
	        } else {
	            // Nenhum resultado encontrado
	            return null;
	        }
	    } catch (SQLException e) {
	        System.out.println("Erro ao executar a consulta: " + e);
	    } finally {
	        try {
	            if (con != null) {
	                con.close();
	            }
	        } catch (SQLException e) {
	            System.out.println("Erro ao fechar a conexão: " + e);
	        }
	    }
	    
	    return null;
	}
	public static boolean update(Cliente cliente) {
		try {
			DAO dao = new DAO();
			Connection con = dao.conectar();
			String query = "UPDATE Cliente SET nome = ?, cpf = ? WHERE cpf = ?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCpf());
			stmt.setString(3, cliente.getCpf());
			 int linhasAfetadas = stmt.executeUpdate();

		        return linhasAfetadas > 0;

		} catch (SQLException e) {
			System.out.println("Erro ao atualizar " + e);
		}
		return false;
	}
	
	public static boolean delete(String cpf) {
		try {
	         DAO dao = new DAO();
	         Connection con = dao.conectar();
	         String query = "DELETE FROM Cliente WHERE cpf = ?";
	         PreparedStatement stmt = con.prepareStatement(query);
	     	
	         stmt.setString(1, cpf);
	         stmt.execute();
		} catch (SQLException e) {
			System.out.println("Erro ao deletar " + e);
		}
		return false;
	}


}
