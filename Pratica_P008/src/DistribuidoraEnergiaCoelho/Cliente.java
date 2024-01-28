package DistribuidoraEnergiaCoelho;

public class Cliente {
	private String nome;
	private String cpf;
	private Imovel imovel;
	
	//Construtor
	public Cliente(String nome, String cpf, Imovel imovel) {
		this.nome = nome;
		if (validarCPF(cpf)) {
            this.cpf = cpf;
        } else {
            System.out.println("CPF inválido. Não foi possível atribuir ao cliente.");
        }
		this.imovel = imovel;
	}

	public Cliente(String nome, String cpf) {
		this.nome = nome;
		if (validarCPF(cpf)) {
            this.cpf = cpf;
        } else {
            System.out.println("CPF inválido. Não foi possível atribuir ao cliente.");
        }
	}

	//Getters e Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	/*
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	*/
	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}
	 public static boolean validarCPF(String cpf) {

	        cpf = cpf.replaceAll("[^0-9]", "");

	        if (cpf.length() != 11) {
	            return false;
	        }

	        if (!cpf.matches("\\d{11}")) {
	            return false;
	        }

	        return true;
	    }
}

