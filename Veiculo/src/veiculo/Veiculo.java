package veiculo;

public class Veiculo {
	private String modelo;
	private String cor;
	private int ano;
	
	public Veiculo(String modelo, String cor, int ano) {
		super();
		this.modelo = modelo;
		this.cor = cor;
		this.ano = ano;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public void exibirInformacoes() {
		System.out.println("modelo = " + modelo);
		System.out.println("cor = " + cor);
		System.out.println("ano = " + ano);
	}	
	
	
}
