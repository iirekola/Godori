
package godori;

public class Ruutu implements Sijainti {
    private Kortti kortti;
    private String nimi;
    
    public Ruutu(String nimi) {
        this.nimi = nimi;
    }

    public String toString() {
        return "Ruutu" + this.nimi;
    }
    
    @Override
    public String luetteleKortit() {
        if (this.kortti == null) {
            return "Ruutu " + this.nimi + " on tyhjä";
        }
        
        return "Ruudussa " + this.nimi + ": " + this.kortti.toString();
    }
    
    public void lisaaKortti(Kortti kortti) {
        if (this.kortti != null) {
            this.kortti.asetaSijainti(null);
        }
        
        this.kortti = kortti;
        kortti.asetaSijainti(this);
    }
    
    public void poistaKortti(Kortti kortti) {
        this.kortti.asetaSijainti(null);
        this.kortti = null;
    }

    
}
