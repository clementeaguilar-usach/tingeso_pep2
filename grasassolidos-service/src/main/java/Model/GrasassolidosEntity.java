package Model;

import com.fasterxml.jackson.databind.DatabindException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "grasassolidos")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GrasassolidosEntity {
    @Id
    @NonNull
    private Integer id;
    private String proveedorCodigo;
    private Integer p_grasa;
    private Integer p_solidototal;
    private Date fecha;
}
