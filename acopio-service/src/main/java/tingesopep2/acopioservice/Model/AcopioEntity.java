package tingesopep2.acopioservice.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "acopio")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AcopioEntity {
    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date fecha;
    private String turno;
    private String proveedorCodigo;
    private Integer kls_leche;
}
