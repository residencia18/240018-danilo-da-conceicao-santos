package Usuario;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String nome;
	List<Usuario> usuarios;
	public Usuario(String nome) {
		super();
		this.nome = nome;
		this.usuarios = new ArrayList<>();
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Usuario> getusuarios() {
		return usuarios;
	}
	public void setusuarios(List<Usuario> usuarios) {
		this.usuarios =usuarios;
	}
	public void listar(int x) {
		for(int i= 0; i<x ;i++) {
			System.out.println("Usuario: " + usuarios.get(i).getNome());
		}
	}
	
	public void listar(int x, int y) {
		for(int i= x; i<y ;i++) {
			System.out.println("Usuario: " + usuarios.get(i).getNome());
		}
	}
	 
	public void listar() {
		for(int i= 0; i<usuarios.size();i++) {
			System.out.println("Usuario: " + usuarios.get(i).getNome());
		}
	}
	public void add(Usuario usuario) {
		usuarios.add(usuario);
	}
	
	public static void main(String[] args) {
		Usuario usuario1 = new Usuario("Danilo");
		Usuario usuario2 = new Usuario("Aninha");
		Usuario usuario3 = new Usuario("Bella");
		Usuario usuario4 = new Usuario("Ben");
		try {
			usuario1.add(usuario1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		usuario1.add(usuario2);
		usuario1.add(usuario2);
		usuario1.add(usuario4);
		usuario1.listar();
		System.out.println("\n");
		usuario1.listar(2);
		System.out.println("\n");
		usuario1.listar(1,2);
	}
}
