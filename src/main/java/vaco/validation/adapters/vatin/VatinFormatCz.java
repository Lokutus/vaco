package vaco.validation.adapters.vatin;

/**
 * The CZECH implementation of VATIN number validation.
 * <ul>
 * <li>Format is CZ\d{8}.
 * <li>The eighth digit is the checksum.
 * <li>Every one of the first seven digits is multiplied with the special digit
 * by it's order. N1*8, N2*7, N3*6...etc. and results are summed up.
 * <li>The sum result is modulo divided by 11.
 * <li>If the checksum is 0, modulo should be 1.
 * <li>If the checksum is 1, modulo should be 0.
 * <li>Otherwise, checksum should be equal to 11-modulo
 * </ul>
 * 
 * @see <a href="http://phpfashion.com/jak-overit-platne-ic-a-rodne-cislo">
 *      http://phpfashion.com/jak-overit-platne-ic-a-rodne-cislo</a>
 * 
 * @author lokutus
 */
public class VatinFormatCz extends AbstractVatinFormat {
    
    /**
     * In the CZ implementation there could be regular VATIN number with CZ
     * prefix or there could be only the numeric part (IČ).
     * 
     * @param vatin
     * @param vatinCountry
     * @param message
     */
    public VatinFormatCz(String vatin , VatinCountry vatinCountry , String message) {
        super(vatin, vatinCountry, message);
        
        if (!this.vatin.substring(0, 2).matches("[A-Z]{2}"))
            this.vatin = VatinCountry.CZ.getValue() + this.vatin;
    }
    
    /**
     * @param vatin
     * @param vatinCountry
     */
    public VatinFormatCz(String vatin , VatinCountry vatinCountry) {
        this(vatin, vatinCountry, "");
    }
    
    /**
     * @param vatin
     * @param message
     */
    public VatinFormatCz(String vatin , String message) {
        this(vatin, null, message);
    }
    
    /**
     * @param vatin
     */
    public VatinFormatCz(String vatin) {
        this(vatin, "");
    }
    
    @Override
    protected boolean isValidCustomImplementation(String vatin) {
        int i1 = Integer.parseInt(vatin.substring(2, 3));
        int i2 = Integer.parseInt(vatin.substring(3, 4));
        int i3 = Integer.parseInt(vatin.substring(4, 5));
        int i4 = Integer.parseInt(vatin.substring(5, 6));
        int i5 = Integer.parseInt(vatin.substring(6, 7));
        int i6 = Integer.parseInt(vatin.substring(7, 8));
        int i7 = Integer.parseInt(vatin.substring(8, 9));
        int checksum = Integer.parseInt(vatin.substring(9, 10));
        
        int total = (i1 * 8) + (i2 * 7) + (i3 * 6) + (i4 * 5) + (i5 * 4) + (i6 * 3) + (i7 * 2);
        int modulo = total % 11;
        
        return (checksum == 1 && modulo == 0) || (checksum == 0 && modulo == 1) || (checksum == 11 - modulo);
    }
}
