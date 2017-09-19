package datos;

import java.io.Serializable;

public class Estudiante implements Serializable{
	
	private String idNumber;
	
	private String name;
	private String career;
	private String email;
	private String phoneNumber;
	
	private int weekrReservations;
	private int score;
	
	//constructor
	public Estudiante(String pName, String pIdNumber, String pCareer, String pEmail, int pScore, String pPhoneNumber) {
		name = pName;
		idNumber = pIdNumber;
		career = pCareer;
		email = pEmail;
		score = pScore;
		phoneNumber = pPhoneNumber;
		weekrReservations = 0;
	}
	
	public Estudiante(String pName, String pIdNumber, String pCareer, String pEmail, int pScore, String pPhoneNumber,int pWeekrReservations) {
		name = pName;
		idNumber = pIdNumber;
		career = pCareer;
		email = pEmail;
		score = pScore;
		phoneNumber = pPhoneNumber;
		weekrReservations = pWeekrReservations;
	}
	
	
	
	

	@Override
	public String toString() {
		String msg = "Nombre: " + name;
		msg += "\nCarnet: " + idNumber;
		msg += "\nCarrera: " + career;
		msg += "\nEmail: " + email;
		msg += "\nNumero de telefono: " + phoneNumber;
		msg += "\nPuntuacion: " + score + "\n";
		return msg;
	}




	//getters & setters
	public void addWeekReservations() {
		weekrReservations++;
	}
	
	public int getWeekReservations() {
		return weekrReservations;
	}
	
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
