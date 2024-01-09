package arquivosTexto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ArquivosTexto {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do arquivo: ");
        String nomeArquivo = scanner.nextLine();

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo));

            System.out.println("Arquivo criado com sucesso!");

            System.out.println("Digite linhas para adicionar ao arquivo (pressione Enter em uma linha vazia para encerrar):");
            String linha;
            do {
                linha = scanner.nextLine();
                if (!linha.isEmpty()) {
                    writer.write(linha);
                    writer.newLine();
                }
            } while (!linha.isEmpty());

            System.out.println("Programa encerrado. Linhas foram adicionadas ao arquivo.");

            writer.close();
        } catch (IOException e) {
            System.err.println("Erro ao criar o arquivo: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
