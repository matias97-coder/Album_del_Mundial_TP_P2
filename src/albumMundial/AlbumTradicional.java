package albumMundial;

public class AlbumTradicional extends Album{

	Integer numeroSorteo;

	public AlbumTradicional(String premio, String codigoAlbum, Integer numeroSorteo) {
		super(premio, codigoAlbum);
		this.numeroSorteo = numeroSorteo;
	}
	
	 public boolean estaNumeroSorteoUtilizado() {
		 return numeroSorteo==null;
	 }
	 
	 public void cargarNumeroSorteo(Integer numSorteo) {
		 numeroSorteo=numSorteo;
	 }
}
