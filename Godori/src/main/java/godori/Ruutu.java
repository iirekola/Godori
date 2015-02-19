
package godori;

import java.util.ArrayList;
import java.util.List;

public class Ruutu implements Sijainti {
    private List<Kortti> kortit;
    private String nimi;
    private String maa;
    
    
    public Ruutu(String nimi) {
        this.nimi = nimi;
        this.kortit = new ArrayList<Kortti>();
        this.maa = "tyhjä";
    }

    public String toString() {
        return "Ruutu " + this.nimi;
    }
    
    public int montakoKorttia() {
        return this.kortit.size();
    }
    
    public String getMaa() {
        return this.maa;
    }
    
    public boolean sisaltaaKortin(Kortti kortti) {
        return this.kortit.contains(kortti);
    }
    
    @Override
    public String luetteleKortit() {
        if (this.kortit.isEmpty()) {
            return "Ruutu " + this.nimi + " on tyhjä";
        }
        
        String korttilista = "";
        
        for (Kortti kortti : kortit) {
            korttilista += "\n  " + kortti.toString();
        }
        
        return korttilista;
    }
    
    public void lisaaKortti(Kortti kortti) {
        kortit.add(kortti);
        this.maa = kortti.getMaa();
        
        kortti.asetaSijainti(this);
    }
    
    public List<Kortti> getKortit() {
        return this.kortit;
    }
    
    public void poistaKortti(Kortti kortti) {
        if (this.kortit.contains(kortti)) {
            this.kortit.remove(kortti);
            kortti.asetaSijainti(null);
        }
        
        if (this.kortit.isEmpty()) {
            this.maa = "tyhjä";
        }
    }
    
    public void tyhjennaRuutu() {
        for (Kortti kortti : kortit) {
            kortti.asetaSijainti(null);
        }
        
        kortit.clear();
        this.maa = "tyhjä";
    }
    
    public boolean onTyhja() {
        return this.kortit.isEmpty();
    }

    
}
