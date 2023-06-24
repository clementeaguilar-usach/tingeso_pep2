package tingesopep2.proveedorservice.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proveedores")
public class prueba {
    @GetMapping
    public String pruebaXD(){
        return "hola";
    }
}
