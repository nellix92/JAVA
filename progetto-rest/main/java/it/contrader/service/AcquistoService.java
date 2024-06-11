package it.contrader.service;
import it.contrader.converter.AcquistoConverter;
import it.contrader.dao.AcquistoRepository;
import it.contrader.dto.AcquistoDTO;
import it.contrader.model.Acquisto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AcquistoService extends AbstractService<Acquisto,AcquistoDTO> {
    @Autowired
    private AcquistoConverter acquistoConverter;
    @Autowired
    private AcquistoRepository acquistoRepository;

    public AcquistoDTO createOrder(AcquistoDTO a){
        return  acquistoConverter.toDTO(acquistoRepository.save(acquistoConverter.toEntity(a)));
    }
    public List<AcquistoDTO> findByUserId(Long id){
        return getAll().stream().filter(a -> a.getAnagraficaId().equals(id)).collect(Collectors.toList());
    }
    public List<AcquistoDTO> findByPrezzoGreater(double prezzo){
        return getAll().stream().filter(a -> a.getPrezzo() >= prezzo).collect(Collectors.toList());
    }
    public List<AcquistoDTO> findByPrezzoLess(double prezzo){
        return getAll().stream().filter(a -> a.getPrezzo() <= prezzo).collect(Collectors.toList());
    }
    public List<AcquistoDTO> findByDateAfter(LocalDate date){
        return getAll().stream().filter(a -> a.getData().isAfter(date)).collect(Collectors.toList());
    }
    public List<AcquistoDTO> findByDateBefore(LocalDate date){
        return getAll().stream().filter(a -> a.getData().isBefore(date)).collect(Collectors.toList());
    }
    public Page<AcquistoDTO> findAllPaged(Pageable page){
        return acquistoConverter.toDtoPage(acquistoRepository.findAll(page));
    }

    public List<AcquistoDTO> findAcquistiUserId(Long id) {
        return getAll().stream().filter(acquisto -> acquisto.getAnagraficaId().equals(id)).collect(Collectors.toList());
    }
    public List <AcquistoDTO> findAllByUserId(Long id){
        return acquistoConverter.toDTOList(acquistoRepository.findAllByAnagraficaUserId(id));
    }
}
