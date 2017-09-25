package app;
import java.io.IOException;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import org.jfree.data.general.DefaultPieDataset;

import datos.*;
import filemanager.Filemanager;

/**
 * Administra y almacena todos las reservaciones.
 * @author Kenneth, Caleb, Lery
 *
 */
public class Reservaciones {
	static List<Reserva> reservations = new ArrayList<Reserva>();
	
	
	/**
	 * Verifica una reserva a ser agregada, retorna como String el resultado.
	 * @param pStudent - Estudiante que realiza la reserva.
	 * @param pRoom - Sala a reservar.
	 * @param pDate - Fecha de la reserva.
	 * @param pHour - Hora de la reserva.
	 * @param pDetail - Detalle de la reserva.
	 * @param pPeople - Cantidad de personas.
	 * @return Resultado.
	 */
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
	/**
	 * Retorna una reserva según el índice en el que se ubica.
	 * @param index - Índice
	 * @return Reserva.
	 */
	static Reserva getReservation(int index) {
		try {
			return reservations.get(index);
		} catch (Exception e) {
			return null;
		}
		
	}
	/**
	 * Retorna como String la información de una reserva según su ID.
	 * @param id - Id de la reserva.
	 * @return Info de la reservación.
	 */
	static String getReservation(String id) {
		for(int i = 0; i < reservations.size();i++) {
			if(id.equals("" + reservations.get(i).getReserveID())) {
				return reservations.get(i).toString();
			}
		}
		return null;
	}
	/**
	 * Retorna como String TODAS las reservas realizadas por un estudiante en específico según su carnet.
	 * @param pID - Carnet del estudiante.
	 * @return Reservas realizadas por el estudiante como un String.
	 */
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
	/**
	 * Retorna la última reserva.
	 * @return Info de la última reserva.
	 */
	static String getLastReservationInfo() {
		return getReservation(reservations.size() - 1).toString();
	}
	/**
	 * Retorna todas las reservas como un String[].
	 * @return String[] con la lista de reservaciones.
	 */
	static String[] getReservationsList() {
		String[] roomList = new String[reservations.size()];
		for(int i = 0; i < reservations.size();i++) {
			roomList[i] = "" + reservations.get(i).getReserveID();
		}
		return roomList;
	}
	
	/**
	 * Retorna un módelo estadístico para ser mostrado en la interfaz.
	 * @return DefaultPieDataset
	 */
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
				
				if(i + 1 == tmptop.size()) {
					tmptop.add(top.get(i2));
					break;
					
				} else if(tmptop.get(i).getValue() < top.get(i2).getValue()) {
					tmptop.add(i, top.get(i2));
					break;
				}
			}
			
			
		}
		
		DefaultPieDataset data = new DefaultPieDataset();
		
		for(int i = 0; i < tmptop.size() && i < 5;i++) {
			data.setValue(tmptop.get(i).getName(), tmptop.get(i).getValue());
		}
		
		return data;
	}
	/**
	 * Retorna todas las reservas de una Sala según su ID.
	 * @param pID - ID de la sala.
	 * @return Info de la reservación.
	 */
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
	/**
	 * Retorna la cantidad de reservas.
	 * @return Cantidad de reservas.
	 */
	static int quantity() {
		return reservations.size();
	}
	
	/**
	 * Carga toda la información de las reservas.
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	static void load() throws ClassNotFoundException, IOException {
		try {
			reservations = (ArrayList<Reserva>) Filemanager.load("Reservaciones.xml");
			Reserva.setCount(reservations.size() - 1);
		} catch(Exception e) {
			reservations = new ArrayList<Reserva>();
		}
	}
	/**
	 * Guarda toda la información de las reservas.
	 */
	static void save() {
		Filemanager.save(reservations, "Reservaciones.xml");
	}
}
