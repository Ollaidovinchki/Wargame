
import java.util.ArrayList;

public class ListeTerrain {

protected ArrayList<Case_hexagonales> liste_terrain = new ArrayList<Case_hexagonales>();

	public ArrayList<Case_hexagonales> getListe() { return liste_terrain; }

	public Case_hexagonales getTerrain(int i) { return liste_terrain.get(i); }

	public ListeTerrain() {
		Colline col = new Colline();
		Eau_profonde eau = new Eau_profonde();
		Foret foret = new Foret();
		Forteresse fort = new Forteresse();
		Montagne mon = new Montagne();
		Plaine plai = new Plaine();
		Village vil = new Village();
		liste_terrain.add(col);
		liste_terrain.add(eau);
		liste_terrain.add(foret);
		liste_terrain.add(fort);
		liste_terrain.add(mon);
		liste_terrain.add(plai);
		liste_terrain.add(vil);
	}
}
