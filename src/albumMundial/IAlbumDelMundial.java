package albumMundial;

import java.util.List;

public interface IAlbumDelMundial {

	/**
	* Registra un nuevo participante y devuelve el codigo unico del
	* album asociado.

	* Si el participante ya est� registrado o el tipo de album es
	* invalido, se debe lanzar una excepcion.
	*/
	
	
	public int registrarParticipante(int dni, String nombre, String tipoAlbum);
	/**
	* Se generan 4 figuritas al azar y se asocia al participante
	* correspondiente identificado por dni
	* Si el participante no est� registrado, se debe lanzar una excepci�n.
	*/
	public void comprarFiguritas(int dni);
	/**
	* Se generan 4 figuritas top 10 al azar y
	* se asocia al participante correspondiente identificado por dni
	* Si el participante no est� registrado, se debe lanzar una excepci�n.
	* Si el participante no tiene album top10, se debe lanzar una excepci�n.
	*/
	public void comprarFiguritasTop10(int dni);
	/**
	* Compra por �nica vez un grupo de 4 figuritas con el codigo promocional
	* asociado a su album web.
	*
	* Si el participante no est� registrado, se debe lanzar una excepci�n.
	* Si el participante no tiene codigo de sorteo o el mismo ya fu� usado,
	* se debe lanzar una excepcion.
	*/
	public void comprarFiguritasConCodigoPromocional(int dni);
	/**
	* Busca entre las figuritas del participante cuales a�n no est�n en el
	* album y las asocia.
	* Devuelve una lista con las figuritas asociadas.
	* De cada figurita se devuelve un string "$pais-$numeroJugador"
	*
	* Si el participante no est� registrado, se debe lanzar una excepci�n.
	*/
	public List<String> pegarFiguritas(int dni);
	/**
	* Verifica si el participante identificado por dni ya complet� el album.
	* Devuelve true si est� completo, sino false.
	* Este metodo debe resolverse en O(1)
	*
	* Si el participante no est� registrado, se debe lanzar una excepci�n.
	*/
	public boolean llenoAlbum(int dni);
	/**
	* Realiza el sorteo instantaneo con el codigo asociado al album
	* tradicional del participante y devuelve algun premio al azar.
	*
	* Si el participante no est� registrado, se debe lanzar una excepci�n.
	* Si no tiene codigo para el sorteo o ya fue sorteado, se debe lanzar
	* una excepcion.
	*/
	public String aplicarSorteoInstantaneo(int dni);
	/**
	* Busca si el participante tiene alguna figurita repetida y devuelve
	* el codigo de la primera que encuentre.
	* Si no encuentra ninguna, devuelve el codigo -1.
	* Si el participante no est� registrado, se debe lanzar una excepci�n.
	*/
	public int buscarFiguritaRepetida(int dni);
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
	public boolean intercambiar(int dni, int codFigurita);
	/**
	* Dado el dni de un participante, busca una figurita repetida e intenta
	* intercambiarla
	* Devuelve true si pudo intercambiarla. Sino, devuelve false.
	*
	* Si el participante no est� registrado, se debe lanzar una excepci�n.
	*/
	public boolean intercambiarUnaFiguritaRepetida(int dni);
	/**
	* Dado el dni de un participante, se devuelve el nombre del mismo.
	*
	* Si el participante no est� registrado, se debe lanzar una excepci�n.
	*/
	public String darNombre(int dni);
	/**
	* Dado el dni de un participante, devuelve el premio correspondiente
	* por llenar el album.
	*
	* Si el participante no est� registrado, se debe lanzar una excepcion.
	* Si no tiene el album completo, se debe lanzar una excepcion.
	*/
	public String darPremio(int dni);

	/**
	* Devuelve un string con la lista de todos los participantes que
	* tienen su album completo y el premio que les corresponde.
	* El listado debe respetar el siguiente formato para cada ganador:
	* " - ($dni) $nombre: $premio"
	*/
	public String listadoDeGanadores();
	/**
	* Devuelve una lista con todos los participantes que llenaron el pais
	* pasado por parametro.
	*
	* De cada participante se devuelve el siguiente String:
	* "($dni) $nombre: $tipoAlbum"
	*/
	public List<String> participantesQueCompletaronElPais(String nombrePais);
}
