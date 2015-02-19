package godori;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.junit.Test;
import static org.junit.Assert.*;

public class PelilogiikkaAloitusTest {
    
    public PelilogiikkaAloitusTest() {
    }
    Pelilogiikka l = new Pelilogiikka();
    Korttienluoja luoja = new Korttienluoja();
//    
    Kortti n = new NeopetKortti("Testi1", "Testi1", false);
    Kortti p = new PetpetKortti("Testi2", "Testi2", true, false);
    Kortti a = new AltadorCupKortti("Testi3", "Testi3", "Testi");
    Kortti m = new MaisemaKortti("Testi4", "Testi4", false);
    
    @Test
    public void luoKorttipakkaToimii() {
        assertEquals(new Korttipakka(luoja.UusiPakka()).toString(), l.luoKorttipakka().toString());
    }
    
    @Test
    public void luoPelaajatToimii() {
        List<Pelaaja> verrattava = new ArrayList<Pelaaja>();
        verrattava.add(new Pelaaja("Testi"));
        verrattava.add(new Pelaaja("Testi2"));
        
        Scanner syote = new Scanner("Testi\nTesti2");
        
        l.luoPelaajat(syote);
        
        assertEquals(verrattava.toString(), l.getPelaajat().toString());
    }
    
    @Test
    public void jaaKortitSekoittaaPakan() {
        Scanner syote = new Scanner("Testi\nTesti2");
        
        l.luoPelaajat(syote);
        
        Korttipakka alkuperainen = l.luoKorttipakka();
        Korttipakka sekoitettu = l.luoKorttipakka();
        
        l.jaaKortit(sekoitettu);
        assertFalse(alkuperainen.luetteleKortit().equals(sekoitettu.luetteleKortit()));
    }
    
    @Test
    public void jaaKortitJakaaPoydan() {
        Scanner syote = new Scanner("Testi\nTesti2");
        
        l.luoPelaajat(syote);
        l.jaaKortit(l.luoKorttipakka());
        
        assertEquals(8, l.getPoyta().montakoKorttia());
    }
    
    @Test
    public void jaaKortitJakaaKadenPelaajalle1() {
        Scanner syote = new Scanner("Testi\nTesti2");
        
        l.luoPelaajat(syote);
        l.jaaKortit(l.luoKorttipakka());
        
        assertEquals(10, l.getPelaajat().get(0).montakoKorttiaKadessa());
    }
    
    @Test
    public void jaaKortitJakaaKadenPelaajalle2() {

        Scanner syote = new Scanner("Testi\nTesti2");

        l.luoPelaajat(syote);
        l.jaaKortit(l.luoKorttipakka());

        assertEquals(10, l.getPelaajat().get(1).montakoKorttiaKadessa());
    }
    
}
