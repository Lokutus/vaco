package vaco.validation.adapters.vatin;

/**
 * @author lokutus
 */
public final class VatinAdaptersFactory {
    
    private VatinAdaptersFactory() {
    }
    
    public static AbstractVatinFormat create(String vatin, VatinCountry vatinCountry, String message) {
        AbstractVatinFormat adapter = null;
        
        switch (vatinCountry) {
        case CZ:
            adapter = new VatinFormatCz(vatin, vatinCountry, message);
            break;
        default:
            adapter = new DefaultVatinFormat(vatin, vatinCountry, message);
        }
        
        return adapter;
    }
    
    public static AbstractVatinFormat create(String vatin, VatinCountry vatinCountry) {
        AbstractVatinFormat adapter = null;
        
        switch (vatinCountry) {
        case CZ:
            adapter = new VatinFormatCz(vatin, vatinCountry, "");
            break;
        default:
            adapter = new DefaultVatinFormat(vatin, vatinCountry, "");
        }
        
        return adapter;
    }
    
    public static class DefaultVatinFormat extends AbstractVatinFormat {
        
        public DefaultVatinFormat(String vatin , VatinCountry vatinCountry , String message) {
            super(vatin, vatinCountry, message);
        }
        
        @Override
        protected boolean isValidCustomImplementation(String vatin) {
            return true;
        }
        
    }
}
