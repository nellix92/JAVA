package it.contrader.controller;


import it.contrader.dto.AgencyDTO;
import it.contrader.dto.LoginDTO;
import it.contrader.dto.UserDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.LoginService;
import it.contrader.main.UserSingleton;
import it.contrader.service.UserService;

/**
 * Controller implementation for handling user authentication requests.
 * This Controller interacts with the LoginService to authenticate user credentials.
 */
public class HomeController implements Controller {

    private static String sub_package = "anagrafica.";

    private static String sub_package2 = "agenzia.";
    private final LoginService loginService;

    private final UserService userService;

    /**
     * Constructs a HomeController with a new instance of LoginService.
     */
    public HomeController() {
        loginService = new LoginService();
        userService = new UserService();
    }

    /**
     * Implements the method from Controller interface. Unpacks a request, extracts the username and password,
     * and uses LoginService to authenticate the user. Depending on the user type, it redirects to the corresponding view.
     * If authentication fails, it redirects back to the Login view.
     *
     * @param request A Request object that encapsulates the user's request.
     */
    public void doControl(Request request) {
        if (request != null) {
            switch (request.getMethod().toUpperCase()) {
                case "LOGIN":
                    UserDTO userDTO = loginService.login((LoginDTO)request.getBody().get("loginDTO"));
                    if (userDTO != null) {
                        Response response = new Response();
                        response.put("username", userDTO.getUsername());
                        UserSingleton.getInstance().setId(userDTO.getId());
                        UserSingleton.getInstance().setUsername(userDTO.getUsername());
                        UserSingleton.getInstance().setPassword(userDTO.getPassword());
                        UserSingleton.getInstance().setUsertype(userDTO.getUsertype());
                        switch (userDTO.getUsertype()) {
                            case "ADMIN":
                                AgencyDTO bdto = new AgencyDTO();
                                MainDispatcher.getInstance().callView("HomeAdmin", response);
                                break;
                            case "USER":
                                MainDispatcher.getInstance().callView("HomeUser", response);
                                break;
                            default:
                                MainDispatcher.getInstance().callView("Login", null);
                                break;
                        }
                    } else {
                        System.out.println("Invalid credentials");
                        MainDispatcher.getInstance().callView("Login", null);
                    }
                    break;
                case "REGISTERUSER":
                    UserDTO usertoinsert = (UserDTO) request.getBody().get("userToInsert");
                    userService.insert(usertoinsert);
                    Response response = new Response();
                    int id = userService.findId(usertoinsert.getUsername());
                    response.put("id", id);

                    UserSingleton.getInstance().setId(id);
                    UserSingleton.getInstance().setUsername(usertoinsert.getUsername());
                    UserSingleton.getInstance().setPassword(usertoinsert.getPassword());
                    UserSingleton.getInstance().setUsertype(usertoinsert.getUsertype());

                    MainDispatcher.getInstance().callView(sub_package + "AnagraficaInsert", response);
                    MainDispatcher.getInstance().callView("Login", null);
                    break;
                case "REGISTERADMIN":
                    /** iNSERISCO LE CREDENZIALI NEL DATABASE*/
                    UserDTO admintoinsert = (UserDTO)  request.getBody().get("userToInsert");
                    userService.insert(admintoinsert);
                    response = new Response();
                    id = userService.findId(admintoinsert.getUsername());
                    response.put("id", id);

                    UserSingleton.getInstance().setId(id);
                    UserSingleton.getInstance().setUsername(admintoinsert.getUsername());
                    UserSingleton.getInstance().setPassword(admintoinsert.getPassword());
                    UserSingleton.getInstance().setUsertype(admintoinsert.getUsertype());

                    /**INSERISCO L'ANAGRAFICA NEL DATABASE*/
                    MainDispatcher.getInstance().callView(sub_package + "AnagraficaInsert", response);
                    MainDispatcher.getInstance().callView(sub_package2 + "AgenziaInsert", response);
                default:
                    System.out.println("No method matches the inserted method: " + request.getMethod());
                    MainDispatcher.getInstance().callView("Login", null);
            }
        } else MainDispatcher.getInstance().callView("Login", null);
    }
}

