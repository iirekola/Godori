package godori;

public class Pelaaja {
    private String nimi;
    private Kasi kasi;
    private Voittopakka voittopakka;
    
    public Pelaaja(String nimi) {
        this.nimi = nimi;
        this.kasi = new Kasi();
        this.voittopakka = new Voittopakka();
    }
    
    public String toString(){
        return this.nimi;
    }
    
    public Kasi getKasi() {
        return this.kasi;
    }
    
    public String tulostaKasi() {
        return this.kasi.luetteleKortit();
    }
    
    public Voittopakka getVoittopakka() {
        return this.voittopakka;
    }
    
    public String tulostaVoittopakka() {
        return this.voittopakka.luetteleKortit();
    }
    
    public void lisaaKorttiKateen(Kortti kortti) {
        this.kasi.lisaaKortti(kortti);
    }
    
    public void lisaaKorttiVoittopakkaan(Kortti kortti) {
        this.voittopakka.lisaaKortti(kortti);
    }
    
    public int montakoKorttiaKadessa() {
       return this.kasi.montakoKorttia();
    }
}
