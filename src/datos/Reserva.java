package datos;

import java.io.Serializable;
import java.util.*;

public class Reserva implements Serializable {
	private static int reservations = 0;
	private int reserveID;
	private Estudiante student;
	private int people;
	private Sala room;
	private GregorianCalendar date;
	private Hora hour;
	private String subject;
	
	
	public Reserva(Estudiante pStudent,Sala pRoom,GregorianCalendar pDate,Hora pHour,String pSubject,int pPeople){
		reserveID = ++reservations;
		student = pStudent;
		room =  pRoom;
		date = pDate;
		hour = pHour;
		subject = pSubject;
		people = pPeople;
	}
	
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



	public String getSubject() {
		return subject;
	}
	
	public int getPeople() {
		return people;
	}

	public String toString() {
		String msg = "Reserva:\nID: " + reserveID;
		msg += "\nAsunto a tratar:\n" + subject;
		msg += "\nEstudiante:\n" + student.toString();
		msg += "Sala:\n" +  room.toString();
		msg += "Fecha:\n " + date.get(date.DAY_OF_MONTH) + "/" + date.get(date.MONTH) + "/" +  date.get(date.YEAR);
		msg += "\nHora:\n" + hour.toString();
		return msg;
	}
	
}
