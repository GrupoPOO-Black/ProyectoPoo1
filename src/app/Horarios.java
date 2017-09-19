package app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import datos.Horario;
import datos.Reserva;
import filemanager.Filemanager;

class Horarios {
	static List<Horario> schedules = new ArrayList<Horario>();
	
	
	
	public static void save() {
		Filemanager.save(schedules, "Horarios.db");
	}
	
	public static void load() throws ClassNotFoundException, IOException {
		Filemanager.load("Horarios.db");
	}
}
