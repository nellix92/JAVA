package libreriaPatternDAO;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		LibroFacade bd = new LibroFacade();
		LibroDTO l = new LibroDTO("Harry Potter 1", 1232555669);
		LibroDTO l1 = new LibroDTO("Harry Potter 2", 1232555670);
		LibroDTO l2 = new LibroDTO("Harry Potter 3", 1232555671);

		bd.save(l);
		;
		bd.save(l1);
		bd.save(l2);

		System.out.println(bd.getAll());

	}

}
