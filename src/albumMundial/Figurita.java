package albumMundial;

public abstract class Figurita {

	private int codigoFigurita;
	private int posicion;
	private int valorBase;
	private Integer rankingPais;
	private String nombrePais;
	private String nombreJugador;
	
	public Figurita () {}
	
	@Override
	public String toString() {
		
		StringBuilder st= new StringBuilder();
		
		st.append ("\n") .append (" codigoFigurita: ") .append (codigoFigurita).append ("ValorBase: ").append(valorBase)
		.append(" nombrePais: ").append(nombrePais).append(" rankingPais: ").append(rankingPais).append(" nombreJugador:")
		.append(nombreJugador).append("\n");
	
		return st.toString();
	}
	
	
	public Figurita(int codigoFigurita, int posicion, int valorBase, Integer rankingPais, String nombrePais, String nombreJugador ) {
		this.codigoFigurita = codigoFigurita;
		this.posicion= posicion;
		this.valorBase = valorBase;
		this.rankingPais=rankingPais;
		this.nombrePais=nombrePais;
		this.nombreJugador=nombreJugador;

	}
	
	public Integer obtenerRankingPais () {
		return rankingPais;
	}
	
	public String obtenerNombrePais() {
		return nombrePais;
	}

	public String obtenerNombreJugador() {
		return nombreJugador;
	}
	public int obtenerValorBase() {
		return valorBase;
	}

	public int obtenerCodigoFigurita() {
		return codigoFigurita;
	}
	
	public int obtenerPosicion() {
		return posicion;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Figurita)) {
			return false;
		}
	
		Figurita otraFig = (Figurita) obj;

		return posicion == otraFig.posicion && nombrePais.equals(otraFig.obtenerNombrePais()) 
				&& codigoFigurita>=0 && otraFig.obtenerCodigoFigurita()>=0
				&& (getClass().equals(otraFig.getClass()) && otraFig.calcularValorFinal() <=calcularValorFinal() );
	}

	public abstract int calcularValorFinal();

}
