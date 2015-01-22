package godori;

import java.util.ArrayList;
import java.util.List;

public class Korttienluoja {
        private ArrayList<Kortti> korttipakka = new ArrayList<Kortti>();
    
    public void luoKortit() {
        
        this.luoNeopetit();
        this.luoPetpetit();
        this.luoAltadorCupit();
        this.luoMaisemat();
    }
    
    public void luoNeopetit() {
        korttipakka.add(new NeopetKortti("Space Station, Neopet", "Space Station", false));
        korttipakka.add(new NeopetKortti("Haunted Woods, Neopet", "Haunted Woods", true));
        korttipakka.add(new NeopetKortti("Shenkuu, Neopet", "Shenkuu", false));
        korttipakka.add(new NeopetKortti("Terror Mountain, Neopet", "Terror Mountain", false));
        korttipakka.add(new NeopetKortti("Lost Desert, Neopet", "Lost Desert", false));
    }
    
    public void luoPetpetit() {
        korttipakka.add(new PetpetKortti("Faerieland, Petpet", "Faerieland", true, false));
        korttipakka.add(new PetpetKortti("Space Station, Petpet", "Space Station", true, false));
        korttipakka.add(new PetpetKortti("Haunted Woods, Petpet", "Haunted Woods", false, false));
        korttipakka.add(new PetpetKortti("Altador, Petpet", "Altador", true, false));
        korttipakka.add(new PetpetKortti("Tyrannia, Petpet", "Tyrannia", false, false));
        korttipakka.add(new PetpetKortti("Krawk Island, Petpet", "Krawk Island", false, false));
        korttipakka.add(new PetpetKortti("Roo Island, Petpet", "Roo Island", false, false));
        korttipakka.add(new PetpetKortti("Meridell, Petpet", "Meridell", false, false));
        korttipakka.add(new PetpetKortti("Mystery Island, Petpet", "Mystery Island", false, true));
    }
    
    public void luoAltadorCupit() {
        korttipakka.add(new AltadorCupKortti("Faerieland, Altador Cup", "Faerieland", "vaakuna"));
        korttipakka.add(new AltadorCupKortti("Tyrannia, Altador Cup", "Tyrannia", "vaakuna"));
        korttipakka.add(new AltadorCupKortti("Roo Island, Altador Cup", "Roo Island", "vaakuna"));
        
        korttipakka.add(new AltadorCupKortti("Altador, Altador Cup", "Altador", "viiri"));
        korttipakka.add(new AltadorCupKortti("Shenkuu, Altador Cup", "Shenkuu", "viiri"));
        korttipakka.add(new AltadorCupKortti("Terror Mountain, Altador Cup", "Terror Mountain", "viiri"));
        
        korttipakka.add(new AltadorCupKortti("Krawk Island, Altador Cup", "Krawk Island", "nauha"));
        korttipakka.add(new AltadorCupKortti("Meridell, Altador Cup", "Meridell", "nauha"));
        korttipakka.add(new AltadorCupKortti("Mystery Island, Altador Cup", "Mystery Island", "nauha"));
    
        
        korttipakka.add(new AltadorCupKortti("Haunted Woods, Altador Cup", "Haunted Woods", null));
    }
    
    public void luoMaisemat() {
        korttipakka.add(new MaisemaKortti("Faerieland, maisema1", "Faerieland", false));
        korttipakka.add(new MaisemaKortti("Faerieland, maisema2", "Faerieland", false));
        
        korttipakka.add(new MaisemaKortti("Space Station, maisema1", "Space Station", false));
        korttipakka.add(new MaisemaKortti("Space Station, maisema2", "Space Station", false));
        
        korttipakka.add(new MaisemaKortti("Haunted Woods, maisema", "Haunted Woods", true));
        
        korttipakka.add(new MaisemaKortti("Altador, maisema1", "Altador", false));
        korttipakka.add(new MaisemaKortti("Altador, maisema2", "Altador", false));
        
        korttipakka.add(new MaisemaKortti("Shenkuu, maisema1", "Shenkuu", false));
        korttipakka.add(new MaisemaKortti("Shenkuu, maisema2", "Shenkuu", false));
        
        korttipakka.add(new MaisemaKortti("Tyrannia, maisema1", "Tyrannia", false));
        korttipakka.add(new MaisemaKortti("Tyrannia, maisema2", "Tyrannia", false));
        
        korttipakka.add(new MaisemaKortti("Krawk Island, maisema1", "Krawk Island", false));
        korttipakka.add(new MaisemaKortti("Krawk Island, maisema2", "Krawk Island", false));
        
        korttipakka.add(new MaisemaKortti("Terror Mountain, maisema1", "Terror Mountain", false));
        korttipakka.add(new MaisemaKortti("Terror Mountain, maisema2", "Terror Mountain", false));
        
        korttipakka.add(new MaisemaKortti("Roo Island, maisema1", "Roo Island", false));
        korttipakka.add(new MaisemaKortti("Roo Island, maisema2", "Roo Island", false));
        
        korttipakka.add(new MaisemaKortti("Lost Desert, maisema1", "Lost Desert", false));
        korttipakka.add(new MaisemaKortti("Lost Desert, maisema2", "Lost Desert", false));
        korttipakka.add(new MaisemaKortti("Lost Desert, maisema3", "Lost Desert", false));
        
        korttipakka.add(new MaisemaKortti("Meridell, maisema1", "Meridell", false));
        korttipakka.add(new MaisemaKortti("Meridell, maisema2", "Meridell", false));
        
        korttipakka.add(new MaisemaKortti("Mystery Island, maisema1", "Mystery Island", false));
        korttipakka.add(new MaisemaKortti("Mystery Island, maisema2", "Mystery Island", false));
    }
    
    public ArrayList<Kortti> getKorttipakka() {
        return korttipakka;
    }
}
