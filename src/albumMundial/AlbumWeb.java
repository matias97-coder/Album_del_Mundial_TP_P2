package albumMundial;

public class AlbumWeb extends Album{
	String codigoPromocional;
	
	public AlbumWeb(String premio, Integer codigoAlbum, String paisesClasificados[], String codigoPromocional) {
		super(premio, codigoAlbum, paisesClasificados);
		this.codigoPromocional = codigoPromocional;
	}

	public AlbumWeb() {
		
	}
	
	 public boolean estaCodigoPromocionalUtilizado() {
		 return codigoPromocional==null;
	 }
	 
	 public void usarCodigoPromocional(String codPromocional) {
		 this.codigoPromocional=codPromocional;
	 }
	 
		@Override
		public boolean tieneCodigoPromocional () {
			return codigoPromocional!=null;
		}
		
}
