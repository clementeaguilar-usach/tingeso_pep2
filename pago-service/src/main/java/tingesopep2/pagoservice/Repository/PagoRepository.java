package tingesopep2.pagoservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tingesopep2.pagoservice.Model.PagoEntity;

import java.util.ArrayList;

@Repository
public interface PagoRepository extends JpaRepository<PagoEntity, Integer> {

    @Query("select p from PagoEntity p where p.proveedorCodigo = :proveedorCodigo")
    ArrayList<PagoEntity> pagoByProveedorCodigo(@Param("proveedorCodigo") String proveedorCodigo);
}
