package albumMundial;

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
	
	public boolean completeElAlbum() {
		return album.completoAlbum();
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
	
	public Album obtenerAlbum () {
		return album;
	}
	
	public boolean estaVacioColeccion() {
		return coleccionDeFiguritas.isEmpty();
	}

	public void agregarFiguritasASuColeccion (List<Figurita> figus){
		coleccionDeFiguritas.addAll(figus);
	}
	
	public ArrayList<Figurita> obtenerColeccionDeFiguritas(){
		return coleccionDeFiguritas;
	}

	public int obtenerUnCodigoFiguritaRepetida() {
		if(coleccionDeFiguritas.size() > 0) {
			return coleccionDeFiguritas.get(0).obtenerCodigoFigurita();
		}
		return -1;
	}

	public List<String> figuritasPegadas() {
		ArrayList<String> figuritasPegadasN = new ArrayList<>();
		
		Iterator<Figurita> it = coleccionDeFiguritas.iterator();
		while(it.hasNext() ) {
			Figurita fig =it.next(); 
			if(fig instanceof FiguritaTradicional) {
				// en .pegarFiguraEnElAlbum(fig) ya vilida si se puede pegar o no la fig
				if (album.tienePegadaFigurita(fig) == false) {
					album.pegarFiguraEnElAlbum(fig);
					figuritasPegadasN.add(fig.obtenerNombrePais() + " - " + fig.obtenerNombreJugador());
					it.remove();
				}
			}
			
			else {
				if(fig instanceof FiguritaTOP10) {
					if (((AlbumExtendido)album).tienePegadaFigurita(fig) == false) {
						((AlbumExtendido)album).pegarFiguritaEnLaSeccionTOP(fig);
						figuritasPegadasN.add(fig.obtenerNombrePais() + " - " + fig.obtenerNombreJugador());
						it.remove();
					}
				}
			}
			
		}

		return figuritasPegadasN;
	}
	
	/* Devuelve una lista con las figuritas que no pegue de mi coleccion,
	 * que son de menor o igual valor de la que recibo por parametro
	 */
	public ArrayList<Figurita> obtenerFiguritasIgualMenorValor(int valorFinal){
		ArrayList<Figurita> figuritasAintercambiar = new ArrayList<Figurita>();
		
		for (Figurita figurita : coleccionDeFiguritas) {
			if(figurita.calcularValorFinal()<=valorFinal) {
				figuritasAintercambiar.add(figurita);
			}
		}
		return figuritasAintercambiar;
	}
	
	public Figurita tieneFiguritaEnColeccion(int codFigurita) {
		
		if (codFigurita==-1)
			return null;
		int i = 0;
		
		while (i < coleccionDeFiguritas.size()) {
			if(coleccionDeFiguritas.get(i).obtenerCodigoFigurita() == codFigurita) {
				return coleccionDeFiguritas.get(i);
			}
			i++;
		}
		return null;
	}
	
	/*
	 * Devuelve una figurita de otro participante B, para realizar el intercambio
	 * */
	
	public Figurita AlgunaFiguritaSinPegarEnAlbum(ArrayList<Figurita> figuritas_part_B) {
		int i = 0;
		while(i < figuritas_part_B.size()) {
			
			/* Si en el album que tengo, la fig no esta ocupada es
			 * decir, esta en false = null, entonces devuelve esa fig
			 * que no tiene pegada del participante b
			 */
			Figurita fig= figuritas_part_B.get(i);
			if(album.tienePegadaFigurita(fig) == false) {
				return figuritas_part_B.get(i);
			}
			i++;
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
	
	public boolean completoUnaSeccion (String pais) {
		return album.completoSeccionPais(pais);
	}
	
	public boolean equals(Object obj) {

		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Participante)) {
			return false;
		}

		Participante otroPart = (Participante) obj;

		return album.equals(otroPart.obtenerAlbum()) && dni!=otroPart.obtenerDNI();

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
