package dev.lucas.procss.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Venda implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idVenda;
    private String dataVenda;
    private double valorVenda;
    @ManyToOne
    private Vendedor vendedor;

    public long getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(long idVenda) {
        this.idVenda = idVenda;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setNomeVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
}
