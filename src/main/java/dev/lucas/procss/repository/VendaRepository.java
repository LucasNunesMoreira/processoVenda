package dev.lucas.procss.repository;

import dev.lucas.procss.models.Venda;
import org.springframework.data.repository.CrudRepository;

public interface VendaRepository extends CrudRepository<Venda, String> {

    Venda findAllBydataVendaBetween(String inicio, String fim);

    //Venda count(long idVenda);

}
