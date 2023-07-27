package tingesopep2.preguntaservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tingesopep2.preguntaservice.Model.PreguntaEntity;
import tingesopep2.preguntaservice.Repository.PreguntaRepository;

import java.util.ArrayList;

@Service
public class PreguntaService {

    @Autowired
    PreguntaRepository preguntaRepository;

    public String guardarPregunta(String dificultad, String codigo, String respuesta, String enunciado) {
        PreguntaEntity newPregunta = new PreguntaEntity();
        newPregunta.setDificultad(dificultad);
        newPregunta.setCodigo(codigo);
        newPregunta.setRespuesta(respuesta);
        newPregunta.setEnunciado(enunciado);
        preguntaRepository.save(newPregunta);
        return "Se guardó la pregunta con éxito.";
    }

    public ArrayList<PreguntaEntity> getAllPreguntas(){
        return (ArrayList<PreguntaEntity>) preguntaRepository.findAll();
    }

    public ArrayList<PreguntaEntity> get4randPreguntasByDificultad(String dificultad) {
        return preguntaRepository.get4randPreguntasByDificultad(dificultad);
    }
}