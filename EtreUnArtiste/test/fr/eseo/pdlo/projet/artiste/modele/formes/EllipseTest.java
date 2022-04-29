package fr.eseo.pdlo.projet.artiste.modele.formes;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Color;
import java.util.Locale;

import org.junit.jupiter.api.Test;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;

public class EllipseTest {

	public double delta = 0.003;

	public EllipseTest() {

	}

	@Test
	void testConstructeurVide() {
		Ellipse e1 = new Ellipse();
		assertEquals(45.0, e1.getLargeur());
		assertEquals(15.0, e1.getHauteur());
		assertEquals(0.0, e1.getPosition().getAbscisse());
		assertEquals(0.0, e1.getPosition().getOrdonnee());
	}

	@Test
	void testConstructeurFull() {
		Ellipse e1 = new Ellipse(new Coordonnees(12.3, 17.6), 56, 73);
		assertEquals(56, e1.getLargeur());
		assertEquals(73, e1.getHauteur());
		assertEquals(12.3, e1.getPosition().getAbscisse());
		assertEquals(17.6, e1.getPosition().getOrdonnee());
	}

	@Test
	void testConstructeurPosition() {
		Ellipse e1 = new Ellipse(new Coordonnees(12.3, 17.6));
		assertEquals(45.0, e1.getLargeur());
		assertEquals(15.0, e1.getHauteur());
		assertEquals(12.3, e1.getPosition().getAbscisse());
		assertEquals(17.6, e1.getPosition().getOrdonnee());
	}

	@Test
	void testConstructeurLargeur() {
		Ellipse e1 = new Ellipse(56, 73);
		assertEquals(56, e1.getLargeur());
		assertEquals(73, e1.getHauteur());
		assertEquals(0.0, e1.getPosition().getAbscisse());
		assertEquals(0.0, e1.getPosition().getOrdonnee());
	}

	@Test
	void testFonctions() {
		Ellipse e1 = new Ellipse(new Coordonnees(10, 10), 25, 15);
		assertEquals(63.82, e1.perimetre(), delta, "Le calcul du périmètre");
		assertEquals(294.524, e1.aire(), delta, "Le calcul de l'aire");
	}

	@Test
	void testLargeurNegative() {
		try {
			new Ellipse(-10, 15);
		}catch(Exception illegalArgumentException) {
			assertTrue("Une valeur négative est impossible", true);
		}
		
		try {
			new Ellipse(10, -15);
		}catch(Exception illegalArgumentException){
			assertTrue("Une valeur négative est impossible", true);
		}
	}

	@Test
	void testContient() {
		Ellipse e1 = new Ellipse();
		assertTrue(e1.contient(new Coordonnees(20, 7)));
		assertFalse(e1.contient(new Coordonnees()));
	}

	@Test
	void testToString() {
		Ellipse e1 = new Ellipse(new Coordonnees(10.0, 10.0), 25, 15);
		e1.setCouleur(Color.black);
		assertEquals(
				"[Ellipse aucune] : pos (10,0 , 10,0) petit rayon 7,5 grand rayon 12,5 "
				+ "périmètre : 63,82 aire : 294,52 couleur = R0,V0,B0",
				e1.toString());
		Ellipse e2 = new Ellipse(new Coordonnees(10.0, 10.0), 15, 25);
		e2.setRemplissage(Remplissage.UNIFORME);
		assertEquals(
				"[Ellipse uniforme] : pos (10,0 , 10,0) petit rayon 7,5 grand rayon 12,5 "
				+ "périmètre : 63,82 aire : 294,52 couleur = R51,V51,B51",
				e2.toString());
		
		Locale.setDefault(new Locale("en"));
		assertEquals(
				"[Ellipse uniforme] : pos (10.0 , 10.0) petit rayon 7.5 grand rayon 12.5 "
				+ "périmètre : 63.82 aire : 294.52 couleur = R51,G51,B51",
				e2.toString());
	}

}
