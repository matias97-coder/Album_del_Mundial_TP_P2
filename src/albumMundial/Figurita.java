package albumMundial;

public abstract class Figurita {
	private int codigoFigurita;
	private int valorBase;
	
	public Figurita(int codigoFigurita, int valorBase) {
		this.codigoFigurita = codigoFigurita;
		this.valorBase = valorBase;
	}

	public int obtenerValorBase() {
		return valorBase;
	}



	public int obtenerCodigoFigurita() {
		return codigoFigurita;
	}
	
	public abstract int calcularValorFinal();
	
	
}
