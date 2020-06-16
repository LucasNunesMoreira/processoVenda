package dev.lucas.procss.repository;

import dev.lucas.procss.models.Vendedor;
import org.springframework.data.repository.CrudRepository;

public interface VendedorRepository extends CrudRepository<Vendedor, String> {
    Vendedor findByidVendedor(long idVendedor);
}
