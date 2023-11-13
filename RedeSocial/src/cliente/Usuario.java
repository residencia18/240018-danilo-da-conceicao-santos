package cliente;

import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {
	private String nome;
	private String email;
	private String nacionalidade;
	private ArrayList<String> postagens;
	private int quantidadePostagens;
	private int pontuacao;
	
	
	
	
	public Usuario() {
		super();
		postagens = new ArrayList<String>();
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
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public void setPostagens(ArrayList<String> postagens) {
		this.postagens = postagens;
	}
	public ArrayList<String> getPostagens() {
		return postagens;
	}
	public int getQuantidadePostagens() {
		return quantidadePostagens;
	}
	public int getPontuacao() {
		return pontuacao;
	}
	public void addPostagens(String postagens) {
		this.postagens.add(postagens);
	}
	
	public void alteraPontuacao(int pontuacao) {
		this.pontuacao+=pontuacao;
		if(this.pontuacao < 0) this.pontuacao = 0;
	}
	public void listarPostagens() {
		for(int i = 0; i<postagens.size();i++) {
			System.out.println(postagens.get(i));
			
		}
	}
	
	public static void main(String[] args) {
		
		String sn = "s", nome, email, nacionalidade;
		
		do {
		Scanner sc = new Scanner(System.in);
		Usuario usuario = new Usuario();
		
		System.out.println("Digite seu nome");
		nome = sc.nextLine();
		System.out.println("Digite seu email");
		email = sc.nextLine();
		System.out.println("Digite seu nacionalidade");
		nacionalidade = sc.nextLine();
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setNacionalidade(nacionalidade);
		
		System.out.println("Cadastrar outro Usuario");
		sn = sc.nextLine();
		}while ( sn != "s");
	}
}
