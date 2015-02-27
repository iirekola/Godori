package godori;

/**
 * Ei mikään maailman fiksuin luokka, yhdistetty pelilogiikka ja tekstikäyttöliittymä
 * Sisältää kaikki metodit toiminnallisuutta ja käyttöliittymää varten
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Pelilogiikka {

    Scanner lukija = new Scanner(System.in);
    private Poyta poyta;
    private Nostopakka nostopakka;
    private List<Pelaaja> pelaajat;
    private Korttipakka taysiPakka;

    public Pelilogiikka() {
        this.poyta = new Poyta();
        this.nostopakka = new Nostopakka();
    }

    public void kaynnista() {
        System.out.println("Godori\n" + erotin());

        aloitaPeli();

        pelaa();

        paataKierros();

    }

    public void uusiKierros() {
        System.out.println("Godori\n" + erotin());
        
        tyhjennaVoittopakat();

        valitseAloittavaPelaaja();

        aloitaKierros();

        pelaa();

        paataKierros();
    }

    public void aloitaPeli() {
        luoPelaajat(this.lukija);
        System.out.println(erotin());

        taysiPakka = luoKorttipakka();

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

    public void paataKierros() {
        for (Pelaaja pelaaja : this.pelaajat) {
            pelaaja.laskePisteet();
        }

        tulostaKierroksenLopputulos();

        if (lopetetaankoPeli() == false) {
            aloitetaankoKierros();
            uusiKierros();
        } else {
            tulostaVoittaja();
            lopetaPeli();
        }
    }

    public void aloitaKierros() {
        tyhjennaVoittopakat();
        
        System.out.println("Uusi kierros alkaa...\n" + erotin());

        jaaKortit(taysiPakka);

        System.out.println(this.tulostaPoyta());
    }
    
    public void lopetaPeli() {
        System.out.print("Uusi peli? y/n ");
        
        while (true) {
            String vastaus = lukija.nextLine();
            
            if (vastaus.equals("N") || vastaus.equals("n")) {
                break;
            } else if (vastaus.equals("Y") || vastaus.equals("y")) {
                uusiPeli();
            }
        }
    }
    
    public void uusiPeli() {
        this.nostopakka.tyhjenna();
        for (Pelaaja pelaaja : pelaajat) {
            pelaaja.tyhjennaPakat();
        }
    }

    public void valitseAloittavaPelaaja() {
        Collections.reverse(pelaajat);
    }
    
    public void tyhjennaVoittopakat() {
        for (Pelaaja pelaaja : pelaajat) {
            pelaaja.tyhjennaVoittopakka();
        }
    }

//    //                 //     //
//    ALOITA PELI - METODIT     //
//    //                 //     //
    public Korttipakka luoKorttipakka() {
        Korttienluoja kl = new Korttienluoja();

        return new Korttipakka(kl.uusiPakka());
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

        System.out.println(erotin());
        System.out.println(this.tulostaKasi(pelaaja));
        System.out.println(this.tulostaPoyta());
    }

    public void pelaaKorttiKadesta(Pelaaja pelaaja) {

        System.out.print("\nValitse kädestäsi pelattava kortti.");
        Kortti valittu = null;

        while (true) {
            System.out.print("\n  Anna kortin numero: ");
            int kortinNumero = 0;
            try {
                kortinNumero = Integer.parseInt(lukija.nextLine());
            }
            catch (Exception e) {
                continue;
            }
            valittu = pelaaja.getKasi().getJarjestysnumeroaVastaavaKortti(kortinNumero);

            if (valittu != null) {
                break;
            }
            
            System.out.print("Valitsemaasi korttia ei löytynyt. Yritä uudestaan. ");
        }
        System.out.println("\nPelataan kortti pöytään...\n  " + valittu);

        siirraKortti(valittu, valittu.getSijainti(), this.poyta);

        System.out.println(erotin() + this.tulostaPoyta());
    }

    public void kaannaKorttiNostopakasta() {
        System.out.println("Käännetään kortti nostopakasta...");
        // odotusominaisuus?
        Kortti kortti = this.nostopakka.nostaKortti();
        siirraKortti(kortti, this.nostopakka, this.poyta);
        System.out.println("  " + kortti);

        System.out.println(erotin() + this.tulostaPoyta());
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
    public boolean lopetetaankoPeli() {
        for (Pelaaja pelaaja : this.pelaajat) {
            if (pelaaja.getPisteet() >= 50) {
                return true;
            }
        }
        return false;
    }

    public void tulostaKierroksenLopputulos() {
        System.out.println("Pisteet kierroksen jälkeen:");

        for (Pelaaja pelaaja : pelaajat) {
            System.out.println("\n  " + pelaaja + ": " + pelaaja.getPisteet());
        }

        System.out.println(erotin());
    }

    public void aloitetaankoKierros() {
        System.out.print("Aloita seuraava kierros? y/n ");

        while (true) {
            String vastaus = lukija.nextLine();
            if (vastaus.equals("Y") || vastaus.equals("y")) {
                break;
            }
            System.out.println("valitse 'y' aloittaksesi seuraavan kierroksen. ");
        }
        System.out.println(erotin());
    }

    public void tulostaVoittaja() {
        Pelaaja voittaja = null;
        int pisteet = 50;

        for (Pelaaja pelaaja : pelaajat) {
            if (pelaaja.getPisteet() > pisteet) {
                voittaja = pelaaja;
                pisteet = pelaaja.getPisteet();
            }
        }

        System.out.println("Voittaja on: " + voittaja.toString() + "\n  pisteet: " + voittaja.getPisteet() + "\n  Onneksi olkoon!");
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
        palautus += pelaaja.tulostaKasi() + erotin();

        return palautus;
    }

    public String tulostaPoyta() {
        String palautus = "";
        palautus += this.poyta.luetteleKortit() + erotin();

        return palautus;
    }

    public String tulostaVoittopakat() {
        String palautus = "";
        for (Pelaaja pelaaja : this.pelaajat) {
            palautus += "\n\n" + pelaaja.toString() + ":\n"
                    + pelaaja.tulostaVoittopakka();
        }
        palautus += erotin();

        return palautus;
    }

    public String erotin() {
        return "\n_______________________________________________\n\n";
    }

    public List<Pelaaja> getPelaajat() {
        return this.pelaajat;
    }

    public Poyta getPoyta() {
        return this.poyta;
    }
}
