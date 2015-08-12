package vaco.validation.adapters.iban;

import java.math.BigInteger;

import vaco.validation.AbstractValidationAdapter;

/**
 * Validate standard IBAN (International Bank Account Number) against the
 * defined pattern. All IBAN are validated against the national rules (length,
 * country code and pattern) and then perform Modulo97-10.
 * <p>
 *
 * Example:<br>
 * <code>
 * IbanValidator validator = new IbanValidator();
 * if (!validator<br>
 *      .register(new IbanValidationAdapter("GR16 0110 1250 0000 0001 2300 695", IbanCountry.GR, "The IBAN is not valid."))<br>
 *      .validate()) {<br>
 *      // raiseMessageBox... or log error...<br>
 *  }
 * </code>
 *
 * @author lokutus
 */
public class IbanFormat extends AbstractValidationAdapter<IbanFormat> {
    
    private String iban;
    private IbanCountry ibanCountry;
    
    /**
     * @param iban
     * @param ibanCountry
     * @param message
     */
    public IbanFormat(String iban , IbanCountry ibanCountry , String message) {
        if (iban != null && iban.length() > 2) {
            this.iban = iban;
            
            if (ibanCountry == null)
                this.ibanCountry = IbanCountry.fromValue(iban.substring(0, 2));
            else
                this.ibanCountry = ibanCountry;
        }
        
        setMessage(message);
    }
    
    /**
     * @param iban
     * @param ibanCountry
     */
    public IbanFormat(String iban , IbanCountry ibanCountry) {
        this(iban, ibanCountry, "");
    }
    
    /**
     * @param iban
     * @param messageCode
     */
    public IbanFormat(String iban , String message) {
        this(iban, null, message);
    }
    
    /**
     * @param iban
     */
    public IbanFormat(String iban) {
        this(iban, "");
    }
    
    @Override
    public boolean isValid() {
        if (iban == null || iban.length() < 2)
            return false;
        
        /** IBAN can be formatted with spaces */
        iban = iban.replaceAll("\\s", "");
        
        return (iban.length() == ibanCountry.getLength() || ibanCountry == IbanCountry.UNKNOWN)
                && (ibanCountry.getValue().equals(iban.substring(0, 2)) || ibanCountry == IbanCountry.UNKNOWN)
                && iban.matches(ibanCountry.getPattern())
                && isValidModulo97(convertIbanToNumeric(iban));
    }
    
    private boolean isValidModulo97(String convertedIban) {
        BigInteger i = new BigInteger(convertedIban);
        BigInteger mod = new BigInteger("97");
        BigInteger result = i.remainder(mod);
        
        return BigInteger.ONE.equals(result);
    }
    
    private String convertIbanToNumeric(String iban) {
        String tmpIban = (iban.substring(4) + iban.substring(0, 4)).toUpperCase();
        
        StringBuilder convertedIban = new StringBuilder();
        for (int i = 0; i < tmpIban.length(); i++) {
            char x = tmpIban.charAt(i);
            String tmp = x + "";
            if (!tmp.matches("[0-9]{1}")) {
                int ascii = x;
                convertedIban.append((ascii - 55) + "");
            } else {
                convertedIban.append(tmp);
            }
            
        }
        
        return convertedIban.toString();
    }
}
