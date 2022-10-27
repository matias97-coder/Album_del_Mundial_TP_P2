package albumMundial;
/*comentario segudno*/
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class AlbumDelMundial implements IAlbumDelMundial {
	
	private Fabrica fabrica;
	private HashMap<String,Participante> participantes; //clave:dni valor:Participante
	
	public AlbumDelMundial() {
		fabrica= new Fabrica();
		participantes= new HashMap <String,Participante>();
	}
	
	
	/**
	* Registra un nuevo participante y devuelve el codigo unico del
	* album asociado.
	*
	* Si el participante ya est� registrado o el tipo de album es
	* invalido, se debe lanzar una excepcion.
	*/
	
	@Override
	public int registrarParticipante(int dni, String nombre, String tipoAlbum) {
		return 0;
	}
	/**
	* Se generan 4 figuritas al azar y se asocia al participante
	* correspondiente identificado por dni
	* Si el participante no est� registrado, se debe lanzar una excepci�n.
	*/
	
	@Override
	public void comprarFiguritas(int dni) {
		
	}
	/**
	* Se generan 4 figuritas top 10 al azar y
	* se asocia al participante correspondiente identificado por dni
	*
	5 de 7
	* Si el participante no est� registrado, se debe lanzar una excepci�n.
	* Si el participante no tiene album top10, se debe lanzar una excepci�n.
	*/
	
	@Override
	public void comprarFiguritasTop10(int dni) {
		
	}
	/**
	* Compra por �nica vez un grupo de 4 figuritas con el codigo promocional
	* asociado a su album web.
	*
	* Si el participante no est� registrado, se debe lanzar una excepci�n.
	* Si el participante no tiene codigo de sorteo o el mismo ya fu� usado,
	* se debe lanzar una excepcion.
	*/
	
	@Override
	public void comprarFiguritasConCodigoPromocional(int dni) {
		
	}
	/**
	* Busca entre las figuritas del participante cuales a�n no est�n en el
	* album y las asocia.
	* Devuelve una lista con las figuritas asociadas.
	* De cada figurita se devuelve un string "$pais-$numeroJugador"
	*
	* Si el participante no est� registrado, se debe lanzar una excepci�n.
	*/
	
	@Override
	public List<String> pegarFiguritas(int dni){
		LinkedList<String> figuritasNoAlbum = new LinkedList();
		
		return figuritasNoAlbum;
	}
	/**
	* Verifica si el participante identificado por dni ya complet� el album.
	* Devuelve true si est� completo, sino false.
	* Este metodo debe resolverse en O(1)
	*
	* Si el participante no est� registrado, se debe lanzar una excepci�n.
	*/
	
	@Override
	public boolean llenoAlbum(int dni) {
		
		return false;
	}
	/**
	* Realiza el sorteo instantaneo con el codigo asociado al album
	* tradicional del participante y devuelve algun premio al azar.
	*
	* Si el participante no est� registrado, se debe lanzar una excepci�n.
	* Si no tiene codigo para el sorteo o ya fue sorteado, se debe lanzar
	* una excepcion.
	*/
	
	@Override
	public String aplicarSorteoInstantaneo(int dni) {
		
		return null;
	}
	/**
	* Busca si el participante tiene alguna figurita repetida y devuelve
	6 de 7
	* el codigo de la primera que encuentre.
	* Si no encuentra ninguna, devuelve el codigo -1.
	*
	* Si el participante no est� registrado, se debe lanzar una excepci�n.
	*/
	
	@Override
	public int buscarFiguritaRepetida(int dni) {
		
		return 0;
	}
	/**
	* Dado el dni de un participante A y el codigo de una figurita,
	* se busca entre los participantes con mismo tipo de album
	* si alguno tiene repetida alguna figurita que le falte al participante A
	* con un valor menor o igual al de la figurita a cambiar.
	* En caso de encontrar alguno, realiza el intercambio y devuelve true.
	* Si no se encuentra ninguna para cambiar, devuelve false.
	*
	*
	* Si el participante no est� registrado o no es due�o de la figurita a
	* cambiar, se debe lanzar una excepci�n.
	*/
	@Override
	public boolean intercambiar(int dni, int codFigurita) {
		
		return false;
	}
	/**
	* Dado el dni de un participante, busca una figurita repetida e intenta
	* intercambiarla
	* Devuelve true si pudo intercambiarla. Sino, devuelve false.
	*
	* Si el participante no est� registrado, se debe lanzar una excepci�n.
	*/
	
	@Override
	public boolean intercambiarUnaFiguritaRepetida(int dni) {
		
		return false;
	}
	/**
	* Dado el dni de un participante, se devuelve el nombre del mismo.
	*
	* Si el participante no est� registrado, se debe lanzar una excepci�n.
	*/
	
	@Override
	public String darNombre(int dni) {
		return null;
	}
	/**
	* Dado el dni de un participante, devuelve el premio correspondiente
	* por llenar el album.
	*
	* Si el participante no est� registrado, se debe lanzar una excepcion.
	* Si no tiene el album completo, se debe lanzar una excepcion.
	*/
	
	@Override
	public String darPremio(int dni) {
		return null;
	}

	/**
	* Devuelve un string con la lista de todos los participantes que
	* tienen su album completo y el premio que les corresponde.
	* El listado debe respetar el siguiente formato para cada ganador:
	* " - ($dni) $nombre: $premio"
	*/
	
	@Override
	public String listadoDeGanadores() {
		return null;
	}
	/**
	* Devuelve una lista con todos los participantes que llenaron el pais
	* pasado por parametro.
	*
	* De cada participante se devuelve el siguiente String:
	* "($dni) $nombre: $tipoAlbum"
	*/
	
	@Override
	public List<String> participantesQueCompletaronElPais(String nombrePais){
		LinkedList<String> participantesARG= new LinkedList();
		
		return participantesARG;
	}
	
}
