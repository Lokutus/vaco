package vaco.validation.validators;

import java.util.List;

import vaco.validation.AbstractValidator;
import vaco.validation.ValidationAdapter;
import vaco.validation.adapters.vatin.VatinAdaptersFactory;
import vaco.validation.adapters.vatin.VatinCountry;

/**
 * Validator to validate VATIN (Value Added Tax Identification Number).<br>
 * Validates against national format and length and then calls the custom
 * national implementation of validation routine.
 * <p>
 *
 * Example:<br>
 * <code>
 * VatinValidator validator = new VatinValidator();<br>
 * if (!validator<br>
 *      .register(new VatinFormatCz("CZ69663963", "The VAT number is invalid."))<br>
 *      .validate()) {<br>
 *      // raiseMessageBox... or log error...<br>
 *  }
 * </code>
 * <p>
 *
 * Or you can use VATIN validator constructor:<br>
 * <code>
 * if (!new VatinValidator("CZ69663963").validate()) {<br>
 *      // raiseMessageBox... or log error...<br>
 * }
 * </code>
 * 
 * @author lokutus
 */
public class VatinValidator extends AbstractValidator<IbanValidator, ValidationAdapter> {
    
    /**
     * @param adapters
     */
    public VatinValidator(List<ValidationAdapter> adapters) {
        for (ValidationAdapter adapter : adapters) {
            register(adapter);
        }
    }
    
    /**
     * @param adapter
     */
    public VatinValidator(ValidationAdapter adapter) {
        register(adapter);
    }
    
    /**
     * @param vatin
     * @param vatinCountry
     */
    public VatinValidator(String vatin , VatinCountry vatinCountry) {
        register(VatinAdaptersFactory.create(vatin, vatinCountry));
    }
    
    /**
     * @param vatin
     */
    public VatinValidator(String vatin) {
        if (vatin != null && vatin.length() > 2) {
            VatinCountry vatinCountry = VatinCountry.fromValue(vatin.substring(0, 2));
            register(VatinAdaptersFactory.create(vatin, vatinCountry));
        }
    }
    
    public VatinValidator() {
    }
}
