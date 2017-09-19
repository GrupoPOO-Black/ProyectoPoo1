package app;

import java.util.ArrayList;
import java.util.List;
import datos.Estudiante;
import filemanager.Filemanager;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;



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
		Filemanager.save(students, "EstudiantesDB.db");
	}
	
	@SuppressWarnings("unchecked")
	public static void load() throws ClassNotFoundException, IOException {
		students = (List<Estudiante>) Filemanager.load("EstudiantesDB.db");
	}
	
	public static void importStudents() {
		try {
			System.out.println("Importando estudiantes...");
			
			File inputFile = new File("EstudiantesDB.xml");
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("student");
			
			
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					try {
						Element eElement = (Element) nNode;
						eElement.getElementsByTagName("name").item(0).getTextContent();						   
						if(verifyStudentID(eElement.getAttribute("id"))) {
							System.out.println("Se agrega estudiante. " + eElement.getAttribute("id"));
							students.add(new Estudiante(
									eElement.getElementsByTagName("name").item(0).getTextContent(),
									eElement.getAttribute("id"), 
									eElement.getElementsByTagName("career").item(0).getTextContent(), 
									eElement.getElementsByTagName("email").item(0).getTextContent(), 
									Integer.parseInt(eElement.getElementsByTagName("score").item(0).getTextContent()), 
									eElement.getElementsByTagName("phone").item(0).getTextContent(), 
									Integer.parseInt(eElement.getElementsByTagName("wReservations").item(0).getTextContent())));
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					   }
				}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void printAll() {
		for(int i = 0;i < students.size();i++) {
			System.out.println(students.get(i).toString());
		}
	}
}
