package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

@SuppressWarnings("serial")
public class ActionEffacer extends AbstractAction {

	public static final String NOM_ACTION = "Effacer Tout";
	private PanneauDessin panneauDessin;

	public ActionEffacer(PanneauDessin panneauDessin) {
		super(NOM_ACTION);
		this.panneauDessin = panneauDessin;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int choix = JOptionPane.showConfirmDialog(panneauDessin, "Voulez vous vraiment tout effacer?", NOM_ACTION,
				JOptionPane.YES_NO_OPTION);
		if (choix == JOptionPane.YES_OPTION) {
			panneauDessin.getVueFormes().clear();
			panneauDessin.repaint();
		}
	}

}
