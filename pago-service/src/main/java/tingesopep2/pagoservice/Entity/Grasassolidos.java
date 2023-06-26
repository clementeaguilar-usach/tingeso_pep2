package tingesopep2.pagoservice.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Grasassolidos {
    private String proveedorCodigo;
    private Integer p_grasa;
    private Integer p_solidototal;
    private Date fecha;
}
