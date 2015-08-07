package vaco.validation.validators;

import java.util.List;

import vaco.validation.AbstractValidator;
import vaco.validation.ValidationAdapter;
import vaco.validation.adapters.iban.IbanFormat;

/**
 * Validator for the particular purpose, to validate IBANs. All IBAN are
 * validated against the national rules (length, country code and pattern) and
 * then perform Modulo97-10.
 * <p>
 *
 * Example to validate IBAN and other stuff:<br>
 * <code>
 * IbanValidator validator = new IbanValidator();
 * if (!validator
 *      .register(new IbanValidationAdapter("GR16 0110 1250 0000 0001 2300 695 ", IbanCountry.GR, "00030077"))
 *      .register(new AnotherValidationAdapter(anotherDataToValidate))
 *      .register(new SomeOtherValidationAdapter(someOtherDataToValidate))
 *      .validate())
 *  {
 *      // raiseMessageBox... or log error...
 *  }
 * </code>
 * <p>
 *
 * Or you can simply validate one IBAN:<br>
 * <code>
 * IbanValidator validator = new IbanValidator("SK31 1200 0000 1987 4263 7541");
 * if (!validator.validate()) {
 *      // raiseMessageBox... or log error...
 * }
 * </code>
 *
 * @author lokutus
 */
public class IbanValidator extends AbstractValidator<IbanValidator, ValidationAdapter> {
    
    /**
     * @param adapters
     */
    public IbanValidator(List<ValidationAdapter> adapters) {
        for (ValidationAdapter adapter : adapters) {
            register(adapter);
        }
    }
    
    /**
     * @param adapter
     */
    public IbanValidator(ValidationAdapter adapter) {
        register(adapter);
    }
    
    /**
     * @param iban
     */
    public IbanValidator(String iban) {
        register(new IbanFormat(iban));
    }
    
    public IbanValidator() {
    }
}
