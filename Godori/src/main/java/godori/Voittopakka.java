package godori;

import java.util.ArrayList;
import java.util.List;

public class Voittopakka implements Sijainti {
    private List<Kortti> neopetKortit;
    private List<Kortti> petpetKortit;
    private List<Kortti> acKortit;
    private List<Kortti> maisemaKortit;
    
    public Voittopakka() {
        this.neopetKortit = new ArrayList<Kortti>();
        this.petpetKortit = new ArrayList<Kortti>();
        this.acKortit = new ArrayList<Kortti>();
        this.maisemaKortit = new ArrayList<Kortti>();
    }
    
    public String toString() {
        return "Voittopakka";
    }
    
    public void lisaaKortti(Kortti kortti) {
        
        String tyyppi = selvitaKortinTyyppi(kortti);
        
        if (tyyppi.equals("Neopet")) {
            this.neopetKortit.add(kortti);
        } else if (tyyppi.equals("Petpet")) {
            this.petpetKortit.add(kortti);
        } else if (tyyppi.equals("AC")) {
            this.acKortit.add(kortti);
        } else if (tyyppi.equals("Maisema")) {
            this.maisemaKortit.add(kortti);
        }
        
        kortti.asetaSijainti(this);
    }

    @Override
    public String luetteleKortit() {
        String palautus = "Voittopakan sisältämät kortit:";
        
        List[] pakat = {this.neopetKortit, this.petpetKortit, this.acKortit, this.maisemaKortit};
        
        for (List<Kortti> pakka : pakat) {
            if (!pakka.isEmpty()) {
                palautus += "\n" + luettelePakanKortit(pakka);
            }
        }
        
        if (onTyhja()) {
            return "Voittopakassa ei ole yhtään korttia.";
        }
        
        return palautus;
    }
    
    public void poistaKortti(Kortti kortti) {
        List<Kortti> olinpaikka = this.missaPakassa(kortti);
        
        if (olinpaikka != null) {
            olinpaikka.remove(kortti);
            kortti.asetaSijainti(null);
        }
    }
    
    public String selvitaKortinTyyppi(Kortti kortti) {
        Kortti n = new NeopetKortti("Testi", "Testi", false);
        Kortti p = new PetpetKortti("Testi", "Testi", true, false);
        Kortti a = new AltadorCupKortti("Testi", "Testi", "Testi");
        Kortti m = new MaisemaKortti("Testi", "Testi", false);
        
        if (kortti.getClass() == n.getClass()) {
            return "Neopet";
        } else if (kortti.getClass() == p.getClass()) {
            return "Petpet";
        } else if (kortti.getClass() == a.getClass()) {
            return "AC";
        } else if (kortti.getClass() == m.getClass()) {
            return "Maisema";
        } else {
            return "99";
        }
    }
    
    public String luettelePakanKortit(List<Kortti> pakka) {
        String palautus = "";
        for (Kortti kortti : pakka) {
            palautus += "\n  " + kortti.toString();
        }
        return palautus;
    }
    
    public List<Kortti> missaPakassa(Kortti kortti) {
        if (this.neopetKortit.contains(kortti)) {
            return this.neopetKortit;
        } else if (this.petpetKortit.contains(kortti)) {
            return this.petpetKortit;
        } else if (this.acKortit.contains(kortti)) {
            return this.acKortit;
        } else if (this.maisemaKortit.contains(kortti)) {
            return this.maisemaKortit;
        } else {
            return null;
        }
    }
    
    public boolean onTyhja() {
        if (this.neopetKortit.isEmpty()) {
            if (this.petpetKortit.isEmpty()) {
                if (this.acKortit.isEmpty()) {
                    if (this.maisemaKortit.isEmpty()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public int getNeopetPisteet() {
        
        if (this.neopetKortit.size() == 5) {
            return 15;
        } else if (this.neopetKortit.size() == 4) {
            return 4;
        } else if (this.neopetKortit.size() == 3 && SisaltaaHauntedWoods() == false) {
            return 3;
        } else if (this.neopetKortit.size() == 3 && SisaltaaHauntedWoods()) {
            return 2;
        } else {
            return 0;
        }
        
    }
    
    public boolean SisaltaaHauntedWoods() {
        for (Kortti kortti : this.neopetKortit) {
            if (kortti.onErityinen()) {
                return true;
            }
        }
        return false;
    }
    
    public int getPetpetPisteet() {
        int pisteet = 0;
        
        return pisteet;
    }
    
    public int getACPisteet() {
        int pisteet = 0;
        
        return pisteet;
    }
    
    public int getMaisemaPisteet() {
        int pisteet = 0;
        
        return pisteet;
    }
}   

