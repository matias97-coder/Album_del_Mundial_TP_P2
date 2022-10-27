package albumMundial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class Fabrica {
	/*La clase Fábrica con los métodos para facilitar la implementación. 
En esta clase les damos ya implementados los métodos que permiten generar 
el valor base de las figuritas, los premios, los países y sus ranking,
 y los datos de los mundiales. También se brindan los 32 países clasificados.*/

	private Random random;

	private String[] premiosInstantaneos;
	private String[] paisesParticipantes;
	private int lugaresPorPais;
	private String[] listadoDeMundialesTop10;
	private Map<String, String[]> balonYPaisPorMundialTop10;
	private Map<String, Integer> ranking;

	public Fabrica() {
		random = new Random(System.currentTimeMillis());
		lugaresPorPais = 12;
		paisesParticipantes = generarPaisesClasificados();
		listadoDeMundialesTop10 = generarListadoDeMundiales();
		balonYPaisPorMundialTop10 = generarPaisesPorMundial();
		ranking = generarRanking();
		premiosInstantaneos = generarPremiosParaSorteoInstantaneo();
	}
	
	////////////////////////////////////////////////////////////////////////
	// NOTA: Deben implementar los siguientes metodos segun su modelo     //
	//       Aprovechando la informacion referida al mundial facilitada   //
	//       por la catedra.                                              //
	//       Solamente deberian deberan usar las variables de clases      //
	//       y el metodo "calcularValorBase" para saber que valor base    //
	//       tendra una figurita en particular.                            //
	////////////////////////////////////////////////////////////////////////

	public Album crearAlbumWeb() {
        throw new RuntimeException("A Implementar");
	}

	public Album crearAlbumExtendido() {
        throw new RuntimeException("A Implementar");
	}

	public Album crearAlbumTradicional() {
		throw new RuntimeException("A Implementar");
	}

	public List<Figurita> generarSobre(int cantFigus) {
		ArrayList<Figurita> sobre= new ArrayList<Figurita>();
		
		Random aleatorio = new Random(System.currentTimeMillis());
		
		for (int i=0;i<cantFigus;i++) {
		
			int pais = aleatorio.nextInt(32); // aleatorio entre 0 y 31 asociado a un paisParticipante
			int codig = aleatorio.nextInt(12); // nro de jugador entre 0 y 11, asociado a un codigo figura
			String paisPart= paisesParticipantes[pais];
			int valorBase=  calcularValorBase(paisPart, codig);
			FiguritaTradicional figTraicional= new 	FiguritaTradicional (codig , valorBase, paisPart, "Jugador "+Integer.toString(codig));
			
			sobre.add(figTraicional);
		}
		return sobre;
	
	}		

	public List<Figurita> generarSobreTop10(int cantFigus) {
		ArrayList<Figurita> sobreTOP10= new ArrayList<Figurita>();
	
		Random aleatorio = new Random(System.currentTimeMillis());
		
		for (int i=0;i<cantFigus;i++) {
			
			int sedeMunial = aleatorio.nextInt(10); // aleatorio entre 0 y 9 asociado a una sedeMundial
			int premio = aleatorio.nextInt(2); // nro de jugador entre 0 y 1,   asociado a una 1er y 2do puesto
			String sedeMundialTOP10= listadoDeMundialesTop10[sedeMunial];

			
			FiguritaTradicional figTraicional=null;
			
			sobreTOP10.add(figTraicional);
		}
		
		return sobreTOP10;
	}


	///////////////////////////////////////////////////////
	///////////// METODOS FACILITADOS POR LA CATEDRA //////
	///////////////////////////////////////////////////////
	
	// Dado el pais y numero de jugador de una figurita calcula
	// cual es su valor base simbobilo.
	
	private int calcularValorBase(String pais, int numero) {
		return ranking.get(pais) + numero;
	}

	private String[] generarPremiosParaSorteoInstantaneo() {
		return new String[]{
				"Una pelota","1 Sobre Gratis", "Una camiseta"
			};
	}

	private String[] generarPaisesClasificados() {
		return new String[]{ 
				"Alemania",   "Arabia Saudita",   "Argentina",          "Australia", 
				"Brasil",     "Belgica",        "CamerÃºn",            "Canada¡", 
				"Costa Rica", "Croacia",        "Dinamarca",          "Ecuador",
				"Espania",     "Estados Unidos", "Francia",            "Gales",
				"Ghana",      "Inglaterra",     "IrÃ¡n",               "Japon", 
				"Marruecos",  "Mexico",         "Paises Bajos",       "Polonia",
				"Portugal",   "Qatar",          "Republica de Corea", "Senegal", 
				"Serbia",     "Suiza",          "Tunez",              "Uruguay" 
			};
	}

	private String[] generarListadoDeMundiales() {
		return new String[] { 
				"España '82",    "Mexico '86", "Italia '90",  "Estados Unidos '94",
				"Francia '98",   "Corea del Sur y JapÃ³n '02", "Alemania '06", 
				"Sudafrica '10", "Brasil '14", "Rusia '18" };
	}

	private Map<String, String[]> generarPaisesPorMundial() {
		Map<String, String[]> ret = new HashMap<>();
		ret.put("Espania '82", new String[] { "Italia", "Brasil" });
		ret.put("Mexico '86", new String[] { "Argentina", "Alemania" });
		ret.put("Italia '90", new String[] { "Italia", "Alemania" });
		ret.put("Estados Unidos '94", new String[] { "Brasil", "Italia" });
		ret.put("Francia '98", new String[] { "Brasil", "Croacia" });
		ret.put("Corea del Sur y Japon '02", new String[] { "Alemania", "Brasil" });
		ret.put("Alemania '06", new String[] { "Francia", "Italia" });
		ret.put("Sudafrica '10", new String[] { "Uruguay", "Paises Bajos" });
		ret.put("Brasil '14", new String[] { "Argentina", "Alemania" });
		ret.put("Rusia '18", new String[] { "Croacia", "BÃ©lgica" });
		return ret;
	}
	
	private Map<String, Integer> generarRanking() {
		Map<String, Integer> ret = new HashMap<>();
		ret.put("Brasil",1);
		ret.put("Belgica",2);
		ret.put("Argentina",3);
		ret.put("Francia",4);
		ret.put("Inglaterra",5);
		ret.put("Italia",6);
		ret.put("Espania",7);
		ret.put("Paises Bajos",8);
		ret.put("Portugal",9);
		ret.put("Dinamarca",10);
		ret.put("Alemania",11);
		ret.put("Croacia",12);
		ret.put("Mexico",13);
		ret.put("Uruguay",14);
		ret.put("Suiza",15);
		ret.put("Estados Unidos",16);
		ret.put("Colombia",17);
		ret.put("Senegal",18);
		ret.put("Gales",19);
		ret.put("Iran",20);
		ret.put("Serbia",21);
		ret.put("Marruecos",22);
		ret.put("Peruº",23);
		ret.put("Japon",24);
		ret.put("Suecia",25);
		ret.put("Polonia",26);
		ret.put("Ucrania",27);
		ret.put("Republica de Corea",28);
		ret.put("Chile",29);
		ret.put("Tanez",30);
		ret.put("Costa Rica",31);
		ret.put("Nigeria",32);
		ret.put("Rusia",33);
		ret.put("Austria",34);
		ret.put("Republica Checa",35);
		ret.put("Hungria",36);
		ret.put("Argelia",37);
		ret.put("Australia",38);
		ret.put("Egipto",39);
		ret.put("Escocia",40);
		ret.put("Canada",41);
		ret.put("Noruega",42);
		ret.put("Camerun",43);
		ret.put("Ecuador",44);
		ret.put("Turquia",45);
		ret.put("Mali",46);
		ret.put("Paraguay",47);
		ret.put("Costa de Marfil",48);
		ret.put("Republica de Irlanda",49);
		ret.put("Qatar",50);
		ret.put("Arabia Saudita",51);
		ret.put("Grecia",52);
		ret.put("Rumania",53);
		ret.put("Burkina Faso",54);
		ret.put("Eslovaquia",55);
		ret.put("Finlandia",56);
		ret.put("Venezuela",57);
		ret.put("Bosnia y Herzegovina",58);
		ret.put("Irlanda del Norte",59);
		ret.put("Panama",60);
		ret.put("Ghana",61);
		ret.put("Islandia",62);
		ret.put("Eslovenia",63);
		ret.put("Jamaica",64);
		ret.put("Macedonia del Norte",65);
		ret.put("Albania",66);
		ret.put("Sudafrica",67);
		ret.put("Irak",68);
		ret.put("Montenegro",69);
		ret.put("Emiratos Arabes Unidos",70);
		ret.put("Cabo Verde",71);
		ret.put("Bulgaria",72);
		ret.put("RD del Congo",73);
		ret.put("El Salvador",74);
		ret.put("OmÃ¡n",75);
		ret.put("Israel",76);
		ret.put("Uzbekistan",77);
		ret.put("Georgia",78);
		ret.put("RP China",79);
		ret.put("Honduras",80);
		ret.put("GabÃ³n",81);
		ret.put("Bolivia",82);
		ret.put("Guinea",83);
		ret.put("Jordania",84);
		ret.put("BahrÃ©in",85);
		ret.put("CuraÃ§ao",86);
		ret.put("HaitÃ­",87);
		ret.put("Zambia",88);
		ret.put("Uganda",89);
		ret.put("Siria",90);
		ret.put("BenÃ­n",91);
		ret.put("Luxemburgo",92);
		ret.put("Armenia",93);
		ret.put("Palestina",94);
		ret.put("RepÃºblica Kirguisa",95);
		ret.put("Vietnam",96);
		ret.put("Bielorrusia",97);
		ret.put("Guinea Ecuatorial",98);
		ret.put("LÃ­bano",99);
		ret.put("Congo",100);
		ret.put("Kenia",101);
		ret.put("Madagascar",102);
		ret.put("Mauritania",103);
		ret.put("Trinidad y Tobago",104);
		ret.put("Nueva Zelanda",105);
		ret.put("India",106);
		ret.put("Kosovo",107);
		ret.put("TayikistÃ¡n",108);
		ret.put("Estonia",109);
		ret.put("Chipre",110);
		ret.put("Tailandia",111);
		ret.put("RDP de Corea",112);
		ret.put("KazajstÃ¡n",113);
		ret.put("Mozambique",114);
		ret.put("Namibia",115);
		ret.put("Guinea-BissÃ¡u",116);
		ret.put("Sierra Leona",117);
		ret.put("Guatemala",118);
		ret.put("Angola",119);
		ret.put("Libia",120);
		ret.put("NÃ­ger",121);
		ret.put("Islas Feroe",122);
		ret.put("AzerbaiyÃ¡n",123);
		ret.put("Malaui",124);
		ret.put("Zimbabue",125);
		ret.put("Gambia",126);
		ret.put("Togo",127);
		ret.put("SudÃ¡n",128);
		ret.put("Comoras",129);
		ret.put("Tanzania",130);
		ret.put("Antigua y Barbuda",131);
		ret.put("RepÃºblica Centroafricana",132);
		ret.put("Filipinas",133);
		ret.put("Letonia",134);
		ret.put("TurkmenistÃ¡n",135);
		ret.put("Islas SalomÃ³n",136);
		ret.put("Ruanda",137);
		ret.put("EtiopÃ­a",138);
		ret.put("Surinam",139);
		ret.put("San CristÃ³bal y Nieves",140);
		ret.put("Burundi",141);
		ret.put("Nicaragua",142);
		ret.put("Esuatini",143);
		ret.put("Lituania",144);
		ret.put("Hong Kong",145);
		ret.put("Malasia",146);
		ret.put("Lesoto",147);
		ret.put("Botsuana",148);
		ret.put("Kuwait",149);
		ret.put("Liberia",150);
		ret.put("Andorra",151);
		ret.put("Indonesia",152);
		ret.put("RepÃºblica Dominicana",153);
		ret.put("Maldivas",154);
		ret.put("Yemen",155);
		ret.put("AfganistÃ¡n",156);
		ret.put("Chinese Taipei",157);
		ret.put("Myanmar",158);
		ret.put("PapÃºa Nueva Guinea",159);
		ret.put("Singapur",160);
		ret.put("Nueva Caledonia",161);
		ret.put("TahitÃ­",162);
		ret.put("Fiyi",163);
		ret.put("Vanuatu",164);
		ret.put("SudÃ¡n del Sur",165);
		ret.put("Barbados",166);
		ret.put("Cuba",167);
		ret.put("Malta",168);
		ret.put("Bermudas",169);
		ret.put("Puerto Rico",170);
		ret.put("Guyana",171);
		ret.put("Santa LucÃ­a",172);
		ret.put("Granada",173);
		ret.put("Moldavia",174);
		ret.put("Nepal",175);
		ret.put("Belice",176);
		ret.put("Camboya",177);
		ret.put("San Vicente y las Granadinas",178);
		ret.put("Montserrat",179);
		ret.put("Mauricio",180);
		ret.put("Chad",181);
		ret.put("Macao",182);
		ret.put("Mongolia",183);
		ret.put("Dominica",184);
		ret.put("ButÃ¡n",185);
		ret.put("Santo TomÃ© y PrÃ­ncipe",186);
		ret.put("Laos",187);
		ret.put("Samoa Estadounidense",188);
		ret.put("Islas Cook",189);
		ret.put("BrunÃ©i Darussalam",190);
		ret.put("Samoa",191);
		ret.put("Bangladesh",192);
		ret.put("Yibuti",193);
		ret.put("PakistÃ¡n",194);
		ret.put("Islas CaimÃ¡n",195);
		ret.put("Liechtenstein",196);
		ret.put("Tonga",197);
		ret.put("Timor Oriental",198);
		ret.put("Seychelles",199);
		ret.put("Eritrea",200);
		ret.put("Aruba",201);
		ret.put("Bahamas",202);
		ret.put("Somalia",203);
		ret.put("Gibraltar",204);
		ret.put("Guam",205);
		ret.put("Turcas y Caicos",206);
		ret.put("Sri Lanka",207);
		ret.put("Islas VÃ­rgenes Estadounidenses",208);
		ret.put("Islas VÃ­rgenes BritÃ¡nicas",209);
		ret.put("Anguila",210);
		ret.put("San Marino",211);
		return ret;
	}

}
