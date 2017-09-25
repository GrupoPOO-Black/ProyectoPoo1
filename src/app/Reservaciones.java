package app;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.jfree.data.general.DefaultPieDataset;

import datos.*;
import filemanager.Filemanager;
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
								if(!reservations.get(i).isCanceled()) {
									return "La sala está reservada a la hora indicada.";
								}
								
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
	
	static DefaultPieDataset getTopCareers() {
		ArrayList<DataCounter> top = new ArrayList<DataCounter>();
		
		for(int i = 1; i < reservations.size();i++){
			if(top.isEmpty()) {
				top.add(new DataCounter(reservations.get(i).getStudent().getCareer(),1));
			} else
			for(int i2 = 0; i2 < top.size();i2++) {
				if(top.get(i2).getName().equals(reservations.get(i).getStudent().getCareer())) {
					top.get(i2).incValue();
					break;
				} else {
					if(i2 + 1 == top.size()) {
						top.add(new DataCounter(reservations.get(i).getStudent().getCareer(),1));
					}
				}
			}
		}
		ArrayList<DataCounter> tmptop = new ArrayList<DataCounter>();
		
		for(int i2 = 0; i2 < top.size();i2++) {
			if(tmptop.isEmpty()) {
				tmptop.add(top.get(i2));
			} else
			for(int i = 0; i < tmptop.size();i++) {
				System.out.println("Ciclo!!!");
				if(tmptop.get(i).getValue() < top.get(i2).getValue()) {
					tmptop.add(i, top.get(i2));
					break;
				} else {
					if(i + 1 == tmptop.size()) {
						tmptop.add(top.get(i2));
					}
				}
			}
		}
		
		DefaultPieDataset data = new DefaultPieDataset();
		
		for(int i = 0; i < tmptop.size() && i < 5;i++) {
			data.setValue(tmptop.get(i).getName(), tmptop.get(i).getValue());
		}
		
		return data;
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
	
	@SuppressWarnings("unchecked")
	static void load() throws ClassNotFoundException, IOException {
		reservations = (ArrayList<Reserva>) Filemanager.load("Reservaciones.xml");
	}
	
	static void save() {
		Filemanager.save(reservations, "Reservaciones.xml");
	}
}
