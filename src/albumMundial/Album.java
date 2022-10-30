

package albumMundial;

import java.util.ArrayList;
import java.util.HashMap;

public class Album {
	
	String premio;
	Integer codigoAlbum;
	HashMap <String, ArrayList<String>> seccionesJugadores;
	String [] paisesClasificados;
	
	public Album(String premio, Integer codigoAlbum,  String [] paisesClasificados) {
		this.premio = premio;
		this.codigoAlbum = codigoAlbum;
		this.seccionesJugadores= generarSeccionJugadores();
		this.paisesClasificados = paisesClasificados;
	} 

	public Album() {
		
	}
	
	public Integer obtenerCodigo() {
		return this.codigoAlbum;
	}
	
	public void cargarPremio(String premio) {
		
	}
	public String obtenerPremio() {
		
		return null;
	}
	
	public String obtenerNumeroDeCodigoAlbum() {
		return null;
	}
	public void pegarFiguraEnElAlbum(Figurita fig) {
		
	}
	public boolean tienePegadaFigurita(Figurita fig)
	{
		return false;
	}
	public boolean estaCompleta() {
		return false;
	}
	public void reclamarPremio() {
		
	}
	public boolean completoSeccionPais (String pais) {
		return false;
	}
	
	private ArrayList<String> generarListaJugadores(){
		ArrayList<String> listaJugadores = new ArrayList<String>();
		String espacioLibre = "";
		for (int i = 0; i < 12; i++) {
			listaJugadores.add(espacioLibre);
		}
		return listaJugadores;
	}

	private HashMap<String, ArrayList<String>> generarSeccionJugadores(){
		HashMap<String, ArrayList<String>> mapaSeccionJugadores = new HashMap<String, ArrayList<String>>();
		for (int i = 0; i < 32; i++) {
			mapaSeccionJugadores.put(paisesClasificados[i], generarListaJugadores());
		}
		return mapaSeccionJugadores;
	}


	
}
