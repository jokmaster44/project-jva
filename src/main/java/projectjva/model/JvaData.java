package projectjva.model;


/**
 * Represents form data entered by the user, information related to Jva form submission.
 */
public class JvaData {

    private final String jva;
    private final String weiterKennzeichen;
    private final boolean mitUhrzeitangabe;
    private final boolean abdruckfurAkten;

    /**
     * Constructs a new immutable JvaData instance.
     *
     * @param jva required JVA value, must not be null
     * @param weiterKennzeichen optional additional text, may be less than 51.
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

    public String getJva(){
        return jva;
    }

    public String getWeiterKennzeichen(){
        return weiterKennzeichen;
    }

    public boolean isMitUhrzeitangabe(){
        return mitUhrzeitangabe;
    }

    public boolean isAbdruckfurAkten(){
        return abdruckfurAkten;
    }
}
