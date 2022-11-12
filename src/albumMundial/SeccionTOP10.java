package albumMundial;

import java.util.ArrayList;

public class SeccionTOP10 {
	private String sede;
	private String [] seccionTOP;
	
	public SeccionTOP10(String sede) {
		this.sede=sede;
		seccionTOP= new String[2];
	}

	public String obtenerSeccionSedeMundial() {
		return sede;
	}
	
	// true= hay fig pegada
	// false= es que la seccion esta en null, 
	public boolean tieneFiguritaPegadaSeccionTOP10 (Figurita fig) {
		return seccionTOP[fig.obtenerPosicion()]!= null;
	}
	

	
	public void pegarFiguritaEnLaSeccionTOP(Figurita fig) {
			if (tieneFiguritaPegadaSeccionTOP10 (fig)==false) {
				seccionTOP[fig.obtenerPosicion()] = fig.obtenerNombreJugador();// seccion.add(index, String)
			}
	}
	

}
