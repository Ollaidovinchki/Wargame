package WarGame;

public class Foret extends Case_hexagonales {

	// constante qui indique le point de deplacement
	private static final int POINT_DEPLACEMENT = 2;
	
	// constante qui indique le bonus de defense
	private static final double BONUS_DEFENSE = 0.4;
	
	/**
	* constructeur 
	*/
	public Foret() {
		super();
		this.setPoint_deplacement(POINT_DEPLACEMENT);
		this.setBonus_defense(BONUS_DEFENSE);
	}
}
