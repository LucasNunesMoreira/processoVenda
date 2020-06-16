package dev.lucas.procss.repository;

import dev.lucas.procss.models.Venda;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface VendaRepository extends CrudRepository<Venda, String> {
    // Faz a selecao das datas
    Iterable<Venda> findAllBydataVendaBetween(String inicio, String fim);
    // Faz agrupamento por id
    //Iterable<Venda> findAllgroupByvendedor(Venda venda);


    //@Query(value = "SELECT * FROM Venda")
    ArrayList<Long> countBydataVendaBetween(String inicio, String fim);
}
   /* SELECT count(ID_VENDA), AVG(VALOR_VENDA) FROM VENDA
        WHERE DATA_VENDA BETWEEN 'inicio' AND 'fim'
        GROUP BY VENDEDOR_ID_VENDEDOR;*/