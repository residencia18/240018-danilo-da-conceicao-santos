//package cripto;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//
//public class Cripto {
//	public static void proccess(String file1, String file2) throws FileNotFoundException {
//		FileOutputStream saida = new FileOutputStream(file2);
//		
//		FileInputStream entrada = new FileInputStream(file1);
//		try {
//			boolean eof = false; int count = 0;
//			while (!eof) {
//				int input = entrada.read();
//				if (input != -1) {
//					saida.write(input);
//					count++;
//				} else eof = true;
//			}
//			entrada.close();
//			System.out.println("\nBytes lidos: " + count);
//		} catch (IOException e) {
//			System.out.println("Error -- " + e.toString());
//		}
//	}
//}

////////////////////////////////////////////////////////
//exemplo 3
///////////////////////////////////////////////////////


//package cripto;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//
//public class Cripto {
//    public static void process(String file1, String file2, String senha) throws FileNotFoundException {
//        FileOutputStream saida = new FileOutputStream(file2);
//
//        FileInputStream entrada = new FileInputStream(file1);
//        try {
//            boolean eof = false;
//            int count = 0;
//            while (!eof) {
//                int input = entrada.read();
//                if (input != -1) {
//                    // Operação XOR com 255
//                    byte byteCriptografado = (byte) (input ^ 255);
//                    saida.write(byteCriptografado);
//                    count++;
//                } else
//                    eof = true;
//            }
//            entrada.close();
//            System.out.println("\nBytes lidos: " + count);
//        } catch (IOException e) {
//            System.out.println("Erro -- " + e.toString());
//        }
//    }
//}

////////////////////////////////////////////////////////
//exemplo 3
///////////////////////////////////////////////////////

package cripto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Cripto {
public static void process(String file1, String file2, String senha) throws FileNotFoundException {
FileOutputStream saida = new FileOutputStream(file2);

FileInputStream entrada = new FileInputStream(file1);
try {
boolean eof = false;


int count = 0, contSenha = 0;
while (!eof) {
int input = entrada.read();
if(contSenha >= senha.length()) {
contSenha=0;
}
if (input != -1) {
// Operação XOR com 255
byte byteCriptografado = (byte) (input ^ senha.charAt(contSenha));
saida.write(byteCriptografado);
count++;
} else
eof = true;
}
entrada.close();
System.out.println("\nBytes lidos: " + count);
} catch (IOException e) {
System.out.println("Erro -- " + e.toString());
}
}
}

