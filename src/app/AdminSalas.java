package app;
import mailing.Mail;
import java.util.List;

import org.joda.time.DateTime;
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
		Horario horario = new Horario();
		
		Horarios.addSchedule(horario);
		
		//Inicilization
		UI.init();
		
	    //--
		Estudiantes.addStudent("Beto", "123", "NADA", "k@f.c", "asdasd");
	}
	
	static void importData() {
		
	}
	
	static void saveData(){
		//Estudiantes.save();
		//Horarios.save();
		//Salas.save();
		//Reservaciones.save();
	}
	
	static void loadData() throws ClassNotFoundException, IOException {
		Estudiantes.load();
	}
	
	static void verifyData() {
		
	}
	
	
	
	
	
	
}
