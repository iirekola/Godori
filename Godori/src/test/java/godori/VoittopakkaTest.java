package godori;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VoittopakkaTest {

    public VoittopakkaTest() {
    }
    Voittopakka v = new Voittopakka();
    Kortti n = new NeopetKortti("Testi1", "Testi1", false);
    Kortti p = new PetpetKortti("Testi2", "Testi2", true, false);
    Kortti a = new AltadorCupKortti("Testi3", "Testi3", "Testi");
    Kortti m = new MaisemaKortti("Testi4", "Testi4", false);

    @Test
    public void toStringToimii() {
        assertEquals("Voittopakka", v.toString());
    }

    @Test
    public void lisaaKorttiToimii() {
        v.lisaaKortti(n);

        assertEquals("Voittopakan sisältämät kortit:\n"
                        + "\n"
                        + "  Testi1", v.luetteleKortit());
    }

    @Test
    public void lisaaKorttiMuuttaaSijainnin() {
        v.lisaaKortti(n);

        assertEquals("Voittopakka", n.getSijainti().toString());
    }
    
    @Test
    public void lisaaKorttiToimiiUsealla() {
        v.lisaaKortti(n);
        v.lisaaKortti(p);
        
        assertEquals("Voittopakan sisältämät kortit:\n" +
                        "\n" +
                        "  Testi1\n" +
                        "\n" +
                        "  Testi2", v.luetteleKortit());
    }
    
    @Test
    public void luetteleKortitKunPakkaOnTyhja() {
        assertEquals("Voittopakassa ei ole yhtään korttia.", v.luetteleKortit());
    }
    
    @Test
    public void poistaKorttiToimiiKunPakassaKyseinenKortti() {
        v.lisaaKortti(p);
        v.poistaKortti(p);
        
        assertEquals("Voittopakassa ei ole yhtään korttia.", v.luetteleKortit());
    }
    
    @Test
    public void poistaKorttiToimiiKunPakassaEiKyseistäKorttia() {
        v.lisaaKortti(n);
        v.poistaKortti(p);
        
        assertEquals("Voittopakan sisältämät kortit:\n"
                        + "\n"
                        + "  Testi1", v.luetteleKortit());
    }
    
    @Test
    public void poistaKorttiPoistaaKortinSijainnin() {
        v.lisaaKortti(p);
        v.poistaKortti(p);
        
        assertEquals(null, p.getSijainti());
    }
    
    @Test
    public void poistaKorttiEiPoistaMuitaKortteja() {
        v.lisaaKortti(n);
        v.lisaaKortti(p);
        v.poistaKortti(p);
        
        assertEquals("Voittopakan sisältämät kortit:\n"
                        + "\n"
                        + "  Testi1", v.luetteleKortit());
    }
    
    @Test
    public void kortitLajitellaanOikein() {
        v.lisaaKortti(m);
        v.lisaaKortti(p);
        v.lisaaKortti(a);
        v.lisaaKortti(n);
        
        assertEquals("Voittopakan sisältämät kortit:\n" +
                        "\n" +
                        "  Testi1\n" +
                        "\n" +
                        "  Testi2\n" +
                        "\n" +
                        "  Testi3\n" +
                        "\n" +
                        "  Testi4", v.luetteleKortit());
    }
}
