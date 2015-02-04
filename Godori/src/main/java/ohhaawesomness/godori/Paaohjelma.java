package ohhaawesomness.godori;

import godori.Kortti;
import godori.Korttienluoja;
import godori.Korttipakka;
import godori.Nostopakka;
import godori.Ruutu;
import godori.Sijainti;
import java.util.ArrayList;

public class Paaohjelma {

    public static void main(String[] args) {
        
        Nostopakka n = new Nostopakka();
        Ruutu r = new Ruutu("r1");
        
        Kortti k1 = new Kortti("Pasi", "Hertta");
        Kortti k2  = new Kortti("Kaisa", "Risti");
        System.out.println("Korttien sijainnit: " + k1 + ": " + k1.getSijainti() + ", " + k2 + ": " + k2.getSijainti());
        
        n.lisaaKortti(k1);
        r.lisaaKortti(k2);
        
        System.out.println("Korttien sijainnit: " + k1 + ": " + k1.getSijainti() + ", " + k2 + ": " + k2.getSijainti());
        System.out.println(r.luetteleKortit());
        
    }
    
}
