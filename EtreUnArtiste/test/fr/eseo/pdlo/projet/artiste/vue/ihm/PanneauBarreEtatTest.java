package fr.eseo.pdlo.projet.artiste.vue.ihm;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilLigne;

public class PanneauBarreEtatTest {
	
	public PanneauBarreEtatTest() {
		testPanneauBarreEtat();
	}
		
	public static void main(String[] args) {
		new PanneauBarreEtatTest();
	}
	
	public void testPanneauBarreEtat() {
		JFrame fenetre = new JFrame("Etre un Artiste");
		PanneauDessin pannel = new PanneauDessin();
		fenetre.add(pannel, BorderLayout.CENTER);
		OutilLigne outil = new OutilLigne();
		pannel.associerOutil(outil);
		fenetre.add(new PanneauBarreEtat(pannel), BorderLayout.SOUTH);
		fenetre.setSize(700, 700);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setLocationRelativeTo(null);
		fenetre.pack();
		fenetre.setVisible(true);
	}
}
