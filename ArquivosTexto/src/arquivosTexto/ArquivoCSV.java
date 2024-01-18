package arquivosTexto;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ArquivoCSV {
	public static void main(String[] args) {
		String nomeArquivo = "produto.csv";
		
		try(BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
			String linha = reader.readLine();
			while(linha != null) {
				System.out.println(linha);
				linha = reader.readLine();
			}

		}
		catch (IOException e) {
			System.err.println("Erro ao Ler o arquivo: " + e.getMessage());
		};
	}
}
