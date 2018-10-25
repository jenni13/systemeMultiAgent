
package systemeMultiAgent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class SatisfationClient {

    ArrayList<Integer> notes;
    double moyenne;

    public SatisfationClient()
    {
        this.moyenne = 0.0;
        this.notes = new ArrayList<Integer>();
    }


    public ArrayList<Integer> addNote()
    {
    	int r;
    	Random rand = new Random();
		r = rand.nextInt(20) + 1;
		
        notes.add(r);
        return notes;

    }
    public ArrayList<Integer> getNote()
    {
        return notes;
    }

    public double getMoyenne()
    {
    	System.out.println("moy = "+moyenne);
        return moyenne;
    }

    public void calculMoyenne(ArrayList<Integer> listNotes) 
    {
        listNotes = this.notes;
        Iterator<Integer> it = listNotes.iterator();
        int somme = 0;

        while (it.hasNext()) {
            somme += it.next();
            this.moyenne = somme / listNotes.size();
        }


    }
    public ArrayList<Integer> randNotes(ArrayList<Integer> n)
    {
    	int r;
    	for(int i = 0 ;i<10;i++)
    	{
    		Random rand = new Random();
    		r = rand.nextInt(20) + 1;
    		n.add(r);
    	}
        
        return n;
    	
    }
    public ArrayList<Integer>removeNote()
    {
    	notes.remove(0);
    	return notes;
    }
    public void afficherNotes(ArrayList<Integer> n)
    {
    	for(int i=0;i<n.size();i++)
    		System.out.print(n.get(i)+" ");
    }

    
    }

