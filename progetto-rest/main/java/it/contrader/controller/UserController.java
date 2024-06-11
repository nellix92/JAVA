package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import it.contrader.dto.LoginDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.UserService;

import java.util.List;


@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController extends AbstractController<UserDTO>{
	
	@Autowired
	private UserService userService;

	@PostMapping(value = "/login")
	public ResponseEntity<UserDTO> login(@RequestBody   UserDTO userDTO) {
		return new ResponseEntity<>(userService.findByEmailAndPassword(userDTO), HttpStatus.OK);
	}

	@PostMapping("/register")
	public ResponseEntity<UserDTO> register(@RequestBody UserDTO u){
		return new ResponseEntity<>(userService.save(u), HttpStatus.OK);
	}

	@GetMapping("/getbyemail")
	public ResponseEntity<UserDTO> findByMail(@RequestParam String email){
		return new ResponseEntity<>(userService.findByEmail(email), HttpStatus.OK);
	}

//	@PostMapping("/insert")
//	public UserDTO insert(@RequestBody UserDTO userDTO){
//		return  userService.save(userDTO);
//	}
//	@PutMapping("/update")
//	public UserDTO update(@RequestBody UserDTO userDTO){
//		return  userService.save(userDTO);
//	}
//	@DeleteMapping("/deletebyid")
//	public void deleteById(@RequestParam Long id){
//		userService.delete(id);
//	}
//	@GetMapping("/findall")
//	public List<UserDTO> findAll(){return userService.findAll();}
//
//	@GetMapping("/findbyid")
//	public UserDTO findById(@RequestParam Long id){return userService.findById(id);}
}