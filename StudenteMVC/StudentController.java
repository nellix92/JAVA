package StudenteMVC;

public class StudentController {

	private Student model;
	private StudentView view;

	public Student getModel() {
		return model;
	}

	public void setModel(Student model) {
		this.model = model;
	}

	public StudentView getView() {
		return view;
	}

	public void setView(StudentView view) {
		this.view = view;
	}

	public StudentController(Student model, StudentView view) {
		this.model = model;
		this.view = view;
	}
	
	public void setStudentName (String nome) {
		model.setNome(nome);
	}
	
	public String getNome () {
		return model.getNome();
	}
	
	public void setRollNo (String rollNo) {
		model.setRollNo(rollNo);
	}
	public String getRollNo () {
		return model.getRollNo();
	}
	
	public void updateView () {
		view.stampaStudente(model);
	}
	
}
