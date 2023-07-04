package tingesopep2.grasassolidosservice.Repository;

import tingesopep2.grasassolidosservice.Model.GrasassolidosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GrasassolidosRepository extends JpaRepository<GrasassolidosEntity, Integer> {

    @Query("select gs from GrasassolidosEntity gs where gs.proveedorCodigo = :proveedorCodigo")
    GrasassolidosEntity gsByProveedorCodigo(@Param("proveedorCodigo") String proveedorCodigo);
}


