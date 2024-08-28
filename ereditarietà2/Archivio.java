package ereditarietà2;

public class Archivio {
	
	private Casa[] v = new Casa [10];
	
	public Archivio (Casa []c) {
		 this.v = c;
	 }
	
	public int mediaCase (int n) {
		int media = 0;
		int count = 0;
		int somma = 0;
		for (Casa casa : v) {
			if (casa !=null && casa.getSuperficie()> n) {
				somma = somma +casa.Costo();
				count ++; 
			}
		}
		media = somma/count;				
		return media;
	}

}
