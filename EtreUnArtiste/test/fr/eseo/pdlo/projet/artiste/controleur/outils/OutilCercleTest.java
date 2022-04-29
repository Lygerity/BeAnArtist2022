package fr.eseo.pdlo.projet.artiste.controleur.outils;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauBarreEtat;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class OutilCercleTest {
	
	public OutilCercleTest() {
		testOutilCercle();
	}

	public static void main(String[] args) {
		new OutilCercleTest();
	}
	
	public void testOutilCercle() {
		JFrame fenetre = new JFrame("Etre un Artiste");
		PanneauDessin pannel = new PanneauDessin();
		fenetre.add(pannel, BorderLayout.CENTER);
		OutilCercle outil = new OutilCercle();
		pannel.associerOutil(outil);
		fenetre.add(new PanneauBarreOutils(pannel), BorderLayout.EAST);
		fenetre.add(new PanneauBarreEtat(pannel), BorderLayout.SOUTH);
		fenetre.setSize(700, 700);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setLocationRelativeTo(null);
		fenetre.pack();
		fenetre.setVisible(true);
	}

}
