package systemeMultiAgent;

import java.util.Random;

import fr.irit.smac.amak.Agent;
import fr.irit.smac.lxplot.LxPlot;
import fr.irit.smac.lxplot.commons.ChartType;
import systemeMultiAgent.AgentLumiereIntelligente.State;

public class AgentVolletAuto  extends Agent<MyAMAS,Salle>{
	
    private CapteurLuminosite interieur;
    private CapteurLuminosite exterieur;
    private SatisfationClient s;
    int id;
    
    
    public enum State {
        OUVERT, FERMER
    }

    private State state = State.OUVERT;
    
	public AgentVolletAuto(int id, MyAMAS amas,CapteurLuminosite interieur,CapteurLuminosite exterieur,SatisfationClient s)
	{
        super(amas);
        this.id = id;
        this.interieur = interieur;
        this.exterieur = exterieur;
        this.s=s;
    }
	
    @Override
    protected void onPerceive() 
    {
        // Nothing goes here as the perception of neighbors criticality is already made
        // by the framework
    }
    
    @Override
    protected void onDecideAndAct() {
    	State nextState = state;
        switch (state) {
        
        case OUVERT:
        	if(this.amas.getEnvironment().heure.after(this.amas.getEnvironment().heured) && this.amas.getEnvironment().heure.before(this.amas.getEnvironment().heuref))
            {

    			if(interieur.Valeur()<10 || exterieur.Valeur()>15)
    			{
    				System.out.println("Ouverture volet numero "+ this.id);
    				nextState=State.OUVERT;
    				break;
    			}
    			if(s.getMoyenne()<5)
    			{
    				
    				System.out.println("Mauvaise satisfaction "+ this.id);
    				s.addNote();
    				s.removeNote();
    				s.afficherNotes(s.getNote());
    				s.calculMoyenne(s.getNote());
    				
    				break;
    			}
    			else if(s.getMoyenne()>=5)
    			{
    				System.out.println("Bonne satisfaction "+ this.id);
    				
    				s.addNote();
    				s.removeNote();
    				s.afficherNotes(s.getNote());
    				s.calculMoyenne(s.getNote());
    				s.getMoyenne();
    				break;
    			}
            }
        		
        case FERMER:
        		if(this.amas.getEnvironment().heure.before(this.amas.getEnvironment().heured) || this.amas.getEnvironment().heure.after(this.amas.getEnvironment().heuref))
        		{
        			System.out.println("Volets car hors des heure d'ouverture" + this.id);
                    nextState=State.FERMER;
                    break;
        		}

        		if (exterieur.Valeur()<10)
        		{
        			System.out.println("fermeture volet numero "+ this.id);
        			nextState=State.FERMER;
        			break;
        			
        		}
        		
      			if(s.getMoyenne()<5)
    			{
    				System.out.println(" Mauvaise satisfaction "+ this.id);
    				s.addNote();
    				s.removeNote();
    				s.afficherNotes(s.getNote());
    				s.calculMoyenne(s.getNote());
    				s.getMoyenne();

    				break;
    			}
      			
    			if(s.getMoyenne()>=5)
    			{
    				System.out.println("Bonne satisfaction "+ this.id);
    				
    				s.addNote();
    				s.removeNote();
    				s.afficherNotes(s.getNote());
    				s.calculMoyenne(s.getNote());
    				s.getMoyenne();
    				break;
    			}

        default:
        	break;

        }
        state = nextState;
        System.out.println ("Je suis "+ state);

       
    }

    @Override
    protected void onUpdateRender()
    {
        LxPlot.getChart("Etat Volets", ChartType.BAR).add(id, exterieur.Valeur());

    }
}
