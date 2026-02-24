package projectjva.model;


/**
 * Represents form data entered by the user
 * This class is an immutable data model that stores
 * Information related to Jva form submission.
 * It contains:
 * Jva required field
 * WeiterKennzeichen optional additional text
 * MitUhrzeitangabe checkbox
 * AbdruckFuerAkten chechbox flag
 */
public class JvaData {

    /**
     * Required JVA fields
     */
    private final String jva;

    /**
     * Optional additional text
     */
    private final String weiterKennzeichen;

    /**
     * Indicates whether time specificatopm is selected
     */
    private final boolean mitUhrzeitangabe;
    /**
     * Indicates whether a copy for files Abdruck fur Akten is selected.
     */
    private final boolean abdruckfurAkten;

    /**
     * Constructs a new immutable JvaData instance.
     * @param jva required JVA value
     * @param weiterKennzeichen optional additional text
     * @param mitUhrzeitangabe flag indicating time specification
     * @param abdruckfurAkten flag indicating file copy selection
     */
    public JvaData(String jva, String weiterKennzeichen,
                   boolean mitUhrzeitangabe, boolean abdruckfurAkten){
        this.jva = jva;
        this.weiterKennzeichen = weiterKennzeichen;
        this.mitUhrzeitangabe = mitUhrzeitangabe;
        this.abdruckfurAkten = abdruckfurAkten;
    }

    /**
     * return the JVa value
     * @return JVA string may be null
     */
    public String getJva(){
        return jva;
    }

    /**
     * Returns the additional text
     * @return additional text may be null
     */
    public String getWeiterKennzeichen(){
        return weiterKennzeichen;
    }

    /**
     * Indicates whether time specification is selected.
     * @return true if selected, false otherwise
     */
    public boolean isMitUhrzeitangabe(){
        return mitUhrzeitangabe;
    }

    /**
     * Indicates whether file copy option is selected.
     * @return true if selected false otherwise.
     */
    public boolean isAbdruckfurAkten(){
        return abdruckfurAkten;
    }
}
