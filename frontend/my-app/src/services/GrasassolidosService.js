import axios from 'axios';

const GRASASSOLIDOS_API_URL = "http://localhost:8080/grasassolidos";

class acopioUploadService {

    uploadKilos(file){
        return axios.post(GRASASSOLIDOS_API_URL + "/fileUpload", file);
    }
}

export default new grasassolidosUploadService();