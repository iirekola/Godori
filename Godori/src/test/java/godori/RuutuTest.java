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
    
    
    @Test
    public void toStringToimii() {
        assertEquals("Ruutu r1", r.toString());
    }

    @Test
    public void lisaaKorttiToimii() {
        r.lisaaKortti(k);
        
        assertEquals("Ruudussa r1:\n  testi", r.luetteleKortit());
    }
    
    @Test
    public void lisaaKorttiMuuttaaSijainnin() {
        r.lisaaKortti(k);
        
        assertEquals("Ruutu r1", k.getSijainti().toString());
    }
    
    @Test
    public void lisaaKorttiMuuttaaMaan() {
        r.lisaaKortti(k);
        
        assertEquals("Altador", r.getMaa());
    }
    
    @Test
    public void lisaaKorttiToimiiUsealla() {
        r.lisaaKortti(k);
        r.lisaaKortti(k2);
        
        assertEquals("Ruudussa r1:\n  testi\n  testi2", r.luetteleKortit());
    }
    
    @Test
    public void luetteleKortitKunRuutuOnTyhja() {
        assertEquals("Ruutu r1 on tyhjä", r.luetteleKortit());
    }
    
    @Test
    public void poistaKorttiToimiiKunRuudussaKyseinenKortti() {
        r.lisaaKortti(k);
        r.poistaKortti(k);
        
        assertEquals("Ruutu r1 on tyhjä", r.luetteleKortit());
    }
    
    @Test
    public void poistaKorttiToimiiKunRuudussaEiKyseistäKorttia() {
        r.lisaaKortti(k);
        r.poistaKortti(k2);
        
        assertEquals("Ruudussa r1:\n  testi", r.luetteleKortit());
    }
    
    @Test
    public void poistaKorttiPoistaaKortinSijainnin() {
        r.lisaaKortti(k);
        r.poistaKortti(k);
        
        assertEquals(null, k.getSijainti());
    }
    
    @Test
    public void poistaKorttiEiPoistaMuitaKortteja() {
        r.lisaaKortti(k);
        r.lisaaKortti(k2);
        r.poistaKortti(k2);
        
        assertEquals("Ruudussa r1:\n  testi", r.luetteleKortit());
    }
    
    @Test
    public void poistaKorttiPoistaaMaan() {
        r.lisaaKortti(k);
        r.poistaKortti(k);
        
        assertEquals("tyhjä", r.getMaa());
    }
    
    @Test
    public void montakoKorttiaToimii0() {
        assertEquals(0, r.montakoKorttia());
    }
    
    @Test
    public void montakoKorttiaToimii1() {
        r.lisaaKortti(k);
        
        assertEquals(1, r.montakoKorttia());
    }
    
    @Test
    public void montakoKorttiaToimii2() {
        r.lisaaKortti(k);
        r.lisaaKortti(k2);
        
        assertEquals(2, r.montakoKorttia());
    }
    
    @Test
    public void sisaltaaKortinToimiiKunTrue() {
        r.lisaaKortti(k);
        
        assertTrue(r.sisaltaaKortin(k));
    }
    
    @Test
    public void sisaltaaKortinToimiiKunFalse() {
        r.lisaaKortti(k);
        
        assertFalse(r.sisaltaaKortin(k2));
    }
    
    @Test
    public void sisaltaaKortinToimiiKunTyhja() {
        assertFalse(r.sisaltaaKortin(k));
    }
    
    @Test
    public void tyhjennaRuutuToimii() {
        r.lisaaKortti(k);
        r.lisaaKortti(k2);
        
        r.tyhjennaRuutu();
        
        assertEquals(0, r.montakoKorttia());
    }
    
    @Test
    public void tyhjennaRuutuTyhjentaaSijainnin() {
        r.lisaaKortti(k);
        r.lisaaKortti(k2);
        
        r.tyhjennaRuutu();
        
        assertEquals(null, k2.getSijainti());
    }
    
    @Test
    public void onTyhjaToimiiKunTrue() {
        assertTrue(r.onTyhja());
    }
    
    @Test
    public void onTyhjaToimiiKunFalse() {
        r.lisaaKortti(k);
        
        assertFalse(r.onTyhja());
    }
    
}
