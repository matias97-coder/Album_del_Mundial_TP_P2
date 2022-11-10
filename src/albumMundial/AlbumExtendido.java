package albumMundial;

import java.util.HashMap;

public class AlbumExtendido extends Album {

	private int figuritasTOPpegadas=0;
	private int totalJugadoresTOP=20;
	private HashMap<String, SeccionTOP10> seccionTop10;
	private String [] mundialesTop10;

	public AlbumExtendido(String premio, Integer codigoAlbum, String[] paisesClasificados, String [] mundialesTop10) {
		super(premio, codigoAlbum, paisesClasificados);
		this.mundialesTop10=mundialesTop10;

		this.seccionTop10=generarSeccionTop10();
	}

	private HashMap<String, SeccionTOP10> generarSeccionTop10(){
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
		SeccionTOP10 secTOP= seccionTop10.get(fig.obtenerNombrePais());
		
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
		return super.cantJugadoresTotales()==super.cantTotalDeFiguritasPegadas() && figuritasTOPpegadas == totalJugadoresTOP  ;
	}
	
}
