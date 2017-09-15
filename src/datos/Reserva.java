package datos;

import java.util.*;

public class Reserva {
	private static int reservations = 0;
	private int reserveID;
	private Estudiante student;
	private Sala room;
	
	
	
	public Reserva(Estudiante pStudent,Sala pRoom,Hora hour){
		reserveID = reservations++;
		student = pStudent;
		room =  pRoom;
	}
	
}
