package app;

import java.util.ArrayList;
import java.util.List;

import datos.Estudiante;
import xml.XmlParser;

class Estudiantes {
	static List<Estudiante> students = new ArrayList<Estudiante>();
	
	
	static boolean addStudent(String pName, String pIdNumber, String pCareer, String pEmail, String pPhoneNumber) {
		if(verifyStudentID(pIdNumber)) {
			students.add(new Estudiante(pName, pIdNumber, pCareer, pEmail, 100, pPhoneNumber));
			return true;
		}
		
		return false;
	}
	
	private static boolean verifyStudentID(String pIdNumber) {
		for(int i = 0;i < students.size();i++) {
			if(students.get(i).getIdNumber().equals(pIdNumber)) {
				return false;
			}
		}
		return true;
	}
	
	public static void save() {
		try {
			XmlParser.write(students, "EstudiantesDB.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void load() {
		try {
			students = (ArrayList<Estudiante>) XmlParser.read("EstudiantesDB.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
