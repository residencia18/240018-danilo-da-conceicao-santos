package facade;

import java.util.Scanner;

class Ponto {
	float x, y, z;
	Ponto(float _x, float _y, float _z) {
		x = _x;
		y = _y;
		z = _z;
	}
		
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	
	public float getZ() {
		return z;
	}

	public void setZ(float z) {
		this.z = z;
	}

	float distancia(Ponto p) {
		return (float) Math.sqrt( Math.pow(this.x - p.getX(), 2) + Math.pow(this.y - p.getY(), 2)+  + Math.pow(this.z - p.getZ(), 2));
	}
	
	static Ponto solicitaPonto() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite as coordenadas");
		float x = sc.nextFloat();
		float y = sc.nextFloat();
		float z = sc.nextFloat();
		return new Ponto(x,y,z);
	}
}
