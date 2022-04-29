package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

@SuppressWarnings("serial")
public class ActionChoisirModeRemplissage extends AbstractAction {
	private PanneauDessin  panneau;
	
	public ActionChoisirModeRemplissage(PanneauDessin pannel, Remplissage modeRemplissage) {
		super(modeRemplissage.getMode());
		panneau = pannel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	if(e.getActionCommand().equals("uniforme")) panneau.setModeRemplissageCourant(Remplissage.UNIFORME);
	else panneau.setModeRemplissageCourant(Remplissage.AUCUNE);
	}
}