package it.contrader.service;

import it.contrader.converter.CasaConverter;
import it.contrader.dao.CasaDAO;
import it.contrader.dto.CasaDTO;
import it.contrader.model.Casa;

import java.util.List;

public class CasaService {

    private final CasaDAO casaDAO;

    private final CasaConverter casaConverter;

    public CasaService(){
        casaDAO = new CasaDAO();
        casaConverter = new CasaConverter();
    }

    public CasaDTO read(int id){
        return casaConverter.toDto(casaDAO.read(id));
    }

    public CasaDTO getNome(String nome){ return casaConverter.toDto(casaDAO.getNome(nome));}

    public List<CasaDTO> getFilterPrezzo(double prezzoMin, double prezzoMax){ return casaConverter.toDTOList(casaDAO.getFilterPrezzo(prezzoMin, prezzoMax));}

    public List<CasaDTO> getFiltroNome(String nome){ return casaConverter.toDTOList(casaDAO.getFiltraNome(nome));}

    public List<CasaDTO> getFiltroMetri(int metriMin, int metriMax){ return casaConverter.toDTOList(casaDAO.getFiltroMetri(metriMin, metriMax)); }

    public List<CasaDTO> getFiltroTipo(String tipo){return casaConverter.toDTOList(casaDAO.getFiltraNome(tipo));}

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
