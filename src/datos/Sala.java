package datos;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Clase sala.
 * @author Kenneth, Caleb, Lery
 *
 */

@SuppressWarnings("serial")
public class Sala implements Serializable{
	
	public final static int INACTIVE = 0;
	public final static int MAINTENACE = 1;
	public final static int ACTIVE = 2;
	
	private static int cSalas = 1;
	private String id = "SAL-";
	private int capacity;
	private String place;
	private ArrayList<String> resources = new ArrayList<String>();
	
	private int status = INACTIVE;
	private float score = 100;
	
	private Horario schedule;
	
	/**
	 * Constructor de la clase sala el cuál permite establecer el estado de la misma.
	 * @param pcapacity - Capacidad de la sala.
	 * @param pstatus - Estado de la sala.
	 * @param pSchedule - Horario de la sala.
	 * @param pPlace - Lugar de la sala.
	 */
	public Sala(int pcapacity, int pstatus,Horario pSchedule,String pPlace){
		if(cSalas < 10) {
			id += "0";
		}
		if(cSalas < 100) {
			id += "0";
		}
		id = id + cSalas;
		cSalas++;
		capacity = pcapacity;
		status = pstatus;
		schedule = pSchedule;
		place = pPlace;
	}
	/**
	 * Constructor de la clase sala.
	 * @param pcapacity - Capacidad de la sala.
	 * @param pSchedule - Horario de la sala.
	 * @param pPlace - Lugar de la sala.
	 */
	public Sala(int pcapacity,Horario pSchedule,String pPlace){
		if(cSalas < 10) {
			id += "0";
		}
		if(cSalas < 100) {
			id += "0";
		}
		id = id + cSalas;
		cSalas++;
		capacity = pcapacity;
		schedule = pSchedule;
		place = pPlace;
	}
	/**
	 * Agrega un recurso a la sala.
	 * @param pResources
	 */
	public void addResource(String pResources) {
		resources.add(pResources);
	}
	/**
	 * Quita un recurso de la sala.
	 * @param pIndex
	 */
	public void removeResource(int pIndex) {
		resources.remove(pIndex);
	}
	
	/**
	 * Verifica que la sala tenga un recurso en específico.
	 * @param pResource - Recurso.
	 * @return true o false si tiene o no cierto recurso.
	 */
	public boolean hasResource(String pResource) {
		for(int i = 0; i < resources.size();i++) {
			if(resources.get(i).equals(pResource)) {
				return true;
			}
		}
		return false;
	}
	
	//GETTERS & SETTERS
	public String getResource(int index) {
		return resources.get(index);
	}
	
	public String[] getResources() {
		String[] resourcelist = new String[resources.size()];
		for(int i = 0; i < resources.size();i++) {
			resourcelist[i] = resources.get(i);
		}
		return resourcelist;
	}
	
	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getId() {
		return id;
	}

	public int getCapacity() {
		return capacity;
	}

	public int getStatus() {
		return status;
	}

	public float getScore() {
		return score;
	}
	
	public Horario getSchedule(){
		return schedule;
	}
	
	public void setSchedule(Horario pSchedule) {
		schedule = pSchedule;
	}
	
	public void switchStatus(int pStatus) {
		if(pStatus >=0 && pStatus <= 2) {
			status = pStatus;	
		}
	}
	
	public String getInfo(){
		String msg = id;
		msg += "\nUbicación: " + place + "\n";
		return msg;
	}
	
	public static void setCount(int count) {
		cSalas = count;
	}
	
	public String toString(){
		String msg = id + "\n Capacidad: " + capacity + "\n Estado: ";
		switch(status){
		case INACTIVE:
			msg += "Inactiva";
			break;
		case ACTIVE:
			msg += "Activa";
			break;	
		case MAINTENACE:
			msg += "En mantenimiento";
			break;
		}
		msg += "\nUbicación: " + place;
		msg += "\nRecursos: \n";
		if(resources.size() < 1) {
			msg += "    Vacio.\n";
		} else {
			for(int i = 0;i < resources.size();i++) {
				msg += "    " + resources.get(i) + "\n";
			}
		}
		return(msg + "\n" + schedule.toString());
	}

	
	
	
}
