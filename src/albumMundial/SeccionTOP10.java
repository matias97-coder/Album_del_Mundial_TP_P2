package albumMundial;

import java.util.ArrayList;

public class SeccionTOP10 {

	private ArrayList<String> seccionTOP;
	
	public SeccionTOP10() {
		seccionTOP= cargarSeccion();
	}

	
	private ArrayList<String> cargarSeccion() {
		ArrayList<String> seccionesTOP10 = new ArrayList<String> ();
		for (int i=0;i<2;i++) {
			seccionesTOP10.add(null);
		}
		
		return seccionesTOP10;
	}
	
	// devuelve el nombre del jugador pegado en el la seccion
	public String obtenerFiguritaEnSeccionTOP10(Figurita fig) {
		return seccionTOP.get(fig.obtenerCodigoFigurita());
	}
	
	
	public boolean tieneFiguritaPegadaSeccionTOP10 (Figurita fig) {
		return ! obtenerFiguritaEnSeccionTOP10(fig).equals(null);
	}
	

	
	public void pegarFiguritaEnLaSeccion(Figurita fig) {
		if (! tieneFiguritaPegadaSeccionTOP10(fig) && fig instanceof FiguritaTOP10) {
			seccionTOP.add(fig.obtenerCodigoFigurita(), fig.obtenerNombreJugador()); // seccion.add(index, String)
		}
	}
	
}
