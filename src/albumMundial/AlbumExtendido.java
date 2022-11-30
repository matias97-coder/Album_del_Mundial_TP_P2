package albumMundial;

import java.util.HashMap;

public class AlbumExtendido extends Album {

	private int figuritasTOPpegadas;
	private int totalJugadoresTOP=20;
	private HashMap<String, SeccionTOP10> seccionTop10;
	private String [] mundialesTop10;
	
	@Override
	public String toString() {
		
		StringBuilder st= new StringBuilder();
		
		st.append (super.toString());
		st.append ("|Extendido cant FigusPegadas:").append (cantTotalDeFiguritasPegadas ()+figuritasTOPpegadas).append("\n");
		
		return st.toString();
	}

	public AlbumExtendido(String premio, Integer codigoAlbum, String[] paisesClasificados, String [] mundialesTop10) {
		super(premio, codigoAlbum, paisesClasificados);
		this.mundialesTop10=mundialesTop10;
		this.seccionTop10=generarSeccionTop10();
		figuritasTOPpegadas=0;
	}

	private HashMap<String, SeccionTOP10> generarSeccionTop10(){
		HashMap<String, SeccionTOP10> mapaSeccionTop10 = new HashMap<>();
		for (String sedesMundiales : mundialesTop10) {
			SeccionTOP10 sec10= new SeccionTOP10(sedesMundiales);
			mapaSeccionTop10.put(sedesMundiales, sec10);
		}
		return mapaSeccionTop10;
	}
	public boolean seccionTOP10completa () {
		return figuritasTOPpegadas == totalJugadoresTOP;
	}
	
	@Override
	public boolean tienePegadaFigurita(Figurita fig) {
		
		if (fig instanceof FiguritaTradicional)
			return super.tienePegadaFigurita(fig); //Llama al metodo de su clase padre ALBUM 
	
		SeccionTOP10 sec10 = seccionTop10.get(fig.obtenerNombrePais());
		return  sec10.tieneFiguritaPegadaSeccionTOP10(fig);
	}
	
	
	@Override
	public void pegarFiguritaEnElAlbum(Figurita fig) {
		
		if (fig instanceof FiguritaTradicional)
			super.pegarFiguritaEnElAlbum(fig); /*LLAMA al metodo pegar de su clase padre "ALBUM"
											 	 en caso que la figurita que quiera pegar sea de tipo tradicional*/
		
		if ((figuritasTOPpegadas<totalJugadoresTOP) && fig instanceof FiguritaTOP10){
			SeccionTOP10 secTOP= seccionTop10.get(fig.obtenerNombrePais());
			secTOP.pegarFiguritaEnLaSeccionTOP(fig);
			figuritasTOPpegadas++;
			
		}
	}

	@Override
	public boolean completoAlbum() {
		return (cantJugadoresTotales()+totalJugadoresTOP) == (cantTotalDeFiguritasPegadas() +figuritasTOPpegadas )  ;
	}
	
}
