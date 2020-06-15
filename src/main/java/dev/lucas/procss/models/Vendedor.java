package dev.lucas.procss.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Vendedor implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idVendedor;
    private String nomeVendedor;
    @OneToMany
    private List<Venda> vendas;

    public long getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(long idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getNomeVendedor() {
        return nomeVendedor;
    }

    public void setNomeVendedor(String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
    }
}
