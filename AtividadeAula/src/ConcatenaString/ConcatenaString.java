package ConcatenaString;

import java.util.Scanner;

public class ConcatenaString {
	
	public static String concatena(String srt1,String str2) {
		String str = srt1 + str2;
		return str;
	}
	 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String x,y,z;
		System.out.println("Digite um nome");
		x = sc.nextLine();
		System.out.println("Digite um nome");
		y = sc.nextLine();
		
		z = concatena(x,y);
		System.out.println(z);
	}
	
	
}
