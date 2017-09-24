package app;

import java.util.ArrayList;
import java.util.List;

import filemanager.Filemanager;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import datos.Estudiante;

import org.w3c.dom.Node;
import org.w3c.dom.Element;



class Estudiantes {
	public final static int NAME = 0;
	public final static int CAREER = 1;
	public final static int EMAIL = 2;
	public final static int IDNUMBER = 3;
	public final static int INCIDENTS = 4;
	public final static int PHONENUMBER = 5;
	public final static int SCORE = 6;
	public final static int WEEKRESERVATIONS = 7;
	
	static List<Estudiante> students = new ArrayList<Estudiante>();
	
	static String addStudent(String pName, String pIdNumber, String pCareer, String pEmail, String pPhoneNumber) {
		if(verifyStudentID(pIdNumber)) {
			students.add(new Estudiante(pName, pIdNumber, pCareer, pEmail, 100, pPhoneNumber));
			return "Se agregó el estudiante.";
		}
		
		return "Número de carnet no válido.";
	}
	
	public static boolean verifyStudentID(String pIdNumber) {
		for(int i = 0;i < students.size();i++) {
			if(students.get(i).getIdNumber().equals(pIdNumber)) {
				return false;
			}
		}
		return true;
	}
	
	public static String getStudentInfo(String pId,int selection) {
		for(int i = 0;i < students.size();i++) {
			if(students.get(i).getIdNumber().equals(pId)) {
				switch(selection) {
				case NAME: return students.get(i).getName();
				case CAREER: return students.get(i).getCareer();
				case EMAIL: return students.get(i).getEmail();
				case PHONENUMBER: return students.get(i).getPhoneNumber();
				case SCORE: return "" + students.get(i).getScore();
				}
				
			}
		}
		return "";
	}
	
	public static Estudiante getStudent(String pId) {
		for(int i = 0;i < students.size();i++) {
			if(students.get(i).getIdNumber().equals(pId)) {
				return students.get(i);
			}
		}
		return null;
	}
	
	public static void resetWeekReservations() {
		for(Estudiante student: students) {
			student.resetWeekReservations();
		}
	}
	

	public static String consultStudent(String id) {
		for(int i = 0;i < students.size();i++) {
			if(students.get(i).getIdNumber().equals(id)) {
				return students.get(i).showInfo();
			}
		}
		
		return "No hay ningún estudiante registrado con ese carnet.";
	}
	
	public static void printAll() {
		for(int i = 0;i < students.size();i++) {
			System.out.println(students.get(i).toString());
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void load() throws ClassNotFoundException, IOException {
		students = (List<Estudiante>) Filemanager.load("EstudiantesDB.db");
	}
	
	public static void save() {
		Filemanager.save(students, "EstudiantesDB.db");
	}
	
	
}
