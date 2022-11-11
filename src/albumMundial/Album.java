

package albumMundial;

import java.util.HashMap;


public abstract class Album {
	

	private int figuritasTotales;
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
		figuritasTotales=0;
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

	
	/* Para poder pegar la Figurita la funcion 
	 * tienePegadaFigurita(fig) tiene que llegar en null
	 * si es null entonces puedo pegar la figurita
	 */
	public void pegarFiguraEnElAlbum(Figurita fig) {
		
			
			if ((figuritasTotales <totalJugadores) && (tienePegadaFigurita(fig)==false) ) {
				SeccionTradicional sec= seccionesJugadores.get(fig.obtenerNombrePais());
				sec.pegarFiguritaEnLaSeccion(fig);
				figuritasTotales++;
			}
	}
	// True si tiene una figurita pegada
	// False= quiero pegar la figurita, si la seccion esta en null
	public boolean tienePegadaFigurita(Figurita fig) {
		// get. (pais,seccionTradicional)
		SeccionTradicional sec= seccionesJugadores.get(fig.obtenerNombrePais());
		
		return sec.tieneFiguritaPegadaSeccion(fig);
	}

	public boolean completoSeccionPais (String pais) {
		
		SeccionTradicional sec= seccionesJugadores.get(pais);
		
		return sec.seccionCompleta();
	}
	
	public void mostrarAlbum() {
		
		int i=0;
		for(String pais : seccionesJugadores.keySet()) {
			i++;
			
			System.out.println(i+" "+ pais+" "+seccionesJugadores.get(pais).cantFigusPegadasSeccion());
		}
	}

	private HashMap<String, SeccionTradicional> generarSeccionJugadores(){
		HashMap<String, SeccionTradicional> mapaSeccionJugadores = new HashMap<String, SeccionTradicional>();
	
		for (String pais: paisesClasificados) {
			SeccionTradicional seccion= new SeccionTradicional(pais);
			mapaSeccionJugadores.put(pais, seccion);
		
		}
		return mapaSeccionJugadores;
	}
	
	public boolean equals(Object obj) {

		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Album)) {
			return false;
		}

		Album otroAlbum = (Album) obj;

		return getClass().equals(otroAlbum.getClass());

	}

	public abstract boolean tieneCodigoPromocional ();
	public abstract boolean completoAlbum();
	
}
