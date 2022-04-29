package fr.eseo.pdlo.projet.artiste.vue.formes;

import java.awt.Color;
import java.awt.Graphics2D;

import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
import fr.eseo.pdlo.projet.artiste.modele.formes.Ellipse;

public class VueEllipse extends VueForme {
	private Remplissage modeRemplissage;

	public VueEllipse(Ellipse ellipse) {
		super(ellipse);
		this.modeRemplissage = ellipse.getRemplissage();

	}

	@Override
	public void affiche(Graphics2D g2d) {
		Color ancienneCouleur = g2d.getColor();
		g2d.setColor(getForme().getCouleur());
		if (modeRemplissage.getMode().equals("uniforme")) {
			g2d.fillOval((int) getForme().getPosition().getAbscisse(), (int) getForme().getPosition().getOrdonnee(),
					(int) getForme().getLargeur(), (int) getForme().getHauteur());
		}
		g2d.drawOval((int) getForme().getPosition().getAbscisse(), (int) getForme().getPosition().getOrdonnee(),
				(int) getForme().getLargeur(), (int) getForme().getHauteur());		
		g2d.setColor(ancienneCouleur);

	}

}
