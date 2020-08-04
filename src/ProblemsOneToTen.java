public class ProblemsOneToTen {
    /**
     * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
     * Find the sum of all the multiples of 3 or 5 below 1000.
     *
     * Idea is simple: keep multiplying each number with a variable that increases by 1 each loop.
     * CAUTION: You should add multipliers of the the number (like 3*5, 6*5, 6 * 10) ONLY ONCE.
     */
    public static long problem1(long small, long big, long upperBound) {
        if(small > big) {
            long placeholder = big;
            small = big;
            big = placeholder;
        }

        long s = 1, b = 1;         // s is multiplier of small number, b is multiplier of big number
        long returnedValue = 0;    // This upper bound is also a multiplier of the two digits

        while(s*small < upperBound) {
            returnedValue += s*small;
            s++;
        }

        while(b*big < upperBound) {
            if(b*big % small == 0) {    // This is the CAUTION at the top
                b++;
                continue;
            }

            returnedValue += b*big;
            b++;
        }

        return returnedValue;
    }

    /**
     * Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:
     * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
     * By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms
     *
     * Straightforward: Hold the last two values in some variables x, y(you could use an array). In each loop, calculate
     * the new term and add it if it's even, then move y's value to x, and set y's value to be the new term.
     */
    public static long problem2(long upperBound) {
        long firstNumber = 1;
        long secondNumber = 1;
        long newTerm;
        long returnedValue = 0;

        while (secondNumber < upperBound) {
            newTerm = firstNumber + secondNumber;
            if(newTerm % 2 == 0) returnedValue += newTerm;

            firstNumber = secondNumber;
            secondNumber = newTerm;
        }

        return returnedValue;
    }
}
