

package albumMundial;

import java.util.HashMap;

public abstract class Album {
	

	private int figuritasTotales=0;
	private int cantJugadoresEquipo=12;
	private int paisesParticipantes=32;
	private String premio;
	private Integer codigoAlbum;
	private String  [] paisesClasificados ;
	private HashMap <String, SeccionTradicional> seccionesJugadores;
	private int totalJugadores= paisesParticipantes*cantJugadoresEquipo; 
	
	@Override
	public String toString() {
		
		StringBuilder st= new StringBuilder();
		
		st.append ("\n") .append (" codigoAlbum: ") .append (codigoAlbum) .append (" premio: ").append(premio).append ("\n");
	
		return st.toString();
	}
	
	public Album(String premio, Integer codigoAlbum,  String [] paisesClasificados) {
		this.premio = premio;
		this.codigoAlbum = codigoAlbum;
		this.paisesClasificados = paisesClasificados;
		this.seccionesJugadores= generarSeccionJugadores();
	} 

	public Album() {
		
	}
	
	public Integer obtenerCodigoAlbum() {
		return codigoAlbum;
	}
	
	public void cargarPremio(String premio) {
		
	}
	public String obtenerPremio() {
		
		return premio;
	}
	
	public int cantTotalDeFiguritasPegadas () {
		return figuritasTotales;
	}
	
	public int cantJugadoresTotales() {
		return  totalJugadores;
	}
	
	public String obtenerNumeroDeCodigoAlbum() {
		return null;
	}
	
	
	/* Para poder pegar la Figurita la funcion 
	 * tienePegadaFigurita(fig) tiene que llegar en null
	 * si es null entonces puedo pegar la figurita
	 */
	public void pegarFiguraEnElAlbum(Figurita fig) {

		if ( tienePegadaFigurita(fig) == false) {
			seccionesJugadores.get(fig.obtenerNombrePais()).pegarFiguritaEnLaSeccion(fig);
			figuritasTotales++;
		}
	}

	// quiero pegar la figurita, si la seccion esta en null
	public boolean tienePegadaFigurita(Figurita fig)
	{
		// get. (pais,seccionTradicional)
		return seccionesJugadores.get(fig.obtenerNombrePais()).tieneFiguritaPegadaSeccion(fig);
	}

	public void reclamarPremio() {
		
	}
	public boolean completoSeccionPais (String pais) {
		// solo sirve para los albunes comunes
		return seccionesJugadores.get(pais).seccionCompleta();
	}
	

	private HashMap<String, SeccionTradicional> generarSeccionJugadores(){
		HashMap<String, SeccionTradicional> mapaSeccionJugadores = new HashMap<String, SeccionTradicional>();
	
		for (String pais: paisesClasificados) {
			SeccionTradicional seccion= new SeccionTradicional(pais);
			mapaSeccionJugadores.put(pais, seccion);
		
		}
		return mapaSeccionJugadores;
	}
	


	public abstract boolean tieneCodigoPromocional ();
	public abstract boolean completoAlbum();
	
}
