package Interfaccia;

public class Moltiplicazione implements operazione{
	public void calcola(int a , int b) {
		int prodotto = a * b;
		System.out.println("La moltiplicazione è: "+prodotto);
	}

}
