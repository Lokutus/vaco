package vaco.validation;

import java.util.ArrayList;
import java.util.List;

import vaco.conditions.Conditional;

/**
 * The {@link ValidationAdapter} template to be extended for business validation
 * purposes.<br>
 * Every business case that is expected to be validated should extend validation
 * adapter and the validation logic routine should be implemented in overriden
 * method isValid() to return {@code TRUE} or {@code FALSE} , whether it's valid
 * or not.
 * <p>
 * Every adapter can use list of {@link Conditional}. If one of these conditions
 * doesn't evaluate, adapter doesn't validate itself and pretends to be valid
 * with silent fallback. Conditions should be registered using validateOn()
 * method.
 * <p>
 * <code>
 * String iban = "GR16 0110 1250 0000 0001 2300 695";
 * IbanValidator validator = new IbanValidator();
 * validator
 *      .register(new IbanValidationAdapter(iban, IbanCountry.fromValue(countryCode))
 *          .validateOn(new IsCountryInList(countryCode, countryCodesEea)));
 * </code>
 *
 * @author lokutus
 *
 * @param <A>
 */
public abstract class AbstractValidationAdapter<A extends ValidationAdapter> implements ValidationAdapter {
    
    /**
     * An optional condition. Adapter allways validates to {@code TRUE} if
     * condition doesn't evaluate.
     */
    protected Conditional condition;
    
    /** Potential error message to be returned while adapter fails. */
    protected String message = "";
    
    /** Potential params of the error message. */
    protected List<String> messageParams = new ArrayList<String>();
    
    @Override
    public String getMessage() {
        return message;
    }
    
    @Override
    public void setMessage(String message) {
        this.message = message;
    }
    
    @Override
    public List<String> getMessageParams() {
        return messageParams;
    }
    
    /**
     * Method to register optional condition on which depends the validation
     * result.
     * 
     * @return current validation adapter
     */
    @SuppressWarnings("unchecked")
    @Override
    public A validateOn(Conditional condition) {
        this.condition = condition;
        return (A) this;
    }
    
    /**
     * Main validation method. Expects custom validation routine in the
     * inheritted isValid() method.<br>
     * If there is a registered condition that does not evaluate, this method
     * allways returns {@code TRUE}
     * 
     * @return {@code TRUE} if validation routine successfully validates.
     *         Otherwise {@code FALSE}
     */
    @Override
    public boolean validate() {
        if (this.condition != null)
            if (!this.condition.evaluate())
                return true;
        
        return isValid();
    }
    
    /**
     * Custom validation routine. Should be overidden in adapter
     * implementations.
     * 
     * @return {@code TRUE} if validation routine successfully validates.
     *         Otherwise {@code FALSE}
     */
    public abstract boolean isValid();
}
