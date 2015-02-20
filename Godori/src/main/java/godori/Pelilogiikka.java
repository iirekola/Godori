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

        paataPeli();

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

    public void paataPeli() {
        for (Pelaaja pelaaja : this.pelaajat) {
            laskePisteet(pelaaja);
        }
    }

//    //                 //     //
//    ALOITA PELI - METODIT     //
//    //                 //     //
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
        this.poyta.merkkaaAloituskadenParit();
    }

//    //            //      //
//    PELAA - METODIT       //
//    //            //      //
    public void pelaaVuoro(Pelaaja pelaaja) {
        try {
            aloitaVuoro(pelaaja);
            pelaaKorttiKadesta(pelaaja);
            Thread.sleep(2000);
            kaannaKorttiNostopakasta();
            Thread.sleep(4000);
            keraaVoitot(pelaaja);
        } catch (Exception e) {
            aloitaVuoro(pelaaja);
            pelaaKorttiKadesta(pelaaja);
            kaannaKorttiNostopakasta();
            keraaVoitot(pelaaja);
        }
    }

    public void aloitaVuoro(Pelaaja pelaaja) {
        System.out.println("Pelaajan " + pelaaja.toString()
                + " vuoro.");

        while (true) {
            System.out.print("  Näytä kortit?  Y/N  ");
            String vastaus = lukija.nextLine();

            if (vastaus.equals("Y") || vastaus.equals("y")) {
                break;
            }
        }

        System.out.println(Erotin());
        System.out.println(this.tulostaKasi(pelaaja));
        System.out.println(this.tulostaPoyta());
    }

    public void pelaaKorttiKadesta(Pelaaja pelaaja) {
        System.out.print("\nValitse kädestäsi pelattava kortti.\n  Anna kortin numero: ");

        int kortinNumero = Integer.parseInt(lukija.nextLine());

        Kortti valittu = pelaaja.getKasi().getJarjestysnumeroaVastaavaKortti(kortinNumero);
        System.out.println("\nPelataan kortti pöytään...\n  " + valittu);

        siirraKortti(valittu, valittu.getSijainti(), this.poyta);

        System.out.println(Erotin() + this.tulostaPoyta());
    }

    public void kaannaKorttiNostopakasta() {
        System.out.println("Käännetään kortti nostopakasta...");
        // odotusominaisuus?
        Kortti kortti = this.nostopakka.nostaKortti();
        siirraKortti(kortti, this.nostopakka, this.poyta);
        System.out.println("  " + kortti);

        System.out.println(Erotin() + this.tulostaPoyta());
    }

    public void keraaVoitot(Pelaaja pelaaja) {
        List<Kortti> voitot = this.poyta.nostettavissaOlevatKortit();
        String kortit = "";
        for (Kortti kortti : voitot) {
            kortit += "\n  " + kortti;
            siirraKortti(kortti, kortti.getSijainti(), pelaaja.getVoittopakka());
        }
        System.out.println("Kerätään voitot..." + kortit);
        System.out.println(this.tulostaVoittopakat());
    }

//    //                //     //
//    PAATA PELI - METODIT     //
//    //                //     //
    public void laskePisteet(Pelaaja pelaaja) {

    }

//    //              //      //
//    YLEISET - METODIT       //
//    //              //      //    
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
