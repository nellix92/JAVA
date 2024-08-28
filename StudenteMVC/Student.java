package StudenteMVC;

public class Student {

	private String nome;
	private String rollNo;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	@Override
	public String toString() {
		return "Student [nome=" + nome + ", rollNo=" + rollNo + "]";
	}

	
}
