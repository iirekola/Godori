package godori;

import java.util.ArrayList;
import java.util.List;
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
    Kortti p = new PetpetKortti("Testi2", "Testi2", false, false);
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
    
    @Test
    public void getNeopetPisteetToimiiKunLiianVahan() {
        v.lisaaKortti(n);
        
        assertEquals(0, v.getNeopetPisteet());
    }
    
    @Test
    public void getNeopetPisteetToimiiKunKolmeIlmanHW() {
        v.lisaaKortti(n);
        v.lisaaKortti(new NeopetKortti("Testi", "Testi", false));
        v.lisaaKortti(new NeopetKortti("Testi", "Testi", false));
        
        assertEquals(3, v.getNeopetPisteet());
    }
    
    @Test
    public void getNeopetPisteetToimiiKunKolmeJoissaHW() {
        v.lisaaKortti(n);
        v.lisaaKortti(new NeopetKortti("Testi", "Testi", false));
        v.lisaaKortti(new NeopetKortti("Testi", "Testi", true));
        
        assertEquals(2, v.getNeopetPisteet());
    }
    
    @Test
    public void getNeopetPisteetToimiiKunNelja() {
        v.lisaaKortti(n);
        v.lisaaKortti(new NeopetKortti("Testi", "Testi", false));
        v.lisaaKortti(new NeopetKortti("Testi", "Testi", true));
        v.lisaaKortti(new NeopetKortti("Testi", "Testi", false));
        
        assertEquals(4, v.getNeopetPisteet());
    }
    
    @Test
    public void getNeopetPisteetToimiiKunViisi() {
        v.lisaaKortti(n);
        v.lisaaKortti(new NeopetKortti("Testi", "Testi", false));
        v.lisaaKortti(new NeopetKortti("Testi", "Testi", true));
        v.lisaaKortti(new NeopetKortti("Testi", "Testi", false));
        v.lisaaKortti(new NeopetKortti("Testi", "Testi", false));
        
        assertEquals(15, v.getNeopetPisteet());
    }
    
    @Test
    public void getPetpetPisteetToimiiKunAlleViisi() {
        v.lisaaKortti(p);
        v.lisaaKortti(new PetpetKortti("Testi", "Testi", false, false));
        v.lisaaKortti(new PetpetKortti("Testi", "Testi", false, false));
        
        assertEquals(0, v.getPetpetPisteet());
    }
    
    @Test
    public void getPetpetPisteetToimiiKunAlleViisiJaLentavat() {
        v.lisaaKortti(new PetpetKortti("Testi", "Testi", true, false));
        v.lisaaKortti(new PetpetKortti("Testi", "Testi", true, false));
        v.lisaaKortti(new PetpetKortti("Testi", "Testi", true, false));
        
        assertEquals(0, v.getPetpetPisteet());
    }
    
    @Test
    public void getPetpetPisteetLisaaMaisemakortinKunAlleViisiJaMysteryIsland() {
        v.lisaaKortti(new PetpetKortti("Testi", "Testi", false, true));
        v.getPetpetPisteet();
        
        assertEquals(1, v.getMaisemapakka().size());
    }
    
    @Test
    public void getPetpetPisteetEiLisaaMaisemakortinKunAlleViisiIlmanMysteryIsland() {
        v.lisaaKortti(new PetpetKortti("Testi", "Testi", false, false));
        v.getPetpetPisteet();
        
        assertEquals(0, v.getMaisemapakka().size());
    }
    
    @Test
    public void getPetpetPisteetEiLisaaMaisemakortinKunYliViisiJaMysteryIsland() {
        v.lisaaKortti(new PetpetKortti("Testi", "Testi", false, true));
        v.lisaaKortti(new PetpetKortti("Testi", "Testi", true, false));
        v.lisaaKortti(new PetpetKortti("Testi", "Testi", false, false));
        v.lisaaKortti(new PetpetKortti("Testi", "Testi", true, false));
        v.lisaaKortti(new PetpetKortti("Testi", "Testi", false, false));
        v.getPetpetPisteet();
        
        assertEquals(0, v.getMaisemapakka().size());
    }
    
    @Test
    public void getPetpetPisteetToimiiKunViisiIlmanKolmeaLentavaa() {
        v.lisaaKortti(p);
        v.lisaaKortti(new PetpetKortti("Testi", "Testi", false, false));
        v.lisaaKortti(new PetpetKortti("Testi", "Testi", false, false));
        v.lisaaKortti(new PetpetKortti("Testi", "Testi", true, false));
        v.lisaaKortti(new PetpetKortti("Testi", "Testi", false, false));
        
        assertEquals(1, v.getPetpetPisteet());
    }
    
    @Test
    public void getPetpetPisteetToimiiKunYliViisiIlmanKolmeaLentavaa() {
        v.lisaaKortti(p);
        v.lisaaKortti(new PetpetKortti("Testi", "Testi", false, false));
        v.lisaaKortti(new PetpetKortti("Testi", "Testi", false, false));
        v.lisaaKortti(new PetpetKortti("Testi", "Testi", true, false));
        v.lisaaKortti(new PetpetKortti("Testi", "Testi", false, false));
        v.lisaaKortti(new PetpetKortti("Testi", "Testi", true, false));
        v.lisaaKortti(new PetpetKortti("Testi", "Testi", false, false));
        
        assertEquals(3, v.getPetpetPisteet());
    }
    
    @Test
    public void KaikkiLentavatToimiiKunFalse() {
        v.lisaaKortti(new PetpetKortti("Testi", "Testi", true, false));
        v.lisaaKortti(new PetpetKortti("Testi", "Testi", true, false));
        v.lisaaKortti(new PetpetKortti("Testi", "Testi", false, false));
        
        assertEquals(0, v.kaikkiLentavat());
    }
    
    @Test
    public void KaikkiLentavatToimiiKunTrue() {
        v.lisaaKortti(new PetpetKortti("Testi", "Testi", true, false));
        v.lisaaKortti(new PetpetKortti("Testi", "Testi", true, false));
        v.lisaaKortti(new PetpetKortti("Testi", "Testi", true, false));
        
        assertEquals(5, v.kaikkiLentavat());
    }
    
    @Test
    public void SisaltaaMysteryIslandToimiiKunTrue() {
        v.lisaaKortti(new PetpetKortti("Testi", "Testi", false, true));
        v.lisaaKortti(new PetpetKortti("Testi", "Testi", true, false));
        v.lisaaKortti(new PetpetKortti("Testi", "Testi", false, false));
        
        assertTrue(v.sisaltaaMysteryIslandPetpet());
    }
    
    @Test
    public void SisaltaaMysteryIslandToimiiKunFalse() {
        v.lisaaKortti(new PetpetKortti("Testi", "Testi", false, false));
        v.lisaaKortti(new PetpetKortti("Testi", "Testi", true, false));
        v.lisaaKortti(new PetpetKortti("Testi", "Testi", false, false));
        
        assertFalse(v.sisaltaaMysteryIslandPetpet());
    }
    
    @Test
    public void montakoYliRajanToimiiKunLiianVahan() {
        List<Kortti> testi = new ArrayList<Kortti>();
        testi.add(new Kortti("Testi", "Testi"));
        testi.add(new Kortti("Testi", "Testi"));
        testi.add(new Kortti("Testi", "Testi"));
        
        assertEquals(0, v.montakoYliRajan(3, testi));
    }
    
    @Test
    public void montakoYliRajanToimiiKunYli() {
        List<Kortti> testi = new ArrayList<Kortti>();
        testi.add(new Kortti("Testi", "Testi"));
        testi.add(new Kortti("Testi", "Testi"));
        testi.add(new Kortti("Testi", "Testi"));
        
        assertEquals(2, v.montakoYliRajan(1, testi));
    }
    
    @Test
    public void getACPisteetToimiiKunAlleViisi() {
        v.lisaaKortti(new AltadorCupKortti("Testi", "Testi", "vaakuna"));
        v.lisaaKortti(new AltadorCupKortti("Testi", "Testi", "viiri"));
        v.lisaaKortti(new AltadorCupKortti("Testi", "Testi", "viiri"));
        
        assertEquals(0, v.getACPisteet());
    }
    
    @Test
    public void getACPisteetToimiiKunAlleViisiJaSetti() {
        v.lisaaKortti(new AltadorCupKortti("Testi", "Testi", "viiri"));
        v.lisaaKortti(new AltadorCupKortti("Testi", "Testi", "viiri"));
        v.lisaaKortti(new AltadorCupKortti("Testi", "Testi", "viiri"));
        
        assertEquals(0, v.getACPisteet());
    }
    
    @Test
    public void getACPisteetToimiiKunViisi() {
        v.lisaaKortti(new AltadorCupKortti("Testi", "Testi", "viiri"));
        v.lisaaKortti(new AltadorCupKortti("Testi", "Testi", "vaakuna"));
        v.lisaaKortti(new AltadorCupKortti("Testi", "Testi", "viiri"));
        v.lisaaKortti(new AltadorCupKortti("Testi", "Testi", "vaakuna"));
        v.lisaaKortti(new AltadorCupKortti("Testi", "Testi", null));
        
        assertEquals(1, v.getACPisteet());
    }
    
    @Test
    public void getACPisteetToimiiKunYliViisi() {
        v.lisaaKortti(new AltadorCupKortti("Testi", "Testi", "viiri"));
        v.lisaaKortti(new AltadorCupKortti("Testi", "Testi", "vaakuna"));
        v.lisaaKortti(new AltadorCupKortti("Testi", "Testi", "viiri"));
        v.lisaaKortti(new AltadorCupKortti("Testi", "Testi", "vaakuna"));
        v.lisaaKortti(new AltadorCupKortti("Testi", "Testi", "nauha"));
        v.lisaaKortti(new AltadorCupKortti("Testi", "Testi", null));
        
        assertEquals(2, v.getACPisteet());
    }
    
    @Test
    public void kolmeSamaaACToimiiKunTrue() {
        v.lisaaKortti(new AltadorCupKortti("Testi", "Testi", "viiri"));
        v.lisaaKortti(new AltadorCupKortti("Testi", "Testi", "viiri"));
        v.lisaaKortti(new AltadorCupKortti("Testi", "Testi", "viiri"));
        
        assertEquals(3, v.kolmeSamaaAC("viiri"));
    }
    
    @Test
    public void kolmeSamaaACToimiiKunFalse() {
        v.lisaaKortti(new AltadorCupKortti("Testi", "Testi", "viiri"));
        v.lisaaKortti(new AltadorCupKortti("Testi", "Testi", "vaakuna"));
        v.lisaaKortti(new AltadorCupKortti("Testi", "Testi", "viiri"));
        
        assertEquals(0, v.kolmeSamaaAC("viiri"));
    }
    
    @Test
    public void tuplaaTuplatToimii() {
        v.lisaaKortti(new MaisemaKortti("Testi", "Testi", true));
        v.lisaaKortti(new MaisemaKortti("Testi", "Testi", false));
        v.tuplaaTuplat();
        
        assertEquals(3, v.getMaisemapakka().size());
    }
    
    @Test
    public void getMaisemaPisteetToimiiKunAlleKymmenen() {
        for (int i = 1; i < 10; i++) {
            v.lisaaKortti(new MaisemaKortti("Testi", "Testi", false));
        }
        
        assertEquals(0, v.getMaisemaPisteet());
    }
    
    @Test
    public void getMaisemaPisteetToimiiKunKymmenen() {
        for (int i = 1; i <= 10; i++) {
            v.lisaaKortti(new MaisemaKortti("Testi", "Testi", false));
        }
        
        assertEquals(1, v.getMaisemaPisteet());
    }
    
    @Test
    public void getMaisemaPisteetToimiiKunYliKymmenen() {
        for (int i = 1; i <= 12; i++) {
            v.lisaaKortti(new MaisemaKortti("Testi", "Testi", false));
        }
        
        assertEquals(3, v.getMaisemaPisteet());
    }
}
