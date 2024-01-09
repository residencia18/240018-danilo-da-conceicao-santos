package cliente;

import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {
	private String nome;
	private String email;
	private String senha;
	private ArrayList<String> postagens;

	public Usuario() {
		super();
		postagens = new ArrayList<String>();
	}
	
	public Usuario(String nome, String email) {
		super();
		this.nome = nome;
		this.email = email;
	}
	

	public Usuario(String nome, String email, String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setPostagens(ArrayList<String> postagens) {
		this.postagens = postagens;
	}
	public ArrayList<String> getPostagens() {
		return postagens;
	}

	public void addPostagens(String postagens) {
		this.postagens.add(postagens);
	}
	

	public void listarPostagens() {
		for(int i = 0; i<postagens.size();i++) {
			System.out.println(postagens.get(i));
			
		}
	}
	
	public static void main(String[] args) {
		
		String sn = "s", nome, email, senha; ;
		
		do {
		Scanner sc = new Scanner(System.in);
		Usuario usuario = new Usuario();
		
		System.out.println("Digite seu nome");
		nome = sc.nextLine();
		System.out.println("Digite seu email");
		email = sc.nextLine();
		System.out.println("Digite sua senha");
		senha = sc.nextLine();
		usuario.setNome(nome);
		usuario.setEmail(email);
		
		System.out.println("Cadastrar outro Usuario");
		sn = sc.nextLine();
		}while ( sn != "s");
	}
}
