package it.contrader.controller;


import it.contrader.dto.AnagraficaDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Anagrafica.Genere;
import it.contrader.model.User;
import it.contrader.service.AnagraficaService;
import it.contrader.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/anagrafica")
public class AnagraficaController {
    private static final Logger logger = LoggerFactory.getLogger(AnagraficaController.class);

    @Autowired
    private AnagraficaService anagraficaService;

    @Autowired
    private UserService userService;

    @GetMapping("/read")
    public String read(HttpServletRequest request, @RequestParam("id") Long id){
        request.getSession().setAttribute("dto", anagraficaService.read(id));
        return "anagrafica/readanagrafica";
    }

    @GetMapping("/getall")
    public String getAll(HttpServletRequest request){
        setAll(request);
        return "anagrafica/anagraficamanager";
    }

   @GetMapping("/delete")
   public String delete(HttpServletRequest request, @RequestParam("id") Long id){
       anagraficaService.delete(id);
       setAll(request);
       return  "anagrafica/anagrafiche";
    }

   @GetMapping("/preupdate")
   public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id){
       request.getSession().setAttribute("dto", anagraficaService.read(id));
       return "anagrafica/updateanagrafica";
    }

    @PostMapping("/update")
    public String update(HttpServletRequest request,
                         @RequestParam("id") Long id,
                         @RequestParam("nome") String nome,
                         @RequestParam("cognome") String cognome,
                         @RequestParam("email") String email,
                         @RequestParam("datadinascita") String dataDiNascita,
                         @RequestParam("genere") Genere genere,
                         @RequestParam("nazione") String nazione,
                         @RequestParam("provincia") String provincia,
                         @RequestParam("citta") String citta,
                         @RequestParam("indirizzo") String indirizzo ){

        AnagraficaDTO dto = new AnagraficaDTO();
        AnagraficaDTO oldAnagrafica = anagraficaService.read(id);

        LocalDate dataParsata = LocalDate.parse(dataDiNascita);

        UserDTO u = (UserDTO) request.getSession().getAttribute("user");

        dto.setId(id);
        dto.setNome(nome);
        dto.setCognome(cognome);
        dto.setEmail(email);
        dto.setDataDiNascita(dataParsata);
        dto.setGenere(genere);
        dto.setNazione(nazione);
        dto.setProvincia(provincia);
        dto.setCitta(citta);
        dto.setIndirizzo(indirizzo);
        dto.setUser_id(oldAnagrafica.getUser_id());
        AnagraficaDTO a = anagraficaService.findByEmail(email);
        if( a == null ){
            anagraficaService.update(dto);
            request.getSession().setAttribute("dto", u);
            request.getSession().setAttribute("anagrafica", dto);
            setAll(request);
            if (u.getUsertype() == User.Usertype.ADMIN){
                return "anagrafica/anagraficamanager";
            }else{
                return "user/readuser";
            }
        }
        else{
            dto.setEmail(oldAnagrafica.getEmail());
            request.getSession().setAttribute("dto", u);
            request.getSession().setAttribute("anagrafica", dto);
            return "user/readuser";
        }
    }

    @PostMapping("/insert")
    public String insert(HttpServletRequest request,
                         @RequestParam("nome") String nome,
                         @RequestParam("cognome") String cognome,
                         @RequestParam("email") String email,
                         @RequestParam("datadinascita") String dataDiNascita,
                         @RequestParam("genere") Genere genere,
                         @RequestParam("nazione") String nazione,
                         @RequestParam("provincia") String provincia,
                         @RequestParam("citta") String citta,
                         @RequestParam("indirizzo") String indirizzo ) throws ParseException {

        AnagraficaDTO dto = new AnagraficaDTO();
        UserDTO u = (UserDTO) request.getSession().getAttribute("user");
        UserDTO userForAnagrafica = userService.getByUsername(u.getUsername());
        LocalDate dataParsata = LocalDate.parse(dataDiNascita);

        if(verificaStringa(nome)) {
            dto.setNome(nome);
        }else{
            System.out.println("inserisci un nome valido");
            request.setAttribute("error", "inserisci un nome valido");
            return "anagrafica/anagraficainsert";
        }
        if(verificaStringa(nome)) {
            dto.setCognome(cognome);
        }else{
            System.out.println("inserisci un cognome valido");
            request.setAttribute("error", "inserisci un cognome valido");
            return "anagrafica/anagraficainsert";
        }
        if(verificaEmail(email)) {
            dto.setEmail(email);
        }else{
            System.out.println("inserisci un'email valido");
            request.setAttribute("error", "inserisci un'email valida");
            return "anagrafica/anagraficainsert";
        }
        dto.setDataDiNascita(dataParsata);
        dto.setGenere(genere);
        if(verificaStringa(nazione)) {
            dto.setNazione(nazione);
        }else{
            System.out.println("inserisci una nazione valida");
            request.setAttribute("error", "Inserisci una Nazione valida");
            return "anagrafica/anagraficainsert";
        }
        if(verificaStringa(provincia)){
            dto.setProvincia(provincia);
        }else{
            System.out.println("inserisci una provincia valida");
            request.setAttribute("error", "Inserisci una provincia valida");
            return "anagrafica/anagraficainsert";
        }
        //if (verificaStringa(citta)) {
            dto.setCitta(citta);
//        }else{
//            System.out.println("inserisci una città valida");
//            request.setAttribute("error", "Inserisci una città valida");
//            return "anagrafica/anagraficainsert";
//        }
        if(verificaIndirizzo(indirizzo)) {
            dto.setIndirizzo(indirizzo);
        }else{
            System.out.println("inserisci una indirizzo valido");
            request.setAttribute("error", "inserisci un indirizzo valido");
            return "anagrafica/anagraficainsert";
        }
        dto.setUser_id(userForAnagrafica.getId());
        AnagraficaDTO newAnagrafica = anagraficaService.findByEmail(dto.getEmail());
        if(newAnagrafica == null) {
            anagraficaService.insert(dto);
            AnagraficaDTO anagraficaSession = anagraficaService.findByEmail(dto.getEmail());
            request.getSession().setAttribute("anagrafica", anagraficaSession);
            request.getSession().setAttribute("anagraficaId", anagraficaSession.getId());
            setAll(request);
            if (u.getUsertype() == User.Usertype.ADMIN) {
                return "agenzia/insertagenzia";
            } else {
                return "home";
            }
        }else{
            request.setAttribute("errorMessage", "Email già presente nel database.");
            return "anagrafica/anagraficainsert";
        }
    }

//    @GetMapping("/process-date")
//    public String processDate(@RequestParam("data") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data) {
//        // La data è stata convertita correttamente
//        return "Data convertita correttamente: " + data.toString();
//    }

    public static boolean verificaStringa(String nome) {
        Pattern pattern = Pattern.compile("^[\\p{L}\\s']{3,}$");
        Matcher matcher = pattern.matcher(nome);
        return matcher.matches();
    }

    public static boolean verificaEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean verificaIndirizzo(String indirizzo) {
        String regex = "^via\\s+[A-Za-zàèéìòóù']+\\s+\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(indirizzo);
        return matcher.matches();
    }

    private void setAll(HttpServletRequest request) {
        System.out.println(anagraficaService.getAll());
        request.getSession().setAttribute("list", anagraficaService.getAll());
    }
}



