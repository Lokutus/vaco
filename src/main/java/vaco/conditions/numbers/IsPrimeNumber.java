package vaco.conditions.numbers;

import vaco.conditions.AbstractPassableCondition;

/**
 * Check whether the number is a prime number or not.<br>
 * Return {@code TRUE} if the base value is prime number. Otherwise
 * return {@code FALSE}.
 * 
 * @author lokutus
 */
public class IsPrimeNumber extends AbstractPassableCondition<Double> {
    
    /**
     * @param number
     */
    public IsPrimeNumber(long number) {
        value = (double) number;
    }
    
    public IsPrimeNumber() {
    }
    
    @Override
    protected boolean eval() {
        return isPrime(value.longValue());
    }
    
    /**
     * @param n
     * @return {@code TRUE} if the number is prime number, otherwise
     *         {@code FALSE}
     */
    public static boolean isPrime(long n) {
        
        /** check if n is a multiple of 2 */
        if (n % 2 == 0)
            return false;
        
        /** if not, then just check the odds */
        for (long i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        
        return true;
    }
}
