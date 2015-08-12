package vaco.validation.adapters.vatin;

import vaco.validation.AbstractValidationAdapter;

/**
 * Abstract implementation of interntional VATIN validation.<br>
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
public abstract class AbstractVatinFormat extends AbstractValidationAdapter<AbstractVatinFormat> {
    
    protected String vatin;
    protected VatinCountry vatinCountry;
    
    /**
     * @param vatin
     * @param vatinCountry
     * @param message
     */
    public AbstractVatinFormat(String vatin , VatinCountry vatinCountry , String message) {
        if (vatin != null && vatin.length() > 2) {
            this.vatin = vatin;
            
            if (vatinCountry == null)
                this.vatinCountry = VatinCountry.fromValue(vatin.substring(0, 2));
            else
                this.vatinCountry = vatinCountry;
        }
        
        setMessage(message);
    }
    
    /**
     * @param vatin
     * @param vatinCountry
     */
    public AbstractVatinFormat(String vatin , VatinCountry vatinCountry) {
        this(vatin, vatinCountry, "");
    }
    
    /**
     * @param vatin
     * @param message
     */
    public AbstractVatinFormat(String vatin , String message) {
        this(vatin, null, message);
    }
    
    /**
     * @param vatin
     */
    public AbstractVatinFormat(String vatin) {
        this(vatin, "");
    }
    
    @Override
    public boolean isValid() {
        if (vatin == null || vatin.length() < 2)
            return false;
        
        /** VATIN can be formatted with spaces */
        vatin = vatin.replaceAll("\\s", "");
        
        return (vatin.length() == vatinCountry.getLength() || vatinCountry == VatinCountry.UNKNOWN)
                && (vatinCountry.getValue().equals(vatin.substring(0, 2)) || vatinCountry == VatinCountry.UNKNOWN)
                && vatin.matches(vatinCountry.getPattern())
                && isValidCustomImplementation(vatin);
    }
    
    /**
     * Should be overriden with custom national validation routine.
     * 
     * @param vatin
     * @return {@code TRUE} if custom validation routine validates the VATIN
     *         number. Otherwise {@code FALSE}
     */
    protected abstract boolean isValidCustomImplementation(String vatin);
    
}
