import axios from 'axios';

const PROVEEDOR_API_URL = "http://localhost:8080/proveedores";

class proveedorService {

    createProveedor(proveedor){
        return axios.post(PROVEEDOR_API_URL +'/saveproveedor', proveedor);
    }
}

export default new proveedorService()