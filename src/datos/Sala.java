package datos;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * 
 * 
 * @author Kenneth Herrera, Caleb Saenz, Lery Sanchez 
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
	
	public Sala(){
	}
	
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
	
	public void addResource(String pResources) {
		resources.add(pResources);
	}
	
	public void removeResource(int pIndex) {
		resources.remove(pIndex);
	}
	public String getResource(int index) {
		return resources.get(index);
	}
	
	public boolean hasResource(String pResource) {
		for(int i = 0; i < resources.size();i++) {
			if(resources.get(i).equals(pResource)) {
				return true;
			}
		}
		return false;
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
