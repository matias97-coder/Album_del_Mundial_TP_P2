package albumMundial;

import java.util.ArrayList;

public class SeccionTOP10 {
	private String sede;
	private ArrayList<String> seccionTop;
	private static final int tamanioSeccion=2;
	
	public SeccionTOP10(String sede) {
		this.sede=sede;
		seccionTop=cargarSeccionTOP();
	}

	public String obtenerSeccionSedeMundial() {
		return sede;
	}
	
	// true= hay fig pegada
	// false= es que la seccion esta en null, 
	
	public boolean tieneFiguritaPegadaSeccionTOP10 (Figurita fig) {
		return seccionTop.get(fig.obtenerPosicion())!=null;
	}
	

	
	public void pegarFiguritaEnLaSeccionTOP(Figurita fig) {
		seccionTop.set(fig.obtenerPosicion(), fig.obtenerNombreJugador());
	}
	
	private ArrayList<String> cargarSeccionTOP() {
		 ArrayList<String> seccion= new ArrayList<String>();
		 
		 for (int i=0;i<tamanioSeccion;i++) {
			 seccion.add(null);
		 }
		 
		 return seccion;
	}

}

