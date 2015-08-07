package vaco.validation.adapters.nin;

/**
 * Country Codes to validate National Identification Numbers against.
 * 
 * @author lokutus
 */
public enum NationalIdentificationNumberCountry {
    
    CZ("CZ"),
    SK("SK"),
    UNKNOWN("");
    
    private String value;
    
    public String getValue() {
        return value;
    }
    
    /**
     * @param value
     */
    private NationalIdentificationNumberCountry(String value) {
        this.value = value;
    }
    
    /**
     * @param value
     * @return NationalIdentificationNumberCountry
     */
    public static NationalIdentificationNumberCountry fromValue(String value) {
        for (NationalIdentificationNumberCountry c : NationalIdentificationNumberCountry.values()) {
            if (c.getValue().equalsIgnoreCase(value))
                return c;
        }
        return NationalIdentificationNumberCountry.UNKNOWN;
    }
}
