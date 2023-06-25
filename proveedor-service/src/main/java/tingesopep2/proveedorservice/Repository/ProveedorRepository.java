package tingesopep2.proveedorservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tingesopep2.proveedorservice.Model.ProveedorEntity;

@Repository
public interface ProveedorRepository extends JpaRepository<ProveedorEntity, String> {
    ProveedorEntity findByCodigo(String codigo);
}
