package veiculos;

public class Moto extends Veiculo {

	public Moto(String modelo, String cor, int ano) {
		super(modelo, cor, ano);
	}
	 public Moto(String modelo, String cor, int ano, boolean eletrico) {
	        super(modelo, cor, ano, eletrico);
	    }
	
	public void ligar() {
        System.out.println("Moto ligada");
    }
	
	public void parar() {
        System.out.println("Moto parada");
    }

    public void empinar() {
        System.out.println("Moto empinando");
    }
}
