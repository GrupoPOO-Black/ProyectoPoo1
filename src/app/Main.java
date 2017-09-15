package app;
import mailing.Mail;
import java.util.List;
import java.util.ArrayList;

import datos.*;
import xml.*;

@SuppressWarnings("unchecked")
public class Main {
	
	static List<Estudiante> students = new ArrayList<Estudiante>();
	static List<Sala> rooms = new ArrayList<Sala>();
	static List<Reserva> reservations = new ArrayList<Reserva>();
	

	
	public static void main(String[] args) throws Exception {
		
		
		
		students.add(new Estudiante("Kenneth","2016","Ing. Computacion","kfhv.24@gmail.com",100,"89657436"));
		
		
		Sala sala = new Sala(5);
	    
	    
	    Reserva reserva = new Reserva(students.get(0), sala, new Hora());
	    
	    System.out.println(reserva.toString());
		
	}

	void saveData() {
		try {
			XmlParser.write(students, "EstudiantesDB.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			XmlParser.write(rooms, "SalasDB.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			XmlParser.write(reservations, "ReservacionesDB.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void loadData() {
		try {
			students = (ArrayList<Estudiante>) XmlParser.read("EstudiantesDB.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			rooms = (ArrayList<Sala>) XmlParser.read("SalaDB.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			reservations = (ArrayList<Reserva>) XmlParser.read("ReservacionesDB.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
