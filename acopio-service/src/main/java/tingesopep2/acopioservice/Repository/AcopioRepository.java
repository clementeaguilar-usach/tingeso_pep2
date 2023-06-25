package tingesopep2.acopioservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tingesopep2.acopioservice.Model.AcopioEntity;

@Repository
public interface AcopioRepository extends JpaRepository<AcopioEntity, Integer> {
    AcopioEntity findByProveedor(String proveedor);
}
