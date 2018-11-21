package systemeMultiAgent;
import java.util.Random;

public class CapteurLuminosite {
    int n;

   /* public int Valeur ()
    {
        Random rand = new Random();
        n = rand.nextInt(20) + 1;
        System.out.println("Luminosité = " + n);
        return n;
    }
    */
   public int Valeur()
    {	
	   System.out.println("n = "+n+"\n");
    	if (n >= 20)
    		n = 0;
    	
    	else
    		n++;
    	System.out.println("n = "+n+"\n");
    	return n;
    	
    }
}