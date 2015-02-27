package godori;

/**
 * Luokka kuvaa pelaajaa ja sisältää metodit käden ja voittopakan käsittelyyn
 */
public class Pelaaja {
    private String nimi;
    private Kasi kasi;
    private Voittopakka voittopakka;
    private int pisteet;
    
    public Pelaaja(String nimi) {
        this.nimi = nimi;
        this.kasi = new Kasi();
        this.voittopakka = new Voittopakka();
        this.pisteet = 0;
    }
    
    public String toString(){
        return this.nimi;
    }
    
    public Kasi getKasi() {
        return this.kasi;
    }
    
    public int getPisteet() {
        return this.pisteet;
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
    
    public void laskePisteet() {
        this.pisteet += this.voittopakka.laskePisteet();
    }
    
    public void tyhjennaPakat() {
        this.kasi.tyhjenna();
        this.voittopakka.tyhjenna();
    }
    
    public void nollaaPisteet() {
        this.pisteet = 0;
    } 

    void tyhjennaVoittopakka() {
        this.voittopakka.tyhjenna();
    }
    
}
