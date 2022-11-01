package albumMundial;

import java.util.ArrayList;
import java.util.HashMap;

public class AlbumExtendido extends Album {

	private int figuritasTOPpegadas=0;
	private int totalJugadoresTOP=20;
	private HashMap<String, ArrayList<String>> seccionTop10;
	private HashMap<String, SeccionTOP10> seccionTop102;
	private String [] mundialesTop10;

	public AlbumExtendido(String premio, Integer codigoAlbum, String[] paisesClasificados, String [] mundialesTop10) {
		super(premio, codigoAlbum, paisesClasificados);
		this.mundialesTop10=mundialesTop10;
		this.seccionTop10 = generarSeccionTop10();
		this.seccionTop102=generarSeccionTop102();
	}
	
	private ArrayList<String> generarListaTop10(){
		ArrayList<String> listaTop10 = new ArrayList<>();
		for (int i = 0; i < 2; i++) {
			listaTop10.add(null);
		}
		return listaTop10;
	}

	private HashMap<String, ArrayList<String>> generarSeccionTop10(){
		HashMap<String, ArrayList<String>> mapaSeccionTop10 = new HashMap<>();
		for (String sedesMundiales : mundialesTop10) {
			mapaSeccionTop10.put(sedesMundiales, generarListaTop10());
		}
		return mapaSeccionTop10;
	}
	
	private HashMap<String, SeccionTOP10> generarSeccionTop102(){
		HashMap<String, SeccionTOP10> mapaSeccionTop10 = new HashMap<>();
		for (String sedesMundiales : mundialesTop10) {
			SeccionTOP10 sec10= new SeccionTOP10();
			mapaSeccionTop10.put(sedesMundiales, sec10);
		}
		return mapaSeccionTop10;
	}
	public boolean seccionTOP10completa () {
		return figuritasTOPpegadas == totalJugadoresTOP;
	}
	
	
	public void pegarFiguritaEnLaSeccionTOP(Figurita fig) {
		SeccionTOP10 secTOP= seccionTop102.get(fig.obtenerNombrePais());
		
		if (! secTOP.tieneFiguritaPegadaSeccionTOP10(fig)) {
			secTOP.pegarFiguritaEnLaSeccion(fig);
			figuritasTOPpegadas++;
		}
	}
	
	@Override
	public boolean tieneCodigoPromocional () {
		return false;
	}
	
	
	
	@Override
	public boolean completoAlbum() {
		return super.cantJugadoresTotales()==super.cantTotalDeFiguritasPegadas() && seccionTOP10completa ();
	}
	
}
