package app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import datos.Horario;
import datos.Reserva;
import filemanager.Filemanager;

class Horarios {
	private static List<Horario> schedules = new ArrayList<Horario>();
	public static Horario tmpSchedule;
	
	public static boolean addSchedule(Horario schedule) {
		for(int i = 0; i < schedules.size();i++) {
			if(schedules.get(i) == schedule){
				return false;
			}
		}
		schedules.add(schedule);
		return true;
	}
	
	static String[] getScheduleList() {
		String[] roomList = new String[schedules.size()];
		for(int i = 0; i < schedules.size();i++) {
			roomList[i] = schedules.get(i).getId();
		}
		return roomList;
	}
	
	static Horario getSchedule(String pId) {
		for(int i = 0;i < schedules.size();i++) {
			if(schedules.get(i).getId().equals(pId)) {
				return schedules.get(i);
			}
		}
		return new Horario();
	}
	
	public static void save() {
		Filemanager.save(schedules, "Horarios.db");
	}
	
	public static void load() throws ClassNotFoundException, IOException {
		Filemanager.load("Horarios.db");
	}

}
