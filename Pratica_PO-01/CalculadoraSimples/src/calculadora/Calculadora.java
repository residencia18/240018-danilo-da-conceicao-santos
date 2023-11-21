package calculadora;

import java.util.Scanner;

public class Calculadora {

	  public static void main(String[] args) {
	
		    double numero1, numero2;
		    char operacao;
		
		  
		    Scanner scanner = new Scanner(System.in);
		    System.out.println("Digite o primeiro número: ");
		    numero1 = scanner.nextDouble();
		    System.out.println("Digite o segundo número: ");
		    numero2 = scanner.nextDouble();
		
		  
		    System.out.println("Escolha uma operação (+, -, *, /): ");
		    operacao = scanner.next().charAt(0);
		
		    double resultado = 0;
		    switch (operacao) {
		      case '+':
		        resultado = numero1 + numero2;
		        break;
		      case '-':
		        resultado = numero1 - numero2;
		        break;
		      case '*':
		        resultado = numero1 * numero2;
		        break;
		      case '/':
		        resultado = numero1 / numero2;
		        break;
		      default:
		        System.out.println("Operação inválida!");
		        return;
		    }
		    System.out.println("O resultado é " + resultado);
	  }
}
