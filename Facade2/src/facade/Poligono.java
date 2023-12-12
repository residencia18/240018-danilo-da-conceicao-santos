package facade;
import java.util.ArrayList;

class Poligono {
	ArrayList<Ponto> pontos;
	
	Poligono() {
		pontos = new ArrayList<Ponto>();
	}
	
	void inserePonto(Ponto p) {
		pontos.add(p);
	}
	
	public ArrayList<Ponto> getPontos() {
		return pontos;
	}

	public void setPontos(ArrayList<Ponto> pontos) {
		this.pontos = pontos;
	}

	float perimetro() {
		float per = 0;
		Ponto p1, p2 = null;
		for (int i=0;i<pontos.size()-1;i++) {
			p1 = pontos.get(i);
			p2 = pontos.get(i+1);
			per += p1.distancia(p2);
		}
		p1 = pontos.get(0);
		per += p1.distancia(p2);
		return per;
	}
}