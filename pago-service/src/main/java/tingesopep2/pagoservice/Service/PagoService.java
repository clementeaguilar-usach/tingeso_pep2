package tingesopep2.pagoservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tingesopep2.pagoservice.Entity.Acopio;
import tingesopep2.pagoservice.Entity.Grasassolidos;
import tingesopep2.pagoservice.Model.PagoEntity;
import tingesopep2.pagoservice.Repository.PagoRepository;

import java.text.SimpleDateFormat;
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

    public ArrayList<String> fechasByProveedorCodigo(String proveedorCodigo) {
        return restTemplate.getForObject("http://acopio-service/acopios/fechas/"
        + proveedorCodigo, ArrayList.class);
    }

    public ArrayList<Acopio> acopioByProveedorCodigo(String proveedorCodigo) {
        return restTemplate.getForObject("http://acopio-service/acopios/"
        + proveedorCodigo, ArrayList.class);
    }

    public Integer countAcopioByProveedorCodigoAndTurno(String proveedorCodigo, String turno) {
        return restTemplate.getForObject("http://acopio-service/acopios/acopio/"
        + proveedorCodigo + "/" + turno, Integer.class);
    }

    //Grasassolidos
    public Grasassolidos gsByProveedorCodigo(String proveedorCodigo) {
        return restTemplate.getForObject("http://grasassolidos-service/grasassolidos/"
        + proveedorCodigo, Grasassolidos.class);
    }
    //Proveedor
    public String nombreProveedor(String codigo) {
        return restTemplate.getForObject("http://proveedor-service/proveedores/nombre/" + codigo, String.class);
    }

    public String categoriaProveedor(String codigo) {
        //System.out.println(codigo);
        return restTemplate.getForObject("http://proveedor-service/proveedores/categoria/" + codigo, String.class);
    }

    public String retencionProveedor(String codigo) {
        return restTemplate.getForObject("http://proveedor-service/proveedores/retencion/" + codigo, String.class);
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

    public Integer pagoByPGrasaAndKlsLeche(Integer p_grasa, Integer kls_leche) {
        if (0 <= p_grasa && p_grasa <= 20) return 30 * kls_leche;
        if (21 <= p_grasa && p_grasa <= 45) return 80 * kls_leche;
        if (46 <= p_grasa) return 120 * kls_leche;
        return 0;
    }

    public Integer pagoByPSolidototalAndKlsLeche(Integer p_solidototal, Integer kls_leche) {
        if (0 <= p_solidototal && p_solidototal <= 7) return -130 * kls_leche;
        if (8 <= p_solidototal && p_solidototal <= 18) return -90 * kls_leche;
        if (19 <= p_solidototal && p_solidototal >= 35) return 95 * kls_leche;
        if (36 <= p_solidototal) return 150 * kls_leche;
        return 0;
    }

    public Integer dctoByVarKlsLeche(Integer var_klsLeche, Integer pagoLeche) {
        if (0 <= var_klsLeche && var_klsLeche <= 8) return 0;
        if (9 <= var_klsLeche && var_klsLeche <= 25) return (int)(pagoLeche * 0.07);
        if (26 <= var_klsLeche && var_klsLeche <= 45) return (int)(pagoLeche * 0.15);
        if (46 <= var_klsLeche) return (int)(pagoLeche * 0.3);
        return 0;
    }

    public Integer dctoByVarPGrasa(Integer var_pGrasa, Integer pagoLeche) {
        if (0 <= var_pGrasa && var_pGrasa <= 15) return 0;
        if (16 <= var_pGrasa && var_pGrasa <= 25) return (int)(pagoLeche * 0.12);
        if (26 <= var_pGrasa && var_pGrasa <= 40) return (int)(pagoLeche * 0.2);
        if (41 <= var_pGrasa) return (int)(pagoLeche * 0.3);
        return 0;
    }

    public Integer dctoByVarPSolidototal(Integer var_pSolidototal, Integer pagoLeche) {
        if (0 <= var_pSolidototal && var_pSolidototal <= 6) return 0;
        if (7 <= var_pSolidototal && var_pSolidototal <= 12) return (int)(pagoLeche * 0.18);
        if (13 <= var_pSolidototal && var_pSolidototal <= 35) return (int)(pagoLeche * 0.22);
        if (36 <= var_pSolidototal) return (int)(pagoLeche * 0.45);
        return 0;
    }

    public Integer bonificacionByFrecuenciaAcopio(String codigoProveedor, Integer pagoLeche) {
        ArrayList<Acopio> acopios = acopioByProveedorCodigo(codigoProveedor);
        Integer totalEnvios = acopios.size();
        Integer enviosM = countAcopioByProveedorCodigoAndTurno(codigoProveedor, "M");
        Integer enviosT = countAcopioByProveedorCodigoAndTurno(codigoProveedor, "T");
        if (totalEnvios == enviosM) return (int)(pagoLeche * 0.12);
        if (totalEnvios == enviosT) return (int)(pagoLeche * 0.08);
        else return (int)(pagoLeche * 0.2);
    }

    public Integer retencion(Integer pago_total, String proveedorCodigo) {
        if (retencionProveedor(proveedorCodigo).equals("Si") &&
                pago_total >= 950000) return (int)(pago_total * 0.13);
        else return 0;
    }

    public Integer kls_enviadosByProveedor(String proveedorCodigo) {
        ArrayList<Integer> kilosList = kls_lecheByProveedor(proveedorCodigo);
        Integer kls_enviados = 0;
        for (Integer i = 0; i < kilosList.size(); i++) {
            kls_enviados = kls_enviados + kilosList.get(i);
        }
        return kls_enviados;
    }

    public void variacionesByProveedorCodigo(String proveedorCodigo, PagoEntity nuevoPago) {
        ArrayList<PagoEntity> pagos = pagoRepository.pagoByProveedorCodigo(proveedorCodigo);
        if (pagos.size() == 0) {
            nuevoPago.setVar_grasa(0);
            nuevoPago.setVar_leche(0);
            nuevoPago.setVar_solidostotal(0);
        }
        else {
            Integer var_grasa = nuevoPago.getP_grasa() - pagos.get(0).getP_grasa();
            Integer var_solidototal = nuevoPago.getP_solidostotal() - pagos.get(0).getP_solidostotal();
            Integer var_leche = (nuevoPago.getKls_enviados() * 100) / pagos.get(0).getKls_enviados();
            nuevoPago.setVar_grasa(var_grasa);
            nuevoPago.setVar_solidostotal(var_solidototal);
            nuevoPago.setVar_leche(var_leche);
        }
    }

    public void setPagoFinal(String proveedorCodigo) {
        PagoEntity pago = new PagoEntity();
        pago.setQuincena(new Date());
        pago.setProveedorCodigo(proveedorCodigo);
        pago.setP_grasa(gsByProveedorCodigo(proveedorCodigo).getP_grasa());
        pago.setP_solidostotal(gsByProveedorCodigo(proveedorCodigo).getP_solidototal());
        pago.setKls_enviados(kls_enviadosByProveedor(proveedorCodigo));
        ArrayList<Acopio> acopios = acopioByProveedorCodigo(proveedorCodigo);
        Integer totalEnvios = acopios.size();
        pago.setN_dias_frecuencia(totalEnvios);
        variacionesByProveedorCodigo(proveedorCodigo, pago);
        pago.setPago_leche(pagoByCategoriaAndKlsLeche(categoriaProveedor(proveedorCodigo), pago.getKls_enviados()));
        pago.setPago_grasa(pagoByPGrasaAndKlsLeche(pago.getP_grasa(), pago.getKls_enviados()));
        pago.setPago_solidostotales(pagoByPSolidototalAndKlsLeche(pago.getP_solidostotal(), pago.getKls_enviados()));
        pago.setBonificacion_frecuencia(bonificacionByFrecuenciaAcopio(proveedorCodigo, pago.getPago_leche()));
        pago.setDcto_var_leche(dctoByVarKlsLeche(pago.getKls_enviados(), pago.getPago_leche()));
        pago.setDcto_var_grasa(dctoByVarPGrasa(pago.getVar_grasa(), pago.getPago_leche()));
        pago.setDcto_var_solidostotales(dctoByVarPSolidototal(pago.getVar_solidostotal(), pago.getPago_leche()));
        pago.setPago_acopio(pago.getPago_leche()
                + pago.getPago_grasa() + pago.getPago_solidostotales() + pago.getBonificacion_frecuencia());
        pago.setDescuentos(pago.getDcto_var_grasa()
                + pago.getDcto_var_leche() + pago.getDcto_var_solidostotales());
        pago.setPago_total(pago.getPago_acopio() - pago.getDescuentos());
        pago.setRetencion(retencion(pago.getPago_total(), proveedorCodigo));
        pago.setPago_final(pago.getPago_total() - pago.getRetencion());
        System.out.println(pago);
        pagoRepository.save(pago);
    }

    public ArrayList<PagoEntity> getAllPagos(){
        return (ArrayList<PagoEntity>) pagoRepository.findAll();
    }
}
