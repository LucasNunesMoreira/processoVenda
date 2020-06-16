package dev.lucas.procss.repository;

import dev.lucas.procss.models.Venda;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface VendaRepository extends CrudRepository<Venda, String> {

    Iterable<Venda> findAllBydataVendaBetween(String inicio, String fim);
    //ArrayList<Venda> findidVendedorDistinct(ArrayList<Venda> vendas);

    //ArrayList<String> countByidVendedor(Iterable<Venda> vendas);
    ArrayList<String> countBydataVendaBetween(String inicio, String fim);

}