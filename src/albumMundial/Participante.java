package albumMundial;

import java.util.ArrayList;

public class Participante {
	private Album album;
	private ArrayList<Figurita> coleccionDeFiguritas;
	private String nombreUsuario;
	private String dni;
	
	public Participante(Album album, String nombreUsuario, String dni) {
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

	public void agregarFiguritasASuColeccion (Figurita fig){

	}

	public void intercambiarFigurita(Figurita figuritaADar, Figurita figuritaARecibir){

	}
	
	public boolean estaFiguritaEnColeccion (Figurita fig){
		
		return false;
	}
}
