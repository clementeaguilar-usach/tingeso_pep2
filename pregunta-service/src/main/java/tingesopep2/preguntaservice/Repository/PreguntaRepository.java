package tingesopep2.preguntaservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tingesopep2.preguntaservice.Model.PreguntaEntity;

import java.util.ArrayList;

@Repository
//Solicita traer 4 preguntas de cierta dificultad
public interface PreguntaRepository extends JpaRepository<PreguntaEntity, String> {
    @Query(value = "Select p.id, p.dificultad, p.codigo, p.respuesta, p.enunciado, " +
            "from pregunta as p " +
            "where p.dificultad = :dificultad " +
            "order by random()" +
            "limit 4",
            nativeQuery = true)
    ArrayList<PreguntaEntity> get4randPreguntasByDificultad(@Param("dificultad")String dificultad);
}
