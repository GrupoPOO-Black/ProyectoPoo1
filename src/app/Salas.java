package app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import datos.Horario;
import datos.Sala;
import filemanager.Filemanager;

class Salas {
	static List<Sala> rooms = new ArrayList<Sala>();
	
	static void addRoom(int pCapacity,Horario pSchedule,String pPlace) {
		rooms.add(new Sala(pCapacity,pSchedule,pPlace));
	}
	
	static void addRoom(int pCapacity, int pstatus,Horario pSchedule,String pPlace) {
		rooms.add(new Sala(pCapacity,pstatus,pSchedule,pPlace));
	}
	
	static String[] getRoomList() {
		String[] roomList = new String[rooms.size()];
		for(int i = 0; i < rooms.size();i++) {
			roomList[i] = rooms.get(i).getId();
		}
		return roomList;
	}
	
	static String getRoomInfo(String pId) {
		for(int i = 0; i < rooms.size();i++) {
			if(rooms.get(i).getId().equals(pId)){
				return rooms.get(i).toString();
			}
		}
		return "No hay una sala con ese código.";
	}
	
	static boolean changeStatus(String pID,int pStatus) {
		for(int i = 0;i < rooms.size();i++) {
			if(rooms.get(i).getId().equals(pID)) {
				rooms.get(i).switchStatus(pStatus);
				return true;
			}
		}
		return false;
	}
	
	static boolean changePlace(String pID,String pPlace) {
		for(int i = 0;i < rooms.size();i++) {
			if(rooms.get(i).getId().equals(pID)) {
				rooms.get(i).setPlace(pPlace);
				return true;
			}
		}
		return false;
	}
	
	static boolean addResource(String pID,String pResource) {
		for(int i = 0;i < rooms.size();i++) {
			if(rooms.get(i).getId().equals(pID)) {
				rooms.get(i).addresource(pResource);
				return true;
			}
		}
		return false;
	}
	
	static boolean removeResource(String pID,int rIndex) {
		for(int i = 0;i < rooms.size();i++) {
			if(rooms.get(i).getId().equals(pID)) {
				rooms.get(i).removeResource(rIndex);
				return true;
			}
		}
		return false;
	} 
	
	public static void save() {
		Filemanager.save(rooms, "Salas.db");
	}
	
	@SuppressWarnings("unchecked")
	public static void load() throws ClassNotFoundException, IOException {
		rooms = (List<Sala>) Filemanager.load("Salas.db");
	}
}
