package contaBancaria;

public class Main {

	public static void main(String[] args){
		try {
			ContaBancaria conta1 = new ContaBancaria("123456");
			ContaBancaria conta2 = new ContaBancaria("654321");
			
			conta1.depositar(100);
			conta1.mostrarSaldo();
			conta2.depositar(200);
			conta2.mostrarSaldo();
			conta1.sacar(300);
			conta1.mostrarSaldo();
			conta2.transferir(30, conta1, conta2);
			conta1.mostrarSaldo();
			conta2.mostrarSaldo();
		} catch (SaldoNegativoException e) {
			  System.out.println("Erro: " + e.getMessage());
		}
		
	}

}
