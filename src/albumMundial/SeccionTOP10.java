package albumMundial;

import java.util.ArrayList;

public class SeccionTOP10 {
	private String sede;
	private ArrayList<String> seccionTOP;
	
	public SeccionTOP10(String sede) {
		this.sede=sede;
		seccionTOP= cargarSeccion();
	}

	public String obtenerSeccionSedeMundial() {
		return sede;
	}
	
	
	private ArrayList<String> cargarSeccion() {
		ArrayList<String> seccionesTOP10 = new ArrayList<String> ();
		for (int i=0;i<2;i++) {
			seccionesTOP10.add(null);
		}
		
		return seccionesTOP10;
	}
	
	/*
	// devuelve el nombre del jugador pegado en el la seccion
	public String obtenerFiguritaEnSeccionTOP10(Figurita fig) {
		return seccionTOP.get(fig.obtenerPosicion());
	}
	*/
	
	
	// true= hay fig pegada
	// false= es que la seccion esta en null, 
	public boolean tieneFiguritaPegadaSeccionTOP10 (Figurita fig) {
		return seccionTOP.get(fig.obtenerPosicion())!= null;
	}
	

	
	public void pegarFiguritaEnLaSeccionTOP(Figurita fig) {
		if ( tieneFiguritaPegadaSeccionTOP10(fig) == false) {
			seccionTOP.add(fig.obtenerCodigoFigurita(), fig.obtenerNombreJugador()); // seccion.add(index, String)
		}
	}
	
	/* Me devuelve una lista con los "numeros" de las figuritas 
	 * que me faltan para completar la seccion
	*/
	
	public ArrayList<Integer> figuritasTOP10QueFaltanPegar(){
		ArrayList<Integer> figuritasFaltantes = new ArrayList<Integer>();
		
		for (int i=0;i<cargarSeccion().size();i++) {
			if (seccionTOP.get(i).equals(null))
				figuritasFaltantes.add(i);
		}
		
		return figuritasFaltantes;
	}

}
