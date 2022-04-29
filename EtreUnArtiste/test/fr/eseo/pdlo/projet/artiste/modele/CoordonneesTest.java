package fr.eseo.pdlo.projet.artiste.modele;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CoordonneesTest {
	
	public CoordonneesTest() {
		
	}

	@Test
	public void testConstructeurVide() {
		Coordonnees coor = new Coordonnees();
		assertEquals(0.0, coor.getAbscisse());
		assertEquals(0.0, coor.getAbscisse());
	}
	
	@Test
	public void testConstructeur2() {
		Coordonnees coor = new Coordonnees(15.3, 18.4);
		assertEquals(15.3, coor.getAbscisse());
		assertEquals(18.4, coor.getOrdonnee());
	}
	
	@Test
	public void testDeplacerVers() {
		Coordonnees coor = new Coordonnees();
		coor.deplacerVers(18.2, 12.9);
		assertEquals(18.2, coor.getAbscisse());
		assertEquals(12.9, coor.getOrdonnee());
	}
	
	@Test
	public void testDeplacerDe() {
		Coordonnees coor = new Coordonnees();
		coor.deplacerDe(6.3, 2.8);
		
		assertEquals(6.3, coor.getAbscisse());
		assertEquals(2.8, coor.getOrdonnee());
	}
	
	@Test
	public void testDistanceVers() {
		Coordonnees coor1 = new Coordonnees(0.0, 2.0);
		Coordonnees coor2 = new Coordonnees(2.0, 0.0);
		assertEquals(2.828, coor1.distanceVers(coor2), 0.0005);
		assertEquals(-0.785, coor1.angleVers(coor2), 0.0005);
	}
	
	@Test
	public void testToString() {
		Coordonnees coor1 = new Coordonnees(500.894, 12);
		assertEquals("(500,89 , 12,0)", coor1.toString());
	}
	
	
}
