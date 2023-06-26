package Repository;

import Model.GrasassolidosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface GrasassolidosRepository extends JpaRepository<GrasassolidosEntity, Integer> {

    @Query("select gs from GrasassolidosEntity gs where gs.proveedorCodigo = :proveedorCodigo")
    ArrayList<GrasassolidosEntity> gsByProveedorCodigo(@Param("proveedorCodigo") String proveedorCodigo);
}


