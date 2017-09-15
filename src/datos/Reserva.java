package datos;

import java.util.*;

public class Reserva {
	private static int reservations = 0;
	private int reserveID;
	private Estudiante student;
	private Sala room;
	private Hora hour;
	private String subject;
	
	
	public Reserva(Estudiante pStudent,Sala pRoom,Hora pHour,String pSubject){
		reserveID = reservations++;
		student = pStudent;
		room =  pRoom;
		hour = pHour;
		subject = pSubject;
	}
	
	public String toString() {
		String msg = "Reserva:\n";
		msg += "Asunto a tratar:\n" + subject;
		msg += "Estudiante:\n" + student.toString();
		msg += "Sala:\n" +  room.toString();
		msg += "Hora:\n" + hour.toString();
		return msg;
	}
	
}
