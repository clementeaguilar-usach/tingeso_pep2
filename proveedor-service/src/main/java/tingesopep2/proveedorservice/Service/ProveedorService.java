package tingesopep2.proveedorservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tingesopep2.proveedorservice.Model.ProveedorEntity;
import tingesopep2.proveedorservice.ProveedorServiceApplication;
import tingesopep2.proveedorservice.Repository.ProveedorRepository;

import java.util.ArrayList;

@Service
public class ProveedorService {

    @Autowired
    ProveedorRepository proveedorRepository;

    public String nombreByCodigo(String codigo) {
        return proveedorRepository.proveedorByCodigo(codigo) != null?
                proveedorRepository.proveedorByCodigo(codigo).getNombre()
                :"No se encuentra proveedor con ese código (nombreByCodigo))";
    }

    public String categoriaByCodigo(String codigo) {
        return proveedorRepository.proveedorByCodigo(codigo) != null?
                proveedorRepository.proveedorByCodigo(codigo).getCategoria()
                :"No se encuentra proveedor con ese código (categoriaByCodigo)";
    }

    public String retencionByCodigo(String codigo) {
        return proveedorRepository.proveedorByCodigo(codigo) != null?
                proveedorRepository.proveedorByCodigo(codigo).getRetencion()
                :"No se encuentra proveedor con ese código (retencionByCodigo)";
    }

    public void saveProveedor(Integer id, String codigo, String nombre, String categoria, String retencion){
        ProveedorEntity nuevoProveedor = new ProveedorEntity(id, codigo, nombre, categoria, retencion);
        proveedorRepository.save(nuevoProveedor);
    }

    public ProveedorEntity saveProveedor(ProveedorEntity proveedor){
        ProveedorEntity proveedorNew = proveedorRepository.save(proveedor);
        return proveedorNew;
    }

    public ArrayList<ProveedorEntity> allProveedores() {
        return (ArrayList<ProveedorEntity>) proveedorRepository.findAll();
    }
}
