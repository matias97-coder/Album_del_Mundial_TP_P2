package albumMundial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
		if(!participantes.containsKey(dni)) 
			throw new RuntimeException("Participante no esta registrado");
		
		Participante part= participantes.get(dni);
		Album album=part.obtenerAlbum();
		
		if (album instanceof AlbumWeb) { 
			if (!((AlbumWeb)album).estaCodigoPromocionalUtilizado()) {
				part.agregarFiguritasASuColeccion(fabrica.generarSobre(4));
				((AlbumWeb)album).usarCodigoPromocional(null); // el codig promocional pasa ser null				
			}else {
				throw new RuntimeException("El codigo promocional ya fue utilizado");
			}
		}else {
			throw new RuntimeException("El participante no tiene codigo promocional");
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
		if(!participantes.containsKey(dni)) 
			throw new RuntimeException("Participante no esta registrado");
		
		Participante participante = participantes.get(dni);
		
		return participante.figuritasPegadas();
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
		
		return participantes.get(dni).poseeAlbumCompleto();
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
		
		if(! (participantes.containsKey(dni)) )
			throw new RuntimeException("Participante no está registrado");
		
		Participante part = participantes.get(dni);
		Album album = part.obtenerAlbum();

		if( ! (album instanceof AlbumTradicional))
			throw new RuntimeException("El album "+ part.tipoAlbum()+" no posee nro de sorteo");
		
		if (((AlbumTradicional) album).obtenerCodigoAlbum() == -1)
			throw new RuntimeException("El codigo ya fue sorteado");
		
		
		((AlbumTradicional) album).actualizarNumeroSorteo(-1); // seteamos el valor a -1, pasar a ser utilizado
				
	 return fabrica.obtenerUnPremioInstantaneo();
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
		if(!participantes.containsKey(dni))
			throw new RuntimeException("Participante no registrado");
		return participantes.get(dni).obtenerUnCodigoFiguritaRepetida();
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
		
		if(codFigurita==-1)
			return false;
		
		if(!participantes.containsKey(dni))
			throw new RuntimeException("Participante no registrado");
		
		Participante participante_A = participantes.get(dni);
		ArrayList<Figurita> figuritasMenorIgualValor = new ArrayList<Figurita>();

		// Figurita que da el participante A
		Figurita figuritaADar = participante_A.tieneFiguritaEnColeccion(codFigurita);
	
		Iterator<Map.Entry<Integer,Participante>> it = participantes.entrySet().iterator();
		
		while(it.hasNext() ) {
			Map.Entry<Integer,Participante> participanteABuscar =it.next();
			
		    Participante participante_B = participanteABuscar.getValue(); //valor
		    
			if(!participante_A.equals(participante_B) && participante_A.obtenerAlbum().equals(participante_B.obtenerAlbum())) {
				
				figuritasMenorIgualValor = participante_B.obtenerFiguritasIgualMenorValor(figuritaADar.calcularValorFinal());
				
				
				// Figurita que da el participante B
				Figurita figuritaAIntercambiar = participante_A.AlgunaFiguritaSinPegarEnAlbum(figuritasMenorIgualValor);
				
				if(figuritaAIntercambiar!=null) {
		
					participante_A.intercambiarFigurita(figuritaADar, figuritaAIntercambiar);
					participante_B.intercambiarFigurita(figuritaAIntercambiar, figuritaADar);
					return true;
				}
			}
		}
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
		if(!participantes.containsKey(dni))
			throw new RuntimeException("Participante no registrado");

		int codFigRep= buscarFiguritaRepetida(dni);		
		return intercambiar(dni, codFigRep);
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
		
		if(!participantes.containsKey(dni)) 
			throw new RuntimeException("Participante no esta registrado");
		
		Participante part= participantes.get(dni);
		Album album = part.obtenerAlbum();
		
		if (!album.completoAlbum())
			throw new RuntimeException("El participante "+part.obtenerNombreUsuario()+" no tiene el album Completo");
		
		part.cargarPremio(album.obtenerPremio());
		
		return part.premioObtenido();
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
	
				listado.append("dni: ").append(part.obtenerDNI()).append(" | nombre: ").append(part.obtenerNombreUsuario())
				.append(" | premio: ").append(alb.obtenerPremio()).append ("\n");
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

			String dato;
			if (part.completoUnaSeccion(nombrePais)) {
				 dato="(dni " +String.valueOf(part.obtenerDNI())+") |nombre: "+part.obtenerNombreUsuario()+ " |tipoAlbum "+part.tipoAlbum();
				
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
