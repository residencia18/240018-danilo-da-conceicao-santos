package contaBancaria;

public class ContaBancaria {
	private double saldo;
	private String titular;
	public ContaBancaria(String titular) {
		super();
		this.saldo = 0;
		this.titular = titular;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) throws SaldoNegativoException {
		if(saldo < 0) {
			throw new SaldoNegativoException("Saldo nao pode ser negativo");
		}
			this.saldo = saldo;
	}
	public String gettitular() {
		return titular;
	}
	public void settitular(String titular) {
		this.titular = titular;
	}
	
	public void depositar(double valor) {
		this.saldo += valor;
	}
	public double sacar(double valor) throws SaldoNegativoException {
		if(this.saldo >= valor) {
			double novoSaldo = getSaldo() - valor;
			setSaldo(novoSaldo);
			return valor;
		}
		
		throw new SaldoNegativoException("Saldo insuficiente");
	}
	
	public void mostrarSaldo() {
		System.out.println("Saldo: " + getSaldo());
	}
	
	public void transferir(double valor, ContaBancaria conta1, ContaBancaria conta2) throws SaldoNegativoException {
		System.out.println("Transferindo "+valor+" de "+ conta1.gettitular()+" para "+conta2.gettitular());
		double transferir = conta1.sacar(valor);
		conta2.depositar(transferir);
	}
}
