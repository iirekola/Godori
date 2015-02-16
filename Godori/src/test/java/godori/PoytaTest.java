package godori;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PoytaTest {
    
    public PoytaTest() {
    }
    Poyta p = new Poyta();
    Kortti k = new Kortti("testi", "Altador");
    Kortti k2 = new Kortti("testi2", "Altador");
    Kortti k3 = new Kortti("testi3", "Shenkuu");

    @Before
    public void setUp() {
    }
    
    @Test
    public void toStringToimii() {
        assertEquals("Pöytä", p.toString());
    }

    @Test
    public void lisaaKorttiToimiiYhdella() {
        p.lisaaKortti(k);
        
        assertEquals("Pöydässä olevat kortit:\n" +
                            "Ruudussa 1:\n" +
                            "  testi", p.luetteleKortit());
    }
    
    @Test
    public void lisaaKorttiToimiiKunSamaaMaata() {
        p.lisaaKortti(k);
        p.lisaaKortti(k2);
        
        assertEquals("Pöydässä olevat kortit:\n" +
                            "Ruudussa 1:\n" +
                            "  testi\n" +
                            "  testi2", p.luetteleKortit());
    }
    
    @Test
    public void lisaaKorttiToimiiKunEriMaata() {
        p.lisaaKortti(k);
        p.lisaaKortti(k3);
        
        assertEquals("Pöydässä olevat kortit:\n" +
                        "Ruudussa 1:\n" +
                        "  testi\n" +
                        "Ruudussa 2:\n" +
                        "  testi3", p.luetteleKortit());
    }
    
    @Test
    public void luetteleKortitKunPoytaOnTyhja() {
        assertEquals("Pöydässä ei ole yhtään korttia.", p.luetteleKortit());
    }
    
    @Test
    public void poistaKorttiToimiiKunPoydassaKyseinenKortti() {
        p.lisaaKortti(k);
        p.poistaKortti(k);
        
        assertEquals("Pöydässä ei ole yhtään korttia.", p.luetteleKortit());
    }
    
    @Test
    public void poistaKorttiToimiiKunPoydassaEiKyseistäKorttia() {
        p.lisaaKortti(k);
        p.poistaKortti(k2);
        
        assertEquals("Pöydässä olevat kortit:\n" +
                            "Ruudussa 1:\n" +
                            "  testi", p.luetteleKortit());
    }
    
    @Test
    public void poistaKorttiEiPoistaMuitaKortteja() {
        p.lisaaKortti(k);
        p.lisaaKortti(k2);
        p.poistaKortti(k2);
        
        assertEquals("Pöydässä olevat kortit:\n" +
                            "Ruudussa 1:\n" +
                            "  testi", p.luetteleKortit());
    }

}
