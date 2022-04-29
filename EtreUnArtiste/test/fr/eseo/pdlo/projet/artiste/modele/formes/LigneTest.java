package fr.eseo.pdlo.projet.artiste.modele.formes;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Color;
import java.util.Locale;

import org.junit.jupiter.api.Test;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

public class LigneTest {

	public LigneTest() {
	}

	@Test
	void testConstructeurVide() {
		Ligne l1 = new Ligne();
		assertEquals(45.0, l1.getLargeur());
		assertEquals(15.0, l1.getHauteur());
		assertEquals(0.0, l1.getPosition().getAbscisse());
		assertEquals(0.0, l1.getPosition().getOrdonnee());
	}

	@Test
	void testConstructeurFull() {
		Ligne l1 = new Ligne(new Coordonnees(12.3, 17.6), 56, 73);
		assertEquals(56, l1.getLargeur());
		assertEquals(73, l1.getHauteur());
		assertEquals(12.3, l1.getPosition().getAbscisse());
		assertEquals(17.6, l1.getPosition().getOrdonnee());
	}

	@Test
	void testConstructeurPosition() {
		Ligne l1 = new Ligne(new Coordonnees(12.3, 17.6));
		assertEquals(45.0, l1.getLargeur());
		assertEquals(15.0, l1.getHauteur());
		assertEquals(12.3, l1.getPosition().getAbscisse());
		assertEquals(17.6, l1.getPosition().getOrdonnee());
	}

	@Test
	void testConstructeurLargeur() {
		Ligne l1 = new Ligne(56, 73);
		assertEquals(56, l1.getLargeur());
		assertEquals(73, l1.getHauteur());
		assertEquals(0.0, l1.getPosition().getAbscisse());
		assertEquals(0.0, l1.getPosition().getOrdonnee());
	}

	@Test
	void testFonctions() {
		Ligne l1 = new Ligne(new Coordonnees(12.3, 17.6), 56, 73);
		assertEquals(12.3, l1.getC1().getAbscisse());
		assertEquals(17.6, l1.getC1().getOrdonnee());
		assertEquals(68.3, l1.getC2().getAbscisse());
		assertEquals(90.6, l1.getC2().getOrdonnee());
		assertEquals(56.0, l1.getLargeur());
		assertEquals(73.0, l1.getHauteur());
		l1.setC1(new Coordonnees());
		assertEquals(0.0, l1.getC1().getAbscisse());// Test C1 apres deplacement
		assertEquals(0.0, l1.getC1().getOrdonnee());
		assertEquals(68.3, l1.getC2().getAbscisse());// Test C2 apres deplacement
		assertEquals(90.6, l1.getC2().getOrdonnee());
		assertEquals(68.3, l1.getLargeur());
		assertEquals(90.6, l1.getHauteur());
		l1.setC2(new Coordonnees(10.0, 10.0));
		assertEquals(0.0, l1.getC1().getAbscisse());// Test C1 apres deplacement
		assertEquals(0.0, l1.getC1().getOrdonnee());
		assertEquals(10.0, l1.getC2().getAbscisse());// Test C2 apres deplacement
		assertEquals(10.0, l1.getC2().getOrdonnee());
		assertEquals(10.0, l1.getLargeur());
		assertEquals(10.0, l1.getHauteur());
		assertEquals(0.0, l1.aire());
		assertEquals(14.142, l1.perimetre(), 0.002);
	}

	@Test
	void testToString() {
		Ligne l1 = new Ligne(new Coordonnees(10.0, 10.0), -5.0, 20.0);
		l1.setCouleur(Color.black);
		assertEquals("[Ligne] c1 : (10,0 , 10,0) c2 : (5,0 , 30,0) longueur : 20,62 angle : 104,04° couleur = R0,V0,B0",
				l1.toString());
		Locale.setDefault(new Locale("en"));
		assertEquals("[Ligne] c1 : (10.0 , 10.0) c2 : (5.0 , 30.0) longueur : 20.62 angle : 104.04° couleur = R0,G0,B0",
				l1.toString());
	}

	@Test
	void testContient() {
		Ligne l1 = new Ligne();
		assertEquals(true, l1.contient(new Coordonnees(45, 15)));
	}

	@Test
	void testNeContientPas() {
		Ligne l1 = new Ligne();
		assertFalse(l1.contient(new Coordonnees(-6, 12)));
	}
	
	@Test
	void testFormes() {
		Ligne l1 = new Ligne(15, 10);
		assertEquals(0.0, l1.getCadreMinX());
		assertEquals(0.0, l1.getCadreMinY());
		assertEquals(15.0, l1.getCadreMaxX());
		assertEquals(10.0, l1.getCadreMaxY());
		l1.deplacerDe(15, 15);
		assertEquals(15.0, l1.getPosition().getAbscisse());
		assertEquals(15.0, l1.getPosition().getOrdonnee());
		l1.deplacerVers(5, 5);
		assertEquals(5.0, l1.getPosition().getAbscisse());
		assertEquals(5.0, l1.getPosition().getOrdonnee());
		
		Ligne l2 = new Ligne(-5, -10);
		assertEquals(-5.0, l2.getCadreMinX());
		assertEquals(-10.0, l2.getCadreMinY());
		assertEquals(0.0, l2.getCadreMaxX());
		assertEquals(0.0, l2.getCadreMaxY());
	}
}
