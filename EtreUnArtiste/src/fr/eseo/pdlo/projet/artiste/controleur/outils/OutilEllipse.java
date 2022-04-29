package fr.eseo.pdlo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Ellipse;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueEllipse;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;

public class OutilEllipse extends OutilForme {

	public OutilEllipse() {
	}

	@Override
	protected VueForme creerVueForme() {
		VueEllipse vueEllipse;
			if (getDebut().getOrdonnee() > getFin().getOrdonnee()
					&& getDebut().getAbscisse() < getFin().getAbscisse()) {
				Ellipse ellipse = new Ellipse(new Coordonnees(getDebut().getAbscisse(), getFin().getOrdonnee()),
						getFin().getAbscisse() - getDebut().getAbscisse(),
						getDebut().getOrdonnee() - getFin().getOrdonnee());
				ellipse.setCouleur(getPanneauDessin().getCouleurCourante());
				ellipse.setRemplissage(getPanneauDessin().getModeRemplissageCourant());
				vueEllipse = new VueEllipse(ellipse);

			} else if (getDebut().getOrdonnee() > getFin().getOrdonnee()
					&& getDebut().getAbscisse() > getFin().getAbscisse()) {
				Ellipse ellipse = new Ellipse(getFin(), getDebut().getAbscisse() - getFin().getAbscisse(),
						getDebut().getOrdonnee() - getFin().getOrdonnee());
				ellipse.setCouleur(getPanneauDessin().getCouleurCourante());
				ellipse.setRemplissage(getPanneauDessin().getModeRemplissageCourant());
				vueEllipse = new VueEllipse(ellipse);

			} else if (getDebut().getOrdonnee() < getFin().getOrdonnee()
					&& getDebut().getAbscisse() > getFin().getAbscisse()) {
				Ellipse ellipse = new Ellipse(new Coordonnees(getFin().getAbscisse(), getDebut().getOrdonnee()),
						getDebut().getAbscisse() - getFin().getAbscisse(),
						getFin().getOrdonnee() - getDebut().getOrdonnee());
				ellipse.setCouleur(getPanneauDessin().getCouleurCourante());
				ellipse.setRemplissage(getPanneauDessin().getModeRemplissageCourant());
				vueEllipse = new VueEllipse(ellipse);

			} else {
				Ellipse ellipse = new Ellipse(getDebut(), getFin().getAbscisse() - getDebut().getAbscisse(),
						getFin().getOrdonnee() - getDebut().getOrdonnee());
				ellipse.setCouleur(getPanneauDessin().getCouleurCourante());
				ellipse.setRemplissage(getPanneauDessin().getModeRemplissageCourant());
				vueEllipse = new VueEllipse(ellipse);
			}

		return vueEllipse;
	}
	
	@Override
	public void mouseClicked(MouseEvent event) {
		if(event.getClickCount() == 2) {
			Ellipse ellipse = new Ellipse(getDebut());
			ellipse.setCouleur(getPanneauDessin().getCouleurCourante());
			ellipse.setRemplissage(getPanneauDessin().getModeRemplissageCourant());
			VueEllipse vueEllipse = new VueEllipse(ellipse);
			getPanneauDessin().ajouterVueForme(vueEllipse);
			getPanneauDessin().repaint();
		}
	}

}
