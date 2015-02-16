package ohhaawesomness.godori;

import godori.AltadorCupKortti;
import godori.Kasi;
import godori.Kortti;
import godori.Korttienluoja;
import godori.Korttipakka;
import godori.MaisemaKortti;
import godori.NeopetKortti;
import godori.Nostopakka;
import godori.PetpetKortti;
import godori.Poyta;
import godori.Ruutu;
import godori.Sijainti;
import godori.Voittopakka;
import java.util.ArrayList;

public class Paaohjelma {

    public static void main(String[] args) {
        Kortti n = new NeopetKortti("Testi1", "Lost Desert", false);
        Kortti p = new PetpetKortti("Testi2", "Faerieland", true, false);
        Kortti a = new AltadorCupKortti("Testi3", "Roo Island", "vaakuna");
        Kortti m = new MaisemaKortti("Testi4", "Faerieland", false);
        
        Voittopakka v = new Voittopakka();
        v.lisaaKortti(p);
        v.lisaaKortti(m);
        v.lisaaKortti(a);
        v.lisaaKortti(n);
        
        System.out.println(v.luetteleKortit());
//        
//        v.poistaKortti(n);
//        
//        System.out.println(v.luetteleKortit());
//        System.out.println("n sijainti: " + n.getSijainti() + ", p sijainti: " + p.getSijainti());
    }

}
