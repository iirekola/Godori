package godori;

public class MaisemaKortti extends Kortti {
    private boolean kaksiKorttia;
    
    public MaisemaKortti(String nimi, String maa, boolean kaksiKorttia) {
        super(nimi, maa);
        this.kaksiKorttia = kaksiKorttia;
    }
}
