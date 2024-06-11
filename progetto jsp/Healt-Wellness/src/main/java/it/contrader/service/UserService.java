package it.contrader.service;

import it.contrader.converter.UserConverter;
import it.contrader.dao.UserDAO;
import it.contrader.dto.AcquistoDTO;
import it.contrader.dto.UserDTO;
import it.contrader.enums.Usertype;
import it.contrader.model.User;

import java.util.List;

/**
 * 
 * @author Vittorio
 *
 *Grazie all'ereditariet� mi basta specificare i tipi di questa classe per
 *ereditare i metodi della clase AbstractService. Pertanto la classe risulta meno complicata
 *da scrivere, facendoci risparmiare tempo e fatica!
 */
public class UserService extends AbstractService<User, UserDTO> {
	
	//Istanzio DAO  e Converter specifici.
	public UserService(){
		this.dao = new UserDAO();
		this.converter = new UserConverter();
	}

	//public List<AcquistoDTO> getAll(){ return converter.toDTOList(dao.getAll()); }
	public boolean insert(UserDTO u) {
		return dao.insert(converter.toEntity(u));
	}


}
