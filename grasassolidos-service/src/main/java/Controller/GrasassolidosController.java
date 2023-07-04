package Controller;

import Model.GrasassolidosEntity;
import Service.GrasassolidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

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
}
