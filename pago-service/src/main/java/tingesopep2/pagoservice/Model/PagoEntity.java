package tingesopep2.pagoservice.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pago")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PagoEntity {
    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date quincena;
    private String proveedorCodigo;
    private Integer p_grasa;
    private Integer p_solidostotal;
    private Integer kls_enviados;
    private Integer n_dias_frecuencia;
    private Integer var_leche;
    private Integer var_grasa;
    private Integer var_solidostotal;
    private Integer pago_leche;
    private Integer pago_grasa;
    private Integer pago_solidostotales;
    private Integer bonificacion_frecuencia;
    private Integer dcto_var_leche;
    private Integer dcto_var_grasa;
    private Integer dcto_var_solidostotales;
    private Integer retencion;
    private Integer descuentos;
    private Integer pago_acopio;
    private Integer pago_total;
    private Integer pago_final;
}
