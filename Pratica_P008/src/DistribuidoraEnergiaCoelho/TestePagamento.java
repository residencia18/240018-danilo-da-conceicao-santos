package DistribuidoraEnergiaCoelho;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class TestePagamento {

	 @Test
	    void testConstrutorPagamento() {
	        LocalDate data = LocalDate.now();
	      //***********caso 1 : tentar enserir um Pagamento 
	        try {
	            new Pagamento(100.0f, data);
	        } catch (IllegalArgumentException e) {
	            fail("Construtor inválido");
	        }        
	        Pagamento pagamento = new Pagamento(100.0f, data);     
	        assertEquals(100.0f, pagamento.getValor());
	        assertEquals(data, pagamento.getData());
	        // Verifica se o reembolso é inicializado como null
	        assertNull(pagamento.getReembolso());
	    }
	 
	 @Test
	    void testSetterspagamento() {
	        LocalDate data = LocalDate.now();
	        Pagamento pagamento = new Pagamento();

	        pagamento.setValor(150.0f);
	        pagamento.setData(data);
	        // Verifica se os valores foram atribuídos corretamente
	        assertEquals(150.0f, pagamento.getValor());
	        assertEquals(data, pagamento.getData());
	    }

	 	//verificar reembolso a um pagamento
	    @Test
	    void testReembolso() {
	    	float valor = 50.0f;
	        Reembolso reembolso = new Reembolso(valor, null);
	        Pagamento pagamento = new Pagamento();
	        
	        pagamento.setReembolso(reembolso);

	        assertNotNull(pagamento.getReembolso());
	        assertEquals(valor, pagamento.getReembolso().getValor());
	    }
	   
	 // Teste para garantir que o setter não aceita valor negativo
	    @Test
	    void testSetValorNegativo()throws Exception {
	    	float valor = -30.0f;
	    	Pagamento pagamento = new Pagamento();    	
	    	try {
	    		pagamento.setValor(valor);
	    	}catch (Exception e) {
		    	assertEquals("O valor deve ser positivo", e.getMessage());
	    	}
	    	
	    	assertEquals(valor, pagamento.getValor());

	    }
	    
	    
}
