package albumMundial;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class AlbumDelMundial implements IAlbumDelMundial {
	
	private Fabrica fabrica;
	private HashMap<Integer, Participante> participantes; //clave:dni valor:Participante

	public AlbumDelMundial() {
		fabrica= new Fabrica();
		participantes= new HashMap <Integer,Participante>();
	}
	
	
	/**
	* Registra un nuevo participante y devuelve el codigo unico del
	* album asociado.
	*
	* Si el participante ya está registrado o el tipo de album es
	* invalido, se debe lanzar una excepcion.
	*/
	
	@Override
	public int registrarParticipante(int dni, String nombre, String tipoAlbum) {
		if(participantes.containsKey(dni)) {
			throw new RuntimeException("Participante ya existe");
		}
		
		Album album = generarAlbum(tipoAlbum);
		
		if(album.equals(null)) {
			throw new RuntimeException("Tipo de album inválido");
		}
		
		Participante participante = new Participante(album, nombre, dni);
		participantes.put(dni, participante);
		return album.obtenerCodigoAlbum();
	}
	
	
	/**
	* Se generan 4 figuritas al azar y se asocia al participante
	* correspondiente identificado por dni
	* Si el participante no está registrado, se debe lanzar una excepción.
	*/
	
	@Override
	public void comprarFiguritas(int dni) {
		Participante part= participantes.get(dni);
		
		if(!participantes.containsKey(dni)) {
			throw new RuntimeException("Participante no esta registrado");
		}
		
		part.agregarFiguritasASuColeccion(fabrica.generarSobre(4));
	}
	/**
	* Se generan 4 figuritas top 10 al azar y
	* se asocia al participante correspondiente identificado por dni
	*
	* Si el participante no está registrado, se debe lanzar una excepción.
	* Si el participante no tiene album top10, se debe lanzar una excepción.
	*/
	
	@Override
	public void comprarFiguritasTop10(int dni) {
	Participante part= participantes.get(dni);
		
		if(!participantes.containsKey(dni)) {
			throw new RuntimeException("Participante no esta registrado");
		}
		
		if (! (part.obtenerAlbum() instanceof AlbumExtendido)) {
			throw new RuntimeException("El participante no tiene el Album extendido");
		}
		
		part.agregarFiguritasASuColeccion(fabrica.generarSobreTop10(4));
	}
	/**
	* Compra por única vez un grupo de 4 figuritas con el codigo promocional
	* asociado a su album web.
	*
	* Si el participante no está registrado, se debe lanzar una excepción.
	* Si el participante no tiene codigo de sorteo o el mismo ya fué usado,
	* se debe lanzar una excepcion.
	*/
	
	@Override
	public void comprarFiguritasConCodigoPromocional(int dni) {
		Participante part= participantes.get(dni);
		Album album=part.obtenerAlbum();
		
		if(!participantes.containsKey(dni)) 
			throw new RuntimeException("Participante no esta registrado");
		
		if (((AlbumWeb)album).estaCodigoPromocionalUtilizado())
			throw new RuntimeException("El codigo promocional ya fue utilizado");
		
		if (! album.tieneCodigoPromocional())
			throw new RuntimeException("El participante no tiene codigo promocional");
		
		if (album instanceof AlbumWeb) { 
			if ( ! ((AlbumWeb)album).estaCodigoPromocionalUtilizado()) {
				part.agregarFiguritasASuColeccion(fabrica.generarSobre(4));
				((AlbumWeb)album).usarCodigoPromocional(null); // el codig promocional pasa ser null
			}
		}
	}
	/**
	* Busca entre las figuritas del participante cuales aún no están en el
	* album y las asocia.
	* Devuelve una lista con las figuritas asociadas.
	* De cada figurita se devuelve un string "$pais-$numeroJugador"
	*
	* Si el participante no está registrado, se debe lanzar una excepción.
	*/
	
	@Override
	public List<String> pegarFiguritas(int dni){
		LinkedList<String> figuritasAsociadas = new LinkedList();
		

		
	
		return figuritasAsociadas;
	}
	/**
	* Verifica si el participante identificado por dni ya completó el album.
	* Devuelve true si está completo, sino false.
	* Este metodo debe resolverse en O(1)
	*
	* Si el participante no está registrado, se debe lanzar una excepción.
	*/
	
	@Override
	public boolean llenoAlbum(int dni) {
		if(!participantes.containsKey(dni)) 
			throw new RuntimeException("Participante no esta registrado");
		
		Participante part= participantes.get(dni);
		Album album = part.obtenerAlbum();
		return album.completoAlbum();
	}
	/**
	* Realiza el sorteo instantaneo con el codigo asociado al album
	* tradicional del participante y devuelve algun premio al azar.
	*
	* Si el participante no está registrado, se debe lanzar una excepción.
	* Si no tiene codigo para el sorteo o ya fue sorteado, se debe lanzar
	* una excepcion.
	*/
	
	@Override
	public String aplicarSorteoInstantaneo(int dni) {
		return null;
	}
	/**
	* Busca si el participante tiene alguna figurita repetida y devuelve
	* el codigo de la primera que encuentre.
	* Si no encuentra ninguna, devuelve el codigo -1.
	*
	* Si el participante no está registrado, se debe lanzar una excepción.
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

	* Si el participante no está registrado o no es dueño de la figurita a
	* cambiar, se debe lanzar una excepción.
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
	* Si el participante no está registrado, se debe lanzar una excepción.
	*/
	
	@Override
	public boolean intercambiarUnaFiguritaRepetida(int dni) {
		
		return false;
	}
	/**
	* Dado el dni de un participante, se devuelve el nombre del mismo.
	*
	* Si el participante no está registrado, se debe lanzar una excepción.
	*/
	
	@Override
	public String darNombre(int dni) {
		Participante part= participantes.get(dni);
		return part.obtenerNombreUsuario();
	}
	/**
	* Dado el dni de un participante, devuelve el premio correspondiente
	* por llenar el album.
	*
	* Si el participante no está registrado, se debe lanzar una excepcion.
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
		StringBuilder listado= new StringBuilder();
		
		for(Integer key : participantes.keySet()) { // recorro todas las keys del diccionario participante
			Participante part = participantes.get(key);
			Album alb=part.obtenerAlbum();
			
			if (alb.completoAlbum()) {
	
				listado.append("$dni: ").append(part.obtenerDNI()).append("$nombre: ").append(part.obtenerNombreUsuario())
				.append("$premio: ").append(alb.obtenerPremio()).append ("\n");
			}
			
		}
		return listado.toString();
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

		LinkedList<String> partCompletaronPais= new LinkedList<String>();
		
		for(Integer key : participantes.keySet()) { // recorro todas las keys del diccionario participante
			Participante part = participantes.get(key);
			Album alb=part.obtenerAlbum();
			
			if (alb.completoSeccionPais(nombrePais)) {
				String dato="($dni " +String.valueOf(part.obtenerDNI())+") $nombre: "
				+part.obtenerNombreUsuario()+ " $tipoAlbum "+part.obtenerAlbum();
				
				partCompletaronPais.add(dato);
			}
		}
		return partCompletaronPais;
	}
	
	
	//METODOS AUXILIARES

	private Album generarAlbum(String tipoAlbum) {
		Album album;
		if(tipoAlbum.equals("Web")) {
			album = fabrica.crearAlbumWeb();
		}else {
				if(tipoAlbum.equals("Extendido")){
					album = fabrica.crearAlbumExtendido();
				}else {
					if(tipoAlbum.equals("Tradicional")) {
						album = fabrica.crearAlbumTradicional();
					}else {
						album = null;
					}
				}
		}
		return album;
	}
	
}
