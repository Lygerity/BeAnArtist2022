package fr.eseo.pdlo.projet.artiste.modele.formes;

import java.awt.Color;
import java.text.DecimalFormat;
import java.util.Locale;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

public class Ligne extends Forme {

	public static final double EPSILON = 0.5;

	public Ligne() {
		super();
	}

	public Ligne(Coordonnees position, double largeur, double hauteur) {
		super(position, largeur, hauteur);
	}

	public Ligne(Coordonnees position) {
		super(position);
	}

	public Ligne(double largeur, double hauteur) {
		super(largeur, hauteur);
	}

	public Coordonnees getC1() {
		return getPosition();
	}

	public Coordonnees getC2() {
		return new Coordonnees(getC1().getAbscisse() + getLargeur(), getC1().getOrdonnee() + getHauteur());
	}

	public void setC1(Coordonnees position) {
		double newLargeur = getC2().getAbscisse() - position.getAbscisse();
		double newHauteur = getC2().getOrdonnee() - position.getOrdonnee();
		setPosition(position);
		setHauteur(newHauteur);
		setLargeur(newLargeur);

	}

	public void setC2(Coordonnees position) {
		setHauteur(position.getOrdonnee() - getC1().getOrdonnee());
		setLargeur(position.getAbscisse() - getC1().getAbscisse());
	}

	@Override
	public boolean contient(Coordonnees point) {
		if (point.distanceVers(getC1()) + point.distanceVers(getC2()) - getC1().distanceVers(getC2()) <= EPSILON)
			return true;
		return false;
	}

	@Override
	public String toString() {
		DecimalFormat form = new DecimalFormat("0.0#");
		String rgb;
		if (Locale.getDefault().getLanguage().equals("fr")) {
			rgb = "R" + getCouleur().getRed() + ",V" + getCouleur().getGreen() + ",B" + getCouleur().getBlue();
		} else {
			rgb = "R" + getCouleur().getRed() + ",G" + getCouleur().getGreen() + ",B" + getCouleur().getBlue();

		}
		double angle = (Math.toDegrees(this.getC1().angleVers(getC2())) + 360) % 360;
		return ("[Ligne]" + " c1 : (" + form.format(getC1().getAbscisse()) + " , " + form.format(getC1().getOrdonnee())
				+ ")" + " c2 : (" + form.format(getC2().getAbscisse()) + " , " + form.format(getC2().getOrdonnee())
				+ ")" + " longueur : " + form.format(perimetre()) + " angle : " + form.format(angle) + "\u00B0")
				+ " couleur = " + rgb;
	}

	@Override
	public double aire() {
		return 0;
	}

	@Override
	public double perimetre() {
		return getC1().distanceVers(getC2());
	}

	@Override
	public Color getCouleur() {
		return couleur;
	}

	@Override
	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}

}
