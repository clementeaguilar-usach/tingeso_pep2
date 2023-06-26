package tingesopep2.pagoservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tingesopep2.pagoservice.Entity.Acopio;
import tingesopep2.pagoservice.Entity.Grasassolidos;
import tingesopep2.pagoservice.Repository.PagoRepository;

import java.util.ArrayList;
import java.util.Date;

@Service
public class PagoService {

    @Autowired
    private PagoRepository pagoRepository;
    @Autowired
    private RestTemplate restTemplate;

    //Rest Controller de Entities
    //Acopio
    public ArrayList<Integer> kls_lecheByProveedor(String proveedorCodigo) {
        return restTemplate.getForObject("http://acopio-service/acopios/kls_leche/"
        + proveedorCodigo, ArrayList.class);
    }

    public ArrayList<Date> fechasByProveedorCodigo(String proveedorCodigo) {
        return restTemplate.getForObject("http://acopio-service/acopios/fechas/"
        + proveedorCodigo, ArrayList.class);
    }

    public ArrayList<Acopio> acopioByProveedorCodigo(String proveedorCodigo) {
        return restTemplate.getForObject("http://acopio-service/acopios/"
        + proveedorCodigo, ArrayList.class);
    }

    public Integer countAcopioByProveedorCodigoAndTurno(String proveedorCodigo, String turno) {
        return restTemplate.getForObject("http://acopio-service/acopios/"
        + proveedorCodigo + "/" + turno, Integer.class);
    }

    //Grasassolidos
    public ArrayList<Grasassolidos> gsByProveedorCodigo(String proveedorCodigo) {
        return restTemplate.getForObject("http://grasassolidos-service/grasassolidos"
        + proveedorCodigo, ArrayList.class);
    }
    //Proveedor
    public String nombreProveedor(String codigo) {
        return restTemplate.getForObject("http://proveedores/nombre/" + codigo, String.class);
    }

    public String categoriaProveedor(String codigo) {
        return restTemplate.getForObject("http://proveedores/categoria/" + codigo, String.class);
    }

    public String retencionProveedor(String codigo) {
        return restTemplate.getForObject("http://proveedores/retencion/" + codigo, String.class);
    }

    //Pago
}
