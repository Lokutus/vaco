package vaco.validation.adapters.vatin;

/**
 * Country codes with VATIN national specifications - length and pattern.
 * 
 * @author lokutus
 */
public enum VatinCountry {
    
    CZ("CZ", 10, "CZ[0-9]{8}"),
    
    /** Default length and pattern for an IBAN with no country code defined */
    UNKNOWN("", 34, "[a-zA-Z]{2}[0-9]+[a-zA-Z0-9]+");
    
    private String value;
    private int length;
    private String pattern;
    
    public String getValue() {
        return value;
    }
    
    public int getLength() {
        return length;
    }
    
    public String getPattern() {
        return pattern;
    }
    
    /**
     * @param value
     * @param length
     * @param pattern
     */
    private VatinCountry(String value , int length , String pattern) {
        this.value = value;
        this.length = length;
        this.pattern = pattern;
    }
    
    /**
     * @param value
     * @return IbanCountry enum from country code
     */
    public static VatinCountry fromValue(String value) {
        for (VatinCountry c : VatinCountry.values()) {
            if (c.getValue().equalsIgnoreCase(value)) {
                return c;
            }
        }
        return VatinCountry.UNKNOWN;
    }
}
