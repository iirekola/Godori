package godori;

public class Kasi implements Sijainti {

    private Kortti[] kortit;

    public Kasi() {
        int alkioita = 10;
        this.kortit = new Kortti[alkioita];
    }

    public String toString() {
        return "Käsi";
    }

    @Override
    public String luetteleKortit() {
        String palautus = "Kädessä olevat kortit:";

        int korttienMaara = 0;
        for (Kortti kortti : kortit) {
            if (kortti != null) {
                palautus += "\n" + (korttienMaara + 1) +":  " + kortti.toString();
                korttienMaara++;
            }
        }

        if (korttienMaara == 0) {
            return "Kädessä ei ole yhtään korttia.";
        }

        return palautus;
    }

    @Override
    public void lisaaKortti(Kortti kortti) {
        boolean lisatty = false;
        for (int i = 0; i < kortit.length; i++) {

            if (lisatty == true) {
                break;

            } else if (kortit[i] == null) {
                kortit[i] = kortti;
                kortti.asetaSijainti(this);
                lisatty = true;
            }
        }
    }

    @Override
    public void poistaKortti(Kortti kortti) {
        for (int i = 0; i < kortit.length; i++) {
            if (kortit[i] == kortti) {
                kortit[i] = null;
                kortti.asetaSijainti(null);
            }
        }
    }
    
    public int montakoKorttia() {
        int montako = 0;
        for (Kortti kortti : this.kortit) {
            if (kortti != null) {
                montako++;
            }
        }
        return montako;
    }
    
    public Kortti[] getKortit() {
        return this.kortit;
    }
}
