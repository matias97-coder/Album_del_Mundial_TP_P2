package albumMundial;

public class FiguritaTradicional extends Figurita{

	public FiguritaTradicional(int codigoFigurita, int valorBase, Integer rankingPais, String nombrePais,
			String nombreJugador) {
		super(codigoFigurita, valorBase, rankingPais, nombrePais, nombreJugador);
	}
	
	public int calcularValorFinal() {
		return super.obtenerValorBase()+super.obtenerRankingPais();
	}
	
}
