package albumMundial;

public class AlbumTradicional extends Album{

	Integer numeroSorteo;
	
	@Override
	public String toString() {
			
		StringBuilder st= new StringBuilder();
		st.append(super.toString());	
		st.append (" numeroSorteo: ") .append (numeroSorteo).append (" ");
		st.append("|Tradicional - Figus pegadas:").append(cantTotalDeFiguritasPegadas ()).append ("\n");
		return st.toString();
	}
	

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
		
	@Override
	public boolean completoAlbum() {
		return cantJugadoresTotales()==cantTotalDeFiguritasPegadas();
	}
	
	public int obtenerNumeroSorteo() {
		return numeroSorteo;
	}
	
	public void actualizarNumeroSorteo(int valor) {
		this.numeroSorteo = valor;
	}
	
}
