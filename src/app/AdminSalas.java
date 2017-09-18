package app;
import mailing.Mail;
import java.util.List;

import org.joda.time.DateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.ArrayList;

import datos.*;
import xml.*;


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
		
		//Inicilization
		loadData();
		
		
		
		Horario schedule = new Horario();
		schedule.setSchedule(Horario.MONDAY, new Hora(6,50,8,45));
		
		
		//Codigo de prueba
		GregorianCalendar date = new GregorianCalendar(2017,8,7);
		Hora hour = new Hora();
		
		Estudiantes.students.add(new Estudiante("Kenneth","2016","Ing. Computacion","kfhv.24@gmail.com",100,"89657436"));
		Sala sala = new Sala(5,schedule);
		
	    Reserva reserva = new Reserva(Estudiantes.students.get(0),sala, date,hour,"Exposicion");
	
	    System.out.println(reserva.toString());
	    
	    
	    //--
	    
	    
	    saveData();
	    
	}

	static void saveData() {
		Estudiantes.save();
		Horarios.save();
		
	}
	
	static void loadData() {
		
		
		
	}
	
	static void verifyData() {
		
	}
	
	
	
	
	
	
}
