package godori;

import java.util.ArrayList;
import java.util.List;

public class Voittopakka implements Sijainti {
    private List<Kortti> voitetutKortit;
    
    public Voittopakka() {
        this.voitetutKortit = new ArrayList<Kortti>();
    }
    
    public String toString() {
        return "voittopakka";
    }
    
    public void lisaaKortti(Kortti kortti) {
        this.voitetutKortit.add(kortti);
        kortti.asetaSijainti(this);
    }

    @Override
    public String luetteleKortit() {
        String palautus = "Voittopakan sisältämät kortit:";
        
        if (voitetutKortit.isEmpty()) {
            return "Voittopakassa ei ole yhtään korttia.";
        }
        
        for (Kortti kortti : voitetutKortit) {
            palautus += "\n  " + kortti.toString();
        }
        
        return palautus;
    }
    
    public void poistaKortti(Kortti kortti) {
        this.voitetutKortit.remove(kortti);
        kortti.asetaSijainti(null);
    }
}   

