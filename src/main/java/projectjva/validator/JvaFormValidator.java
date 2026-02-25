package projectjva.validator;

import projectjva.model.JvaData;


/**
 * Validator responsible for checking business rules of JvaData
 * This validator ensure:
 * The JVA field is not null or empty
 * The WeiterKennzeichen field does not exceed 50 characters
 */
public class JvaFormValidator implements Validator<JvaData>{

    /**
     * Validates the provided
     *
     * @param form the form data to validate
     * @return ValidatorResult containing validation status and optional ValidationErrorCode
     */
    @Override
    public ValidatorResult validate(final JvaData form)  {

        if(form == null){
            return ValidatorResult.error(ValidationErrorCode.FORM_NULL);
        }

        final String jva = form.getJva();
        if (jva == null || jva.trim().isEmpty()){
            return ValidatorResult.error(ValidationErrorCode.JVA_REQUIRED);
        }

        final String k = form.getWeiterKennzeichen();
        if (k != null && k.length() > 50){
            return ValidatorResult.error(ValidationErrorCode.KENNZEICHEN_TOO_LONG);
        }
        return ValidatorResult.success();
    }
}
