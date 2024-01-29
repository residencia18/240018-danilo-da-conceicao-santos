package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Usuario.Usuario;

public class UsuarioDAO {
	public static boolean create(Usuario usuario) {
		DAO dao = new DAO();
		Connection con = dao.conectar();
		String query = "INSERT INTO usuario (login, senha, email) VALUES (?, ?, ?)";
		
		try(PreparedStatement stmt = con.prepareStatement(query)) {
			stmt.setString(1, usuario.getLogin());
			stmt.setString(2, usuario.getSenha());
			stmt.setString(3, usuario.getEmail());
			stmt.execute();
			System.out.println(stmt.toString());
			return true;
		} catch (SQLException e) {
			System.out.println("Erro ao concectar " + e);
		}
		return false;
	}
	
	public static ArrayList<Usuario> readAll(){
		ArrayList<Usuario> lista = new  ArrayList<Usuario>();
		DAO dao = new DAO();
		Connection con = dao.conectar();
		String query = "SELECT login, senha, email FROM usuario";
		try(PreparedStatement stmt = con.prepareStatement(query)) {
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					Usuario usuario = new Usuario();	
					usuario.setLogin(rs.getString("login"));
					usuario.setSenha(rs.getString("senha"));
					usuario.setEmail(rs.getString("email"));
					lista.add(usuario);
				}
		} catch (SQLException e) {
			System.out.println("Erro ao adicionar " + e);
		}
		return lista;
	}
	
	public static Usuario readById(String login){
		ArrayList<Usuario> lista = new  ArrayList<Usuario>();
		DAO dao = new DAO();
		Connection con = dao.conectar();
		String query = "SELECT login, senha, Email FROM usuario WHERE login =?";
		try(PreparedStatement stmt = con.prepareStatement(query)) {
				ResultSet rs = stmt.executeQuery();
					stmt.setString(1, login);
					Usuario usuario = new Usuario();	
					usuario.setLogin(rs.getString("login"));
					usuario.setSenha(rs.getString("senha"));
					usuario.setEmail(rs.getString("email"));
					lista.add(usuario);
					return usuario;
		} catch (SQLException e) {
			System.out.println("Erro ao adicionar " + e);
			return null;
		}
		
	}
	public static boolean update(Usuario usuario) {
		try {
			DAO dao = new DAO();
			Connection con = dao.conectar();
			String query = "UPDATE usuario SET login = ?, senha = ?, email = ? WHERE login = ?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, usuario.getLogin());
			stmt.setString(2, usuario.getSenha());
			stmt.setString(3, usuario.getEmail());
			stmt.setString(4, usuario.getLogin());
			stmt.execute();
			return true;
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar " + e);
		}
		return false;
	}
	public static boolean delete(Usuario usuario) {
		try {
			DAO dao = new DAO();
			Connection con = dao.conectar();
			String query = "DELETE FROM usuario WHERE login = ?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, usuario.getLogin());
			stmt.execute();
			return true;
		} catch (SQLException e) {
			System.out.println("Erro ao deletar " + e);
		}
		return false;
	}
	
	public static void main(String[] args) {
		Usuario usuario = new Usuario("Joana", "joana", "joana@tutu");
		
			for(int i = 0; i < readAll().size(); i++)
				System.out.println(readAll().get(i).getLogin());
		
	}
}

