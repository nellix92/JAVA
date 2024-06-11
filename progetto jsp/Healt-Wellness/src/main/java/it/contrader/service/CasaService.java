package it.contrader.service;

import it.contrader.converter.CasaConverter;
import it.contrader.dao.CasaDAO;
import it.contrader.dto.CasaDTO;
import it.contrader.model.Casa;

import java.util.List;

public class CasaService extends AbstractService<Casa, CasaDTO>{


    private final CasaDAO casaDAO;

    private final CasaConverter casaConverter;

    public CasaService(){
        this.casaDAO = new CasaDAO();
        this.casaConverter = new CasaConverter();
    }


    public CasaDTO read(int id){
        return casaConverter.toDTO(casaDAO.read(id));
    }

    public CasaDTO getNome(String nome){ return casaConverter.toDTO(casaDAO.getNome(nome));}

    public List<CasaDTO> getFilterPrezzo(double prezzo){ return casaConverter.toDTOList(casaDAO.getFilterPrezzo(prezzo));}

    public List<CasaDTO> getFiltroNome(String nome){ return casaConverter.toDTOList(casaDAO.getFiltraNome(nome));}

    public List<CasaDTO> getFiltroMetri(int metri){ return casaConverter.toDTOList(casaDAO.getFiltroMetri(metri)); }

    public List<CasaDTO> getFiltroTipo(String tipo){return casaConverter.toDTOList(casaDAO.getFiltraNome(tipo));}

    public List<CasaDTO> getFiltroCostruita(int minAnnoCostruzione) {
        return casaConverter.toDTOList(casaDAO.getFiltroCostruita(minAnnoCostruzione));
    }

    public List<CasaDTO> getAll(){
        return casaConverter.toDTOList(casaDAO.getAll());
    }

    public boolean insert(CasaDTO dto){
        return casaDAO.insert(casaConverter.toEntity(dto));
    }

    public boolean update(CasaDTO dto){
        return casaDAO.update(casaConverter.toEntity(dto));
    }

    public boolean delete(int id){
        return casaDAO.delete(id);
    }
}