/*
 * Created by Louison Tendron in April 2022
 * ESEO 2021-2022
 */

package fr.eseo.pdlo.projet.artiste;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauBarreEtat;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class EtreUnArtiste {
	
	private EtreUnArtiste() {
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
	
	private EtreUnArtiste(String titre, String largeur, String hauteur) {
		JFrame fenetre = new JFrame(titre);
		PanneauDessin pannel = new PanneauDessin();
		fenetre.add(pannel, BorderLayout.CENTER);
		try {
			int largeurVoulue = Integer.valueOf(largeur);
			int hauteurVoulue = Integer.valueOf(hauteur);
			pannel.setSize(largeurVoulue, hauteurVoulue);
			fenetre.setSize(largeurVoulue + 60, hauteurVoulue + 220);
		}catch(Exception NumberFormatException) {
			fenetre.setSize(700, 700);
		}
		
		fenetre.add(new PanneauBarreOutils(pannel), BorderLayout.EAST);
		fenetre.add(new PanneauBarreEtat(pannel), BorderLayout.SOUTH);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setLocationRelativeTo(null);
		fenetre.pack();
		fenetre.setVisible(true);
	}

	public static void main(String[] args) {
		if(args.length == 0)new EtreUnArtiste();
		else new EtreUnArtiste(args[0], args[1], args[2]);
		}
	}

