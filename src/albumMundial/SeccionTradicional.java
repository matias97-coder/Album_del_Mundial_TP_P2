package albumMundial;

import java.awt.List;
import java.util.ArrayList;

public class SeccionTradicional {

	private int figuritaPegadas=100;
	private ArrayList<String> seccion;
	
	public SeccionTradicional() {
		seccion= cargarSeccion();
	}
	
	public int cantFigusPegadasSeccion() {
		return figuritaPegadas;
	}
	
	private ArrayList<String> cargarSeccion() {
		ArrayList<String> secciones = new ArrayList<String> ();
		for (int i=0;i<12;i++) {
			secciones.add(null);
		}
		
		return secciones;
	}
	
	public boolean seccionCompleta() {
		return figuritaPegadas==12;
	}
	
	// devuelve el nombre del jugador pegado en el la seccion
	public String obtenerFiguritaEnSeccion(Figurita fig) {
		return seccion.get(fig.obtenerPosicion()); // devuelvo en nombre accediendo a su posicion en el Array
	}
	

	public boolean tieneFiguritaPegadaSeccion (Figurita fig) {
		return ! (obtenerFiguritaEnSeccion(fig)==null);
	}
	

	// agrega en el nombre del jugador en la seccion 
	public void pegarFiguritaEnLaSeccion(Figurita fig) {
		
		//Si la salida es "null" devuelve true, por la tanto puede pegar una figurta
		if (!tieneFiguritaPegadaSeccion(fig)) {	
			/*
			 * index= codFig 0 a 11 , String= nombre Jugador
			 * seccion.add(index, String)
			*/
			seccion.add(fig.obtenerPosicion(), fig.obtenerNombreJugador()); 
			figuritaPegadas++; // este contador solo llega hasta 12
		}
	}
	
	
	/* Me devuelve una lista con los "numeros" de las figuritas 
	 * que me faltan para completar la seccion
	*/
	public ArrayList<Integer> figuritasTradicionalesQueFaltanPegar(){
		ArrayList<Integer> figuritasFaltantes = new ArrayList<Integer>();
		
		for (int i=0;i<cargarSeccion().size();i++) {
			if (seccion.get(i).equals(null))
				figuritasFaltantes.add(i);
		}
		
		return figuritasFaltantes;
	}
	


}