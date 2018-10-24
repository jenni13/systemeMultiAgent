package systemeMultiAgent;
import java.util.Random;

public class CapteurLuminosite {
    //private AgentLumiereIntelligente takenBy;
    int n;


    /*public CapteurLuminosite(int n) {
        this.n = n;
    }*/
 public int Valeur ()
 {
     Random rand = new Random();
     n = rand.nextInt(20) + 1;
     System.out.println("Luminosité = " + n);
     return n;
 }

}

