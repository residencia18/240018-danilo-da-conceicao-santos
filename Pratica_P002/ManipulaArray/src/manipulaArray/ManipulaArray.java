package manipulaArray;

import java.util.Arrays;
import java.util.Scanner;

public class ManipulaArray {

	
	public static int[] criarArray(int tamanho){
		Scanner sc = new Scanner(System.in);
		int[] array = new int[tamanho];
		for (int i = 0; i < array.length; i++) {
			System.out.print("Digite um valor: ");
			array[i] = sc.nextInt();						
		}
		return array;
	}
	
	public static int[] criarArrayAleatorio(int tamanho, int min, int max){
		int[] array = new int[tamanho];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * (max - min + 1) + min);
		}
		return array;
	}
	
	public static void mostrarArray(int[] array){
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
	
	public static int somarArray(int[] array){
		
		int soma = 0;
		for (int i = 0; i < array.length; i++) {
			soma += array[i];
		}
		return soma;
	}
	public static int maiorValor(int[] array){
		int maior = 0;
		for (int i = 0; i < array.length; i++) {
			maior = Math.max(maior, array[i]);
		}
		return maior;
	}
	public static int menorValor(int[] array){
		int menor = 0;
		for (int i = 0; i < array.length; i++) {
			menor = Math.min(menor, array[i]);
		}
		return menor;
	}
	public  static int[] ordenarArray(int[] array){
		Arrays.sort(array);
		return array;
	} 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] vetor = ManipulaArray.criarArray(5);	
		ManipulaArray.mostrarArray(vetor);
		
		int soma = ManipulaArray.somarArray(vetor);
		System.out.println("Soma: " + soma);
		
		int maior = ManipulaArray.maiorValor(vetor);
		System.out.println("Maior valor: " + maior);
		
		int menor = ManipulaArray.menorValor(vetor);
		System.out.println("Menor valor: " + menor);
		
		vetor = ManipulaArray.ordenarArray(vetor);
		ManipulaArray.mostrarArray(vetor);		
	}
}
