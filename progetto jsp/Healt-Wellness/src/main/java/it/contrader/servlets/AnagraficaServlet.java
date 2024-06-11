package it.contrader.servlets;
import it.contrader.dto.UserDTO;
import it.contrader.enums.Usertype;
import it.contrader.model.Anagrafica;
import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import it.contrader.dto.AnagraficaDTO;
import it.contrader.model.User;
import it.contrader.service.AnagraficaService;
import it.contrader.service.UserService;


/**
 * This servlet class handles various CRUD operations for users.
 * It provides functionality to read, create, update, and delete users.
 */
@WebServlet("/AnagraficaServlet")
public class AnagraficaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /** Service used for user-related operations. */
    private AnagraficaService service;
    private UserService userService;

    /**
     * Initializes the servlet and creates a new instance of the UserService.
     */
    @Override
    public void init() {
        this.service = new AnagraficaService();
        this.userService = new UserService();
    }

    /**
     * Handles GET requests. It provides functionality based on the "mode" parameter.
     *
     * @param request the HttpServletRequest object containing client request data
     * @param response the HttpServletResponse object to send data to the client
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mode = request.getParameter("mode");
        if (mode != null) {
            switch (mode.toUpperCase()) {
                case "GETALL":
                    updateList(request);
                    request.getRequestDispatcher("/anagrafica/anagraficamanager.jsp").forward(request, response);
                    break;

                case "READ":
                    String idParameter = request.getParameter("id");
                    if (idParameter != null && !idParameter.isEmpty()) {
                        int idAnagraficaToRead = Integer.parseInt(idParameter);
                        AnagraficaDTO anagrafica = service.read(idAnagraficaToRead);
                        request.setAttribute("anagrafica", anagrafica);
                        System.out.println(anagrafica);
                        getServletContext().getRequestDispatcher("/anagrafica/anagraficareaduser.jsp").forward(request, response);
                    } else {
                        // Gestire il caso in cui il parametro "id" non è stato fornito nella richiesta GET
                        throw new RuntimeException("Nessun parametro 'id' fornito nella richiesta GET per READ");
                    }
                    break;

                case "PREPARE_UPDATE":
                    int idAnagraficaToUpdate = Integer.parseInt(request.getParameter("id"));
                    AnagraficaDTO anagraficaToUpdate = service.read(idAnagraficaToUpdate);
                    request.setAttribute("anagraficaToUpdate", anagraficaToUpdate);
                    getServletContext().getRequestDispatcher("/anagrafica/updateanagrafica.jsp").forward(request, response);
                    break;

                case "DELETE":
                    int idAnagraficaToDelete = Integer.parseInt(request.getParameter("id"));
                    if (service.delete(idAnagraficaToDelete)) {
                        updateList(request);
                        request.getRequestDispatcher("/anagrafica/anagraficamanager.jsp").forward(request, response);
                    } else {
                        throw new RuntimeException("Cancellazione non andata a buon fine");
                    }
                    break;

                default:
                    throw new RuntimeException("Metodo " + mode + " non disponibile");
            }
        } else {
            throw new RuntimeException("Nessun metodo specificato");
        }
    }

    /**
     * Handles POST requests. It provides functionality based on the "mode" parameter.
     *
     * @param request the HttpServletRequest object containing client request data
     * @param response the HttpServletResponse object to send data to the client
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mode = request.getParameter("mode");
        if(mode != null) {
            String nome = request.getParameter("nome");
            String cognome = request.getParameter("cognome");
            String email = request.getParameter("email");
            String dataDiNascita = request.getParameter("datadinascita");
            String genere = request.getParameter("genere");
            String nazione = request.getParameter("nazione");
            String provincia = request.getParameter("provincia");
            String citta = request.getParameter("citta");
            String indirizzo = request.getParameter("indirizzo");
            List<UserDTO> listDto = userService.getAll();
            UserDTO lastUser = listDto.get(listDto.size() - 1);
            UserDTO user = (UserDTO) request.getSession().getAttribute("user");
            if(user.getId() == 0){
                user.setId(lastUser.getId());
            }
            AnagraficaDTO anagraficaDTO = new AnagraficaDTO (nome, cognome, email, dataDiNascita, genere, nazione, provincia, citta, indirizzo, user.getId());
            request.getSession().setAttribute("id", lastUser.getId());

//<G
            //Anagrafica anagrafica = (Anagrafica) request.getSession().getAttribute("anagrafica");
//G>
            switch (mode.toUpperCase()) {
                case "INSERT":
                    if(service.insert(anagraficaDTO)) {
                        request.getSession().setAttribute("anagrafica", anagraficaDTO);
                        updateList(request);
                        if(user.getUsertype() == Usertype.ADMIN){
                            getServletContext().getRequestDispatcher("/agenzia/insertagenzia.jsp").forward(request, response);
                        }else{
                            request.getRequestDispatcher("home.jsp").forward(request, response);
                        }
                    } else throw new RuntimeException("Inserimento non andato a buon fine");
                    break;
                case "UPDATE":
                    int id = Integer.parseInt(request.getParameter("id"));
                    anagraficaDTO.setId(id);
                    request.getSession().setAttribute("anagrafica", anagraficaDTO);
                    user = new UserDTO();
                    if (request.getAttribute("user") == null){
                        user = (UserDTO) request.getSession().getAttribute("user");
                    }else{
                        user = (UserDTO) request.getAttribute("user");
                    }
                    System.out.println(user);
                    request.setAttribute("user", user);
                    if(service.update(anagraficaDTO)) {
                        updateList(request);
                        request.setAttribute("anagrafica", anagraficaDTO);
                        if(user.getUsertype() == Usertype.ADMIN){
                            getServletContext().getRequestDispatcher("/user/readuser.jsp").forward(request, response);
                        }else{
                            request.getRequestDispatcher("home.jsp").forward(request, response);
                        }
                        request.getRequestDispatcher("/user/readuser.jsp").forward(request, response);
                    } else throw new RuntimeException("Modifica non andata a buon fine");
                    break;
            }
        } else throw new RuntimeException("Nessun metodo specificato");
    }

    /**
     * Updates the list of users and sets it as a request attribute.
     *
     * @param request the HttpServletRequest object containing client request data
     */
    public void updateList(HttpServletRequest request) {
        List<AnagraficaDTO>listDTO = service.getAll();
        request.setAttribute("anagrafiche", listDTO);
    }
    private void redirectToPage(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
        getServletContext().getRequestDispatcher(page).forward(request, response);
    }
}