package fr.eseo.pdlo.projet.artiste.vue.formes;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

import fr.eseo.pdlo.projet.artiste.modele.formes.Ligne;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class VueLigneTest {
	
	public VueLigneTest() {
		testLignes();
	}

	public static void main(String[] args) {
		new VueLigneTest();
	}
	
	private void testLignes() {
		JFrame fenetre = new JFrame("Test Lignes");
		PanneauDessin pannel = new PanneauDessin(350, 350, Color.white);
		pannel.ajouterVueForme(new VueLigne(new Ligne()));
		fenetre.setSize(new Dimension(400, 400));
		fenetre.add(pannel);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setLocationRelativeTo(null);
		fenetre.pack();
		fenetre.setVisible(true);
	}

}
