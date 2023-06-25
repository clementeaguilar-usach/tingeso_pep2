package tingesopep2.acopioservice.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "acopio")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AcopioEntity {
    @Id
    @NonNull
    private Integer id;
    private Date fecha;
    private String turno;
    private String proveedor;
    private Integer kls_leche;
}
