package godori;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PelaajaTest {
    
    public PelaajaTest() {
    }
    Pelaaja p = new Pelaaja("Pasi");
    Kortti n = new NeopetKortti("Testi", "Altador", true);
    Kortti pp = new PetpetKortti("Testi2", "Altador", false, false);
    Kortti ac = new AltadorCupKortti("Testi3", "Altador", "viiri");
    Kortti m = new MaisemaKortti("Testi4", "Altador", true);
    
    @Test
    public void toStringToimii() {
        assertEquals("Pasi", p.toString());
    }
    
    @Test
    public void konstruktoriTekeeKaden() {
        assertFalse(p.getKasi() == null);
    }
    
    @Test
    public void konstruktoriTekeeVoittopakan() {
        Voittopakka verrattava = new Voittopakka();
        
        assertFalse(p.getVoittopakka() == null);
    }
    
    @Test
    public void tulostaKasiToimiiKunTyhja() {
        assertEquals("Kädessä ei ole yhtään korttia.", p.tulostaKasi());
    }
    
    @Test
    public void tulostaKasiToimiiKunEiTyhja() {
        p.lisaaKorttiKateen(n);
        
        assertEquals("Kädessä olevat kortit:\n" +
                    "1:  Testi", p.tulostaKasi());
    }
    
    @Test
    public void tulostaVoittopakkaToimiiKunTyhja() {
        assertEquals("Voittopakassa ei ole yhtään korttia.", p.tulostaVoittopakka());
    }
    
    @Test
    public void tulostaVoittopakkaToimiiKunEiTyhja() {
        p.lisaaKorttiVoittopakkaan(n);
        
        assertEquals("Voittopakan sisältämät kortit:\n" +
                        "\n" +
                        "  Testi", p.tulostaVoittopakka());
    }
    
    @Test
    public void tulostaVoittopakkaToimiiKunEiTyhja2() {
        p.lisaaKorttiVoittopakkaan(n);
        p.lisaaKorttiVoittopakkaan(pp);
        p.lisaaKorttiVoittopakkaan(ac);
        p.lisaaKorttiVoittopakkaan(m);
        
        assertEquals("Voittopakan sisältämät kortit:\n" +
                        "\n" +
                        "  Testi\n" +
                        "\n" +
                        "  Testi2\n" +
                        "\n" +
                        "  Testi3\n" +
                        "\n" +
                        "  Testi4", p.tulostaVoittopakka());
    }
}
