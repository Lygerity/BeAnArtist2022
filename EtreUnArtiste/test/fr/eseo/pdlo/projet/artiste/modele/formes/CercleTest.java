package fr.eseo.pdlo.projet.artiste.modele.formes;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Color;
import java.util.Locale;

import org.junit.jupiter.api.Test;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

public class CercleTest {

	public CercleTest() {

	}

	@Test
	void testConstructeurVide() {
		Cercle c1 = new Cercle();
		assertEquals(45.0, c1.getLargeur());
		assertEquals(45.0, c1.getHauteur());
		assertEquals(0.0, c1.getPosition().getAbscisse());
		assertEquals(0.0, c1.getPosition().getOrdonnee());
	}

	@Test
	void testConstructeurFull() {
		Cercle c1 = new Cercle(new Coordonnees(12.3, 17.6), 56);
		assertEquals(56, c1.getLargeur());
		assertEquals(56, c1.getHauteur());
		assertEquals(12.3, c1.getPosition().getAbscisse());
		assertEquals(17.6, c1.getPosition().getOrdonnee());
	}

	@Test
	void testConstructeurPosition() {
		Cercle c1 = new Cercle(new Coordonnees(12.3, 17.6));
		assertEquals(45.0, c1.getLargeur());
		assertEquals(45.0, c1.getHauteur());
		assertEquals(12.3, c1.getPosition().getAbscisse());
		assertEquals(17.6, c1.getPosition().getOrdonnee());
	}

	@Test
	void testConstructeurLargeur() {
		Cercle c1 = new Cercle(73);
		assertEquals(73, c1.getLargeur());
		assertEquals(73, c1.getHauteur());
		assertEquals(0.0, c1.getPosition().getAbscisse());
		assertEquals(0.0, c1.getPosition().getOrdonnee());
	}

	@Test
	void testFonctions() {
		Cercle c1 = new Cercle(new Coordonnees(10, 10), 50.5);
		assertEquals(158.65, c1.perimetre(), 0.001, "Le périmètre du cercle");
		assertEquals(2002.96, c1.aire(), 0.002, "l'aire du cercle");
	}

	@Test
	void testLargeurNegative() {
		final Exception throw1 = assertThrows(IllegalArgumentException.class, () -> {
			new Cercle(-10);
		});
		assertEquals(throw1.getMessage(), "Une valeur négative est impossible");
	}

	@Test
	void testToString() {
		Cercle c1 = new Cercle(new Coordonnees(10.0, 10.0), 50.5);
		c1.setCouleur(Color.black);
		assertEquals(
				"[Cercle aucune] : pos (10,0 , 10,0) rayon 25,25 périmètre : 158,65 aire : 2002,96 couleur = R0,V0,B0",
				c1.toString());
		
		Locale.setDefault(new Locale("en"));
		assertEquals(
				"[Cercle aucune] : pos (10.0 , 10.0) rayon 25.25 périmètre : 158.65 aire : 2002.96 couleur = R0,G0,B0",
				c1.toString());
	}

}
