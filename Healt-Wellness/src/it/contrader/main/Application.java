package it.contrader.main;

import java.util.Scanner;

/*
 * Ogni applicazione java necessita di una funzione main() 
 * Essa sar� di fatto la prima funzione chiamata dalla JVM, la sua mancanza verr� infatti notata dall'interprete che 
 * quindi non permetter� l'avvio del programma.
 * Banalmente qualsiasi applicazione a cascata ( stile C ) potrebbe essere interamente scritta all'interno del main
 * ma questo non avrebbe senso all'interno di un linguaggio di programmazione ad oggetti.
 * Per ulteriori dettagli GUIDA SEZIONE 1.
*/
public class Application {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("[L]ogin or [S]ignUp?");
        String res = scanner.next().toUpperCase();
        if (res.equals("S")) {
            System.out.println("Sei un [U]tente o un [A]dmin?");
            String res2 = scanner.next().toUpperCase();
            switch (res2) {
                case "U":
                    res = "SignUpUser";
                    break;
                case "A":
                    res = "SignUpAdmin";
                    break;
                default:
                    System.out.println("Opzione non valida!");
            }
        } else if(res.equals("L")){
            res = "Login";
        } else {
            System.out.println("Opzione non valida!");
            MainDispatcher.getInstance().callView("Login", null);
        }
        MainDispatcher.getInstance().callView(res, null);
    }
}
