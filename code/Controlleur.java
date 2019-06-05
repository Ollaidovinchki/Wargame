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
                 if ((x>=(311 + 62*i) && x<=(358 +62*i)  && y>=(95+55*j) && y<=(135+55*j) ))
                 {
                   coordonnees[0]=i;
                   coordonnees[1]=j;
                   return coordonnees;
                 }
             }
             else
             {
                 if ((x>=(341 + 62*i) && x<=(398 +62*i)  && y>=(148+55*j) && y<=(188+55*j) ))
                 {
                   coordonnees[0]=i;
                   coordonnees[1]=j;
                   return coordonnees;
                 }
             }
         }
     }
     return coordonnees;
}


}
