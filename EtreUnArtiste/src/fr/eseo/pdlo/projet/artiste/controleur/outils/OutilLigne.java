package fr.eseo.pdlo.projet.artiste.controleur.outils;

import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
import fr.eseo.pdlo.projet.artiste.modele.formes.Ligne;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueLigne;

public class OutilLigne extends OutilForme {
	private Remplissage remplissage = null;
	public OutilLigne() {}

	@Override
	protected VueForme creerVueForme() {
		VueLigne vueLigne;
		if (getFin() != null) {
			Ligne ligne = new Ligne(getDebut(),
					getFin().getAbscisse() - getDebut().getAbscisse(),
					getFin().getOrdonnee() - getDebut().getOrdonnee());
			ligne.setCouleur(getPanneauDessin().getCouleurCourante());
			vueLigne = new VueLigne(ligne);
		} else {
			Ligne ligne = new Ligne(getDebut());
			ligne.setCouleur(getPanneauDessin().getCouleurCourante());
			vueLigne = new VueLigne(ligne);
		}
		return vueLigne;
	}
	
	public Remplissage getRemplissage() {
		return remplissage;
	}

}
