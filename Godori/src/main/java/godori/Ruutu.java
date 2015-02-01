
package godori;

public class Ruutu implements Sijainti {
    private Kortti kortti;

    public String toString() {
        return "Ruutu";
    }
    
    @Override
    public String luetteleKortit() {
        return this.kortti.toString();
    }
    
    public void asetaKortti(Kortti kortti) {
        this.kortti = kortti;
        kortti.asetaSijainti(this);
    }
    
    public void poistaKortti() {
        this.kortti = null;
    }
}
