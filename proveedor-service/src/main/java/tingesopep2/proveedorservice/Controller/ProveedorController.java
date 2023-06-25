package tingesopep2.proveedorservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tingesopep2.proveedorservice.Service.ProveedorService;

@RestController
@RequestMapping("/proveedores")
public class ProveedorController {

    @Autowired
    ProveedorService proveedorService;

    @GetMapping("/nombre/{codigo}")
    public ResponseEntity<String> nombreProveedor(@PathVariable("codigo") String codigo){
        return ResponseEntity.ok(proveedorService.nombreByCodigo(codigo));
    }

    @GetMapping("/categoria/{codigo}")
    public ResponseEntity<String> categoriaProveedor(@PathVariable("codigo") String codigo) {
        return ResponseEntity.ok(proveedorService.categoriaByCodigo(codigo));
    }

    @GetMapping("/retencion/{codigo}")
    public ResponseEntity<String> retencionProveedor(@PathVariable("codigo") String codigo) {
        return ResponseEntity.ok(proveedorService.retencionByCodigo(codigo));
    }
}
