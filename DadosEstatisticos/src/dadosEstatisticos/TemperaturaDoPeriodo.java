package dadosEstatisticos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TemperaturaDoPeriodo implements DadosEstatisticos {
	private List<Double> temperaturas;
	
	public TemperaturaDoPeriodo() {
		this.temperaturas = new ArrayList<>();
	}
	public Object maximo() {
		double[] temperaturas = this.temperaturas.stream().mapToDouble(Double::doubleValue).toArray();
		double max = 0;
		for(int i = 0; i < temperaturas.length; i++) {
			if(max < temperaturas[i]) {
				max = temperaturas[i];
			}
		}
		return  max;
	}
	public Object minimo(double[] temperaturas) {
		double min = 0;
		for(int i = 0; i < temperaturas.length; i++) {
			if(min > temperaturas[i]) {
				min = temperaturas[i];
			}
		}
		return  min;
	}
	public Object ordenar(double[] temperatura) {
	
		Arrays.sort(temperatura);
        return Arrays.asList(temperatura);
	}
	
	public  Object buscar(double temperaturas[],double n) {
		Arrays.sort( temperaturas);
		double busca = Arrays.binarySearch( temperaturas, n );
			if(busca > 0 ) {
				return temperaturas[(int) busca];
			}
			else {	
				System.out.println("Nao existe");
				return null;
			}
				
	}
	

}
