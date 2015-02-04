
package godori;

import java.util.ArrayList;
import java.util.List;

public class Nostopakka implements Sijainti {
    private List<Kortti> nostettavissaOlevat;
    
    public Nostopakka() {
        this.nostettavissaOlevat = new ArrayList<Kortti>();
    }
    
    public String toString() {
        return "nostopakka";
    }
    
    public void lisaaKortti(Kortti kortti) {
        this.nostettavissaOlevat.add(kortti);
        kortti.asetaSijainti(this);
    }

    @Override
    public String luetteleKortit() {
        String palautus = "Nostopakan sisältämät kortit:";
        
        if (nostettavissaOlevat.isEmpty()) {
            return "Nostopakassa ei ole yhtään korttia.";
        }
        
        for (Kortti kortti : nostettavissaOlevat) {
            palautus += "\n  " + kortti.toString();
        }
        
        return palautus;
    }
    
    public void poistaKortti(Kortti kortti) {
        this.nostettavissaOlevat.remove(kortti);
        kortti.asetaSijainti(null);
    }
}   
