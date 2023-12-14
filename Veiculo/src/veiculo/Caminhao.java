package veiculo;

public class Caminhao extends Veiculo {
	public int numeroEixo, capacidadeMaxima;
	
	public Caminhao(String modelo, String cor, int ano) {
		super(modelo, cor, ano);	
	}

	public Caminhao(String modelo, String cor, int ano, int numeroEixo, int capacidadeMaxima) {
		super(modelo, cor, ano);
		this.numeroEixo = numeroEixo;
		this.capacidadeMaxima = capacidadeMaxima;
	}

	public Caminhao(String modelo, String cor, int ano, int numeroEixo) {
		super(modelo, cor, ano);
		this.numeroEixo = numeroEixo;
	}

	public Caminhao( int ano,String modelo, String cor, int capacidadeMaxima) {
		super(modelo, cor, ano);
		this.capacidadeMaxima = capacidadeMaxima;
	}
	
	public void exibirInformacoes(int capacidadeMaxima ) {
		super.exibirInformacoes();
		System.out.println("capacidadeMaxima = " + capacidadeMaxima);
	}

	public void exibirInformacoes(int capacidadeMaxima, int eixo) {
		super.exibirInformacoes();
		System.out.println("capacidadeMaxima = " + capacidadeMaxima);
		System.out.println("numeroEixo = " + numeroEixo);
	}
	
	public void exibirInformacoes(boolean eixo) {
		super.exibirInformacoes();
		if( eixo) {
			System.out.println("numeroEixo = " + numeroEixo);
		}	
	}	
}
