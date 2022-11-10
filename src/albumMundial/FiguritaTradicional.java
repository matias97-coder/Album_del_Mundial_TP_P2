package albumMundial;

public class FiguritaTradicional extends Figurita{

	public FiguritaTradicional(int codigoFigurita, int posicion,int valorBase, Integer rankingPais, String nombrePais,
			String nombreJugador) {
		super(codigoFigurita, posicion,valorBase, rankingPais, nombrePais, nombreJugador);
	}
	
	@Override
	public int calcularValorFinal() {
		return obtenerValorBase()+obtenerRankingPais();
	}
	

}
