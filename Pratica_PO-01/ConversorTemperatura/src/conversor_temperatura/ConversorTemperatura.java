package conversor_temperatura;

import java.util.Scanner;

public class ConversorTemperatura {

  public static void main(String[] args) {


    double temperatura;
    String unidadeOrigem;
    String unidadeDestino;

    Scanner scanner = new Scanner(System.in);
    System.out.println("Digite a temperatura: ");
    temperatura = scanner.nextDouble();
    System.out.println("Digite a unidade de origem (Celsius ou Fahrenheit): ");
    unidadeOrigem = scanner.next();

    double temperaturaConvertida;
    if (unidadeOrigem.equals("Celsius")) {
      temperaturaConvertida = (temperatura * 9 / 5) + 32;
      unidadeDestino = "Fahrenheit";
    } else {
      temperaturaConvertida = (temperatura - 32) * 5 / 9;
      unidadeDestino = "Celsius";
    }

    System.out.println("A temperatura " + temperatura + " " + unidadeOrigem + " é igual a " + temperaturaConvertida + " " + unidadeDestino);
  }
}
