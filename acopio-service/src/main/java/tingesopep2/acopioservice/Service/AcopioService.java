package tingesopep2.acopioservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tingesopep2.acopioservice.Repository.AcopioRepository;

import java.util.ArrayList;
import java.util.Date;

@Service
public class AcopioService {

    @Autowired
    private AcopioRepository acopioRepository;
    /*
    public ArrayList<Date> dateByProveedor(String proveedor) {
        return acopioRepository.fechasByProveedor(proveedor)
    }
    */
}
