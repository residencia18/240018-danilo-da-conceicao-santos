package facade;

import java.util.ArrayList;

class Poligono {
	ArrayList<Ponto> pontos;
	
	Poligono() {
		pontos = new ArrayList<Ponto>();
	}
	
	public ArrayList<Ponto> getPontos() {
		return pontos;
	}

	public void setPontos(ArrayList<Ponto> pontos) {
		this.pontos = pontos;
	}

	void inserePonto(float x, float y, float z) {
		Ponto p = new Ponto (x, y, z);
		pontos.add(p);
	}
	
	float perimetro() {
        float per = 0;
        Ponto p1, p2;
        for (int i = 0; i < pontos.size() - 1; i++) {
            p1 = pontos.get(i);
            p2 = pontos.get(i + 1);
            per += Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2)+ Math.pow(p1.z - p2.z, 2));
        }
        p1 = pontos.get(0);
        p2 = pontos.get(pontos.size() - 1);
        per += Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2) + Math.pow(p1.z - p2.z, 2));
        return per;
    }
}
