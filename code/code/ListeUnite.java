
import java.util.ArrayList;

public class ListeUnite {

	protected ArrayList<Unite> liste_unite = new ArrayList<Unite>();

	public ArrayList<Unite> getListe() { return liste_unite; }

	public ListeUnite() {
		Infanterie inf = new Infanterie();
		InfLourde infl = new InfLourde();
		Cavalerie cav = new Cavalerie();
		Mage mage = new Mage();
		Archer arc = new Archer();
		liste_unite.add(inf);
		liste_unite.add(infl);
		liste_unite.add(cav);
		liste_unite.add(mage);
		liste_unite.add(arc);
	}
}
