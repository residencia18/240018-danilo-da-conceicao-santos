package calculadora;

import java.io.PrintStream;
import java.util.Scanner;

public class Main {
   public Main() {
   }

   public static void main(String[] args) throws ImpossivelDividirPorZeroException {
      Scanner sc = new Scanner(System.in);
      System.out.println("Digite um numeero");
      float a = sc.nextFloat();
      System.out.println("Digite um numeero");
      float b = sc.nextFloat();

      try {
         PrintStream var10000 = System.out;
         float var10001 = Calculadora.dividir(a, b);
         var10000.println("Resultado Divisao  " + var10001);
      } catch (ImpossivelDividirPorZeroException var5) {
         System.out.println(var5.getMessage());
      }

   }
}