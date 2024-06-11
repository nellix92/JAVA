package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.converter.UserConverter;
import it.contrader.dao.UserRepository;
import it.contrader.dto.UserDTO;
import it.contrader.model.User;

@Service
public class UserService extends AbstractService<User, UserDTO> {

	@Autowired
	private UserConverter converter;
	@Autowired
	private UserRepository repository;

	public UserDTO findById(Long id){
		return converter.toDTO(repository.findById(id).orElseThrow(()-> new RuntimeException("User ID non trovato")));
	}

	public UserDTO findByUsernameAndPassword(String username, String password) {
		return converter.toDTO(repository.findByUsernameAndPassword(username, password));
	}

	public UserDTO getByUsername(String username){
		return repository.existsByUsername(username) ? converter.toDTO(repository.findByUsername(username).orElseThrow(()-> new RuntimeException("NESSUN UTENTE TROVATO"))) : null;
	}

}
