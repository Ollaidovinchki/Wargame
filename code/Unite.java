
import java.io.Serializable;
import java.util.Random;

public class Unite implements Serializable{

	protected int pv;
	protected int max_pv;
	protected int p_att;
	protected int p_def;
	protected int depl;
	protected int vision;
	protected String type;
	protected boolean etat; // True = vivant et False = mort
	public int equipe;
	public int ligne;
	public int colonne;

	Unite(String type, int pv, int p_att, int p_def, int depl, int vision, boolean etat){
		this.type = type;
		this.pv = pv;
		this.max_pv = pv;
		this.p_att = p_att;
		this.p_def = p_def;
		this.depl = depl;
		this.vision = vision;
		this.etat = etat;
	}

	// Les fonctions Get()
	public String getType() {return this.type;}

	public int getPV() { return this.pv; }

	public int getP_att() { return this.p_att; }

	public int getP_def() { return this.p_def; }

	public int getDepl() { return this.depl; }

	public int getVision() { return this.vision; }

	public int getEquipe() { return this.equipe; }

	public int getLigne() { return this.ligne;}

	public int getColonne() { return this.colonne;}

	public boolean getEtat() { return this.etat;}

	public void setLigne(int i) { this.ligne = i;}

	public void setColonne(int i) { this.colonne = i;}

	// Les fonctions Set()
	public void setPV(int pv) {
		this.pv += pv;

		if(this.pv <= 0) {
			this.etat = false;
			System.out.println(" Cette unite est morte.");
		}
	}

	public void setDepl(int p) {
		this.depl -= p;
	}
	// On r� initialise les d�placements de cette unit� une fois son tour finis
	public void ReinitialiseDepl(int p) {this.depl = p;}

	public void setEquipe(int i) {
		this.equipe = i;
	}

	public void InfoUnit() {
		System.out.println("type unite :" + this.type);
		//System.out.println(this.pv);
		//System.out.println(this.p_att);
		//System.out.println(this.p_def);
		//System.out.println(this.depl);
		//System.out.println(this.vision);
		//System.out.println(this.etat);
	}

	public void Attaquer(Unite ennemie, double bonus_def) {

		Random rnd = new Random();
		int def_ennemie = ennemie.getP_def();
		int D_subit = this.p_att;
		int critique = 0;

		def_ennemie = def_ennemie + (int)((def_ennemie * bonus_def/100));
		D_subit = D_subit - def_ennemie;
		if(D_subit <= 0)
			D_subit = 1;

		// Al�atoire
		critique = rnd.nextInt(10);
		if(critique >= 7)
			critique = D_subit;
		else
			critique = 0;
		D_subit = D_subit + critique;
		ennemie.setPV(-D_subit);
		System.out.println("Attaque r�alis� sur "+ennemie.getType()+ " nombre de d�gat inflig�s = "+-D_subit);
	}

	public void Recuperation(){
		int x=0;
		if(this.pv < this.max_pv) {
			this.pv = this.pv + (int)(0.05 * this.pv + 1);
			x=(int)(0.05 * this.pv + 1);
			if(this.pv > this.max_pv)
				this.max_pv = max_pv;
		}
		System.out.println("Points de vie r�cup�r�s = "+x);
	}

}
