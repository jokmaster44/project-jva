package projectjva.validator;

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
     * Test case: Should return SUCCESS when the form is valid.
     *
     * Initial state:
     * - A JvaFormValidator instance is created.
     * - A JvaData object is created with:
     *
     * Steps: 1. Execute validation using JvaFormValidator.validate(form).
     *
     * Expected result:
     * - Validation returns SUCCESS status.
     * - Validation error code is null.
     */
    @Test
    void testJvaValidator_returnSuccess_whenFormisValid() {
        //Arange
        JvaFormValidator validator = new JvaFormValidator();
        JvaData form = new JvaData("Berlin", null, false, false);
        //Act
        ValidatorResult result = validator.validate(form);
        //Assert
        assertEquals(ValidationStatus.SUCCESS, result.getStatus());
        assertNull(result.getErrorCode());
    }

    /** Testcase: Should return Error when the form objects itself is null.
    * Initial state: JvaData object, where "jva" is not set.
    * Steps:
    * 1. Run validation.
    *
    * Result state: Validation returns ERROR status and JVA_REQUIRED error code.
    */
    @Test
    void testJvaValidator_returnError_whenJvaisNull() {
        // Arrange
        JvaFormValidator validator = new JvaFormValidator();
        JvaData form = new JvaData(null, null, false, false);

        // Act
        ValidatorResult result = validator.validate(form);

        // Assert
        assertEquals(ValidationStatus.ERROR, result.getStatus());
        assertEquals(ValidationErrorCode.JVA_REQUIRED, result.getErrorCode());
    }

    /**
     * Test case: Should return ERROR when the form object itself is null.
     *
     * Initial state:
     * - A JvaFormValidator instance is created.
     * - The form object reference is null.
     *
     * Steps:
     * 1. Execute validation using JvaFormValidator.validate(null).
     *
     * Expected result:
     * - Validation returns ERROR status.
     * - Validation error code is FORM_NULL.
     */
    @Test
    void TestJvaValidator_returnError_whenFormisNull() {
        //Arrange
        JvaFormValidator validator = new JvaFormValidator();
        //Act
        ValidatorResult result = validator.validate(null);
        //Assert
        assertEquals(ValidationStatus.ERROR, result.getStatus());
        assertEquals(ValidationErrorCode.FORM_NULL, result.getErrorCode());
    }

    /**
     * Test case: Should return ERROR when WeiterKennzeichen exceeds 50 characters.
     *
     * Steps: 1. Execute validation using JvaFormValidator.validate(form).
     *
     * Expected result:
     * - Validation returns ERROR status.
     * - Validation error code is KENNZEICHEN_TOO_LONG.
     */
    @Test
    void testJvaValidator_returnError_whenKennzeichenTooLong() {
        //Arrange
        JvaFormValidator validator = new JvaFormValidator();
        String longText = "a".repeat(51);
        JvaData form = new JvaData("Berlin", longText, false, false);
        //Act
        ValidatorResult result = validator.validate(form);
        //Assert
        assertEquals(ValidationStatus.ERROR, result.getStatus());
        assertEquals(ValidationErrorCode.KENNZEICHEN_TOO_LONG, result.getErrorCode());
    }
}