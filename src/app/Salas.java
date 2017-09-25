package app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import datos.Horario;
import datos.Sala;
import filemanager.Filemanager;

/**
 * Administra y almacena las Salas.
 * @author Kenneth, Caleb, Lery
 *
 */
class Salas {
	static List<Sala> rooms = new ArrayList<Sala>();
	
	/**
	 * Agrega una sala INACTIVA.
	 * @param pCapacity - Capacidad de la sala.
	 * @param pSchedule - Horario a asiganar.
	 * @param pPlace - Lugar.
	 */
	static void addRoom(int pCapacity,Horario pSchedule,String pPlace) {
		rooms.add(new Sala(pCapacity,pSchedule,pPlace));
	}
	/**
	 * Agrega una sala según el estado que se especifique.
	 * @param pCapacity - Capacidad de la sala.
	 * * @param pstatus - Estado.
	 * @param pSchedule - Horario a asiganar.
	 * @param pPlace - Lugar.
	 */
	static void addRoom(int pCapacity, int pstatus,Horario pSchedule,String pPlace) {
		rooms.add(new Sala(pCapacity,pstatus,pSchedule,pPlace));
	}
	/**
	 * Retorna un String[] de la lista de salas.
	 * @return String[] con la lista de salas.
	 */
	static String[] getRoomList() {
		String[] roomList = new String[rooms.size()];
		for(int i = 0; i < rooms.size();i++) {
			roomList[i] = rooms.get(i).getId();
		}
		return roomList;
	}
	/**
	 * Retorna la información de una sala en específico según su ID.
	 * @param pId - ID de la sala.
	 * @return Info de la sala.
	 */
	static String getRoomInfo(String pId) {
		for(int i = 0; i < rooms.size();i++) {
			if(rooms.get(i).getId().equals(pId)){
				return rooms.get(i).toString();
			}
		}
		return "No hay una sala con ese código.";
	}
	/**
	 * Retorna un String[] filtrado según los parametros de búsqueda.
	 * @param pCapacity - Capacidad mínima.
	 * @param resources - Recursos mínimos.
	 * @return String[] con el resultado de la búsqueda.
	 */
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
	/**
	 * Cambia el estado de una sala.
	 * @param pID - ID de la sala.
	 * @param pStatus - Estado.
	 * @return true si fue cambiado.
	 */
	static boolean changeStatus(String pID,int pStatus) {
		for(int i = 0;i < rooms.size();i++) {
			if(rooms.get(i).getId().equals(pID)) {
				rooms.get(i).switchStatus(pStatus);
				return true;
			}
		}
		return false;
	}
	/**
	 * Cambia la ubicación de una sala.
	 * @param pID - ID de la sala.
	 * @param pPlace - Ubicación.
	 * @return true si fue cambiado.
	 */
	static boolean changePlace(String pID,String pPlace) {
		for(int i = 0;i < rooms.size();i++) {
			if(rooms.get(i).getId().equals(pID)) {
				rooms.get(i).setPlace(pPlace);
				return true;
			}
		}
		return false;
	}
	/**
	 * Retorna una sala según el ID.
	 * @param pId - ID de la sala.
	 * @return Sala.
	 */
	public static Sala getRoom(String pId) {
		for(int i = 0; i < rooms.size();i++) {
			if(rooms.get(i).getId().equals(pId)) {
				return rooms.get(i);
			}
		}
		return null;
	}
	/**
	 * Agrega un recurso a una sala.
	 * @param pID - ID de la sala.
	 * @param pResource - Recurso a agregar.
	 * @return true si fue agregado.
	 */
	static boolean addResource(String pID,String pResource) {
		for(int i = 0;i < rooms.size();i++) {
			if(rooms.get(i).getId().equals(pID)) {
				rooms.get(i).addResource(pResource);
				return true;
			}
		}
		return false;
	}
	/**
	 * Quita un recurso a una sala.
	 * @param pID - ID de la sala.
	 * @param pIndex - Recuros a quitar.
	 * @return true si fue removido.
	 */
	static boolean removeResource(String pID,int pIndex) {
		for(int i = 0;i < rooms.size();i++) {
			if(rooms.get(i).getId().equals(pID)) {
				rooms.get(i).removeResource(pIndex);
				return true;
			}
		}
		return false;
	}
	/**
	 * Retorna los recursos de una sala en forma de String[]. 
	 * @param pID - ID de la sala.
	 * @return String[] con la lista de recuros de la sala especificada.
	 */
	static String[] getResources(String pID) {
		for(int i = 0;i < rooms.size();i++) {
			if(rooms.get(i).getId().equals(pID)) {
				return rooms.get(i).getResources();
			}
		}
		return new String[0];
	}
	/**
	 * Carga toda la información de las salas.
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public static void load() throws ClassNotFoundException, IOException {
		try {
			rooms = (List<Sala>) Filemanager.load("Salas.xml");
			Sala.setCount(rooms.size() + 1);
		} catch(Exception e) {
			rooms = new ArrayList<Sala>();
		}
	}
	/**
	 * Guarda toda la información de las salas.
	 */
	public static void save() {
		Filemanager.save(rooms, "Salas.xml");
	}
}
