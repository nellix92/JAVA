package it.contrader.service;

import it.contrader.converter.UserConverter;
import it.contrader.exceptions.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import it.contrader.dao.UserRepository;
import it.contrader.dto.UserDTO;
import it.contrader.model.User;
import java.util.List;
import java.util.Optional;

@Service
public class UserService extends AbstractService<User,UserDTO> {

	@Autowired
	UserRepository userRepository;
	@Autowired
	UserConverter userConverter;

	BCryptPasswordEncoder encoder;

	public UserService() {
		this.encoder = new BCryptPasswordEncoder();
	}

	public UserDTO findByEmailAndPassword(UserDTO user) {
		User u = userRepository.findByEmail(user.getEmail());
		if(encoder.matches(user.getPassword(), u.getPassword())){
			String email = user.getEmail();
			String password = u.getPassword();
		return converter.toDTO(((UserRepository)repository).findByEmailAndPassword(email, password)
				.orElseThrow(() -> new InvalidCredentialsException("Credenziali Errate")));
		} else {
			return null;
		}
	}

	public UserDTO findByEmail(String email){
		return converter.toDTO(userRepository.findByEmail(email));
	}

	public UserDTO save(UserDTO userDTO){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(userDTO.getPassword());
		userDTO.setPassword(encodedPassword);
		return userConverter.toDTO(userRepository.save(userConverter.toEntity(userDTO)));
	}

	public List<UserDTO> findAll(){
		return userConverter.toDTOList((List<User>) userRepository.findAll());
	}

	public void delete(Long id){
		userRepository.deleteById(id);
	}

	public UserDTO findById(Long id){
		return userConverter.toDTO(userRepository.findById(id).orElseThrow(()->new RuntimeException("id Utente non trovato!")));
	}
	public Page<UserDTO> findAllPaginata(Pageable pageable){
		return userConverter.toDTOPage(userRepository.findAll(pageable));
	}
}
