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
    public Integer pagoByCategoriaAndKlsLeche(String categoria, Integer kls_leche) {
        switch (categoria) {
            case "A":
                return 700 * kls_leche;
            case "B":
                return 550 * kls_leche;
            case "C":
                return 400 * kls_leche;
            case "D":
                return 250 * kls_leche;
            default:
                return 0;
        }
    }

    public Integer pagoByP_GrasaAndKlsLeche(String p_grasa, Integer kls_leche) {
        Integer int_p_grasa = Integer.parseInt(p_grasa);
        if (0 <= int_p_grasa && int_p_grasa <= 20) return 30 * kls_leche;
        if (21 <= int_p_grasa && int_p_grasa <= 45) return 80 * kls_leche;
        if (46 <= int_p_grasa) return 120 * kls_leche;
        return 0;
    }

    public Integer pagoByP_SolidototalAndKlsLeche(String p_solidototal, Integer kls_leche) {
        Integer int_p_solidototal = Integer.parseInt(p_solidototal);
        if (0 <= int_p_solidototal && int_p_solidototal <= 7) return -130 * kls_leche;
        if (8 <= int_p_solidototal && int_p_solidototal <= 18) return -90 * kls_leche;
        if (19 <= int_p_solidototal && int_p_solidototal >= 35) return 95 * kls_leche;
        if (36 <= int_p_solidototal) return 150 * kls_leche;
        return 0;
    }
    /*
    public Integer dias

    public Double bonificacionByFrecuenciaMT(ArrayList<Acopio> acopios) {

    }
     */
}
