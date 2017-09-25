package app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import datos.Horario;
import filemanager.Filemanager;
/**
 * Administra y almacena todos los horarios
 * 
 * @author Kenneth, Caleb, Lery
 *
 */
class Horarios {
	private static List<Horario> schedules = new ArrayList<Horario>();
	public static Horario tmpSchedule;
	/**
	 * Agrega un horario a la lista.
	 * @param schedule - Horario
	 * @return true si fue agregado.
	 */
	public static boolean addSchedule(Horario schedule) {
		for(int i = 0; i < schedules.size();i++) {
			if(schedules.get(i) == schedule){
				return false;
			}
		}
		schedules.add(schedule);
		return true;
	}
	/**
	 * Retorna toda la lista de Horarios como un String[].
	 * @return String[] con la lista de horarios.
	 */
	static String[] getScheduleList() {
		String[] roomList = new String[schedules.size()];
		for(int i = 0; i < schedules.size();i++) {
			roomList[i] = schedules.get(i).getId();
		}
		return roomList;
	}
	/**
	 * Retorna un horario según su ID
	 * @param pId - Código de identificación
	 * @return Horario.
	 */
	static Horario getSchedule(String pId) {
		for(int i = 0;i < schedules.size();i++) {
			if(schedules.get(i).getId().equals(pId)) {
				return schedules.get(i);
			}
		}
		return new Horario();
	}
	/**
	 * Guarda toda la información sobre los horarios.
	 */
	public static void save() {
		Filemanager.save(schedules, "Horarios.xml");
	}
	/**
	 * Carga toda la información sobre los horarios.
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public static void load() throws ClassNotFoundException, IOException {
		try {
			schedules = (ArrayList<Horario>) Filemanager.load("Horarios.xml");
			Horario.setCount(schedules.size());
		} catch (Exception e) {
			schedules = new ArrayList<Horario>();
		}
		
	}
	
}
