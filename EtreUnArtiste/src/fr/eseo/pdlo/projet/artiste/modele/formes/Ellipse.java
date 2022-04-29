package fr.eseo.pdlo.projet.artiste.modele.formes;

import java.awt.Color;
import java.text.DecimalFormat;
import java.util.Locale;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.Remplissable;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;

public class Ellipse extends Forme implements Remplissable{
	
	Remplissage remplissage;
	
	public Ellipse() {
		super();
		setRemplissage(Remplissage.AUCUNE);
	}
	
	public Ellipse(Coordonnees position) {
		super(position);
		setRemplissage(Remplissage.AUCUNE);
	}
	
	public Ellipse(double largeur, double hauteur) {
		super(largeur, hauteur);
		setRemplissage(Remplissage.AUCUNE);
	}
	
	public Ellipse(Coordonnees position, double largeur, double hauteur) {
		super(position, largeur, hauteur);
		setRemplissage(Remplissage.AUCUNE);
	}
	
	@Override
	public void setLargeur(double largeur){
		if(largeur < 0) throw new IllegalArgumentException("Une valeur négative est impossible");
		this.largeur = largeur;
	}
	
	@Override
	public void setHauteur(double hauteur) {
		if(hauteur < 0) throw new IllegalArgumentException("Une valeur négative est impossible");
		this.hauteur = hauteur;
	}
	
	@Override
	public String toString() {
		DecimalFormat form = new DecimalFormat("0.0#");
		double petitRayon;
		double grandRayon;
		String rgb;
		if(getHauteur()>getLargeur()) {
			petitRayon = getLargeur()/2;
			grandRayon = getHauteur()/2;
		}else {
			petitRayon = getHauteur()/2;
			grandRayon = getLargeur()/2;
		}
		
		if (Locale.getDefault().getLanguage().equals("fr")) {
			rgb = "R" + getCouleur().getRed() + ",V" + getCouleur().getGreen() + ",B" + getCouleur().getBlue();
		} else {
			rgb = "R" + getCouleur().getRed() + ",G" + getCouleur().getGreen() + ",B" + getCouleur().getBlue();

		}
		return ("[Ellipse " + getRemplissage().getMode() + "] :"
                + " pos (" +form.format(getPosition().getAbscisse())+" , "+form.format(getPosition().getOrdonnee())+")"
                + " petit rayon " +form.format(petitRayon)
                + " grand rayon " + form.format(grandRayon)
                + " périmètre : "+form.format(perimetre())
                + " aire : " + form.format(aire()))
				+ " couleur = " + rgb;
	}
	

	@Override
	public double aire() {
		return Math.PI * getLargeur()/2 * getHauteur()/2;
	}

	@Override
	public double perimetre() {
		double a = getHauteur()/2;
		double b = getLargeur()/2;
		double h = Math.pow((a-b) / (a + b), 2);
		return Math.PI * (b + a) * (1 + (3 * h)/(10 + Math.sqrt(4 - 3*h)));
	}

	@Override
	public boolean contient(Coordonnees point) {
		double x = point.getAbscisse();
		double y = point.getOrdonnee();
		double demiAxeX = getLargeur()/2;
		double demiAxeY = getHauteur()/2;
		double xCentre = getPosition().getAbscisse() + demiAxeX;
		double yCentre = getPosition().getOrdonnee() + demiAxeY;
		if(Math.pow((x - xCentre) / demiAxeX, 2) + Math.pow((y - yCentre) / demiAxeY, 2) < 1) return true;
		return false;
	}

	@Override
	public Color getCouleur() {
		return couleur;
	}

	@Override
	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}

	@Override
	public Remplissage getRemplissage() {
		return remplissage;
	}

	@Override
	public void setRemplissage(Remplissage modeRemplissage) {
		this.remplissage = modeRemplissage;
	}

}
