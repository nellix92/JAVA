package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.User;

import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Long> {

	User findByUsernameAndPassword(String username, String password);

	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);

}
