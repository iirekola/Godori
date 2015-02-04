package godori;


import godori.Kortti;
import godori.Ruutu;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RuutuTest {
    
    public RuutuTest() {
    }
    Ruutu r = new Ruutu("r1");
    Kortti k = new Kortti("testi", "Altador");
    Kortti k2 = new Kortti("testi2", "Altador");
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void lisaaKorttiToimii() {
        r.lisaaKortti(k);
        
        assertEquals("Ruudussa r1: testi", r.luetteleKortit());
    }
    
    @Test
    public void lisaaKorttiToimiiKunRuudussaOnJoKortti() {
        r.lisaaKortti(k);
        r.lisaaKortti(k2);
        
        assertEquals("Ruudussa r1: testi2", r.luetteleKortit());
    }
    
    @Test
    public void lisaaKorttiKunRuudussaOnJoKorttiPoistaaVanhanKortinSijainnin() {
        r.lisaaKortti(k);
        r.lisaaKortti(k2);
        
        assertEquals(null, k.getSijainti());
    }
    
    @Test
    public void luetteleKortitKunRuutuOnTyhja() {
        assertEquals("Ruutu r1 on tyhjä", r.luetteleKortit());
    }
    
    @Test
    public void poistaKorttiToimii() {
        r.lisaaKortti(k);
        r.poistaKortti(null);
        
        assertEquals("Ruutu r1 on tyhjä", r.luetteleKortit());
    }
    
    @Test
    public void poistaKorttiPoistaaKortinSijainnin() {
        r.lisaaKortti(k);
        r.poistaKortti(null);
        
        assertEquals(null, k.getSijainti());
    }
}
