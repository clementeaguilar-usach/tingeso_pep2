package Controller;

import Service.GrasassolidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@RequestMapping("/grasassolidos")
public class GrasassolidosController {

    @Autowired
    private GrasassolidosService grasassolidosService;

    @PostMapping("/fileUpload")
    public String cargarGrasasSolidos(@RequestParam("file")MultipartFile file,
                                      RedirectAttributes redirectAttributes) {
        grasassolidosService.guardar(file);
        grasassolidosService.leerCsv("datos.csv");
        return "Se leyó Datos.csv correctamente";
    }
}
