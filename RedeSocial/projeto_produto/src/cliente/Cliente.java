package cliente;

import java.util.Scanner;

public class Cliente {
	private String nome, cpf;
	private int idade;
	public Cliente(String nome, String cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.idade = 0;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String nome,cpf;
		int idade;
		
		System.out.println("Digite seu nome");
		nome = sc.nextLine();
		System.out.println("Digite seu cpf");
		cpf = sc.nextLine();
		
		Cliente cliente1 = new Cliente(nome,cpf);
		
		System.out.println("Nome " + cliente1.getNome()+ "\ncpf " + cliente1.getCpf());
		
		System.out.println("Digite sua idade");
		idade = sc.nextInt();
		cliente1.setIdade(idade);
		System.out.println("Nome " + cliente1.getNome()+ " cpf " + cliente1.getCpf()+ " idade " + cliente1.getIdade());
		
	}
}
