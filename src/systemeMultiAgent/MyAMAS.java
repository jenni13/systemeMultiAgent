package systemeMultiAgent;

import fr.irit.smac.amak.Amas;
import fr.irit.smac.amak.Scheduling;

public class MyAMAS extends Amas<Table>{
	  
	public MyAMAS(Table env) {
	        super(env, Scheduling.DEFAULT);
	    }
	    @Override
	    protected void onInitialAgentsCreation() {
	        Philosopher[] p = new Philosopher[getEnvironment().getForks().length];
	        //Create one agent per fork
	        for (int i=0;i<getEnvironment().getForks().length-1;i++) {
	            p[i] =new Philosopher(i, this, getEnvironment().getForks()[i], getEnvironment().getForks()[i+1]);
	        }

	        //Let the last philosopher takes the first fork (round table) 
	        p[getEnvironment().getForks().length-1]=new Philosopher(getEnvironment().getForks().length-1, this, getEnvironment().getForks()[getEnvironment().getForks().length-1], getEnvironment().getForks()[0]);


	        //Add neighborhood
	        for (int i=1;i<p.length;i++) {
	            p[i].addNeighbor(p[i-1]);
	            p[i-1].addNeighbor(p[i]);
	        }
	        p[0].addNeighbor(p[p.length-1]);
	        p[p.length-1].addNeighbor(p[0]);
	    }



public static void main(String[] args) {
    Table env = new Table();
    new MyAMAS(env);
}

}