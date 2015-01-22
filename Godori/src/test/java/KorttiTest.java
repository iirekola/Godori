
import godori.Kortti;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class KorttiTest {
    
    public KorttiTest() {
    }
    
    Kortti k;
    
    
    @Before
    public void setUp() {
        k = new Kortti("Testi", "Altador");
    }
    
    @Test
    public void toStringOikein() {
        String vastaus = k.toString();
        
        assertEquals("Testi", vastaus); 
    }
    
    @Test
    public void getMaaOikein() {
        String vastaus = k.getMaa();
        
        assertEquals("Altador", vastaus); 
    }
    
}
