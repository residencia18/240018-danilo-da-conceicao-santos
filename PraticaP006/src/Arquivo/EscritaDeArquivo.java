package Arquivo;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class EscritaDeArquivo {
    public static void main(String[] args) {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("saida.txt")))) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Digite as linhas de texto (digite 'sair' para encerrar):");
            while (true) {
                String linha = scanner.nextLine();
                if (linha.equalsIgnoreCase("sair")) {
                    break;
                }
                writer.println(linha);
            }
            System.out.println("Linhas gravadas em 'saida.txt'.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

