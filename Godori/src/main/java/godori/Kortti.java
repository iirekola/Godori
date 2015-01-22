package godori;

public class Kortti {
    private String nimi;
    private String maa;
    
    public Kortti(String nimi, String maa) {
        this.nimi = nimi;
        this.maa = maa;
    }
    
    public String toString() {
        return this.nimi;
    }
    
    public String getMaa() {
        return this.maa;
    }
}
