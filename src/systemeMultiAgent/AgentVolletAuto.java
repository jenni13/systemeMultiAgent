package systemeMultiAgent;

import fr.irit.smac.amak.Agent;

public class AgentVolletAuto  extends Agent<MyAMAS,Salle>{
	
	public AgentVolletAuto(int id, MyAMAS amas, CapteurLuminosite left, CapteurLuminosite right) {
        super(amas);
        this.id = id;
        this.left = left;
        this.right = right;
    }

}
