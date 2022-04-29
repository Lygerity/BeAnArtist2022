package fr.eseo.pdlo.projet.artiste.vue.ihm;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

@SuppressWarnings("serial")
public class PanneauBarreEtat extends JPanel implements MouseMotionListener {
	
	private JLabel valeurX;
	private JLabel valeurY;
	
	public PanneauBarreEtat(PanneauDessin panneauDessin) {
		new JPanel(new FlowLayout());
		setPreferredSize(new Dimension(150, 50));
		panneauDessin.addMouseMotionListener(this);
		this.add(valeurX = new JLabel("x: 0"));
		this.add(valeurY = new JLabel("y: 0"));
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		mettreAJourAffichage(new Coordonnees(e.getX(), e.getY()));		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		mettreAJourAffichage(new Coordonnees(e.getX(), e.getY()));
	}
	
	private void mettreAJourAffichage(Coordonnees coor) {
		valeurX.setText("x: " + coor.getAbscisse());
		valeurY.setText("y: " + coor.getOrdonnee());
	}
}
