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
	
	public static boolean INACTIVE = false;
	public static boolean ACTIVE = false;
	
	private static int cSalas = 001;
	private String id = "SAL-";
	private int capacity;
	private ArrayList<String> resources = new ArrayList<String>();
	
	private boolean status = INACTIVE;
	private float score = 100;
	
	private Horario schedule;
	
	public Sala(){
	}
	
	public Sala(int pcapacity, boolean pstatus,Horario pSchedule){
		id = id + cSalas;
		cSalas++;
		capacity = pcapacity;
		status = pstatus;
		schedule = pSchedule;
	}
	
	public Sala(int pcapacity,Horario pSchedule){
		id = id + cSalas;
		cSalas++;
		capacity = pcapacity;
		schedule = pSchedule;
	}
	
	public void addresource(String resource) {
		resources.add(resource);
	}
	
	public ArrayList<String> getResources() {
		return resources;
	}
	
	public String getId() {
		return id;
	}

	public int getCapacity() {
		return capacity;
	}

	public boolean getStatus() {
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
	
	public void switchStatus() {
		status = !status;
	}

	public String toString(){
		return(id + "\n Capacidad: " + capacity + "\n Estado: " + status + "\n" + schedule.toString());
	}
	
	
}
