package libreriaPatternDAO;

import java.util.List;

public interface LibroDAO {

	public List<Libro> getAll();

	public Libro getByIsbn(int isbn);

	public void save(Libro l);

	public void delete(Libro l);

	public void update(Libro l);
}
