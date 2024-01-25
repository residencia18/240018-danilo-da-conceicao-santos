package arquivosTexto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Programa {
	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		List<Produto> listaProdutos = new ArrayList<>();

		
		//// ler o arquivo csv ////
		File arquivoFonte = new File("produto.csv");
		try(BufferedReader reader = new BufferedReader(new FileReader(arquivoFonte))) {
			String linha = reader.readLine();
			while(linha != null) {
				String[] dados = linha.split(",");
				String nome = dados[0];
				double preco = Double.parseDouble(dados[1]);
				int quantidade = Integer.parseInt(dados[2]);
				
				listaProdutos.add(new Produto(nome, preco, quantidade));
				
				linha = reader.readLine();
			}				
		} catch (IOException e) {
			System.err.println("Erro ao ler o arquivo: " + e.getMessage());
		}
		 for (Produto produto : listaProdutos) {
	            System.out.println(produto.getNome()+ ", " + produto.getPreco() + ", " + produto.getQuantidade()); // Exemplo: imprimir os produtos na tela
	        }
		 
		/////criar pasta e salvar dentroo novo arquivo csv /////

			try(BufferedWriter writer = new BufferedWriter(new FileWriter("summer.csv"));) {
				for(Produto produto : listaProdutos) {
					writer.write(produto.getNome() + "," + produto.calculaTotal());
					writer.newLine();
				}
				System.out.println("Arquivo criado com sucesso!");
				
			}catch(Exception e){
				System.err.println("Erro ao ler o arquivo: " + e.getMessage());
			}
		 
		 
	}
}		