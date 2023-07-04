package tingesopep2.grasassolidosservice.Service;

import tingesopep2.grasassolidosservice.Model.GrasassolidosEntity;
import tingesopep2.grasassolidosservice.Repository.GrasassolidosRepository;
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
import java.util.Date;

@Service
public class GrasassolidosService {

    @Autowired
    private GrasassolidosRepository grasassolidosRepository;
    private final Logger logg = LoggerFactory.getLogger(GrasassolidosService.class);

    public GrasassolidosEntity gsByProveedorCodigo(String proveedorCodigo) {
        return grasassolidosRepository.gsByProveedorCodigo(proveedorCodigo);
    }

    @Generated
    public String guardar(MultipartFile file) {
        String name = file.getOriginalFilename();
        if (name != null) {
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    Path path = Paths.get(file.getOriginalFilename());
                    Files.write(path, bytes);
                    logg.info("Archivo guardado");
                } catch (IOException e) {
                    logg.error("ERROR", e);
                }
            }
            return "Archivo guardado con exito";
        } else {
            return "No se ha guardado el archivo";
        }
    }

    @Generated
    public String leerCsv(String archivo) {
        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new FileReader(archivo));
            String temp = "";
            String bfRead;
            int count = 1;
            while ((bfRead = bf.readLine()) != null) {
                if (count == 1) {
                    count = 0;
                } else {
                    guardarData(bfRead.split(";")[0], bfRead.split(";")[1], bfRead.split(";")[2]);
                    temp = temp + "\n" + bfRead;
                }
            }
            return "Grasassolido cargado con exito";
        } catch (Exception e) {
            return "Error al cargar Grasassolido";
        } finally {
            if (bf != null) {
                try {
                    bf.close();
                } catch (IOException e) {
                    logg.error("ERROR", e);
                }
            }
        }
    }

    public void guardarData(String proveedor, String grasa, String solido) {
        GrasassolidosEntity data = new GrasassolidosEntity();
        data.setProveedorCodigo(proveedor);
        data.setP_grasa(Integer.valueOf(grasa));
        data.setP_solidototal(Integer.valueOf(solido));
        data.setFecha(new Date());
        grasassolidosRepository.save(data);
    }
}
