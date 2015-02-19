package godori;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pelilogiikka {

    Scanner lukija = new Scanner(System.in);
    private Poyta poyta;
    private Nostopakka nostopakka;
    private List<Pelaaja> pelaajat;

    public Pelilogiikka() {
        this.poyta = new Poyta();
        this.nostopakka = new Nostopakka();
    }

    public void kaynnista() {
        System.out.println("Godori\n" + Erotin());

        aloitaPeli();

        pelaa();

    }

    public void aloitaPeli() {
        luoPelaajat(this.lukija);
        System.out.println(Erotin());

        Korttipakka taysiPakka = luoKorttipakka();

        jaaKortit(taysiPakka);
   
        System.out.println(this.tulostaPoyta());
        
    }

    public void pelaa() {
        while (!this.nostopakka.onTyhja() && !this.poyta.onTyhja()) {
            for (Pelaaja pelaaja : this.pelaajat) {
                pelaaVuoro(pelaaja);
            }
        }
    }

    public void pelaaVuoro(Pelaaja pelaaja) {
        aloitaVuoro(pelaaja);
        pelaaKorttiKadesta(pelaaja);
        kaannaKorttiNostopakasta();
        keraaVoitot(pelaaja);
    }

    public Korttipakka luoKorttipakka() {
        Korttienluoja kl = new Korttienluoja();

        return new Korttipakka(kl.UusiPakka());
    }

    public void luoPelaajat(Scanner lukija) {
        this.pelaajat = new ArrayList<Pelaaja>();

        for (int i = 1; i <= 2; i++) {
            System.out.print("Pelaaja" + i + ", nimi: ");
            String nimi = lukija.nextLine();
            this.pelaajat.add(new Pelaaja(nimi));
        }
    }

    public void jaaKortit(Korttipakka taysiPakka) {
        taysiPakka.sekoitaKortit();

        ArrayList<Kortti> kortit = taysiPakka.getKortit();

        int i = 0;
        for (Kortti kortti : kortit) {
            if (i < 8) {
                this.poyta.lisaaKortti(kortti);
            } else if (i < 18) {
                this.pelaajat.get(0).lisaaKorttiKateen(kortti);
            } else if (i < 28) {
                this.pelaajat.get(1).lisaaKorttiKateen(kortti);
            } else {
                this.nostopakka.lisaaKortti(kortti);
            }
            i++;
        }
    }
    
    public void aloitaVuoro(Pelaaja pelaaja) {
        System.out.print("Pelaajan " + pelaaja.toString() 
                + " vuoro.\n  Näytä kortit?  Y/N  ");

        while (true) {
            String vastaus = lukija.nextLine();

            if (vastaus.equals("Y") || vastaus.equals("y")) {
                break;
            }
        }
    }

    public void pelaaKorttiKadesta(Pelaaja pelaaja) {
        System.out.println(Erotin());
        System.out.println(this.tulostaKasi(pelaaja));
        System.out.println(this.tulostaPoyta());
        
        System.out.print("\nValitse kädestäsi pelattava kortti.\n  Anna kortin numero: ");
        
        int kortinNumero = Integer.parseInt(lukija.nextLine()) - 1;
        Kortti valittu = pelaaja.getKasi().getKortit()[kortinNumero];
        
        siirraKortti(valittu, valittu.getSijainti(), this.poyta);
    }

    public void kaannaKorttiNostopakasta() {
        System.out.println(Erotin() + this.tulostaPoyta());
        System.out.println("Käännetään kortti nostopakasta...");
        // odotusominaisuus?
        Kortti kortti = this.nostopakka.nostaKortti();
        siirraKortti(kortti, this.nostopakka, this.poyta);
    }

    public void keraaVoitot(Pelaaja pelaaja) {
        System.out.println(Erotin() + this.tulostaPoyta());
        List<Kortti> voitot = this.poyta.nostettavissaOlevatKortit();
        for (Kortti kortti : voitot) {
            siirraKortti(kortti, kortti.getSijainti(), pelaaja.getVoittopakka());
        }
        System.out.println(this.tulostaVoittopakat());
    }
    
    public void siirraKortti(Kortti kortti, Sijainti s1, Sijainti s2) {
        s1.poistaKortti(kortti);
        s2.lisaaKortti(kortti);
    }

    public String tulostaKasi(Pelaaja pelaaja) {
        String palautus = "";
        palautus += pelaaja + "\n";
        palautus += pelaaja.tulostaKasi() + Erotin();
        
        return palautus;
    }

    public String tulostaPoyta() {
        String palautus = "";
        palautus += this.poyta.luetteleKortit() + Erotin();
        
        return palautus;
    }

    public String tulostaVoittopakat() {
        String palautus = "";
        for (Pelaaja pelaaja : this.pelaajat) {
            palautus += "\n\n" + pelaaja.toString() + ":\n"
                    + pelaaja.tulostaVoittopakka();
        }
        palautus += Erotin();
        
        return palautus;
    }

    public String Erotin() {
        return "\n_______________________________________________\n\n";
    }

    public List<Pelaaja> getPelaajat() {
        return this.pelaajat;
    }

    public Poyta getPoyta() {
        return this.poyta;
    }
}
