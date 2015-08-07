package vaco.validation.adapters.nin;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Czech NIN - the birth certificate number.<br>
 * Most common format is yymmdd/nnnn where y is the year of the birth, m is the
 * month of the birth, d is the day of the birth.<br>
 * First three of the last four digits is the serial number and the last digit
 * is the checksum for modulo 11.<br>
 * Months are specific. Women have month number with added value of 50 or 70.
 * Men could have simply the month number or the month number with added value
 * od 20.
 *
 * @author lokutus
 */
public class BirthCertificateNumberCz extends NationalIdentificationNumber {
    
    public static final String PATTERN_SIMPLE = "\\s*[0-9]{6}\\s*[/-]?\\s*[0-9]{3}(\\d?)\\s*";
    public static final String PATTERN = "\\s*[0-9]{2}(0[1-9]|10|11|12|2[1-9]|30|31|32|5[1-9]|60|61|62|7[1-9]|80|81|82)(0[1-9]|1[0-9]|2[0-9]|(30|31))\\s*[/-]?\\s*[0-9]{3}(\\d?)\\s*";
    
    /**
     * @param nin
     * @param message
     */
    public BirthCertificateNumberCz(String nin , String message) {
        this.nin = nin;
        ninCountry = NationalIdentificationNumberCountry.CZ;
        this.message = message;
    }
    
    /**
     * @param nin
     */
    public BirthCertificateNumberCz(String nin) {
        this(nin, "");
    }
    
    @Override
    public boolean isValid() {
        if (nin == null || !nin.matches(PATTERN))
            return false;
        
        nin = nin.replaceAll("\\s", "").replaceAll("/", "").replaceAll("-", "");
        
        /* Before 1954 every number is valid because it simply doesn't validate */
        int y = Integer.parseInt(nin.substring(0, 2));
        if (nin.length() < 10)
            return y < 54;
        
        /**
         * Check MODULO11 of the first 9 digits<br>
         * The last number is the checksum of [0-9]
         */
        if (!isValidModulo11(nin))
            return false;
        
        /**
         * Check if date exists<br>
         * Year lesser then 54 is from 21st century, others are from past.<br>
         * Month are extended by 50 for women and since 2003 it can be extended
         * by 20 for men and by 70 for women.
         */
        int m = Integer.parseInt(nin.substring(2, 4));
        int d = Integer.parseInt(nin.substring(4, 6));
        y += y < 54 ? 2000 : 1900;
        m -= m > 70 ? 70 : (m > 50 ? 50 : (m > 20 ? 20 : 0));
        
        return isValidDate(y, m, d);
    }
    
    private boolean isValidModulo11(String nin) {
        int num = Integer.parseInt(nin.substring(0, 9));
        int checksum = Integer.parseInt(nin.substring(9));
        int mod = num % 11;
        mod = mod == 10 ? 0 : mod;
        
        return mod == checksum;
    }
    
    private boolean isValidDate(int year, int month, int day) {
        String formatString = "MMddyyyy";
        String m = "0" + month;
        String d = "0" + day;
        String y = year + "";
        
        m = m.substring(m.length() - 2);
        d = d.substring(d.length() - 2);
        
        String input = m + d + y;
        
        try {
            SimpleDateFormat format = new SimpleDateFormat(formatString);
            format.setLenient(false);
            format.parse(input);
        } catch (ParseException e) {
            return false;
        } catch (IllegalArgumentException e) {
            return false;
        }
        
        return true;
    }
}
