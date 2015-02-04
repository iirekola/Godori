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
}
