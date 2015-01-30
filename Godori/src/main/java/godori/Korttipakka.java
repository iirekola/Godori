
package godori;

import java.util.ArrayList;

public class Korttipakka {
    private ArrayList<Kortti> kortit;
    
    public Korttipakka(ArrayList<Kortti> kortit) {
        this.kortit = kortit;
    }
    
    public String toString() {
        String palautus = "Korttipakan sisältämät kortit:";
        
        if (kortit.isEmpty()) {
            return "  Pakassa ei ole yhtään korttia.";
        }
        
        for (Kortti kortti : kortit) {
            palautus += "\n  " + kortti.toString();
        }
        
        return palautus;
    }
}
