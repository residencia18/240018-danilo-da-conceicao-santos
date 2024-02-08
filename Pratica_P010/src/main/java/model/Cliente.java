package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cliente {
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private Integer id;
	private String nome;
	private String cpf;

	@ManyToOne
	private Imovel imovel;
	

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
	
	public Cliente() {
		super();
	}
	
	public Integer getId() {
        return id;
    }

	public void setId(Integer id) {
        this.id = id;
    }
	
	
	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
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

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + "]";
	}

	public static boolean validarCPF(String cpf2) {
		if(cpf2.length() > 11) {
			return false;
		}
		return true;
	}
	
	
	
	
}
