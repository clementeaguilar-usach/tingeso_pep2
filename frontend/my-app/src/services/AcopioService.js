import axios from 'axios';

const ACOPIO_API_URL = "http://localhost:8080/acopios";

class acopioUploadService {

    uploadAcopio(file){
        return axios.post(ACOPIO_API_URL + "/fileUpload", file);
    }
}

export default new acopioUploadService()