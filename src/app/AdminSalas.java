package app;
import mailing.Mail;
import java.util.List;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.io.IOException;
import java.util.ArrayList;

import datos.*;


@SuppressWarnings("unchecked")
/**
 * 
 * 
 * 
 * @author keneth
 *
 */
public class AdminSalas {
	
	public static void main(String[] args) throws Exception {
		//loadData();
		UI.init();
		/*
		Horario horario = new Horario();
		horario.setSchedule(1);
		horario.setSchedule(2);
		horario.setSchedule(3);
		horario.setSchedule(4);
		horario.setSchedule(5);
		horario.setSchedule(6);
		Horarios.addSchedule(horario);
		*/
		//Inicilization
		
		
	    //--
		//Estudiantes.addStudent("Kenneth Herrera Valverde", "2016094891", "Ing. Computación", "kfhv.24@gmail.com", "89657436");
	}
	
	static void importData() {
		
	}
	
	static void saveData(){
		Estudiantes.save();
		Horarios.save();
		Salas.save();
		Reservaciones.save();
	}
	
	static void loadData() throws ClassNotFoundException, IOException {
		Estudiantes.load();
		Salas.load();
		Horarios.load();
		Reservaciones.load();
		
	}
	
	static void verifyData() {
		
	}
	
	
	
	
	
	
}
