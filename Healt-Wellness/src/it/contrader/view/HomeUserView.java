package it.contrader.view;


import it.contrader.controller.Request;
import it.contrader.controller.Response;
import it.contrader.main.MainDispatcher;
import it.contrader.main.UserSingleton;

public class HomeUserView extends AbstractView{

	private static String sub_anagrafica = "anagrafica.";

	private static String sub_agenzia = "agenzia.";
	String choice;

	@Override
	public void showResults(Response response) {
		if(response!=null) {
			System.out.println("\n Benvenuto in SAMPLE PROJECT " + response.getBody().get("username").toString() + "\n");
		}
	}

	@Override
	public void showOptions() {
		System.out.println("-------------MENU------------\n");
		System.out.println(" Seleziona cosa vuoi visualizzare:");
		System.out.println("[P]rofilo [S]torico_acquisti [C]atalogo [E]sci");
		choice = this.getInput();

	}

	@Override
	public void submit() {

		Request request = new Request();
		String choice2;
		switch (choice.toUpperCase()) {
			case "P":
				System.out.println(" Seleziona:");
				System.out.println("[V]isualizza_Profilo [M]odifica_Profilo [C]ancella profilo");
				choice2 = this.getInput();
				switch (choice2.toUpperCase()){
					case "V":
						System.out.println("ID\tUsername\tPassword\tTipo Utente");
						System.out.println("----------------------------------------------------\n");
						System.out.println(UserSingleton.getInstance().toString());
						MainDispatcher.getInstance().callView(sub_anagrafica + "AnagraficaRead", null);
						break;
					case "M":
						MainDispatcher.getInstance().callView(sub_anagrafica + "AnagraficaUpdate", null);
						break;
					case "C":
						MainDispatcher.getInstance().callView("CancellazioneUtente", null);
						break;
					default:
						System.out.println("Azione non disponibile");
						showOptions();
				}
				break;
			case "S":
				request.setController("Acquisto");
				request.setMethod("getAll");
				MainDispatcher.getInstance().callAction(request);
				break;
			case "C":
				request.setController("Casa");
				request.setMethod("getAll");
				MainDispatcher.getInstance().callAction(request);
				break;
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;
			default:
				System.out.println("Azione non disponibile");
				showOptions();
		}

	}

}
