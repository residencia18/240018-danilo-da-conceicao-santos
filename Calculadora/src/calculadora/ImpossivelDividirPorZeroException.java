package calculadora;

public class ImpossivelDividirPorZeroException extends Exception {
   int dividendo;
   float dividendu;

   public ImpossivelDividirPorZeroException(int dividendo) {
      this.dividendo = dividendo;
   }

   public ImpossivelDividirPorZeroException(float dividendo) {
      this.dividendu = dividendo;
   }

   public String getMessage() {
      return " Impossivel Dividir " + this.dividendu + " por Zero";
   }
}