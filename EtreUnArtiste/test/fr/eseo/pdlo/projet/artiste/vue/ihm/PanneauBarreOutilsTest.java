package fr.eseo.pdlo.projet.artiste.vue.ihm;

import java.awt.BorderLayout;

import javax.swing.JFrame;


public class PanneauBarreOutilsTest {

	public PanneauBarreOutilsTest() {
		testPanneauBarreOutil();
	}
	
	public static void main(String[] args) {
		new PanneauBarreOutilsTest();
	}
	
	public void testPanneauBarreOutil() {
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
