package DistribuidoraEnergiaCoelho;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class TestePagamento {

	 @Test
	    void testConstrutorPagamento() {
	        LocalDate data = LocalDate.now();
	        Pagamento pagamento = new Pagamento(100.0f, data);

	        assertEquals(100.0f, pagamento.getValor());
	        assertEquals(data, pagamento.getData());
	        assertNull(pagamento.getReembolso());
	    }

}
