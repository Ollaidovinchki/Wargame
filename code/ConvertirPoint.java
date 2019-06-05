import java.util.Scanner;
public class ConvertirPoint{
  public static int[] ConvertirPoint(int ligne, int col){             
	  int coordonnées[] = {0,0};
	  if(ligne%2==0)
	  {
		  coordonnées[0]=12+ col*60;
		  coordonnées[1]=65+ ligne*50;
	  }
	  else
	  {
		  coordonnées[0]=42+ col*60;
		  coordonnées[1]=115+ (ligne-1)*50;
	  }
	  return coordonnées;
  }   
  public static int[] ConvertirCoordonnées(int x, int y){             
	  int coordonnées[] = {0,0};
	  int i,j;
	  for(i=0;i<12;i++)
	  {
		  for(j=0;j<12;j++)
		  {
			  if(i%2==0)
			  {
				  if ((x>=(12 + 60*i) && x<=(70 +60*i)  && y>=(80+50*j) && y<=(112+50*j) ))
				  {
					coordonnées[0]=i;
					coordonnées[1]=j;
					return coordonnées;
				  }
			  }
			  else
			  {
				  if ((x>=(42 + 60*i) && x<=(100 +60*i)  && y>=(130+50*j) && y<=(162+50*j) ))
				  {
					coordonnées[0]=i;
					coordonnées[1]=j;
					return coordonnées;
				  } 
			  }
		  }
	  }
	  return coordonnées;
  }   
  public static void main(String[] args) {
	  Scanner sc = new Scanner(System.in);
	  System.out.print( "entrer x");
	  int str = sc.nextInt();
	  System.out.print( "entrer y");
	  int str2 = sc.nextInt();
	  int testcoord[]= {0,0};
	  testcoord=ConvertirCoordonnées(str,str2);
	  System.out.println("Ligne:"+testcoord[0]+"Colonne :"+testcoord[1]); 
	  System.out.print( "entrer i");
	  int str3 = sc.nextInt();
	  System.out.print( "entrer j");
	  int str4 = sc.nextInt();
	  int testpoint[]= {0,0};
	  testpoint=ConvertirPoint(str3,str4);
	  System.out.println("X:"+testpoint[0]+"Y:"+testpoint[1]); 

	  }
}
