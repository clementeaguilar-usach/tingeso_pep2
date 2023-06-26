package tingesopep2.pagoservice.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Acopio {
    private Date fecha;
    private String turno;
    private String proveedorCodigo;
    private Integer kls_leche;
}
