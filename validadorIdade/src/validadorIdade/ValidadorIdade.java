package validadorIdade;

public class ValidadorIdade {
   public ValidadorIdade() {
   }

   public static void validarIdadeChecada(int idade) throws IdadeInvalidaException {
      if (idade < 0 || idade > 150) {
         throw new IdadeInvalidaException("Idade inv\u00e1lida: " + idade);
      }
   }
}
