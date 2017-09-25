package app;
import java.io.IOException;

/**
 * 
 * @author Kenneth, Caleb, Lery
 *
 */
public class AdminSalas {
	/**
	 * Método Main, inicialización del programa.
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		
		loadData();
		UI.init();
		
		
	}
	/**
	 * Guarda todos los datos de la aplicación
	 */
	static void saveData(){
		Estudiantes.save();
		Horarios.save();
		Salas.save();
		Reservaciones.save();
	}
	/**
	 * Lee todos los datos de la aplicación
	 */
	static void loadData() throws ClassNotFoundException, IOException {
		Estudiantes.load();
		Salas.load();
		Horarios.load();
		Reservaciones.load();
		
	}
}
