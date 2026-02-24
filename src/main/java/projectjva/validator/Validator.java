package projectjva.validator;


/**
 * Generic validator interface.
 * @param <T> type of object to validate
 */
public interface Validator<T> {

        /**
         * Validates the given object and returns validation result.
         *
         * @param value object to validate
         * @return validation result (SUCCESS or ERROR with code)
         */
        ValidatorResult validate(T value);
    }
