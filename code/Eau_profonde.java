package WarGame;

public class Eau_profonde extends Case_hexagonales {

	// constante qui indique le point de deplacement
	private static final int POINT_DEPLACEMENT = 0;
	
	// constante qui indique le bonus de defense
	private static final double BONUS_DEFENSE = 0.0;
	
	/**
	* constructeur 
	*/
	public Eau_profonde() {
		super();
		this.setPoint_deplacement(POINT_DEPLACEMENT);
		this.setBonus_defense(BONUS_DEFENSE);
	}
}
