
package systemeMultiAgent;

import fr.irit.smac.amak.Agent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SatisfationClient {

    ArrayList<Double> notes = new ArrayList<Double>();
    double moyenne;

    public SatisfationClient()
    {
        this.moyenne = 0.0;
    }


    private void addNote(ArrayList<Double> tab,double note)
    {
        tab.add(note);

    }
    private ArrayList<Double> getNote()
    {
        return notes;
    }

    private double getMoyenne()
    {
        return moyenne;
    }

    public void calculMoyenne(double newNote) {
        ArrayList<Double> listNotes = this.notes;
        Iterator<Double> it = listNotes.iterator();
        int somme = 0;

        listNotes.add(newNote);
        while (it.hasNext()) {
            somme += it.next();
            this.moyenne = somme / listNotes.size();
        }


    }}

