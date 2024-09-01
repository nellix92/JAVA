package libreriaPatternDAO;

import java.util.ArrayList;
import java.util.List;

public class LibroFacade {

	private LibroDAOImpl lDAO = new LibroDAOImpl();

	public List<LibroDTO> getAll() {
		List<LibroDTO> resdto = new ArrayList<LibroDTO>();
		List<Libro> res = lDAO.getAll();
		for (Libro libro : res) {
			LibroDTO bdto = new LibroDTO(libro.getNome(), libro.getIsbn());
			resdto.add(bdto);
		}

		return resdto;

	}

	public void save(LibroDTO lDTO) {
		Libro l = new Libro(lDTO.getNome(), lDTO.getIsbn());
		lDAO.save(l);

	}
}
