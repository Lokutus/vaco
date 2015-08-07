package vaco.validation.adapters.iban;

/**
 * Country codes with IBAN national specifications - length and pattern.
 * 
 * @author lokutus
 */
public enum IbanCountry {
    
    AD("AD", 24, "AD[0-9]{2}[0-9]{8}[a-zA-Z0-9]{12}"),
    AE("AE", 23, "AE[0-9]{2}[0-9]{3}[0-9]{16}"),
    AL("AL", 28, "AL[0-9]{2}[0-9]{8}[a-zA-Z0-9]{16}"),
    AT("AT", 24, "AT[0-9]{2}[0-9]{16}"),
    AZ("AZ", 28, "AZ[0-9]{2}[a-zA-Z0-9]{4}[0-9]{20}"),
    BA("BA", 20, "BA39[0-9]{16}"),
    BE("BE", 16, "BE[0-9]{2}[0-9]{12}"),
    BG("BG", 22, "BG[0-9]{2}[A-Z]{4}[0-9]{6}[a-zA-Z0-9]{8}"),
    BH("BH", 22, "BH[0-9]{2}[A-Z]{4}[a-zA-Z0-9]{14}"),
    BR("BR", 29, "BR[0-9]{2}[0-9]{23}[A-Z]{1}[a-zA-Z0-9]{1}"),
    CH("CH", 21, "CH[0-9]{2}[0-9]{5}[a-zA-Z0-9]{12}"),
    CR("CR", 21, "CR[0-9]{2}[0-9]{17}"),
    CY("CY", 28, "CY[0-9]{2}[0-9]{8}[a-zA-Z0-9]{16}"),
    CZ("CZ", 24, "CZ[0-9]{2}[0-9]{20}"),
    DE("DE", 22, "DE[0-9]{2}[0-9]{18}"),
    DK("DK", 18, "DK[0-9]{2}[0-9]{14}"),
    DO("DO", 28, "DO[0-9]{2}[A-Z]{4}[0-9]{20}"),
    EE("EE", 20, "EE[0-9]{2}[0-9]{16}"),
    ES("ES", 24, "ES[0-9]{2}[0-9]{20}"),
    FI("FI", 18, "FI[0-9]{2}[0-9]{14}"),
    FO("FO", 18, "FO[0-9]{2}[0-9]{14}"),
    FR("FR", 27, "FR[0-9]{2}[0-9]{10}[a-zA-Z0-9]{11}[0-9]{2}"),
    GB("GB", 22, "GB[0-9]{2}[A-Z0-9]{4}[0-9]{14}"),
    GE("GE", 22, "GE[0-9]{2}[a-zA-Z0-9]{2}[0-9]{16}"),
    GI("GI", 23, "GI[0-9]{2}[A-Z0-9]{4}[a-zA-Z0-9]{15}"),
    GL("GL", 18, "GL[0-9]{2}[0-9]{14}"),
    GR("GR", 27, "GR[0-9]{2}[0-9]{7}[a-zA-Z0-9]{16}"),
    GT("GT", 28, "GT[0-9]{2}[a-zA-Z0-9]{4}[a-zA-Z0-9]{20}"),
    HR("HR", 21, "HR[0-9]{2}[0-9]{17}"),
    HU("HU", 28, "HU[0-9]{2}[0-9]{24}"),
    IE("IE", 22, "IE[0-9]{2}[a-zA-Z0-9]{4}[0-9]{14}"),
    IL("IL", 23, "IL[0-9]{2}[0-9]{19}"),
    IS("IS", 26, "IS[0-9]{2}[0-9]{22}"),
    IT("IT", 27, "IT[0-9]{2}[A-Z0-9]{1}[0-9]{10}[a-zA-Z0-9]{12}"),
    JO("JO", 30, "JO[0-9]{2}[A-Z]{4}[0-9]{22}"),
    KW("KW", 30, "KW[0-9]{2}[A-Z]{4}[a-zA-Z0-9]{22}"),
    KZ("KZ", 20, "KZ[0-9]{2}[0-9]{3}[a-zA-Z0-9]{13}"),
    LB("LB", 28, "LB[0-9]{2}[0-9]{4}[a-zA-Z0-9]{20}"),
    LI("LI", 21, "LI[0-9]{2}[0-9]{5}[a-zA-Z0-9]{12}"),
    LT("LT", 20, "LT[0-9]{2}[0-9]{16}"),
    LU("LU", 20, "LU[0-9]{2}[0-9]{3}[a-zA-Z0-9]{13}"),
    LV("LV", 21, "LV[0-9]{2}[A-Z]{4}[a-zA-Z0-9]{13}"),
    MC("MC", 27, "MC[0-9]{2}[0-9]{10}[a-zA-Z0-9]{11}[0-9]{2}"),
    MD("MD", 24, "MD[0-9]{2}[a-zA-Z0-9]{2}[a-zA-Z0-9]{18}"),
    ME("ME", 22, "ME25[0-9]{18}"),
    MK("MK", 19, "MK07[0-9]{3}[a-zA-Z0-9]{10}[0-9]{2}"),
    MR("MR", 27, "MR13[0-9]{23}"),
    MT("MT", 31, "MT[0-9]{2}[A-Z]{4}[0-9]{5}[a-zA-Z0-9]{18}"),
    MU("MU", 30, "MU[0-9]{2}[A-Z]{4}[0-9]{19}[A-Z0-9]{3}"),
    NL("NL", 18, "NL[0-9]{2}[A-Z]{4}[0-9]{10}"),
    NO("NO", 15, "NO[0-9]{2}[0-9]{11}"),
    PK("PK", 24, "PK[0-9]{2}[a-zA-Z0-9]{4}[0-9]{16}"),
    PL("PL", 28, "PL[0-9]{2}[0-9]{24}"),
    PS("PS", 29, "PS[0-9]{2}[a-zA-Z0-9]{4}[0-9]{21}"),
    PT("PT", 25, "PT50[0-9]{21}"),
    QA("QA", 29, "QA[0-9]{2}[A-Z]{4}[a-zA-Z0-9]{21}"),
    RO("RO", 24, "RO[0-9]{2}[A-Z]{4}[a-zA-Z0-9]{16}"),
    RS("RS", 22, "RS[0-9]{2}[0-9]{18}"),
    SA("SA", 24, "SA[0-9]{2}[0-9]{2}[a-zA-Z0-9]{18}"),
    SE("SE", 24, "SE[0-9]{2}[0-9]{20}"),
    SI("SI", 19, "SI56[0-9]{15}"),
    SK("SK", 24, "SK[0-9]{2}[0-9]{20}"),
    SM("SM", 27, "SM[0-9]{2}[A-Z]{1}[0-9]{10}[a-zA-Z0-9]{12}"),
    TN("TN", 24, "TN[0-9]{2}[0-9]{20}"),
    TR("TR", 26, "TR[0-9]{2}[0-9]{5}[a-zA-Z0-9]{17}"),
    VG("VG", 24, "VG[0-9]{2}[a-zA-Z0-9]{4}[0-9]{16}"),
    XK("XK", 20, "XK[0-9]{2}[0-9]{4}[0-9]{10}[0-9]{2}"),
    
    /** Default length and pattern for an IBAN with no country code defined */
    UNKNOWN("", 34, "[a-zA-Z]{2}[0-9]{2}[a-zA-Z0-9]{4}[0-9]{7}([a-zA-Z0-9]?){0,16}");
    
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
    private IbanCountry(String value , int length , String pattern) {
        this.value = value;
        this.length = length;
        this.pattern = pattern;
    }
    
    /**
     * @param value
     * @return IbanCountry enum from country code
     */
    public static IbanCountry fromValue(String value) {
        for (IbanCountry c : IbanCountry.values()) {
            if (c.getValue().equalsIgnoreCase(value)) {
                return c;
            }
        }
        return IbanCountry.UNKNOWN;
    }
}
