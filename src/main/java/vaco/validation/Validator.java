package vaco.validation;

import java.util.List;

/**
 * @author lokutus
 *
 * @param <E>
 */
public interface Validator<E extends ValidationAdapter> {
    
    /**
     * @return ValidationStatus
     */
    ValidationStatus getStatus();
    
    /**
     * @return List of validation adapters
     */
    List<E> getFailedAdapters();
    
    /**
     * @return List of String
     */
    List<String> getFailedMessages();
    
    /**
     * @return ValidarionAdapter
     */
    E getFirstFailedAdapter();
    
    /**
     * @return String
     */
    String getFirstFailedMessage();
    
    /**
     * Register one validation adapter to the validation queue.
     *
     * @param validationAdapter
     * @return Validator
     */
    Validator<?> register(E validationAdapter);
    
    /**
     * Resets validator o it's initial state without validation adapters and
     * failed adapters.
     *
     * @return Validator
     */
    Validator<?> reset();
    
    /**
     * Validate all adapters in the exact order as they were registered into the
     * queue.
     *
     * @return TRUE/FALSE
     */
    boolean validate();
}
