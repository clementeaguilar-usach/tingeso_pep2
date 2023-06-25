package tingesopep2.proveedorservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tingesopep2.proveedorservice.Model.ProveedorEntity;

@Repository
public interface ProveedorRepository extends JpaRepository<ProveedorEntity, String> {
    @Query("select p from ProveedorEntity p where p.codigo = :codigo ")
    ProveedorEntity proveedorByCodigo(@Param("codigo") String codigo);
}
