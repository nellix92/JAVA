package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import it.contrader.dto.AgenziaDTO;
import it.contrader.dto.AnagraficaDTO;
import it.contrader.model.User;
import it.contrader.service.AgenziaService;
import it.contrader.service.AnagraficaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.UserDTO;
import it.contrader.model.User.Usertype;
import it.contrader.service.UserService;

import java.util.Objects;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;

	@Autowired
	private AnagraficaService anagraficaService;
	@Autowired
	private AgenziaService agenziaService;

	@PostMapping("/login")
	public String login(HttpServletRequest request, @RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "password", required = true) String password) {
		UserDTO userDTO = service.findByUsernameAndPassword(username, password);
		if(userDTO!=null) {
			AnagraficaDTO anagraficaDTO = anagraficaService.findByUserId(userDTO.getId());
			request.getSession().setAttribute("user", userDTO);
			request.getSession().setAttribute("anagrafica", anagraficaDTO);
			request.getSession().setAttribute("anagraficaId", anagraficaDTO.getId());
			if (userDTO.getUsertype() == Usertype.ADMIN) {
				AgenziaDTO agenziaDTO = agenziaService.findByAdminId(userDTO.getId());
				if(agenziaDTO == null){
					return "agenzia/insertagenzia";
				}else{
					request.getSession().setAttribute("agenzia", agenziaDTO);
					request.getSession().setAttribute("agenziaId", agenziaDTO.getId());
					return "home";
				}
			}
		}
		if(userDTO != null) {
			return "home";
		}else{
			request.setAttribute("errorMessage", "Username o password errati.");
			return "index";
		}
	}

	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "user/users";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		UserDTO userDTO = (UserDTO) request.getSession().getAttribute("user");
		if(!Objects.equals(userDTO.getId(), id)){
			return "user/users";
		}else{
			return "index";
		}
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "user/updateuser";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("username") String username,
			@RequestParam("password") String password) {

		UserDTO u = service.findById(id);
		UserDTO dto = new UserDTO();
		dto.setId(id);
		dto.setUsername(username);
		dto.setPassword(password);
		dto.setUsertype(u.getUsertype());
		service.update(dto);
		request.getSession().setAttribute("dto", dto);
		AnagraficaDTO a = anagraficaService.findByUserId(id);
		request.getSession().setAttribute("anagrafica", a);
		setAll(request);
		if(dto.getUsertype()==Usertype.ADMIN){
			return "user/users";
		}else{
			return "user/readuser";
		}
	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("username") String username,
			@RequestParam("password") String password, @RequestParam("usertype") Usertype usertype) {
		UserDTO dto = new UserDTO();
		dto.setUsername(username);
		dto.setPassword(password);
		dto.setUsertype(usertype);
		UserDTO u = service.getByUsername(username);
		if(u == null){
			service.insert(dto);
			UserDTO newUser = service.getByUsername(dto.getUsername());
			request.getSession().setAttribute("user", newUser);
			setAll(request);
			return "/anagrafica/anagraficainsert";
		}else{
			request.setAttribute("errorMessage", "Username già presente nel database.");
			return "/registration";
		}
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		AnagraficaDTO a = anagraficaService.findByUserId(id);
		request.getSession().setAttribute("anagrafica", a);
		return "user/readuser";
	}

	@GetMapping("/profilo")
	public String readProfilo(HttpServletRequest request){
		UserDTO userProfilo = (UserDTO) request.getSession().getAttribute("user");
		UserDTO afterReg = service.findByUsernameAndPassword(userProfilo.getUsername(),userProfilo.getPassword());
		request.getSession().setAttribute("dto", afterReg);
		AnagraficaDTO a = anagraficaService.findByUserId(afterReg.getId());
		request.getSession().setAttribute("anagrafica", a);
		return "user/readuser";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}

	private void setAll(HttpServletRequest request) {
		System.out.println(service.getAll());
		request.getSession().setAttribute("list", service.getAll());
	}
}
