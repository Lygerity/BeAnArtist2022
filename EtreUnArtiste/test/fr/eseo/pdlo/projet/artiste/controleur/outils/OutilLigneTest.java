package fr.eseo.pdlo.projet.artiste.controleur.outils;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class OutilLigneTest {
	
	public OutilLigneTest() {
		testOutilLigne();
	}

	public static void main(String[] args) {
		new OutilLigneTest();
	}
	
	public void testOutilLigne() {
		JFrame fenetre = new JFrame("Etre un Artiste");
		PanneauDessin pannel = new PanneauDessin();
		fenetre.add(pannel, BorderLayout.CENTER);
		fenetre.setSize(300, 400);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setLocationRelativeTo(null);
		OutilLigne outil = new OutilLigne();
		pannel.associerOutil(outil);		
		fenetre.pack();
		fenetre.setVisible(true);
	}
}
