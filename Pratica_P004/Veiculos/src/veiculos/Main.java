package veiculos;

public class Main {

	public static void main(String[] args) {
		Carro carro = new Carro("Civic", "Preto", 2022);
        Moto moto = new Moto("CBR", "Vermelho", 2021);

    
        carro.ligar();  
        carro.acelerar();  
        carro.parar();  
        carro.abrirPorta();  

        System.out.println(); 

        moto.ligar();  
        moto.acelerar();  
        moto.parar();  
        moto.empinar(); 
        
        Carro carro1 = new Carro("Civic", "Preto", 2022, false);
        Moto moto1 = new Moto("CBR", "Vermelho", 2021, true);

        Garagem garagemComTomada = new Garagem(true);

        carro1.estacionar(garagemComTomada);
        moto1.estacionar(garagemComTomada);

        System.out.println();

        Garagem garagemSemTomada = new Garagem(false);

        carro1.estacionar(garagemSemTomada);
        moto1.estacionar(garagemSemTomada);
        
        
        
	}

}
