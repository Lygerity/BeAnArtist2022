package fr.eseo.pdlo.projet.artiste.modele;
import java.text.DecimalFormat;

public class Coordonnees{
	
	public static final double ABSCISSE_PAR_DEFAUT = 0.0;
	public static final double ORDONNEE_PAR_DEFAUT = 0.0;
	
	private double abscisse;
	private double ordonnee;
	
	public Coordonnees(){
		setAbscisse(ABSCISSE_PAR_DEFAUT);
		setOrdonnee(ORDONNEE_PAR_DEFAUT);
	}
	
	public Coordonnees(double abscisse, double ordonnee){
		setAbscisse(abscisse);
		setOrdonnee(ordonnee);
	}
	
	public void setAbscisse(double abscisse){
		this.abscisse = abscisse;
	}
	
	public double getAbscisse(){
		return abscisse;
	}
	
	public void setOrdonnee(double ordonnee){
		this.ordonnee = ordonnee;
	}
	
	public double getOrdonnee(){
		return ordonnee;
	}
	
	public void deplacerVers(double x, double y){
		setAbscisse(x);
		setOrdonnee(y);
	}
	
	public void deplacerDe(double deltaX, double deltaY){
		setAbscisse(getAbscisse() + deltaX);
		setOrdonnee(getOrdonnee() + deltaY);
	}
	
	public double distanceVers(Coordonnees coord){
		double deltaX = coord.getAbscisse() - this.getAbscisse();
		double deltaY = coord.getOrdonnee() - this.getOrdonnee();
		double distance  = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
		return distance;
	}
	
	public double angleVers(Coordonnees coord){
		double deltaX = coord.getAbscisse() - this.getAbscisse();
		double deltaY = coord.getOrdonnee() - this.getOrdonnee();
		double angle = Math.atan2(deltaY,deltaX);
		return angle;
	}
	
	public String toString() {
		DecimalFormat form = new DecimalFormat("0.0#");
		return "(" + form.format(getAbscisse()) + " , " + form.format(getOrdonnee()) + ")";
	}

	
}