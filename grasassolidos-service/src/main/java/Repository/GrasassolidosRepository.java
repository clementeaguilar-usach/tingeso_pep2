package Repository;

import Model.GrasassolidosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrasassolidosRepository extends JpaRepository<GrasassolidosEntity, Integer> {
}
