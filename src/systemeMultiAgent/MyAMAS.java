package systemeMultiAgent;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import fr.irit.smac.amak.Amas;
import fr.irit.smac.amak.Scheduling;

//import java.text.SimpleDateFormat;


public class MyAMAS extends Amas<Salle>{
	  
	public MyAMAS(Salle env) {
	        super(env, Scheduling.DEFAULT);
	       
	        
	    }
	    @Override
	    protected void onInitialAgentsCreation() {
	    	AgentLumiereIntelligente[] l = new AgentLumiereIntelligente[getEnvironment().getCapteurLum().length];
	    	AgentVolletAuto[] v = new AgentVolletAuto[getEnvironment().getCapteurLum().length];
	        //Create one light an one shutter per captors
	        for (int i=0;i<getEnvironment().getCapteurLum().length-1;i++) 
	        {
	            l[i] =new AgentLumiereIntelligente(i, this, getEnvironment().getCapteurLum()[i], getEnvironment().getCapteurLum()[i+1]);
	            v[i] =new AgentVolletAuto(i, this, getEnvironment().getCapteurLum()[i], getEnvironment().getCapteurLum()[i+1],getEnvironment().sc);
	        }
	    }

public static void main(String[] args) {
	Salle env = new Salle( );
	MyAMAS myAMAS = new MyAMAS(env);
	

	//env.heure.get(Calendar.MINUTE);
    	
  
    //Affichage de la date et l'heure actuelle de Notre Systeme
    //Date date = new Date();
    //String str = String.format("Date/heure actuelle : %tc", date );
  //  System.out.printf(str);
    //System.out.printf("\n");

}

}