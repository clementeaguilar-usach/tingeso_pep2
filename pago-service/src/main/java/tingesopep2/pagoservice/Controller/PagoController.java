package tingesopep2.pagoservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tingesopep2.pagoservice.Model.PagoEntity;
import tingesopep2.pagoservice.Service.PagoService;

import java.util.ArrayList;

@RestController
@RequestMapping("/pagos")
public class PagoController {

    @Autowired
    PagoService pagoService;

    @PostMapping("/calcular/{proveedorCodigo}")
    public String pagoFinal(@PathVariable("proveedorCodigo") String proveedorCodigo) {
        pagoService.setPagoFinal(proveedorCodigo);
        return "Se calculó el pago para el proveedor " + pagoService.nombreProveedor(proveedorCodigo);
    }

    @GetMapping("/pagoFinal")
    public ArrayList<PagoEntity> getAllPagos() {
        return pagoService.getAllPagos();
    }
}
