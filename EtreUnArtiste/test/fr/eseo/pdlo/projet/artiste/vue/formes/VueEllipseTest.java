package fr.eseo.pdlo.projet.artiste.vue.formes;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
import fr.eseo.pdlo.projet.artiste.modele.formes.Ellipse;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class VueEllipseTest {
	
	public VueEllipseTest() {
		testEllipse();
	}

	public static void main(String[] args) {
		new VueEllipseTest();
	}
	
	private void testEllipse() {
		JFrame fenetre = new JFrame("Test Ellipse");
		PanneauDessin pannel = new PanneauDessin(350, 350, Color.white);
		pannel.setModeRemplissageCourant(Remplissage.UNIFORME);
		pannel.ajouterVueForme(new VueEllipse(new Ellipse(new Coordonnees(150, 75), 75, 60)));
		pannel.ajouterVueForme(new VueEllipse(new Ellipse(new Coordonnees(130, 100), 45, 120)));
		pannel.ajouterVueForme(new VueEllipse(new Ellipse(new Coordonnees(200, 75), 75, 180)));
		Ellipse e1 = new Ellipse();
		e1.setCouleur(Color.red);
		e1.setRemplissage(pannel.getModeRemplissageCourant());
		pannel.ajouterVueForme(new VueEllipse(e1));
		fenetre.setSize(new Dimension(400, 400));
		fenetre.add(pannel);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setLocationRelativeTo(null);
		fenetre.pack();
		fenetre.setVisible(true);
	}

}
