package it.contrader.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import it.contrader.model.User.Usertype;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO della classe User. Ha gli stessi attributi di User
 * 
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 * @see //User
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

	private Long id;


	
	private String email;
	
	private String password;

	private Usertype usertype;

}
