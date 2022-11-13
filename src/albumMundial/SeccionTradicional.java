package albumMundial;

public class SeccionTradicional {

	private int figuritaPegadas;
	private String pais;
	private String [] seccion;
	
	public SeccionTradicional(String pais) {
		this.pais=pais;
		seccion = new String[12];
		figuritaPegadas=0;
	}
	
	public String obtenerPaisSeccion() {
		return pais;
	}
	
	public int cantFigusPegadasSeccion() {
		return figuritaPegadas;
	}

	public boolean seccionCompleta() {
		return figuritaPegadas==12;
	}

	/* true= hay fig pegada
	/false= es que la seccion esta en null, 
	 * seccion.get(fig.obtenerPosicion())=null;
	*/
	public boolean tieneFiguritaPegadaSeccion (Figurita fig) {
		return  seccion[fig.obtenerPosicion()] != null;
	}
	
	//si da true, entonces no pude pegar la figurita
	// agrega en el nombre del jugador en la seccion 
	public void pegarFiguritaEnLaSeccion(Figurita fig) {
		
			/*
			 * index= codFig 0 a 11 , String= nombre Jugador
			 * seccion.add(index, String)
			*/
			if ((figuritaPegadas<12)) {
				seccion[fig.obtenerPosicion()] = fig.obtenerNombreJugador();
			figuritaPegadas++; // este contador solo llega hasta 12
			}
	}
	
	public int cantSeccionesCreadas() {
		return seccion.length;
	}
	
}