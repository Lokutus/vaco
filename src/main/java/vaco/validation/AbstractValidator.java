package vaco.validation;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Abstract validator to implement basic validation logic.<br>
 * Validation adapters are added to the queue using method
 * register(validationAdapter) and then they are being validated in the same
 * order using method validate().
 * 
 * @author lokutus
 *
 * @param <T>
 * @param <E>
 */
public abstract class AbstractValidator<T extends AbstractValidator<T, E>, E extends ValidationAdapter> implements
        Validator<E> {
    
    /** Queue of validation adapters to be validated */
    protected List<E> adapters = new LinkedList<E>();
    
    /** Queue of validation adapters that have failed to validate */
    protected List<E> failedAdapters = new LinkedList<E>();
    
    /** Validation status of the adapters queue - VALID, NOT VALID, UNKNOWN */
    protected ValidationStatus status = ValidationStatus.UNKNOWN;
    
    /**
     * Reuturn validation status of the current validator. Default value is
     * {@code UNKNOWN}.
     * 
     * @return status of the current validator
     */
    
    @Override
    public ValidationStatus getStatus() {
        return status;
    }
    
    /**
     * In case of one or more failing adapters return all failed adapters.
     * 
     * @return error all failed validation adapters
     */
    @Override
    public List<E> getFailedAdapters() {
        return failedAdapters;
    }
    
    /**
     * In case of one or more failing adapters return all error messages from
     * all failed adapters.
     * 
     * @return error messages from all failed validation adapters
     */
    @Override
    public List<String> getFailedMessages() {
        List<String> messages = new LinkedList<String>();
        for (Iterator<E> iterator = failedAdapters.iterator(); iterator.hasNext();) {
            messages.add(iterator.next().getMessage());
        }
        
        return messages;
    }
    
    @Override
    public E getFirstFailedAdapter() {
        return failedAdapters.get(0);
    }
    
    /**
     * In case of one or more failing adapters return the error message from the
     * first failed adapter.
     * 
     * @return error message from the first failed validation adapter
     */
    @Override
    public String getFirstFailedMessage() {
        if (getFirstFailedAdapter() != null)
            return getFirstFailedAdapter().getMessage();
        
        return "";
    }
    
    /**
     * Register one validation adapter to the queue.
     * 
     * @return current validator to aneble method chaining
     */
    @Override
    @SuppressWarnings("unchecked")
    public T register(E validationAdapter) {
        adapters.add(validationAdapter);
        return (T) this;
    }
    
    /**
     * Reset all queues, delete all validation adapters and set the default
     * validation state to UNKNOWN.
     * 
     * @return current validator to enable method chaining
     */
    @Override
    @SuppressWarnings("unchecked")
    public T reset() {
        adapters = new LinkedList<E>();
        failedAdapters = new LinkedList<E>();
        status = ValidationStatus.UNKNOWN;
        return (T) this;
    }
    
    /**
     * Validates all registered adapters in the exact order in what they were
     * registered. Failed adapters are being put to the failed validation
     * adapters queue in the same order.
     *
     * @return {@code TRUE} if all validation adapters returns {@code TRUE}.<br>
     *         Otherwise {@code FALSE}
     */
    @Override
    public boolean validate() {
        status = ValidationStatus.UNKNOWN;
        this.failedAdapters = new LinkedList<E>();
        
        for (E adapter : adapters) {
            if (adapter != null && !adapter.validate())
                failedAdapters.add(adapter);
        }
        
        if (this.getFailedAdapters().size() > 0) {
            status = ValidationStatus.NOT_VALID;
            return false;
        }
        
        status = ValidationStatus.VALID;
        return true;
    }
}
