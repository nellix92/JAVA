package it.contrader.servlets;

import it.contrader.dto.AgenziaDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.User;
import it.contrader.service.AgenziaService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/AgenziaServlet")
public class AgenziaServlet extends HttpServlet {

    private static final long serialVersionUID = 4L;

 //-----------------------------------------------------------
    private AgenziaService service;
 //------------------------------------------------------------
    @Override
    public void init(){this.service = new AgenziaService();}
//------------------------------------------------------------
    public void updateList(HttpServletRequest request) {
        List<AgenziaDTO> listDTO = service.getAll();
        request.setAttribute("agenzie", listDTO);
    }
 //-----------------------------------------------------------
 @Override
 public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     String mode = request.getParameter("mode");
     if(mode != null) {
         switch (mode.toUpperCase()) {
             case "GETALL":
                 System.out.println("sono in get all agenzia");

                 updateList(request);
                 request.getRequestDispatcher("/agenzia/agenziamanager.jsp").forward(request, response);
                 break;
             case "READ":
                 int idAgenziaToRead = Integer.parseInt(request.getParameter("id"));
                 AgenziaDTO agenzia = service.read(idAgenziaToRead);
                 request.setAttribute("agenzia", agenzia);
                 getServletContext().getRequestDispatcher("/agenzia/readagenzia.jsp").forward(request, response);
                 break;
             case "PREPARE_UPDATE":
                 int idAgenziaToUpdate = Integer.parseInt(request.getParameter("id"));
                 AgenziaDTO agenziaToUpdate = service.read(idAgenziaToUpdate);
                 request.setAttribute("agenziaToUpdate", agenziaToUpdate);
                 getServletContext().getRequestDispatcher("/agenzia/updateagenzia.jsp").forward(request, response);
                 break;
             case "DELETE":
                 int idAgenziaToDelete = Integer.parseInt(request.getParameter("id"));
                 if(service.delete(idAgenziaToDelete)) {
                     updateList(request);
                     request.getRequestDispatcher("/agenzia/agenziamanager.jsp").forward(request, response);
                 } else throw new RuntimeException("Cancellazione non andata a buon fine" + idAgenziaToDelete);
                 break;
             default:
                 throw new RuntimeException("Metodo " + mode + " non disponibile");
         }
     } else throw new RuntimeException("Nessun metodo specificato");
 }

 //-----------------------------------------------------
 @Override
 public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     String mode = request.getParameter("mode");
     if(mode != null) {

         String nome = request.getParameter("nome");
         String descrizione = request.getParameter("descrizione");
         String provincia = request.getParameter("provincia");
         String citta = request.getParameter("citta");
         String indirizzo = request.getParameter("indirizzo");

         UserDTO user = (UserDTO) request.getSession().getAttribute("user");
         int adminId = user.getId();
         AgenziaDTO agenzia = new AgenziaDTO(nome, descrizione, provincia, citta, indirizzo, adminId );

         switch (mode.toUpperCase()) {
             case "INSERT":
                 if(service.insert(agenzia)) {
                     updateList(request);
                     request.getSession().setAttribute("agenzia", agenzia);
                     request.getRequestDispatcher("/agenzia/agenziamanager.jsp").forward(request, response);
                 } else throw new RuntimeException("Inserimento non andato a buon fine");
                 break;
             case "UPDATE":
                 int id = Integer.parseInt(request.getParameter("id"));
                 agenzia.setId(id);
                 agenzia.setAdmin_id(adminId);
                 if(service.update(agenzia)) {
                     updateList(request);
                     request.getRequestDispatcher("/agenzia/agenziamanager.jsp").forward(request, response);
                 } else throw new RuntimeException("Modifica non andata a buon fine");
                 break;

         }
     } else throw new RuntimeException("Nessun metodo specificato");
 }






}
