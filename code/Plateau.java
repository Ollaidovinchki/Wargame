package projet_v1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Plateau {

	protected Case_hexagonales t_jeu[][] = new Case_hexagonales[10][10];
	protected Equipe equipe1;
	protected Equipe equipe2;
	protected ArrayList<Integer> coup_ligne = new ArrayList<Integer>();
	protected ArrayList<Integer> coup_colonne = new ArrayList<Integer>();
	
	Plateau(ListeTerrain liste_t) {
		Random rnd = new Random();
		int alea = 0;
		// Attention, toutes les case de même type (exemple tous les montagnes vont etre modifié
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				alea = rnd.nextInt(7);
				if(alea == 1) {
					Colline c = new Colline();
					this.t_jeu[i][j] = c;
				}else if(alea == 2) {
					Eau_profonde e = new Eau_profonde();
					this.t_jeu[i][j] = e;
				}else if(alea == 3) {
					Foret f = new Foret();
					this.t_jeu[i][j] = f;
				}else if(alea == 4) {
					Forteresse fort = new Forteresse();
					this.t_jeu[i][j] = fort;
				}else if(alea == 5) {
					Montagne m = new Montagne();
					this.t_jeu[i][j] = m;
				}else if(alea == 6) {
					Plaine p = new Plaine();
					this.t_jeu[i][j] = p;
				}else if(alea == 0) {
					Village v = new Village();
					this.t_jeu[i][j] = v;
				}
			}
		}
	}
	
	public void AfficheTerrain() {
	// Pour afficher les terrains, remplacer avec des coordonnées et des images	
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				if(this.t_jeu[i][j] instanceof Colline)
					System.out.print(1);
				else if(this.t_jeu[i][j] instanceof Eau_profonde)
					System.out.print(2);
				else if(this.t_jeu[i][j] instanceof Foret)
					System.out.print(3);
				else if(this.t_jeu[i][j] instanceof Forteresse)
					System.out.print(4);
				else if(this.t_jeu[i][j] instanceof Montagne)
					System.out.print(5);
				else if(this.t_jeu[i][j] instanceof Plaine)
					System.out.print(6);
				else if(this.t_jeu[i][j] instanceof Village)
					System.out.print(7);
			}
			System.out.println("");
		}
	}
	
	public void PlaceEquipe(Equipe e1, Equipe e2) {
		for(int i=0;i<e1.getTailleEquipe();i++) {
			this.t_jeu[0][2+i].setEtatCase(1);
			e1.liste_unite_equipe.get(i).setColonne(2+i);
			e1.liste_unite_equipe.get(i).setLigne(0);
		}
		for(int j=0;j<e2.getTailleEquipe();j++) {
			this.t_jeu[9][2+j].setEtatCase(2);
			e2.liste_unite_equipe.get(j).setColonne(2+j);
			e2.liste_unite_equipe.get(j).setLigne(9);
		}
	}
	
	public void AffUnite() {
		for(int i=0;i<10;i++) {
			if(i%2!=0)
				System.out.print(" ");
			for(int j=0;j<10;j++) {
					System.out.print(this.t_jeu[i][j].getEtatCase());
			}
			System.out.println("");
		}
	}
	
	
	public boolean VerifDeplacement(Unite unit,int ligne,int colonne) {
		int pd = this.t_jeu[ligne][colonne].getPoint_deplacement();
		int u_equipe = unit.getEquipe();
		if(unit.getDepl() >= pd ){
			if(this.t_jeu[ligne][colonne].getEtatCase()==0)
				return true; // Deplacement possible sur cette case
			else if(this.t_jeu[ligne][colonne].getEtatCase() != u_equipe) 
				return true; // Attaquer la cible
			else 
				return false;
		}
		else
			return false;
	}
	
	public boolean VerifAttaqueDistance(Unite unit,int ligne,int colonne) {
		int pd = this.t_jeu[ligne][colonne].getPoint_deplacement();
		int u_equipe = unit.getEquipe();
		if(unit.getDepl() >= pd ){
			if(this.t_jeu[ligne][colonne].getEtatCase()==0)
				return false; // Deplacement possible sur cette case
			else if(this.t_jeu[ligne][colonne].getEtatCase() != u_equipe) { 
				System.out.println("Attaque à distance possible!");
				return true; // Attaquer la cible
			}
			else 
				return false;
		}
		else
			return false;
	}
	
	// On vérifie les coups possibles d'une unité
	public void CaseDeplacementUnit(Unite unit) {
		this.coup_colonne.clear();
		this.coup_ligne.clear();
		int ligne = unit.getLigne();
		int colonne = unit.getColonne();
		// ici on récupère la case ou se trouve notre unité au clic (x,y)
		if(ligne%2!=0) {
			if(ligne != 0) {
				if(VerifDeplacement(unit,ligne-1,colonne)) {
					this.coup_colonne.add(colonne);
					this.coup_ligne.add(ligne-1);
				}
				if(colonne != 9) {
					if(VerifDeplacement(unit,ligne-1,colonne+1)) {
						this.coup_colonne.add(colonne+1);
						this.coup_ligne.add(ligne-1);
					}
				}
			}
			if(colonne != 0) {
				if(VerifDeplacement(unit,ligne,colonne-1)) {
					this.coup_colonne.add(colonne-1);
					this.coup_ligne.add(ligne);
				}
			}
			if(colonne != 9) {
				if(VerifDeplacement(unit,ligne,colonne+1)) {
					this.coup_colonne.add(colonne+1);
					this.coup_ligne.add(ligne);
				}
			}
			if(ligne != 9) {
				if(VerifDeplacement(unit,ligne+1,colonne)) {
					this.coup_colonne.add(colonne);
					this.coup_ligne.add(ligne+1);
				}
				if(colonne != 9) {
					if(VerifDeplacement(unit,ligne+1,colonne+1)) {
						this.coup_colonne.add(colonne+1);
						this.coup_ligne.add(ligne+1);
					}
				}
			}
		}else {
			if(ligne != 0) {
				if(VerifDeplacement(unit,ligne-1,colonne)) {
					this.coup_colonne.add(colonne);
					this.coup_ligne.add(ligne-1);
				}
				if(colonne != 9) {
					if(VerifDeplacement(unit,ligne-1,colonne-1)) {
						this.coup_colonne.add(colonne-1);
						this.coup_ligne.add(ligne-1);
					}
				}
			}
			if(colonne != 0) {
				if(VerifDeplacement(unit,ligne,colonne-1)) {
					this.coup_colonne.add(colonne-1);
					this.coup_ligne.add(ligne);
				}
			}
			if(colonne != 9) {
				if(VerifDeplacement(unit,ligne,colonne+1)) {
					this.coup_colonne.add(colonne+1);
					this.coup_ligne.add(ligne);
				}
			}
			if(ligne != 9) {
				if(VerifDeplacement(unit,ligne+1,colonne)) {
					this.coup_colonne.add(colonne);
					this.coup_ligne.add(ligne+1);
				}
				if(colonne != 9) {
					if(VerifDeplacement(unit,ligne+1,colonne-1)) {
						this.coup_colonne.add(colonne-1);
						this.coup_ligne.add(ligne+1);
					}
				}
			}
		}
	}
	
	public void AttaqueUniteDistance(Unite unit) {
		int ligne = unit.getLigne();
		int colonne = unit.getColonne();
		//Regarde en haut à deux cases
		if(ligne > 1) {
			if(VerifAttaqueDistance(unit,ligne-2,colonne)) {
				this.coup_colonne.add(colonne);
				this.coup_ligne.add(ligne-2);
			}
			if(colonne != 9) {
				if(VerifAttaqueDistance(unit,ligne-2,colonne+1)) {
					this.coup_colonne.add(colonne+1);
					this.coup_ligne.add(ligne-2);
				}
			}
			if(colonne !=0) {
				if(VerifAttaqueDistance(unit,ligne-2,colonne-1)) {
					this.coup_colonne.add(colonne-1);
					this.coup_ligne.add(ligne-2);
				}
			}
		}
		// Regarde à gauche
		if(colonne > 1) {
			if(VerifAttaqueDistance(unit,ligne,colonne-2)) {
				this.coup_colonne.add(colonne-2);
				this.coup_ligne.add(ligne);
			}
		}
		// Regarde à droite
		if(colonne < 8) {
			if(VerifAttaqueDistance(unit,ligne,colonne+2)) {
				this.coup_colonne.add(colonne+2);
				this.coup_ligne.add(ligne);
			}
		}
		// Regarde en bas
		if(ligne < 8) {
			if(VerifAttaqueDistance(unit,ligne+2,colonne)) {
				this.coup_colonne.add(colonne);
				this.coup_ligne.add(ligne+2);
			}
			if(colonne != 9) {
				if(VerifAttaqueDistance(unit,ligne+2,colonne+1)) {
					this.coup_colonne.add(colonne+1);
					this.coup_ligne.add(ligne+2);
				}
			}
			if(colonne != 0) {
				if(VerifAttaqueDistance(unit,ligne+2,colonne-1)) {
					this.coup_colonne.add(colonne-1);
					this.coup_ligne.add(ligne+2);
				}
			}
		}
		// On regarde les cases en diagonales
		if(ligne%2==0) {
			if(ligne !=0) {
				if(colonne >1) {
					if(VerifAttaqueDistance(unit,ligne-1,colonne-2)) {
						this.coup_colonne.add(colonne-2);
						this.coup_ligne.add(ligne-1);
					}
				}
				if(colonne !=9) {
					if(VerifAttaqueDistance(unit,ligne-1,colonne+1)) {
						this.coup_colonne.add(colonne+1);
						this.coup_ligne.add(ligne-1);
					}
				}
			}
			if(ligne!=9) {
				if(colonne >1) {
					if(VerifAttaqueDistance(unit,ligne+1,colonne-2)) {
						this.coup_colonne.add(colonne-2);
						this.coup_ligne.add(ligne+1);
					}
				}
				if(colonne !=9) {
					if(VerifAttaqueDistance(unit,ligne+1,colonne+1)) {
						this.coup_colonne.add(colonne+1);
						this.coup_ligne.add(ligne+1);
					}
				}
			}
		}
		else {
			if(ligne !=0) {
				if(colonne != 0) {
					if(VerifAttaqueDistance(unit,ligne-1,colonne-1)) {
						this.coup_colonne.add(colonne-1);
						this.coup_ligne.add(ligne-1);
					}
				}
				if(colonne <8) {
					if(VerifAttaqueDistance(unit,ligne-1,colonne+2)) {
						this.coup_colonne.add(colonne+2);
						this.coup_ligne.add(ligne-1);
					}
				}
			}
			if(ligne!=9) {
				if(colonne !=0) {
					if(VerifAttaqueDistance(unit,ligne+1,colonne-1)) {
						this.coup_colonne.add(colonne-1);
						this.coup_ligne.add(ligne+1);
					}
				}
				if(colonne <9) {
					if(VerifAttaqueDistance(unit,ligne+1,colonne+2)) {
						this.coup_colonne.add(colonne+2);
						this.coup_ligne.add(ligne+1);
					}
				}
			}
		}
		
	}
	
	// On affecte le déplcament ou l'attaque d'une unité en fonction du choix de l'adversaire
	public void AffecterDeplacement(Unite unit,int choix) {
			int ligne = this.coup_ligne.get(choix);
			int colonne = this.coup_colonne.get(choix);
			
			if(this.t_jeu[ligne][colonne].getEtatCase()!=0 && this.t_jeu[ligne][colonne].getEtatCase()!=unit.getEquipe()) {
				if(unit.getEquipe()==this.equipe1.getId()) {
					for(int i=0;i<this.equipe2.getListeEquipe().size();i++) {
						if(this.equipe2.getListeEquipe().get(i).getLigne()==ligne && this.equipe2.getListeEquipe().get(i).getColonne()==colonne) {
							unit.Attaquer(this.equipe2.getListeEquipe().get(i), this.t_jeu[ligne][colonne].getBonus_defense());
							unit.setDepl(t_jeu[ligne][colonne].getPoint_deplacement());
							if(this.equipe2.getListeEquipe().get(i).getEtat() == false) {
								this.t_jeu[this.equipe2.getListeEquipe().get(i).getLigne()][this.equipe2.getListeEquipe().get(i).getColonne()].setEtatCase(0);
								this.equipe2.liste_unite_equipe.remove(this.equipe2.getListeEquipe().get(i));
							}
						}
					}
				}else {
					for(int i=0;i<this.equipe1.getListeEquipe().size();i++) {
						if(this.equipe1.getListeEquipe().get(i).getLigne()==ligne && this.equipe1.getListeEquipe().get(i).getColonne()==colonne) {
							unit.Attaquer(this.equipe1.getListeEquipe().get(i), this.t_jeu[ligne][colonne].getBonus_defense());
							unit.setDepl(t_jeu[ligne][colonne].getPoint_deplacement());
							if(this.equipe1.getListeEquipe().get(i).getEtat() == false) {
								this.t_jeu[this.equipe1.getListeEquipe().get(i).getLigne()][this.equipe1.getListeEquipe().get(i).getColonne()].setEtatCase(0);
								this.equipe1.liste_unite_equipe.remove(this.equipe1.getListeEquipe().get(i));
							}
						}
					}
				}
			}else {
				this.t_jeu[unit.getLigne()][unit.getColonne()].setEtatCase(0);
				this.t_jeu[ligne][colonne].setEtatCase(unit.getEquipe());
				unit.setDepl(t_jeu[ligne][colonne].getPoint_deplacement());
				unit.setLigne(ligne);
				unit.setColonne(colonne);
			}
			
		}
	
	
	public static void main(String[] args) {
		ListeTerrain liste_t = new ListeTerrain();
		Archer arch = new Archer();
		Infanterie inf = new Infanterie();
		Mage mage = new Mage();
		ListeUnite l_u = new ListeUnite();
		int save_depl = 0;
		int nbr_depl = 0;
		
		Plateau plateau = new Plateau(liste_t);
		plateau.AfficheTerrain();
		plateau.AffUnite();
		//System.out.println("PV inf : " + inf.pv);
		//System.out.println("PV mage : " + mage.pv);
		//arch.Attaquer(inf, 10);
		//System.out.println("PV inf : " + inf.pv);
		//inf.Recuperation();
		plateau.equipe1 = new Equipe(1);
		plateau.equipe2 = new Equipe(2);
		plateau.equipe1.CreationEquipe(l_u.getListe());
		plateau.equipe2.CreationEquipe(l_u.getListe());
		
		plateau.PlaceEquipe(plateau.equipe1,plateau.equipe2);
		plateau.AffUnite();
		
		while(plateau.equipe1.liste_unite_equipe.size()!=0 && plateau.equipe2.liste_unite_equipe.size()!=0) {
			
			for(int i=0;i<plateau.equipe1.liste_unite_equipe.size();i++) {
				save_depl = plateau.equipe1.liste_unite_equipe.get(i).getDepl();
				
				while(plateau.equipe1.liste_unite_equipe.get(i).getDepl()>0) {
					nbr_depl ++;
					plateau.equipe1.liste_unite_equipe.get(i).InfoUnit();
					plateau.CaseDeplacementUnit(plateau.equipe1.liste_unite_equipe.get(i));
					if(plateau.equipe1.liste_unite_equipe.get(i) instanceof Archer || plateau.equipe1.liste_unite_equipe.get(i) instanceof Mage)
						plateau.AttaqueUniteDistance(plateau.equipe1.liste_unite_equipe.get(i));
					if(plateau.coup_colonne.size()==0 && plateau.coup_ligne.size()==0) {
						System.out.println("Aucun coup possibles on stop avec cette unité!");
						plateau.equipe1.liste_unite_equipe.get(i).setDepl(20);
					}
					else {
						System.out.println("Choix 0: Passer votre tour");
						for(int j=0;j<plateau.coup_colonne.size();j++) {
							System.out.print("Choix "+(j+1) + ":  "+plateau.coup_ligne.get(j));
							System.out.println(plateau.coup_colonne.get(j));
						}
						Scanner sc = new Scanner(System.in);
						int choix=0;
						do {
							System.out.println("choix : ");
							choix = sc.nextInt();
						}while(choix < 0 || choix>=plateau.coup_colonne.size()+1);
						if(choix !=0)
							plateau.AffecterDeplacement(plateau.equipe1.liste_unite_equipe.get(i), choix-1);
						else {
							System.out.println("Vous avez choisi de passer votre tour.");
							plateau.equipe1.liste_unite_equipe.get(i).setDepl(20);
							if(nbr_depl==1) {
								System.out.println("Vous avez choisi de passer votre tour dès le début vous allez donc récupérer des points de vie sur cette unité.");
								plateau.equipe1.liste_unite_equipe.get(i).Recuperation();
							}
						}
					}
					plateau.AffUnite();
				}
				nbr_depl = 0;
				plateau.equipe1.liste_unite_equipe.get(i).ReinitialiseDepl(save_depl);
			}
			
			for(int i=0;i<plateau.equipe2.liste_unite_equipe.size();i++) {
				save_depl = plateau.equipe2.liste_unite_equipe.get(i).getDepl();
				
				while(plateau.equipe2.liste_unite_equipe.get(i).getDepl()>0) {
					nbr_depl++;
					plateau.CaseDeplacementUnit(plateau.equipe2.liste_unite_equipe.get(i));
					if(plateau.equipe2.liste_unite_equipe.get(i) instanceof Archer || plateau.equipe2.liste_unite_equipe.get(i) instanceof Mage)
						plateau.AttaqueUniteDistance(plateau.equipe2.liste_unite_equipe.get(i));
					if(plateau.coup_colonne.size()==0 && plateau.coup_ligne.size()==0) {
						System.out.println("Aucun coup possibles on stop avec cette unité!");
						plateau.equipe2.liste_unite_equipe.get(i).setDepl(20);
					}
					else {
						System.out.println("Choix 0: Passer votre tour");
						for(int j=0;j<plateau.coup_colonne.size();j++) {
							System.out.print("Choix "+(j+1) + ":  "+plateau.coup_ligne.get(j));
							System.out.println(plateau.coup_colonne.get(j));
						}
						Scanner sc = new Scanner(System.in);
						int choix=0;
						do {
							System.out.println("choix : ");
							choix = sc.nextInt();
						}while(choix < 0 || choix>=plateau.coup_colonne.size()+1);
						if(choix !=0)
							plateau.AffecterDeplacement(plateau.equipe2.liste_unite_equipe.get(i), choix-1);
						else {
							System.out.println("Vous avez choisi de passer votre tour.");
							plateau.equipe2.liste_unite_equipe.get(i).setDepl(20);
							if(nbr_depl==1) {
								System.out.println("Vous avez choisi de passer votre tour dès le début vous allez donc récupérer des points de vie sur cette unité.");
								plateau.equipe2.liste_unite_equipe.get(i).Recuperation();
							}
						}
					}
					plateau.AffUnite();
				}
				nbr_depl = 0;
				plateau.equipe2.liste_unite_equipe.get(i).ReinitialiseDepl(save_depl);
			}
		}
		System.out.println("Fin de la partie !");
	}
}
            