package systemeMultiAgent;

import fr.irit.smac.amak.Amas;
import fr.irit.smac.amak.Scheduling;

public class MyAMAS extends Amas<Salle>{
	  
	public MyAMAS(Salle env) {
	        super(env, Scheduling.DEFAULT);
	    }
	    @Override
	    protected void onInitialAgentsCreation() {
	    	AgentLumiereIntelligente[] l = new AgentLumiereIntelligente[getEnvironment().getCapteurLum().length];
	    	//AgentVolletAuto[] v = new AgentVolletAuto[getEnvironment().getCapteurLum().length];
	        //Create one agent per fork
	        for (int i=0;i<getEnvironment().getCapteurLum().length-1;i++) {
	            l[i] =new AgentLumiereIntelligente(i, this, getEnvironment().getCapteurLum()[i], getEnvironment().getCapteurLum()[i+1]);
	            // l[i] =new AgentVolletAuto(i, this, getEnvironment().getCapteurLum()[i], getEnvironment().getCapteurLum()[i+1]);
	        }

	        //Let the last philosopher takes the first fork (round table) 
	        l[getEnvironment().getCapteurLum().length-1]=new AgentLumiereIntelligente(getEnvironment().getCapteurLum().length-1, this, getEnvironment().getCapteurLum()[getEnvironment().getCapteurLum().length-1], getEnvironment().getCapteurLum()[0]);
	        //l[getEnvironment().getCapteurLum().length-1] =new AgentVolletAuto(i, this, getEnvironment().getCapteurLum()[i], getEnvironment().getCapteurLum()[i+1]);

	        //Add neighborhood
	        for (int i=1;i<l.length;i++) {
	            l[i].addNeighbor(l[i-1]);
	            l[i-1].addNeighbor(l[i]);
	        }
	        l[0].addNeighbor(l[l.length-1]);
	        l[l.length-1].addNeighbor(l[0]);
	    }



public static void main(String[] args) {
    Salle env = new Salle();
    new MyAMAS(env);
}

}