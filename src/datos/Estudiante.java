package datos;

public class Estudiante {
	
	private String name;
	private String idNumber;
	private String career;
	private String email;
	private int score = 100;
	private String phoneNumber;
	
	
	//constructor
	public Estudiante(String pName, String pIdNumber, String pCareer, String pEmail, int pScore, String pPhoneNumber) {
		super();
		this.name = pName;
		this.idNumber = pIdNumber;
		this.career = pCareer;
		this.email = pEmail;
		this.score = pScore;
		this.phoneNumber = pPhoneNumber;
	}
	
	public Estudiante(){
		
	}
	
	
	
	

	@Override
	public String toString() {
		return "Estudiante [name=" + name + ", idNumber=" + idNumber + ", career=" + career + ", email=" + email
				+ ", score=" + score + ", phoneNumber=" + phoneNumber + "]";
	}




	//getters & setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	
	
	

}
