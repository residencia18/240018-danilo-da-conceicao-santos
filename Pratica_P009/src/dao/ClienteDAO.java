package dao;

import java.sql.Connection;

public class ClienteDAO {
	DAO dao = new DAO();
	Connection con = dao.conectar();
	String query = "INSERT INTO Cliente (nome, cpf) VALUES (?, ?)";
}
