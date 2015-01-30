


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
        String vastaus = k.UusiPakka().toString();
        assertEquals("[Space Station, Neopet, Haunted Woods, Neopet, Shenkuu, Neopet, Terror Mountain, Neopet, Lost Desert, Neopet, Faerieland, Petpet, Space Station, Petpet, Haunted Woods, Petpet, Altador, Petpet, Tyrannia, Petpet, Krawk Island, Petpet, Roo Island, Petpet, Meridell, Petpet, Mystery Island, Petpet, Faerieland, Altador Cup, Tyrannia, Altador Cup, Roo Island, Altador Cup, Altador, Altador Cup, Shenkuu, Altador Cup, Terror Mountain, Altador Cup, Krawk Island, Altador Cup, Meridell, Altador Cup, Mystery Island, Altador Cup, Haunted Woods, Altador Cup, Faerieland, maisema1, Faerieland, maisema2, Space Station, maisema1, Space Station, maisema2, Haunted Woods, maisema, Altador, maisema1, Altador, maisema2, Shenkuu, maisema1, Shenkuu, maisema2, Tyrannia, maisema1, Tyrannia, maisema2, Krawk Island, maisema1, Krawk Island, maisema2, Terror Mountain, maisema1, Terror Mountain, maisema2, Roo Island, maisema1, Roo Island, maisema2, Lost Desert, maisema1, Lost Desert, maisema2, Lost Desert, maisema3, Meridell, maisema1, Meridell, maisema2, Mystery Island, maisema1, Mystery Island, maisema2]",
                vastaus);
    }

    
    
}
