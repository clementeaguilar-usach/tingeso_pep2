package tingesopep2.grasassolidosservice.Model;

import com.fasterxml.jackson.databind.DatabindException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "grasassolidos")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GrasassolidosEntity {
    @Id
    @NonNull
    @SequenceGenerator(name = "grasassolidos_sequence", sequenceName = "grasassolidos_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "grasassolidos_sequence")
    private Integer id;
    private String proveedorCodigo;
    private Integer p_grasa;
    private Integer p_solidototal;
    private Date fecha;
}
