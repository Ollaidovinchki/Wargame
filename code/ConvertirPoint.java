import java.util.Scanner;
public class ConvertirPoint{
  public static int[] ConvertirPoint(int ligne, int col){             
	  int coordonn�es[] = {0,0};
	  if(ligne%2==0)
	  {
		  coordonn�es[0]=12+ col*60;
		  coordonn�es[1]=65+ ligne*50;
	  }
	  else
	  {
		  coordonn�es[0]=42+ col*60;
		  coordonn�es[1]=115+ (ligne-1)*50;
	  }
	  return coordonn�es;
  }   
  public static int[] ConvertirCoordonn�es(int x, int y){             
	  int coordonn�es[] = {0,0};
	  int i,j;
	  for(i=0;i<12;i++)
	  {
		  for(j=0;j<12;j++)
		  {
			  if(i%2==0)
			  {
				  if ((x>=(12 + 60*i) && x<=(70 +60*i)  && y>=(80+50*j) && y<=(112+50*j) ))
				  {
					coordonn�es[0]=i;
					coordonn�es[1]=j;
					return coordonn�es;
				  }
			  }
			  else
			  {
				  if ((x>=(42 + 60*i) && x<=(100 +60*i)  && y>=(130+50*j) && y<=(162+50*j) ))
				  {
					coordonn�es[0]=i;
					coordonn�es[1]=j;
					return coordonn�es;
				  } 
			  }
		  }
	  }
	  return coordonn�es;
  }   
  public static void main(String[] args) {
	  Scanner sc = new Scanner(System.in);
	  System.out.print( "entrer x");
	  int str = sc.nextInt();
	  System.out.print( "entrer y");
	  int str2 = sc.nextInt();
	  int testcoord[]= {0,0};
	  testcoord=ConvertirCoordonn�es(str,str2);
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