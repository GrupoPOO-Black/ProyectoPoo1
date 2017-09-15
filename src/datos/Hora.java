package datos;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Hora {
	private Date openTime = new Date();
	private Date closeTime = new Date();
	
	
	public Hora(){
		this.openTime.setHours(7); 
		this.openTime.setMinutes(30); 
		this.closeTime.setHours(19); 
		this.closeTime.setMinutes(30);
	}
	
	public Hora(Date pOpenTime,Date pCloseTime){
		this.openTime = pOpenTime;
		this.closeTime = pCloseTime;
	}
	
	
	
	public boolean compareHours(Hora pHour) {
		/*
		 * Se establece un formato de hora tipo HHMM
		 * Siendo un entero el cual dos cifras menos significativas sean los minutos y el resto las horas
		 */
		int opentime1 = (openTime.getHours() * 100) + openTime.getMinutes();
		int opentime2 = (pHour.getOpenTime().getHours() * 100) + pHour.getOpenTime().getMinutes();
		
		int closetime1 = (closeTime.getHours() * 100) + closeTime.getMinutes();
		int closetime2 = (pHour.getCloseTime().getHours() * 100) + pHour.getCloseTime().getMinutes();
		
		/*
		 * Se verifica que las horas no choquen
		 */
		if(opentime1 < opentime2 && closetime1 > opentime2) {
			return true;
		}
		
		if(opentime1 < closetime2 && closetime1 > closetime2) {
			return true;
		}
		/*
		 * Si no chocan retorna falso
		 */
		return false;
	}
	
	public boolean validHour(Hora pHour) {
		
		int opentime1 = (openTime.getHours() * 100) + openTime.getMinutes();
		int opentime2 = (pHour.getOpenTime().getHours() * 100) + pHour.getOpenTime().getMinutes();
		
		int closetime1 = (closeTime.getHours() * 100) + closeTime.getMinutes();
		int closetime2 = (pHour.getCloseTime().getHours() * 100) + pHour.getCloseTime().getMinutes();
		
		if(opentime2 >= opentime1 && closetime2 <= closetime1) {
			return true;
		}
		
		return false;
	}
	
	
	
	public Date getOpenTime() {
		return openTime;
	}

	public Date getCloseTime() {
		return closeTime;
	}

	@Override
	public String toString() {
	    SimpleDateFormat simpDate = new SimpleDateFormat("HH:mm");
		return "De " + simpDate.format(openTime) + " a " + simpDate.format(closeTime);
	}
}
