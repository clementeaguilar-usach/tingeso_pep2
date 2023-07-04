package tingesopep2.grasassolidosservice.Controller;

import tingesopep2.grasassolidosservice.Model.GrasassolidosEntity;
import tingesopep2.grasassolidosservice.Service.GrasassolidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@RequestMapping("/grasassolidos")
public class GrasassolidosController {

    @Autowired
    private GrasassolidosService grasassolidosService;

    @GetMapping("/{proveedorCodigo}")
    public ResponseEntity<GrasassolidosEntity> gsByProveedorCodigo(@PathVariable("proveedorCodigo")
                                                                              String proveedorCodigo) {
        return ResponseEntity.ok(grasassolidosService.gsByProveedorCodigo(proveedorCodigo));
    }

    @PostMapping("/fileUpload")
    public String cargarGrasasSolidos(@RequestParam("file")MultipartFile file,
                                      RedirectAttributes redirectAttributes) {
        grasassolidosService.guardar(file);
        grasassolidosService.leerCsv("datos.csv");
        return "Se leyó Datos.csv correctamente";
    }

    @GetMapping("/hola")
    public String hola() {
        return "Hola";
    }
}
