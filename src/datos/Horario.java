package datos;
import java.util.*;
/**
 * Horario de una Sala
 * @author Kenneth
 *
 */
public class Horario {
	
	private boolean[] opened = new boolean[7];
	private List<Hora> hours = new ArrayList<Hora>();
	
	
	public Horario(){
		for(int i = 0;i < 8;i++) {
			opened[i] = false;
			hours.add(new Hora());
		}
	}
	/**
	 * 
	 * Establece la hora de disponibilidad de un dia especifico
	 * 
	 * @param pDay
	 * @param pHour
	 */
	public void setHorario(int pDay, Hora pHour) {
		if(pDay >= 0 && pDay <= 7) {
			opened[pDay] = true;
			hours.set(pDay, pHour);
		}
	}
	/**
	 * Se quita la disponibilidad de un dia especifico
	 * @param pDay
	 */
	
	public void closeDay(int pDay) {
		if(pDay >= 0 && pDay <= 7) {
			opened[pDay] = false;
		}
	}
	
	public String toString(){
		String msg = "Horarios: \n";
		for(int i = 0; i < 7;i++){
			if(opened[i]){
				switch(i){
				case 0:	msg += "	Domingo: ";
						break;
				case 1:	msg += "	Lunes: ";
						break;
				case 2:	msg += "	Martes: ";
						break;
				case 3:	msg += "	Miercoles: ";
						break;
				case 4:	msg += "	Jueves: ";
						break;
				case 5:	msg += "	Viernes: ";
						break;
				case 6:	msg += "	Sabado: ";
						break;
				}
				msg += hours.get(i).toString() + "\n";
			}
		}
		
		return msg;
	}
}
