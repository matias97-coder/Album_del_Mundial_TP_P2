package albumMundial;

public class AlbumWeb extends Album{
	String codigoPromocional;

	public AlbumWeb(String premio, String codigoAlbum, String codigoPromocional) {
		super(premio, codigoAlbum);
		this.codigoPromocional = codigoPromocional;
	}
	
	 public boolean estaCodigoPromocionalUtilizado() {
		 return codigoPromocional!=null;
	 }
	 
	 public void cargarCodigoPromocional(String codPromocional) {
		 codigoPromocional=codPromocional;
	 }
}
