package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilCercle;
import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilEllipse;
import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilLigne;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

@SuppressWarnings("serial")
public class ActionChoisirForme extends AbstractAction {

	public static final String NOM_ACTION_LIGNE = "Ligne";
	public static final String NOM_ACTION_CERCLE = "Cercle";
	public static final String NOM_ACTION_ELLIPSE = "Ellipse";
	private PanneauDessin panneauDessin;
	@SuppressWarnings("unused")
	private PanneauBarreOutils panneauOutil;

	public ActionChoisirForme(PanneauDessin panneauDessin, PanneauBarreOutils panneauOutil, String nom) {
		super(nom);
		this.panneauDessin = panneauDessin;
		this.panneauOutil = panneauOutil;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(NOM_ACTION_LIGNE)) {
			panneauDessin.associerOutil(new OutilLigne());
		} else if (e.getActionCommand().equals(NOM_ACTION_CERCLE)) {
			panneauDessin.associerOutil(new OutilCercle());
		} else {
			panneauDessin.associerOutil(new OutilEllipse());
		}

	}

}
