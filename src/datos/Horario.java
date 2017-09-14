package datos;
import java.util.*;

public class Horario {
	private boolean[] opened = new boolean[7];
	
	private List<Date> open = new ArrayList<Date>();
	private List<Date> close = new ArrayList<Date>();
	
	
	public Horario(){
		
	}
	
	
	public String toString(){
		String msg = "Horarios: \n";
		for(int i = 0; i < 7;i++){
			if(opened[i]){
				switch(i){
					
				}
				
			}
		}
		
		return msg;
	}
}
