package filemanager;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Filemanager {
	public static void save(Object pOb,String fileName) {
		try (ObjectOutputStream oos =
				new ObjectOutputStream(new FileOutputStream(fileName))) {

			oos.writeObject(pOb);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static Object load(String fileName) throws IOException, ClassNotFoundException {
		FileInputStream fin= new FileInputStream (fileName);
		ObjectInputStream ois = new ObjectInputStream(fin);
		Object tmp = ois.readObject(); 
		fin.close();
		return tmp;
	}
}
