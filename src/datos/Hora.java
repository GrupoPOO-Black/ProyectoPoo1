package datos;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Hora {
	private Date openTime;
	private Date closeTime;
	private boolean open;
	
	
	public Hora(){
		this.openTime.setHours(7); this.openTime.setMinutes(30); 
		this.closeTime.setHours(19); this.closeTime.setMinutes(30);
	}
	
	public Hora(Date pOpenTime,Date pCloseTime){
		this.openTime = pOpenTime;
		this.closeTime = pCloseTime;
	}
	
	@Override
	public String toString() {
	    SimpleDateFormat simpDate = new SimpleDateFormat("HH:mm");
		return "Abierto desde " + simpDate.format(openTime) + " hasta " + simpDate.format(closeTime);
	}
}
