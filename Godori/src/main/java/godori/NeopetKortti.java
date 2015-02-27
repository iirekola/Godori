package godori;

/**
 * Kortti-luokan alaluokka, kuvaa Neopet typpisiä kortteja
 */
public class NeopetKortti extends Kortti {
    private boolean onHW;
    
    public NeopetKortti(String nimi, String maa, boolean onHW) {
        super(nimi, maa);
        this.onHW = onHW;
    }
    
    @Override
    public boolean onErityinen() {
        return onHW;
    }
}