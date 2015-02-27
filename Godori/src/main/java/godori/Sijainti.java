
package godori;

/**
 * Interface korttien sijainneille
 */
public interface Sijainti {
    @Override
    String toString();
    String luetteleKortit();
    void lisaaKortti(Kortti kortti);
    void poistaKortti(Kortti kortti);
    void tyhjenna();
}
