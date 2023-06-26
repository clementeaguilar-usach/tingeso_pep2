package tingesopep2.acopioservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tingesopep2.acopioservice.Model.AcopioEntity;

import java.util.ArrayList;
import java.util.Date;

@Repository
public interface AcopioRepository extends JpaRepository<AcopioEntity, Integer> {

    @Query("select a.fecha from AcopioEntity a where a.proveedorCodigo = :proveedorCodigo")
    ArrayList<Date> fechasByProveedorCodigo(@Param("proveedorCodigo") String proveedorCodigo);

    @Query("select a.kls_leche from AcopioEntity a where a.proveedorCodigo = :proveedorCodigo")
    ArrayList<Integer> kls_lecheByProveedorCodigo(@Param("proveedorCodigo") String proveedorCodigo);

    @Query("select a from AcopioEntity a where a.proveedorCodigo = :proveedorCodigo")
    ArrayList<AcopioEntity> acopioByProveedorCodigo(@Param("proveedorCodigo") String proveedorCodigo);

    @Query("select count(a) from AcopioEntity a where a.proveedorCodigo = :proveedorCodigo and a.turno = :turno")
    Integer countAcopioByProveedorCodigoAndTurno(@Param("proveedorCodigo") String proveedorCodigo,
                                                         @Param("turno") String turno);
}
