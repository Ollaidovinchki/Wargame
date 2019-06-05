
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Equipe implements Serializable{

	protected int id;
	protected ArrayList<Unite> liste_unite_equipe = new ArrayList<Unite>();

	public Equipe(int i) {
		this.id=i;
	}

	public int getId() { return this.id; }

	public ArrayList<Unite> getListeEquipe() { return this.liste_unite_equipe; }

	public int getTailleEquipe() { return this.liste_unite_equipe.size(); }

	public void CreationEquipe(ArrayList<Unite> liste, int choix) {

		Unite unite;
		int taille_max = 3;

		for(int i=0; i<taille_max; i++)
		{	if(choix==0)
			{
				unite = new Infanterie();
				unite.setEquipe(this.id);
				this.liste_unite_equipe.add(unite);
			}
			else if(choix == 1)
			{
				unite = new InfLourde();
				unite.setEquipe(this.id);
				this.liste_unite_equipe.add(unite);
			}
			else if(choix == 2)
			{
				unite = new Cavalerie();
				unite.setEquipe(this.id);
				this.liste_unite_equipe.add(unite);
			}
			else if(choix == 3)
			{
				unite = new Mage();
				unite.setEquipe(this.id);
				this.liste_unite_equipe.add(unite);
			}
			else if(choix == 4)
			{
				unite = new Archer();
				unite.setEquipe(this.id);
				this.liste_unite_equipe.add(unite);
			}

		}

	}

	//Affichage d'une liste d'unite
	/*public void AfficheListeChoix(ArrayList<Unite> liste_choix) {

		for(int i=0;i<liste_choix.size();i++) {
			System.out.print(i +")"+"Type : " + liste_choix.get(i).getType());
			System.out.print(" / PV : " + liste_choix.get(i).getPV());
			System.out.print(" / P_Att : " + liste_choix.get(i).getP_att());
			System.out.print(" / P_def : " + liste_choix.get(i).getP_def());
			System.out.print(" / Depl : " + liste_choix.get(i).getDepl());
			System.out.println(" / Vision : " + liste_choix.get(i).getVision());
		}
		System.out.println();
	}*/

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
