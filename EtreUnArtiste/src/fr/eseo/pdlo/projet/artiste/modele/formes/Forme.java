package fr.eseo.pdlo.projet.artiste.modele.formes;

import java.awt.Color;
import fr.eseo.pdlo.projet.artiste.modele.Coloriable;
import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

public abstract class Forme implements Coloriable{

	public static final double LARGEUR_PAR_DEFAUT = 45.0;
	public static final double HAUTEUR_PAR_DEFAUT = 15.0;
	public static final Color COULEUR_PAR_DEFAUT = javax.swing.UIManager.getColor("Panel.foreground");
	
	protected double largeur;
	protected double hauteur;
	protected Color couleur;
	private Coordonnees position;
	
	public Forme() {
		setLargeur(LARGEUR_PAR_DEFAUT);
		setHauteur(HAUTEUR_PAR_DEFAUT);
		setPosition(new Coordonnees());
		setCouleur(COULEUR_PAR_DEFAUT);
	}
	
	public Forme(Coordonnees position, double largeur, double hauteur) {
		setLargeur(largeur);
		setHauteur(hauteur);
		setPosition(position);
		setCouleur(COULEUR_PAR_DEFAUT);
	}
	
	public Forme(Coordonnees position) {
		setLargeur(LARGEUR_PAR_DEFAUT);
		setHauteur(HAUTEUR_PAR_DEFAUT);
		setPosition(position);
		setCouleur(COULEUR_PAR_DEFAUT);
	}
	
	public Forme(double largeur, double hauteur) {
		setLargeur(largeur);
		setHauteur(hauteur);
		setPosition(new Coordonnees());
		setCouleur(COULEUR_PAR_DEFAUT);
	}

	public double getHauteur(){
		return hauteur;
	}
	
	
	public void setLargeur(double largeur){
		this.largeur = largeur;
	}
	
	
	public double getLargeur(){
		return largeur;
	}
	
	
	
	public void setPosition(Coordonnees coordonnees) {
		this.position = coordonnees;
	}

	
	public void setHauteur(double hauteurParDefaut) {
		this.hauteur = hauteurParDefaut;
	}


	
	public Coordonnees getPosition() {
		return position;
	}

	
	public double getCadreMinX() {
		if(getLargeur() < 0)return position.getAbscisse() + getLargeur();
		return position.getAbscisse();
	}

	
	public double getCadreMinY() {
		if(getHauteur() > 0)return position.getOrdonnee();
		return position.getOrdonnee() + getHauteur();
	}
	
	public double getCadreMaxX() {
		if(getLargeur() < 0)return position.getAbscisse();
		return position.getAbscisse() + getLargeur();
	}

	
	public double getCadreMaxY() {
		if(getHauteur() < 0)return position.getOrdonnee();
		return position.getOrdonnee() + getHauteur();
	}


	
	public void deplacerVers(double nouvX, double nouvY) {
		position.deplacerVers(nouvX, nouvY);
	}

	
	public void deplacerDe(double deltaX, double deltaY) {
		position.deplacerDe(deltaX, deltaY);
	}
	
	
	public abstract boolean contient(Coordonnees point);
	
	public abstract double aire();
	
	public abstract double perimetre();
	
}
