package ereditarietà2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Appartemento a = new Appartemento(100, 3000, 1);
		Appartemento b = new Appartemento(1000, 4000, 1);
		Villa c = new Villa (100,30000,true);
		
		Casa []ar = new Casa [10];
		ar[0]=a;
		ar[1]=b;
		ar[2]=c;
		
		Archivio arc = new Archivio(ar);
		System.out.println(arc.mediaCase(50));

	}

}
