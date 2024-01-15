//package facade;
//import java.io.IOException;
//import cripto.Cripto;
//public class Facade {
//	// faz a coppia do arquivo bit a bit com o arquivo original.
//	public static void main(String[] args) {
//		String nome1 = args[0];
//		String nome2 = args[1];
//		
//		System.out.println(nome1);
//		System.out.println(nome2);
//		try {
//			Cripto.proccess(nome1, nome2);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
//	}
//}

package facade;

import cripto.Cripto;

public class Facade {
    // faz a coppia do arquivo bit a bit com o arquivo original.
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Uso: java Facade <arquivo1> <arquivo2> <senha>");
            System.exit(1);
        }

        String nome1 = args[0];
        String nome2 = args[1];
        String senha = args[2];

        System.out.println(nome1);
        System.out.println(nome2);
        try {
            Cripto.process(nome1, nome2, senha);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
