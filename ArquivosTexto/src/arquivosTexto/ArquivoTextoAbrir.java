package arquivosTexto;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ArquivoTextoAbrir {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do arquivo: ");
        String nomeArquivo = scanner.nextLine();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo));

            System.out.println("Conteúdo do arquivo:");

            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }

            reader.close();
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

