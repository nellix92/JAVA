package Biblioteca;


public class Libreria {

	private Libro[]libri;

	public Libreria(Libro[] libri) {
		super();
		this.libri = libri;
	}

	public Libro[] getLibri() {
		return libri;
	}

	public void setLibri(Libro[] libri) {
		this.libri = libri;
	}
	
	public int trovaLibri (String a, int k) {
		int count = 0;
		for (Libro libro : libri) {
			if(libro.getAutore().equals(a)&&libro.getPrezzo()>k) {
				count++;
			}
		}
		return count;
	}
	public String [] trovaByAutore(String a) {
		String []titoli = new String[this.libri.length];
		int pos=0;
		for (Libro libro : libri) {
			if(libro.getAutore().equals(a)) {
				titoli[pos]=libro.getTitolo();
				pos++;
			}
		}
		return titoli;
	}
	
	public static void main(String[] args) {
		Libro l = new Libro("Harry Potter", "JKR", 18);
		Libro l1 = new Libro("Harry Potter 2", "JKR", 18);
		Libro l2 = new Libro("Harry Potter 3", "JKR", 18);
		Libro l3 = new Libro("Il gattopardo", "Tommaso di Lampedusa", 18);
		
		Libro [] libro = new Libro[4];
		libro[0]=l;	
		libro[1]=l1;
		libro[2]=l2;
		libro[3]=l3;

		Libreria lib = new Libreria(libro);
		String a = "JKR";
		int prezzo = 12;
		
		System.out.println(lib.trovaLibri(a, prezzo));
		String [] titoli=lib.trovaByAutore(a);
		for (String s : titoli) {
			if(s!=null)
			System.out.println(s);
		}
				

	}
}
