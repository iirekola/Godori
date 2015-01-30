
import godori.Kortti;
import godori.Korttipakka;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KorttipakkaTest {

    public KorttipakkaTest() {
    }
    Korttipakka pakka;
    ArrayList<Kortti> k;

    @Before
    public void setUp() {
        k = new ArrayList<Kortti>();
    }
    
    

    @Test
    public void konstruktoriToimii1() {
        k.add(new Kortti("testi", "Altador"));
        k.add(new Kortti("testi2", "Altador"));
        pakka = new Korttipakka(k);
        
        assertEquals("Korttipakan sisältämät kortit:\n  testi\n  testi2", pakka.luetteleKortit());
        
    }
    
    @Test
    public void konstruktoriToimii2() {
        Kortti kortti = new Kortti("testi", "Altador");
        Kortti kortti2 = new Kortti("testi2", "Altador");
        k.add(kortti);
        k.add(kortti2);
        
        pakka = new Korttipakka(k);
        
        String vastaus = kortti.getSijainti().toString() + ", " + kortti2.getSijainti().toString();
        
        assertEquals("korttipakka, korttipakka", vastaus);
    }

    @Test
    public void tyhjaPakkaTulostuuOikein() {
        pakka = new Korttipakka(k);
        String verrattava = pakka.luetteleKortit();

        assertEquals("  Pakassa ei ole yhtään korttia.", verrattava);
    }
    
    @Test
    public void korttienTulostusToimiiYhdella() {
        k.add(new Kortti("testi", "Altador"));
        pakka = new Korttipakka(k);
        
           String verrattava = pakka.luetteleKortit();

        assertEquals("Korttipakan sisältämät kortit:\n  testi", verrattava);
    }

    @Test
    public void korttienTulostusToimiiUsealla() {
        k.add(new Kortti("testi", "Altador"));
        k.add(new Kortti("testi2", "Altador"));
        k.add(new Kortti("testi3", "Altador"));
        pakka = new Korttipakka(k);

        String verrattava = pakka.luetteleKortit();

        assertEquals("Korttipakan sisältämät kortit:\n  testi\n  testi2\n  testi3", verrattava);
    }

}
