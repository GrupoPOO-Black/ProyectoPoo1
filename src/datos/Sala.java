package datos;

import java.util.ArrayList;

/**
 * 
 * 
 * 
 * @author Kenneth Herrera, Caleb Saenz, Lery Sanchez 
 *
 */

public class Sala {
	private static int cSalas = 001;
	private String id = "SAL-";
	private int capacity;
	private ArrayList<String> resources = new ArrayList<String>();
	
	private String status = "Inactive";
	private float score = 100;
	
	
	
	public Sala(int pcapacity){
		id = id + cSalas;
		cSalas++;
		capacity = pcapacity;
		
		System.out.println("Sala c�digo: " + id + " ha sido creada.");
	}
	
	public Sala(){
		
		
	}
	
	public Sala(int pcapacity, String pstatus){
		id = id + cSalas;
		cSalas++;
		capacity = pcapacity;
		status = pstatus;
		
		System.out.println("Sala c�digo: " + id + " ha sido creada.");
		
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

	public String getStatus() {
		return status;
	}

	public float getScore() {
		return score;
	}

	public String toString(){
		return(id + "\n Capacidad: " + capacity + "\n Estado: " + status);
	}
	
	
}
