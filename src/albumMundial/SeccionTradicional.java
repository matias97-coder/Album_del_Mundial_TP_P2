package albumMundial;

import java.util.ArrayList;

public class SeccionTradicional {

	private int figuritaPegadas;
	private String pais;
	private ArrayList<String> seccion;
	
	public SeccionTradicional(String pais) {
		this.pais=pais;
		seccion= cargarSeccion();
		figuritaPegadas=0;
	}
	
	public String obtenerPaisSeccion() {
		return pais;
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

	/* true= hay fig pegada
	/false= es que la seccion esta en null, 
	 * seccion.get(fig.obtenerPosicion())=null;
	*/
	public boolean tieneFiguritaPegadaSeccion (Figurita fig) {
		return  seccion.get(fig.obtenerPosicion()) != null;
	}
	
	//si da true, entonces no pude pegar la figurita
	// agrega en el nombre del jugador en la seccion 
	public void pegarFiguritaEnLaSeccion(Figurita fig) {
		
			/*
			 * index= codFig 0 a 11 , String= nombre Jugador
			 * seccion.add(index, String)
			*/
			if ((figuritaPegadas<12) && (tieneFiguritaPegadaSeccion (fig)==false)) {
			seccion.add(fig.obtenerPosicion(), fig.obtenerNombreJugador()); 
			figuritaPegadas++; // este contador solo llega hasta 12
			}
	}
	

	public int cantSeccionesCreadas() {
		return seccion.size();
	}
	

}