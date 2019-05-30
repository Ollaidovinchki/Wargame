
import java.util.ArrayList;
import java.util.Scanner;

public class Equipe {

	protected int id;
	protected ArrayList<Unite> liste_unite_equipe = new ArrayList<Unite>();
	
	public Equipe(int i) {
		this.id=i;
	}
	
	public int getId() { return this.id; }
	
	public ArrayList<Unite> getListeEquipe() { return this.liste_unite_equipe; }
	
	public int getTailleEquipe() { return this.liste_unite_equipe.size(); }
	
	public void CreationEquipe(ArrayList<Unite> liste) {
		
		int taille_equipe = 0;
		int taille_max = 3;
		int choix;
		
		//Affichage de toutes les unites
		this.AfficheListeChoix(liste);
		
		do {
			//Selection d'une unite
			choix = SelectionUnite();
			if(choix==0) {
				Infanterie inf = new Infanterie();
				inf.setEquipe(this.id);
				this.liste_unite_equipe.add(inf);
			}
			else if(choix == 1) {
				InfLourde infl = new InfLourde();
				infl.setEquipe(this.id);
				this.liste_unite_equipe.add(infl);
			}
			else if(choix == 2) {
				Cavalerie cav = new Cavalerie();
				cav.setEquipe(this.id);
				this.liste_unite_equipe.add(cav);
			}
			else if(choix == 3) {
				Mage mage = new Mage();
				mage.setEquipe(this.id);
				this.liste_unite_equipe.add(mage);
			}
			else if(choix == 4) {
				Archer arc = new Archer();
				arc.setEquipe(this.id);
				this.liste_unite_equipe.add(arc);
			}
				
			taille_equipe += 1;
			
		}while(taille_equipe < taille_max);
		System.out.println("Votre equipe est maintenant complete!");
		this.AfficheListeChoix(this.liste_unite_equipe);
	}
	
	//Affichage d'une liste d'unite
	public void AfficheListeChoix(ArrayList<Unite> liste_choix) {
		
		for(int i=0;i<liste_choix.size();i++) {
			System.out.print(i +")"+"Type : " + liste_choix.get(i).getType());
			System.out.print(" / PV : " + liste_choix.get(i).getPV());
			System.out.print(" / P_Att : " + liste_choix.get(i).getP_att());
			System.out.print(" / P_def : " + liste_choix.get(i).getP_def());
			System.out.print(" / Depl : " + liste_choix.get(i).getDepl());
			System.out.println(" / Vision : " + liste_choix.get(i).getVision());
		}
		System.out.println();
	}
	
	public int SelectionUnite() {
		int choix;
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("choix : ");
			choix = sc.nextInt();
		}while(choix<0 || choix>=5);
		return choix;
	}
}
