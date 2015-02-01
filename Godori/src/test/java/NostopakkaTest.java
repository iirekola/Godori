
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
    Nostopakka pakka;
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void tyhjaPakkaTulostuuOikein() {
        pakka = new Nostopakka();
        String verrattava = pakka.luetteleKortit();

        assertEquals("Nostopakassa ei ole yhtään korttia.", verrattava);
    }
    
    @Test
    public void korttienTulostusToimiiYhdella() {
        pakka = new Nostopakka();
        pakka.lisaaKortti(new Kortti("testi", "Altador"));
        
        String verrattava = pakka.luetteleKortit();

        assertEquals("Nostopakan sisältämät kortit:\n  testi", verrattava);
    }

    @Test
    public void korttienTulostusToimiiUsealla() {
        pakka = new Nostopakka();
        
        pakka.lisaaKortti(new Kortti("testi", "Altador"));
        pakka.lisaaKortti(new Kortti("testi2", "Altador"));
        pakka.lisaaKortti(new Kortti("testi3", "Altador"));

        String verrattava = pakka.luetteleKortit();

        assertEquals("Nostopakan sisältämät kortit:\n  testi\n  testi2\n  testi3", verrattava);
    }
}
