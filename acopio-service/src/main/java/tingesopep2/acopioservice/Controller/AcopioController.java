package tingesopep2.acopioservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tingesopep2.acopioservice.Model.AcopioEntity;
import tingesopep2.acopioservice.Service.AcopioService;

import java.util.ArrayList;
import java.util.Date;

@RestController
@RequestMapping("/acopios")
public class AcopioController {

    @Autowired
    AcopioService acopioService;

    @GetMapping("/kls_leche/{proveedorCodigo}")
    public ResponseEntity<ArrayList<Integer>> kls_lecheByProveedor(@PathVariable("proveedorCodigo") String proveedorCodigo) {
        return ResponseEntity.ok(acopioService.kls_lecheByProveedorCodigo(proveedorCodigo));
    }

    @GetMapping("/fechas/{proveedorCodigo}")
    public ResponseEntity<ArrayList<Date>> fechasByProveedorCodigo(@PathVariable("proveedorCodigo") String proveedorCodigo) {
        return ResponseEntity.ok(acopioService.fechasByProveedorCodigo(proveedorCodigo));
    }

    @GetMapping("/{proveedorCodigo}")
    public ResponseEntity<ArrayList<AcopioEntity>> acopioByProveedorCodigo(@PathVariable("proveedorCodigo") String proveedorCodigo) {
        return ResponseEntity.ok(acopioService.acopioByproveedorCodigo(proveedorCodigo));
    }

    @GetMapping("/acopio/{proveedorCodigo}/{turno}")
    public ResponseEntity<Integer> countAcopioByProveedorCodigoAndTurno(@PathVariable("proveedorCodigo") String proveedorCodigo,
                                                                        @PathVariable("turno") String turno) {
        return ResponseEntity.ok(acopioService.countAcopioByproveedorCodigoAndTurno(proveedorCodigo, turno));
    }

    @PostMapping("/fileUpload/")
    public String cargarAcopio(@RequestParam("file")MultipartFile file,
                                                     RedirectAttributes redirectAttributes) {
        acopioService.guardar(file);
        acopioService.leerCsv("acopio.csv");
        return "Se leyó Acopio.csv correctamente";
    }
}
