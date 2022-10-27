package albumMundial;

public class FiguritaTOP10 extends Figurita{

	private String sedeMundial;
	private String anio;
	private String tipoBalon;
	
	
	
	public FiguritaTOP10(int codigoFigurita, int valorBase, String sedeMundial, String anio, String tipoBalon) {
		super(codigoFigurita, valorBase);
		this.sedeMundial = sedeMundial;
		this.anio = anio;
		this.tipoBalon = tipoBalon;
	}


	@Override
	public int calcularValorFinal() {
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
