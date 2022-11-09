package albumMundial;

import java.util.ArrayList;
import java.util.List;

public class Participante {
	private Album album;
	private ArrayList<Figurita> coleccionDeFiguritas;
	private String nombreUsuario;
	private int dni;
	private String premio=null;
	
	
	@Override
	public String toString() {
		
		StringBuilder st= new StringBuilder();
		
		st.append ("\n") .append (" DNI: ") .append (dni).append(" nombreUsuario:").append(nombreUsuario)
		.append(" Album:").append(tipoAlbum()).append("\n");
	
		return st.toString();
	}
	
	
	public Participante(Album album, String nombreUsuario, int dni) {
		this.album = album;
		this.nombreUsuario = nombreUsuario;
		this.dni = dni;
		coleccionDeFiguritas= new ArrayList<Figurita>();
	}
	
	public void cargarPremio(String premio) {
		this.premio=premio;
	}
	
	public String premioObtenido () {
		return premio;
	}
	
	public boolean poseeAlbumCompleto (){

		return false;
	}

	/* De cada figurita se devuelve un string "$pais-$numeroJugador"
	 * hay que usar iteradores aca
	 * */
	
	public ArrayList<String> pegarFiguritasEnElAlbum (){
		ArrayList<String> figuritasPegadas = new ArrayList<String> ();
		
		return figuritasPegadas;
		}

	public void agregarFiguritasASuColeccion (List<Figurita> figus){
		coleccionDeFiguritas.addAll(figus);
	}

	public void intercambiarFigurita(Figurita figuritaADar, Figurita figuritaARecibir){

	}
	
	public int obtenerDNI() {
		return dni;	
	}
	
	public String obtenerNombreUsuario() {
		return nombreUsuario;
	}
	
	public boolean estaFiguritaEnColeccion (Figurita fig){
		
		return false;
	}
	
	public Album obtenerAlbum () {
		return album;
	}
	
	public ArrayList<Figurita> obtenerColeccionDeFiguritas(){
		return coleccionDeFiguritas;
	}

	public String tipoAlbum () {
		if (album instanceof AlbumTradicional)
			return "Tradicional";
		if (album instanceof AlbumWeb)
			return "WEB";
		if (album instanceof AlbumExtendido)
			return "Extendido";
		return null;
	}
	
	
}
