package projet_v1;

public class Case_hexagonales {
	
	/**
	* Classe Case_hexagonales
	*
	*/ 
	
	// etat de la case est occupe ou non
	// (0 = vide, 1 = equipe1, 2 = equipe2) 
	protected int estOccupe;
	
	// effet point de deplacement
	protected int point_deplacement;
	
	// effet bonus de defense
	protected double bonus_defense;
	
	/**
	* Constructor 
	*/
	public Case_hexagonales(int point_deplacement, double bonus_defense) {
		this.estOccupe = 0;
		this.point_deplacement = point_deplacement;
		this.bonus_defense = bonus_defense;
	}
	
	
	/**
	* get l'etat de la case hexagonale
	* @return boolean
	*/
	public int getEtatCase() {
		return this.estOccupe;
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
	* rend la case hexagonale occupe
	*/
	public void setEtatCase(int i) {
		this.estOccupe = i;
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
