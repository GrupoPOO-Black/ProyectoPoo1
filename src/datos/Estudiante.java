package datos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase estudiante.
 * @author Kenneth, Caleb, Lery
 *
 */
public class Estudiante implements Serializable{
	
	private String idNumber;
	
	private String name;
	private String career;
	private String email;
	private String phoneNumber;
	
	private List<String> incidents = new ArrayList<String>();
	private int weekReservations;
	private int score;
	
	/**
	 * Contructor de la clase Estudiante.
	 * @param pName - Nombre del estudiante.
	 * @param pIdNumber - Carnet del estudiante.
	 * @param pCareer - Carrera del estudiante.
	 * @param pEmail - Email del estudiante.
	 * @param pScore - Puntuación del estudiante.
	 * @param pPhoneNumber - Número de teléfono.
	 */
	public Estudiante(String pName, String pIdNumber, String pCareer, String pEmail, int pScore, String pPhoneNumber) {
		name = pName;
		idNumber = pIdNumber;
		career = pCareer;
		email = pEmail;
		score = pScore;
		phoneNumber = pPhoneNumber;
		weekReservations = 0;
	}
	/**
	 * Muestra la información del estudiante.
	 * @return String info.
	 */
	public String showInfo() {
		String msg = "Nombre: " + name;
		msg += "\nCarnet: " + idNumber;
		msg += "\nCarrera: " + career;
		msg += "\nEmail: " + email;
		msg += "\nNumero de telefono: " + phoneNumber;
		msg += "\nPuntuacion: " + score + "\n";
		if(incidents.size()>0) {
			msg += "Incidentes: \n";
			for(int i = 0;i < incidents.size();i++) {
				msg += "	" + (i + 1) + ") " + incidents.get(i) + "\n";
			}
		}
		return msg;
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
	public void addIncident(String pIncident, int penalization) {
		incidents.add(pIncident);
		if(score >= penalization) {
			score -= penalization;
		} else {
			score = 0;
		}
	}
	
	public void reservationCanceled() {
		score--;
	}
	
	public List<String> getIncidents(){
		
		return incidents;
	}
	
	public void addWeekReservations() {
		weekReservations++;
	}
	
	public int getWeekReservations() {
		return weekReservations;
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

	public void resetWeekReservations() {
		weekReservations = 0;
	}
}
