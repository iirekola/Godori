package godori;

/**
 * Kortti-luokan alaluokka, kuvaa Maisema typpisiä kortteja
 */
public class MaisemaKortti extends Kortti {
    private boolean kaksiKorttia;
    
    public MaisemaKortti(String nimi, String maa, boolean kaksiKorttia) {
        super(nimi, maa);
        this.kaksiKorttia = kaksiKorttia;
    }
    
    @Override
    public boolean onErityinen() {
        return this.kaksiKorttia;
    }
}
