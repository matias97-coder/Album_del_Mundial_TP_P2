package albumMundial;

public class FiguritaTradicional extends Figurita
{
	private String nombrePais;
	private String nombreJugador;
	
	public FiguritaTradicional(int codigoFigurita, int valorBase, String nombrePais, String nombreJugador) {
		super(codigoFigurita, valorBase);
		this.nombrePais = nombrePais;
		this.nombreJugador = nombreJugador;
	}

	public String obtenerNombrePais() {
		return nombrePais;
	}

	public String obtenerNombreJugador() {
		return nombreJugador;
	}
	
	@Override
	public int calcularValorFinal(int rankingPais) {
		
		return super.obtenerValorBase()+rankingPais;
	}
	
	
}
