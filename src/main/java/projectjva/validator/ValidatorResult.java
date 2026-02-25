package projectjva.validator;


/**
 * Represents the result of validation, this class encapsulates:
 * The overall validation status (SUCCESS or ERROR)
 * An optional describing the reason of failure ,instances are created via the static factory methods.
 */
public class ValidatorResult {

    private final ValidationStatus status;

    /**
     * Specific validation error code, will be code null when validation is successful.
     */
    private final ValidationErrorCode errorCode;

    public boolean isSuccessful() {
        return status == ValidationStatus.SUCCESS;
    }


    /**
     * Private constructor to enforce usage of factory methods.
     *
     * @param status the validation status
     * @param errorCode the validation error code (null if SUCCESS)
     */
    private ValidatorResult(ValidationStatus status, ValidationErrorCode errorCode) {
        this.status = status;
        this.errorCode = errorCode;
    }

    public static ValidatorResult success() {
        return new ValidatorResult(ValidationStatus.SUCCESS, null);
    }

    /**
     * Creates an error validation result with a specific error code.
     *
     * @param code the validation error code
     * @return a ValidatorResult with Status ERROR.
     */
    public static ValidatorResult error(ValidationErrorCode code) {
        return new ValidatorResult(ValidationStatus.ERROR, code);
    }

    public ValidationStatus getStatus() {
        return status;
    }

    public ValidationErrorCode getErrorCode() {
        return errorCode;
    }
}