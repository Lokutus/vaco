package vaco.validation.adapters;

import vaco.validation.AbstractValidationAdapter;

/**
 * Validate standard SWIFT/BIC (Bank Identification Code) number against the
 * defined pattern. BIC should not be null.<br>
 * Pattern: Six chars, two chars or nums and optional three more chars or nums.
 * 
 * @author lokutus
 */
public class BicFormat extends AbstractValidationAdapter<BicFormat> {
    
    public static final String PATTERN = "[A-Z]{6}[A-Z0-9]{2}([A-Z0-9]{3})?";
    
    /** SWIFT/BIC number to be validated */
    protected String bic;
    
    public BicFormat(String bic , String message) {
        this.bic = bic;
        setMessage(message);
    }
    
    public BicFormat(String bic) {
        this(bic, "");
    }
    
    @Override
    public boolean isValid() {
        return bic != null && bic.matches(PATTERN);
    }
}
