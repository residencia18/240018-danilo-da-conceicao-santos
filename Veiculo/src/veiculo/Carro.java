package veiculo;

public class Carro extends Veiculo {
	
	private int numeroPorta;
	
	public Carro(String modelo, String cor, int ano, int numeroPorta) {
		super(modelo, cor, ano);
		this.numeroPorta = numeroPorta;
	}
	public Carro(String modelo, String cor, int ano) {
		super(modelo, cor, ano);
	}	
	public void exibirInformacoes(int numeroPorta) {
		super.exibirInformacoes();
		System.out.println("numeroPorta = " + numeroPorta);
	
	}
	public boolean numeroPorta() {
		if(this.numeroPorta > 0) {
			return true;
		}
		return false;
	}
	
	
	public void exibirInformacoes() {
		super.exibirInformacoes();
		if( numeroPorta()) {
			System.out.println("numeroPorta = " + numeroPorta);
		}	
	}	
}
