package app;
import mailing.Mail;
import java.util.List;

import org.joda.time.DateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
		
		//Inicilization
		loadData();
		
		
		
		
		
		Horario schedule = new Horario();
		schedule.setSchedule(Horario.MONDAY, new Hora(6,50,20,45));
		
		Salas.addRoom(5,true,schedule);
		Salas.save();
		
		
		Salas.load();
		
		System.out.println(Salas.getRoom(0).toString());
		
		//Codigo de prueba
		
		GregorianCalendar date = new GregorianCalendar(2017,8,18);
		
		Hora hour = new Hora();
		
		Estudiantes.students.add(new Estudiante("Kenneth","2016094891","Ing. Computacion","kfhv.24@gmail.com",100,"89657436"));
		Estudiantes.students.add(new Estudiante("Jose","2016094890","Ing. Forestal","asdr.24@gmail.com",100,"12345134"));
		
		Estudiantes.students.get(0).addWeekReservations();
		
		
		
	    System.out.println(Reservaciones.reserveRoom(Estudiantes.students.get(0),Salas.getRoom(0), date,hour,"Exposicion",1));

	    
	    //--
	    
	    
	    
	    
	    saveData();
	    
	   
	    System.out.println("END.");
	}

	static void saveData(){
		//Estudiantes.save();
		//Horarios.save();
		//Salas.save();
		//Reservaciones.save();
	}
	
	static void loadData() {
		Estudiantes.load();
	}
	
	static void verifyData() {
		
	}
	
	
	
	
	
	
}
