package app;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import datos.*;
public class Reservaciones {
	static List<Reserva> reservations = new ArrayList<Reserva>();
	
	static String reserveRoom(Estudiante pStudent,Sala pRoom,GregorianCalendar pDate,Hora pHour,String pDetail, int pPeople) {
		
		if(!pRoom.getSchedule().getOpened()[pDate.get(GregorianCalendar.DAY_OF_WEEK) - 1]) {
			System.out.println(pDate.get(GregorianCalendar.DAY_OF_WEEK) + "Dia no disponible.");
			return "La sala no está disponible el día seleccionado.";
		}
		
		if(pRoom.getStatus() != Sala.ACTIVE) {
			return "La sala no está disponible.";
		}
		
		if(!pRoom.getSchedule().getHours().get(pDate.get(GregorianCalendar.DAY_OF_WEEK) -  1).validHour(pHour)) {
			return "La sala no está disponible a esa hora.";
		}
		
		if(pStudent.getScore() < 70) {
			return "El estudiante no tiene suficientes puntos para reservar una sala.";
		}
		
		if(pRoom.getCapacity() < pPeople) {
			return "La capacidad máxima de la sala es de " + pRoom.getCapacity() + ".";
		}
		
		if(pStudent.getWeekReservations() > 2) {
			return "El estudiante ya hizo 3 reservas esta semana.";
		}
		
		for(int i = 0;i < reservations.size();i++) {
			if(reservations.get(i).getRoom().getId().equals(pRoom.getId())) {
				if(reservations.get(i).getDate().get(GregorianCalendar.DAY_OF_MONTH) == pDate.get(GregorianCalendar.DAY_OF_MONTH)) {
					if(reservations.get(i).getDate().get(GregorianCalendar.MONTH) == pDate.get(GregorianCalendar.MONTH)) {
						if(reservations.get(i).getDate().get(GregorianCalendar.YEAR) == pDate.get(GregorianCalendar.YEAR)) {
							if(reservations.get(i).getHour().compareHours(pHour)){
								return "La sala está reservada a la hora indicada.";
							}
						}
					}
				}
			}
			
		}
		
		pStudent.addWeekReservations();
		
		reservations.add(new Reserva(pStudent, pRoom, pDate, pHour, pDetail,pPeople));
		return "Sala reservada.";
	}
	
	static Reserva getReservation(int index) {
		try {
			return reservations.get(index);
		} catch (Exception e) {
			return null;
		}
		
	}
	
	static String getReservation(String id) {
		for(int i = 0; i < reservations.size();i++) {
			if(id.equals("" + reservations.get(i).getReserveID())) {
				return reservations.get(i).toString();
			}
		}
		return null;
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
				return "Este estudiante no ha reservado ninguna sala.";
			}
			return msg;
		} else {
			return "Este estudiante no ha reservado ninguna sala.";
		}
		
	}
	static String getLastReservationInfo() {
		return getReservation(reservations.size() - 1).toString();
	}
	
	static String[] getReservationsList() {
		String[] roomList = new String[reservations.size()];
		for(int i = 0; i < reservations.size();i++) {
			roomList[i] = "" + reservations.get(i).getReserveID();
		}
		return roomList;
	}
	
	static String getStringFromRmID(String pID) { 
		if(quantity() > 0) {
			boolean rflag = false;
			String msg = "Reservas de la sala: " +  pID + "\n";
			for(int i = 0; i < quantity();i++) {
				if(reservations.get(i).getRoom().getId().equals(pID)) {
					msg += "\n" + reservations.get(i).toString();
					rflag = true;
				}
			}
			if(!rflag) {
				return "Sala no tiene reservas";
			}
			return msg;
		} else {
			return "Sala no tiene reservas";
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
