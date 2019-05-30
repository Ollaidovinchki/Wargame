package projet_v1;

public class Plateau {

	public static void main(String[] args) {
		Archer arch = new Archer();
		Infanterie inf = new Infanterie();
		Mage mage = new Mage();
		ListeUnite l = new ListeUnite();
		Equipe equipe1 = new Equipe();
		
		System.out.println("Pv archer : " + arch.pv);
		System.out.println("PV inf : " + inf.pv);
		System.out.println("PV mage : " + mage.pv);
		arch.Attaquer(inf, 10);
		System.out.println("PV inf : " + inf.pv);
		//inf.Recuperation();
		//System.out.println("PV inf : " + inf.pv);
		equipe1.CreationEquipe(l.getListe());
	}

}
