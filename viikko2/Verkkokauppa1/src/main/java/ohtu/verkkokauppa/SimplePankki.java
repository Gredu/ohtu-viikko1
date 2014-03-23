package ohtu.verkkokauppa;

public interface SimplePankki {

	boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa);
	
}
