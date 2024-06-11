package it.contrader.view;

import it.contrader.controller.Request;
import it.contrader.controller.Response;
import it.contrader.dto.UserDTO;
import it.contrader.main.MainDispatcher;

public class SignUpAdminView extends AbstractView {

    private String username;
    private String password;

    private String nomeAgenzia;
    private String usertype = "ADMIN";

    public SignUpAdminView() {
    }

    @Override
    public void showResults(Response response) {
        if (response!=null) {
            System.out.println("Inserimento andato a buon fine.\n");
            Request request = new Request("User", "getAll", null);
            MainDispatcher.getInstance().callAction(request);
        }

    }

    @Override
    public void showOptions() {
        System.out.println("Inserisci username dell'admin:");
        username = getInput();
        System.out.println("Inserisci password dell'admin:");
        password = getInput();

    }

    @Override
    public void submit() {
        Request request = new Request();
        UserDTO userToInsert = new UserDTO(username, password, usertype);
        request.getBody().put("userToInsert", userToInsert);
        request.setMethod("registerAdmin");
        request.setController("Home");
        MainDispatcher.getInstance().callAction(request);

    }
}
