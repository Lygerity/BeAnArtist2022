package fr.eseo.pdlo.projet.artiste.vue.formes;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
import fr.eseo.pdlo.projet.artiste.modele.formes.Cercle;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class VueCercleTest {
	
	public VueCercleTest() {
		testCercle();
	}

	public static void main(String[] args) {
		new VueCercleTest();
	}
	
	private void testCercle() {
		JFrame fenetre = new JFrame("Test Cercle");
		PanneauDessin pannel = new PanneauDessin(350, 350, Color.white);
		pannel.setModeRemplissageCourant(Remplissage.UNIFORME);
		pannel.ajouterVueForme(new VueCercle(new Cercle(new Coordonnees(150, 75), 60)));
		pannel.ajouterVueForme(new VueCercle(new Cercle(new Coordonnees(130, 100), 120)));
		pannel.ajouterVueForme(new VueCercle(new Cercle(new Coordonnees(200, 75), 180)));
		Cercle c1 = new Cercle();
		c1.setCouleur(Color.red);
		c1.setRemplissage(pannel.getModeRemplissageCourant());
		pannel.ajouterVueForme(new VueEllipse(c1));
		fenetre.setSize(new Dimension(400, 400));
		fenetre.add(pannel);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setLocationRelativeTo(null);
		fenetre.pack();
		fenetre.setVisible(true);
	}

}
