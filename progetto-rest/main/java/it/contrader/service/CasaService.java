package it.contrader.service;

import it.contrader.converter.CasaConverter;
import it.contrader.dao.CasaRepository;
import it.contrader.dto.CasaDTO;
import it.contrader.model.Casa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CasaService{
    @Autowired
    CasaRepository casaRepository;

    @Autowired
    CasaConverter casaConverter;

    public CasaDTO findById(Long id){
        return casaConverter.toDTO(casaRepository.findById(id).orElseThrow(()->new RuntimeException("idCasa non trovato!")));
    }

    public List<CasaDTO> findAll(){
        return casaConverter.toDTOList(casaRepository.findAll());
    }

    public CasaDTO save(CasaDTO casaDTO){
        return casaConverter.toDTO(casaRepository.save(casaConverter.toEntity(casaDTO)));
    }

    public void delete(Long id){
        casaRepository.deleteById(id);
    }

    public List<CasaDTO> findFiltraPrezzo(Double prezzoMinimoFiltra)  {
        return findAll().stream().filter(casa->casa.getPrezzo()>=prezzoMinimoFiltra).collect(Collectors.toList());
    }

    public List<CasaDTO> findFiltraNome(String nome)  {
        return findAll().stream()
                .filter(casa->casa.getNome().toUpperCase().contains(nome.toUpperCase())).collect(Collectors.toList());
    }

    public List<CasaDTO> findFiltraMetratura(int metraturaMinimaFiltra)  {
        return findAll().stream().filter(casa->casa.getMetratura()>=metraturaMinimaFiltra).collect(Collectors.toList());
    }

    public List<CasaDTO> findFiltraCostruita(int costruitaMinimoFiltra)  {
        return findAll().stream().filter(casa->casa.getCostruita()>=costruitaMinimoFiltra).collect(Collectors.toList());
    }

    public Page<CasaDTO> findAllPaginata(Pageable pageable){
        return casaConverter.toDTOPage(casaRepository.findAll(pageable));
    }

    public List<CasaDTO> findAllByTipo(String tipo){
        return findAll().stream().filter(casa -> casa.getTipo().toString().equals(tipo)).collect(Collectors.toList());
    }

    public List<CasaDTO> filterAll(String nome, double prezzo, int metratura, int data){
        return findAll().stream().filter(casa -> casa.getNome().toUpperCase().contains(nome.toUpperCase()))
                .filter(casa -> casa.getPrezzo()<= prezzo)
                .filter(casa -> casa.getMetratura() >= metratura)
                .filter(casa -> casa.getCostruita() >= data)
                .collect(Collectors.toList());
    }
}
