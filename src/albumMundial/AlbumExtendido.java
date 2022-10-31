package albumMundial;

import java.util.ArrayList;
import java.util.HashMap;

public class AlbumExtendido extends Album {

	
	HashMap<String, ArrayList<String>> seccionTop10;
	String [] paisesTop10;

	public AlbumExtendido(String premio, Integer codigoAlbum, String[] paisesClasificados, String [] paisesTop10) {
		super(premio, codigoAlbum, paisesClasificados);
		this.seccionTop10 = generarSeccionTop10();
	}
	
	private ArrayList<String> generarListaTop10(){
		ArrayList<String> listaTop10 = new ArrayList<>();
		for (int i = 0; i < 2; i++) {
			listaTop10.add(i, "");
		}
		return listaTop10;
	}

	private HashMap<String, ArrayList<String>> generarSeccionTop10(){
		HashMap<String, ArrayList<String>> mapaSeccionTop10 = new HashMap<>();
		for (String string : paisesTop10) {
			seccionTop10.put(string, generarListaTop10());
		}
		return mapaSeccionTop10;
	}
	
	@Override
	public boolean tieneCodigoPromocional () {
		return false;
	}
	
}
