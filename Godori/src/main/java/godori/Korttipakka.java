
package godori;

import java.util.ArrayList;

public class Korttipakka {
    private ArrayList<Kortti> kortit;
    
    public Korttipakka(ArrayList<Kortti> kortit) {
        this.kortit = kortit;
    }
    
    public String toString() {
        String palautus = "";
        
        for (Kortti kortti : kortit) {
            palautus += kortti;
        }
        
        return palautus;
    }
}
