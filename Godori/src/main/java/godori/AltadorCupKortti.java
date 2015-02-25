package godori;

public class AltadorCupKortti extends Kortti {
    private String tunnus;
    
    public AltadorCupKortti(String nimi, String maa, String tunnus) {
        super(nimi, maa);
        this.tunnus = tunnus;
    }
    
    @Override
    public String onErityinen2() {
        return this.tunnus;
    }
}
