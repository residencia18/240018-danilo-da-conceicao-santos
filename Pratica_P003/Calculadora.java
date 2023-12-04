import java.util.Scanner;

public class Calculadora {

    public int somar(int a, int b) {
        return a + b;
    }

    public int subtrair(int a, int b) {
        return a - b;
    }

    public int multiplicar(int a, int b) {
        return a * b;
    }

    public int dividir(int a, int b) throws DivisionByZeroException {
        if (b == 0) {
            throw new DivisionByZeroException();
        }
        return a / b;
    }

    public float dividir(float a, float b) throws DivisionByZeroException {
        if (b == 0) {
            throw new DivisionByZeroException();
        }
        return a / b;
    }

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Digite um Numero");
            int a = sc.nextInt();
            System.out.println("Digite outro numero");
            int b = sc.nextInt();

            Calculadora calculadora = new Calculadora();

            // Exemplo de uso dos métodos
            int resultadoDivisaoInteira = calculadora.dividir(a, b);
            System.out.println("Resultado da divisão inteira: " + resultadoDivisaoInteira);

            float resultadoDivisaoFloat = calculadora.dividir((float) a, (float) b);
            System.out.println("Resultado da divisão float: " + resultadoDivisaoFloat);

            int resultadoSoma = calculadora.somar(a, b);
            System.out.println("Resultado da soma: " + resultadoSoma);

            int resultadoSubtracao = calculadora.subtrair(a, b);
            System.out.println("Resultado da subtração: " + resultadoSubtracao);

            int resultadoMultiplicacao = calculadora.multiplicar(a, b);
            System.out.println("Resultado da multiplicação: " + resultadoMultiplicacao);

        } catch (DivisionByZeroException e) {
            System.out.println(e.getMessage());
        }
    }
}
