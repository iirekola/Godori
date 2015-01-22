package godori;

public class PetpetKortti extends Kortti {
    private boolean onLentava;
    private boolean onMaisema;
    
    public PetpetKortti(String nimi, String maa, boolean onLentava, boolean onMaisema) {
        super(nimi, maa);
        this.onLentava = onLentava;
        this.onMaisema = onMaisema;
    }
}
