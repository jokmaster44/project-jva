package projectjva.validator;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projectjva.model.JvaData;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for JvaValidator
 * This class verifies validation rules for JvaData
 * JVA must not be null or empty
 * WeiterKennzeichen must not exceed 50 characters
 */
class JvaDataFormValidatorTest {

    private JvaFormValidator validator;
    private JvaData form;

    /**
     * Should return success when form is valid
     */
    @Test
    void TestJvaValidatorReturnSuccesWhenFormIsValid() {

        JvaFormValidator validator = new JvaFormValidator();
        JvaData form = new JvaData("Berlin", null, false, false);

        ValidatorResult result = validator.validate(form);

        assertEquals(ValidationStatus.SUCCESS, result.getStatus());
        assertNull(result.getErrorCode());
    }

    /**
     * Should return Error when the form objects itself is null.
      */
    @Test
    void TestJvaValidatorReturnErrorWhenJvaisNull() {

        JvaFormValidator validator = new JvaFormValidator();
        JvaData form = new JvaData(null, null, false, false);

        ValidatorResult result = validator.validate(form);

        assertEquals(ValidationStatus.ERROR, result.getStatus());
        assertEquals(ValidationErrorCode.JVA_REQUIRED, result.getErrorCode());
    }

    /**
     * Should return ERROR when the form object itself is null.
     */
    @Test
    void TestJvaValidatorReturnErrorWhenFormIsNull() {
        JvaFormValidator validator = new JvaFormValidator();

        ValidatorResult result = validator.validate(null);

        assertEquals(ValidationStatus.ERROR, result.getStatus());
        assertEquals(ValidationErrorCode.FORM_NULL, result.getErrorCode());
    }

    /**
     * Should return ERROR when WeiterKennzeichen exceeds 50 characters.
     */
    @Test
    void shouldReturnErrorWhenKennzeichenTooLong() {
        JvaFormValidator validator = new JvaFormValidator();
        String longText = "a".repeat(51);
        JvaData form = new JvaData("Berlin", longText, false, false);

        ValidatorResult result = validator.validate(form);

        assertEquals(ValidationStatus.ERROR, result.getStatus());
        assertEquals(ValidationErrorCode.KENNZEICHEN_TOO_LONG, result.getErrorCode());
    }
}