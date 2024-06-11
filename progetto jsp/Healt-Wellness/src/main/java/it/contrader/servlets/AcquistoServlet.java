package it.contrader.servlets;

import it.contrader.dto.AcquistoDTO;
import it.contrader.dto.AnagraficaDTO;
import it.contrader.dto.CasaDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Anagrafica;
import it.contrader.model.User;
import it.contrader.service.AcquistoService;
import it.contrader.service.AnagraficaService;
import it.contrader.service.CasaService;
import it.contrader.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/AcquistoServlet")
public class AcquistoServlet extends HttpServlet {

    private static final long serialVersionUID = 8L;

    private UserService userService;

    private AcquistoService acquistoService;

    private CasaService casaService;

    private AnagraficaService anagraficaService;

    @Override
    public void init(){
        this.userService = new UserService();
        this.casaService = new CasaService();
        this.acquistoService = new AcquistoService();
        this.anagraficaService=new AnagraficaService();}

    //------------------------------------------------------------------------------------

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mode = request.getParameter("mode");
        if (mode != null){
            switch (mode.toUpperCase()){
                case "GETALL":
                    updateList(request);
                    request.getRequestDispatcher("/acquisto/acquistomanager.jsp").forward(request, response);
                    break;
                case "GETBYANAGRAFICA":
                    UserDTO user = (UserDTO) request.getSession().getAttribute("user");
                    //UserDTO u = userService.read(Integer.parseInt(request.getSession().getParameter("id")));
                    AnagraficaDTO anagrafica = anagraficaService.findByUser(user.getId());
                    List<AcquistoDTO> acquistoByAnagrafica = acquistoService.getByAnagrafica(anagrafica.getId());
                    request.setAttribute("acquisto", acquistoByAnagrafica);
                    request.getRequestDispatcher("/acquisto/readacquistouser.jsp").forward(request, response);
                    break;
                case "READ":
                    int idAcquisto = Integer.parseInt(request.getParameter("id"));
                    AcquistoDTO acquistoToRead = acquistoService.read(idAcquisto);
                    request.setAttribute("acquisto", acquistoToRead);
                    break;
                case "PREPARE_UPDATE":
                    int idAcquistoToUpdate = Integer.parseInt(request.getParameter("id"));
                    AcquistoDTO acquistoToUpdate = acquistoService.read(idAcquistoToUpdate);
                    request.setAttribute("acquistoToUpdate", acquistoToUpdate);
                    getServletContext().getRequestDispatcher("acquisto/updateacquisto.jsp").forward(request, response);
                    break;
                case "DELETE":
                    int idAcquistoToDelete = Integer.parseInt(request.getParameter("id"));
                    if(acquistoService.delete(idAcquistoToDelete)){
                        updateList(request);
                        request.getRequestDispatcher("/acquisto/acquistomanager.jsp").forward(request,response);
                    } else throw new RuntimeException("CANCELLAZIONE ACQUISTO FALLITA");
                    break;
                default:
                    throw new RuntimeException("METODO " + mode.toUpperCase() + " NON DISPONIBILE");
            }
        } else throw new RuntimeException("NESSUN METODO SPECIFICATO");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mode = request.getParameter("mode");
        if (mode != null){
            UserDTO user = (UserDTO) request.getSession().getAttribute("user");
            AnagraficaDTO anagraficaDTO = anagraficaService.findByUser(user.getId());
            CasaDTO casaDTO = casaService.read(Integer.parseInt(request.getParameter("houseId")));
            AcquistoDTO acquisto = new AcquistoDTO(anagraficaDTO.getId(), casaDTO.getNome(), casaDTO.getPrezzo(), casaDTO.getId());
            casaDTO.setDisponibile(false);
            switch(mode.toUpperCase()){
                case "INSERT":
                    if (acquistoService.insert(acquisto)){
                        System.out.println("prima del metodo update: " +  casaDTO);
                        casaService.update(casaDTO);
                        System.out.println("dopo il metodo update: " +  casaDTO);
                        updateListCase(request);
                        updateList(request);
                        request.getRequestDispatcher("/casa/casamanager.jsp").forward(request, response);
                    }
                    break;
                case "UPDATE":
                    int id = Integer.parseInt(request.getParameter("id"));
                    acquisto.setId(id);
                    if(acquistoService.update(acquisto)){
                        updateList(request);
                        request.getRequestDispatcher("/acquisto/readacquistouser.jsp").forward(request, response);
                    }
                    break;
                default:
                    throw new RuntimeException("METODO " + mode.toUpperCase() + " NON DISPONIBILE");
            }
        } else throw new RuntimeException("NESSUN METODO SPECIFICATO");
    }

    public void updateList(HttpServletRequest request) {
        List<AcquistoDTO> acquistoDTOList = acquistoService.getAll();
        request.setAttribute("acquisto", acquistoDTOList);
    }

    public void updateListCase(HttpServletRequest request) {
        List<CasaDTO>listDTO = casaService.getAll();
        request.setAttribute("casa", listDTO);
    }

}
