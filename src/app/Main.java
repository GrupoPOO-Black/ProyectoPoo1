package app;
import mailing.Mail;
import java.util.List;
import java.util.ArrayList;

import datos.*;
import xml.*;

@SuppressWarnings("unchecked")
public class Main {

	

	/**
	 * 
	 * 
	 * Launch the application.
	 * @throws Exception 
	 */
	
	
	public static void main(String[] args) throws Exception {
		
		List<Estudiante> sList = new ArrayList<Estudiante>();
		
		
		sList.add(new Estudiante("Kenneth","2016","Ing. Computacion","kfhv.24@gmail.com",100,"89657436"));

		XmlParser.write(sList, "Estudiantes.xml");
		
		
		
		
		
		List<Estudiante> listFromFile = (List<Estudiante>) XmlParser.read("Estudiantes.xml");
	    
	    
	    
	    System.out.println(listFromFile.get(0).toString());
	    
		
	}

}
