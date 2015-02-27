package godori;




import godori.Korttienluoja;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KorttienluojaTest {
    
    public KorttienluojaTest() {
    }
    Korttienluoja k = new Korttienluoja(); 
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void luoKortitOikein(){
        String vastaus = k.uusiPakka().toString();
        assertEquals("[Space Station, Neopet, Haunted Woods, Neopet, Shenkuu, Neopet, Terror Mountain, Neopet, Lost Desert, Neopet, Faerieland, Lentävä Petpet, Space Station, Lentävä Petpet, Haunted Woods, Petpet, Altador, Lentävä Petpet, Tyrannia, Petpet, Krawk Island, Petpet, Roo Island, Petpet, Meridell, Petpet, Mystery Island, Petpet/Maisema, Faerieland, Vaakuna, Tyrannia, Vaakuna, Roo Island, Vaakuna, Altador, Viiri, Shenkuu, Viiri, Terror Mountain, Viiri, Krawk Island, Nauha, Meridell, Nauha, Mystery Island, Nauha, Haunted Woods, Altador Cup, Faerieland, maisema1, Faerieland, maisema2, Space Station, maisema1, Space Station, maisema2, Haunted Woods, 2X maisema, Altador, maisema1, Altador, maisema2, Shenkuu, maisema1, Shenkuu, maisema2, Tyrannia, maisema1, Tyrannia, maisema2, Krawk Island, maisema1, Krawk Island, maisema2, Terror Mountain, maisema1, Terror Mountain, maisema2, Roo Island, maisema1, Roo Island, maisema2, Lost Desert, maisema1, Lost Desert, maisema2, Lost Desert, 2X maisema3, Meridell, maisema1, Meridell, maisema2, Mystery Island, maisema1, Mystery Island, maisema2]",
                vastaus);
    }

    
    
}
