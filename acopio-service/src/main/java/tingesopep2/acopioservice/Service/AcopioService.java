package tingesopep2.acopioservice.Service;

import lombok.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tingesopep2.acopioservice.Repository.AcopioRepository;
import tingesopep2.acopioservice.Model.AcopioEntity;

import java.io.BufferedReader;
import java.io.FileReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Service
public class AcopioService {

    @Autowired
    private AcopioRepository acopioRepository;
    private final Logger logg = LoggerFactory.getLogger(AcopioService.class);

    public ArrayList<AcopioEntity> obtenerData() {
        return (ArrayList<AcopioEntity>) acopioRepository.findAll();
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
        acopioRepository.deleteAll();
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
                    guardarDataDB(bfRead.split(";")[0], bfRead.split(";")[1], bfRead.split(";")[2], bfRead.split(";")[3]);
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

    public void guardarDataDB(String fecha, String turno, String proveedor, String kls_leche){
        AcopioEntity newData = new AcopioEntity();
        if(fecha != null){
            try {
                Date date = new SimpleDateFormat("yyyy/MM/dd").parse(fecha);
                newData.setFecha(date);
            }
            catch (ParseException pe){
                throw new RuntimeException(pe);
            }
        }
        newData.setTurno(turno);
        newData.setProveedorCodigo(proveedor);
        newData.setKls_leche(Integer.valueOf(kls_leche));
        guardarData(newData);
    }

    public void guardarData(AcopioEntity data){
        acopioRepository.save(data);
    }

    public ArrayList<Integer> kls_lecheByProveedorCodigo(String proveedor) {
        return acopioRepository.kls_lecheByProveedorCodigo(proveedor);
    }

    public ArrayList<Date> fechasByProveedorCodigo(String proveedor) {
        return acopioRepository.fechasByProveedorCodigo(proveedor);
    }

    public ArrayList<AcopioEntity> acopioByproveedorCodigo(String proveedor){
        return acopioRepository.acopioByProveedorCodigo(proveedor);
    }

    public Integer countAcopioByproveedorCodigoAndTurno(String proveedor, String turno){
        return acopioRepository.countAcopioByProveedorCodigoAndTurno(proveedor, turno);
    }
}