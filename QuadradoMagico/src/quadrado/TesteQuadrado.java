package quadrado;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TesteQuadrado {

	@Test
	void testClique() {
		Quadrado quadrado = new Quadrado("XXOXOXOXX");
		//Caso 1: testar Clique(1)
		quadrado.clique(1);
		assertEquals("OOOOOXOXX", quadrado.getEstado());
		
		//Caso 2: testar Clique(2)
		quadrado = new Quadrado("XXOXOXOXX");
		quadrado.clique(2);
		assertEquals("OOXXOXOXX", quadrado.getEstado());
		
		//Caso 3: testar Clique(3)
		quadrado = new Quadrado("XXOXOXOXX");
		quadrado.clique(3);
		assertEquals("XOXXOOOXX", quadrado.getEstado());
		
		//Caso 4: testar Clique(4)
		quadrado = new Quadrado("XXOXOXOXX");
		quadrado.clique(4);
		assertEquals("OXOOOXXXX", quadrado.getEstado());
		
		//Caso 5: testar Clique(5)
		quadrado = new Quadrado("XXOXOXOXX");
		quadrado.clique(5);
		assertEquals("XOOOXOOOX", quadrado.getEstado());
		
		//Caso 6: testar Clique(6)
		quadrado = new Quadrado("XXOXOXOXX");
		quadrado.clique(6);
		assertEquals("XXXXOOOXO", quadrado.getEstado());
		
		//Caso 7: testar Clique(7)
		quadrado = new Quadrado("XXOXOXOXX");
		quadrado.clique(7);
		assertEquals("XXOOOXXOX", quadrado.getEstado());
		
		//Caso 8: testar Clique(8)
		quadrado = new Quadrado("XXOXOXOXX");
		quadrado.clique(8);
		assertEquals("XXOXOXXOO", quadrado.getEstado());
		
		//Caso 9: testar Clique(9)
		quadrado = new Quadrado("XXOXOXOXX");
		quadrado.clique(9);
		assertEquals("XXOXOOOOO", quadrado.getEstado());
	}
	
	@Test
	void testInverte() {
		Quadrado quadrado = new Quadrado("XXXXXXXXX");
		quadrado.inverte(0);
		assertEquals("OXXXXXXXX", quadrado.getEstado());
		quadrado.inverte(8);
		assertEquals("OXXXXXXXO", quadrado.getEstado());
	}

}
