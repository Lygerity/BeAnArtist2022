package fr.eseo.pdlo.projet.artiste.vue.formes;

import java.awt.Color;
import java.awt.Graphics2D;

import fr.eseo.pdlo.projet.artiste.modele.formes.Ligne;

public class VueLigne extends VueForme {

	public VueLigne(Ligne ligne) {
		super(ligne);
	}

	@Override
	public void affiche(Graphics2D g2d) {
		Color ancienneCouleur = g2d.getColor();
		g2d.setColor(getForme().getCouleur());
		g2d.drawLine((int) getForme().getPosition().getAbscisse(), (int) getForme().getPosition().getOrdonnee(),
				(int) getForme().getPosition().getAbscisse() + (int) getForme().getLargeur(),
				(int) getForme().getPosition().getOrdonnee() + (int) getForme().getHauteur());
		g2d.setColor(ancienneCouleur);
	}

}
