package fr.eseo.pdlo.projet.artiste.vue.ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import fr.eseo.pdlo.projet.artiste.controleur.outils.Outil;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
import fr.eseo.pdlo.projet.artiste.modele.formes.Forme;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;

@SuppressWarnings("serial")
public class PanneauDessin extends JPanel {

	public static final int LARGEUR_PAR_DEFAUT = 640;
	public static final int HAUTEUR_PAR_DEFAUT = 480;
	public static final Color COULEUR_FOND_PAR_DEFAUT = Color.white;
	
	private Color couleurCourante;
	private final List<VueForme> vueFormes;
	private Outil outilCourant;
	private Remplissage modeRemplisssage;

	public PanneauDessin() {
		new JPanel();
		setPreferredSize(new Dimension(LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT));
		setBackground(COULEUR_FOND_PAR_DEFAUT);
		setCouleurCourante(Forme.COULEUR_PAR_DEFAUT);
		setModeRemplissageCourant(Remplissage.AUCUNE);
		vueFormes = new ArrayList<>();
	}

	public PanneauDessin(int largeur, int hauteur, Color fond) {
		new JPanel();
		setPreferredSize(new Dimension(largeur, hauteur));
		setBackground(fond);
		setCouleurCourante(Forme.COULEUR_PAR_DEFAUT);
		setModeRemplissageCourant(Remplissage.AUCUNE);
		vueFormes = new ArrayList<>();
	}

	public List<VueForme> getVueFormes() {
		return vueFormes;
	}

	public void ajouterVueForme(VueForme vueForme) {
		getVueFormes().add(vueForme);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D) g.create();
		for (int i = 0; i < getVueFormes().size(); i++) {
			g2D.setColor(getCouleurCourante());
			//System.out.println(g2D.getColor());
			getVueFormes().get(i).affiche(g2D);
		}
		g2D.dispose();
	}

	public void associerOutil(Outil outil) {
		if (getOutilCourant() == null)
			setOutilCourant(outil);
		else {
			getOutilCourant().setPanneauDessin(null);
			dissocierOutil();
			setOutilCourant(outil);
		}
	}

	public void dissocierOutil() {
		removeMouseListener(getOutilCourant());
		removeMouseMotionListener(getOutilCourant());
		setOutilCourant(null);
	}

	public Outil getOutilCourant() {
		return outilCourant;
	}

	private void setOutilCourant(Outil outil) {
		outilCourant = outil;
		if (outil != null) {
			getOutilCourant().setPanneauDessin(this);
			this.addMouseListener(outil);
			this.addMouseMotionListener(outil);
		}
	}
	
	public Color getCouleurCourante() {
		return couleurCourante;
	}
	
	public void setCouleurCourante(Color couleur) {
		couleurCourante = couleur;
	}
	
	public Remplissage getModeRemplissageCourant() {
		return modeRemplisssage;
	}
	
	public void setModeRemplissageCourant(Remplissage modeRemplissage) {
		this.modeRemplisssage = modeRemplissage;
	}

}
