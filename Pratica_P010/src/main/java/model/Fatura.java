package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "Fatura")
public class Fatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; 

    private LocalDate data;
    private float ultimaLeitura;
    private float penultimaLeitura;
    private float valor;
    private boolean estadoPagamento = false;

    public Fatura() {

    }

    public Fatura(LocalDate data, float ultimaLeitura, float penultimaLeitura, float valor) {
        this.data = data;
        this.ultimaLeitura = ultimaLeitura;
        this.penultimaLeitura = penultimaLeitura;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public float getUltimaLeitura() {
        return ultimaLeitura;
    }

    public void setUltimaLeitura(float ultimaLeitura) {
        this.ultimaLeitura = ultimaLeitura;
    }

    public float getPenultimaLeitura() {
        return penultimaLeitura;
    }

    public void setPenultimaLeitura(float penultimaLeitura) {
        this.penultimaLeitura = penultimaLeitura;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public boolean isEstadoPagamento() {
        return estadoPagamento;
    }

    public void setEstadoPagamento(boolean estadoPagamento) {
        this.estadoPagamento = estadoPagamento;
    }
}
