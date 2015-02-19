package godori;


import godori.Kortti;
import godori.Nostopakka;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class NostopakkaTest {
    
    public NostopakkaTest() {
    }
    Nostopakka pakka = new Nostopakka();
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void toStringToimii() {
        assertEquals("Nostopakka", pakka.toString());
    }

    @Test
    public void tyhjaPakkaTulostuuOikein() {
        String verrattava = pakka.luetteleKortit();

        assertEquals("Nostopakassa ei ole yhtään korttia.", verrattava);
    }
    
    @Test
    public void korttienTulostusToimiiYhdella() {
        pakka.lisaaKortti(new Kortti("testi", "Altador"));
        
        String verrattava = pakka.luetteleKortit();

        assertEquals("Nostopakan sisältämät kortit:\n  testi", verrattava);
    }

    @Test
    public void korttienTulostusToimiiUsealla() {
        pakka.lisaaKortti(new Kortti("testi", "Altador"));
        pakka.lisaaKortti(new Kortti("testi2", "Altador"));
        pakka.lisaaKortti(new Kortti("testi3", "Altador"));

        String verrattava = pakka.luetteleKortit();

        assertEquals("Nostopakan sisältämät kortit:\n  testi\n  testi2\n  testi3", verrattava);
    }
    
    @Test
    public void kortinAsetusToimii() {
        Kortti testi = new Kortti("testi", "Altador");
        pakka.lisaaKortti(testi);
        
        assertEquals("Nostopakka", testi.getSijainti().toString());
    }
    
    @Test
    public void korttiPoistuuPakasta() {
        Kortti testi = new Kortti("testi", "Altador");
        pakka.lisaaKortti(testi);
        
        pakka.poistaKortti(testi);
        
        assertEquals("Nostopakassa ei ole yhtään korttia.", pakka.luetteleKortit());
    }
    
    @Test
    public void poistetunKortinSijaintiNull() {
        Kortti testi = new Kortti("testi", "Altador");
        pakka.lisaaKortti(testi);
        
        pakka.poistaKortti(testi);
        
        assertEquals(null, testi.getSijainti());
    }
    
    @Test
    public void onTyhjaToimiiKunTyhja() {
        assertTrue(pakka.onTyhja());
    }
    
    @Test
    public void onTyhjaToimiiKunEiOleTyhja() {
        Kortti testi = new Kortti("testi", "Altador");
        pakka.lisaaKortti(testi);
        
        assertFalse(pakka.onTyhja());
    }
}
