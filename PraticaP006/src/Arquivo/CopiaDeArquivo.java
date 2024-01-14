package Arquivo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopiaDeArquivo {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("origem.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("destino.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                writer.write(linha);
                writer.newLine();
            }
            System.out.println("Conteúdo de 'origem.txt' copiado para 'destino.txt'.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
