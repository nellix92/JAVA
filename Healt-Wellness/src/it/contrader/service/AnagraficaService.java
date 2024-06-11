package it.contrader.service;

import it.contrader.converter.AnagraficaConverter;
import it.contrader.dao.AnagraficaDAO;
import it.contrader.dto.AnagraficaDTO;

public class AnagraficaService {

    private final AnagraficaDAO anagraficaDAO;

    private final AnagraficaConverter anagraficaConverter;

    public AnagraficaService(){
        anagraficaDAO = new AnagraficaDAO();
        anagraficaConverter = new AnagraficaConverter();
    }

    public AnagraficaDTO read(int id) {
        return anagraficaConverter.toDTO(anagraficaDAO.read(id));
    }


    public boolean insert(AnagraficaDTO dto) {
        return anagraficaDAO.insert(anagraficaConverter.toEntity(dto));
    }

    public boolean update(AnagraficaDTO dto) {
        return anagraficaDAO.update(anagraficaConverter.toEntity(dto));
    }

}
