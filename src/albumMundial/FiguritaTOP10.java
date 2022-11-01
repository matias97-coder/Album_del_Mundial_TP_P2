package albumMundial;

public class FiguritaTOP10 extends Figurita{

	private String anio;
	private String tipoBalon;

	public FiguritaTOP10(int codigoFigurita, int valorBase, Integer rankingPais, String nombrePais,
			String nombreJugador, String anio, String tipoBalon) {
		super(codigoFigurita, valorBase, rankingPais, nombrePais, nombreJugador);
		this.anio = anio;
		this.tipoBalon = tipoBalon;
	}



	public int calcularValorFinal(int rankingPais) {
		return 0;
	}



	public String obtenerAnio() {
		return anio;
	}


	public String obtenerTipoBalon() {
		return tipoBalon;
	}


	@Override
	public int calcularValorFinal() {
		
		if (tipoBalon.equals("oro"))
			return (super.obtenerValorBase()+super.obtenerRankingPais())*120/100;
		
		return (super.obtenerValorBase()+super.obtenerRankingPais())*110/100;
	}
	
	
	
}
