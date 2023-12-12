package validadorIdade;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Cliente {
   public Cliente() {
   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      System.out.println("Digite a data de nascimento (no formato yyyy-MM-dd):");
      String dataNascimentoStr = sc.next();
      LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr);
      int idade = calcularIdade(dataNascimento);

      try {
         ValidadorIdade.validarIdadeChecada(idade);
         System.out.println("sua idade e: " + idade);
      } catch (IdadeInvalidaException var6) {
         System.out.println("Erro: " + var6.getMessage());
      }

   }

   private static int calcularIdade(LocalDate dataNascimento) {
      LocalDate hoje = LocalDate.now();
      return Period.between(dataNascimento, hoje).getYears();
   }
}
