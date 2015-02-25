package godori;

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