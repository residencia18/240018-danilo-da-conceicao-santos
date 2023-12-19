package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Array {
	private static String nome[]= {"Joao", "Maria", "Juca", "Pedro", "Catia"};
	
	public static void verificaArray(String nome[], String n) {
		for(int i = 0; i<nome.length; i++) {
			if(n.equals(nome)) {
				System.out.println("existe");
			}
			System.out.println("Nao existe");
		}
	}
	
	public static void verificaArray2(String nome[],String n) {
		Arrays.sort( nome);
		int busca = Arrays.binarySearch( nome, n );
			if(busca > 0 ) {
				System.out.println("existe");
			}
			else {	
				System.out.println("Nao existe");
			}	
		
	}
	
	public static List ConvertArray(String nomes[]) {
		List list = new ArrayList( Arrays.asList(nomes ) );
		return list;
	}
	
	public static void inseriEmotraIverso(String nome[]) {
		 List link = new LinkedList();
		 
		 for ( int count = 0; count < nome.length; count++ ) {
			 link.add( nome[ count ] );	
			 System.out.println(link.get(count));
		 }
		 System.out.println("\n");
		 Collections.reverse(link);
		 for ( int count = 0; count < nome.length; count++ ) {			
			 System.out.println(link.get(count));
		 }
	}

	public static void main(String[] args) {
		Array.inseriEmotraIverso(nome);
	}
}

