package albumMundial;

public class FiguritaTOP10 extends Figurita{

	private String anio;
	private String tipoBalon;

	@Override
	public String toString() {
		
		StringBuilder st= new StringBuilder();
		
		st.append ("\n") .append (" anio: ") .append (anio).append(" premio:").append(tipoBalon).append("\n");
	
		return st.toString();
	}
	
	public FiguritaTOP10(int codigoFigurita, int posicion,int valorBase, Integer rankingPais, String nombrePais,
			String nombreJugador, String anio, String tipoBalon) {
		super(codigoFigurita, posicion,valorBase, rankingPais, nombrePais, nombreJugador);
		this.anio = anio;
		this.tipoBalon = tipoBalon;
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
	
	@Override
	public boolean equals(Object obj) {

		if (obj == null) {
			return false;
		}
		if (!(obj instanceof FiguritaTOP10)) {
			return false;
		}

		FiguritaTOP10 otraFig = (FiguritaTOP10) obj;

		return obtenerCodigoFigurita() == otraFig.obtenerCodigoFigurita();
	}
	
}
