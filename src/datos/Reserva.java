package datos;

import java.util.*;

public class Reserva {
	private static int reservations = 0;
	private int reserveID;
	private Estudiante student;
	private Sala room;
	private GregorianCalendar date;
	private Hora hour;
	private String subject;
	
	
	public Reserva(Estudiante pStudent,Sala pRoom,GregorianCalendar pDate,Hora pHour,String pSubject){
		reserveID = ++reservations;
		student = pStudent;
		room =  pRoom;
		date = pDate;
		hour = pHour;
		subject = pSubject;
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
