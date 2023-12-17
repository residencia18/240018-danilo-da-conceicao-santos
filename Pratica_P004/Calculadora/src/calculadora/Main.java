package calculadora;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Digite um Numero");
            int a = sc.nextInt();
            System.out.println("Digite outro numero");
            int b = sc.nextInt();

            Calculadora calculadora = new Calculadora();

          
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

        
            ArrayList<Integer> numeros = new ArrayList<>();
            numeros.add(2);
            numeros.add(4);
            numeros.add(6);

            int resultadoSomaLista = Calculadora.somar(numeros);
            System.out.println("Resultado da soma da lista: " + resultadoSomaLista);

            int resultadoMultiplicacaoLista = Calculadora.multiplicar(numeros);
            System.out.println("Resultado da multiplicação da lista: " + resultadoMultiplicacaoLista);

        } catch (DivisionByZeroException e) {
            System.out.println(e.getMessage());
        }
    }
}
