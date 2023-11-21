package somaNumeros;

import java.util.Scanner;

public class Soma {
	
	public static int soma(int n1, int n2){
		return  n1+n2;		
	}
	
	public static void main(String[] args) {
		int x,y;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("digite 1 numero interio");
		x = sc.nextInt();
		System.out.println("digite 1 numero interio");
		y = sc.nextInt();
		System.out.println(soma(x,y));
	}
	
}
