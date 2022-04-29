package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauBarreEtat;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;


public class ActionChoisirCouleurTest {

	public ActionChoisirCouleurTest() {
		testActionChoisirCouleur();
	}
	
	public static void main(String[] args) {
		new ActionChoisirCouleurTest();
	}
	
	public void testActionChoisirCouleur() {
		JFrame fenetre = new JFrame("Etre un Artiste");
		PanneauDessin pannel = new PanneauDessin();
		fenetre.add(pannel, BorderLayout.CENTER);
		fenetre.add(new PanneauBarreOutils(pannel), BorderLayout.EAST);
		fenetre.add(new PanneauBarreEtat(pannel), BorderLayout.SOUTH);
		fenetre.setSize(700, 700);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setLocationRelativeTo(null);
		fenetre.pack();
		fenetre.setVisible(true);
	}

}
