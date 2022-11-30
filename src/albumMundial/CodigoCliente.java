package albumMundial;

public class CodigoCliente {

	public static void main(String[] args) {

		IAlbumDelMundial sistema = new AlbumDelMundial();
		
		sistema.registrarParticipante(222222, "Christian", "Tradicional");
		sistema.registrarParticipante(333333, "Mariana", "Extendido");
		sistema.registrarParticipante(111111, "José", "Web");
		sistema.registrarParticipante(555555, "Miguel", "Web");
		sistema.registrarParticipante(666666, "Jazzmine", "Extendido");
		sistema.registrarParticipante(777777, "Dante", "Tradicional");

    	//sistema.comprarFiguritasConCodigoPromocional(333333);
		
		/*
		
		
		// El participante 111111 tiene album Web entonces tiene un codigo
		// promocional para solicitar 4 figuritas sin consto.
		sistema.comprarFiguritasConCodigoPromocional(111111);
		sistema.comprarFiguritas(222222);
		sistema.comprarFiguritas(333333);

/*
 * 
 * 				
		System.out.println("Figus que pego:"+sistema.totalDeFigus(222222));
		// El participante 333333 tiene un album tradicional y por eso puede
		// participar en un sortepo por un premio instantaneo.
		System.out.println(sistema.darNombre(333333) + " recibio por sorteo instantaneo: "
				+ sistema.aplicarSorteoInstantaneo(333333));
		System.out.println();
*/
		
		
		for (int i = 0; i < 700; i++) {
			sistema.comprarFiguritas(222222);
			sistema.comprarFiguritas(777777);
		}
		sistema.intercambiarUnaFiguritaRepetida(222222);

		sistema.pegarFiguritas(333333);

		// Simulamos un uso prolongado del sistema.
		for (int i = 0; i < 700; i++) {
			sistema.comprarFiguritas(222222);
			sistema.pegarFiguritas(222222);
			sistema.comprarFiguritas(555555);
			sistema.pegarFiguritas(555555);
		}

		for (int i = 0; i < 700; i++) {
			sistema.comprarFiguritasTop10(333333);
			sistema.pegarFiguritas(333333);
			sistema.comprarFiguritas(333333);
			//sistema.pegarFiguritas(333333);
		}

		
		if (sistema.llenoAlbum(222222)) {
			
			System.out.println(sistema.darNombre(222222) + " recibio: " + sistema.darPremio(222222));
			System.out.println();
		}

		System.out.println("Llenaron album:");
		System.out.println(sistema.listadoDeGanadores());
		System.out.println();

		System.out.println("Participantes que Llenaron el Pais Argentina:");
		for (String item : sistema.participantesQueCompletaronElPais("Argentina"))
			System.out.println(item);

		System.out.println();
		System.out.println("=================================================");
		System.out.println(sistema);
		
		
	}

}
