package app;
import java.util.ArrayList;
import java.util.List;

import datos.*;
import xml.XmlParser;
public class Reservaciones {
	static List<Reserva> reservations = new ArrayList<Reserva>();
	
	static void reserveRoom() {
		
		
	}
	
	public static void save() {
		try {
			XmlParser.write(reservations, "ReservacionesDB.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void load() {
		try {
			reservations = (ArrayList<Reserva>) XmlParser.read("ReservacionesDB.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
