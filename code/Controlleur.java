import java.awt.Point;


public class Controlleur
{

    public Controlleur()
    {

    }

  public int[] ConvertirCaseEnPoint(int ligne, int col){
	  int coordonnees[] = {0,0};
	  if(ligne%2==0)
	  {
		  coordonnees[0]=311+ col*62;
		  coordonnees[1]=95+ ligne*55;
	  }
	  else
	  {
		  coordonnees[0]=341+ col*62;
		  coordonnees[1]=148+ (ligne-1)*55;
	  }
	  return coordonnees;
  }

  public int[] ConvertirCoordonneesEnCase(int x, int y){
     int coordonnees[] = {0,0};
     int i,j;
     for(i=0;i<12;i++)
     {
         for(j=0;j<12;j++)
         {
             if(i%2==0)
             {
                 if ((x>=(311 + 62*j) && x<=(369 +62*j)  && y>=(111+55*i) && y<=(142+55*i) ))
                 {
                   coordonnees[0]=i;
                   coordonnees[1]=j;
                   return coordonnees;
                 }
             }
             else
             {
                 if ((x>=(341 + 62*j) && x<=(399 +62*j)  && y>=(166+55*(i-1)) && y<=(197+55*(i-1)) ))
                 {
                 System.out.println("impair" );
                   coordonnees[0]=i;
                   coordonnees[1]=j;
                   return coordonnees;
                 }
             }
         }
     }
     return coordonnees;
}


public Unite getUnite(String unite)
{
    if(unite.equals("Archer"))
        return new Archer();
    if(unite.equals("I. legere"))
        return new Infanterie();
    if(unite.equals("I. lourde"))
        return new InfLourde();
    if(unite.equals("Mage"))
        return new Mage();
    if(unite.equals("Chevalier"))
        return new Cavalerie();

    return null;    
}

}
