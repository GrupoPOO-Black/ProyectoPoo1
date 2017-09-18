package app;

import java.util.ArrayList;
import java.util.List;

import datos.Horario;
import datos.Reserva;
import xml.XmlParser;

class Horarios {
	static List<Horario> schedules = new ArrayList<Horario>();
	
	public static void save() {
		try {
			XmlParser.write(schedules, "HorariosDB.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void load() {
		try {
			schedules = (ArrayList<Horario>) XmlParser.read("HorariosDB.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
