package fr.eseo.pdlo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;

public abstract class OutilForme extends Outil {
	
	public void mouseClicked(MouseEvent event) {
		if(event.getClickCount() == 2) {
			setFin(null);
			getPanneauDessin().ajouterVueForme(creerVueForme());
			getPanneauDessin().repaint();
		}
	}
	
	public void mouseReleased(MouseEvent event) {
		if(event.getX() != getDebut().getAbscisse() || event.getY() != getDebut().getOrdonnee()) {
			setFin(new Coordonnees(event.getX(), event.getY()));
			getPanneauDessin().ajouterVueForme(creerVueForme());
			getPanneauDessin().repaint();
		}
	}
	
	protected abstract VueForme creerVueForme();
	
}
