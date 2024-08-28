package StudenteMVC;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StudentView view = new StudentView();
		Student model = new Student();
		model.setNome("Nello");
		model.setRollNo("1");
		StudentController controller = new StudentController(model, view);
		controller.updateView();
		view.stampaStudente(model);

	}

}
