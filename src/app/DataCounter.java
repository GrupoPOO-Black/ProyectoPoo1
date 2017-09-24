package app;

public class DataCounter {
	public String name = "";
	public int value = 0;
	
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
