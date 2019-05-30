package WarGame;

public class Forteresse extends Case_hexagonales {

	// constante qui indique le point de deplacement
	private static final int POINT_DEPLACEMENT = 1;
	
	// constante qui indique le bonus de defense
	private static final double BONUS_DEFENSE = 0.6;
	
	/**
	* constructeur 
	*/
	public Forteresse() {
		super();
		this.setPoint_deplacement(POINT_DEPLACEMENT);
		this.setBonus_defense(BONUS_DEFENSE);
	}
}
