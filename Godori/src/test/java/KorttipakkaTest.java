
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
    public void tyhjaPakkaTulostuuOikein() {
        pakka = new Korttipakka(k);
        String verrattava = pakka.toString();
        
        assertEquals("  Pakassa ei ole yhtään korttia.", verrattava);
    }

    @Test
    public void toStringToimii() {
        ArrayList<Kortti> k = new ArrayList<Kortti>();
        k.add(new Kortti("testi", "Altador"));
        k.add(new Kortti("testi2", "Altador"));
        pakka = new Korttipakka(k);
        
        String verrattava = pakka.toString();
        
        assertEquals("Korttipakan sisältämät kortit:\n  testi\n  testi2", verrattava);
    }

}
