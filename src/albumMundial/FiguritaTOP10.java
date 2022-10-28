package albumMundial;

public class FiguritaTOP10 extends Figurita{

	private String sedeMundial;
	private String anio;
	private String tipoBalon;
	private String nombreJugador;
	
	
	
	public FiguritaTOP10(int codigoFigurita, int valorBase, String sedeMundial, String anio, String tipoBalon, String nombreJugador) {
		super(codigoFigurita, valorBase);
		this.sedeMundial = sedeMundial;
		this.anio = anio;
		this.tipoBalon = tipoBalon;
		this.nombreJugador=nombreJugador;
	}



	public int calcularValorFinal(int rankingPais) {
		return 0;
	}


	public String obtenerSedeMundial() {
		return sedeMundial;
	}



	public String obtenerAnio() {
		return anio;
	}


	public String obtenerTipoBalon() {
		return tipoBalon;
	}



	
	
}
