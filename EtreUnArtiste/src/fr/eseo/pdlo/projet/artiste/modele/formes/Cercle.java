package fr.eseo.pdlo.projet.artiste.modele.formes;

import java.text.DecimalFormat;
import java.util.Locale;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

public class Cercle extends Ellipse {
	
	public Cercle() {
		super(LARGEUR_PAR_DEFAUT, LARGEUR_PAR_DEFAUT);
	}
	
	public Cercle(Coordonnees position) {
		super(position, LARGEUR_PAR_DEFAUT, LARGEUR_PAR_DEFAUT);
	}
	
	public Cercle(Coordonnees position, double taille) {
		super(position, taille, taille);
	}
	
	public Cercle(double taille) {
		super(taille, taille);
	}
	
	@Override
	public void setLargeur(double largeur) {
		if(largeur < 0) throw new IllegalArgumentException("Une valeur négative est impossible");
		this.largeur = largeur;
		this.hauteur = largeur;
	}
	
	@Override
	public void setHauteur(double hauteur) {
		setLargeur(hauteur);
	}
	
	@Override
	public double perimetre() {
		return Math.PI * getLargeur();
	}
	
	@Override
	public double aire() {
		return Math.PI * Math.pow(getLargeur()/2, 2);
	}
	
	@Override
	public String toString() {
		String rgb;
		if (Locale.getDefault().getLanguage().equals("fr")) {
			rgb = "R" + getCouleur().getRed() + ",V" + getCouleur().getGreen() + ",B" + getCouleur().getBlue();
		} else {
			rgb = "R" + getCouleur().getRed() + ",G" + getCouleur().getGreen() + ",B" + getCouleur().getBlue();

		}
		DecimalFormat form = new DecimalFormat("0.0#");
		return ("[Cercle " + getRemplissage().getMode() + "] :"
                + " pos (" +form.format(getPosition().getAbscisse())+" , "+form.format(getPosition().getOrdonnee())+")"
                + " rayon " +form.format(getLargeur()/2)
                + " périmètre : "+form.format(perimetre())
                + " aire : " + form.format(aire()))
				+ " couleur = " + rgb;
	}

}
