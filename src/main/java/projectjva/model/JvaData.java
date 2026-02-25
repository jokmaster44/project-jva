package projectjva.model;


/**
 * Represents form data entered by the user, information related to Jva form submission.
 */
public record JvaData(String jva, String weiterKennzeichen, boolean mitUhrzeitangabe, boolean abdruckfurAkten) {

}
