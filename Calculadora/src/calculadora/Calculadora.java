
package calculadora;

public class Calculadora {
   public Calculadora() {
   }

   public static int soma(int a, int b) {
      return a + b;
   }

   public int somar(int a, int b) {
      return a + b;
   }

   public static int subtrair(int a, int b) {
      return a - b;
   }

   public static int multiplicar(int a, int b) {
      return a * b;
   }

   public static int dividir(int a, int b) {
      return a / b;
   }

   public static float dividir(float dividendo, float divisor) throws ImpossivelDividirPorZeroException {
      if (divisor == 0.0F) {
         throw new ImpossivelDividirPorZeroException(dividendo);
      } else {
         return dividendo / divisor;
      }
   }
}
