package fr.eseo.pdlo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionSelectionner;
import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Forme;

public class OutilSelectionner extends Outil {
	private Forme formeSelectionnee;

	public OutilSelectionner() {
	}

	public void mouseClicked(MouseEvent event) {
		for (int i = getPanneauDessin().getVueFormes().size() - 1; i >= 0; i--) {
			if (getPanneauDessin().getVueFormes().get(i).getForme()
					.contient(new Coordonnees(event.getX(), event.getY()))) {
				formeSelectionnee = getPanneauDessin().getVueFormes().get(i).getForme();
				JOptionPane.showMessageDialog(getPanneauDessin(), formeSelectionnee.toString(),
						ActionSelectionner.NOM_ACTION, JOptionPane.INFORMATION_MESSAGE);
				break;
			}
		}

	}
}
