package testes;

import cliente.Cliente;
import dao.ClienteDAO;

public class TesteCliente {
	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		cliente.setNome("Juca");
	cliente.setCpf("123.456.789-11");
		
		//ClienteDAO.create(cliente);
		
		//System.out.println(ClienteDAO.readAll().get(0).getNome());
		//System.out.println(ClienteDAO.readById("1").getNome());
		
		ClienteDAO.update(cliente);
	}
}
