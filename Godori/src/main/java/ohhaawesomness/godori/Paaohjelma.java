package ohhaawesomness.godori;

import godori.Kortti;
import godori.Korttienluoja;
import godori.Korttipakka;
import java.util.ArrayList;

public class Paaohjelma {

    public static void main(String[] args) {
        
        ArrayList<Kortti> k = new ArrayList<Kortti>();
        k.add(new Kortti("testi", "Altador"));
        k.add(new Kortti("testi2", "Altador"));
        Korttipakka pakka = new Korttipakka(k);
        System.out.println(pakka);
        
    }
    
}
