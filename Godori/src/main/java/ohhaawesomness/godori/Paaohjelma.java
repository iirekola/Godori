package ohhaawesomness.godori;

import godori.Kortti;
import godori.Korttienluoja;
import godori.Korttipakka;
import java.util.ArrayList;

public class Paaohjelma {

    public static void main(String[] args) {
        
       
//        k.add(new Kortti("testi2", "Altador"));
//        
//        Korttipakka pakka = new Korttipakka(k);
//       // System.out.println(pakka);
//        
//        for (Kortti kortti : k) {
//            System.out.println(kortti.getSijainti());
//        }
        
        
        Kortti kortti = new Kortti("testi", "Altador");
        System.out.println(kortti.getMaa() + "\n");
        System.out.println(kortti.toString() +"\n");
        System.out.println(kortti.getSijainti() +"\n");
        
        ArrayList<Kortti> k = new ArrayList<Kortti>();
        k.add(kortti);
        
        System.out.println("lisättiin listaan\n");
        System.out.println(kortti.getSijainti() +"\n");
        
        Korttipakka pakka = new Korttipakka(k);
        System.out.println(kortti.getSijainti() +"\n");
        
        
    }
    
}
