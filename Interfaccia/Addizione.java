package Interfaccia;

public class Addizione implements operazione {

	@Override
	public void calcola(int a , int b) {
		// TODO Auto-generated method stub
		
		int somma = a + b;
		System.out.println("La somma è: "+somma);
		}

}
