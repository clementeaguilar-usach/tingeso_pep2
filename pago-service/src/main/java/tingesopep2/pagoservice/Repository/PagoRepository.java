package tingesopep2.pagoservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tingesopep2.pagoservice.Model.PagoEntity;

@Repository
public interface PagoRepository extends JpaRepository<PagoEntity, Integer> {
}
