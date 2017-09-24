package datos;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

public class Hora implements Serializable {
	private Date openTime = new Date();
	private Date closeTime = new Date();
	private boolean invalidTime = false;
	
	@SuppressWarnings("deprecation")
	public Hora(){
		this.openTime.setHours(7); 
		this.openTime.setMinutes(30); 
		this.closeTime.setHours(19); 
		this.closeTime.setMinutes(30);
	}

@SuppressWarnings("deprecation")
public Hora(int pOpentimeH, int pOpentimeM,int pClosetimeH, int pClosetimeM){
	this.openTime.setHours(pOpentimeH); 
	this.openTime.setMinutes(pOpentimeM); 
	this.closeTime.setHours(pClosetimeH); 
	this.closeTime.setMinutes(pClosetimeM);
	
	if(((getOpenTime().getHours() * 100) + getOpenTime().getMinutes()) >= (getCloseTime().getHours() * 100) + getCloseTime().getMinutes()) {
		this.openTime.setHours(7); 
		this.openTime.setMinutes(30); 
		this.closeTime.setHours(19); 
		this.closeTime.setMinutes(30);
		
		invalidTime = true;
	}
}
	
	
	
	@SuppressWarnings("deprecation")
	public boolean compareHours(Hora pHour) {
		
		int opentime1 = (openTime.getHours() * 100) + openTime.getMinutes();
		int opentime2 = (pHour.getOpenTime().getHours() * 100) + pHour.getOpenTime().getMinutes();
		int closetime1 = (closeTime.getHours() * 100) + closeTime.getMinutes();
		int closetime2 = (pHour.getCloseTime().getHours() * 100) + pHour.getCloseTime().getMinutes();
	
		if(opentime1 == opentime2 && closetime1 == closetime2) {
			return true;
		}
		
		if(opentime1 < opentime2 && opentime2 < closetime1) {
			return true;
		}
		
		if(opentime1 < closetime2 && closetime2 < closetime1) {
			return true;
		}
		
		if(opentime2 < opentime1 && opentime1 < closetime2) {
			return true;
		}
		
		if(opentime2 < closetime1 && closetime1 < closetime2) {
			return true;
		}
		
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
	
	
	
	public boolean isInvalidTime() {
		return invalidTime;
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
