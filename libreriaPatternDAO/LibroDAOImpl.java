package libreriaPatternDAO;

import java.util.ArrayList;
import java.util.List;

public class LibroDAOImpl implements LibroDAO {

	private List<Libro> libri = new ArrayList<Libro>();
	
	
	@Override
	public List<Libro> getAll() {
		return libri;
	}

	@Override
	public Libro getByIsbn(int isbn) {
		Libro l = new Libro();
		for (Libro libro : libri) {
			if(libro.getIsbn()==isbn) {
				l=libro;
			}
		}
		return l;
	}

	@Override
	public void save(Libro l) {
		libri.add(l);
	}

	@Override
	public void delete(Libro l) {
		libri.remove(l);
		
	}

	@Override
	public void update(Libro l) {
		for (Libro libro : libri) {
			if (libro.getIsbn()==l.getIsbn()) {
				libro.setNome(l.getNome());
				libro.setIsbn(l.getIsbn());
				libro = l; // è uguale ai due di sopra solo che è una solo riga fi codice
				break;
			}
		}
	}
	
	
	
	
}
