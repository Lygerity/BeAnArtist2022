package fr.eseo.pdlo.projet.artiste.vue.ihm;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionChoisirCouleur;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionChoisirForme;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionChoisirModeRemplissage;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionEffacer;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionSelectionner;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;

@SuppressWarnings("serial")
public class PanneauBarreOutils extends JPanel {

	private PanneauDessin panneauDessin;

	public PanneauBarreOutils(PanneauDessin panneauDessin) {
		new JPanel(new BoxLayout(panneauDessin, HEIGHT));
		setPreferredSize(new Dimension(125, 400));
		this.panneauDessin = panneauDessin;
		initComponents();
	}

	private void initComponents() {
		JButton boutonEffacer = new JButton(new ActionEffacer(panneauDessin));
		boutonEffacer.setName(ActionEffacer.NOM_ACTION);
		boutonEffacer.setPreferredSize(new Dimension(125, 26));
		this.add(boutonEffacer);
		
		
		ButtonGroup boutonsOutils = new ButtonGroup();
		ButtonGroup boutonsRemplissage = new ButtonGroup();
		
		JToggleButton boutonLigne = new JToggleButton(
				new ActionChoisirForme(panneauDessin, this, ActionChoisirForme.NOM_ACTION_LIGNE));
		boutonLigne.setName(ActionChoisirForme.NOM_ACTION_LIGNE);
		boutonLigne.setPreferredSize(new Dimension(125, 26));
		boutonsOutils.add(boutonLigne);
		this.add(boutonLigne);

		JToggleButton boutonEllipse = new JToggleButton(
				new ActionChoisirForme(panneauDessin, this, ActionChoisirForme.NOM_ACTION_ELLIPSE));
		boutonEllipse.setName(ActionChoisirForme.NOM_ACTION_ELLIPSE);
		boutonEllipse.setPreferredSize(new Dimension(125, 26));
		boutonsOutils.add(boutonEllipse);
		this.add(boutonEllipse);

		JToggleButton boutonCercle = new JToggleButton(
				new ActionChoisirForme(panneauDessin, this, ActionChoisirForme.NOM_ACTION_CERCLE));
		boutonCercle.setName(ActionChoisirForme.NOM_ACTION_CERCLE);
		boutonCercle.setPreferredSize(new Dimension(125, 26));
		boutonsOutils.add(boutonCercle);
		this.add(boutonCercle);
		
		JToggleButton boutonSelectionner = new JToggleButton(new ActionSelectionner(panneauDessin));
		boutonSelectionner.setName("Sélectionner");
		boutonSelectionner.setPreferredSize(new Dimension(125, 26));
		boutonsOutils.add(boutonSelectionner);
		this.add(boutonSelectionner);
		
		JButton boutonCouleur = new JButton(new ActionChoisirCouleur(panneauDessin));
		boutonCouleur.setName(ActionChoisirCouleur.NOM_ACTION);
		boutonCouleur.setPreferredSize(new Dimension(125, 26));
		this.add(boutonCouleur);
		
		JToggleButton boutonUniforme = new JToggleButton(new ActionChoisirModeRemplissage(panneauDessin, Remplissage.UNIFORME));
		boutonUniforme.setName("Remplissage");
		boutonUniforme.setPreferredSize(new Dimension(125, 26));
		boutonsRemplissage.add(boutonUniforme);
		this.add(boutonUniforme);
		
		JToggleButton boutonVide = new JToggleButton(new ActionChoisirModeRemplissage(panneauDessin, Remplissage.AUCUNE));
		boutonVide.setName("Forme vide");
		boutonVide.setPreferredSize(new Dimension(125, 26));
		boutonsRemplissage.add(boutonVide);
		boutonVide.doClick();
		this.add(boutonVide);

	}

}
