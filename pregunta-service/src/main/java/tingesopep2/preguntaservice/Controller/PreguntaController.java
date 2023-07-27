package tingesopep2.preguntaservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tingesopep2.preguntaservice.Model.PreguntaEntity;
import tingesopep2.preguntaservice.Service.PreguntaService;

import java.util.ArrayList;

@RestController
@RequestMapping("/pregunta")
public class PreguntaController {

    @Autowired
    PreguntaService preguntaService;

    @PostMapping("/newPregunta")
    private ResponseEntity cargarPregunta(@RequestParam("dificultad") String dificultad,
                                          @RequestParam("codigo") String codigo,
                                          @RequestParam("respuesta") String respuesta,
                                          @RequestParam("enunciado") String enunciado) {
        preguntaService.guardarPregunta(dificultad, codigo, respuesta, enunciado);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/allPreguntas")
    private ResponseEntity<ArrayList<PreguntaEntity>> allPreguntas() {
        ArrayList<PreguntaEntity> preguntas;
        preguntas = preguntaService.getAllPreguntas();
        return ResponseEntity.ok(preguntas);
    }

    @GetMapping("/4preguntas/{dificultad}")
    private ResponseEntity<ArrayList<PreguntaEntity>> get4randPreguntasByDificultad(
            @PathVariable("dificultad")String dificultad) {
        return ResponseEntity.ok(preguntaService.get4randPreguntasByDificultad(dificultad));
    }
}
