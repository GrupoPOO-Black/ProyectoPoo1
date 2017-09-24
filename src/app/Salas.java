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
	
	static String[] searchRoom(int pCapacity,String[] resources) {
		
		List<Sala> tmpRooms = new ArrayList<Sala>();
		
		for(int i = 0;i < rooms.size();i++) {
			if(rooms.get(i).getCapacity() > pCapacity && rooms.get(i).getStatus() == Sala.ACTIVE) {
				boolean validRoom = true;
				for(int i2 = 0;i2 < resources.length;i2++) {
					if(!rooms.get(i).hasResource(resources[i2])){
						validRoom = false;
						break;
					} 
				}
				if(validRoom){
					tmpRooms.add(rooms.get(i));
				}
			}
		}
		
		String[] result = new String[tmpRooms.size()];
		for(int i = 0; i < tmpRooms.size();i++) {
			result[i] = tmpRooms.get(i).getId();
		}
		
		return result;
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
	
	public static Sala getRoom(String pId) {
		for(int i = 0; i < rooms.size();i++) {
			if(rooms.get(i).getId().equals(pId)) {
				return rooms.get(i);
			}
		}
		return null;
	}
	
	
	static boolean addResource(String pID,String pResource) {
		for(int i = 0;i < rooms.size();i++) {
			if(rooms.get(i).getId().equals(pID)) {
				rooms.get(i).addResource(pResource);
				return true;
			}
		}
		return false;
	}
	
	static boolean removeResource(String pID,int pIndex) {
		for(int i = 0;i < rooms.size();i++) {
			if(rooms.get(i).getId().equals(pID)) {
				rooms.get(i).removeResource(pIndex);
				return true;
			}
		}
		return false;
	}

	static String[] getResources(String pID) {
		for(int i = 0;i < rooms.size();i++) {
			if(rooms.get(i).getId().equals(pID)) {
				return rooms.get(i).getResources();
			}
		}
		return new String[0];
	}
	
	@SuppressWarnings("unchecked")
	public static void load() throws ClassNotFoundException, IOException {
		rooms = (List<Sala>) Filemanager.load("Salas.xml");
	}
	
	public static void save() {
		Filemanager.save(rooms, "Salas.xml");
	}
}
