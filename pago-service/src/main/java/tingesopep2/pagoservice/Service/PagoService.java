package tingesopep2.pagoservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tingesopep2.pagoservice.Repository.PagoRepository;

@Service
public class PagoService {

    @Autowired
    PagoRepository pagoRepository;
}
