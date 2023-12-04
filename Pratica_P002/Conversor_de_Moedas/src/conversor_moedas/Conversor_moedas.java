package conversor_moedas;

import java.util.Scanner;

public class Conversor_moedas {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double valorDollar;
		double taxaCambio;
		double valorConvertido;
		
		System.out.println("Insira o valor do dollar: ");
		valorDollar = sc.nextDouble();
			
		System.out.println("Insira a taxa de cambio para reais: ");
		taxaCambio = sc.nextDouble();
		
		valorConvertido = valorDollar * taxaCambio;
		
		System.out.println("O valor convertido para reais: " + valorConvertido + " reais");
		
	}
}
