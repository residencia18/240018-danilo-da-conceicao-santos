package leituraArquivo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LeituraDeArquivo {
	public static void main(String[] args) {
     
        try {
            BufferedReader reader = new BufferedReader(new FileReader("entrada.txt"));

            System.out.println("Conteúdo do arquivo:");

            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }

            reader.close();
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        } finally {
        	
        }
    }
}
