package it.contrader.service;
import it.contrader.converter.AnagraficaConverter;
import it.contrader.dao.AnagraficaRepostory;
import it.contrader.dto.AnagraficaDTO;
import it.contrader.model.Anagrafica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AnagraficaService extends AbstractService<Anagrafica, AnagraficaDTO> {
    @Autowired
    AnagraficaRepostory anagraficaRepostory;
    @Autowired
    AnagraficaConverter anagraficaConverter;

    public AnagraficaDTO findByUserId(Long id){
        return anagraficaConverter.toDTO(anagraficaRepostory.findByUser_id(id));
    }
//    public AnagraficaDTO findById(Long id){
//        return anagraficaConverter.toDTO(anagraficaRepostory.findById(id).orElseThrow(()-> new RuntimeException("idAnagrafica non trovato")));
//    }
//
//    public List<AnagraficaDTO> findAll() {return anagraficaConverter.toDTOList(anagraficaRepostory.findAll()); }
//
//    public AnagraficaDTO save(AnagraficaDTO anagraficaDTO){
//        return anagraficaConverter.toDTO(anagraficaRepostory.save(anagraficaConverter.toEntity(anagraficaDTO)));
//    }
//
//    public void delete(Long id){ anagraficaRepostory.deleteById(id); }
}
