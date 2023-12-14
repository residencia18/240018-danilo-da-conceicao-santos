package veiculo;

public class Main {
	public static void main(String[] args) {
		Carro fusca = new Carro("gt", "amarelo", 1970);
		Carro monza = new Carro("lts", "Brenco", 1986, 4);
		fusca.exibirInformacoes();
		System.out.println("\n");
		monza.exibirInformacoes(4);
		System.out.println("\n");
		Caminhao Bau = new Caminhao("Tanque", "preto", 2023, 2, 5 );
		Bau.exibirInformacoes();
		System.out.println("\n");
		Bau.exibirInformacoes(2,5);
	}
}
