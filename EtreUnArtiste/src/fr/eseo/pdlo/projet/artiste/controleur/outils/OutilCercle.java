package fr.eseo.pdlo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Cercle;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueCercle;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;

public class OutilCercle extends OutilForme {

	public OutilCercle() {
	}

	@Override
	protected VueForme creerVueForme() {
		VueCercle vueCercle;
			if (getDebut().getOrdonnee() > getFin().getOrdonnee()
					&& getDebut().getAbscisse() < getFin().getAbscisse()) {
				
				double largeur = Math.max(getFin().getAbscisse() - getDebut().getAbscisse(),
						getDebut().getOrdonnee() - getFin().getOrdonnee());
				Cercle cercle = new Cercle(
						new Coordonnees(getDebut().getAbscisse(), getDebut().getOrdonnee() - largeur), largeur);
				cercle.setCouleur(getPanneauDessin().getCouleurCourante());
				cercle.setRemplissage(getPanneauDessin().getModeRemplissageCourant());
				vueCercle = new VueCercle(cercle);

			} else if (getDebut().getOrdonnee() > getFin().getOrdonnee()
					&& getDebut().getAbscisse() > getFin().getAbscisse()) {
				
				double largeur = Math.max(getDebut().getAbscisse() - getFin().getAbscisse(),
						getDebut().getOrdonnee() - getFin().getOrdonnee());
				Cercle cercle = new Cercle(
						new Coordonnees((getDebut().getAbscisse() - largeur), (getDebut().getOrdonnee()) - largeur),
						largeur);
				cercle.setCouleur(getPanneauDessin().getCouleurCourante());
				cercle.setRemplissage(getPanneauDessin().getModeRemplissageCourant());
				vueCercle = new VueCercle(cercle);

			} else if (getDebut().getOrdonnee() < getFin().getOrdonnee()
					&& getDebut().getAbscisse() > getFin().getAbscisse()) {

				double largeur = Math.max(getDebut().getAbscisse() - getFin().getAbscisse(),
						getFin().getOrdonnee() - getDebut().getOrdonnee());
				Cercle cercle = new Cercle(
						new Coordonnees((getDebut().getAbscisse() - largeur), getDebut().getOrdonnee()), largeur);
				cercle.setCouleur(getPanneauDessin().getCouleurCourante());
				cercle.setRemplissage(getPanneauDessin().getModeRemplissageCourant());
				vueCercle = new VueCercle(cercle);

			} else {
				Cercle cercle = new Cercle(getDebut(), Math.max(getFin().getAbscisse() - getDebut().getAbscisse(),
						getFin().getOrdonnee() - getDebut().getOrdonnee()));
				cercle.setCouleur(getPanneauDessin().getCouleurCourante());
				cercle.setRemplissage(getPanneauDessin().getModeRemplissageCourant());
				vueCercle = new VueCercle(cercle);
			}
			return vueCercle;
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		if (event.getClickCount() == 2) {
			Cercle cercle = new Cercle(getDebut());
			cercle.setCouleur(getPanneauDessin().getCouleurCourante());
			cercle.setRemplissage(getPanneauDessin().getModeRemplissageCourant());
			VueCercle vueCercle = new VueCercle(cercle);
			getPanneauDessin().ajouterVueForme(vueCercle);
			getPanneauDessin().repaint();
		}
	}

}
