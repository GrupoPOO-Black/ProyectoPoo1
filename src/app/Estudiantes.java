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


/**
 * 
 * Clase Estudiantes que guarda y administra los datos de cada Estudiante
 * 
 * @author Kenneth, Caleb, Lery
 *
 */
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
	
	
	/**
	 * Agrega un estudiante con un número de id válido
	 * 
	 * @param pName - Nombre del estudiante
	 * @param pIdNumber - Id del estuduante
	 * @param pCareer - Carrera del estudiante
	 * @param pEmail - Correo del estudiante
	 * @param pPhoneNumber - Número de teléfono del estudiante
	 * @return Retorna el resultado final
	 */
	static String addStudent(String pName, String pIdNumber, String pCareer, String pEmail, String pPhoneNumber) {
		if(verifyStudentID(pIdNumber)) {
			students.add(new Estudiante(pName, pIdNumber, pCareer, pEmail, 100, pPhoneNumber));
			return "Se agregó el estudiante.";
		}
		
		return "Número de carnet no válido.";
	}
	
	/**
	 * Verifica si un ID ya está siendo utilizado por algún estudiante
	 * @param pIdNumber - ID a verificar
	 * @return true si ya está siendo utilizado.
	 */
	public static boolean verifyStudentID(String pIdNumber) {
		for(int i = 0;i < students.size();i++) {
			if(students.get(i).getIdNumber().equals(pIdNumber)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 
	 * Retorna un dato en específico del estudiante según indique la selección
	 * @param pId - Carnet del estudiante
	 * @param selection - Que dato se mostrará
	 * @return Info del estudiante.
	 */
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
	/**
	 * Retorna un objeto de tipo estudiante con el ID correspondiente.
	 * @param pId - Carnet del estudiante
	 * @return Estudiante.
	 */
	public static Estudiante getStudent(String pId) {
		for(int i = 0;i < students.size();i++) {
			if(students.get(i).getIdNumber().equals(pId)) {
				return students.get(i);
			}
		}
		return null;
	}
	/**
	 * Reinicia el contador de reservaciones por semana.
	 */
	public static void resetWeekReservations() {
		for(Estudiante student: students) {
			student.resetWeekReservations();
		}
	}
	
	/**
	 * Retorna información apartir el carnet de un estudiante
	 * @param id - Carnet
	 * @return Info del estudiante.
	 */
	public static String consultStudent(String id) {
		for(int i = 0;i < students.size();i++) {
			if(students.get(i).getIdNumber().equals(id)) {
				return students.get(i).showInfo();
			}
		}
		
		return "No hay ningún estudiante registrado con ese carnet.";
	}
	
	/**
	 * Imprime en pantalla todos los estudiantes.
	 */
	public static void printAll() {
		for(int i = 0;i < students.size();i++) {
			System.out.println(students.get(i).toString());
		}
	}
	
	/**
	 * Carga la información sobre los estudiantes.
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public static void load() throws ClassNotFoundException, IOException {
		try {
			students = (List<Estudiante>) Filemanager.load("Estudiantes.xml");
			students.size();
		} catch (Exception e){
			students = new ArrayList<Estudiante>();
		}
		
	}
	/**
	 * Guarda toda la información de los estudiantes.
	 */
	public static void save() {
		Filemanager.save(students, "Estudiantes.xml");
	}
	
	
}
