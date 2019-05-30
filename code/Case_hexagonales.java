package WarGame;

import java.awt.image.BufferedImage;

public class Case_hexagonales {
	
	/**
	* Classe Case_hexagonales
	*
	*/
	
	// image de la case hexagonale au repos
	protected BufferedImage imageCase;
	
	// image de la case hexagonale en situation d'attaque
	protected BufferedImage imageCaseAttaque;
	
	// etat de la case est occupe ou non
	protected boolean estOccupe;
	
	//Unite occupant la case au max une seule
	private Unite unite;
	
	// effet point de deplacement
	protected int point_deplacement;
	
	// test si une attaque est autorise 
	protected boolean permetAttaque;
	
	//test si un deplacement est autorise
	protected boolean permetDeplacement;
	
	// effet bonus de defense
	protected double bonus_defense;
	
	//
	protected int cordX, cordY;
	
	/**
	* Constructor 
	*/
	public Case_hexagonales(int cordX, int cordY) {
		
		this.estOccupe = false;
		this.unite = new Unite();
		this.point_deplacement = 0;
		this.bonus_defense =0.0;
		this.permetAttaque = false;
		this.permetDeplacement = true;
		this.cordX = cordX;
		this.cordY = cordY;
		
		// image a charger pour le graphique
		imageCase = null;
		imageCaseAttaque = null;
		
		
	}
	
	/**
	* get l'abcisse X
	* @return int
	*/
	public int getCordX() {
		return this.cordX;
	}

	/**
	* set l'abcisse X
	* @param int
	*/
	public void setCordX(int x) {
		this.cordX = x;
	}

	/**
	* get l'ordonne Y
	* @return int
	*/
	public int getCordY() {
		return cordY;
	}

	/**
	* set l'ordonne Y
	* @param int
	*/
	public void setCordY(int y) {
		this.cordY = y;
	}
	
	/**
	* get l'etat de la case hexagonale
	* @return boolean
	*/
	public boolean etatCase() {
		return this.estOccupe;
	}
	
	/**
	* get l'unite occupant la case hexagonale
	* @return unite
	*/
	public Unite getUnite() {
		return this.unite;
	}
	
	/**
	* set l'unite occupant la case et
	* permet le deplacement sur elle.
	* @return unite
	*/
	public void setUnite(Unite unite) {
		this.unite = unite;
		this.permetDeplacement = true;
	}
	
	/**
	* get point de deplacement
	* @return point_deplacement
	*/
	public int getPoint_deplacement() {
		return this.point_deplacement;
	}
	
	/**
	* get bonus de defense
	* @return bonus_defense
	*/
	public double getBonus_defense() {
		return this.bonus_defense;
	}
	
	/**
	* libere la case hexagonale
	*/
	public boolean libereCase() {
		return this.estOccupe = false;
	}
	
	/**
	* rend la case hexagonale occupe
	*/
	public boolean occupeCase() {
		return this.estOccupe = true;
	}
	
	/**
	* set le bonus de defense
	* @param bonus nouveau bonus de defense 
	*/
	public void setBonus_defense(double bonus) {
		this.bonus_defense = bonus;
	}
	
	/**
	* set le point de deplacement
	* @param point nouveau point 
	*/
	public void setPoint_deplacement(int point) {
		this.point_deplacement = point;
	}
	
	/**
	* get le booleen pour savoir 
	* une attaque est autorise sur 
	* la case
	* @return boolean
	*/
	public boolean permetAttaque() {
		return this.permetAttaque;
	}

	/**
	* get le booleen pour savoir 
	* un deplacement est autorise sur 
	* la case
	* @return boolean
	*/
	public boolean permetDeplacement() {
		return this.permetDeplacement;
	}
	
	/**
	* changer l'image de la case
	* @param BufferedImage image
	*/
	public void setImage(BufferedImage image) {
		this.imageCase = image;
	}
	
	/**
	* mise a jour des parametres de la case
	* lors du jeu ( bonus etc ...)
	* @param BufferedImage image
	*/
	public void miseAjourCase() {
		
		if (this.unite != null) {
		}

	}

}
