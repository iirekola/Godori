
package godori;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Luokka kuvaa täyttä kortipakkaa
 */
public class Korttipakka implements Sijainti{
    private ArrayList<Kortti> kortit;
    
    public Korttipakka(ArrayList<Kortti> kortit) {
        this.kortit = kortit;
        
        for (Kortti kortti : kortit) {
            kortti.asetaSijainti(this);
        }
    }
    
    public String toString() {
        return "korttipakka";
    }
    
    public String luetteleKortit() {
        String palautus = "Korttipakan sisältämät kortit:";
        
        if (kortit.isEmpty()) {
            return "Korttipakassa ei ole yhtään korttia.";
        }
        
        for (Kortti kortti : kortit) {
            palautus += "\n  " + kortti.toString();
        }
        
        return palautus;
    }
    
    public void sekoitaKortit() {
        Collections.shuffle(kortit);
    }

    @Override
    public void lisaaKortti(Kortti kortti) {    
        // nothing happens
    }

    @Override
    public void poistaKortti(Kortti kortti) {
        // nothing happens
    }
    
    public ArrayList<Kortti> getKortit() {
        return this.kortit;
    }

    @Override
    public void tyhjenna() {
        // nothing happens
    }
    
}
