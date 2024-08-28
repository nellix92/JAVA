package Interfaccia;

public class Divisione implements operazione {
	public void calcola (int a , int b) {
		int rapporto = a/b;
		System.out.println("La divisione è: "+rapporto);
	}

}
