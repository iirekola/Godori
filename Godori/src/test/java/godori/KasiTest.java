package godori;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KasiTest {

    public KasiTest() {
    }

    Kasi kasi = new Kasi();
    Kortti k = new Kortti("testi", "Altador");
    Kortti k2 = new Kortti("testi2", "Altador");

    @Before
    public void setUp() {
    }
    
    @Test
    public void luetteleKortitToimiiKunTyhja() {
        assertEquals("Kädessä ei ole yhtään korttia.", kasi.luetteleKortit());
    }

    @Test
    public void lisaaKorttiToimii() {
        kasi.lisaaKortti(k);
        
        assertEquals("Kädessä olevat kortit:\n  testi", kasi.luetteleKortit());
    }
    
    @Test
    public void lisaaKorttiMuuttaaSijainnin() {
        kasi.lisaaKortti(k);
        
        assertEquals("Käsi", k.getSijainti().toString());
    }

    @Test
    public void lisaaKorttiToimiiUsealla() {
        kasi.lisaaKortti(k);
        kasi.lisaaKortti(k2);
        
        assertEquals("Kädessä olevat kortit:\n  testi\n  testi2", kasi.luetteleKortit());
    }
    
    @Test
    public void poistaKorttiToimiiKunRuudussaKyseinenKortti() {
        kasi.lisaaKortti(k);
        kasi.poistaKortti(k);
        
        assertEquals("Kädessä ei ole yhtään korttia.", kasi.luetteleKortit());
    }
    
    @Test
    public void poistaKorttiToimiiKunRuudussaEiKyseistäKorttia() {
        kasi.lisaaKortti(k);
        kasi.poistaKortti(k2);
        
        assertEquals("Kädessä olevat kortit:\n  testi", kasi.luetteleKortit());
    }
    
    @Test
    public void poistaKorttiPoistaaKortinSijainnin() {
        kasi.lisaaKortti(k);
        kasi.poistaKortti(k);
        
        assertEquals(null, k.getSijainti());
    }
    
    @Test
    public void poistaKorttiEiPoistaMuitaKortteja() {
        kasi.lisaaKortti(k);
        kasi.lisaaKortti(k2);
        kasi.poistaKortti(k2);
        
        assertEquals("Kädessä olevat kortit:\n  testi", kasi.luetteleKortit());
    }
}
