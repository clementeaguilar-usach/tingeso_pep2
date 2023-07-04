import axios from 'axios';

const PAGOS_API_URL = "http://localhost:8080/pagos";
class pagosService {

    calcularPago(codigoProveedor){
        return axios.post(PAGOS_API_URL + "/calcular/" + codigoProveedor);
    }

    getPagos(){
        return axios.get(PAGOS_API_URL + '/pagoFinal');
    }
}

export default new pagosService();