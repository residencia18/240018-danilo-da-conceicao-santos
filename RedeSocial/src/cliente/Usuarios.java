package cliente;

import java.util.ArrayList;
import java.util.Scanner;

public class Usuarios {
	private ArrayList<Usuario> usuarios;

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public void adicionarUsuario() {
		String sn = "s", nome, email, senha; ;
		
		do {
		Scanner sc = new Scanner(System.in);				
		System.out.println("Digite seu nome");
		nome = sc.nextLine();
		System.out.println("Digite seu email");
		email = sc.nextLine();
		System.out.println("Digite sua senha");
		senha = sc.nextLine();
		Usuario usuario = new Usuario(nome, email, senha);
		usuarios.add(usuario);	
		System.out.println("Cadastrar outro Usuario");
		sn = sc.nextLine();
		}while ( sn != "s");
	}
	
	public void mostrarUsuarios(Usuarios usuarios) {
		for(int i = 0; i<usuarios.getUsuarios().size();i++) {
			System.out.println(usuarios.getUsuarios().get(i).getNome());
			System.out.println(usuarios.getUsuarios().get(i).getEmail());
		}	
	}
	public void listarUsuarios() {
		for(int i = 0; i<usuarios.size();i++) {
			usuarios.get(i).getNome();
			usuarios.get(i).getEmail();
		}
	}
	public void removerUsuario() {
		for(int i = 0; i<usuarios.size();i++) {
			usuarios.remove(i);
		}
	}
	
	public void buscarUsuario(ArrayList<Usuario> usuarios) {
		String nome;
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o nome do usuario");
		nome = sc.nextLine();
		
		for(int i = 0; i<usuarios.size();i++) {
			if(usuarios.get(i).getNome().equals(nome)) {
				System.out.println(usuarios.get(i).getNome());
				System.out.println(usuarios.get(i).getEmail());
			}
		}
	}
	
}
