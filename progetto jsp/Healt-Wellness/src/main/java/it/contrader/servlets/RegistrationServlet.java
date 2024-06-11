package it.contrader.servlets;

import java.util.List;
import it.contrader.dto.UserDTO;
import it.contrader.enums.Usertype;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import it.contrader.service.UserService;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserService service;

    /**
     * Inizializza la servlet creando una nuova istanza del servizio di login.
     */
    @Override
    public void init() {
        this.service = new UserService();
    }

    /**
     * Gestisce le richieste POST ricevute. In questo caso si gestisce la richiesta di login.
     *
     * @param request  la richiesta HTTP ricevuta
     * @param response la risposta HTTP da inviare
     * @throws ServletException se si verifica un errore generale per questa richiesta
     * @throws IOException      se si verifica un errore di I/O durante la gestione della richiesta
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String usertype = request.getParameter("usertype");
        UserDTO userDTO = new UserDTO (username,password, Usertype.valueOf(usertype));
        service.insert(userDTO);

        if (userDTO != null) {
            request.getSession().setAttribute("user", userDTO);
            if (userDTO.getUsertype() != null) {
//                String redirectPage;
//                redirectPage = "/anagrafica/anagraficainsert.jsp";
//                redirectToPage(request, response, redirectPage);
                getServletContext().getRequestDispatcher("/anagrafica/anagraficainsert.jsp").forward(request, response);

            } else {
                throw new RuntimeException("Lo usertype non è stato valorizzato");
            }
        }
    }

    /**
     * Reindirizza alla pagina specificata.
     *
     * @param request  la richiesta HTTP ricevuta
     * @param response la risposta HTTP da inviare
     * @param page     la pagina verso cui reindirizzare
     * @throws ServletException se si verifica un errore generale per questa richiesta
     * @throws IOException      se si verifica un errore di I/O durante la gestione della richiesta
     */
    private void redirectToPage(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
        getServletContext().getRequestDispatcher(page).forward(request, response);
    }
}
