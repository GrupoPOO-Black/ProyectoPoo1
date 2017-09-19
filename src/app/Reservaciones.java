package app;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import datos.*;
public class Reservaciones {
	static List<Reserva> reservations = new ArrayList<Reserva>();
	
	static boolean reserveRoom(Estudiante pStudent,Sala pRoom,GregorianCalendar pDate,Hora pHour,String pDetail, int pPeople) {
		
		if(!pRoom.getSchedule().getOpened()[pDate.get(GregorianCalendar.DAY_OF_WEEK) - 1]) {
			System.out.println(pDate.get(GregorianCalendar.DAY_OF_WEEK) + "Dia no disponible.");
			return false;
		}
		
		if(!pRoom.getStatus()) {
			return false;
		}
		
		if(!pRoom.getSchedule().getHours().get(pDate.get(GregorianCalendar.DAY_OF_WEEK)).validHour(pHour)) {
			return false;
		}
		
		if(pStudent.getScore() < 70) {
			return false;
		}
		
		if(pRoom.getCapacity() < pPeople) {
			return false;
		}
		
		if(pStudent.getWeekReservations() > 2) {
			return false;
		}
		
		for(int i = 0;i < reservations.size();i++) {
			if(reservations.get(i).getDate().get(GregorianCalendar.DAY_OF_MONTH) == pDate.get(GregorianCalendar.DAY_OF_MONTH)) {
				if(reservations.get(i).getDate().get(GregorianCalendar.MONTH) == pDate.get(GregorianCalendar.MONTH)) {
					if(reservations.get(i).getDate().get(GregorianCalendar.YEAR) == pDate.get(GregorianCalendar.YEAR)) {
						if(reservations.get(i).getHour().compareHours(pHour)){
							return false;
						}
					}
				}
			}
		}
		
		pStudent.addWeekReservations();
		
		reservations.add(new Reserva(pStudent, pRoom, pDate, pHour, pDetail,pPeople));
		
		return true;
	}
	
	static void save() {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static Reserva getReservation(int index) {
		try {
			return reservations.get(index);
		} catch (Exception e) {
			return null;
		}
		
	}
	
	static String getStringFromStID(String pID) {
		if(quantity() > 0) {
			boolean rflag = false;
			String msg = "Reservas del estudiante: " +  pID + "\n";
			for(int i = 0; i < quantity();i++) {
				if(reservations.get(i).getStudent().getIdNumber().equals(pID)) {
					msg += reservations.get(i).toString();
					rflag = true;
				}
			}
			if(!rflag) {
				return "Este estudiante no ha reservado ninguna sala";
			}
			return msg;
		} else {
			return "Este estudiante no ha reservado ninguna sala";
		}
		
	}
	
	static int quantity() {
		return reservations.size();
	}
	
	static void load() {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
