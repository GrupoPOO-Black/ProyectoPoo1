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
	
	public static int INACTIVE = 0;
	public static int MAINTENACE = 1;
	public static int ACTIVE = 2;
	
	private static int cSalas = 001;
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
		id = id + cSalas;
		cSalas++;
		capacity = pcapacity;
		status = pstatus;
		schedule = pSchedule;
		place = pPlace;
	}
	
	public Sala(int pcapacity,Horario pSchedule,String pPlace){
		id = id + cSalas;
		cSalas++;
		capacity = pcapacity;
		schedule = pSchedule;
		place = pPlace;
	}
	
	public void addresource(String resource) {
		resources.add(resource);
	}
	
	public void removeResource(int rIndex) {
		resources.remove(rIndex);
	}
	
	public ArrayList<String> getResources() {
		return resources;
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

	public String toString(){
		return(id + "\n Capacidad: " + capacity + "\n Estado: " + status + "\n" + schedule.toString());
	}

	
	
	
}
