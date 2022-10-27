package albumMundial;

public abstract class Figurita {
	private int codigoFigurita;
	private int valorBase;
	private int valorFinal;
	
	public Figurita(int codigoFigurita, int valorBase,int valorFinal) {
		this.codigoFigurita = codigoFigurita;
		this.valorBase = valorBase;
		this.valorFinal=valorFinal;
	}

	public int obtenerValorBase() {
		return valorBase;
	}

	public int obtenerValorFinal() {
		return valorFinal;
	}

	public int obtenerCodigoFigurita() {
		return codigoFigurita;
	}
	
	public void cargarValorFinal (int valor) {
		valorFinal=valor;
	}
	
	public abstract int calcularValorFinal(int rankingPais);
	
	
}
