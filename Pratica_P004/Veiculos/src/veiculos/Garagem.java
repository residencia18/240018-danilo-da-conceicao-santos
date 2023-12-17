package veiculos;

import java.util.ArrayList;
import java.util.List;

public class Garagem {
	private List<Veiculo> veiculos;
    private boolean possuiTomadaEletrica;
    
    
    public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	public boolean isPossuiTomadaEletrica() {
		return possuiTomadaEletrica;
	}

	public void setPossuiTomadaEletrica(boolean possuiTomadaEletrica) {
		this.possuiTomadaEletrica = possuiTomadaEletrica;
	}

	public Garagem(boolean possuiTomadaEletrica) {
        this.veiculos = new ArrayList<>();
        this.possuiTomadaEletrica = possuiTomadaEletrica;
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    public void removerVeiculo(Veiculo veiculo) {
        veiculos.remove(veiculo);
    }

    public boolean possuiTomadaEletrica() {
        return possuiTomadaEletrica;
    }
}
