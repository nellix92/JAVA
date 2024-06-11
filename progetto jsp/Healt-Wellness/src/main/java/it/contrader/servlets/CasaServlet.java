package it.contrader.servlets;

import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.AgenziaDTO;
import it.contrader.dto.CasaDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.AgenziaService;
import it.contrader.service.CasaService;

@WebServlet("/CasaServlet")
public class CasaServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;

    private  CasaService service;

    private AgenziaService agenziaService;

    @Override
    public void init() {
        this.service = new CasaService();
        this.agenziaService = new AgenziaService();
    }

    public void updateList(HttpServletRequest request) {
        List<CasaDTO>listDTO = service.getAll();
        request.setAttribute("casa", listDTO);
    }

    public void updateListNome(HttpServletRequest request) {
        List<CasaDTO>listDTO = service.getFiltroNome(request.getParameter("cercaNome"));
        System.out.println(request.getParameter("cercaNome"));
        request.setAttribute("casa", listDTO);
    }

    public void updateListAnno(HttpServletRequest request) {
        List<CasaDTO>listDTO = service.getFiltroCostruita(Integer.parseInt(request.getParameter("cercaAnno")));
        System.out.println(request.getParameter("cercaAnno"));
        request.setAttribute("casa", listDTO);
    }

    public void updateListPrezzo(HttpServletRequest request) {
        List<CasaDTO>listDTO = service.getFilterPrezzo(Integer.parseInt(request.getParameter("cercaPrezzo")));
        System.out.println(request.getParameter("cercaPrezzo"));
        request.setAttribute("casa", listDTO);
    }

    public void updateListMetri(HttpServletRequest request) {
        List<CasaDTO>listDTO = service.getFiltroMetri(Integer.parseInt(request.getParameter("cercaMetri")));
        System.out.println(request.getParameter("cercaMetri"));
        request.setAttribute("casa", listDTO);
    }



    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mode = request.getParameter("mode");

        if (mode != null){
            switch (mode.toUpperCase()){
                case "GETALL":
                case "AZZERAFILTRI":
                    updateList(request);
                request.getRequestDispatcher("/casa/casamanager.jsp").forward(request, response);
                break;

                case "READ":
                    int idCasaToRead = Integer.parseInt(request.getParameter("id"));
                    CasaDTO casa = service.read(idCasaToRead);
                    request.setAttribute("casa", casa);
                    getServletContext().getRequestDispatcher("/casa/casamanager.jsp").forward(request, response);
                    break;
//                case "FILTRAPREZZO":
//                    Double minPrezzo = Double.valueOf(request.getParameter("minPrezzo"));
//                    Double maxPrezzo = Double.valueOf(request.getParameter("maxPrezzo"));
//                    List<CasaDTO> casaFiltrataPrezzo = service.getFilterPrezzo(minPrezzo, maxPrezzo);
//                    getServletContext().getRequestDispatcher("/casa/casamanager.jsp").forward(request, response);
//                    break;
                case "FILTRI":
                    String nome;
                    double prezzo;
                    int metri;
                    int anno;
                    if(!request.getParameter("cercaNome").isEmpty()) {
                        nome = request.getParameter("cercaNome");
                    }else{
                        nome = "";
                    }
                    if(!request.getParameter("cercaPrezzo").isEmpty()){
                        prezzo = Double.parseDouble(request.getParameter("cercaPrezzo"));
                    }else{
                        prezzo = 0.0;
                    }
                    if(!request.getParameter("cercaMetri").isEmpty()){
                        metri = Integer.parseInt(request.getParameter("cercaMetri"));
                    }else{
                        metri = 0;
                    }
                    if(!request.getParameter("cercaAnno").isEmpty()){
                        anno = Integer.parseInt(request.getParameter("cercaAnno"));
                    }else{
                        anno = 0;
                    }

                    if(prezzo == 0.0 && metri == 0 && anno == 0){
                        updateListNome(request);
                        getServletContext().getRequestDispatcher("/casa/casamanager.jsp").forward(request, response);
                    } else if (nome.isEmpty() && prezzo == 0.0 && metri == 0) {
                        updateListAnno(request);
                        getServletContext().getRequestDispatcher("/casa/casamanager.jsp").forward(request, response);
                    } else if (nome.isEmpty() && anno == 0 && metri == 0) {
                        updateListPrezzo(request);
                        getServletContext().getRequestDispatcher("/casa/casamanager.jsp").forward(request, response);
                    }else if (nome.isEmpty() && anno == 0 && prezzo == 0.0) {
                        updateListMetri(request);
                        getServletContext().getRequestDispatcher("/casa/casamanager.jsp").forward(request, response);
                    } else{
                        System.out.println("claudio fai schifo");
                    }
                    break;
                case "PREPARE_UPDATE":
                    int idCasaToUpdate = Integer.parseInt(request.getParameter("id"));
                    CasaDTO casaToUpdate = service.read(idCasaToUpdate);
                    request.setAttribute("casaToUpdate", casaToUpdate);
                    getServletContext().getRequestDispatcher("/casa/updatecasa.jsp").forward(request, response);
                    break;

                case "DELETE":
                    int idCasaToDelete = Integer.parseInt(request.getParameter("id"));
                    if(service.delete(idCasaToDelete)) {
                        updateList(request);
                        request.getRequestDispatcher("/casa/casamanager.jsp").forward(request, response);
                    } else throw new RuntimeException("Cancellazione non andata a buon fine");
                    break;

                default:
                    throw new RuntimeException("Metodo " + mode + " non disponibile");
            }
        } else throw new RuntimeException("Nessun metodo specificato");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mode = request.getParameter("mode");
        if (mode != null){
            String nome = request.getParameter("nome");
            double prezzo = Double.parseDouble(request.getParameter("prezzo"));
            String indirizzo = request.getParameter("indirizzo");
            String metri_quadrati = request.getParameter("metri_quadrati");
            String costruita = request.getParameter("costruita");
            String dettagli = request.getParameter("dettagli");
            String tipo = request.getParameter("tipo");
            boolean disponibile = Boolean.parseBoolean(request.getParameter("disponibile"));
            System.out.println(disponibile);

            UserDTO user = (UserDTO) request.getSession().getAttribute("user");
            int adminId = user.getId();

            AgenziaDTO agenzia = agenziaService.findByFk(adminId);
            int id_agenzia = agenzia.getId();

            CasaDTO casa = new CasaDTO(nome, prezzo, indirizzo, metri_quadrati, costruita, dettagli, tipo, disponibile, id_agenzia);

            switch (mode.toUpperCase()) {
                case "INSERT":
                    if(service.insert(casa)) {
                        updateList(request);
                        request.getRequestDispatcher("/casa/casamanager.jsp").forward(request, response);
                    } else throw new RuntimeException("Inserimento non andato a buon fine");
                    break;
                case "UPDATE":
                    int id = Integer.parseInt(request.getParameter("id"));
                    casa.setId(id);
                    if(service.update(casa)) {
                        updateList(request);
                        request.getRequestDispatcher("/casa/casamanager.jsp").forward(request, response);
                    } else throw new RuntimeException("Modifica non andata a buon fine");
                    break;
            }
        } else throw new RuntimeException("Nessun metodo specificato");
    }
}
