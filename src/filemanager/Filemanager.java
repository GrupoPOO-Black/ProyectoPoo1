package filemanager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 * Administrador de archivos.
 * @author Kenneth, Caleb, Lery
 *
 */
public class Filemanager {
	/**
	 * Guarda el objeto en la ruta especificada.
	 * @param pOb - Objecto.
	 * @param fileName - Ruta.
	 */
	public static void save(Object pOb,String fileName) {
		try (ObjectOutputStream oos =
				new ObjectOutputStream(new FileOutputStream(fileName))) {

			oos.writeObject(pOb);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	/**
	 * Retorna un objeto desde la ruta especificada.
	 * @param fileName - Ruta.
	 * @return Objeto
	 */
	public static Object load(String fileName) {
		FileInputStream fin;
		try {
			fin = new FileInputStream (fileName);
			ObjectInputStream ois = new ObjectInputStream(fin);
			Object tmp = ois.readObject(); 
			fin.close();
			return tmp;
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
}
