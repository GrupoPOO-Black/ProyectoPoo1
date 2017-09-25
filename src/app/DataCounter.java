package app;

/**
 * Clase utilizada para las estadísticas
 * @author Kenneth, Caleb, Lery
 *
 */
public class DataCounter {
	public String name = "";
	public int value = 0;
	
	/**
	 * Constructor DataCounter
	 * @param name - Nombre
	 * @param value - Valor
	 */
	public DataCounter(String name,int value) {
		this.name = name;
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void incValue() {
		this.value++;
	}

	public String getName() {
		return name;
	}
	
	
}
