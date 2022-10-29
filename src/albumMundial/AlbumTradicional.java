package albumMundial;

public class AlbumTradicional extends Album{

	Integer numeroSorteo;
	
	 public AlbumTradicional(String premio, Integer codigoAlbum, String[] paisesClasificados, Integer numeroSorteo) {
		super(premio, codigoAlbum, paisesClasificados);
		this.numeroSorteo = numeroSorteo;
	}

	public boolean estaNumeroSorteoUtilizado() {
		 return numeroSorteo==null;
	 }
	 
	 public void cargarNumeroSorteo(Integer numSorteo) {
		 numeroSorteo=numSorteo;
	 }
}
