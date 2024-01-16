package persistencia;
import java.io.*;
import java.util.List;

import org.json.*;
import cliente.*;

public class ClienteJSON {
	
	public static void salvar(List<Cliente> clientes, String nomeArquivo) throws IOException{
		
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		
		for(Cliente c : clientes) {
			JSONObject jsonCliente = new JSONObject();
			jsonCliente.put("nome", c.getNome());
			jsonCliente.put("cpf", c.getCpf());
			jsonCliente.put("cnh", c.getCnh());
			array.put(jsonCliente);
		}
		json.put("clientes", array);
		
	}
	
	public static void main(String[] args) throws Exception {
		Cliente c1 = new Cliente("João", "123.456.789-00", "123456789");
		Cliente c2 = new Cliente("Maria", "987.654.321-00", "987654321");
		Cliente c3 = new Cliente("Pedro", "456.789.123-00", "456789123");
		JSONArray array = new JSONArray();
		array.put(c1);
		array.put(c2);
		array.put(c3);	
		ClienteJSON.salvar(List.of(c1, c2, c3), "clientes.json");
		try(BufferedReader br = new BufferedReader(new FileReader("clientes.json"))) {
			
			JSONObject json = new JSONObject(br.readLine());
			JSONArray jsonarray = json.getJSONArray("clientes");
			
		}
		for(int i= 0; i< array.length(); i++) {
			System.out.println(array.getString(i));
		}
	}
}
