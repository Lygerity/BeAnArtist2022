package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JColorChooser;

import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

@SuppressWarnings("serial")
public class ActionChoisirCouleur extends AbstractAction {
	
	public static final String NOM_ACTION = "Choix Couleur";
	private PanneauDessin pannel;

			
	public ActionChoisirCouleur(PanneauDessin panneauDessin) {
		super(NOM_ACTION);
		pannel = panneauDessin;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Color couleur = JColorChooser.showDialog(pannel, NOM_ACTION, pannel.getCouleurCourante());
		pannel.setCouleurCourante(couleur);
		//System.out.println(pannel.getCouleurCourante());
	}

}
