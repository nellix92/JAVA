package it.contrader.service;

import it.contrader.converter.ImmagineConverter;
import it.contrader.dao.ImmagineRepository;
import it.contrader.dto.CasaDTO;
import it.contrader.dto.ImmagineDTO;
import it.contrader.model.Immagine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImmagineService extends AbstractService <Immagine, ImmagineDTO>{

    @Autowired
    ImmagineRepository immagineRepository;

    @Autowired
    ImmagineConverter immagineConverter;

    public List<ImmagineDTO> findAll(){
        return immagineConverter.toDTOList(immagineRepository.findAll());
    }

    public List<ImmagineDTO> findByCasaId(int id){
        return immagineConverter.toDTOList(immagineRepository.findByCasaId(id));
    }

    public ImmagineDTO findByUserId(int id){
        return immagineConverter.toDTO(immagineRepository.findByUserId(id));
    }

    public String uploadImage(MultipartFile imageFile) throws IOException {
        String projectDir = System.getProperty("user.dir"); // Ottieni la directory di lavoro corrente del progetto, user.dir e la cartella di default del sistema, quindi anche quando siamo su server diversi riesce a ricavare il percorso corretto
        String uploadDirectory = projectDir + File.separator + "images"; // Costruisci il percorso relativo alla cartella 'images'
        String fileName = System.currentTimeMillis() + "_" + imageFile.getOriginalFilename(); //System.currentTimeMilles e un metodo che restituisce il tempo attuale ed e stato utilizzato qui per randomizzare il nome dell'immagine
        File destinationFile = new File(uploadDirectory + File.separator + fileName);
        imageFile.transferTo(destinationFile);
        return fileName;
    }

    public boolean deleteImmagine(String name){
        String projectDir = System.getProperty("user.dir"); // Ottieni la directory di lavoro corrente del progetto, user.dir e la cartella di default del sistema, quindi anche quando siamo su server diversi riesce a ricavare il percorso corretto
        String uploadDirectory = projectDir + File.separator + "images"; // Costruisci il percorso relativo alla cartella 'images'
        File fileImage=new File(uploadDirectory + File.separator + name);
        return fileImage.delete();
    }

    public UrlResource getImmagine(String name) throws MalformedURLException {

        String projectDir = System.getProperty("user.dir"); // Ottieni la directory di lavoro corrente del progetto, user.dir e la cartella di default del sistema, quindi anche quando siamo su server diversi riesce a ricavare il percorso corretto
        String uploadDirectory = projectDir + File.separator + "images"; // Costruisci il percorso relativo alla cartella 'images'
        Path pathImmagine = Paths.get(uploadDirectory + File.separator + name);
        UrlResource urlResource = new UrlResource(pathImmagine.toUri());
        if(urlResource.exists()){
            return urlResource;
        }
        else return null;
    }

}
