package caixaEletronico;

import java.util.Scanner;

public class Main {
   public Main() {
   }

   public static void main(String[] args) {
      CaixaEletronico caixa = new CaixaEletronico();
      Scanner sc = new Scanner(System.in);
      System.out.println("Digite o valor a ser sacado:");
      double valor = (double)sc.nextInt();

      try {
         caixa.sacar(valor);
      } catch (ValorInvalidoException var6) {
         System.out.println("Error : " + var6.getMessage());
      }

   }
}