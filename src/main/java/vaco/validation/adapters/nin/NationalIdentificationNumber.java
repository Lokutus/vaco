package vaco.validation.adapters.nin;

import vaco.validation.AbstractValidationAdapter;

/**
 * Base class for validating national identification number.<br>
 * Use factory methods create to get the proper validation adapter based on the
 * country code.
 *
 * @author lokutus
 */
public class NationalIdentificationNumber extends AbstractValidationAdapter<NationalIdentificationNumber> {
    
    /** NationalIdentificationNumber to be validated */
    protected String nin;
    
    /** Country Code to be validated against */
    protected NationalIdentificationNumberCountry ninCountry;
    
    @Override
    public boolean isValid() {
        return true;
    }
    
    /**
     * Factory method to instantiate a specific NationalIdentificationNumber
     * using a Country Code.
     * 
     * @param nin
     * @param ninCountry
     * @return NationalIdentificationNumber instance
     */
    public static NationalIdentificationNumber create(String nin, NationalIdentificationNumberCountry ninCountry) {
        switch (ninCountry) {
        case CZ:
            return new BirthCertificateNumberCz(nin);
        case SK:
            return new BirthCertificateNumberSk(nin);
        default:
            return new NationalIdentificationNumber();
        }
    }
    
    /**
     * Factory method to instantiate a specific NationalIdentificationNumber
     * using a Country Code.
     * 
     * @param nin
     * @param ninCountry
     * @param message
     * @return NationalIdentificationNumber instance
     */
    public static NationalIdentificationNumber create(String nin, NationalIdentificationNumberCountry ninCountry,
            String message) {
        switch (ninCountry) {
        case CZ:
            return new BirthCertificateNumberCz(nin, message);
        case SK:
            return new BirthCertificateNumberSk(nin, message);
        default:
            return new NationalIdentificationNumber();
        }
    }
}
