package albumMundial;

public class Figurita {
	
	private int codigoFigurita;
	private int valorBase;
	private Integer rankingPais;
	private String nombrePais;
	private String nombreJugador;
	
	private boolean estaPegada=false;
	public Figurita () {}
	
	public Figurita(int codigoFigurita, int valorBase, Integer rankingPais, String nombrePais, String nombreJugador ) {
		this.codigoFigurita = codigoFigurita;
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

	public boolean sePegoLaFigurita () {
		return estaPegada;
	}
	
	public void pegarFigurita (boolean pegar) {
		estaPegada=pegar;
	}

	public int obtenerCodigoFigurita() {
		return codigoFigurita;
	}
	

	public int calcularValorFinal() {
		return valorBase+rankingPais;
	}
	
	
}
