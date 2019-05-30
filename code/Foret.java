package WarGame;

public class Foret extends Case_hexagonales {

	// constante qui indique le point de deplacement
	private static final int POINT_DEPLACEMENT = 2;
	
	// constante qui indique le bonus de defense
	private static final double BONUS_DEFENSE = 0.4;
	
	/**
	* constructeur 
	*/
	public Foret(int cordX, int cordY) {
		super(cordX, cordY);
		this.setPoint_deplacement(POINT_DEPLACEMENT);
		this.setBonus_defense(BONUS_DEFENSE);
		// todo charger l'image pour ce type de case, ie remplacer null
		this.setImage(null);
	}
}
