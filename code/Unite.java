package projet_v1;

import java.util.Random;

public class Unite {
	
	protected int pv;
	protected int p_att;
	protected int p_def;
	protected int depl;
	protected int vision;
	protected String type;
	protected boolean etat;
	
	Unite(String type, int pv, int p_att, int p_def, int depl, int vision, boolean vivant){
		this.type = type;
		this.pv = pv;
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
	
	// Les fonctions Set()
	public void setPV(int pv) { 
		this.pv += pv;
		
		if(this.pv <= 0)
			this.etat = false;
	}
	
	public void Attaquer(Unite ennemie, int bonus_def) {
	
		Random rnd = new Random();
		int def_ennemie = ennemie.getP_def();
		int D_subit = this.p_att;
		int critique = 0;
		
		def_ennemie = def_ennemie + (int)((def_ennemie * bonus_def/100));
		D_subit = D_subit - def_ennemie;
		
		// Aléatoire
		critique = rnd.nextInt(10);
		if(critique >= 7)
			critique = D_subit;
		else
			critique = 0;
		D_subit = D_subit + critique;
		ennemie.setPV(-D_subit);
	}
	
	public void Recuperation(){
		this.pv = this.pv + (int)(0.05 * this.pv + 1);
	}

}
