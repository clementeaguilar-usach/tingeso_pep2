package tingesopep2.pagoservice.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "pago")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PagoEntity {
    @Id
    @NonNull
    private Integer id;
    private Date quincena;
    private double total_kls;
    private double nro_dias_leche;
    private double promedio_leche;
    private double variacion_leche;
    private double variacion_grasa;
    private double variacion_st;
    private double pago_leche;
    private double pago_grasa;
    private double pago_st;
    private double bonificacion_frecuencia;
    private double dcto_variacion_leche;
    private double dcto_variacion_grasa;
    private double dcto_variacion_st;
    private double pago_final;
    private double pago_total;
    private double retencion;
    private double pago_acopio;
    private double descuentos;
    private String proveedor;
    private double grasa;
    private double st;
}
