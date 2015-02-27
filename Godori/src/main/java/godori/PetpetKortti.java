package godori;

/**
 * Kortti-luokan alaluokka, kuvaa Petpet typpisiä kortteja
 */
public class PetpetKortti extends Kortti {
    private boolean onLentava;
    private boolean onMaisema;
    
    public PetpetKortti(String nimi, String maa, boolean onLentava, boolean onMaisema) {
        super(nimi, maa);
        this.onLentava = onLentava;
        this.onMaisema = onMaisema;
    }
    
    @Override
    public boolean onErityinen() {
        return this.onLentava;
    }
    
    @Override
    public String onErityinen2() {
        if (onMaisema) {
            return "maisema";
        }
        return null;
    }
}
