package vaco.validation.validators;

import java.util.List;

import vaco.validation.AbstractValidator;
import vaco.validation.ValidationAdapter;

/**
 * Validator for the most business validation use cases.
 * <p>
 * Example:<br>
 * <code>
 * SimpleValidator validator = new SimpleValidator();
 * boolean isValid = validator
 *          .register(new SomeValidationAdapter(someDataToValidate))
 *          .register(new AnotherValidationAdapter(anotherDataToValidate))
 *          .register(new SomeOtherValidationAdapter(someOtherDataToValidate))
 *          .validate();
 * if (!isValid)
 *      // raiseMessageBox... or log error...
 * </code>
 * 
 * @author lokutus
 */
public class SimpleValidator extends AbstractValidator<SimpleValidator, ValidationAdapter> {
    
    /**
     * @param adapters
     */
    public SimpleValidator(List<ValidationAdapter> adapters) {
        for (ValidationAdapter adapter : adapters) {
            register(adapter);
        }
    }
    
    /**
     * @param adapter
     */
    public SimpleValidator(ValidationAdapter adapter) {
        register(adapter);
    }
    
    public SimpleValidator() {
    }
}
