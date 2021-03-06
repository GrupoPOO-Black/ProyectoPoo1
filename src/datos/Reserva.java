package datos;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 * Clase reserva.
 * @author Kenneth, Caleb, Lery
 *
 */
public class Reserva implements Serializable {
	private static int reservations = 0;
	private int reserveID;
	private Estudiante student;
	private int people;
	private Sala room;
	private GregorianCalendar date;
	private Hora hour;
	private String subject;
	
	private boolean canceled = false;
	
	/**
	 * Crea una reserva.
	 * @param pStudent - Estudiante a cargo de la reserva.
	 * @param pRoom - Sala cual será reservada.
	 * @param pDate - Fecha de la reserva.
	 * @param pHour - Hora de la reserva.
	 * @param pSubject - Asunto de la reserva. 
	 * @param pPeople - Cantidad de personas.
	 */
	public Reserva(Estudiante pStudent,Sala pRoom,GregorianCalendar pDate,Hora pHour,String pSubject,int pPeople){
		reserveID = ++reservations;
		student = pStudent;
		room =  pRoom;
		date = pDate;
		hour = pHour;
		subject = pSubject;
		people = pPeople;
	}
	
	/**
	 * Cancela una reserva, y se llama a la función en estudiantes que lo penaliza.
	 */
	public void cancelReservation() {
		canceled = true;
		student.reservationCanceled();
	}
	
	
	//GETTERS & SETTERS
	public int getReserveID() {
		return reserveID;
	}

	public Estudiante getStudent() {
		return student;
	}

	public Sala getRoom() {
		return room;
	}

	public GregorianCalendar getDate() {
		return date;
	}

	public Hora getHour() {
		return hour;
	}
	
	public boolean isCanceled() {
		return canceled;
	}

	public String getSubject() {
		return subject;
	}
	
	public int getPeople() {
		return people;
	}
	
	public static void setCount(int count) {
		reservations = count;
	}

	public String toString() {
		String msg = "\nReserva:\nID: " + reserveID;
		if(canceled) {
			msg += " CANCELADA\n";
		}
		msg += "\nAsunto a tratar:\n" + subject;
		msg += "\nEstudiante:\n" + student.getName();
		msg += "\nSala:\n" +  room.getInfo();
		msg += "Fecha:\n " + new SimpleDateFormat("dd/MMM/yyyy").format(new Date(date.getTimeInMillis()));
		msg += "\nHora:\n" + hour.toString();
		return msg;
	}
	
}
