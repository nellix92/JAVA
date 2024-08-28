package Interfaccia;

public class Sottrazione implements operazione {

	@Override
	public void calcola(int a, int b) {
		int sottrazione = a - b;
		System.out.println("La sottrazione è: "+sottrazione);
		
	}

}
