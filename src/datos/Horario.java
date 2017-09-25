package datos;
import java.io.Serializable;
import java.util.*;
/**
 * Horario de una Sala
 * @author Kenneth, Caleb, Lery
 *
 */
@SuppressWarnings("serial")
public class Horario implements Serializable {
	
	final public static int SUNDAY = 0;
	final public static int MONDAY = 1;
	final public static int TUESDAY = 2;
	final public static int WENDSDAY = 3;
	final public static int THURSDAY = 4;
	final public static int FRIDAY = 5;
	final public static int SATURDAY = 6;
	
	private static int ids = 1;
	
	
	private String id = "H-";
	private boolean[] opened = new boolean[7];
	private List<Hora> hours = new ArrayList<Hora>();
	
	/**
	 * Constructor sin parametros de la clase Horarios, por defecto sin días habilitados.
	 */
	public Horario(){
		id = id + ids;
		ids++;
		for(int i = 0;i < 7;i++) {
			opened[i] = false;
			hours.add(new Hora());
		}
	}
	
	/**
	 * 
	 * Establece la hora de disponibilidad de un dia especifico a una hora específica.
	 * 
	 * @param pDay - Día a verificar 0-6.
	 * @param pHour - Hora a verificar.
	 */
	public void setSchedule(int pDay, Hora pHour) {
		if(validDay(pDay)) {
			opened[pDay] = true;
			hours.set(pDay, pHour);
		}
	}
	
	
	//GETTERS & SETTERS
	public String getId() {
		return id;
	}
	
	public boolean[] getOpened() {
		return opened;
	}

	public List<Hora> getHours() {
		return hours;
	}

	public void setSchedule(int pDay) {
		if(validDay(pDay)) {
			opened[pDay] = true;
		}
	}
	public void closeDay(int pDay) {
		if(validDay(pDay)) {
			opened[pDay] = false;
		}
	}
	private boolean validDay(int pDay) {
		if(pDay >= 0 && pDay <= 6) {
			return true;
		}
		return false;
	}
	public static void setCount(int count) {
		ids = count;
	}
	public String toString(){
		String msg = "Horario ID: " + id + " \n";
		for(int i = 0; i < 7;i++){
			switch(i){
			case 0:	msg += " Domingo: ";
					break;
			case 1:	msg += " Lunes: ";
					break;
			case 2:	msg += " Martes: ";
					break;
			case 3:	msg += " Miercoles: ";
					break;
			case 4:	msg += " Jueves: ";
					break;
			case 5:	msg += " Viernes: ";
					break;
			case 6:	msg += " Sabado: ";
					break;
			}
			if(opened[i]){
				msg += hours.get(i).toString() + "\n";
			} else {
				msg += " Cerrado.\n";
			}
		}
		return msg;
	}
}
