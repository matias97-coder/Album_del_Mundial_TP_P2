package albumMundial;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

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
	
	public boolean poseeAlbumCompleto (){

		return false;
	}

	public void agregarFiguritasASuColeccion (List<Figurita> figus){
		coleccionDeFiguritas.addAll(figus);
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
	
	public int obtenerUnCodigoFiguritaRepetida() {
		if(coleccionDeFiguritas.size() > 0) {
			return coleccionDeFiguritas.get(0).obtenerCodigoFigurita();
		}
		return -1;
	}

	public ArrayList<String> figuritasPegadas() {
		ArrayList<String> figuritasPegadas = new ArrayList<>();
		Iterator<Figurita> it = coleccionDeFiguritas.iterator();
		while(it.hasNext() ) {
			Figurita fig =it.next(); 
			if(fig instanceof FiguritaTradicional) {
				if (! album.tienePegadaFigurita(fig)) {
					album.pegarFiguraEnElAlbum(fig);
					figuritasPegadas.add(fig.obtenerNombrePais() + " - " + fig.obtenerNombreJugador());
					it.remove();
				}
			}else {
				if(! ((AlbumExtendido)album).tienePegadaFigurita(fig)) {
					((AlbumExtendido)album).pegarFiguraEnElAlbum(fig);
					figuritasPegadas.add(fig.obtenerNombrePais() + " - " + fig.obtenerNombreJugador());
					it.remove();
				}
			}
			
		}
		return figuritasPegadas;
	}
	
	public ArrayList<Figurita> obtenerFiguritasIgualMenorValor(int valorBase){
		ArrayList<Figurita> figuritasAintercambiar = new ArrayList<Figurita>();
		
		for (Figurita figurita : coleccionDeFiguritas) {
			if(figurita.obtenerValorBase() <= valorBase && !figuritasAintercambiar.contains(figurita)) {
				figuritasAintercambiar.add(figurita);
			}
		}
		return figuritasAintercambiar;
	}
	
	public Figurita tieneFiguritaEnColeccion(int codFigurita) {
		int i = 0;
		while (i < coleccionDeFiguritas.size()) {
			if(coleccionDeFiguritas.get(i).obtenerCodigoFigurita() == codFigurita) {
				return coleccionDeFiguritas.get(i);
			}
			i++;
		}
		return null;
	}
	
	public Figurita AlgunaFiguritaSinPegarEnAlbum(ArrayList<Figurita> figuritas) {
		int i = 0;
		while(i < figuritas.size()) {
			if(!album.tienePegadaFigurita(figuritas.get(i))) {
				return figuritas.get(i);
			}
		}
		return null;
	}
	
	public void intercambiarFigurita(Figurita figuritaADar, Figurita figuritaARecibir){
		coleccionDeFiguritas.add(figuritaARecibir);
		coleccionDeFiguritas.remove(figuritaADar);
	}
	
	public Figurita obtenerAlgunaFiguritaDeLaColeccion() {
		return coleccionDeFiguritas.get((new Random(System.currentTimeMillis())).nextInt(coleccionDeFiguritas.size()));
	}
}
