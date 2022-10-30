package albumMundial;

import java.util.ArrayList;
import java.util.List;

public class Participante {
	private Album album;
	private ArrayList<Figurita> coleccionDeFiguritas;
	private String nombreUsuario;
	private int dni;
	
	public Participante(Album album, String nombreUsuario, int dni) {
		this.album = album;
		this.nombreUsuario = nombreUsuario;
		this.dni = dni;
		coleccionDeFiguritas= new ArrayList<Figurita>();
	}
	
	public boolean poseeAlbumCompleto (){

		return false;
	}

	public void pegasFiguritasAlAlbum (){

		}

	public void agregarFiguritasASuColeccion (List<Figurita> figus){
		coleccionDeFiguritas.addAll(figus);
	}

	public void intercambiarFigurita(Figurita figuritaADar, Figurita figuritaARecibir){

	}
	
	public boolean estaFiguritaEnColeccion (Figurita fig){
		
		return false;
	}
	
	public String obtenerTipoDeAlbum () {
		if (album instanceof AlbumTradicional) 
			return "Tradicional";
	
		if (album instanceof AlbumWeb)
			return "Web";
		
		return "Extendido";
	}
	
	
	
}
