package WarGame;

public class Case_hexagonales {
	
	/**
	* Classe Case_hexagonales
	*
	*/ 
	
	// etat de la case est occupe ou non
	protected boolean estOccupe;
	
	//Unite occupant la case au max une seule
	private Unite unite;
	
	// effet point de deplacement
	protected int point_deplacement;
	
	// effet bonus de defense
	protected double bonus_defense;
	
	/**
	* Constructor 
	*/
	public Case_hexagonales() {
		this.estOccupe = false;
		this.unite = new Unite();
		this.point_deplacement = 0;
		this.bonus_defense =0.0;
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
	
	// affiche les caractéristiques de la case
	public String toString(){
		return ("[Case Hexagonales]: [Etat] "+this.estOccupe+"");
	}
	
	

	

}
