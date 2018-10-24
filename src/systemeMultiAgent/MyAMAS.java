package systemeMultiAgent;

import fr.irit.smac.amak.Amas;
import fr.irit.smac.amak.Scheduling;

public class MyAMAS extends Amas<Salle>{
	  
	public MyAMAS(Salle env) {
	        super(env, Scheduling.DEFAULT);
	    }
	    @Override
	    protected void onInitialAgentsCreation() {
	    	//AgentLumiereIntelligente[] l = new AgentLumiereIntelligente[getEnvironment().getCapteurLum().length];
	    	AgentVolletAuto[] v = new AgentVolletAuto[getEnvironment().getCapteurLum().length];
	        //Create one light an one shutter per captors
	        for (int i=0;i<getEnvironment().getCapteurLum().length-1;i++) 
	        {
	            //l[i] =new AgentLumiereIntelligente(i, this, getEnvironment().getCapteurLum()[i], getEnvironment().getCapteurLum()[i+1]);
	            v[i] =new AgentVolletAuto(i, this, getEnvironment().getCapteurLum()[i], getEnvironment().getCapteurLum()[i+1]);
	        }
	    }



public static void main(String[] args) {
    Salle env = new Salle();
    new MyAMAS(env);
}

}