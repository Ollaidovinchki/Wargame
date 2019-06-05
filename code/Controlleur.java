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
				  if ((x>=(12 + 60*i) && x<=(70 +60*i)  && y>=(80+50*j) && y<=(112+50*j) ))
				  {
					coordonnees[0]=i;
					coordonnees[1]=j;
					return coordonnees;
				  }
			  }
			  else
			  {
				  if ((x>=(42 + 60*i) && x<=(100 +60*i)  && y>=(130+50*j) && y<=(162+50*j) ))
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
