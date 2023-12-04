package jogoAdivinhacao;

import java.util.Scanner;

public class JogoAdivinhacao {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int numeroSecreto = (int) (Math.random() * 100);
		int tentativas = 0;
		int chute;
		
		do {
			System.out.println("Qual o seu palpite?");
			chute = sc.nextInt();
			if (numeroSecreto < chute) {
				System.out.println("O seu palpite é maior que o número secreto.");
			} else if (numeroSecreto > chute) {
				System.out.println("O seu palpite é menor que o número secreto.");
			}
			tentativas++;
			} while ( numeroSecreto!= chute);
		
			System.out.println("Parabéns, você acertou!");
			System.out.println("O número secreto era " + numeroSecreto);
			System.out.println("Foram necessárias " + tentativas + " tentativas");
	}
}
