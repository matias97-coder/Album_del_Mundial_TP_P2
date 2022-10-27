package albumMundial;

import java.util.ArrayList;
import java.util.HashMap;

public class Album {

	String premio;
	String codigoAlbum;
	HashMap <String, ArrayList<String>> seccionesJugadores;
	
	public Album(String premio, String codigoAlbum) {
		this.premio = premio;
		this.codigoAlbum = codigoAlbum;
		seccionesJugadores= new HashMap<String, ArrayList<String>>();
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


	
}
