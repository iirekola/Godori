package ohhaawesomness.godori;

import godori.Kasi;
import godori.Kortti;
import godori.Korttienluoja;
import godori.Korttipakka;
import godori.Nostopakka;
import godori.Poyta;
import godori.Ruutu;
import godori.Sijainti;
import java.util.ArrayList;

public class Paaohjelma {

    public static void main(String[] args) {
        Kortti k = new Kortti("testi", "Shenkuu");
        Kortti k1 = new Kortti("testi1", "Altador");
        Kortti k2 = new Kortti("testi2", "Altador");
        Kortti k3 = new Kortti("testi3", "Suomi");
      
        Poyta p = new Poyta();

        p.lisaaKortti(k);
        p.lisaaKortti(k1);
        p.lisaaKortti(k2);
        p.lisaaKortti(k3);
//        System.out.println(p.luetteleKortit());
        
        System.out.println("testin sijainti: " + k.getSijainti());
        System.out.println("test3:n sijainti: " + k3.getSijainti());

    }

}
