package app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import datos.Horario;
import datos.Sala;
import filemanager.Filemanager;

class Salas {
	static List<Sala> rooms = new ArrayList<Sala>();
	
	static void addRoom(int pCapacity,Horario pSchedule) {
		rooms.add(new Sala(pCapacity,pSchedule));
	}
	
	static void addRoom(int pCapacity, boolean pstatus,Horario pSchedule) {
		rooms.add(new Sala(pCapacity,pstatus,pSchedule));
	}
	
	static Sala getRoom(int index) {
		try {
			return rooms.get(index);
		} catch (Exception e) {
			return null;
		}
		
	}
	
	public static void save() {
		Filemanager.save(rooms, "Salas.db");
	}
	
	@SuppressWarnings("unchecked")
	public static void load() throws ClassNotFoundException, IOException {
		rooms = (List<Sala>) Filemanager.load("Salas.db");
	}
}
