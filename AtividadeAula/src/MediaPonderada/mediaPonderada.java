package MediaPonderada;

import java.util.Scanner;

public class mediaPonderada {
	private double nota1,nota2,nota3;
	 

	public double getNota1() {
		return nota1;
	}

	public void setNota1(double nota1) {
		this.nota1 = nota1;
	}

	public double getNota2() {
		return nota2;
	}

	public void setNota2(double nota2) {
		this.nota2 = nota2;
	}

	public double getNota3() {
		return nota3;
	}

	public void setNota3(double nota3) {
		this.nota3 = nota3;
	}
	public static double mediaPonderada(double n1, double n2, double n3) {
		  
		  double ponderada = (n1+3)+(n2+3)+(n3+4)/10;

		  return ponderada;
	}
	
	public static void main(String[] args) {
		double x,y,z;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("digite 1 numero interio");
		x = sc.nextInt();
		System.out.println("digite 1 numero interio");
		y = sc.nextInt();
		System.out.println("digite 1 numero interio");
		z = sc.nextInt();
		System.out.println(mediaPonderada(x,y,z));
	}
}
	


