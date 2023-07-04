package Service;

import Model.GrasassolidosEntity;
import Repository.GrasassolidosRepository;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Service
public class GrasassolidosService {

    @Autowired
    private GrasassolidosRepository grasassolidosRepository;
    private final Logger logg = LoggerFactory.getLogger(GrasassolidosService.class);

    public GrasassolidosEntity gsByProveedorCodigo(String proveedorCodigo) {
        return grasassolidosRepository.gsByProveedorCodigo(proveedorCodigo);
    }

    public String guardar(MultipartFile file){
        String filename = file.getOriginalFilename();
        if(filename != null){
            if(!file.isEmpty()){
                try{
                    byte [] bytes = file.getBytes();
                    Path path  = Paths.get(file.getOriginalFilename());
                    Files.write(path, bytes);
                    logg.info("Archivo guardado");
                }
                catch (IOException e){
                    logg.error("ERROR", e);
                }
            }
            return "Archivo guardado con exito!";
        }
        else{
            return "No se pudo guardar el archivo";
        }
    }

    @Generated
    public void leerCsv(String direccion){
        String texto = "";
        BufferedReader bf = null;
        grasassolidosRepository.deleteAll();
        try{
            bf = new BufferedReader(new FileReader(direccion));
            String temp = "";
            String bfRead;
            int count = 1;
            while((bfRead = bf.readLine()) != null){
                if (count == 1){
                    count = 0;
                }
                else{
                    guardarDataDB(bfRead.split(";")[0], bfRead.split(";")[1], bfRead.split(";")[2]);
                    temp = temp + "\n" + bfRead;
                }
            }
            texto = temp;
            System.out.println("Archivo leido exitosamente");
        }catch(Exception e){
            System.err.println("No se encontro el archivo");
        }finally{
            if(bf != null){
                try{
                    bf.close();
                }catch(IOException e){
                    logg.error("ERROR", e);
                }
            }
        }
    }

    public void guardarDataDB(String proveedorCodigo, String p_grasa, String p_solidototal){
        GrasassolidosEntity newData = new GrasassolidosEntity();
        newData.setProveedorCodigo(proveedorCodigo);
        newData.setP_grasa(Integer.valueOf(p_grasa));
        newData.setP_solidototal(Integer.valueOf(p_solidototal));
        guardarData(newData);
    }

    public void guardarData(GrasassolidosEntity data){
        grasassolidosRepository.save(data);
    }
}
