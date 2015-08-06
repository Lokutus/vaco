package vaco.validation;

import java.util.List;

import vaco.conditions.Conditional;

/**
 * @author lokutus
 */
public interface ValidationAdapter {
    
    /**
     * For the failed validation routine this should keep message or message
     * code for the user notification.
     *
     * @return the failed message code or message itself.
     */
    String getMessage();
    
    /**
     * Prepare the message or message code for potential validation failure
     * purposes.
     *
     * @param message
     */
    void setMessage(String message);
    
    /**
     * For the failed validation routine this should keep message params to be
     * formatted with the user notification.
     *
     * @return The list of failure message params
     */
    List<String> getMessageParams();
    
    /**
     * Add a condition of validation process. If the condition evaluates to
     * true, validation proceeds. Otherwise the validation routine should
     * silently fall back with result=true.<br>
     * For multiple conditions use chainable conditions.
     *
     * @param condition
     * @return ValidationAdapter
     */
    ValidationAdapter validateOn(Conditional condition);
    
    /**
     * The validation process of the custom validation routine.
     *
     * @return TRUE/FALSE based on the custom validation routine.
     */
    boolean validate();
}
