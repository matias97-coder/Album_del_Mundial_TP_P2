package albumMundial;

public class FiguritaTOP10 extends Figurita{

	private String sedeMundial;
	private String anio;
	private String tipoBalon;
	
	
	
	public FiguritaTOP10(int codigoFigurita, int valorBase, int valorFinal, String sedeMundial, String anio, String tipoBalon) {
		super(codigoFigurita, valorBase, valorFinal);
		this.sedeMundial = sedeMundial;
		this.anio = anio;
		this.tipoBalon = tipoBalon;
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
