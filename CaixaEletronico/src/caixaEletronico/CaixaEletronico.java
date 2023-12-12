package caixaEletronico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CaixaEletronico {
   private List<Double> notas = new ArrayList();

   public CaixaEletronico() {
      this.notas.add(100.0);
      this.notas.add(50.0);
      this.notas.add(10.0);
   }

   public void notasDisponivel() {
      System.err.println("Notas Disponivel " + String.valueOf(this.notas));
   }

   public void sacar(double valor) throws ValorInvalidoException {
      if (valor <= 0.0) {
         throw new ValorInvalidoException("Saque invalido! Notas nao Disponiveis");
      } else {
         Iterator var5 = this.notas.iterator();

         while(var5.hasNext()) {
            double nota = (Double)var5.next();
            double quantidade = valor / nota;
            if (quantidade > 0.0) {
               System.out.println("Retirando " + quantidade + " nota(s) de R$" + nota);
               valor -= quantidade * nota;
            }
         }

      }
   }

   public static void sacar(float saque) throws ValorInvalidoException {
      if (saque % 10.0F != 0.0F) {
         throw new ValorInvalidoException("Saque invalido! permido somente divisivel por 10");
      } else {
         System.out.println("Saque de R$" + saque + " realizado com sucesso.");
      }
   }
}
