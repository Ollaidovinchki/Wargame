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
		  coordonnees[0]=12+ col*60;
		  coordonnees[1]=65+ ligne*50;
	  }
	  else
	  {
		  coordonnees[0]=42+ col*60;
		  coordonnees[1]=115+ (ligne-1)*50;
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
