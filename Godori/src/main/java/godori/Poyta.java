package godori;

import java.util.ArrayList;
import java.util.List;

public class Poyta implements Sijainti {
    private Ruutu[] ruudut = new Ruutu[12];

    public Poyta() {
        
        ruudut[0] = new Ruutu("1");
        ruudut[1] = new Ruutu("2");
        ruudut[2] = new Ruutu("3");
        ruudut[3] = new Ruutu("4");
        ruudut[4] = new Ruutu("5");
        ruudut[5] = new Ruutu("6");
        ruudut[6] = new Ruutu("7");
        ruudut[7] = new Ruutu("8");
        ruudut[8] = new Ruutu("9");
        ruudut[9] = new Ruutu("10");
        ruudut[10] = new Ruutu("11");
        ruudut[11] = new Ruutu("12");  
    }
    
    public String toString() {
        return "Pöytä";
    }

    @Override
    public String luetteleKortit() {
        String palautus = "Pöydässä olevat kortit:";

        int korttienMaara = 0;
        for (Ruutu ruutu : ruudut) {
            if (ruutu.onTyhja()) {
                continue;
            }
            palautus += "\n" + ruutu.luetteleKortit();
            korttienMaara += ruutu.montakoKorttia();
        }

        if (korttienMaara == 0) {
            return "Pöydässä ei ole yhtään korttia.";
        }

        return palautus;
    }

    @Override
    public void lisaaKortti(Kortti kortti) {

        boolean lisatty = false;
        for (Ruutu ruutu : ruudut) {
            if (ruutu.getMaa().equals(kortti.getMaa())) {
                ruutu.lisaaKortti(kortti);
                lisatty = true;
                break;
            }

        }

        if (lisatty == false) {
            for (Ruutu ruutu : ruudut) {
                if (ruutu.onTyhja()) {
                    ruutu.lisaaKortti(kortti);
                    break;
                }
            }
        }
    }

    @Override
    public void poistaKortti(Kortti kortti) {
        for (int i = 0; i < ruudut.length; i++) {
            if (ruudut[i].sisaltaaKortin(kortti)) {
                ruudut[i].poistaKortti(kortti);
            }
        }
    }
    
    public boolean onTyhja() {
        
        for (Ruutu ruutu : this.ruudut) {
            if (!ruutu.onTyhja()) {
                return false;
            }
        }
        
        return true;
    }
    
    public int montakoKorttia() {
        int montako = 0;
        for (Ruutu ruutu : this.ruudut) {
            montako += ruutu.montakoKorttia();
        }
        
        return montako;
    }
    
    public List<Kortti> nostettavissaOlevatKortit() {
        List<Kortti> nostettavissaOlevat = new ArrayList<Kortti>();
        
        for (Ruutu ruutu : this.ruudut) {
            if (ruutu.montakoKorttia() == 4) {
                for (Kortti kortti : ruutu.getKortit()) {
                    nostettavissaOlevat.add(kortti);
                }
            } else if (!ruutu.onAloituskadenPari() && ruutu.montakoKorttia() == 2) {
                for (Kortti kortti : ruutu.getKortit()) {
                    nostettavissaOlevat.add(kortti);
                }
            }
        }
        return nostettavissaOlevat;
    }
    
    public void merkkaaAloituskadenParit() {
        for (Ruutu ruutu : this.ruudut) {
            if (ruutu.montakoKorttia() == 2) {
                ruutu.pariAloituskadessaTrue();
            }
        }
    }
}
