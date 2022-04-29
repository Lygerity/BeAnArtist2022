package fr.eseo.pdlo.projet.artiste.vue.ihm;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

public class PanneauDessinTest {
	
	public PanneauDessinTest() {
		testConstructeurParDefaut();
		testConstructeur();
	}

	public static void main(String[] args) {
		new PanneauDessinTest();
	}
	
	private void testConstructeurParDefaut() {
		JFrame fenetre = new JFrame("Etre un Artiste");
		fenetre.add(new PanneauDessin(), BorderLayout.CENTER);
		fenetre.setSize(300, 400);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setLocationRelativeTo(null);
		fenetre.pack();
		fenetre.setVisible(true);
	}
	
	private void testConstructeur() {
		JFrame fenetre = new JFrame("Blues du Businessman");
		fenetre.add(new PanneauDessin(500, 350, Color.blue), BorderLayout.CENTER);
		fenetre.setSize(550, 400);
		fenetre.setLocationRelativeTo(null);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.pack();
		fenetre.setVisible(true);
	}

}
