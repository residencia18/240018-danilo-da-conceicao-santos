package facade;

import java.util.Scanner;

class Facade {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		System.out.println("Poligono de quantos pontos?");
		int n = sc.nextInt();
		Poligono poli = new Poligono();
		for (int i=0; i< n; i++) {
			System.out.println("Digite as coordenadas");
			float x = sc.nextFloat();
			float y = sc.nextFloat();
			float z = sc.nextFloat();
			poli.inserePonto(x, y, z);
		}
		
		System.out.println("Mostrando o perimetro: " + poli.perimetro());
		
	}
}
