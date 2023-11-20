package paridade;

import java.util.Scanner;

public class Paridade {
	
	public static String paridade(int num) {
		if(num%2==0) return "par";
			
		return "impar";
	}
	
	public static void main(String[] args) {
		int x,y;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("digite 1 numero interio");
		x = sc.nextInt();
		
		System.out.println(paridade(x));
	}
}
