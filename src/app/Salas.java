package app;

import java.util.ArrayList;
import java.util.List;

import datos.Horario;
import datos.Sala;
import xml.XmlParser;

class Salas {
	static List<Sala> rooms = new ArrayList<Sala>();
	
	static void addRoom(int pCapacity,Horario pSchedule) {
		rooms.add(new Sala(pCapacity,pSchedule));
	}
	
	static void addRoom(int pCapacity, boolean pstatus,Horario pSchedule) {
		rooms.add(new Sala(pCapacity,pstatus,pSchedule));
	}
	
	public static void save() {
		try {
			XmlParser.write(rooms, "SalasDB.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void load() {
		try {
			rooms = (ArrayList<Sala>) XmlParser.read("SalasDB.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
