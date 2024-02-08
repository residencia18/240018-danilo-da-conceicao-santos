package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Imovel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String matricula;
    private String endereco;
    private float ultimaLeitura;
    private float penultimaLeitura;
    private Integer idCliente;

    public Imovel(String matricula, String endereco, float ultimaLeitura, float penultimaLeitura) {
        this.matricula = matricula;
        this.endereco = endereco;
        this.ultimaLeitura = ultimaLeitura;
        this.penultimaLeitura = penultimaLeitura;
    }

    public Imovel() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
}
