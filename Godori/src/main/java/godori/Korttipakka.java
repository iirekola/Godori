
package godori;

import java.util.ArrayList;

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
    
    public void jaaKortit() {
        // jakaa kortit
    }

    @Override
    public void lisaaKortti(Kortti kortti) {    
        // nothing happens
    }

    @Override
    public void poistaKortti(Kortti kortti) {
        // nothing happens
    }
    
}
