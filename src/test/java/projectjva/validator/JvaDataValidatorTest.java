package projectjva.validator;

import org.junit.jupiter.api.Test;
import projectjva.model.JvaData;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Unit tests for JvaValidator, this class verifies validation rules for JvaData
 * JVA must not be null or empty
 * WeiterKennzeichen must not exceed 50 characters
 */
class JvaDataFormValidatorTest {

    /**
     * Test case: Should return SUCCESS when DataForm is valid.
     *
     * Steps: 1.
     * Execute validation using JvaFormValidator.validate(form).
     *
     * Expected result:
     * - Validation returns SUCCESS status.
     * - Validation error code is null.
     */
    @Test
    void testJvaValidator_returnSuccess_whenFormisValid() {

        //Arrange
        final JvaFormValidator validator = new JvaFormValidator();
        JvaData form = new JvaData("Berlin", null, false, false);

        //Act
        final ValidatorResult result = validator.validate(form);

        //Assert
        assertEquals(ValidationStatus.SUCCESS, result.getStatus());
        assertNull(result.getErrorCode());
    }

    /** Testcase: Should return Error when the DataObjects itself is null.
    * Initial state: JvaData object, where "jva" is not set.
    * Steps:
    * 1. Run validation.
    *
    * Result state: Validation returns ERROR status and JVA_REQUIRED error code.
    */
    @Test
    void testJvaValidator_returnError_whenJvaisNull() {

        // Arrange
        final JvaFormValidator validator = new JvaFormValidator();
        JvaData form = new JvaData(null, null, false, false);

        // Act
        final ValidatorResult result = validator.validate(form);

        // Assert
        assertEquals(ValidationStatus.ERROR, result.getStatus());
        assertEquals(ValidationErrorCode.JVA_REQUIRED, result.getErrorCode());
    }

    /**
     * Test case: Should return ERROR when the form DataObject is null.
     *
     * Steps:
     * 1. Execute validation using JvaFormValidator.validate(null).
     *
     * Expected result:
     * - Validation returns ERROR status.
     * - Validation error code is FORM_NULL.
     */
    @Test
    void testJvaValidator_returnError_whenFormisNull() {

        //Arrange
        final JvaFormValidator validator = new JvaFormValidator();

        //Act
        final ValidatorResult result = validator.validate(null);

        //Assert
        assertEquals(ValidationStatus.ERROR, result.getStatus());
        assertEquals(ValidationErrorCode.FORM_NULL, result.getErrorCode());
    }

    /**
     * Test case: Should return ERROR when WeiterKennzeichen exceeds 50 characters.
     *
     * Steps: 1.
     * Execute validation using JvaFormValidator.validate(form).
     *
     * Expected result:
     * - Validation returns ERROR status.
     * - Validation error code is KENNZEICHEN_TOO_LONG.
     */
    @Test
    void testJvaValidator_returnError_whenKennzeichenTooLong() {

        //Arrange
        final JvaFormValidator validator = new JvaFormValidator();
        final String longText = "a".repeat(51);
        final JvaData form = new JvaData("Berlin", longText, false, false);

        //Act
        final ValidatorResult result = validator.validate(form);

        //Assert
        assertEquals(ValidationStatus.ERROR, result.getStatus());
        assertEquals(ValidationErrorCode.KENNZEICHEN_TOO_LONG, result.getErrorCode());
    }
}