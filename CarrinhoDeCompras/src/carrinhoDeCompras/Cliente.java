package carrinhoDeCompras;

public class Cliente {
	private String nome;
	private String cpf;
	
	public Cliente(String nome, String cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
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
	
	public String toString() {
		String str = "";
		str += "Nome: " + nome;
		str += "\nCPF: " + cpf;
		return str;
	}
	
}
