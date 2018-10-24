package systemeMultiAgent;
import java.util.Random;

public class CapteurLuminosite {
    //private AgentLumiereIntelligente takenBy;
    int n;


    public CapteurLuminosite(int n) {
        this.n = n;
    }
 public int Valeur ()
 {
     Random rand = new Random();
     n = rand.nextInt(50) + 1;

     System.out.println("Luminosité = " + n);
     return n;
 }

}
/*
    public synchronized boolean tryTake(AgentLumiereIntelligente asker) {
        if (takenBy != null)
            return false;
        takenBy = asker;
        return true;
    }

    public synchronized void release(AgentLumiereIntelligente asker) {
        if (takenBy == asker) {
            takenBy = null;
        }
    }

    public synchronized boolean owned(AgentLumiereIntelligente asker) {
        return takenBy == asker;
    }
    */


